package SistemadeCursos.negocio;

import java.util.ArrayList;

import SistemadeCursos.classes.Cursos;
import SistemadeCursos.repository.IRepositorioCurso;
import SistemadeCursos.repository.RepositorioCurso;

public class NegocioCurso {

	private RepositorioCurso repositorio;

	public NegocioCurso(RepositorioCurso repositorio) {
		this.repositorio = repositorio;
	}
	
	
	public ArrayList<Cursos> listarCursos(){
		return repositorio.getCursos();
	}
	
	public void adicionar(Cursos curso) {
		if(curso != null) {
			repositorio.include(curso);
			System.out.println("Item adicionado");
		} else {
			System.out.println("Erro ao adicionar item");
		}
	}
	
	public ArrayList<Cursos> procurarCurso(String nome){
		if(nome != null) {
			return repositorio.buscarNome(nome);
		} else {
			return null;
		}
	}
	
	public void removerCurso(Cursos curso) {
		boolean funcionou = repositorio.delete(curso.getId());
		if(funcionou) {
			System.out.println("Curso deletado com sucesso");
		} else {
			System.out.println("Falha ao deletar curso");
		}
	}
	
	public void editar(Cursos novoCurso) {
		if(novoCurso != null) {
			repositorio.update(novoCurso);
		} else {
			System.out.println("erro ao atualizar curso");
		}
	}
	
	
}
