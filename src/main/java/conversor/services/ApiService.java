package services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class ApiService {

    private static final String API_KEY = "add608eecb82ed627aa17c79";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Método para pegar a taxa de câmbio entre duas moedas
    public double obterTaxaDeCambio(String moedaOrigem, String moedaDestino) throws Exception {
        String urlString = API_URL + moedaOrigem;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Verificar código de status HTTP
        if (connection.getResponseCode() != 200) {
            throw new Exception("Falha na conexão com a API. Código HTTP: " + connection.getResponseCode());
        }

        // Ler a resposta da API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Converter a resposta em JSON
        JSONObject jsonResponse = new JSONObject(response.toString());

        // Verificar se a requisição foi bem-sucedida
        if (!jsonResponse.getString("result").equals("success")) {
            throw new Exception("Erro ao obter taxas de câmbio.");
        }

        // Obter a taxa de câmbio
        JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
        return conversionRates.getDouble(moedaDestino); // Retorna a taxa de conversão da moedaDestino
    }
}
