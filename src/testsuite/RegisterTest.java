package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    //Lunch the chrome browser
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void VerifyThatSignInPageDisplay(){
        //Find the create and account link on click on it
        driver.findElement(By.linkText("Create an Account")).click();
        String expectedText ="Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void UserShouldRegisterAccountSuccessfully(){
        //Find the create and account link on click on it
        driver.findElement(By.linkText("Create an Account")).click();
        //Enter first Name
        driver.findElement(By.id("firstname")).sendKeys("jeelu");
        //Enter last Name
        driver.findElement(By.id("lastname")).sendKeys("patel");
        //Enter Email
        driver.findElement(By.id("email_address")).sendKeys("jeelu123@gmail.com");
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("Amruta@12");
        //Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("Amruta@12");
        //Click on Create an Account button
        driver.findElement(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")).click();
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
      Assert.assertEquals(expectedText,actualText);
        //Click on down aero nearo Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();

        //click on sign out
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();

        //verify the text
        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText1, actualText1);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
