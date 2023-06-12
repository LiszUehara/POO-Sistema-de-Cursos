package SistemadeCursos.Exceptions;

public class ContaJaCadastradaException extends Exception{
    public ContaJaCadastradaException(){
        super("Email já cadastrado!");

    }
}