package SistemadeCursos.negocio;

import java.util.ArrayList;

import SistemadeCursos.classes.Cursos;
import SistemadeCursos.repository.RepositorioCurso;

public class NegocioCurso {

    private RepositorioCurso repositorio;

    public NegocioCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }


    public ArrayList<Cursos> listarCursos() {
        return repositorio.getCursos();
    }


    public void adicionar(Cursos curso) {

        try {
            repositorio.adicionar(curso);
            System.out.println("Curso adicionado com Sucesso");

        } catch (NullPointerException e) {
            System.out.println("Erro ao adicionar o curso");
        } catch (NumberFormatException e) {
            System.out.println("Nome do curso não pode ser numero");
        }

    }

    public ArrayList<Cursos> procurarCurso(String nome) {
        try {
            return repositorio.buscarNome(nome);
        } catch (NullPointerException e) {
            System.out.println("Não localizado");
            return null;
        }
    }

    public Cursos pegarCursoPorId(int id) {
        try {
            return repositorio.getCursos().get(repositorio.buscarId(id));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    public int pegarPosicaoCurso(int id) {
        return repositorio.buscarId(id);
    }

    public void removerCurso(Cursos curso) {
        boolean funcionou = repositorio.delete(curso.getId());


        try {
            if (funcionou) {
                System.out.println("Curso deletado com sucesso");
            }

        } catch (NullPointerException e) {
            System.out.println("Falha ao deletar curso, curso não encontrado");

        }


    }

    public void editar(Cursos novoCurso, int id) {

        try {
            repositorio.atualizar(novoCurso, id);
        } catch (NullPointerException e) {
            System.out.println("erro ao atualizar curso");
        }


    }


}
