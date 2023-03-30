public enum API {
    
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtractorIMDBData()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-05-05&end_date=2022-05-08", new ExtractorNasaData()),
    LANG("http://localhost:8080/lang", new ExtractorIMDBData());

    private String url;
    private ExtractorData extractor;

    API (String url, ExtractorData extractor)
    {
        this.url = url;
        this.extractor = extractor;
    }
 
    public String getUrl() {
        return url;
    }

    public ExtractorData getExtractor() {
        return extractor;
    }
}
