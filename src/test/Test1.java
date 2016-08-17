package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.data.Letter;
import test.data.User;

public class Test1 extends BaseTest {

    @DataProvider
    public static Object[][] forAuth() {
        return new Object[][]{
                {new User("luxofttest1001@gmail.com", "b55rkrgb13")},
                {new User("luxofttest1002@gmail.com", "b55rkrgb13")}
        };
    }
    @DataProvider
    public static Object[][] forRead() {
        return new Object[][]{
                {new User("luxofttest1001@gmail.com", "b55rkrgb13"), "la la la"},
                {new User("luxofttest1002@gmail.com", "b55rkrgb13"), "blah blah blah"}
        };
    }

    @Test(dataProvider = "forAuth")
    private void login(User user){
        Assert.assertTrue(app.getAuthHelper().loginAs(user));
    }


    @Test(dataProvider = "forRead")
    private void readMail(User user, String messageExp){
        app.getAuthHelper().loginAs(user);
        Letter letter = app.getInboxMailHelper().openLetterBySubjectContains("Hello world");
        Assert.assertEquals(letter.message, messageExp);
    }

    @Test
    private void sendMail(){
        Letter letter = new Letter();
        letter.to = new User("luxofttest1001@gmail.com", "b55rkrgb13");
        letter.from = new User("luxofttest1002@gmail.com", "b55rkrgb13");
        letter.subject = "lolka";
        letter.message = "hi";
        app.getAuthHelper().loginAs(letter.from);
        app.getSendMailHelper().sendMail(letter);
    }
}
