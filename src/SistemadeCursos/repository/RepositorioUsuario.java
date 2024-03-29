package SistemadeCursos.repository;

import java.util.ArrayList;

import SistemadeCursos.classes.Admin;
import SistemadeCursos.classes.Aluno;
import SistemadeCursos.classes.Instrutor;
import SistemadeCursos.classes.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {

    public ArrayList<Usuario> getUsuario() {

        return usuarios;
    }

    ArrayList<Usuario> usuarios;

    public RepositorioUsuario() {
        Usuario admin = new Admin("admin1", "admin@admin", "senha123", 2423, 1234);
        usuarios = new ArrayList<Usuario>();
        usuarios.add(admin);
    }


    public boolean existenteCPF(int cpf) {
        try {
            for (Usuario usuario : usuarios) {
                if (usuario.getCpf() == cpf) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("Conta nao existe");
            return false;
        }
    }

    public boolean existenteEmail(String email) {
        try {
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("Conta nao existe");
            return false;
        }
    }


    public boolean existenteMatricula(int matricula) {
        try {
            for (Usuario usuario : usuarios) {
                if (usuario.getMatricula() == matricula) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("Conta nao existe");
            return false;
        }
    }

    public boolean existenteNomedeUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return true;
            }
        }
        return false;
    }


    public Usuario verificarCpf(int valor) {

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf() == valor)
                return usuario;
        }

        return null;
    }


    public Usuario verificarMatricula(int valor) {

        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == valor)
                return usuario;
        }


        return null;
    }


    public Usuario consultarUsuario(Usuario usuario) {
        return null;
    }


    @Override
    public void adicionar(Usuario user) {
        int cpf = user.getCpf();
        String email = user.getEmail();
        String senha = user.getSenha();
        String nomeUsuario = user.getNomeUsuario();
        int matricula = user.getMatricula();


        try {
            if (user instanceof Aluno) {
                usuarios.add(new Aluno(nomeUsuario, email, senha, matricula, cpf));
            } else if (user instanceof Instrutor) {
                usuarios.add(new Instrutor(nomeUsuario, email, senha, matricula, cpf));
            } else if (user instanceof Admin) {
                usuarios.add(new Admin(nomeUsuario, email, senha, matricula, cpf));
            }


        } catch (OutOfMemoryError e) {
            System.out.println("Memoria cheia, sem espaço para mais usuarios");
        }


    }

    @Override
    public void remover(Usuario usuario) {
        Usuario users = consultar(usuario.getCpf());
        usuarios.remove(users);
    }

    @Override
    public void atualizar(Usuario user, int id) {
        Usuario usuario = consultar(id);
        if (usuario != null) atualizaUsuario(user, usuario);

    }

    private void atualizaUsuario(Usuario novosValores, Usuario atuaisValores) {
        String email = novosValores.getEmail();
        int matricula = novosValores.getMatricula();
        int cpf = novosValores.getCpf();
        String nomeUsuario = novosValores.getNomeUsuario();
        String senha = novosValores.getSenha();


        atuaisValores.setEmail(email);
        atuaisValores.setCpf(cpf);
        atuaisValores.setMatricula(matricula);
        atuaisValores.setNomeUsuario(nomeUsuario);
        atuaisValores.setSenha(senha);
    }

    @Override
    public Usuario logar(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }


    @Override
    public Usuario consultar(int valor) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf() == valor) {
                return usuario;
            }

        }
        return null;
    }


}
