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
        openSite("https://cvbank.soft-gen.com/");
        initLogin();
        fillLoginForm("cat@com.i", "123456");
        confirmLogin();
    }
    @AfterTest
    public void tearDown(){
        stop();
    }



    public void confirmLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillLoginForm(String email, String pwd) {
        type(By.xpath("//input[@placeholder='email']"), email);
        type(By.xpath("//input[@placeholder='password']"), pwd);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initLogin() {
        click(By.xpath("//button[contains(text(),'Log In')]"));
    }

    public void openSite(String url) {
        wd.get(url);
    }
    public void stop() {
        wd.quit();
    }


}
