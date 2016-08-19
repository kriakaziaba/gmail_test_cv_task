package pages;

import data.Letter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

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

    public void fillAndSend(Letter letter) {
        to.sendKeys(letter.getTo().getMail());
        subjectbox.sendKeys(letter.getSubject());
        txbMessage.sendKeys(letter.getMessage());
    }

    public void attachFile(String fileName) {
        inputFile.sendKeys(fileName);
    }
}
