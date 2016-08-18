package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Inbox extends BasePage {
    public Inbox(RemoteWebDriver driver) {
        super(driver);
    }

    By bntLogo = By.id("gbq1");

    @FindBy(css = "a.gb_b.gb_8a")
    WebElement linkAvatar;

    @FindBy(css = "div.gb_gb.gb_ga")
    WebElement popup;

    @FindBy(css = "a.gb_Fa.gb_Ce")
    WebElement btnExit;

    public boolean isOnPage() {
        return driver.findElements(bntLogo).size() == 1;
    }

    public void openLetterBySubject(String subject) {
        driver.findElement(By.xpath("//tbody/tr/td[position()=6 and contains(.,'" + subject + "')]")).click();
    }

    public void logOut() {
        linkAvatar.click();
        wait.until(ExpectedConditions.visibilityOf(popup));
        btnExit.click();
    }
}
