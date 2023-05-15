package SistemadeCursos.repository;


import java.util.ArrayList;

import SistemadeCursos.classes.Aluno;
import SistemadeCursos.classes.Categoria;
import SistemadeCursos.classes.Cursos;
import SistemadeCursos.classes.Usuario;

public class RepositorioCurso implements IRepositorioCurso {
	
	 public ArrayList<Cursos> getCursos() {
	        return cursos;
	    }

	 ArrayList<Cursos> cursos;
	 
	 
	public RepositorioCurso() {
		cursos = new ArrayList<Cursos>();
		//adicionar teste
	}

	@Override
	public ArrayList<Cursos> buscarNome(String nome) {
		
		ArrayList<Cursos> busca = new ArrayList<Cursos>();
        for (Cursos curso : cursos){
            if(curso.getNome().toLowerCase().contains(nome.toLowerCase())){
                busca.add(curso);
            }
        }
        System.out.printf("Valor localizado");
        return busca;
	}

	 public int buscarId(int id){
	        int posicao = -1;
	        int valor = this.cursos.size();
	        for (int i = 0; i < valor; i++) {
	            if(id == this.cursos.get(i).getId()){
	                posicao = i;
	            } else {
	            	posicao = -1;
	            }
	        }
	        return posicao;
	    }

	 
	 
	@Override
	public void include(Cursos curso) {
		this.cursos.add(curso);
		
	}

	@Override
	public Boolean delete(int id, Usuario usuario) {
		if(usuario.verificaAdmin() == true) {
			int valor = buscarId(id);
			if(valor == -1 ) {
				return false;
			} else {
				this.cursos.remove(valor);
				return true;
			} 
		} else {
			return false;
		}
		
	}
	
	
	@Override
	public void atualizar(Cursos novoCurso, int id) {
		Cursos curso = getCursos().get(buscarId(id));
		if (curso != null) atualizaCurso(novoCurso, curso);
		
	}
	
	private void atualizaCurso(Cursos novosValores, Cursos atuaisValores) {
		String nome = novosValores.getNome();
		ArrayList<Categoria> categoria =  novosValores.getCategorias();
		double nota =  novosValores.getNota();
		int qtdAlunos =  novosValores.getQtdAulas();
		int qtdAulas =   novosValores.getQtdAulas();
		int id = novosValores.getId();
		
		atuaisValores.setId(id);
		atuaisValores.setCategorias(categoria);
		atuaisValores.setNome(nome);
		atuaisValores.setNota(nota);
		atuaisValores.setQtdAulas(qtdAulas);
		atuaisValores.setQtdAlunos(qtdAlunos);
		
	}
	
	private void adicionarAluno(Aluno aluno, Cursos curso) {
		Aluno novaMatricula = aluno;
		curso.getAlunos().add(novaMatricula);
	}
	
	private void removerAluno(Aluno aluno, Cursos curso) {
		Aluno matriculaRemover = aluno;
		
	}
	
	
	
	private void matricular(int id, Aluno aluno) {
		int idCurso =  buscarId(id);
		if(idCurso != -1) {
			Cursos cursoValor = cursos.get(idCurso);
			if(idCurso != -1) {
				adicionarAluno(aluno, cursoValor);
				System.out.println("Matriculado com sucesso");
			} else {
				System.out.println("Falha ao matricular");
			}
		}
	}

	private void removerMatricula(int id, Aluno aluno) {
		int idCurso =  buscarId(id);
		if(idCurso != -1) {
			
		}
	}
	
	}


