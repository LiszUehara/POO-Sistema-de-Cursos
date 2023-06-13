package SistemadeCursos.classes;

public class Admin extends Usuario {

    public Admin(String nomeUsuario, String email, String senha, int matricula, int cpf) {
        super(nomeUsuario, email, senha, matricula, cpf);

    }

    @Override
    public boolean verificaAdmin() {
        return true;
    }

    public boolean verificaInstrutor() {
        return false;
    }

}
