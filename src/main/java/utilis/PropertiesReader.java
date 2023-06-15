package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertiesReader {

    public static Map<String , String> propertiesReader (String filePath) throws IOException {
        Properties properties = new Properties();

        // Load the properties from a file
        properties.load(new FileInputStream(filePath));

        // Create a HashMap object
        HashMap<String, String> map = new HashMap<>();

        // Iterate over the properties and add them to the map
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }

        // Print the map

        return  map;

}
}
