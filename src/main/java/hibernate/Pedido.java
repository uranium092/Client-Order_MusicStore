package hibernate;

import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="cliente")
	private Cliente clientePedido;
	
	@Column(name="articulo")
	private String articuloCliente;
	
	@Column(name="precio_articulo")
	private double precioArticulo;
	
	public Pedido() { }

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}

	public String getArticuloCliente() {
		return articuloCliente;
	}

	public void setArticuloCliente(String articuloCliente) {
		this.articuloCliente = articuloCliente;
	}

	public double getPrecioArticulo() {
		return precioArticulo;
	}

	public void setPrecioArticulo(double precioArticulo) {
		this.precioArticulo = precioArticulo;
	}

	public Pedido(String articuloCliente, double precioArticulo) {
		super();
		this.articuloCliente = articuloCliente;
		this.precioArticulo = precioArticulo;
	}

	
}