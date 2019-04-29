package config.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfig {

    private static BaseConfig instance;
    private static WebDriver driver;
    protected WebDriverWait wait;
    private String browserName;
    private String remoteAddress;

    public String getBrowserName() {
        return browserName;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public static void setDriver(WebDriver driver) {
        BaseConfig.driver = driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public static BaseConfig getInstance() {
        if(instance == null) {
            instance = new BaseConfig();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setUp() throws MalformedURLException {
        ConfigEnvironment environment = new ConfigEnvironment();
        setBrowserName(environment.getEnvironment("browserName"));
        setRemoteAddress(environment.getEnvironment("remoteAddress"));

        // Setup desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, getBrowserName());
        driver = new RemoteWebDriver(new URL(getRemoteAddress()), caps);
        wait = new WebDriverWait(driver, 15);
    }

    public void shutdown(){
        driver.quit();
    }
}
