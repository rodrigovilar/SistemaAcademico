package com.cadastro;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {

	private String nome, endereco, cnpj;
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public List<Curso> getCursos(){
		return cursos;
		
	}
	public void addCurso(Curso curso){
		cursos.add(curso);
	}
	
	public List<Departamento> getDepartamentos(){
		return departamentos;
	}
	public void addDepartamento(Departamento departamento){
		departamentos.add(departamento);
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	public void addAluno(Aluno aluno){
		alunos.add(aluno);
	}
	public List<Professor> getProfessores() {
		return professores;
	}

	public void addProfessor(Professor professor) {
		professores.add(professor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
