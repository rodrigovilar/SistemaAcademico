package com.excecoes;

public class ProfessorNomeNuloException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProfessorNomeNuloException (String mensagem) {
		super(mensagem);
	}
}
