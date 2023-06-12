package SistemadeCursos;

import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.classes.Cursos;
import SistemadeCursos.classes.Usuario;
import SistemadeCursos.negocio.NegocioCurso;
import SistemadeCursos.negocio.NegocioUsuario;
import SistemadeCursos.repository.RepositorioCurso;
import SistemadeCursos.repository.RepositorioUsuario;

public class Sistema {
	private NegocioCurso cursos;
	private NegocioUsuario usuarios;
	
	public Sistema() {
		this.cursos = new NegocioCurso(new RepositorioCurso());
		this.usuarios = new NegocioUsuario(new RepositorioUsuario());
	}
	
	public void adicionarCurso(Cursos curso){
		this.cursos.adicionar(curso);
	}
	
	public void procurarCurso(String nome) {
		this.cursos.procurarCurso(nome);
	}
	
	public void removerCurso(Cursos curso) {
		this.cursos.removerCurso(curso);
	}
	
	public void  editar(Cursos novoCurso) {
		this.cursos.editar(novoCurso, 0);
	}
	
	public void adicionar(Usuario usuarios) {
		this.usuarios.adicionar(usuarios);
	}

	public boolean logar(String email, String senha) throws UsuarioNaoExisteException {
		try{
			Usuario user = this.usuarios.logar(email, senha);
			return user!= null;
		}catch (UsuarioNaoExisteException e){
		System.out.println("<Usuario Nao existe>");
		return false;
		}
	}
	
	public void listarUsuarios() {
		this.usuarios.listarUsuarios();
	}
	
	public void editarUsuario(Usuario usuarios, int cpf) {
		this.usuarios.editarUsuario(usuarios, cpf);
	}
	
	public void removerConta(int cpf) {
		this.usuarios.adicionar(cpf);
	}

	public void consultar(int cpf){
		this.usuarios.consultar(cpf);
	}
	
}
