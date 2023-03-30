import java.util.List;
import java.util.Map;

public class ExtractorNasaData implements ExtractorData {
    
    public List<Cont> extract(String json)
    {
        // Extract some of the movies data, such as name, raking, image
        var jsonparser = new parser();
        List<Map<String, String>> atributes_list = jsonparser.parse(json); 

        return atributes_list.stream()
            .map((atributes) -> 
            {
                String title = atributes.get("title");
                String url_image = atributes.get("url");

                var content = new Cont(title, url_image);

                return content;
            })
            .toList();

    }
}
