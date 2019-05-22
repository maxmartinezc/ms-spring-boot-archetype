package ${package}.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@ApiModelProperty(notes = "Fecha y hora de creación", example="2019-05-01 17:30:00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creationDate;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExampleDtoResponse [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}
}