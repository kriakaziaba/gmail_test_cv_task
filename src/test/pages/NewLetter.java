package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewLetter extends BasePage {
    public NewLetter(RemoteWebDriver driver) {
        super(driver);
    }

    WebElement to;

    WebElement subjectbox;

}
