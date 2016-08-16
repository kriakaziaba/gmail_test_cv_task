package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.pages.PageManager;

/**
 * Created by DiR on 16.08.2016.
 */
public class WeDriverBased {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;
    private final Long EXPLICIT_WAIT = 10L;

    public WeDriverBased(RemoteWebDriver driver, PageManager pages){
        this.driver = driver;
        this.pages = pages;
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }
}
