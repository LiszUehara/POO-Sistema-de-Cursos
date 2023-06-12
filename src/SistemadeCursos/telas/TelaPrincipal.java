package SistemadeCursos.telas;

import java.util.Scanner;

import SistemadeCursos.Sistema;
import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.classes.Usuario;

public class TelaPrincipal {
    private Scanner scanner;
    private Sistema sistema;
    private boolean logado = false;

public TelaPrincipal(Sistema fachada){
    scanner = new Scanner(System.in);
    sistema = fachada;
}

public void logar(Sistema fachada) throws UsuarioNaoExisteException{
        while(true){
            System.out.println(">>>> Menu de Logar <<<<");

            System.out.println("Digite seu Usuario:");
            String usuario = scanner.nextLine();

            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();

                if(fachada.logar(usuario, senha) == true) {
                    logado = true;
                    break;
                };
        }
        }

public void iniciar() throws UsuarioNaoExisteException{
while(true){

System.out.println(">>>> Menu de operacoes <<<<");
if(logado == true){

    
    System.out.println("1 - Remover Usuario");
    System.out.println("2 - Informações do Usuario");
    System.out.println("0 - Sair");


        String operacao = scanner.nextLine();
        switch(operacao){
        case "1": { 
            System.out.println(" Digite seu CPF:");
            int cpf = scanner.nextInt();

            sistema.removerConta(cpf);
            break;
        }
        case "2": {
            System.out.println("Digite seu cpf ");
            int cpf = scanner.nextInt();

            sistema.consultar(cpf);
            System.out.println(sistema.consultar(cpf));
        break;
        } 
        case "s":
        case "S": System.exit(0); break;
        default: System.out.println("<Tente novamente.>");
        } 
        }
else {
    System.out.println("1 - Logar");
System.out.println("2 - Cadastrar Usuario");
System.out.println("0 - Sair");
String operacao = scanner.nextLine();
switch(operacao){
case "1": {logar(sistema); break;}
case "2":  break;
case "s":
case "0": System.exit(0); break;
default: System.out.println("<Tente novamente.>");
} 
}




} 


}
}
