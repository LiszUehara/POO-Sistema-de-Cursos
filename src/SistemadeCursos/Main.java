package SistemadeCursos;

import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.telas.TelaPrincipal;

public class Main {
	public static void main(String[] args) throws UsuarioNaoExisteException {
		
	Sistema sistema = new Sistema();
	TelaPrincipal tela = new TelaPrincipal(sistema);
	tela.iniciar();

    }

   
}

	
