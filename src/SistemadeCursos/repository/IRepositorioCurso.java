package SistemadeCursos.repository;

import java.util.ArrayList;

import SistemadeCursos.classes.Cursos;
import SistemadeCursos.classes.Usuario;

public interface IRepositorioCurso {
    void include(Cursos curso);
    void atualizar(Cursos curso, int id);
	ArrayList<Cursos> buscarNome(String nome);
	Boolean delete(int id, Usuario usuario);
	
}
