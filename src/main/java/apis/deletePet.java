package apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class deletePet {

    @Value("${pet.id}")
    protected String petId;

    @Value("${api.url}")
    protected String url;

    public String getUrl() {
        return url+petId;
    }
}
