package Framework.Utilitize;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// This class is used to read Config property file
public class ReadConfig {

    Properties properties;

    String Path = "C:\\Users\\deven\\IdeaProjects\\FrameWork\\Configuration\\config.properties";


    public ReadConfig() throws IOException {

        properties = new Properties();

        FileInputStream fis = new FileInputStream(Path);
        properties.load(fis);
    }

    public String getbaseURl() {
        String Value = properties.getProperty("baseUrl");
        if (Value != null) {
            return Value;
        } else {
            throw new RuntimeException("Url is not specified in config file");
        }
    }

    public String getBrowser() {
        String Value = properties.getProperty("browser");
        if (Value != null) {
            return Value;
        } else {
            throw new RuntimeException("browser is not specified in config file");
        }
    }

}
