package ${package}.dto;

import javax.validation.constraints.NotEmpty;

import ${package}.validator.Run;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Dto para request example", description = "Datos del example")
public class ExampleDtoRequest 
{
	@ApiModelProperty(notes = "Run del example", example = "12345678-9", required = true)
	@Run
	private String run;

	@ApiModelProperty(notes = "Descripción del example", required = true)
	@NotEmpty(message="El campo description es requerido")
	private String description;

	/**
	 * Constructor de ExampleDtoRequest sin argumentos
	 */
	public ExampleDtoRequest () {
		
	}
	
	/**
	 * @return the run
	 */
	public String getRun() {
		return run;
	}
	/**
	 * @param run the run to set
	 */
	public void setRun(String run) {
		this.run = run;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param descripcion the descripcion to set
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
		builder.append("ExampleDtoResponse [description=");
		builder.append(description);
		builder.append(", run=");
		builder.append(run);
		builder.append("]");
		return builder.toString();
	}
}
