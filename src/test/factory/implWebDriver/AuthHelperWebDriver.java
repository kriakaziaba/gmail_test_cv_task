package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.factory.interfaces.AuthHelper;
import test.pages.PageManager;

/**
 * Created by tku on 8/15/2016.
 */
public class AuthHelperWebDriver extends WeDriverBased implements AuthHelper {
    public AuthHelperWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }
}
