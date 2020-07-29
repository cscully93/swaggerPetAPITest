package apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class getPet {

    @Value("${pet.id}")
    protected String petId;

    @Value("${api.url}")
    protected String url;

    public String getUrl() {
        return url+petId;
    }
}
