package apis;

import org.springframework.stereotype.Component;

@Component
public class deletePet {

    private int petId = 12345;
    private String url = "https://petstore.swagger.io/v2/pet/"+petId;

    public String getUrl() {
        return url;
    }
}
