package apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class postPet {

    @Value("${pet.id}")
    protected String petId;

    @Value("${pet.name}")
    protected String petName;

    @Value("${pet.photo.url}")
    protected String photoUrl;

    @Value("${pet.tag}")
    protected String petTag;

    @Value("${pet.status}")
    protected String status;

    @Value("${api.url}")
    protected String url;

    @Value("${updated.name}")
    protected String updateName;

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
        return "{  \"id\": " + petId + ",\"category\": {\"id\": 1,\"name\": \"Pet\"},\"name\": \""+petName+"\",\"photoUrls\": [\""+photoUrl+"\"],\"tags\": [{\"id\": 1,\"name\": \""+petTag+"\"}],\"status\":\""+status+"\"}";
    }
}
