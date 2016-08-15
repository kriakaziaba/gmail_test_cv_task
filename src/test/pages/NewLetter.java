package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by DiR on 15.08.2016.
 */
public class NewLetter extends BasePage {
    public NewLetter(RemoteWebDriver driver) {
        super(driver);
    }

    WebElement to;

    WebElement subjectbox;

}
