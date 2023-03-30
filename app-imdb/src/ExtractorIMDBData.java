import java.util.List;
import java.util.Map;

public class ExtractorIMDBData implements ExtractorData {
    
    public List<Cont> extract(String json)
    {
         // Extract some of the movies data, such as name, raking, image
         var jsonparser = new parser();
         List<Map<String, String>> atributes_list = jsonparser.parse(json); 

         // Populate lists's atributes
         return atributes_list.stream()
         .map((atributes) -> 
         {
             String title = atributes.get("title");
             String url_image = atributes.get("image");

             var content = new Cont(title, url_image);

             return content;
         })
         .toList();
    }
}
