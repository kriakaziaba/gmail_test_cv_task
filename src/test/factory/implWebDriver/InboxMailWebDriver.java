package factory.implWebDriver;

import data.User;
import org.openqa.selenium.remote.RemoteWebDriver;
import data.Letter;
import factory.interfaces.InboxMail;
import pages.PageManager;

public class InboxMailWebDriver extends WebDriverBased implements InboxMail {
    public InboxMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public Letter openLetterBySubject(User user, String subject) {
        pages.inbox.openLetterBySubject(subject);
        return pages.letterPage.getLetterInfo();
    }

    @Override
    public String saveAttachedFile(Letter letter) {
        return pages.letterPage.saveFile();
    }
}
