package actions;

import apis.deletePet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.junit.Assert;
import org.junit.After;
import java.io.IOException;

@Component
@ComponentScan(basePackages = {"apis"})
@PropertySource("application.properties")
public class deleteActions {

    @Autowired
    protected deletePet pet;
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private String url;
    private int actualStatus;
    @Before
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @After()
    public void close() throws IOException {
        client.close();
        response.close();
    }

    public void buildAPI() {
        url = pet.getUrl();
    }

    public void deletePetById() throws IOException {
        setup();
        HttpDelete request = new HttpDelete(url);
        response = client.execute(request);
        actualStatus = response.getStatusLine().getStatusCode();
        close();
    }

    public void checkActualResult(){
        Assert.assertEquals(actualStatus, 200);

    }

}
