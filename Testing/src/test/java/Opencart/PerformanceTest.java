package Opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

       try 
       {
            // Define the URL of the website to test
            String url = "https://demo.nopcommerce.com/";

            // Start time before navigating to the URL
            long startTime = System.currentTimeMillis();

            // Navigate to the website
            driver.get(url);

            // Wait until the page is fully loaded (customize the condition as needed)
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.urlToBe(url)
            );

            // End time after the page is loaded
            long endTime = System.currentTimeMillis();

            // Calculate the total load time
            long loadTime = endTime - startTime;

            // Print the load time
            System.out.println("Page Load Time: " + loadTime + " milliseconds");

        } 
        finally 
        {
            //Close the browser
            driver.quit();
        }
    }
}

