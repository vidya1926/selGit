package newLearnings;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class RecordVideo {

	public static void main(String[] args) throws InterruptedException, IOException {
//		  ChromeOptions opt=new ChromeOptions();
//		  opt.addArguments("--headless");
		 ChromeDriver driver = new ChromeDriver();
		 
		        // Start recording using FFmpeg
		        Process ffmpeg = new ProcessBuilder(
		                "C:\\Users\\DELL\\Downloads\\ffmpeg-master-latest-win64-gpl\\ffmpeg-master-latest-win64-gpl\\bin\\ffmpeg.exe",
		                "-f", "gdigrab", // Screen capture input for Windows
		                "-framerate", "30", // Frame rate
		                "-i", "desktop", // Capture the entire screen
		                "-q:v", "1", // Quality setting
		                "output.mp4" // Output file
		        ).start();
		        // Setup Selenium WebDriver		       
		       
		        driver.get("http://leaftaps.com/opentaps/control/login");
	            // Login actions
	            driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	            driver.findElement(By.id("password")).sendKeys("crmsfa");
	            driver.findElement(By.className("decorativeSubmit")).click();
	            driver.findElement(By.linkText("CRM/SFA")).click();
		        // Stop recording and close browser
		        ffmpeg.destroy(); // Stop FFmpeg process
		        driver.quit();
		    }
		
}
