package documentReview;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DriverFactory2 {

	@Test
	public  void run() throws InterruptedException,FileNotFoundException {
		RemoteWebDriver driver=new ChromeDriver();;
		
		try {		
		driver.get("http:www.google.com");
	    Thread.sleep(3000);
		System.out.println(driver);
		driver.findElement(By.name("s")).sendKeys("Selenium");		
		}
		catch(NoSuchElementException e){			
	     System.out.println("Exception "+ e);
	     throw new RuntimeException("Exception");
		}		
		driver.close();
	}
	
//  @Test
//	public  void test() {
//		RemoteWebDriver driver;
//			
//		 driver=new ChromeDriver();
//		 driver.get("www.google.com");
//		
//		driver.close();
//	}
}
