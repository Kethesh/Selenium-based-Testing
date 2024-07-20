package Opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class CSRFTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Define the URL of the website to test
            String url = "https://demo.nopcommerce.com/";

            // Navigate to the website
            driver.get(url);

            // Wait until the login link is present and click it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in"))).click();

            // Wait for the login page to load and the email input to be present
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));

            // Find the input elements for email and password
            WebElement emailField = driver.findElement(By.id("Email"));
            WebElement passwordField = driver.findElement(By.id("Password"));

            // Input the credentials
            emailField.sendKeys("legitimate_user@example.com");
            passwordField.sendKeys("legitimate_password");

            // Submit the form
            driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

            // Wait until logged in
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-profile")));

            // Obtain the CSRF token (if it's available as a hidden field or in the page source)
            WebElement csrfTokenElement = driver.findElement(By.name("_csrf"));
            String csrfToken = csrfTokenElement.getAttribute("value");

            // Logout to simulate an unauthorized context
            driver.findElement(By.linkText("Logout")).click();

            // Attempt to perform an action using the CSRF token obtained earlier
            driver.navigate().to("https://demo.nopcommerce.com/perform_critical_action");
            driver.findElement(By.name("_csrf")).sendKeys(csrfToken);
            driver.findElement(By.name("other_param")).sendKeys("value");
            driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

            // Check if the action was successful or blocked
            boolean isCSRFSuccessful;
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-success")));
                isCSRFSuccessful = true;
            } catch (TimeoutException e) {
                isCSRFSuccessful = false;
            }

            if (isCSRFSuccessful) {
                System.out.println("Potential CSRF vulnerability found!");
            } else {
                System.out.println("No CSRF vulnerability detected.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


