package hsenid;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BMO_JUSTEAT_TESTNG extends Browserdriver
{
    public static WebDriver driver = null; // Declaring Global webdriver variable called 'driver' to run our tests in browsers
    // Please Enter your data.properties file path below
    // Location of Data.properties file SRC--> Test --> Java -->Utilities, right click on file and get file path and paste it below

    /********************/
    public static String prop_file_path = "C:\\Users\\anvesh\\IdeaProjects\\BMO_" +
            "JUST_EAT_PROJECT_TEST\\src\\test\\java\\Utilities\\data.properties";
    /********************/

    @BeforeTest // before starting tests we are invoking browser
    public void openbrowser() throws IOException
    {
        driver = Browserdriver.initializeDriver(prop_file_path); // Opening Selected Browser

    }

    @Test // Test--1 Opening Just Eat URL and validating its title
    public void openJustEatWebsite()
    {
        driver.get(prop.getProperty("url")); // Navigating to Selected URL
        System.out.println(driver.getTitle()); // Printing Title of page to validate the Navigated page
    }
    @Test (priority = 1) // Test--2 Finding SEarch bar and SEarching for given Postal code
    public void postalcodesearch() throws InterruptedException {

        driver.findElement(By.xpath(prop.getProperty("searchbar_xpath")))
                .sendKeys(prop.getProperty("postal_code")+ Keys.ENTER); // Locating Search bar and sending postal code as keys
        Thread.sleep(1000); // Waiting for Search to finish

    }
    @Test (priority = 2) // Test--3 Waiting for all Restaurants to open,
    // Scrolling up and Down once to load everything properly
    public void loadingallRestaurants() throws InterruptedException
    {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)"); // Scrolling all the way to the bottom to page
        Thread.sleep(1000); // Waiting for Restaurants to load
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(document.body.scrollHeight, 0)"); // Scrolling all the way to the top of page
        Thread.sleep(1000); // Waiting for Restaurants to load
        // Here These sleeps are very important since page is taking time to load all the restaurants.

    }
    @Test (priority = 3) // Test--4 Choosing the restaurant that customer wants to order
    public void ChoosingRestaurant() throws InterruptedException
    {
        //Locating the element of choosen restaurant
        WebElement Restaurant = driver.findElement(By.xpath(prop.getProperty("Choosen_Restaurant_Path")));
        // make choosen restaurant Scroll into the view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Restaurant);
        Restaurant.click(); // opening the selected restaurant
        Thread.sleep(1000);// Wait untill selected restaurant is open
    }
    @Test (priority = 4) // Test--5 Ordering a Beverage
    public void order_Drink()
    {
        // Selecting the customer choosen beverage/drink and selecting it
        driver.findElement(By.xpath(prop.getProperty("Selected_Drink_Xpath"))).click();
        // Opting for the Pick up or delievery, only happens first time you select an item and add it to cart
        driver.findElement(By.xpath("//a[contains(text(),\"I'm happy to collect my food\")]")).click();

    }
    @Test (priority = 5) //Test--6 Ordering Salad Bowl
    public void order_Salad() throws InterruptedException
    {
        //Selecting the customer choosen salald bowl
        driver.findElement(By.xpath(prop.getProperty("Selected_Salad_Xpath"))).click();
        Thread.sleep(1000); // Waiting for the additionla addons to pop up
        // Customising Customer Salad with his Choosen options
        // These Customizations can also be loaded through Data.properties file given enough time
        driver.findElement(By.xpath("//div[contains(text(),'Salad Options')]")).click();
        driver.findElement(By.xpath("//input[@class='submit resetExtras']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Sauce 1')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Caesar Sauce')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Cheese Options')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'No Cheese')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Extras? (Salad)')]")).click();
        driver.findElement(By.xpath("//input[@class='submit resetExtras']")).click();
        driver.findElement(By.xpath("//input[@class='submit']")).click();

    }
    @Test (priority = 6) // Test--7 Finally Checking out after customers adds everything to cart
    public void Checkout()
    {
        driver.findElement(By.xpath("//button[@class='checkoutButton']")).click(); // Check out button Locator
        // Once we select Check out customer is redirected to "I am Not Robot" Captcha
        // Automating Captcha in Live Production requires ManualIntervention or human response
        // After Checkout there is Scope for writing more Tests like Customer Login, Create a new account, Payment Card Details etc....

    }

    @AfterTest // After test is done Closing Browsers
    public void closebrowser() throws InterruptedException
    {
        Thread.sleep(2000); // Added this line so we can see results for a second before browser closes completely
        driver.close();
        driver=null;
    }
}
