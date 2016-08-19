package tests;

import data.Letter;
import data.User;
import org.testng.annotations.*;
import factory.implMailApi.AppManagerApi;
import factory.implWebDriver.AppManagerWebDriver;
import factory.interfaces.AppManager;
import utils.WorkWithFiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    AppManager app;
    public static String downloadedDirectory;

    User user1 = new User("luxofttest1001@gmail.com", "b55rkrgb13");
    User user2 = new User("luxofttest1002@gmail.com", "b55rkrgb13");

    //https://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
    @BeforeSuite
    @Parameters({"appType", "browser"})
    public void bfs(@Optional("selenium") String appType, @Optional("ch") String browser){
        downloadedDirectory = WorkWithFiles.directoryOfTest() + "downloadhere" + System.getProperty("file.separator");
        switch (appType){
            case "selenium":
                default:
                app = new AppManagerWebDriver(browser);
                break;
            case "api":
                app = new AppManagerApi();
                break;
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afs(){
        app.stop();
    }

    @DataProvider
    public Object[][] sendFile() {
        String subj = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        Letter letter = new Letter(user1, user2, subj, "Hi");
        return new Object[][]{
                {letter, WorkWithFiles.directoryOfTest() + "somefile"}
        };
    }

    @DataProvider
    public Object[][] forAuth() {
        return new Object[][]{
                {user1},
                {user2}
        };
    }
    @DataProvider
    public Object[][] forRead() {
        return new Object[][]{
                {user1, "Hello world amiga", "la la la"},
                {user2, "Hello world amigo", "blah blah blah"}
        };
    }
}
