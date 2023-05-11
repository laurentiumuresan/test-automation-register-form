package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumUtils {
    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
        switch (getBrowserEnumFromString(browserType)) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case FIREFOX, MOZILLA -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case IE -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
        }
        return driver;
    }

    public static Browsers getBrowserEnumFromString(String browserType) {
        for (Browsers browser : Browsers.values()) {
            if (browserType.equalsIgnoreCase(browser.toString())) {
                return browser;
            }
        }
        return null;
    }

    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
