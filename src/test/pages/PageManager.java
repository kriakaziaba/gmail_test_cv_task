package test.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tku on 8/15/2016.
 */
public class PageManager {
    private RemoteWebDriver driver;
    public ChooseAnAccount chooseAnAccount;
    public HelpPage helpPage;
    public Inbox inbox;
    public Letter letter;
    public NewLetter newLetter;
    public PasswordEnter passwordEnter;

    public PageManager(RemoteWebDriver driver){
        this.driver = driver;
        chooseAnAccount = initElements(chooseAnAccount);
        helpPage = initElements(helpPage);
        inbox = initElements(inbox);
        letter = initElements(letter);
        newLetter = initElements(newLetter);
        passwordEnter = initElements(passwordEnter);
    }

    private <T extends BasePage> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }
}
