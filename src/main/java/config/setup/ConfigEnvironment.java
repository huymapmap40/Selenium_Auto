package config.setup;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConfigEnvironment {

    public String getEnvironment(String jsonKey) {
        JSONParser parser = new JSONParser();
        Object obj;
        String environmentValue = null;

        try {
            String currentDir = new File("src\\main\\java\\config").getAbsolutePath();
            obj = parser.parse(new FileReader(currentDir + "\\config.json"));
            JSONObject jsonObject = (JSONObject) obj;
            environmentValue = (String) jsonObject.get(jsonKey);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return environmentValue;
    }
}
