package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.data.Letter;
import test.factory.interfaces.InboxMail;
import test.pages.PageManager;

public class InboxMailWebDriver extends WebDriverBased implements InboxMail {
    public InboxMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public Letter openLetterBySubjectContains(String subject) {
        return null;
    }
}
