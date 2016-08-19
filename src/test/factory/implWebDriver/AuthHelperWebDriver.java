package factory.implWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import data.User;
import factory.interfaces.AuthHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageManager;

public class AuthHelperWebDriver extends WebDriverBased implements AuthHelper {
    public AuthHelperWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public void goToGmail() {
        pages.googleStart.goToGmail();
    }

    @Override
    public boolean loginAsPositive(User user) {
        if (pages.aboutPage.isOnPage()){
            pages.aboutPage.clickSingIn();
        }

        if (pages.signIn.isOnPage()){
            pages.signIn.switchAccount();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Google']")));
    }

    @Override
    public void changeUser() {
        pages.signIn.switchAccount();
    }
}
