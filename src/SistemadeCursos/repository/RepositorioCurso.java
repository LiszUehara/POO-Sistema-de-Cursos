package SistemadeCursos.repository;


import java.util.ArrayList;

import SistemadeCursos.classes.Categoria;
import SistemadeCursos.classes.Cursos;

public class RepositorioCurso implements IRepositorioCurso {

    public ArrayList<Cursos> getCursos() {
        return cursos;
    }

    ArrayList<Cursos> cursos;


    public RepositorioCurso() {
        cursos = new ArrayList<Cursos>();

    }

    @Override
    public ArrayList<Cursos> buscarNome(String nome) {

        ArrayList<Cursos> busca = new ArrayList<Cursos>();
        for (Cursos curso : cursos) {
            if (curso.getNome().toLowerCase().contains(nome.toLowerCase())) {
                busca.add(curso);
            }
        }
        if (busca.isEmpty()) {
            System.out.printf("Valor localizado");
            return busca;
        } else return null;
    }

    public int buscarId(int id) {
        int posicao = -1;
        int valor = this.cursos.size();
        for (int i = 0; i < valor; i++) {
            if (id == this.cursos.get(i).getId()) {
                posicao = i;
            } else {
                posicao = -1;
            }
        }
        return posicao;
    }


    @Override
    public void adicionar(Cursos curso) {
        this.cursos.add(curso);

    }

    @Override
    public Boolean delete(int id) {
        int valor = buscarId(id);
        if (valor == -1) {
            return false;
        } else {
            this.cursos.remove(valor);
            return true;
        }


    }


    @Override
    public void atualizar(Cursos novoCurso, int id) {
        try {
            Cursos curso = getCursos().get(buscarId(id));
            if (curso != null) atualizaCurso(novoCurso, curso);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            System.out.println("Nao foi possivel encontrar o curso");
        }


    }

    private void atualizaCurso(Cursos novosValores, Cursos atuaisValores) {
        String nome = novosValores.getNome();
        double nota = novosValores.getNota();
        int id = novosValores.getId();

        atuaisValores.setId(id);
        atuaisValores.setNome(nome);
        atuaisValores.setNota(nota);

    }


}


