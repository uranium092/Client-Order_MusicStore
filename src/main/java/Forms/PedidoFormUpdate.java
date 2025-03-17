package Forms;

import javax.validation.constraints.*;

public class PedidoFormUpdate {
	
	@NotBlank(message="Especificar artículo válido")
	@Size(min=3, message="Debe contener mínimo 3 letras")
	@Size(max=35, message="Debe contener máximo 40 letras")
	private String nombreArticulo;
	
	@Min(value=1, message="Indique un precio")
	@NotNull(message="Indique un precio")
	private double precio;
	
	private String idPedido;

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	
	
}