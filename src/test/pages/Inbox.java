package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Inbox extends BasePage {
    public Inbox(RemoteWebDriver driver) {
        super(driver);
    }

    By btnLogo = By.id("gbq1");

    @FindBy(id = "gbq1")
    WebElement btnLogoElement;

    @FindBy(css = "a.gb_b.gb_8a")
    WebElement linkAvatar;

    @FindBy(css = "div.gb_gb.gb_ga")
    WebElement popup;

    @FindBy(css = "a.gb_Fa.gb_Ce")
    WebElement btnExit;

    @FindBy(css = "div.z0>div")
    WebElement btnCompose;

    @FindBy(css = "div.Hd")
    WebElement popupCompose;

    public boolean isOnPage() {
        return wait.until(not(stalenessOf(driver.findElement(btnLogo))));
    }

    public void openLetterBySubject(String subject) {
        int i = 0;
        while (i++<5) {
            try {
                driver.findElement(By.xpath("//tbody/tr/td[position()=6 and contains(.,'" + subject + "')]")).click();
                return;
            } catch (NoSuchElementException|ElementNotVisibleException ignore) {
                driver.navigate().refresh();
            }
        }
    }

    public void logOut() {
        linkAvatar.click();
        wait.until(ExpectedConditions.visibilityOf(popup));
        btnExit.click();
    }

    public void compose() {
        btnCompose.click();
        wait.until(ExpectedConditions.visibilityOf(popupCompose));
    }
}
