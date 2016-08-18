package pages;

import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChooseAnAccount extends BasePage {
    public ChooseAnAccount(RemoteWebDriver driver) {
        super(driver);
    }

    By h1 = By.cssSelector("div.HKjQUb>h1");

    public boolean isOnPage() {
        return driver.findElements(h1).size() == 1;
    }

    public void choose(User user) {
        driver.findElement(By.id("account-" + user.getMail())).click();
    }
}
