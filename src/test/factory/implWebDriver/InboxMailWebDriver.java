package factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import data.Letter;
import factory.interfaces.InboxMail;
import pages.PageManager;

public class InboxMailWebDriver extends WebDriverBased implements InboxMail {
    public InboxMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public Letter openLetterBySubjectContains(String subject) {
        return null;
    }
}
