package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }


}
