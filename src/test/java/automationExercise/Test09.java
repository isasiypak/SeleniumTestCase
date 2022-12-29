package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test09 {

    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");



    }

    //   1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {


        //            3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button

        WebElement products = driver.findElement(By.xpath("//*[@href='/products']"));
        products.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//div[@style='height: auto !important;']"));
        Assert.assertTrue(allProducts.isEnabled());
        //6. Enter product name in search input and click search button
        WebElement searchProduct = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchProduct.sendKeys("POLO", Keys.ENTER);
        WebElement button = driver.findElement(By.xpath("//*[@type='button']"));

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(searchedProduct.isDisplayed());

        //8. Verify all the products related to search are visible
    }

}








