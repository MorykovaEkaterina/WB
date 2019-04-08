import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EbayLoginTest {
    WebDriver wd;

    @BeforeTest
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }


    @Test
    public  void loginTest(){
        wd.get("https://www.ebay.com");

        wd.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        wd.findElement(By.xpath("//input[@id='userid']")).click();
        wd.findElement(By.xpath("//input[@id='userid']")).clear();
        wd.findElement(By.xpath("//input[@id='userid']")).sendKeys("username");

        wd.findElement(By.xpath("//input[@id='pass']")).click();
        wd.findElement(By.xpath("//input[@id='pass']")).clear();
        wd.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");

        wd.findElement(By.xpath("//button[@id='sgnBt']")).click();

    }

    @AfterTest
    public  void  tearDown(){
        wd.quit();

    }
}

