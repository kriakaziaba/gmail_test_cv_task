package pages;

import data.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Compose extends BasePage {
    public Compose(RemoteWebDriver driver) {
        super(driver);
    }

    WebElement to;

    WebElement subjectbox;

    @FindBy(css = "div.Am.Al")
    WebElement txbMessage;

    @FindBy(xpath = "//input[@type='file']")
    WebElement inputFile;

    @FindBy(css = "div.a1.aaA.aMZ")
    WebElement btnAttachFile;

    @FindBy(css = "div.aoO")
    WebElement btnSend;

    @FindBy(css = "div.nH div.vh")
    WebElement blockMessageSend;

    By fileAttached = By.name("attach");

    public void fill(Letter letter) {
        to.sendKeys(letter.getTo().getMail());
        subjectbox.sendKeys(letter.getSubject());
        txbMessage.sendKeys(letter.getMessage());
    }

    public void attachFile(String fileName) {
        btnAttachFile.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputFile.sendKeys(fileName);
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(fileAttached));
    }

    public void send() {
        btnSend.click();
        wait.until(ExpectedConditions.visibilityOf(blockMessageSend));
    }
}
