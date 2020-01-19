package helpers;

import org.springframework.stereotype.Component;

@Component
public class verifyPet {

    private int id = 12345;
    private String categoryName = "Pet";
    private String petName = "Billy";
    private String status = "available";
    private String tagName = "Dog Tag";
    private String photoUrls = "sample.jpeg";

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getPetName() {
        return petName;
    }

    public String getStatus() {
        return status;
    }

    public String getTagName() {
        return tagName;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }
}
