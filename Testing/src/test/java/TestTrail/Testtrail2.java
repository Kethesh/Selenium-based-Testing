package TestTrail;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testtrail2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we r providing data for registration
		// note : for the mentioned website the below fields were  so we have taken these only
		//if u r doing it on different websit make sure u add necessary fields
		
		//using Scanner to take input
		Scanner sc= new Scanner(System.in);
		
		//taking name as input
		System.out.println("enter your first name");
		String Fname = sc.next();
		System.out.println("enter your second name");
		String Sname = sc.next();
		//taking email-id
		System.out.println("enter your emailid");
		String emailid = sc.next();
		//taking password
		System.out.println("enter your password");
		String password = sc.next();
		//conforming password
		System.out.println("enter your conform password");
		String conpassword = sc.next();
		
		
		//we r passing data to the site through browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		//clicking i=on register button
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		//after click successful we will pass the data
		//name
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(Fname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(Sname);
		//email-id
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailid);
		//password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		//conf-password
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(conpassword);
		//final submiton/registration
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
	}

}
