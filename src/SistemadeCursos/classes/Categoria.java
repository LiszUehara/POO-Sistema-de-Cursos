package SistemadeCursos.classes;

public class Categoria {
    private String nomeCategoria;
    private int qtdCategoria;


    public Categoria(String nomeCategoria) {
        super();
        this.nomeCategoria = nomeCategoria;
        this.qtdCategoria = 0;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getQtdCategoria() {
        return qtdCategoria;
    }

    public void setQtdCategoria(int qtdCategoria) {
        this.qtdCategoria = qtdCategoria;
    }


}
