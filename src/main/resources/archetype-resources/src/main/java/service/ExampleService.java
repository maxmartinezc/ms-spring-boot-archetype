package ${package}.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ${package}.dto.ExampleDtoRequest;
import ${package}.dto.ExampleDtoResponse;
import ${package}.entity.ExampleEntity;
import ${package}.enums.ErrorCodesEnum;
import ${package}.exception.CustomNotFoundException;
import ${package}.repository.ExampleRepository;

/**
 * Clase service de ejemplo, retornan valores estaticos.
 */
@Service
public class ExampleService {

	@Autowired
	ExampleRepository exampleRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * Retorna la lista de los examples
	 * @return
	 */
	public Page<ExampleDtoResponse> getList(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size, Direction.DESC, "creationDate");
		Page<ExampleDtoResponse> list = this.exampleRepository.findAll(pageable)
				.map(item -> this.modelMapper.map(item, ExampleDtoResponse.class));
		return list;
	}
	
	/**
	 * Guarda un example
	 * @return
	 */
	public int save(ExampleDtoRequest exampleDtoRequest) {
		ExampleEntity example = this.modelMapper.map(exampleDtoRequest, ExampleEntity.class);
		this.exampleRepository.save(example);
		return example.getId();
	}
	
	/**
	 * Elimina un example
	 * @return
	 */
	public void delete(int id) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		this.exampleRepository.delete(example.get());
	}
	
	/**
	 * Modifica un example
	 * @return
	 */
	public void put(int id, ExampleDtoRequest exampleDtoRequest) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		
		this.modelMapper.map(exampleDtoRequest, example.get());
		this.exampleRepository.save(example.get());
	}

	/**
	 * Retorna la información de un example por su id
	 * @param id
	 * @return
	 */
	public ExampleDtoResponse getById(int id) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		ExampleDtoResponse exDtoR = this.modelMapper.map(example.get(), ExampleDtoResponse.class);
		return exDtoR;
	}
}
