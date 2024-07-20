package Opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.Duration;

public class SecurityTests {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();
        String filePathE = "D://USER DATA//SOFTWARES//java//Testing//src//test//java//Opencart//emailid";
        String filePathP = "D://USER DATA//SOFTWARES//java//Testing//src//test//java//Opencart//passwords";
        String logFilePath = "D://USER DATA//SOFTWARES//java//Testing//src//test//java//Opencart//testlog";

        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFilePath)))
        {
            // Define the URL of the website to test
            String url = "https://demo.nopcommerce.com/";

            // Navigate to the website
            driver.get(url);

            // Example of a login page where SQL injection could be tested
            driver.findElement(By.linkText("Log in")).click();

            // Wait until the login page is loaded
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("Email"))
            );

            // Read all lines from the email file
            List<String> emailLines = Files.readAllLines(Paths.get(filePathE));
            // Read all lines from the password file
            List<String> passwordLines = Files.readAllLines(Paths.get(filePathP));

            // Check if the number of emails matches the number of passwords
            if (emailLines.size() != passwordLines.size()) {
              logWriter.write("The number of email IDs does not match the number of passwords.\n");
               return;
            }

            // Iterate through each email and password combination
            for (int i = 0; i < emailLines.size(); i++) 
            {
                String email = emailLines.get(i);
                String password = passwordLines.get(i);

                // Find the email and password fields
                WebElement emailField = driver.findElement(By.id("Email"));
                WebElement passwordField = driver.findElement(By.id("Password"));

                // Clear the fields before inputting data
                emailField.clear();
                passwordField.clear();

                // Input the email and password
                emailField.sendKeys(email);
                passwordField.sendKeys(password);

                // Click the login button
                driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

                // Add a delay of 3 seconds between each login attempt
                Thread.sleep(3000);

                // Log the result
                String resultMessage = "Test case " + (i + 1) + ": Email = " + email + ", Password = " + password;

                // Check for successful login or error message
                if (driver.getCurrentUrl().contains("login")) {
                    resultMessage += " - Login failed";
                } else {
                    resultMessage += " - Login successful";
                    driver.navigate().back();
                }

                logWriter.write(resultMessage + "\n");
                System.out.println(resultMessage);

                // Navigate back to the login page for the next attempt
                driver.get(url);
                driver.findElement(By.linkText("Log in")).click();
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
