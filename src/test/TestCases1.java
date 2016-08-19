import data.Letter;
import data.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.WorkWithFiles;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class TestCases1 extends BaseTest {

    User user1 = new User("luxofttest1001@gmail.com", "b55rkrgb13");
    User user2 = new User("luxofttest1002@gmail.com", "b55rkrgb13");

    @DataProvider
    public Object[][] sendFile() {
        return new Object[][]{
                {user1, user2, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), "Hi", "D:\\temp\\gmail_test_cv_task\\target\\test-classes\\somefile"}
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
                {user1, "la la la"},
                {user2, "blah blah blah"}
        };
    }

    @Test(dataProvider = "forAuth")
    private void login(User user){
        Assert.assertTrue(app.getAuthHelper().loginAs(user));
    }


    @Test(dataProvider = "forRead")
    private void readMail(User user, String messageExp){
        app.getAuthHelper().loginAs(user);
        Letter letter = app.getInboxMailHelper().openLetterBySubject(user, "Hello world");
        Assert.assertEquals(letter.getMessage(), messageExp);
    }

    @Test(dataProvider = "sendFile")
    private void sendMail(User userFrom, User userTo, String subj, String body, String file){
        Letter letter = new Letter(userFrom, userTo, subj, body);
        app.getAuthHelper().loginAs(letter.getFrom());
        app.getSendMailHelper().sendMail(letter);
    }

    @Test(dataProvider = "sendFile")
    private void sendMailWithFile(User userFrom, User userTo, String subj, String body, String file){
        Letter letterSend = new Letter(userFrom, userTo, subj, body);
        app.getAuthHelper().loginAs(letterSend.getFrom());
        app.getSendMailHelper().sendMail(letterSend, file);
        app.getAuthHelper().logOut();
        app.getAuthHelper().loginAs(letterSend.getTo());
        Letter letterReceived = app.getInboxMailHelper().openLetterBySubject(letterSend.getTo(), subj);
        String path = app.getInboxMailHelper().saveAttachedFile(letterReceived);
        Assert.assertEquals(letterReceived.getMessage(), letterSend.getMessage());
        Assert.assertEquals(letterReceived.getSubject(), letterSend.getSubject());
        Assert.assertEquals(letterReceived.getFrom(), letterSend.getFrom());
        Assert.assertEquals(letterReceived.getTo(), letterSend.getTo());
        Assert.assertEquals(WorkWithFiles.getListLines(file).toArray(), WorkWithFiles.getListLines(letterReceived.getPathToAttachment(), file).toArray());
    }
}