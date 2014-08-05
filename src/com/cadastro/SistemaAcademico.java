package com.cadastro;

import java.util.ArrayList;
import java.util.List;

import com.excecoes.CpfDuplicadoException;
import com.excecoes.IdadeInvalidaException;

public class SistemaAcademico {

	private String nome, endereco, cnpj;
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private int IDADE_MINIMO = 18;
	private double media;
	private String situacaoDisciplina= null;
	
	/**public String SituaçãoDisciplina(Disciplina disciplina){
		
		if(isSubmeterMedia()){
			situaçãoDisciplina = ""
			
		}
		
	}
   */
	public String validarIdade(Pessoa pessoa) {
		
		if(pessoa.getIdade() < IDADE_MINIMO){
			throw new IdadeInvalidaException("Idade não Permitida, por gentileza informe uma idade acima de 18 anos");
		}else{
            return"";
	}
	}
	public boolean submeterMedia(Aluno aluno,Disciplina disciplina, double nota){
		
		
		
		return true;
	}
	

	public void addAluno(Aluno novoAluno){
		validarIdade(novoAluno);
		
		for(Aluno alunoAntigo : alunos){
			if(alunoAntigo != null && 
					alunoAntigo.getCpf()== novoAluno.getCpf()){
				throw new 	CpfDuplicadoException("Cpf ja cadastrado");
			}
		}
		alunos.add(novoAluno);
	}
	public void addProfessor(Professor novoProfessor){
		validarIdade(novoProfessor);
	   
		for(Professor professorAntigo : professores){
			if(professorAntigo != null && 
					professorAntigo.getCpf()== novoProfessor.getCpf()){
				throw new 	CpfDuplicadoException("Cpf ja cadastrado");
			}
		}
		professores.add(novoProfessor);
	
	}
	public void addDepartamento(Departamento departamento){
		departamentos.add(departamento);
	}
	
	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	
	public void addCurso(Curso curso){
		cursos.add(curso);
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public List<Curso> getCursos(){
		return cursos;
		
	}
		
	public List<Departamento> getDepartamentos(){
		return departamentos;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
		public List<Professor> getProfessores() {
		return professores;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	public String getNome(){
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
	public boolean alunoAprovado(double media){
		double mediaFinal = media;
		if(mediaFinal < 5){
			return false;
		}else{
			return true;
		}
	}
	

}
     
	
