package api;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

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
 * Clase que recibe los datos desde la Vista para crear los objetos del Modelo y
 * luego delega a los Daos la persistencia de estos.
 * 
 * @author Lucas
 */
public class Servicio {

	private DatabaseManager db4o;

	private static final String DATABASE_FILE = "database.db4o";

	ObjectContainer db;

	public Servicio() {
		new File(DATABASE_FILE).delete();
		// cfg = Db4oEmbedded.newConfiguration();
		// container = Db4oEmbedded.openFile(cfg,DATABASE_FILE);

		// db = Db4oEmbedded.openFile(DATABASE_FILE);

		/* Testeandooooooo */
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentPersistenceSupport());
		db = Db4oEmbedded.openFile(config, DATABASE_FILE);

		// open the db4o-session. For example at the beginning for a web-request

	}

	public Servicio(DatabaseManager db4o) {
		this.db4o = db4o;

	}

	/* ---------------- Metodos de creación ---------------- */

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

		// Recupero el usuario de la bd
		if (pedido.getUsuario().getId() != null)
			pedido.setUsuario(new UsuarioDAOImpl(session).getById(pedido.getUsuario().getId()));

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

	/* ---------------- Metodos de actualización ---------------- */

	public PedidoDTO actualizarPedido(PedidoDTO pedidoDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Pedido pedido = crearModeloPedido(pedidoDTO);

		Pedido p = new PedidoDAOImpl(session).getById(pedido.getId());

		// Actualizo los campos
		p.setEstado(pedido.getEstado());
		p.setFecha(pedido.getFecha());
		p.setHora(pedido.getHora());
		p.setPago(pedido.getPago());
		p.setPrecio(pedido.getPrecio());

		// Ya no hace falta con la persistencia transaparente
		// new PedidoDAOImpl(session).guardarPedido(p);

		session.commit();
		session.close();
		return new PedidoDTO(p);
	}

	public TaxiDTO actualizarTaxi(TaxiDTO taxiDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Taxi taxi = crearModeloTaxi(taxiDTO);

		Taxi t = new TaxiDAOImpl(session).getById(taxi.getId());

		// Actualizo los campos
		t.setChofer(taxi.getChofer());
		t.setEmpresa(taxi.getEmpresa());
		t.setLibre(taxi.getLibre());
		t.setLicencia(taxi.getLicencia());
		t.setNotificacion(taxi.getNotificacion());
		t.setPatente(taxi.getPatente());

		// Ya no hace falta con la persistencia transaparente
		// new TaxiDAOImpl(session).guardarTaxi(t);

		session.commit();
		session.close();
		return new TaxiDTO(t);
	}

	public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
		// ObjectContainer session = Db4oEmbedded.openFile(cfg,DATABASE_FILE);
		ObjectContainer session = db.ext().openSession();

		Usuario usuario = crearModeloUsuario(usuarioDTO);

		Usuario u = new UsuarioDAOImpl(session).getById(usuario.getId());

		// Actualizo los campos
		u.setApellido(usuario.getApellido());
		u.setDni(usuario.getDni());
		u.setMail(usuario.getMail());
		u.setNombre(usuario.getNombre());
		u.setTelefono(usuario.getTelefono());

		// Ya no hace falta con la persistencia transaparente
		// new TaxiDAOImpl(session).guardarTaxi(t);

		session.commit();
		session.close();
		return new UsuarioDTO(u);
	}

	/* ---------------- Metodos de obtención ---------------- */

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

	public TaxiDTO obtenerTaxi(TaxiDTO taxiDTO) {
		ObjectContainer session = db.ext().openSession();

		Taxi taxi = new TaxiDAOImpl(session).getById(taxiDTO.getId());
		taxiDTO = new TaxiDTO(taxi);

		session.close();
		return taxiDTO;
	}

	/**
	 * Metodo que recibe los parametros necesarios para asignar un taxi a un
	 * pedido previamente realizado.
	 */

	public PedidoDTO asignarUnTaxi(PedidoDTO pedidoDTO, TaxiDTO taxiDTO) {
		ObjectContainer session = db.ext().openSession();

		// obtengo el pedido de la bd
		Pedido pedido = new PedidoDAOImpl(session).getById(pedidoDTO.getId());
		Taxi taxi = new TaxiDAOImpl(session).getById(taxiDTO.getId());
		pedido.setTaxi(taxi);

		new PedidoDAOImpl(session).guardarPedido(pedido);

		session.commit();
		session.close();
		return new PedidoDTO(pedido);
	}

	/* ---------------- Metodos de listados ---------------- */

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

	public List<PedidoDTO> listarPedidos() {
		ObjectContainer session = db.ext().openSession();

		List<Pedido> pedidos = new PedidoDAOImpl(session).listarPedidos();
		List<PedidoDTO> pedidoDTOs = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			pedidoDTOs.add(new PedidoDTO(pedido));
		}

		session.close();
		return pedidoDTOs;
	}

	public List<PedidoDTO> listarPedidosPendientes() {
		ObjectContainer session = db.ext().openSession();

		List<Pedido> pedidos = new PedidoDAOImpl(session).listarPedidosPendientes();
		List<PedidoDTO> pedidoDTOs = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			pedidoDTOs.add(new PedidoDTO(pedido));
		}

		session.close();
		return pedidoDTOs;
	}

	/**
	 * Metodo encargado de listar el top 1 de choferes. Es decir, el chofer que
	 * mas viajes ha realizo.
	 */
	public String listarChoferConMasViajesRealizados() {
		// ObjectContainer session = this.db4o.startSession();
		ObjectContainer session = db.ext().openSession();

		// Obtengo los taxis ya que cada chofer se corresponde con un unico taxi
		List<Taxi> taxis = new TaxiDAOImpl(session).listarTaxis();

		int max = 0;
		Taxi taxi_max = new Taxi();

		// suponiendo que los taxis no se repiten

		for (Taxi taxi : taxis) {
			int cant = new PedidoDAOImpl(session).cantPedidosPorTaxi(taxi);
			if (cant > max) {
				max = cant;
				taxi_max = taxi;
			}
		}

		session.close();
		return taxi_max.getChofer();
	}

	public void contarChoferes() {

		List<String> choferes = new LinkedList<String>();
		ObjectContainer session = db.ext().openSession();

		// List<Pedido> result = session.query(new Predicate<Pedido>() {
		// public boolean match(Pedido pedido) {
		// return true;
		// }
		// });
		// ListIterator<Pedido> it = result.listIterator();

		// agrego todos los pedidos a una lista
		ListIterator<Pedido> it = new PedidoDAOImpl(session).listarPedidos().listIterator();

		// recorro la lista recuperando los choferes y los agrego a una nueva
		// lista
		while (it.hasNext())
			try {
				choferes.add(it.next().getTaxi().getChofer());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		// cuento el numero de coincidencias en dicha lista
		Map<String, Long> counted = choferes.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));

		System.out.println(counted);

		session.close();
	}

	/*
	 * ---------------- Metodos que convierten de Dtos a Modelos
	 * ----------------
	 */

	private Usuario crearModeloUsuario(UsuarioDTO usuarioDTO) {
		if (usuarioDTO.getId() == null)
			return new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDni(),
					usuarioDTO.getMail(), usuarioDTO.getTelefono());
		else
			return new Usuario(usuarioDTO.getId(), usuarioDTO.getNombre(), usuarioDTO.getApellido(),
					usuarioDTO.getDni(), usuarioDTO.getMail(), usuarioDTO.getTelefono());
	}

	private Pedido crearModeloPedido(PedidoDTO pedidoDTO) {
		if (pedidoDTO.getId() == null)
			return new Pedido(pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(), pedidoDTO.getPago(),
					(pedidoDTO.getUsuario() == null) ? null : crearModeloUsuario(pedidoDTO.getUsuario()),
					(pedidoDTO.getTaxi() == null) ? null : crearModeloTaxi(pedidoDTO.getTaxi()));
		else
			return new Pedido(pedidoDTO.getId(), pedidoDTO.getPrecio(), pedidoDTO.getFecha(), pedidoDTO.getHora(),
					pedidoDTO.getPago(), pedidoDTO.getEstado(),
					(pedidoDTO.getUsuario() == null) ? null : crearModeloUsuario(pedidoDTO.getUsuario()),
					(pedidoDTO.getTaxi() == null) ? null : crearModeloTaxi(pedidoDTO.getTaxi()));
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
