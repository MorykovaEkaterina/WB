import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BankCvTest {
    WebDriver wd;

    @BeforeTest
    public void  setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public  void bankTest(){
        wd.get("https://cvbank.soft-gen.com/");

        wd.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

        wd.findElement(By.xpath("//input[@placeholder='email']")).click();
        wd.findElement(By.xpath("//input[@placeholder='email']")).clear();
        wd.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("cat@com.i");

        wd.findElement(By.xpath("//input[@placeholder='password']")).click();
        wd.findElement(By.xpath("//input[@placeholder='password']")).clear();
        wd.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("123456");

        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @AfterTest
    public void tearDown(){
        wd.quit();
    }
}
