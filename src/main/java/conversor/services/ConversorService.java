package services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorService {

    private ApiService apiService;

    public ConversorService() {
        this.apiService = new ApiService();
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino) throws Exception {
        double taxaDeCambio = apiService.obterTaxaDeCambio(moedaOrigem, moedaDestino);
        double valorConvertido = valor * taxaDeCambio;

        registrarLog(valor, moedaOrigem, valorConvertido, moedaDestino);
        return valorConvertido;
    }

    private void registrarLog(double valorOriginal, String moedaOrigem, double valorConvertido, String moedaDestino) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String log = String.format("[%s] %.2f %s -> %.2f %s%n",
                agora.format(formatter), valorOriginal, moedaOrigem, valorConvertido, moedaDestino);

        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            writer.write(log);
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
