package br.unigran.controleabastecimento;

public class Abastecimento {
    private Integer id;
    private Integer kmAtual;
    private Integer qntAbastecida;
    private String dia;
    private Double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(Integer kmAtual) {
        this.kmAtual = kmAtual;
    }

    public Integer getQntAbastecida() {
        return qntAbastecida;
    }

    public void setQntAbastecida(Integer qntAbastecida) {
        this.qntAbastecida = qntAbastecida;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
