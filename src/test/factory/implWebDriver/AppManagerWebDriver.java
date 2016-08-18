package factory.implWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import factory.interfaces.AppManager;
import factory.interfaces.AuthHelper;
import factory.interfaces.InboxMail;
import factory.interfaces.SendMail;
import pages.PageManager;
import utils.WorkWithFiles;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class AppManagerWebDriver implements AppManager {

    private PageManager pages;
    public static RemoteWebDriver driver;
    private AuthHelper authHelper;
    private InboxMail inboxMail;
    private SendMail sendMail;

    public AppManagerWebDriver(String browser){
        Properties props = new Properties();
        try {
            props.load(WorkWithFiles.class.getResourceAsStream("/project.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = props.getProperty("project.build.testOutputDirectory");
        String sep = System.getProperty("file.separator");
        String destFilePath = path + sep + "temp" + sep;

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", destFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap;
        switch (browser){
            case "ch":
                cap = DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(cap);
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            default:
                //todo add others are needed
                break;
        }
        pages = new PageManager(driver);
        authHelper = new AuthHelperWebDriver(driver, pages);
        inboxMail = new InboxMailWebDriver(driver, pages);
        sendMail = new SendMailWebDriver(driver, pages);
    }


    @Override
    public AuthHelper getAuthHelper() {
        return authHelper;
    }

    @Override
    public InboxMail getInboxMailHelper() {
        return inboxMail;
    }

    @Override
    public SendMail getSendMailHelper() {
        return sendMail;
    }

    @Override
    public void stop() {
        driver.quit();
    }
}