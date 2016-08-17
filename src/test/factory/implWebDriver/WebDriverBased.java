package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.pages.PageManager;

public class WebDriverBased {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;
    private final Long EXPLICIT_WAIT = 10L;

    public WebDriverBased(RemoteWebDriver driver, PageManager pages){
        this.driver = driver;
        this.pages = pages;
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }
}
