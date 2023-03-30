import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App 
{   
    public static void main(String[] args) throws Exception 
    {
        // Get the data of the json file, using the url
        API api = API.NASA; 

        String url = api.getUrl();
        var http = new ClientHttp();
        String json = http.takeData(url);

        // Extract some of the movies data, such as name, raking, image
        ExtractorData extractor = api.getExtractor();
        List<Cont> contents = extractor.extract(json);

        var maker_sticker = new StickersMakers(); 

        // Print the data and manipulate it
        for (Cont content : contents)
        { 
            // get the name of the arquive
            String name_arq = content.title();

            // Get the URL
            InputStream input_stream = new URL(content.url_image()).openStream();

            // Make the sticker and print to the terminal the name of the title's sticker
            maker_sticker.maker(input_stream, name_arq);
            System.out.println(content.title());
        }

        
    }
}