package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test10 {

    /**
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Scroll down to footer
     5. Verify text 'SUBSCRIPTION'
     6. Enter email address in input and click arrow button
     7. Verify success message 'You have been successfully subscribed!' is visible
     */
    //1. Tarayıcıyı başlatın
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anasayfaGorunum = driver.findElement(By.xpath("//*[@lang='en'][1]"));
        Assert.assertTrue(anasayfaGorunum.isDisplayed());
        Thread.sleep(1000);
    }
    @Test
    public void test2() throws InterruptedException {
        //4. Altbilgiye doğru aşağı kaydırın
//           JavascriptExecutor js = (JavascriptExecutor) driver; //javascript classi
//           js.executeScript("window.scroll(0,10000)"); //console
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        //5. 'ABONELİK' metnini doğrulayın
        WebElement abonelikDogrulama = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(abonelikDogrulama.isDisplayed());
        Thread.sleep(1000);
    }
    @Test
    public void test3() throws InterruptedException {
        //6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("aysez123@gmail.com",Keys.TAB);
        driver.findElement(By.xpath("//*[@id='subscribe']")).click();
        //7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        WebElement basariliAbone = driver.findElement(By.xpath("//*[@class='alert-success alert']"));
        Assert.assertTrue(basariliAbone.isDisplayed());
        Thread.sleep(1000);
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
}

