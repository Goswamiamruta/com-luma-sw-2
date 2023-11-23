package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    //Lunch the chrome browser
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //Click on ‘Sale’ Menu tab
        driver.findElement(By.linkText("Sale")).click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.linkText("Jackets")).click();
        //verify text
        String expectedText1 = "Jackets";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
        // verify that 12 products are displayed
        List<WebElement> list = driver.findElements(By.className("toolbar-amount"));
        list.size();
        System.out.println("Olivia 1/4 Zip Light Jacket");
        System.out.println("Juno Jacket");
        System.out.println("Neve Studio Dance Jacket");
        System.out.println("Nadia Elements Shell");
        System.out.println("Jade Yoga Jacket");
        System.out.println("Adrienne Trek Jacket");
        System.out.println("Inez Full Zip Jacket");
        System.out.println("Riona Full Zip Jacket");
        System.out.println("Ingrid Running Jacket");
        System.out.println("Augusta Pullover Jacket");
        System.out.println("Josie Yoga Jacket");
        System.out.println("Stellar Solar Jacket");

        //verify the text
        String expectedText = "12 Items";
        String actualText = driver.findElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}