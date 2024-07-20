package Opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductSearchTest {
    public static void main(String[] args) {
        // Set the path to the Microsoft Edge WebDriver executable
        //System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");

        // Initialize the WebDriver (Edge in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Define the URL of the website to test
            String url = "https://demo.opencart.com/";

            // Navigate to the website
            driver.get(url);

            // List of keywords to test
            String[] keywords = {"laptop", "phone", "camera", "tablet"};

            for (String keyword : keywords) {
                // Perform a search for the keyword
                performSearch(driver, keyword);

                // Validate search results
                validateSearchResults(driver, keyword);

                // Apply filtering and sorting options
                applyFiltersAndSort(driver);
            }

        } finally {
            // Close the browser
            //driver.quit();
        }
    }

    private static void performSearch(WebDriver driver, String keyword) {
        // Wait for the search bar to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Search")));

        // Find the search bar and input the keyword
        WebElement searchBar = driver.findElement(By.name("Search"));
        searchBar.clear();
        searchBar.sendKeys(keyword);
        searchBar.submit();
    }

    private static void validateSearchResults(WebDriver driver, String keyword) {
        // Wait for the search results to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-thumb")));

        // Find the search results elements
        List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));

        // Validate that search results are displayed
        if (results.isEmpty()) {
            System.out.println("No results found for keyword: " + keyword);
        } else {
            System.out.println("Results found for keyword: " + keyword);
        }
    }

    private static void applyFiltersAndSort(WebDriver driver) {
        // Apply a filter (e.g., by category)
        // Note: Adjust the selectors based on the actual structure of the website
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryFilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        categoryFilter.click();

        // Apply sorting options (e.g., price low to high)
        WebElement sortOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        sortOption.click();
        WebElement sortOptionValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search']")));
        sortOptionValue.click();
    }
}
