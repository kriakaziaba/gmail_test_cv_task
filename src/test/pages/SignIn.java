package pages;

import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignIn extends BasePage {
    public SignIn(RemoteWebDriver driver) {
        super(driver);
    }

    By h1 = By.cssSelector("div.banner>h1");

    @FindBy(id = "Email")
    WebElement txbEmail;

    @FindBy(id = "next")
    WebElement next;

    @FindBy(id = "Passwd")
    WebElement txbPsw;

    @FindBy(id = "signIn")
    WebElement bntSignIn;

    @FindBy(id = "account-chooser-link")
    WebElement linkChangeAccount;

    @FindBy(id = "account-chooser-add-account")
    WebElement btnAddAccount;

    public boolean isOnPage() {
        return driver.findElements(h1).size() == 1;
    }

    public void loginAs(User user) {
        if (!bntSignIn.isDisplayed()) {
            txbEmail.sendKeys(user.getMail());
            next.click();
        }
        wait.until(ExpectedConditions.visibilityOf(txbPsw));
        txbPsw.sendKeys(user.getPassword());
        bntSignIn.click();
    }

    public void switchAccount() {
        if (driver.findElements(By.id("account-chooser-link")).size()>0) {
            linkChangeAccount.click();
            btnAddAccount.click();
        }
    }
}
