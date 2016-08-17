package factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import data.Letter;
import factory.interfaces.SendMail;
import pages.PageManager;

import java.io.File;

public class SendMailWebDriver extends WebDriverBased implements SendMail {
    public SendMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public void sendMail(Letter letter) {

    }

    @Override
    public void sendMail(Letter letter, File file) {

    }
}
