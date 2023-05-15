package SistemadeCursos.classes;

import java.util.ArrayList;

public class Cursos {
	private String nome;
	private double nota = 0.0;
	private int qtdAlunos;
	private int qtdAulas;
	private String categoria;
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private int id;
	
	
	
	public Cursos(String nome, double nota, int qtdAlunos, int qtdAulas, String categoria, int id,
			ArrayList<Categoria> categorias) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.qtdAlunos = qtdAlunos;
		this.qtdAulas = qtdAulas;
		this.categoria = categoria;
		this.id = id;
		this.categorias = categorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public int getQtdAulas() {
		return qtdAulas;
	}

	public void setQtdAulas(int qtdAulas) {
		this.qtdAulas = qtdAulas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	void exibeInformacoes() {
		System.out.println("nome do curso" + nome + "nota do curso" + nota + "quantidade de alunos matriculados"
				+ qtdAlunos + "quantidade de aulas" + qtdAulas + "Categoria" + categoria
				
				);
	}
	
	void valorAvaliacao(double notaDada) {
		
		nota =+ notaDada / qtdAlunos;
	}
	



	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}


	public void atualiza(Cursos curso) {
		this.categoria = curso.getCategoria();
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.nota = curso.getNota();
		this.qtdAlunos = curso.getQtdAlunos();
		this.qtdAulas = curso.getQtdAulas();
	};
	

	
	
	
	} 
	

