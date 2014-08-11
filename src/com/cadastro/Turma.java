package com.cadastro;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private Disciplina disciplina;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
		
	}
	
	public void addAluno(Aluno aluno){
		this.alunos.add(aluno);
	}

}
