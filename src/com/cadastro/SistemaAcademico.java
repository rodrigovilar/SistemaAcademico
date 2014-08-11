package com.cadastro;

import java.util.ArrayList;
import java.util.List;

import com.excecoes.CpfDuplicadoException;
import com.excecoes.IdadeInvalidaException;
import com.excecoes.ProfessorNomeNuloException;

public class SistemaAcademico {

	private String nome, endereco, cnpj;
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Turma turma;
	private int IDADE_MINIMO = 18;
	private String matricula;
	
	
	
	public String gerarMatricula(Aluno aluno){
      
		return matricula = aluno.getNome().substring(0,4) + aluno.getCpf().substring(0,3);
	
	}
	  
	public String validarIdade(Pessoa pessoa) {
		
		if(pessoa.getIdade() < IDADE_MINIMO){
			throw new IdadeInvalidaException("Idade não Permitida, por gentileza informe uma idade acima de 18 anos");
		}else{
            return"";
	}
	}
	public String SituacaoAlunoPorDisciplina(Aluno aluno, Disciplina disciplina, double nota){
		
		if(nota >= 5){
			return "Aprovado";
		}else{
			return "Reprovado";
			
		}
	}
	public String validarProfessorNulo(Professor professor){
				
			if(professor.getNome() == null ){
				throw new ProfessorNomeNuloException("Preencha todos os campos corretamente");
			}else{
				return " ";
			}
	}
	public String toString(Aluno aluno,Disciplina disciplina, double nota){
		
		
		return ("Disciplina: "  +disciplina.getNome()+ ", Nota: " +nota+ ", Situação: " +SituacaoAlunoPorDisciplina(aluno,disciplina,nota));
	}
	
	
	public void validarCpfDuplicado(Pessoa novaPessoa){
					
		for(Pessoa pessoaAntiga : pessoas){
			if(pessoaAntiga != null && 
					pessoaAntiga.getCpf()== novaPessoa.getCpf()){
				throw new 	CpfDuplicadoException("Cpf ja cadastrado");
			}
		}
		pessoas.add(novaPessoa);
	}
	
	public void addAluno(Aluno novoAluno){
		gerarMatricula(novoAluno);
		validarIdade(novoAluno);
		validarCpfDuplicado(novoAluno);
		alunos.add(novoAluno);
	}
	public void addProfessor(Professor novoProfessor){
		validarProfessorNulo(novoProfessor);
		validarIdade(novoProfessor);
		validarCpfDuplicado(novoProfessor);
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
	public List<Pessoa> getPessoas(){
		return pessoas;
	}
	public List<Professor> getProfessores(){
		return professores;
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
	public Turma getTurma(){
		return turma;
	}
	public void setTurma(Turma turma){
		this.turma = turma;
	}
	}
	
