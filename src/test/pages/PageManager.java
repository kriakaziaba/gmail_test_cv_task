package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
    private WebDriver driver;
    public ChooseAnAccount chooseAnAccount;
    public GoogleStart googleStart;
    public AboutPage aboutPage;
    public Inbox inbox;
    public LetterPage letterPage;
    public Compose compose;
    public PasswordEnter passwordEnter;
    public SignIn signIn;

    public PageManager(RemoteWebDriver driver){
        this.driver = driver;
        chooseAnAccount = initElements(new ChooseAnAccount(driver));
        aboutPage = initElements(new AboutPage(driver));
        inbox = initElements(new Inbox(driver));
        letterPage = initElements(new LetterPage(driver));
        compose = initElements(new Compose(driver));
        passwordEnter = initElements(new PasswordEnter(driver));
        googleStart = initElements(new GoogleStart(driver));
        signIn = initElements(new SignIn(driver));
    }

    private <T extends BasePage> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }
}
