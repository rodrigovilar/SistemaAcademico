package com.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cadastro.Aluno;
import com.cadastro.Curso;
import com.cadastro.Departamento;
import com.cadastro.Disciplina;
import com.cadastro.Pessoa;
import com.cadastro.Professor;
import com.cadastro.SistemaAcademico;
import com.cadastro.Turma;
import com.excecoes.IdadeInvalidaException;

public class SistemaTeste {
	
	private SistemaAcademico sistemaAcademico;
	
	@Before
	public void NovoSistemaAcademico(){
		sistemaAcademico = new SistemaAcademico();
	}
	
	@Test//Teste Cadastro Sistema Academico
	public void CadastrarSistemaAcademico(){
		sistemaAcademico.setNome("Universidade Federal da Paraíba");
		sistemaAcademico.setEndereco("Cidade Universitária, João Pessoa/PB");
		sistemaAcademico.setCnpj("888.0001.00/00");
		assertEquals("Universidade Federal da Paraíba",sistemaAcademico.getNome());
		assertEquals("Cidade Universitária, João Pessoa/PB",sistemaAcademico.getEndereco());
		assertEquals("888.0001.00/00",sistemaAcademico.getCnpj());
	}

	@Test//Teste Cadastrar Professor			
	public void cadastrarProfessor(){
		Professor professor1 = new Professor();
		professor1.setNome("Rodrigo Vilar");
		professor1.setIdade(24);
		professor1.setCpf("111.111.111-2");
		professor1.setEndereco("Rua Beira Rio, 123, Centro, João Pessoa");
		
		List <Professor> professores = sistemaAcademico.getProfessores();
		sistemaAcademico.addProfessor(professor1);
		assertEquals(1, professores.size());
		assertEquals(professor1, professores.get(0));
				
	}
	@Test//Teste Cadastrar Aluno		
	public void cadastrarAluno(){
		Aluno aluno = new Aluno();
		aluno.setNome("Keila");
		aluno.setIdade(19);
		aluno.setCpf("111.222.333-4");
		sistemaAcademico.gerarMatricula(aluno);
		List <Aluno> alunos = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno);
		assertEquals("Keil111",sistemaAcademico.gerarMatricula(aluno));
		assertEquals(1, alunos.size());
		assertEquals(aluno, alunos.get(0));
				
	}
	@Test//Teste Cadastrar Cursos
	public void CadastrarCursos(){
		Curso curso1 = new Curso();
		curso1.setNome("Licenciatura em Ciência da Computação");
		curso1.setCargaHoraria(3080);
		Curso curso2 = new Curso();
		curso2.setNome("Sistema de Informação");
		curso2.setCargaHoraria(3090);
			
		List <Curso> cursos = sistemaAcademico.getCursos();
		sistemaAcademico.addCurso(curso1);
		sistemaAcademico.addCurso(curso2);
		assertEquals(2,cursos.size());
		assertEquals(curso2,cursos.get(1));
		assertEquals(curso1,cursos.get(0));
		
	}
	
	@Test// Teste Cadastrar Departamentos
	public void CadastrarDepartamentos(){
		Departamento departamento1 = new Departamento();
		departamento1.setNome("Centro de Ciências Exatas e Aplicadas");
		Departamento departamento2 = new Departamento();
		departamento2.setNome("Centro de Tecnologia");
		Departamento departamento3 = new Departamento();
		departamento3.setNome("Centro de Informática");
				
		List <Departamento> departamentos = sistemaAcademico.getDepartamentos();
		sistemaAcademico.addDepartamento(departamento1);
		sistemaAcademico.addDepartamento(departamento2);
		sistemaAcademico.addDepartamento(departamento3);
		assertEquals(3,departamentos.size());
		assertEquals(departamento1,departamentos.get(0));
		assertEquals(departamento2,departamentos.get(1));
		assertEquals(departamento3,departamentos.get(2));
		
	}
	@Test//Teste formar Turma por disciplina e remover 	
	public void formarTurmaPorDisciplinaeRemoverdaLista(){
		Turma t1 = new Turma();
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("IP");
		disciplina1.setCargaHoraria(60);
		disciplina1.setCreditos(6);
		
		t1.setDisciplina(disciplina1);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Carlos André");
		aluno1.setIdade(20);
		aluno1.setCpf("111.222.333-4");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Fernanda Karla");
		aluno2.setIdade(30);
		aluno2.setCpf("111.222.325-7");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("João Felipe");
		aluno3.setIdade(21);
		aluno3.setCpf("111.022.333-8");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Maria Glaúdia");
		aluno4.setIdade(23);
		aluno4.setCpf("121.002.703-4");
		
		List<Aluno> alunos = t1.getAlunos();
		t1.addAluno(aluno1);
		t1.addAluno(aluno2);
		t1.addAluno(aluno3);
		t1.addAluno(aluno4);
		
		sistemaAcademico.setTurma(t1);
		
		assertEquals(2,alunos.indexOf(aluno3));
		assertEquals(0,alunos.indexOf(aluno1));
		assertEquals(1,alunos.indexOf(aluno2));
		assertEquals(3,alunos.indexOf(aluno4));
		assertEquals(4,alunos.size());
		
		alunos.remove(aluno1);
		
		assertTrue(alunos.contains(aluno2));
		assertTrue(alunos.contains(aluno3));
		assertTrue(alunos.contains(aluno4));
		
		assertFalse(alunos.contains(aluno1));
		
	}
	@Test//Teste Matricular Alunos em uma Turma/Disciplina
	public void matricularAlunosEmTurma(){
		Turma t1 = new Turma();
		Disciplina d1 = new Disciplina();
		d1.setNome("CALCULO 1");
		d1.setCargaHoraria(90);
		d1.setCreditos(9);
        
		t1.setDisciplina(d1);
	
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Roberto Carlos");
		aluno1.setIdade(20);
		aluno1.setCpf("234.555.987-0");
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Raimundo José");
		aluno2.setCpf("255.555.987-0");
		aluno2.setIdade(20);
		List<Aluno> alunos = t1.getAlunos();
		t1.addAluno(aluno1);
		t1.addAluno(aluno2);
		
		sistemaAcademico.setTurma(t1);
		
		assertEquals(2,alunos.size());
		assertTrue(alunos.contains(aluno2));
		assertTrue(alunos.contains(aluno1));
		
	}
	@Test//Teste para submeter Media por disciplina e retorna sua nota e sua situação de acordo com a nota.
	public void TesteSubmeterMediaPorDisciplina(){
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Liviany Reis");
		aluno1.setCpf("1");
		aluno1.setIdade(23);
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Introdução ao Computador");
		disciplina1.setCargaHoraria(60);
		disciplina1.setCreditos(6);
		assertEquals("Disciplina: Introdução ao Computador, Nota: 8.0, Situação: Aprovado", sistemaAcademico.toString(aluno1,disciplina1,8.0));
		
	}
	
	@Test(expected = com.excecoes.IdadeInvalidaException.class)//teste para validar idade do aluno.
	public void ValidarIdadeAluno(){;
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Pedro Nascimento");
		aluno1.setCpf("222.222.333-2");
		aluno1.setIdade(18);
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Pedro Nascimento");
		aluno2.setCpf("222.222.333-2");
		aluno2.setIdade(16);
		List<Aluno> alunos = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno1);
		sistemaAcademico.addAluno(aluno2);
		assertEquals("Idade não Permitida, por gentileza informe uma idade acima de 18 anos", sistemaAcademico.validarIdade(aluno2));
		assertEquals(1,alunos.size());
	}
	
	@Test(expected = com.excecoes.CpfDuplicadoException.class)// Teste para verificar cpf duplicado do professor.
	public void cpfDoProfessorDuplicado(){
		Professor professor1 = new Professor();
		professor1.setNome("Vanessa Dantas");
		professor1.setCpf("258.259.104-36");
		professor1.setIdade(30);
		Professor professor2 = new Professor();
		professor2.setNome("Carlos Alberto");
		professor2.setCpf("258.259.104-36");
		professor2.setIdade(46);
		
		List<Professor> professores = sistemaAcademico.getProfessores();
		sistemaAcademico.addProfessor(professor1);
		sistemaAcademico.addProfessor(professor2);
		assertEquals(professor1, sistemaAcademico.getProfessores()); 
		assertEquals("Cpf ja cadastrado", sistemaAcademico.getProfessores());
		assertEquals(1,professores.size());
	}
	@Test(expected = com.excecoes.CpfDuplicadoException.class)// Teste para verificar cpf duplicado do aluno.
	public void cpfDoAlunoDuplicado(){
		Aluno a1 = new Aluno();
		a1.setNome("Carlos André");
		a1.setIdade(23);
		a1.setCpf("324.444.111-0");
		
		Aluno a2 = new Aluno();
		a2.setNome("Felipe Augusto");
		a2.setIdade(20);
		a2.setCpf("324.444.111-0");
		
		List<Aluno> alunos = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(a1);
		sistemaAcademico.addAluno(a2);
		assertEquals(a1, sistemaAcademico.getAlunos());
		assertEquals("Cpf ja cadastrado", sistemaAcademico.getAlunos());
		assertEquals(1,alunos.size());
		
	}
	@Test(expected = com.excecoes.IdadeInvalidaException.class)// Teste para Vaidar idade do professor.
	public void validarIdadeProfessor(){
		Professor p1 = new Professor();
		p1.setCpf("111.333.556-1");
		p1.setIdade(14);
		
		assertEquals("Idade não Permitida, por gentileza informe uma idade acima de 18 anos", sistemaAcademico.validarIdade(p1));
	}
	@Test
	public void exibirSituaçãoDoAlunoEmUmDisciplina(){// Teste para verificar a situação do aluno de acordo com a nota do aluno, que pode ser aprovado ou reprovado.
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Cristal");
		aluno1.setCpf("1");
		aluno1.setIdade(23);
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Raimundo");
		aluno2.setCpf("2");
		aluno2.setIdade(18);
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Linguagem de Programação");
		disciplina1.setCargaHoraria(60);
		disciplina1.setCreditos(6);
		
		sistemaAcademico.SituacaoAlunoPorDisciplina(aluno1, disciplina1, 9.5);
		sistemaAcademico.SituacaoAlunoPorDisciplina(aluno2, disciplina1, 4.5);
		
		assertEquals("Aprovado",sistemaAcademico.SituacaoAlunoPorDisciplina(aluno1, disciplina1,9.5));
		assertEquals("Reprovado",sistemaAcademico.SituacaoAlunoPorDisciplina(aluno1, disciplina1,4.5));
		
	}

	@Test
	public void ExibirMediasDoPeriodo(){//Teste para exibir media do periodo como se fosse um histórico.
		Aluno a = new Aluno();
		a.setNome("Wendell");
	
		Disciplina d1 = new Disciplina();
		d1.setNome("IP");
		Disciplina d2 = new Disciplina();
		d2.setNome("Calculo1");
		Disciplina d3 = new Disciplina();
		d3.setNome("Matematica Elementar");
		Disciplina d4 = new Disciplina();
		d4.setNome("Filosofia");
		Disciplina d5 = new Disciplina();
		d5.setNome("IC");
		List <String> historico = new ArrayList<>();
		historico.add(a.getNome());
		historico.add(sistemaAcademico.toString(a,d1,8.5));
		historico.add(sistemaAcademico.toString(a,d2,8.0));
		historico.add(sistemaAcademico.toString(a,d3,8.5));
		historico.add(sistemaAcademico.toString(a,d4,9.5));
		historico.add(sistemaAcademico.toString(a,d5,9.0));
		assertEquals(2,historico.indexOf(sistemaAcademico.toString(a,d2,8.0)));
		assertEquals("Disciplina: Filosofia, Nota: 9.5, Situação: Aprovado", historico.get(4));
		assertEquals("Disciplina: Calculo1, Nota: 8.0, Situação: Aprovado",historico.get(2));
		assertEquals("Disciplina: IP, Nota: 8.5, Situação: Aprovado",historico.get(1));
		assertTrue(historico.contains("Wendell"));
		assertEquals(6,historico.size());
	
	   }
	
	@Test
	public void GerarMatriculaAluno(){//Teste que gerar a matricula do aluno automaticamente de acordo com seu cpf e nome.
		Aluno aluno = new Aluno();
		aluno.setNome("Leandro");
		aluno.setCpf("111222.333-42");
		aluno.setEndereco("Rua das Trincheiras");
		aluno.setIdade(23);
		sistemaAcademico.gerarMatricula(aluno);
		assertEquals("Lean111",sistemaAcademico.gerarMatricula(aluno));
		
	}
	@Test (expected = com.excecoes.ProfessorNomeNuloException.class)//Teste para verificar o campo nome quando for nulo, e lança uma exceção.
	public void cadastrandoProfessorNulo(){
		Professor professor1 = new Professor();
		professor1.setNome(null);
		List<Professor> professores = sistemaAcademico.getProfessores();
		sistemaAcademico.addProfessor(professor1);
		assertEquals("Preencha todos os campos corretamente", sistemaAcademico.validarProfessorNulo(professor1));
	}
	@Test (expected = com.excecoes.PessoaSexoNuloException.class)
	public void alunoComSexoIncorreto(){
		Aluno aluno1 = new Aluno();
		aluno1.setSexo("Gato");
		
		assertEquals("Campo 'Sexo' preenchido incorretamente", sistemaAcademico.validarSexoNulo(aluno1));
	}
	@Test (expected = com.excecoes.PessoaSexoNuloException.class)
	public void alunoComSexoNulo(){
		Aluno aluno1 = new Aluno();
		aluno1.setSexo(null);
		
		assertEquals("Campo 'Sexo' preenchido incorretamente", sistemaAcademico.validarSexoNulo(aluno1));
	}
	@Test (expected = com.excecoes.PessoaSexoNuloException.class)
	public void professorComSexoIncorreto(){
		Professor professor1 = new Professor();
		professor1.setSexo("Mulher");
		
		assertEquals("Campo 'Sexo' preenchido incorretamente", sistemaAcademico.validarSexoNulo(professor1));
	}	
	@Test (expected = com.excecoes.PessoaSexoNuloException.class)
	public void professorComSexoNulo(){
		Professor p1 = new Professor();
		p1.setSexo(null);
		
		assertEquals("Campo 'Sexo' preenchido incorretamente", sistemaAcademico.validarSexoNulo(p1));
	}
	@Test (expected = com.excecoes.PessoaCpfNuloException.class)
	public void alunoCpfNulo(){
		Aluno a1 = new Aluno();
		a1.setCpf(null);
		
		assertEquals("Campo 'CPF' não preenchido", sistemaAcademico.validarCpfNulo(a1));
	}
	@Test (expected = com.excecoes.PessoaCpfNuloException.class)
	public void professorCpfNulo(){
		Professor p1 = new Professor();
		p1.setCpf(null);
		
		assertEquals("Campo 'CPF' não preenchido", sistemaAcademico.validarCpfNulo(p1));
		
	}

	
	
	}
	
	