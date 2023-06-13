package SistemadeCursos.testes;

import SistemadeCursos.classes.Cursos;
import SistemadeCursos.repository.RepositorioCurso;

public class TesteCurso {


    public static void main(String[] args) {
        RepositorioCurso repositorio = new RepositorioCurso();

        Cursos cursoA = new Cursos("curso A", 0, "TI", 0);

        repositorio.adicionar(cursoA);

        Cursos cursoB = new Cursos("curso B", 1, "TI", 1);
        Cursos cursoC = new Cursos("curso C", 0, "TI", 2);

        Cursos cursoD = new Cursos("curso D", 0, "TI", 5);

        repositorio.adicionar(cursoB);
        repositorio.adicionar(cursoC);

        for (Cursos c : repositorio.getCursos()) {
            System.out.println(c.getNome());
        }

        repositorio.delete(1);

        for (Cursos c : repositorio.getCursos()) {
            System.out.println(c.getNome());
        }


        repositorio.atualizar(cursoD, 0);

        for (Cursos c : repositorio.getCursos()) {
            System.out.println(c.getNome());
        }
    }

}
