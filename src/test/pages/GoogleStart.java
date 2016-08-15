package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tku on 8/15/2016.
 */
public class GoogleStart extends BasePage {
    public GoogleStart(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div>a[href^='https://mail.google.com']")
    private WebElement linkGmail;

    public HelpPage goToGmail(){

    }
}
