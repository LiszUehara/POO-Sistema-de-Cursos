package SistemadeCursos.Exceptions;

public class UsuarioNaoExisteException extends Exception{

    public UsuarioNaoExisteException(){
        super("Email ou senha estão incorretos");
    }
    
}