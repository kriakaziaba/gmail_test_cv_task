package factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import data.User;
import factory.interfaces.AuthHelper;
import pages.PageManager;

public class AuthHelperWebDriver extends WebDriverBased implements AuthHelper {
    public AuthHelperWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public boolean loginAs(User user) {
        return false;
    }
}
