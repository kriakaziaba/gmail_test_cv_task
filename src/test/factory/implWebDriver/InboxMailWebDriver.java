package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.factory.interfaces.InboxMail;
import test.pages.PageManager;

/**
 * Created by tku on 8/15/2016.
 */
public class InboxMailWebDriver extends WeDriverBased implements InboxMail {
    public InboxMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }
}
