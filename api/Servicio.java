package api;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;

import dao.DatabaseManager;
import dao.PedidoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import dto.PedidoDTO;
import dto.UsuarioDTO;
import model.Pedido;
import model.Taxi;
import model.Usuario;

/**
 * Clase que recibe los datos, desde la Vista, para crear los objetos del Modelo
 * y luego delega a los Daos la persistencia de estos.
 * 
 * @author Lucas
 */
public class Servicio {
	private DatabaseManager db4o;
	private UsuarioDAO usuarioDAO;

	public Servicio() {
	}
	
	public Servicio(DatabaseManager db4o) {
		this.db4o = db4o;

	}
	
	public void crearUsuario(UsuarioDTO usuarioDTO) { 
		ObjectContainer session = this.db4o.open();
		Usuario usuario = crearModeloUsuario(usuarioDTO);
		new UsuarioDAOImpl(session).guardarUsuario(usuario);
		session.commit();
		session.close();
	}

	public void crearPedido(PedidoDTO pedidoDTO) {
		ObjectContainer session = this.db4o.open();

		Pedido pedido = new Pedido(pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(), null,
				new Usuario());

		new PedidoDAOImpl(session).guardarPedido(pedido);

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

	private Usuario crearModeloUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDni(), usuarioDTO.getMail(),
				usuarioDTO.getTelefono());
	}
}
