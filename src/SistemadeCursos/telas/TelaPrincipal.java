package SistemadeCursos.telas;

import java.util.Objects;
import java.util.Scanner;

import SistemadeCursos.Sistema;
import SistemadeCursos.Exceptions.UsuarioNaoExisteException;
import SistemadeCursos.classes.*;

public class TelaPrincipal {
    private Scanner scanner;
    private Sistema sistema;
    private Usuario logado = null;

    public TelaPrincipal(Sistema fachada) {
        scanner = new Scanner(System.in);
        sistema = fachada;
    }

    public void logar(Sistema fachada) throws UsuarioNaoExisteException {
        while (true) {
            System.out.println(">>>> Menu de Logar <<<<");

            System.out.println("Digite seu Email:");
            String usuario = scanner.next();

            System.out.println("Digite sua senha:");
            String senha = scanner.next();
            logado = fachada.logar(usuario, senha);
            break;

        }
    }

    public void iniciar() throws UsuarioNaoExisteException {
        while (true) {

            System.out.println(">>>> Menu de operacoes <<<<");
            if (logado != null) {

                if (logado instanceof Aluno) {
                    menuAluno();
                } else if (logado instanceof Instrutor) {
                    menuInstrutor();
                } else if (logado instanceof Admin) {
                    menuAdmin();
                }

            } else {
                System.out.println("1 - Logar");
                System.out.println("2 - Cadastrar Usuario");
                System.out.println("0 - Sair");
                String operacao = scanner.next();
                switch (operacao) {
                    case "1" -> {
                        logar(sistema);
                    }
                    case "2" -> {
                        criarUsuario();
                    }
                    case "s", "0" -> System.exit(0);
                    default -> System.out.println("<Tente novamente.>");
                }
            }


        }


    }

