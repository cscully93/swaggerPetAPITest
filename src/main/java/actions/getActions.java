package actions;

import apis.getPet;
import helpers.jsonReader;
import helpers.verifyPet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@ComponentScan(basePackages = {"apis", "helpers"})
public class getActions {

    @Autowired
    protected getPet pet;
    @Autowired
    protected jsonReader jsonReader;
    @Autowired
    protected verifyPet verifyPet;

    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private int id;
    private String categoryName;
    private String petName;
    private String status;
    private String tagName;
    private String photoUrls;
    private String url;
    private int actualStatus;
    private JSONObject json;

    @Before
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @After
    public void close() throws IOException {
        client.close();
        response.close();
    }

    public void buildAPI() {
        url = pet.getUrl();
    }

    public void getPetById() throws IOException {
        setup();
        HttpGet request = new HttpGet(url);
        response = client.execute(request);
        actualStatus = response.getStatusLine().getStatusCode();
        json = new JSONObject(EntityUtils.toString(response.getEntity()));
        close();


    }

    public void checkStatus() {
        if (actualStatus == 200) {

            getPetDetails(json);

        } else if (actualStatus == 404) {
            System.out.println("404 returned, Pet has been successfully deleted");
        }
    }

    public void getPetDetails(JSONObject json) {

        id = (int) jsonReader.getValueFor(json, "id");
        JSONObject categoryObj = (JSONObject) jsonReader.getValueFor(json, "category");
        JSONArray tagObj = (JSONArray) jsonReader.getValueFor(json, "tags");
        JSONArray photoUrlObj = (JSONArray) jsonReader.getValueFor(json, "photoUrls");
        categoryName = (String) jsonReader.getValueFor(categoryObj, "name");
        petName = (String) jsonReader.getValueFor(json, "name");
        status = (String) jsonReader.getValueFor(json, "status");
        tagName = "";
        photoUrls = photoUrlObj.getString(0);

        for (int i = 0; i < tagObj.length(); i++) {
            JSONObject result = tagObj.getJSONObject(i);
            tagName = result.getString("name");
        }





    }
    public void printDetails(){
        System.out.println("*** Pet Details ***" + "\n"
                + "ID: " + id + "\n"
                + "Category Name: " + categoryName + "\n"
                + "Pet Name: " + petName + "\n"
                + "Status: " + status + "\n"
                + "Tag name: " + tagName + "\n"
                + "Photo URLs: " + photoUrls + "\n");
    }

    public void verifyPetDetails() {
        Assert.assertEquals(id, verifyPet.getId());
        Assert.assertEquals(categoryName, verifyPet.getCategoryName());
        Assert.assertEquals(petName, verifyPet.getPetName());
        Assert.assertEquals(status, verifyPet.getStatus());
        Assert.assertEquals(tagName, verifyPet.getTagName());
        Assert.assertEquals(photoUrls, verifyPet.getPhotoUrls());
    }

    public void writePetToFile() {
        String fileName = "data-created/pet-created.txt";
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println("*** Pet Created " + strDate + " ***" + "\n"
                    + "ID: " + id + "\n"
                    + "Category Name: " + categoryName + "\n"
                    + "Pet Name: " + petName + "\n"
                    + "Status: " + status + "\n"
                    + "Tag name: " + tagName + "\n"
                    + "Photo URLs: " + photoUrls + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
