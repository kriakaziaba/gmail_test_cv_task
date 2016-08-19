package factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import data.Letter;
import factory.interfaces.SendMail;
import pages.PageManager;

public class SendMailWebDriver extends WebDriverBased implements SendMail {
    public SendMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public void sendMail(Letter letter) {
        pages.inbox.compose();
        pages.compose.fill(letter);
        pages.compose.send();
    }

    @Override
    public void sendMail(Letter letter, String fileName) {
        pages.inbox.compose();
        pages.compose.fill(letter);
        pages.compose.attachFile(fileName);
        pages.compose.send();
    }
}
