package Forms;

import javax.validation.constraints.*;

public class ClienteFormUpdate {

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="Especificar nombre válido")
	@Size(min=3, message="Debe contener mínimo 3 letras")
	@Size(max=35, message="Debe contener máximo 35 letras")
	private String name;
	
	@NotBlank(message="Especificar apellido válido")
	@Size(min=3, message="Debe contener mínimo 3 letras")
	@Size(max=35, message="Debe contener máximo 35 letras")
	private String lastName;
	
	@NotBlank(message="Especificar banda válida")
	@Size(min=3, message="Debe contener mínimo 3 letras")
	@Size(max=35, message="Debe contener máximo 35 letras")
	private String band;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	
	
}