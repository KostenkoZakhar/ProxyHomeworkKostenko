package homeWork19;

import config.BaseProxyClass;
import net.lightbody.bmp.core.har.Har;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestYoutube extends BaseProxyClass {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//button[contains(@class,'icon-button') and contains(@class,'topbar-menu-button-avatar-button')]")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("no war");
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        File screenYoutubePage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenYoutubePage, new File("C:\\JAVA\\noWarScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
