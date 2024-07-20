import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new EdgeDriver();
driver.get("https://demo.nopcommerce.com/");
	String Sub_title = driver.getTitle();
	System.out.println(Sub_title);
	
	driver.findElement(By.id("logo"));
	System.out.println(" ");
	}

}
 
