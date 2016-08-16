package test.factory.implWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import test.factory.interfaces.SendMail;
import test.pages.PageManager;

import java.io.File;

public class SendMailWebDriver extends WeDriverBased implements SendMail {
    public SendMailWebDriver(RemoteWebDriver driver, PageManager pages) {
        super(driver, pages);
    }

    @Override
    public void sendMail(String to, String subject, String messageBody) {

    }

    @Override
    public void sendMailWithFile(String to, String subject, String messageBody, File file) {

    }
}
