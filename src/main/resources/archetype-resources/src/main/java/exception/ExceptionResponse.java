package ${package}.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ExceptionResponse {

	private String internalCode;
	private String message;
	private List<SubErrorResponse> errors = new ArrayList<>();
	public String getInternalCode() {
		return internalCode;
	}
	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<SubErrorResponse> getErrors() {
		return errors;
	}
	
	public void setValidationErrors(Errors errs) {
		List<FieldError> fieldErrors = errs.getFieldErrors();
		List<ObjectError> globalErrors = errs.getGlobalErrors();
		globalErrors.forEach(o -> errors.add(new SubErrorResponse(o.getCode(), "Global", o.getDefaultMessage(), o.getObjectName())));
		fieldErrors.forEach(f -> errors.add(new SubErrorResponse(f.getField(), f.getRejectedValue(), f.getDefaultMessage(), f.getObjectName())));
	}
	
	public class SubErrorResponse {
		String internalErrorCode;
		Object developerMessage;
		String userMessage;
		String moreInfo;

		public SubErrorResponse(String internalErrorCode, Object developerMessage, String userMessage, String moreInfo) {
			super();
			this.internalErrorCode = internalErrorCode;
			this.developerMessage = developerMessage;
			this.userMessage = userMessage;
			this.moreInfo = moreInfo;
		}

		public String getInternalErrorCode() {
			return internalErrorCode;
		}

		public void setInternalErrorCode(String internalErrorCode) {
			this.internalErrorCode = internalErrorCode;
		}

		public Object getDeveloperMessage() {
			return developerMessage;
		}

		public void setDeveloperMessage(Object developerMessage) {
			this.developerMessage = developerMessage;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}

		public String getMoreInfo() {
			return moreInfo;
		}

		public void setMoreInfo(String moreInfo) {
			this.moreInfo = moreInfo;
		}
	}
}
