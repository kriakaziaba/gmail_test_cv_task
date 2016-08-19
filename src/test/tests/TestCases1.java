package tests;

import data.Letter;
import data.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WorkWithFiles;

public class TestCases1 extends BaseTest {

    @BeforeMethod
    public void cleanUp(){
        app.preconditions();
    }

    @Test(dataProvider = "forAuth")
    private void login(User user){
        app.getAuthHelper().goToGmail();
        Assert.assertTrue(app.getAuthHelper().loginAsPositive(user));
    }


    @Test(dataProvider = "forRead")
    private void readMail(User user, String subj, String messageExp){
        app.getAuthHelper().goToGmail();
        app.getAuthHelper().loginAsPositive(user);
        Letter letter = app.getInboxMailHelper().openLetterBySubject(user, subj);
        Assert.assertEquals(letter.getMessage(), messageExp);
    }

    @Test(dataProvider = "sendFile")
    private void sendMail(Letter letterSend, String file){
        app.getAuthHelper().goToGmail();
        app.getAuthHelper().loginAsPositive(letterSend.getFrom());
        app.getSendMailHelper().sendMail(letterSend);
        app.getAuthHelper().logOut();
        app.getAuthHelper().changeUser();
        app.getAuthHelper().loginAsPositive(letterSend.getTo());
        Letter letterReceived = app.getInboxMailHelper().openLetterBySubject(letterSend.getTo(), letterSend.getSubject());
        Assert.assertEquals(letterReceived.getMessage(), letterSend.getMessage());
        Assert.assertEquals(letterReceived.getSubject(), letterSend.getSubject());
        Assert.assertEquals(letterReceived.getFrom(), letterSend.getFrom());
        Assert.assertEquals(letterReceived.getTo(), letterSend.getTo());
    }

    @Test(dataProvider = "sendFile")
    private void sendMailWithFile(Letter letterSend, String file){
        app.getAuthHelper().goToGmail();
        app.getAuthHelper().loginAsPositive(letterSend.getFrom());
        app.getSendMailHelper().sendMail(letterSend, file);
        app.getAuthHelper().logOut();
        app.getAuthHelper().changeUser();
        app.getAuthHelper().loginAsPositive(letterSend.getTo());
        Letter letterReceived = app.getInboxMailHelper().openLetterBySubject(letterSend.getTo(), letterSend.getSubject());
        String path = app.getInboxMailHelper().saveAttachedFile(letterReceived, letterSend.getTo());
        Assert.assertEquals(letterReceived.getMessage(), letterSend.getMessage());
        Assert.assertEquals(letterReceived.getSubject(), letterSend.getSubject());
        Assert.assertEquals(letterReceived.getFrom(), letterSend.getFrom());
        Assert.assertEquals(letterReceived.getTo(), letterSend.getTo());
        Assert.assertEquals(WorkWithFiles.getListLines(file).toArray(), WorkWithFiles.getListLines(path).toArray());
    }
}