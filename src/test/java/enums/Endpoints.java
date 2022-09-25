package enums;

public enum Endpoints {

    COSMETICS("/catalog/cosmetics/"),
    FAVORITES("/personal/favourites/");

    String endpoint;

    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
