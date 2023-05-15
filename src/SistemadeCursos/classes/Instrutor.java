package SistemadeCursos.classes;

public class Instrutor extends Usuario{

	public Instrutor(String nomeUsuario, String email, String senha, int matricula, int cpf) {
		super(nomeUsuario, email, senha, matricula, cpf);
	}
	public boolean verificaAdmin(){
		return false;
	}
	
	@Override
	public boolean verificaInstrutor() {
		return true;
	}
	
}
