package utils;

import java.util.Properties;

public class PropConst {
    public static final String BASE_URL = "base.url";

    public static final String TYPE_BROWSER = "type.browser";

    public static final String PATH_CHROME_DRIVER_WINDOWS = "path.chrome.driver.windows";

    private final Properties properties = new Properties();
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
