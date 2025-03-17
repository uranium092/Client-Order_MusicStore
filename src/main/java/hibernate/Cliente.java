package hibernate;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name="nombre")
	private String nombreCliente;
	
	@Column(name="apellido")
	private String apellidoCliente;
	
	@Column(name="banda")
	private String bandaCliente;
	
	@OneToMany(mappedBy="clientePedido", cascade=CascadeType.ALL)
	private List<Pedido> pedido;
	
	public void addOrder(Pedido p){
		p.setClientePedido(this);
		pedido.add(p);
	}
	
	public Cliente() { }

	public Cliente(String nombreCliente, String apellidoCliente, String bandaCliente) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.bandaCliente = bandaCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getBandaCliente() {
		return bandaCliente;
	}

	public void setBandaCliente(String bandaCliente) {
		this.bandaCliente = bandaCliente;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	public int getId() {
		return idCliente;
	}
	
	
} 