    private void menuAluno() {
        System.out.println("0 - Deslogar");
        System.out.println("1 - Remover sua Conta");
        System.out.println("2 - Informações do Usuario");
        System.out.println("3 - Atualizar o Usuario");
        System.out.println("4 - Listar Cursos");
        System.out.println("5 - Procurar Curso");
        System.out.println("6 - Se Matricular");
        System.out.println("7 - Se Desmatricular");
        System.out.println("8 - Assistir Curso");
        System.out.println("S - Sair");

        String operacao = scanner.next();

        switch (operacao) {
            case "0" -> {
                logado = null;
            }
            case "1" -> {
                sistema.removerConta(logado);
                logado = null;
            }
            case "2" -> {
                Usuario usuario = sistema.consultar(logado.getCpf());
                System.out.println(usuario);
            }
            case "3" -> {

                System.out.println(" Digite o Nome de usuario:");
                String nomeUsuarioCadastro = scanner.next();
                System.out.println(" Digite o Email:");
                String emailCadastro = scanner.next();
                System.out.println(" Digite sua senha:");
                String senhaCadastro = scanner.next();
                System.out.println(" Digite sua matricula:");
                int matriculaCadastro = scanner.nextInt();
                System.out.println(" Digite o seu cpf:");
                int cpfCadastro = scanner.nextInt();

                Aluno novoAluno = new Aluno(nomeUsuarioCadastro, emailCadastro, senhaCadastro, matriculaCadastro, cpfCadastro);
                sistema.editarUsuario(novoAluno, logado.getCpf());
                logado = null;
            }
            case "4" -> {
                sistema.listarCursos();
            }
            case "5" -> {
                System.out.println(" Digite o nome do curso para procurar:");
                String procurarCurso = scanner.next();
                sistema.procurarCurso(procurarCurso);
            }
            case "6" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                sistema.matricularAluno((Aluno) logado, idCurso);
            }
            case "7" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                sistema.desmatricularAluno((Aluno) logado, idCurso);
            }
            case "8" -> {
                System.out.println(" Digite o id do Curso:");
                int idCursoAssistir = scanner.nextInt();
                Cursos meuCursoAssistir = sistema.pegarCursoPorId(idCursoAssistir);
                sistema.assistirCurso(meuCursoAssistir);
            }
            case "s", "S" -> System.exit(0);
            default -> System.out.println("<Tente novamente.>");
        }
    }

    private void menuInstrutor() {
        System.out.println("0 - Deslogar");
        System.out.println("1 - Remover Usuario");
        System.out.println("2 - Informações do Usuario");
        System.out.println("3 - Atualizar o Usuario");
        System.out.println("4 - Listar Cursos");
        System.out.println("5 - Procurar Curso");
        System.out.println("6 - Adicionar Curso");
        System.out.println("7 - Remover Curso");
        System.out.println("8 - Editar Curso");
        System.out.println("9 - Matricular aluno");
        System.out.println("10 - Adicionar Aula em Curso");
        System.out.println("S - Sair");

        String operacao = scanner.next();

        switch (operacao) {
            case "0" -> {
                logado = null;
            }
            case "1" -> {
                Usuario usuario = sistema.consultar(logado.getCpf());
                sistema.removerConta(usuario);
                logado = null;
            }
            case "2" -> {
                Usuario usuario = sistema.consultar(logado.getCpf());
                System.out.println(usuario);
            }
            case "3" -> {

                System.out.println(" Digite o Nome de usuario:");
                String nomeUsuarioCadastro = scanner.next();
                System.out.println(" Digite o Email:");
                String emailCadastro = scanner.next();
                System.out.println(" Digite sua senha:");
                String senhaCadastro = scanner.next();
                System.out.println(" Digite sua matricula:");
                int matriculaCadastro = scanner.nextInt();
                System.out.println(" Digite o seu cpf:");
                int cpfCadastro = scanner.nextInt();

                Instrutor novoInstrutor = new Instrutor(nomeUsuarioCadastro, emailCadastro, senhaCadastro, matriculaCadastro, cpfCadastro);
                sistema.editarUsuario(novoInstrutor, logado.getCpf());
                logado = null;
            }
            case "4" -> {
                sistema.listarCursos();
            }
            case "5" -> {
                System.out.println(" Digite o nome do curso para procurar:");
                String procurarCurso = scanner.next();
                sistema.procurarCurso(procurarCurso);
            }
            case "6" -> {
                System.out.println(" Digite o Nome do Curso:");
                String nomeCursoCadastro = scanner.next();
                System.out.println(" Digite o id do Curso:");
                int idCursoCadastro = scanner.nextInt();
                System.out.println(" Digite a categoria do Curso:");
                String categoriaCursoCadastro = scanner.next();
                Cursos cursoCad = new Cursos(nomeCursoCadastro, 0, categoriaCursoCadastro, idCursoCadastro);
                sistema.adicionarCurso(cursoCad);
            }
            case "7" -> {
                System.out.println(" Digite o id do Curso:");
                int idCursoRemover = scanner.nextInt();
                Cursos meuCursoRemover = sistema.pegarCursoPorId(idCursoRemover);
                sistema.removerCurso(meuCursoRemover);

            }
            case "8" -> {
                System.out.println(" Digite o id do Curso para editar:");
                int idCursoCadastro = scanner.nextInt();
                System.out.println(" Digite o Nome do Curso:");
                String nomeCursoCadastro = scanner.next();
                System.out.println(" Digite a categoria do Curso:");
                String categoriaCursoCadastro = scanner.next();
                Cursos cursoEditar = new Cursos(nomeCursoCadastro, 0, categoriaCursoCadastro, idCursoCadastro);
                sistema.editar(cursoEditar, idCursoCadastro);
            }
            case "9" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                System.out.println(" Digite o cpf do Aluno:");
                int idAluno = scanner.nextInt();
                Aluno aluno = (Aluno) sistema.consultar(idAluno);
                sistema.matricularAluno(aluno, idCurso);
            }
            case "10" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                System.out.println(" Digite o id da Aula:");
                int idAula = scanner.nextInt();
                System.out.println(" Digite o nome da Aula:");
                String nomeAula = scanner.next();
                System.out.println(" Digite a duracao da Aula:");
                int duracaoAula = scanner.nextInt();
                sistema.adicionarAula(new Aulas(idAula, nomeAula, duracaoAula), idCurso);
            }
            case "s", "S" -> System.exit(0);
            default -> System.out.println("<Tente novamente.>");
        }
    }

    private void menuAdmin() {
        System.out.println("0 - Deslogar");
        System.out.println("1 - Remover Usuario"); //admin
        System.out.println("2 - Informações do Usuario");
        System.out.println("3 - Atualizar o Usuario");
        System.out.println("4 - Criar Usuario");
        System.out.println("5 - Listar Usuarios"); //admin
        System.out.println("6 - Listar Cursos");
        System.out.println("7 - Procurar Curso");
        System.out.println("8 - Adicionar Curso");
        System.out.println("9 - Remover Curso");
        System.out.println("10 - Editar Curso");
        System.out.println("11 - Matricular aluno");
        System.out.println("12 - Adicionar Aula em Curso");
        System.out.println("13 - Assistir Curso");
        System.out.println("S - Sair");

        String operacao = scanner.next();

        switch (operacao) {
            case "0" -> {
                logado = null;
            }
            case "1" -> {
                System.out.println(" Digite o CPF:");
                int cpf = scanner.nextInt();
                Usuario usuario = sistema.consultar(cpf);
                sistema.removerConta(usuario);
                if (cpf == logado.getCpf()) logado = null;
            }
            case "2" -> {
                Usuario usuario = sistema.consultar(logado.getCpf());
                System.out.println(usuario);
            }
            case "3" -> {

                System.out.println(" Digite o Nome de usuario:");
                String nomeUsuarioCadastro = scanner.next();
                System.out.println(" Digite o Email:");
                String emailCadastro = scanner.next();
                System.out.println(" Digite sua senha:");
                String senhaCadastro = scanner.next();
                System.out.println(" Digite sua matricula:");
                int matriculaCadastro = scanner.nextInt();
                System.out.println(" Digite o seu cpf:");
                int cpfCadastro = scanner.nextInt();

                Admin novoAdmin = new Admin(nomeUsuarioCadastro, emailCadastro, senhaCadastro, matriculaCadastro, cpfCadastro);
                sistema.editarUsuario(novoAdmin, logado.getCpf());
                logado = null;
            }
            case "4" -> {
                criarUsuario();
            }
            case "5" -> {
                sistema.listarUsuarios();
            }
            case "6" -> {
                sistema.listarCursos();
            }
            case "7" -> {
                System.out.println(" Digite o nome do curso para procurar:");
                String procurarCurso = scanner.next();
                sistema.procurarCurso(procurarCurso);
            }
            case "8" -> {
                System.out.println(" Digite o Nome do Curso:");
                String nomeCursoCadastro = scanner.next();
                System.out.println(" Digite o id do Curso:");
                int idCursoCadastro = scanner.nextInt();
                System.out.println(" Digite a categoria do Curso:");
                String categoriaCursoCadastro = scanner.next();
                Cursos cursoCad = new Cursos(nomeCursoCadastro, 0, categoriaCursoCadastro, idCursoCadastro);
                sistema.adicionarCurso(cursoCad);
            }
            case "9" -> {
                System.out.println(" Digite o id do Curso:");
                int idCursoRemover = scanner.nextInt();
                Cursos meuCursoRemover = sistema.pegarCursoPorId(idCursoRemover);
                sistema.removerCurso(meuCursoRemover);

            }
            case "10" -> {
                System.out.println(" Digite o id do Curso para editar:");
                int idCursoCadastro = scanner.nextInt();
                System.out.println(" Digite o Nome do Curso:");
                String nomeCursoCadastro = scanner.next();
                System.out.println(" Digite a categoria do Curso:");
                String categoriaCursoCadastro = scanner.next();
                Cursos cursoEditar = new Cursos(nomeCursoCadastro, 0, categoriaCursoCadastro, idCursoCadastro);
                sistema.editar(cursoEditar, idCursoCadastro);
            }
            case "11" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                System.out.println(" Digite o cpf do Aluno:");
                int idAluno = scanner.nextInt();
                Aluno aluno = (Aluno) sistema.consultar(idAluno);
                sistema.matricularAluno(aluno, idCurso);
            }
            case "12" -> {
                System.out.println(" Digite o id do Curso:");
                int idCurso = scanner.nextInt();
                System.out.println(" Digite o id da Aula:");
                int idAula = scanner.nextInt();
                System.out.println(" Digite o nome da Aula:");
                String nomeAula = scanner.next();
                System.out.println(" Digite a duracao da Aula:");
                int duracaoAula = scanner.nextInt();
                sistema.adicionarAula(new Aulas(idAula, nomeAula, duracaoAula), idCurso);
            }
            case "13" -> {
                System.out.println(" Digite o id do Curso:");
                int idCursoAssistir = scanner.nextInt();
                Cursos meuCursoAssistir = sistema.pegarCursoPorId(idCursoAssistir);
                sistema.assistirCurso(meuCursoAssistir);
            }
            case "s", "S" -> System.exit(0);
            default -> System.out.println("<Tente novamente.>");
        }
    }

    private void criarUsuario() {
        System.out.println("É um aluno ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não,  um instrutor");
        String EAluno = scanner.next();

        System.out.println(" Digite o Nome de usuario:");
        String nomeUsuarioCadastro = scanner.next();
        System.out.println(" Digite o Email:");
        String emailCadastro = scanner.next();
        System.out.println(" Digite sua senha:");
        String senhaCadastro = scanner.next();
        System.out.println(" Digite sua matricula:");
        int matriculaCadastro = scanner.nextInt();
        System.out.println(" Digite o seu cpf:");
        int cpfCadastro = scanner.nextInt();

        if (Objects.equals(EAluno, "1")) {
            sistema.adicionar(new Aluno(nomeUsuarioCadastro, emailCadastro, senhaCadastro, matriculaCadastro, cpfCadastro));
        } else if (Objects.equals(EAluno, "2")) {
            sistema.adicionar(new Instrutor(nomeUsuarioCadastro, emailCadastro, senhaCadastro, matriculaCadastro, cpfCadastro));
        }
    }
}
