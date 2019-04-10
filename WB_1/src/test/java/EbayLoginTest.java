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
        openSite("https://www.ebay.com");
        initLogin();
        fillLoginForm("username", "123456");
        confirmLogin();

    }

    @AfterTest
    public  void  tearDown(){
        stop();

    }

    public void confirmLogin() {
        click(By.xpath("//button[@id='sgnBt']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillLoginForm(String user, String pwd) {
        type(By.xpath("//input[@id='userid']"), user);
        type(By.xpath("//input[@id='pass']"), pwd);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initLogin() {
        click(By.xpath("//a[contains(text(),'Sign in')]"));
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void stop() {
        wd.quit();
    }
}

