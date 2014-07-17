package com.excecoes;

public class CpfDuplicadoException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public CpfDuplicadoException (String mensagem) {
		super(mensagem);
	}

}
