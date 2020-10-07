package hsenid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browserdriver
{
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriver initializeDriver(String prop_file_path) throws IOException
    {
        prop = new Properties(); // creating a new variable to store Data.properties file
        FileInputStream fis = new FileInputStream(prop_file_path); // Loading data.properties filepath
        prop.load(fis); // Loading data.properties file into Properties Variable
        // Choosing Browser to run test, browser = data.properties --> browser
        String browserName = prop.getProperty("browser"); // Loading Browser name to start If Else Ladder
        int tym = Integer.parseInt(prop.getProperty("time")); // Loading expected implicit wait time

        /******************************************/
        /******** setting up the drivers path
         * we are creating an instance of the WebDriver interface and casting it to chromeDriver Class.
         * WebDriver is an interface, driver is a reference variable, chromeDriver() is a Constructor,
         * new is a keyword, and new chromeDriver() is an Object  ******/
        /*******************************************/

        if (browserName.equals("chrome")) // Code to run test in Chrome
        {
            String browserpath = prop.getProperty("chromepath"); // Loading Chrome driver file path in browser path
            System.setProperty("webdriver.chrome.driver", browserpath); // Loading Chromedriver
            driver = new ChromeDriver();
        }

        else if (browserName.equals("firefox")) // Code to Run Tests in Firefox
        {
            //Setup your IE BRowser Code here
            String browserpath = prop.getProperty("firefoxpath");
            System.setProperty("webdriver.gecko.driver", browserpath);
            driver = new FirefoxDriver();

        }

        else if (browserName.equals("IE")) // Code to run test in IE
        {
            //Setup your IE BRowser Code here
            String browserpath = prop.getProperty("iepath");
        }


        driver.manage().timeouts().implicitlyWait(tym,TimeUnit.SECONDS); /******* Implicit WAit******/

        return driver; // Returning driver to TestNG Suite to start the tests

    }
}
