import data.Letter;
import data.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    User user1 = new User("luxofttest1001@gmail.com", "b55rkrgb13");
    User user2 = new User("luxofttest1002@gmail.com", "b55rkrgb13");

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
        Letter letter = app.getInboxMailHelper().openLetterBySubjectContains("Hello world");
        Assert.assertEquals(letter.message, messageExp);
    }

    @Test
    private void sendMail(){
        Letter letter = new Letter();
        letter.to = user1;
        letter.from = user2;
        letter.subject = "lolka";
        letter.message = "hi";
        app.getAuthHelper().loginAs(letter.from);
        app.getSendMailHelper().sendMail(letter);
    }
}
