package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.data.User;
import test.factory.interfaces.AuthHelper;
import test.pages.PageManager;

public class AuthHelperWebDriver extends WebDriverBased implements AuthHelper {
    public AuthHelperWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public boolean loginAs(User user) {
        return false;
    }
}
