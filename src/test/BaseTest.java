package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

/**
 * Created by DiR on 15.08.2016.
 */
public class BaseTest {

    RemoteWebDriver driver;

    @BeforeSuite
    public void bfs(){
        driver = new ChromeDriver();

    }
}
