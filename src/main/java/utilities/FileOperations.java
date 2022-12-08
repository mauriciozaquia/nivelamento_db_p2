package utilities;

import java.io.*;
import java.util.Properties;

public class FileOperations {

    private static final String DIR_PATH_PROPERTIES =
            System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + "main" + File.separator + "resources" + File.separator + "properties" + File.separator;

    public static Properties getProperties(String fileName) {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            File file = new File(DIR_PATH_PROPERTIES + fileName + ".properties");
            inputStream = new FileInputStream(file);
            prop.load(inputStream);
            return prop;
        } catch (Exception e) {
            System.out.println("Passando exception " + e.getMessage());
        }
        return prop;
    }

    public static void setProperties(String fileName, String propKey, String propValue) {
        Properties prop = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties");
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
