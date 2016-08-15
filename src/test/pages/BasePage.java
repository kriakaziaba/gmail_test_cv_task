package test.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by DiR on 15.08.2016.
 */
public class BasePage {

    RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
    }

}
