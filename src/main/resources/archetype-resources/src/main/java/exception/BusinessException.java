package ${package}.exception;

import ${package}.enums.ErrorCodesEnum;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMsg;

	public BusinessException(ErrorCodesEnum code) {
		this.errorMsg = code.getMsg();
		this.errorCode = code.getCode();
	}
	
	public BusinessException(ErrorCodesEnum code, String v) {
		this.errorMsg = String.format(code.getMsg(), v);
		this.errorCode = code.getCode();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}