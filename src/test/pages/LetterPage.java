package pages;

import data.Letter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {
    public LetterPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='Bk'])[last()]//span[@class='go']")
    WebElement textFrom;

    @FindBy(xpath = "(//div[@class='Bk'])[last()]//span[@name='me']")
    WebElement textTo;

    public Letter getLetterInfo() {
        String subj;
        String from = textFrom.getText().replace("<","").replace(">","");
        String to = textFrom.getText().replace("<","").replace(">","");
        String message;
        Letter letter = new Letter()
    }
}
