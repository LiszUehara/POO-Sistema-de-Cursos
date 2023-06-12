package SistemadeCursos.testes;

import SistemadeCursos.classes.Admin;
import SistemadeCursos.classes.Aluno;
import SistemadeCursos.classes.Instrutor;
import SistemadeCursos.classes.Usuario;
import SistemadeCursos.repository.RepositorioUsuario;

public class TesteUsuario {

	public static void main(String[] args) {
		RepositorioUsuario repositorio = new RepositorioUsuario();
		
		Usuario usuarioA = new Admin("admin1", "admin@admin", "senha123", 2423, 1234);
		Usuario usuarioD = new Admin("adm", "admin@admin", "senha123", 24423, 12345);
		
		repositorio.adicionar(usuarioA);
		
		Usuario usuarioB = new Aluno("aluno1", "aluno@admin", "senha123", 28, 123456);
		Usuario usuarioC = new Instrutor("inst", "inst@admin", "senha123", 74, 1234567);
		
		repositorio.adicionar(usuarioB);
		repositorio.adicionar(usuarioC);
		
		for(Usuario c : repositorio.getUsuario()) {
			System.out.println(c.getNomeUsuario());
		}
		
		repositorio.remover(usuarioB, 0);
		
		for(Usuario c : repositorio.getUsuario()) {
			System.out.println(c.getNomeUsuario());
		}
		
		
		repositorio.atualizar(usuarioD,1234);
		
		for(Usuario c : repositorio.getUsuario()) {
			System.out.println(c.getNomeUsuario());
		}
	}
	
}
