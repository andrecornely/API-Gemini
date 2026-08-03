import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        String apiKey = "AQ.Ab8RN6ICQzPBArB9GjPmedJLd5UMrLcFydAZTqfLMFDtWwndKg";

        HttpClient client = HttpClient.newHttpClient();

        String json = """
      {
      "contents": [{
      "parts": [{
      "text": "Olá, quem és?"
        }]
       }]
       }
    """;

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(
                                "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.6-flash:generateContent?key="
                                        + apiKey))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();
        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );
        System.out.println(response.body());
    }
}