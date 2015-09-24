package api;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;

import dao.DatabaseManager;
import dao.PedidoDAOImpl;
import dao.TaxiDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import dto.PedidoDTO;
import dto.TaxiDTO;
import dto.UsuarioDTO;
import model.Pedido;
import model.Taxi;
import model.Usuario;

/**
 * Clase que recibe los datos, desde la Vista, para crear los objetos del Modelo
 * y luego delega a los Daos la persistencia de estos.
 * 
 * @author Lucas?
 */
public class Servicio {
	
	private DatabaseManager db4o;
	private UsuarioDAO usuarioDAO;
	
	private static final String DATABASE_FILE = "database.db4o";
	
	ObjectContainer db;
	
	public Servicio() {
		new File(DATABASE_FILE).delete();
//		cfg = Db4oEmbedded.newConfiguration();
//        container = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
        
        db = Db4oEmbedded.openFile(DATABASE_FILE);

        // open the db4o-session. For example at the beginning for a web-request
        

	}
	
	public Servicio(DatabaseManager db4o) {
		this.db4o = db4o;

	}
	
	public void crearUsuario(UsuarioDTO usuarioDTO) { 
//		ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();
		Usuario usuario = crearModeloUsuario(usuarioDTO);
		new UsuarioDAOImpl(session).guardarUsuario(usuario);
		session.commit();
		session.close();
	}

	public void crearPedido(PedidoDTO pedidoDTO) {
//		ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();
		
		Pedido pedido = new Pedido(pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(), pedidoDTO.getPago(), crearModeloUsuario(pedidoDTO.getUsuario()), crearModeloTaxi(pedidoDTO.getTaxi()) );
		new PedidoDAOImpl(session).guardarPedido(pedido);
		session.commit();
		session.close();
	}
	
	public void crearTaxi(TaxiDTO taxiDTO) { 
//		ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();
		Taxi taxi = new Taxi(taxiDTO.getPatente(), taxiDTO.getChofer(), taxiDTO.getLicencia(), taxiDTO.getEmpresa(), taxiDTO.getLibre());
		new TaxiDAOImpl(session).guardarTaxi(taxi);
		session.commit();
		session.close();
	}


	/**
	 * Metodo que recibe los parametros necesarios para realizar el pedido de un
	 * taxi.
	 */
	public void pedirUnTaxi(PedidoDTO pedidoDTO, UsuarioDTO usuarioDTO) {
		// abro session/transaccion (si hace falta)
		ObjectContainer session = this.db4o.open();

		// traigo instancias de la BD y delego en los objetos del modelo
		// logica en el modelo, no en los daos o en este Servicio

		// Pedido pedido = new Pedido(precio, fecha, hora, pago, usuario);
		// new PedidoDao(session).guardar(pedido);

		// db4o.listResult(result);
		// commit y close
		// session.commit();
		session.close();
	}

	/**
	 * Metodo que recibe los parametros necesarios para asignar un taxi a un
	 * pedido previamente realizado.
	 */
	public void asignarUnTaxi(Pedido pedido, Taxi taxi) {

		// obtengo el pedido de la bd
		// PedidoDAO pedidoDao= new PedidoDAO(session);
		// pedidoDAO.get(pedido);

		pedido.setTaxi(taxi);

		// pedidoDAO.store(pedido)

	}

	public List<Taxi> listarTaxis() {
		return null;
	}

	public List<Taxi> listarTaxisLibres() {
		return null;

	}

	public List<Pedido> listarPedidos() {
		return null;
	}

	public List<Pedido> listarPedidosPendientes() {
		return null;
	}

	/**
	 * Metodo encargado de listar el top 1 de choferes. Es decir, el chofer que
	 * mas viajes ha realizo.
	 */
	public String listarChoferConMasViajesRealizados(String nombre) {
		// abro session/transaccion (si hace falta)
		// ObjectContainer session = this.db4o.startSession();
		//
		// return new UnDao(session).listarChoferes(nombre);

		// commit y close
		// session.commit();
		// session.close();

		
		
		return null;
	}
	
	public Set distinctNative() {
//		ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();
		ObjectSet<Taxi> result = session.query(Taxi.class);
		// will use the equals-method of TestClass.
		Set<Taxi> distinctResult = new HashSet<Taxi>(result);
		
		return distinctResult;
	}

	private Usuario crearModeloUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDni(), usuarioDTO.getMail(),
				usuarioDTO.getTelefono());
	}
	
	private Taxi crearModeloTaxi(TaxiDTO taxiDTO) {
		return new Taxi(taxiDTO.getPatente(),taxiDTO.getChofer(),taxiDTO.getLicencia(),taxiDTO.getEmpresa(), taxiDTO.getLibre());
	}
}
