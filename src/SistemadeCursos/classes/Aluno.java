package SistemadeCursos.classes;

public class Aluno extends Usuario {

    public Aluno(String nomeUsuario, String email, String senha, int matricula, int cpf) {
        super(nomeUsuario, email, senha, matricula, cpf);
    }

    public boolean verificaAdmin() {
        return false;
    }

    public boolean verificaInstrutor() {
        return false;
    }

}
