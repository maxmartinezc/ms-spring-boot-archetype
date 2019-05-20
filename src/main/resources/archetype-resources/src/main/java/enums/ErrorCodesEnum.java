package ${package}.enums;

public enum ErrorCodesEnum {
	DTO_REQUEST_VALIDATION("DTO_REQUEST_VALIDATION", "Atributos no validos"),
	WRONG_PARAMETER_DATA("WRONG_PARAMETER_DATA", "Parametro no valido [%s]"),
	UNAUTHORIZED("UNAUTHORIZED", "%s"),
	INVALID_TOKEN("INVALID_TOKEN", "Token no valido: %s"),
	INVALID_TOKEN_EXPIRED("INVALID_TOKEN_EXPIRED", "Token expirado"),
	NOT_FOUND("NOT_FOUND", "Recurso no encontrado [%s]");

	private final String code;
	private final String msg;

	ErrorCodesEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}
}