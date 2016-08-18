import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import factory.implMailApi.AppManagerApi;
import factory.implWebDriver.AppManagerWebDriver;
import factory.interfaces.AppManager;

public class BaseTest {

    AppManager app;

    //https://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
    @BeforeSuite
    @Parameters({"appType", "browser"})
    public void bfs(@Optional("selenium") String appType, @Optional("ch") String browser){
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

    @AfterSuite
    public void afs(){
        app.stop();
    }
}
