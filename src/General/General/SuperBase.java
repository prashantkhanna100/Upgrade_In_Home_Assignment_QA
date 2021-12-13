package General;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * Common Methods for all Classes - Test, Page, Domain
 */
public class SuperBase {

    /**
     * Method to return any data saved in Properties file
     *
     * @param propertyName
     * @return
     */
    public static String getProperty(String propertyName) {
        final String propertyFilePath = "src/General/General/Framework.properties";
        Properties properties;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Framework.properties not found at " + propertyFilePath);
        }
        String url = properties.getProperty(propertyName);
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}