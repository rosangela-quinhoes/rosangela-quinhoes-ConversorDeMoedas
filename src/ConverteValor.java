import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteValor {

    public Conversor buscaConversao(String base_code, String target_code,
    Double conversion_rate, Double valor,
     Double conversion_result)

        throws IOException, InterruptedException {

        URI url_str = URI.create(
        "https://v6.exchangerate-api.com/v6/63b9fccb462501441208b991/pair/" +
                base_code + "/" + target_code + "/" + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url_str)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
//        System.out.println(response.body());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        conversion_result = jsonObject.get("conversion_result").getAsDouble();
//        System.out.println("Taxa de Conversão Obtida: " + conversion_result);

        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException("Não suportamos o código de moeda fornecido");
        } catch (InterruptedException e) {
            throw new RuntimeException("Não suportamos o código de moeda fornecido");
        }


        return new Gson().fromJson(response.body(), Conversor.class);



    }
}

