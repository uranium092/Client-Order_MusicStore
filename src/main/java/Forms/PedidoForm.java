package Forms;

import javax.validation.constraints.*;

public class PedidoForm {
	
	@NotBlank(message="Especificar artículo válido")
	@Size(min=3, message="Debe contener mínimo 3 letras")
	@Size(max=35, message="Debe contener máximo 40 letras")
	private String articulo;
	
	@Min(value=1, message="Indique un precio")
	@NotNull(message="Indique un precio")
	private double precio;
	
	private String idCliente;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}