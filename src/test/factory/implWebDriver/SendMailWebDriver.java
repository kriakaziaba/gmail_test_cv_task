package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.factory.interfaces.SendMail;
import test.pages.PageManager;

/**
 * Created by tku on 8/15/2016.
 */
public class SendMailWebDriver extends WeDriverBased implements SendMail {
    public SendMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }
}
