package ${package}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object para "example"
 *
 */
@ApiModel(value = "Informacion de un example", description = "Datos del example")
public class ExampleDtoResponse
{
	@ApiModelProperty(notes = "Identificador", example="1")
	private int id;
	
	@ApiModelProperty(notes = "Descripción", example="Loren ipsum")
	private String description;

	/**
	 * Constructor de ExampleDtoResponse sin argumentos
	 */
	public ExampleDtoResponse () {
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExampleDtoResponse [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
