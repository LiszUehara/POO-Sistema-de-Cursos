package SistemadeCursos.repository;

import java.util.ArrayList;

import SistemadeCursos.classes.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {
	
	public ArrayList<Usuario> getUsuario() {
       
		return usuarios;
    }
	 ArrayList<Usuario> usuarios;

	public RepositorioUsuario() {
		usuarios = new ArrayList<Usuario>();
	}
	
	
    public boolean existenteCPF(int cpf){
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf() == cpf) {
                return true;
            }
        }
        return false;
    }

    public boolean existenteEmail(String email){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean existenteMatricula(int matricula){
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existenteNomedeUsuario(String nomeUsuario){
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return true;
            }
        }
        return false;
    }
    
    
    public Usuario verificarCpf(int valor) {

        for (Usuario usuario : usuarios) {
        	if (usuario.getCpf()  == valor) 
            	return usuario;
        }
        	

        return null;
    }
    
    
    public Usuario verificarMatricula(int valor) {

        for (Usuario usuario : usuarios) {
        	if (usuario.getMatricula()  == valor) 
            	return usuario;
        }
        	

        return null;
    }
    
    

    
    public Usuario consultarUsuario(Usuario usuario) {
        return null;
    }
    
    


	@Override
	public void adicionar(Usuario user) {
		usuarios.add(user);
		
	}

	@Override
	public void remover(Usuario usuario) {
		Usuario users = consultar(usuario.getCpf());
		if( users != null) {
			usuarios.remove(users);
		}
			
		
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
		for(Usuario usuario: usuarios) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}



	

	@Override
	public Usuario consultar(int valor) {
		for(Usuario usuario : usuarios ) {
			if(usuario.getCpf() == valor) {
				return usuario;
			}
			
		}
		return null;
	}






}
