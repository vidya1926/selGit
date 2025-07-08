package documentReview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverFactory {

	@Test
	public  void run() {		
		ChromeDriver driver=new ChromeDriver();
		System.out.println(driver);
	}

}
