package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage {
    public AboutPage(RemoteWebDriver driver) {
        super(driver);
    }

    By linkSignIn = By.id("gmail-sign-in");

    public boolean isOnPage() {
        return driver.findElements(linkSignIn).size() == 1;
    }

    public void clickSingIn() {
        driver.findElement(linkSignIn).click();
    }
}
