package helpers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Component
public class jsonReader {

    public Object getValueFor(JSONObject jsonObject, String key){
        return jsonObject.get(key);
    }

}
