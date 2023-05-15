package SistemadeCursos.repository;

import java.util.ArrayList;

import SistemadeCursos.classes.Cursos;

public interface IRepositorioCurso {
    void include(Cursos curso);
    Boolean delete(int id);
    void atualizar(Cursos curso, int id);
	ArrayList<Cursos> buscarNome(String nome);
}
