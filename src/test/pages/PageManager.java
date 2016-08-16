package test.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
    private RemoteWebDriver driver;
    public ChooseAnAccount chooseAnAccount;
    public HelpPage helpPage;
    public Inbox inbox;
    public LetterPage letterPage;
    public NewLetter newLetter;
    public PasswordEnter passwordEnter;

    public PageManager(RemoteWebDriver driver){
        this.driver = driver;
        chooseAnAccount = initElements(chooseAnAccount);
        helpPage = initElements(helpPage);
        inbox = initElements(inbox);
        letterPage = initElements(letterPage);
        newLetter = initElements(newLetter);
        passwordEnter = initElements(passwordEnter);
    }

    private <T extends BasePage> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }
}
