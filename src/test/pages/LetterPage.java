package pages;

import data.Letter;
import data.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {
    public LetterPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='Bk'])[last()]//span[@class='go']")
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
        String subj = textSubject.getText();
        String from = textFrom.getText().replace("<","").replace(">","");
        String to = textTo  .getAttribute("email");
        String message = textMessage.getText();
        return new Letter(new User(to,""), new User(from,""), subj, message);
    }

    public String saveFile() {
        new Actions(driver).moveToElement(linkAttachment).click(btnDownload).perform();
        String fileName = textAttachmentName.getText();
        String path = driver.getCapabilities().getCapability("browser.download.folderlist").toString();
        return path + System.getProperty("file.separator") + fileName;
    }
}
