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
	public void formarTurma(){
		Disciplina disciplina = new Disciplina();
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		Aluno aluno4 = new Aluno();
		disciplina.setNome("IP");
		List <Aluno> turmaIP = sistemaAcademico.getAlunos();
		sistemaAcademico.addAluno(aluno1);
		sistemaAcademico.addAluno(aluno2);
		sistemaAcademico.addAluno(aluno3);
		sistemaAcademico.addAluno(aluno4);
		assertEquals(2,turmaIP.indexOf(aluno3));
		assertEquals(4,turmaIP.size());	
		
	}
	@Test
	public void matricularAlunosEmDuasTurmasETrancarUma(){
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("CALCULO 1");
		disciplina1.setCargaHoraria(90);
		disciplina1.setCreditos(9);
		
		
		
		List <Aluno> turmaCALCULO1 = disciplina1.getAlunos();
		disciplina1.addAluno(aluno1);
		disciplina1.addAluno(aluno2);
		assertEquals(2,turmaCALCULO1.size());
		assertTrue(turmaCALCULO1.contains(aluno2));
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("LP");
		disciplina2.setCargaHoraria(60);
		disciplina2.setCreditos(6);
		List <Aluno> turmaLP = disciplina2.getAlunos();
		disciplina2.addAluno(aluno1);
		disciplina2.addAluno(aluno2);
		disciplina2.addAluno(aluno3);
		assertEquals(3,turmaLP.size());
		assertTrue(turmaLP.contains(aluno2));
		
		turmaLP.remove(aluno2);
		assertFalse(turmaLP.contains(aluno2));

	}
	@Test
	public void TesteSubmeterNotaPorDisciplina(){
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Liviany Reis");
		aluno1.setIdade(23);
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Introdução à Computador");
		assertEquals("O Aluno está Reprovado",sistemaAcademico.SubmeterNotas(aluno1, disciplina1, 5));
		}
	
	
		
		
	}
	
	