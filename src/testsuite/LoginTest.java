package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username and password elements and enter valid username and valid password
        driver.findElement(By.xpath("//input[@class='input_error form_input']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("Error", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.xpath("//input[@class='input_error form_input']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        //find number of items on page
        List<WebElement> displayedProductList = driver.findElements(By.className("inventory_item_name"));
        System.out.println("Total slides are: "+ displayedProductList.size());


       /* //Tag name Locator ---> to find multiple elements, here number of links on main page which will start with tag name "a" always
        List<WebElement> linksElements = driver.findElements(By.tagName("div"));
        System.out.println("Total number of links : "+ linksElements.size());
        for( WebElement link : linksElements){
            System.out.println("The links: "+ link.getText());
            System.out.println("The value of attributes : "+ link.getAttribute("class"));
        }*/
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}












