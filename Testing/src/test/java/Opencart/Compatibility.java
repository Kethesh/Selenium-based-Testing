package Opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Compatibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); 
		WebDriver Driver = new FirefoxDriver();
		WebDriver Driver1 = new EdgeDriver();
		
		// lunching the website with different browser
		Driver.get("https://demo.nopcommerce.com/");
		driver.get("https://demo.nopcommerce.com/");
		Driver1.get("https://demo.nopcommerce.com/");
		
		//gathering data of website like title,URL,Pagesource
		//we r using different browser for different purpose
		//Firefox
		String Sub_title = Driver.getTitle();
		//chrome
		String currentUrl = driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		//microsoftEdge
		String windowHandle = Driver1.getWindowHandle();
		
		//printing the data 
		System.out.println("The Title is : \n");
		System.out.println(Sub_title);
		System.out.println("The current URL : \n");
		System.out.println(currentUrl);
		System.out.println("The pagesource : \n");
		System.out.println(pageSource);
		System.out.println("The Window Handel : \n");
		System.out.println(windowHandle);
		
		
	}

}
