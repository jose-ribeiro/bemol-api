package br.com.bemolapi.api.exception;

public class NegocioExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NegocioExecption (String message) {
		super(message);
	}

}



