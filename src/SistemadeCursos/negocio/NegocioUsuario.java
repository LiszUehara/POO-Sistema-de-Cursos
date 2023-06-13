package SistemadeCursos.negocio;

import java.util.ArrayList;

import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.classes.Usuario;
import SistemadeCursos.repository.RepositorioUsuario;

public class NegocioUsuario {

    private RepositorioUsuario repositorio;

    public NegocioUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario logar(String email, String senha) throws UsuarioNaoExisteException {
        Usuario user = repositorio.logar(email, senha);
        if (user == null) {
            throw new UsuarioNaoExisteException();
        } else {
            return user;
        }


    }

    public void adicionar(Usuario usuario) {
        boolean existeEmail = repositorio.existenteEmail(usuario.getEmail());
        boolean existeCpf = repositorio.existenteCPF(usuario.getCpf());
        boolean existeMatricula = repositorio.existenteMatricula(usuario.getMatricula());

        if (existeEmail || existeCpf || existeMatricula == true) {
            System.out.println("Usuario existente");
        } else {
            repositorio.adicionar(usuario);
            System.out.println("Usuario cadastrado com sucesso");
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = repositorio.getUsuario();
        if (usuarios == null) {
            System.out.println("lista vazia");
            return null;
        } else {
            return usuarios;
        }
    }

    public void editarUsuario(Usuario usuarios, int cpf) {
        if (usuarios != null) {
            repositorio.atualizar(usuarios, cpf);
        } else {
            System.out.println("Atualização não funcionou");
        }
    }

    public void removerConta(Usuario usuarios) {
        if (usuarios != null) {
            repositorio.remover(usuarios);
        } else {
            System.out.println("Falha ao remover usuario");
        }
    }

    public Usuario consultar(int cpf) {
        return repositorio.consultar(cpf);
    }

}

