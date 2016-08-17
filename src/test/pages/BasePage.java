package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

    RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
    }


}
