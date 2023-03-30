import java.util.List;

// Making a interface to extract the json body
public interface ExtractorData {
    List<Cont> extract(String json);
}
