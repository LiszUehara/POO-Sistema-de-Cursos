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
		if(user == null) {
			throw new UsuarioNaoExisteException();
		} else {
			return user;
		}
		
	
}
	
	public void adicionar(int cpf) {
		boolean existeEmail = repositorio.existenteEmail(cpf.getEmail());
		boolean existeCpf =  repositorio.existenteCPF(cpf.getCpf());
		boolean existeMatricula =  repositorio.existenteMatricula(cpf.getMatricula());
		
		if(existeEmail || existeCpf || existeMatricula == true) {
			System.out.println("Usuario existente");
		} else {
			System.out.println("Usuario cadastrado com sucesso");
		}
		
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		ArrayList<Usuario> usuarios = repositorio.getUsuario();
		if(usuarios == null) {
			System.out.println("lista vazia");
			return null;
		}else  {
			return usuarios;
		}
	}
	
	public void editarUsuario(Usuario usuarios, int cpf) {
		if(usuarios != null) {
			repositorio.atualizar(usuarios, cpf);
		} else {
			System.out.println("Atualização não funcionou");
		}
	}
	
	public void removerConta(Usuario usuarios, int cpf) {
		if(usuarios != null) {
			repositorio.remover(usuarios, cpf);
		} else {
			System.out.println("Falha ao remover usuario");
		}
	}

    public void consultar(int cpf) {
    }
	
}

