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
import com.cadastro.Professor;
import com.cadastro.SistemaAcademico;
import com.excecoes.IdadeInvalidaException;

public class SistemaTeste {
	
	private SistemaAcademico sistemaAcademico;
	
	@Before
	public void NovoSistemaAcademico(){
		sistemaAcademico = new SistemaAcademico();
	}
	
	@Test
	public void CadastrarSistemaAcademico(){
		sistemaAcademico.setNome("Universidade Federal da Paraíba");
		sistemaAcademico.setEndereco("Cidade Universitária, João Pessoa/PB");
		sistemaAcademico.setCnpj("888.0001.00/00");
		assertEquals("Universidade Federal da Paraíba",sistemaAcademico.getNome());
		assertEquals("Cidade Universitária, João Pessoa/PB",sistemaAcademico.getEndereco());
		assertEquals("888.0001.00/00",sistemaAcademico.getCnpj());
	}

	@Test
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
	@Test
	public void cadastrarAluno(){
		Aluno aluno = new Aluno();
		aluno.setMatricula("81124930");
		aluno.setIdade(19);
		List <Aluno> alunos = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno);
		assertEquals(1, alunos.size());
		assertEquals(aluno, alunos.get(0));
				
	}
	@Test
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
	
	@Test
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
	@Test
	public void formarTurmaPorDisciplina(){
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("IP");
		Aluno aluno1 = new Aluno();
		aluno1.setIdade(20);
		aluno1.setCpf("111.222.333-4");
		Aluno aluno2 = new Aluno();
		aluno2.setIdade(30);
		aluno2.setCpf("111.222.325-7");
		Aluno aluno3 = new Aluno();
		aluno3.setIdade(21);
		aluno3.setCpf("111.022.333-8");
		Aluno aluno4 = new Aluno();
		aluno4.setIdade(23);
		aluno4.setCpf("121.002.703-4");
		
		List <Aluno> turmaIP = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno1);
		sistemaAcademico.addAluno(aluno2);
		sistemaAcademico.addAluno(aluno3);
		sistemaAcademico.addAluno(aluno4);
		assertEquals(2,turmaIP.indexOf(aluno3));
		assertEquals(4,turmaIP.size());	
		
	}
	@Test
	public void matricularAlunosEmTurmaETrancar(){
		Aluno aluno1 = new Aluno();
		aluno1.setIdade(20);
		aluno1.setCpf("234.555.987-0");
		Aluno aluno2 = new Aluno();
		aluno2.setCpf("234.555.996-0");
		aluno2.setIdade(20);
		aluno1.setCpf("124.505.987-0");
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("CALCULO 1");
		disciplina1.setCargaHoraria(90);
		disciplina1.setCreditos(9);
		
		
		
		List <Aluno> turmaCALCULO1 = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno1);
		sistemaAcademico.addAluno(aluno2);
		assertEquals(2,turmaCALCULO1.size());
		assertTrue(turmaCALCULO1.contains(aluno2));
		
		
		turmaCALCULO1.remove(aluno2);
		assertFalse(turmaCALCULO1.contains(aluno2));

	}
	/**@Test
	public void TesteSubmeterMediaPorDisciplina(){
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Liviany Reis");
		aluno1.setIdade(23);
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Linguagem de Programação");
		assertEquals(8.0, sistemaAcademico.submeterMedia(aluno1,disciplina1, 8.0));
		
	}
	
	*/
	
	@Test(expected = com.excecoes.IdadeInvalidaException.class)
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
	
	@Test(expected = com.excecoes.CpfDuplicadoException.class)
	public void cpfDoProfessorDuplicado(){
		Professor professor1 = new Professor();
		professor1.setCpf("258.259.104-36");
		professor1.setIdade(30);
		Professor professor2 = new Professor();
		professor2.setCpf("258.259.104-36");
		professor2.setIdade(46);
		
		List<Professor> professores = sistemaAcademico.getProfessores();
		sistemaAcademico.addProfessor(professor1);
		sistemaAcademico.addProfessor(professor2);
		assertEquals(professor1, sistemaAcademico.getProfessores()); 
		assertEquals("Cpf ja cadastrado", sistemaAcademico.getProfessores());
	}
	@Test(expected = com.excecoes.CpfDuplicadoException.class)
	public void cpfDoAlunoDuplicado(){
		Aluno a1 = new Aluno();
		a1.setIdade(23);
		a1.setCpf("324.444.111-0");
		
		Aluno a2 = new Aluno();
		a2.setIdade(20);
		a2.setCpf("324.444.111-0");
		
		List<Aluno> alunos = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(a1);
		sistemaAcademico.addAluno(a2);
		assertEquals(a1, sistemaAcademico.getAlunos()); 
		assertEquals("Cpf ja cadastrado", sistemaAcademico.getAlunos());
		
		
		}
		
	@Test(expected = com.excecoes.IdadeInvalidaException.class)
	public void validarIdadeProfessor(){
		Professor p1 = new Professor();
		p1.setCpf("111.333.556-1");
		p1.setIdade(14);
		
		assertEquals("Idade não Permitida, por gentileza informe uma idade acima de 18 anos", sistemaAcademico.validarIdade(p1));
	}
	
	@Test
	public void exibirSituaçãoDoAluno(){
		SistemaAcademico mediaAluno1 = new SistemaAcademico();
		SistemaAcademico mediaAluno2 = new SistemaAcademico();

		mediaAluno1.setMedia(9.5);
		mediaAluno2.setMedia(4.5);
		
		assertTrue(mediaAluno1.alunoAprovado(mediaAluno1.getMedia()));
		assertFalse(mediaAluno2.alunoAprovado(mediaAluno2.getMedia()));

		
	}
	
	/**@Test
	public void ExibirHistorico(){
		Aluno a = new Aluno();
		a.setNome("Liviany Reis");
		a.setCpf("321.666.333-4");
		a.setIdade(21);
		a.setMatricula("81221233");
		
		Disciplina d1 = new Disciplina();
		d1.setNome("IP");
		d1.setNota(7.3);
		Disciplina d2 = new Disciplina();
		d2.setNome("IC");
		d2.setNota(9.0);
		Disciplina d3 = new Disciplina();
		d3.setNome("Filosofia");
		d3.setNota(9.6);
		Disciplina d4 = new Disciplina();
		d4.setNome("Calculo 1");
		d4.setNota(10);
		Disciplina d5 = new Disciplina();
		d5.setNome("Matematica elementar");
		d5.setNota(8.0);
		
		
		sistemaAcademico.submeterNotas(a, d1, 10);
		sistemaAcademico.submeterNotas(a, d2, 4);
		sistemaAcademico.submeterNotas(a, d3, 8);
		sistemaAcademico.submeterNotas(a, d4, 9);
		sistemaAcademico.submeterNotas(a, d5, 10);
		
		List<Disciplina> disciplinas = sistemaAcademico.getDisciplinas();
		
		sistemaAcademico.exibirHistorico(a,disciplinas);
		
	}*/
	
}
	
	