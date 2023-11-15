package page;

public class UrlBuilder {
    private String baseUrl;

    public UrlBuilder() {

    }

    public UrlBuilder withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public String addApiEndpoint(String endpoint) {
        return baseUrl + endpoint;
    }

}