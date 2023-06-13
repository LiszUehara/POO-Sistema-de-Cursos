package SistemadeCursos.classes;

public class Aulas {
    private int id;
    private String nomeAula;
    private int duracaoAula;

    public Aulas(int id, String nomeAula, int duracaoAula) {
        this.id = id;
        this.nomeAula = nomeAula;
        this.duracaoAula = duracaoAula;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }


}
