package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class Inbox extends BasePage {
    public Inbox(RemoteWebDriver driver) {
        super(driver);
    }

    By bntLogo = By.id("gbq1");

    public boolean isOnPage() {
        return driver.findElements(bntLogo).size() == 1;
    }

    public void openLetterBySubject(String subject) {
        driver.findElement(By.xpath("//tbody/tr/td[position()=6 and contains(.,'" + subject + "')]")).click();
    }
}
