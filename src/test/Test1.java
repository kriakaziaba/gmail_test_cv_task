package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.data.Letter;

public class Test1 extends BaseTest {

    String mail1 = "luxofttest1001@gmail.com";
    String mail2 = "luxofttest1002@gmail.com";
    String password = "b5rkrgb13";

    @DataProvider
    public static Object[][] forAuth() {
        return new Object[][]{
                {"luxofttest1001@gmail.com", "b5rkrgb13"},
                {"luxofttest1002@gmail.com", "b5rkrgb13"}
        };
    }
    @DataProvider
    public static Object[][] forRead() {
        return new Object[][]{
                {"luxofttest1001@gmail.com", "b5rkrgb13", "la la la"},
                {"luxofttest1002@gmail.com", "b5rkrgb13", "blah blah blah"}
        };
    }

    @Test(dataProvider = "forAuth")
    private void login(String mail, String pwd){
        Assert.assertTrue(app.getAuthHelper().loginAs(mail, pwd));
    }


    @Test(dataProvider = "forRead")
    private void readMail(String mail, String pwd, String messageExp){
        app.getAuthHelper().loginAs(mail, pwd);
        Letter letter = app.getInboxMailHelper().openLetterBySubjectContains("Hello world");
        Assert.assertEquals(letter.message, messageExp);
    }

    @Test
    private void sendMail(){
        Letter letter = new Letter();
        letter.to = "luxofttest1001@gmail.com";
        letter.from = "luxofttest1002@gmail.com";
        letter.subject = "lolka";
        letter.message = "hi";
        app.getAuthHelper().loginAs(letter.from, "b5rkrgb13");
        app.getSendMailHelper().sendMail(letter);
    }
}
