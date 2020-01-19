package actions;

import apis.postPet;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = {"apis"})
public class postActions {

    @Autowired
    protected postPet pet;

    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private String url;
    private int actualStatus;
    private String requestBody;
    private String newName;


    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod()
    public void close() throws IOException {
        client.close();
        response.close();
    }

    public void buildAPI(){
        url = pet.getUrl();
        requestBody = pet.getRequestBody();
    }

    public void buildUpdateAPI(){
        url = pet.getUpdateNameUrl();
        newName = pet.getUpdateName();
    }

    public void postPet() throws IOException {
        setup();
        HttpPost request = new HttpPost(url);
         request.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        actualStatus = response.getStatusLine().getStatusCode();
        close();
        Assert.assertEquals(actualStatus, 200);
    }

    public void checkActualResult(){
        Assert.assertEquals(actualStatus, 200);
    }

    public void postPetUpdateName() throws IOException {
        setup();

        HttpPost request = new HttpPost(url);

        List<NameValuePair> updateName = new ArrayList<NameValuePair>();
        updateName.add(new BasicNameValuePair("name", newName));
        request.setEntity(new UrlEncodedFormEntity(updateName, HTTP.UTF_8));
        response = client.execute(request);
        actualStatus = response.getStatusLine().getStatusCode();
        close();

    }

}
