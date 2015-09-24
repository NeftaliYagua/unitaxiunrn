package api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import dao.DatabaseManager;
import dao.PedidoDAOImpl;
import dao.TaxiDAOImpl;
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

	private static final String DATABASE_FILE = "database.db4o";

	ObjectContainer db;

	public Servicio() {
		new File(DATABASE_FILE).delete();
		// cfg = Db4oEmbedded.newConfiguration();
		// container = Db4oEmbedded.openFile(cfg,DATABASE_FILE);

		db = Db4oEmbedded.openFile(DATABASE_FILE);

		// open the db4o-session. For example at the beginning for a web-request

	}

	public Servicio(DatabaseManager db4o) {
		this.db4o = db4o;

	}

	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Usuario usuario = crearModeloUsuario(usuarioDTO);
		new UsuarioDAOImpl(session).guardarUsuario(usuario);

		session.commit();
		session.close();
		return new UsuarioDTO(usuario);
	}

	public PedidoDTO crearPedido(PedidoDTO pedidoDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Pedido pedido = crearModeloPedido(pedidoDTO);
		new PedidoDAOImpl(session).guardarPedido(pedido);

		session.commit();
		session.close();
		return new PedidoDTO(pedido);
	}

	public TaxiDTO crearTaxi(TaxiDTO taxiDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Taxi taxi = crearModeloTaxi(taxiDTO);
		new TaxiDAOImpl(session).guardarTaxi(taxi);

		session.commit();
		session.close();
		return new TaxiDTO(taxi);
	}

	public UsuarioDTO obtenerUsuario(UsuarioDTO usuarioDTO) {
		ObjectContainer session = db.ext().openSession();

		Usuario usuario = new UsuarioDAOImpl(session).getById(usuarioDTO.getId());
		usuarioDTO = new UsuarioDTO(usuario);

		session.close();
		return usuarioDTO;
	}

	public PedidoDTO obtenerPedido(PedidoDTO pedidoDTO) {
		ObjectContainer session = db.ext().openSession();

		Pedido pedido = new PedidoDAOImpl(session).getById(pedidoDTO.getId());
		pedidoDTO = new PedidoDTO(pedido);

		session.close();
		return pedidoDTO;
	}

	/**
	 * Metodo que recibe los parametros necesarios para asignar un taxi a un
	 * pedido previamente realizado.
	 */
	/*
	 * public void asignarUnTaxi(Pedido pedido, Taxi taxi) {
	 * 
	 * // obtengo el pedido de la bd // PedidoDAO pedidoDao= new
	 * PedidoDAO(session); // pedidoDAO.get(pedido);
	 * 
	 * pedido.setTaxi(taxi);
	 * 
	 * // pedidoDAO.store(pedido)
	 * 
	 * }
	 */
	public List<TaxiDTO> listarTaxis() {
		ObjectContainer session = db.ext().openSession();

		List<Taxi> taxis = new TaxiDAOImpl(session).listarTaxis();

		List<TaxiDTO> taxiDTOs = new ArrayList<TaxiDTO>();
		for (Taxi taxi : taxis) {
			taxiDTOs.add(new TaxiDTO(taxi));
		}

		session.close();
		return taxiDTOs;
	}

	public List<TaxiDTO> listarTaxisLibres() {
		ObjectContainer session = db.ext().openSession();

		List<Taxi> taxis = new TaxiDAOImpl(session).listarTaxisLibres();
		List<TaxiDTO> taxiDTOs = new ArrayList<TaxiDTO>();
		for (Taxi taxi : taxis) {
			taxiDTOs.add(new TaxiDTO(taxi));
		}
		session.close();
		return taxiDTOs;
	}

	public List<Pedido> listarPedidos() {
		ObjectContainer session = db.ext().openSession();

		List<Pedido> pedidos = new PedidoDAOImpl(session).listarPedidos();

		session.close();
		return pedidos;
	}

	public List<Pedido> listarPedidosPendientes() {
		ObjectContainer session = db.ext().openSession();

		List<Pedido> pedidos = new PedidoDAOImpl(session).listarPedidosPendientes();

		session.close();
		return pedidos;
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
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();
		ObjectSet<Taxi> result = session.query(Taxi.class);
		// will use the equals-method of TestClass.
		Set<Taxi> distinctResult = new HashSet<Taxi>(result);

		return distinctResult;
	}

	/* De Dtos a Modelos */
	private Usuario crearModeloUsuario(UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null)
			return new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDni(),
					usuarioDTO.getMail(), usuarioDTO.getTelefono());
		else
			return new Usuario(usuarioDTO.getId(), usuarioDTO.getNombre(), usuarioDTO.getApellido(),
					usuarioDTO.getDni(), usuarioDTO.getMail(), usuarioDTO.getTelefono());
	}

	private Pedido crearModeloPedido(PedidoDTO pedidoDTO) {
		if (pedidoDTO.getId() == null)
			return new Pedido(pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(), pedidoDTO.getPago(),
					crearModeloUsuario(pedidoDTO.getUsuario()), crearModeloTaxi(pedidoDTO.getTaxi()));
		else
			return new Pedido(pedidoDTO.getId(), pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(),
					pedidoDTO.getPago(), pedidoDTO.getEstado(), crearModeloUsuario(pedidoDTO.getUsuario()),
					crearModeloTaxi(pedidoDTO.getTaxi()));
	}

	private Taxi crearModeloTaxi(TaxiDTO taxiDTO) {
		if (taxiDTO.getId() == null)
			return new Taxi(taxiDTO.getPatente(), taxiDTO.getChofer(), taxiDTO.getLicencia(), taxiDTO.getEmpresa(),
					taxiDTO.getLibre());
		else
			return new Taxi(taxiDTO.getId(), taxiDTO.getPatente(), taxiDTO.getChofer(), taxiDTO.getLicencia(),
					taxiDTO.getEmpresa(), taxiDTO.getLibre());
	}
}
