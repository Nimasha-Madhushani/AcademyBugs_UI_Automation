package page;

public class ApiEndPoints {
    String baseUrl = "https://academybugs.com";
    UrlBuilder apiUrlBuilder = new UrlBuilder().withBaseUrl(baseUrl);

    public String getFindBugsEndPoint(){return apiUrlBuilder.addApiEndpoint("/find-bugs");}

    public String getStoreEndpoint() {
        return apiUrlBuilder.addApiEndpoint("/store");
    }

    public String getMyCartEndpoint() {
        return apiUrlBuilder.addApiEndpoint("/my-cart");
    }

}
