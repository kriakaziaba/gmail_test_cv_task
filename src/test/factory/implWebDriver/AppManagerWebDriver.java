package test.factory.implWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.factory.interfaces.AppManager;
import test.factory.interfaces.AuthHelper;
import test.factory.interfaces.InboxMail;
import test.factory.interfaces.SendMail;
import test.pages.PageManager;

public class AppManagerWebDriver implements AppManager {

    private PageManager pages;
    protected RemoteWebDriver driver;
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
}