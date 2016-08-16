package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test
    private void login(){
        Assert.assertTrue(app.getAuthHelper().loginAs("login", "password"));
    }

    @Test
    private void readMail(){
        app.getAuthHelper().loginAs("login", "password");
        app.getInboxMailHelper().openLetterByIndex(0);
        app.getInboxMailHelper().openLetterBySubject("subject");
        Assert.assertEquals(app.getInboxMailHelper().getBody());
    }

    @Test
    private void sendMail(){
        app.getAuthHelper()
    }
}
