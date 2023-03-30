package config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.WorkWithFile;
import utils.WorkWithLogs;

import java.util.HashMap;
import java.util.Map;

public class BaseClass1 {
    public static WebDriver driver;
    public static Map<String,String> map=new HashMap<>();
    @BeforeClass
    public static void openChrome() {
        driver = DriverConfig.createDriver(Browsers.BROWSERMOBPROXY);
    }

    @AfterClass
    public static void closeChrome() throws InterruptedException {
     //   Thread.sleep(5000);
        WorkWithLogs.printLogs(driver);
        WorkWithFile.createFile("HillelLogs",WorkWithLogs.getLogEntries(driver));
        WorkWithFile.createFile("Map",map);
        driver.quit();
    }

}
