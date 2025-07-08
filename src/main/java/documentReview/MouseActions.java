package documentReview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
   
	public static void main(String[] args) {		
	
		ChromeDriver driver=new ChromeDriver();
        // Navigate to the web page
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		//locate the WebElement
		WebElement eleMen = driver.findElement(By.linkText("MEN"));
		//Instantiate Actions class
		Actions builder = new Actions(driver);
		//to mouse hover on a WebElement
		builder.moveToElement(eleMen).perform();
		
//		
//		WebElement inputField = driver.findElement(By.id("input"));
//		Actions actions = new Actions(driver);
//		actions.click(inputField)
//		        .keyDown(Keys.SHIFT)
//		       .sendKeys("selenium")
//		       .keyUp(Keys.SHIFT)
//		       .perform();

		
			WebElement slider = driver.findElement(By.id("slider"));
			Actions actions = new Actions(driver);
			actions.clickAndHold(slider)
			       .moveByOffset(50, 0)
			       .release()
			       .perform();

      
	}

}
