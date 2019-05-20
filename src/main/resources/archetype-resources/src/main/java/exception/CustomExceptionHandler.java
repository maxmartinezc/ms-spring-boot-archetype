package ${package}.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import ${package}.enums.ErrorCodesEnum;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setInternalCode("500");
		exceptionResponse.setMessage(ex.getMessage());
		ex.printStackTrace();
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleCustomNotFoundException(CustomNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setInternalCode(ex.getErrorCode());
		exceptionResponse.setMessage(ex.getErrorMsg());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setInternalCode(ErrorCodesEnum.DTO_REQUEST_VALIDATION.getCode());
		exceptionResponse.setMessage(ErrorCodesEnum.DTO_REQUEST_VALIDATION.getMsg());
		exceptionResponse.setValidationErrors(result);
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Custom exceptions
	 * 
	 * @param BusinessException ex
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setInternalCode(ex.getErrorCode());
		exceptionResponse.setMessage(ex.getErrorMsg());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
