package main;

import services.ConversorService;

import java.io.*;
import java.util.Scanner;

public class ConversorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        ConversorService conversorService = new ConversorService();

        while (opcao != 0) {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("1. Dólar (USD) → Real (BRL)");
            System.out.println("2. Real (BRL) → Dólar (USD)");
            System.out.println("3. Euro (EUR) → Real (BRL)");
            System.out.println("4. Real (BRL) → Euro (EUR)");
            System.out.println("5. Libra (GBP) → Real (BRL)");
            System.out.println("6. Real (BRL) → Libra (GBP)");
            System.out.println("7. Ver logs de conversões");
            System.out.println("8. Limpar logs de conversões");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 7:
                    exibirLogs();
                    continue;
                case 8:
                    limparLogs();
                    continue;
            }

            if (opcao < 1 || opcao > 6) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1 -> {
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                }
                case 2 -> {
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                }
                case 3 -> {
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                }
                case 4 -> {
                    moedaOrigem = "BRL";
                    moedaDestino = "EUR";
                }
                case 5 -> {
                    moedaOrigem = "GBP";
                    moedaDestino = "BRL";
                }
                case 6 -> {
                    moedaOrigem = "BRL";
                    moedaDestino = "GBP";
                }
            }

            try {
                double valorConvertido = conversorService.converter(valor, moedaOrigem, moedaDestino);
                System.out.println("Valor convertido: " + valorConvertido + " " + moedaDestino);
            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void exibirLogs() {
        System.out.println("\n=== HISTÓRICO DE CONVERSÕES ===");
        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String linha;
            boolean vazio = true;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                vazio = false;
            }
            if (vazio) {
                System.out.println("Nenhuma conversão registrada ainda.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de logs ou arquivo inexistente.");
        }
    }

    private static void limparLogs() {
        try (PrintWriter writer = new PrintWriter("logs.txt")) {
            writer.print(""); // limpa o conteúdo
            System.out.println("Logs de conversões apagados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao limpar os logs.");
        }
    }
}
