package model;

import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Pedido implements Activatable, Cloneable {

	private String id;
	private double precio;
	private String fecha;
	private String hora;
	private String pago;
	private String estado;
	private Usuario usuario;
	private Taxi taxi;
	private transient Activator _activator;

	public Pedido() {
		this.id = UUID.randomUUID().toString();
	}

	public Pedido(String id, double precio, String fecha, String hora, String pago, String estado, Usuario usuario,
			Taxi taxi) {
		super();
		this.id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado = estado;
		this.usuario = usuario;
		this.taxi = taxi;
	}

	public Pedido(double precio, String fecha, String hora, String pago, Usuario usuario, Taxi taxi) {
		super();
		this.id = UUID.randomUUID().toString();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado = "PENDIENTE";
		this.usuario = usuario;
		this.taxi = taxi;
	}

	public double getPrecio() {
		activate(ActivationPurpose.READ);
		return precio;
	}

	public void setPrecio(double precio) {
		activate(ActivationPurpose.READ);
		this.precio = precio;
	}

	public String getFecha() {
		activate(ActivationPurpose.READ);
		return fecha;
	}

	public void setFecha(String fecha) {
		activate(ActivationPurpose.WRITE);
		this.fecha = fecha;
	}

	public String getHora() {
		activate(ActivationPurpose.READ);
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPago() {
		activate(ActivationPurpose.READ);
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public Usuario getUsuario() {
		activate(ActivationPurpose.READ);
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Taxi getTaxi() {
		activate(ActivationPurpose.READ);
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public String getEstado() {
		activate(ActivationPurpose.READ);
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String[] toArray() {
		String[] cadena = { this.getUsuario().getNombre() + " " + this.getUsuario().getApellido(), this.getFecha(),
				getEstado().toString() };
		return cadena;
	}

	public Object getObjectId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		activate(ActivationPurpose.READ);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pedido) {
			Pedido tmpPedido = (Pedido) obj;
			if (this.getId().equals(tmpPedido.getId())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public void activate(ActivationPurpose purpose) {
		if (_activator != null) {
			_activator.activate(purpose);
		}
	}

	@Override
	public void bind(Activator activator) {
		if (_activator == activator) {
			return;
		}
		if (activator != null && _activator != null) {
			throw new IllegalStateException();
		}
		_activator = activator;
	}

	public void asignarTaxi(Taxi taxi) {
		activate(ActivationPurpose.WRITE);
		this.setTaxi(taxi);
	}	

}
