package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import test.factory.implMailApi.AppManagerApi;
import test.factory.implWebDriver.AppManagerWebDriver;
import test.factory.interfaces.AppManager;

/**
 * Created by DiR on 15.08.2016.
 */
public class BaseTest {

    AppManager app;

    //https://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
    @BeforeSuite
    @Parameters({"appType"})
    public void bfs(String appType){
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
