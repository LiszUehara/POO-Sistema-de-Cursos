package SistemadeCursos.classes;

import java.util.ArrayList;

public class Cursos {
    private String nome;
    private double nota = 0.0;

    private String categoria;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private ArrayList<Aulas> aulas = new ArrayList<Aulas>();
    private ArrayList<Double> listaNotas = new ArrayList<Double>();
    private int qtdAlunos = 0;
    private int qtdAulas = 0;
    private int id;


    public Cursos(String nome, double nota, String categoria, int id) {
        super();
        this.nome = nome;
        this.nota = nota;
        this.categoria = categoria;
        this.id = id;
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

    public ArrayList<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<Aulas> aulas) {
        this.aulas = aulas;
    }

    public ArrayList<Double> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Double> listaNotas) {
        this.listaNotas = listaNotas;
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
        System.out.println(nome);
    }

    void valorAvaliacao(double notaDada) {

        nota = +notaDada / qtdAlunos;
    }

    public void atualiza(Cursos curso) {
        this.categoria = curso.getCategoria();
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.nota = curso.getNota();
        this.qtdAlunos = curso.getQtdAlunos();
        this.qtdAulas = curso.getQtdAulas();
    }

    ;


    public void assitirCurso() {
        System.out.println("Você esta assistindo ao curso");
        exibeInformacoes();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void receberNota(double nota) {
        listaNotas.add(nota);
        double soma = 0;
        double valorNota = 0;
        for (int i = 0; i < listaNotas.size(); i++) {
            soma = +i;
        }

        valorNota = soma / listaNotas.size();
        this.setNota(valorNota);

    }

    public void adicionarAulas(Aulas aula) {
        aulas.add(aula);
        qtdAulas++;
        System.out.println("aula adicionada");

    }

    public void adicionarAlunos(Aluno aluno) {
        alunos.add(aluno);
        qtdAlunos++;
        System.out.println("aluno matriculado");

    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
        qtdAlunos--;
        System.out.println("aluno desmatriculado");

    }


    @Override
    public String toString() {
        return ("nome do curso " + nome + "\nnota do curso " + nota + "\nquantidade de alunos matriculados "
                + qtdAlunos + "\nquantidade de aulas " + qtdAulas + "\nCategoria " + categoria);


    }
}
	

