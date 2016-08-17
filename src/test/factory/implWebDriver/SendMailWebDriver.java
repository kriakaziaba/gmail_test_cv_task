package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.data.Letter;
import test.factory.interfaces.SendMail;
import test.pages.PageManager;

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
