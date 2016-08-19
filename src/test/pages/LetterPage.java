package pages;

import data.Letter;
import data.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LetterPage extends BasePage {
    public LetterPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3.iw>span.gD")
    WebElement textFrom;

    @FindBy(xpath = "(//div[@class='Bk'])[last()]//span[@class='g2']")
    WebElement textTo;

    @FindBy(css = "h2.hP")
    WebElement textSubject;

    @FindBy(css = "div.a3s>div[dir=ltr]")
    WebElement textMessage;

    @FindBy(css = "a.aQy")
    WebElement linkAttachment;

    @FindBy(css = "div.aQv>div.aSK")
    WebElement btnDownload;

    @FindBy(css = "span.aV3.a6U")
    WebElement textAttachmentName;

    public Letter getLetterInfo() {
        wait.until(ExpectedConditions.visibilityOf(textSubject));
        String subj = textSubject.getText();
        String from = textFrom.getAttribute("email");
        String to = textTo  .getAttribute("email");
        String message = textMessage.getText();
        return new Letter(new User(to,""), new User(from,""), subj, message);
    }

    public String saveFile() {
        new Actions(driver).moveToElement(linkAttachment).click(btnDownload).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String fileName = textAttachmentName.getText();
        return BaseTest.downloadedDirectory + fileName;
    }
}
