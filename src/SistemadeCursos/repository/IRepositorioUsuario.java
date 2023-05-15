package SistemadeCursos.repository;

import SistemadeCursos.classes.Usuario;

public interface IRepositorioUsuario {
	    public void adicionar(Usuario user);
	    void remover(Usuario conta);
	    void atualizar(Usuario user,int id);
	    Usuario logar(String email, String senha);
	    boolean existenteCPF(int cpf);
	    boolean existenteEmail(String email);
	    boolean existenteMatricula(int matricula);
	    boolean existenteNomedeUsuario(String nomeUsuario);
	    Usuario verificarCpf(int valor);
	    Usuario consultar(int valor) ;
}
