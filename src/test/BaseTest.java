package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.factory.implMailApi.AppManagerApi;
import test.factory.implWebDriver.AppManagerWebDriver;
import test.factory.interfaces.AppManager;

public class BaseTest {

    AppManager app;

    //https://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
    @BeforeSuite
    @Parameters({"appType"})
    public void bfs(@Optional("api") String appType){
        switch (appType){
            case "selenium":
                default:
                app = new AppManagerWebDriver("xuy");
                break;
            case "api":
                app = new AppManagerApi();
                break;
        }
    }
}
