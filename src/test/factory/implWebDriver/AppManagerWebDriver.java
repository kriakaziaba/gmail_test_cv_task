package factory.implWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import factory.interfaces.AppManager;
import factory.interfaces.AuthHelper;
import factory.interfaces.InboxMail;
import factory.interfaces.SendMail;
import pages.PageManager;

public class AppManagerWebDriver implements AppManager {

    private PageManager pages;
    public static RemoteWebDriver driver;
    private AuthHelper authHelper;
    private InboxMail inboxMail;
    private SendMail sendMail;

    public AppManagerWebDriver(String browser){
        switch (browser){
            default:
            case "ch":
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
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