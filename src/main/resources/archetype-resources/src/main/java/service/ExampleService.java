package ${package}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ${package}.dto.ExampleDtoRequest;
import ${package}.dto.ExampleDtoResponse;
import ${package}.repository.ExampleRepository;

/**
 * Clase service de ejemplo, retornan valores estaticos.
 */
@Service
public class ExampleService {

	@Autowired
	ExampleRepository exampleRepository;
	
	/**
	 * Retorna la lista de los examples
	 * @return
	 */
	public Page<ExampleDtoResponse> getList() {
		Page<ExampleDtoResponse> list = null;
		return list;
	}
	
	/**
	 * Guarda un example
	 * @return
	 */
	public int save(ExampleDtoRequest exampleDtoRequest) {
		return 1;
	}
	
	/**
	 * Modifica parcialmente un example
	 * @return
	 */
	public void patch(int id, ExampleDtoRequest exampleDtoRequest) {
		//void
	}
	
	/**
	 * Modifica totalmente un example
	 * @return
	 */
	public void put(int id, ExampleDtoRequest exampleDtoRequest) {
		//void
	}
}
