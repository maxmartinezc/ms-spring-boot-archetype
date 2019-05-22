package ${package}.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ${package}.dto.ExampleDtoRequest;
import ${package}.dto.ExampleDtoResponse;
import ${package}.service.ExampleService;

@RestController
@RequestMapping(value = "/example")
@Api(value="ExampleController")
public class ExampleController {

	@Autowired
	ExampleService exampleService;
	
	@ApiOperation(value = "Retorna la lista de examples", response = String.class)
	@GetMapping("/")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna la lista de examples")
	})
	public ResponseEntity<Page<ExampleDtoResponse>> getExamplesList(){
		Page<ExampleDtoResponse> list = this.exampleService.getList();
		return new ResponseEntity<Page<ExampleDtoResponse>>(list, HttpStatus.OK);
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
	
	@ApiOperation(value = "Modifica parcialmente un example")
	@PatchMapping("/{id}")
	@ApiResponses(value = {
        @ApiResponse(code = 204, message = "Example modificado con éxito."),
        @ApiResponse(code = 400, message = "Atributos no validos"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public ResponseEntity<Void> patch(@ApiParam("Id del example") @PathVariable(value="id") int id,
			@RequestBody @Valid ExampleDtoRequest exampleDtoRequest){
		this.exampleService.patch(id, exampleDtoRequest);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Modificación total un example")
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