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
		turmaIP.add(aluno1);
		turmaIP.add(aluno2);
		turmaIP.add(aluno3);
		turmaIP.add(aluno4);
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
		
		List <Aluno> turmaCALCULO1 = new ArrayList<>();
		turmaCALCULO1.add(aluno1);
		turmaCALCULO1.add(aluno2);
		turmaCALCULO1.add(aluno3);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("LP");
		List <Aluno> turmaLP = sistemaAcademico.getAlunos();
		turmaLP.add(aluno1);
		turmaLP.add(aluno2);
		turmaLP.add(aluno3);
		assertEquals(3,turmaLP.size());
		assertTrue(turmaLP.contains(aluno2));
		
		turmaLP.remove(aluno2);
		assertFalse(turmaLP.contains(aluno2));

	}
	
	

}
