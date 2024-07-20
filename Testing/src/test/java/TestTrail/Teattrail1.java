package TestTrail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Teattrail1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		//file path linking to a string
		String filePath = "D://USER DATA//SOFTWARES//java//Testing//src//test//java//TestTrail//listofelements";

        try 
        {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // testing each line/element from list/file
            for (String line : lines) {
            	
        		driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]")).sendKeys(line); 
        		
        		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
               
        		List<WebElement> addToCartButtons = driver.findElements(By.linkText("Add to cart"));

        		// Interact with the first "Add to cart" button (index 0)
        		if (!addToCartButtons.isEmpty()) 
        		{
        		     // Change the index to target a different button
        			addToCartButtons.get(0).click(); 

        		}
        		//adding delay or wait to observe the process
                Thread.sleep(30000);

            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            driver.quit();
        }
		
		//can also use the direct method without try and catch
		//driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]")).sendKeys("mac");
		//driver.findElement(By.linkText("Search")).click();
		//driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
	}

}
