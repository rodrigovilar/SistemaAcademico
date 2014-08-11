package com.excecoes;

public class PessoaNomeNuloException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PessoaNomeNuloException (String mensagem) {
		super(mensagem);
	}
}