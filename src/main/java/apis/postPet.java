package apis;

import org.springframework.stereotype.Component;

@Component
public class postPet {

    private String url = "https://petstore.swagger.io/v2/pet";

    private int petId = 12345;

    private String updateName ="Johnny";

    public String getUpdateName() {
        return updateName;
    }

    public String getUrl() {
        return url;
    }

    public String getUpdateNameUrl() {
        return url + "/" + petId;
    }

    public String getRequestBody() {
        return "{  \"id\": " + petId + ",\"category\": {\"id\": 1,\"name\": \"Pet\"},\"name\": \"Billy\",\"photoUrls\": [\"sample.jpeg\"],\"tags\": [{\"id\": 1,\"name\": \"Dog Tag\"}],\"status\":\"available\"}";
    }
}
