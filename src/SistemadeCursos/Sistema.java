package SistemadeCursos;

import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.classes.Aluno;
import SistemadeCursos.classes.Aulas;
import SistemadeCursos.classes.Cursos;
import SistemadeCursos.classes.Usuario;
import SistemadeCursos.negocio.NegocioCurso;
import SistemadeCursos.negocio.NegocioUsuario;
import SistemadeCursos.repository.RepositorioCurso;
import SistemadeCursos.repository.RepositorioUsuario;

import java.util.ArrayList;

public class Sistema {
    private NegocioCurso cursos;
    private NegocioUsuario usuarios;

    public Sistema() {
        this.cursos = new NegocioCurso(new RepositorioCurso());
        this.usuarios = new NegocioUsuario(new RepositorioUsuario());
    }

    public void adicionarCurso(Cursos curso) {
        this.cursos.adicionar(curso);
    }

    public void procurarCurso(String nome) {
        this.cursos.procurarCurso(nome);
    }

    public void removerCurso(Cursos curso) {
        if (curso != null) {
            this.cursos.removerCurso(curso);
        } else {
            System.out.println("Falha ao remover curso");
        }

    }

    public void adicionarAula(Aulas aula, int id) {
        try {
            int posicao = this.cursos.pegarPosicaoCurso(id);
            cursos.listarCursos().get(posicao).adicionarAulas(aula);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Nao foi possivel cadastrar a aula");
        }
    }

    public void matricularAluno(Aluno aluno, int id) {
        try {
            int posicao = this.cursos.pegarPosicaoCurso(id);
            cursos.listarCursos().get(posicao).adicionarAlunos(aluno);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Nao foi possivel matricular o aluno");
        }

    }

    public void desmatricularAluno(Aluno aluno, int id) {
        try {
            int posicao = this.cursos.pegarPosicaoCurso(id);
            cursos.listarCursos().get(posicao).removerAluno(aluno);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Nao foi possivel desmatricular o aluno");
        }

    }

    public Cursos pegarCursoPorId(int id) {
        return this.cursos.pegarCursoPorId(id);
    }

    public void editar(Cursos novoCurso, int idAtual) {
        this.cursos.editar(novoCurso, idAtual);
    }

    public void adicionar(Usuario usuarios) {
        this.usuarios.adicionar(usuarios);
    }

    public Usuario logar(String email, String senha) throws UsuarioNaoExisteException {
        try {
            Usuario user = this.usuarios.logar(email, senha);
            return user;
        } catch (UsuarioNaoExisteException e) {
            System.out.println("<Usuario Nao existe>");
            return null;
        }
    }

    public void listarUsuarios() {
        ArrayList<Usuario> usuarios = this.usuarios.listarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void assistirCurso(Cursos curso) {
        curso.assitirCurso();
    }

    public void listarCursos() {
        ArrayList<Cursos> cursos = this.cursos.listarCursos();
        for (Cursos curso : cursos) {
            System.out.println(curso);
        }
    }

    public void editarUsuario(Usuario usuarios, int cpf) {
        this.usuarios.editarUsuario(usuarios, cpf);
    }

    public void removerConta(Usuario usuario) {
        this.usuarios.removerConta(usuario);
    }

    public Usuario consultar(int cpf) {
        return this.usuarios.consultar(cpf);
    }

}
