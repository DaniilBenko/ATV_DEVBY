package manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    private static Properties properties;
    private static String propertiesPath = "src/main/resources/application.properties";

    static {
        init();
    }

    private static void init() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            throw new PropertiesNotFoundException("Properties Not Found");
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
