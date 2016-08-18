package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStart extends BasePage {
    public GoogleStart(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div>a[href^='https://mail.google.com']")
    private WebElement linkGmail;

    public void goToGmail(){
        linkGmail.click();
    }
}
