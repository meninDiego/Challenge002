package models;

public class ResultadoConversao {
    private double valorOriginal;
    private String moedaOrigem;
    private double valorConvertido;
    private String moedaDestino;

    public ResultadoConversao(double valorOriginal, String moedaOrigem, double valorConvertido, String moedaDestino) {
        this.valorOriginal = valorOriginal;
        this.moedaOrigem = moedaOrigem;
        this.valorConvertido = valorConvertido;
        this.moedaDestino = moedaDestino;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }
}
