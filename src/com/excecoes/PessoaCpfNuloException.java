package com.excecoes;

public class PessoaCpfNuloException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public PessoaCpfNuloException (String mensagem) {
		super(mensagem);
	}


}
