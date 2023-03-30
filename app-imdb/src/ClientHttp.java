import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
    
    public String takeData(String url)
    {
        // try to catch the info of the URL
        try
        {
            HttpClient client = HttpClient.newHttpClient();
            var requisition = HttpRequest.newBuilder(URI.create(url)).GET().build();
            HttpResponse <String> answer = client.send(requisition, BodyHandlers.ofString());
            String json = answer.body();

            return json;
        }
        catch (IOException | InterruptedException ex)
        {
            throw new ClientHttpException("Error detected when tried to take the URL");
        }
    }

}
