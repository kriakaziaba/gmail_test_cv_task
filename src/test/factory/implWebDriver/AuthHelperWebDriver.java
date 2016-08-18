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
        driver.get("https://www.google.com.ua");
        pages.googleStart.goToGmail();
        if (pages.aboutPage.isOnPage()){
            pages.aboutPage.clickSingIn();
        }
        else if (pages.signIn.isOnPage()){
            pages.signIn.loginAs(user);
        }
        else if (pages.chooseAnAccount.isOnPage()){
            pages.chooseAnAccount.choose(user);
            pages.signIn.loginAs(user);
        }
        return pages.inbox.isOnPage();
    }

    @Override
    public void logOut() {
        pages.inbox.logOut();
    }
}
