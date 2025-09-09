package br.com.soc.sistema.vo;

public enum Periodo {
    MANHA("MANHÃ"),
    TARDE("TARDE"),
    AMBOS("AMBOS");

    private String descricao;

    private Periodo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}