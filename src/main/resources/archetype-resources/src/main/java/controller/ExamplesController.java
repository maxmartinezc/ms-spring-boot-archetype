package ${package}.controller;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ${package}.dto.ExampleDtoRequest;
import ${package}.dto.ExampleDtoResponse;
import ${package}.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/examples")
@Api(value="ExamplesController")
public class ExamplesController {

	@Autowired
	ExampleService exampleService;
	
	@ApiOperation(value = "Retorna la lista de examples", response = String.class)
	@GetMapping("/")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna la lista de examples")
	})
	public ResponseEntity<Page<ExampleDtoResponse>> getExamplesList(
			@ApiParam(value="Paginador: Número de la página", required = false) @RequestParam(value="page", defaultValue = "0") int page,
			@ApiParam(value="Paginador: Tamaño de la página", required = false) @RequestParam(value="size", defaultValue = "20") int size){
		
		Page<ExampleDtoResponse> list = this.exampleService.getList(page, size);
		return new ResponseEntity<Page<ExampleDtoResponse>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna la información de un example", response = String.class)
	@GetMapping("/{id}")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna un example")
	})
	public ResponseEntity<ExampleDtoResponse> getExamplesById(@ApiParam("Id del example") @PathVariable(value="id") int id){
		
		ExampleDtoResponse exampleDtoResponse = this.exampleService.getById(id);
		return new ResponseEntity<ExampleDtoResponse>(exampleDtoResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear un example")
	@PostMapping("/")
	@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Example creado con éxito. Retorna el location correspondiente al nuevo recurso"),
        @ApiResponse(code = 400, message = "Atributos no validos")
	})
	public ResponseEntity<Void> save(@RequestBody @Valid ExampleDtoRequest exampleDtoRequest){
		int id = this.exampleService.save(exampleDtoRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(String.valueOf(id)).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Elimina un example")
	@DeleteMapping("/{id}")
	@ApiResponses(value = {
        @ApiResponse(code = 204, message = "Example eliminado con éxito."),
        @ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public ResponseEntity<Void> delete(@ApiParam("Id del example") @PathVariable(value="id") int id){
		this.exampleService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Modificación de un example")
	@PutMapping("/{id}")
	@ApiResponses(value = {
        @ApiResponse(code = 204, message = "Example modificado con éxito."),
        @ApiResponse(code = 400, message = "Atributos no validos"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public ResponseEntity<Void> put(@ApiParam("Id del example") @PathVariable(value="id") int id,
			@RequestBody @Valid ExampleDtoRequest exampleDtoRequest){
		this.exampleService.put(id, exampleDtoRequest);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}