package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommonFunctions {

    Logger log = Logger.getLogger(CommonFunctions.class.getName());

    public int switchHttpRequest(String method) {
        int method_id = -1;
        switch (method) {
            case "Get":
                method_id = 0;
                break;
            case "Post":
                method_id = 1;
                break;
            case "Put":
                method_id = 2;
                break;
            case "Delete":
                method_id = 3;
                break;
        }
        return method_id;
    }

    public JsonObject LoadTestData() throws FileNotFoundException {

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error occurred", e);
        }
        String filepath = properties.getProperty("test.data.file.path");

        Gson gson = new Gson();
        JsonObject obj;
        obj = gson.fromJson(new FileReader(filepath), JsonObject.class);

        return obj;
    }
}
