package TestTrail;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testtrail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//performing click action on different elements
		//with a menu driven loop way
		WebDriver driver = new ChromeDriver();
		Scanner sc =new Scanner (System.in);
		//infinite for loop
		for(;;) 
		{
			
			System.out.println("enter the operation to \n 1.performing click action on logo (nopcommerce) "
					+ "\n 2. performing click action on Computers"
					+ "\n 3. performing click action on Electronics \n 4. performing click action on Apparel"
					+ "\n 5. performing click action on downloads \n 6.performing click action on books  "
					+ "\n 7.performing click action on jewelry  \n 8. performing click action on gift cards");
			
			int stage = sc.nextInt();
			// switching the stages and options
			//note we can use a variable of any data-type for switch case
			//hear i am choosing integer
			switch (stage) {
			case 1:
				//performing click action on logo (nopcommerce)
				driver.get("https://demo.nopcommerce.com/");
				String resultMessage;
				driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("logo")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 2:
				//performing click action on Computers
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Computers")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 3:
				//performing click action on Electronics
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Electronics")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 4:
				//performing click action on Apparel
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Apparel")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 5:
				//performing click action on downloads
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Digital downloads")) {
					resultMessage = "failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 6:
				//performing click action on books
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Books")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 7:
				//performing click action on jewelry
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Jewelry")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			case 8:
				//performing click action on gift cards
				driver.get("https://demo.nopcommerce.com/");
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")).click();
				//printing the result
				if (driver.getCurrentUrl().contains("Gift Cards")) {
					resultMessage = " failed";
				} else {
					resultMessage = " successful";
					driver.navigate().back();
				}
				System.out.println(resultMessage);
				break;
			 default:
	                System.out.println("Invalid day of the week");
	                break;
		/*
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		//performing click action on 
		driver.findElement(By.xpath("")).click();
		//performing click action on 
		driver.findElement(By.xpath("")).click();
				
		*/
	}
		}
}}
