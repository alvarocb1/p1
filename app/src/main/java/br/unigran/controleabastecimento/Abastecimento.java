package br.unigran.controleabastecimento;

public class Abastecimento {
    private Integer id;
    private String kmAtual;
    private String qntAbastecida;
    private String dia;
    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(String kmAtual) {
        this.kmAtual = kmAtual;
    }

    public String getQntAbastecida() {
        return qntAbastecida;
    }

    public void setQntAbastecida(String qntAbastecida) {
        this.qntAbastecida = qntAbastecida;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
