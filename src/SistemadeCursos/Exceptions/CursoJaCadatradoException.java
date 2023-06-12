package SistemadeCursos.Exceptions;

public class CursoJaCadatradoException extends Exception{
    public CursoJaCadatradoException(){
        super("Curso já existe");

    }

}
