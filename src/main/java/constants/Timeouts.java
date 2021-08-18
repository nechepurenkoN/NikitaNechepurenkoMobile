package constants;

import java.util.Properties;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Timeouts {

    private final String PROPERTIES_PATH = "/timeouts.properties";
    public Integer CLICKABLE;
    public Integer VISIBLE;

    static {
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties() {
        Properties properties = new Properties();
        properties.load(Timeouts.class.getResourceAsStream(PROPERTIES_PATH));
        CLICKABLE = Integer.parseInt((String) properties.get("clickable"));
        VISIBLE = Integer.parseInt((String) properties.get("visible"));
    }
}
