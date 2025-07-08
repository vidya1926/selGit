package documentReview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoeHandling {

	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//getWindowHandle -> returns the current windowhandle
		String pWindowHandle = driver.getWindowHandle();
		System.out.println(pWindowHandle);
		
		//get the title of the parent window
		String pTitle = driver.getTitle();
		System.out.println("Parent title is : "+pTitle);
		
		try {
		driver.findElement(By.xpath("//span[text()='Ope']")).click();
		}catch(Exception e) {
			System.out.println("No Such Element Found");
			throw new RuntimeException(e);
		}
		//click on the open button
//		try {
//		driver.findElement(By.xpath("//span[text()='Ope']")).click();
//		}catch(Exception e) {
//			//driver.findElement(By.xpath("//span[text()='Open']")).click();
//		//getWindowHandles -> return Set<String>
//		Set<String> windowHandles = driver.getWindowHandles();
//		System.out.println("The total no: of windows : "+windowHandles.size());
//		 List<String> windowHandlesList = new ArrayList<String>(windowHandles);
//		
//		driver.switchTo().window(windowHandlesList.get(1));
//		//driver.switchTo().window(windowHandlesList.get(0));
//		}
		System.out.println("Child window title is : "+driver.getTitle());
	}
	
}
