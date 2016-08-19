package factory.implWebDriver;

import factory.interfaces.AppManager;
import factory.interfaces.AuthHelper;
import factory.interfaces.InboxMail;
import factory.interfaces.SendMail;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageManager;
import tests.BaseTest;

import java.util.HashMap;

public class AppManagerWebDriver implements AppManager {

    private PageManager pages;
    private RemoteWebDriver driver;
    private AuthHelper authHelper;
    private InboxMail inboxMail;
    private SendMail sendMail;

    public AppManagerWebDriver(String browser){
        DesiredCapabilities cap;
        switch (browser){
            case "ch":
                HashMap<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", BaseTest.downloadedDirectory);
                prefs.put("download.prompt_for_download", false);
                prefs.put("download.directory_upgrade", true);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setExperimentalOption("prefs", prefs);
                cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(cap);
                break;
            case "ff":
                FirefoxProfile ffProfile = new FirefoxProfile();
                ffProfile.setPreference("browser.download.folderList",2);
                ffProfile.setPreference("browser.download.manager.showWhenStarting", false);
                ffProfile.setPreference("browser.download.dir", BaseTest.downloadedDirectory);
                ffProfile.setPreference("webdriver.firefox.marionette", true);
                ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "*/*");
                cap = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(cap);
                driver.manage().window().maximize();
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

    @Override
    public void preconditions() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com.ua");
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com.ua");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.titleIs("Google"));
    }
}