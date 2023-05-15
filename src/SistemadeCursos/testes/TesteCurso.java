package SistemadeCursos.testes;

import SistemadeCursos.classes.Cursos;
import SistemadeCursos.repository.RepositorioCurso;

public class TesteCurso {

	
	
	public static void main(String[] args) {
		RepositorioCurso repositorio = new RepositorioCurso();
		
		Cursos cursoA = new Cursos("curso A", 0, 0, 0, "TI", 0, null);
		
		repositorio.include(cursoA);
		
		Cursos cursoB = new Cursos("curso B", 1, 0, 1, "TI", 1, null);
		Cursos cursoC = new Cursos("curso C", 0, 0, 2, "TI", 2, null);
		
		Cursos cursoD = new Cursos("curso D", 0, 0, 0, "TI", 5, null);
		
		repositorio.include(cursoB);
		repositorio.include(cursoC);
		
		for(Cursos c : repositorio.getCursos()) {
			System.out.println(c.getNome());
		}
		
		repositorio.delete(1);
		
		for(Cursos c : repositorio.getCursos()) {
			System.out.println(c.getNome());
		}
		
		
		repositorio.atualizar(cursoD,0);
		
		for(Cursos c : repositorio.getCursos()) {
			System.out.println(c.getNome());
		}
	}
	
}
