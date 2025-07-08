package newLearnings;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {

	public static void main(String[] args) throws InterruptedException {
	
	
		String downloadFilepath = System.getProperty("user.dir") + "\\Files";
        new File(downloadFilepath).mkdirs(); // Create folder if it doesn't exist

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefs);

		// Launch browser
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Navigate to site
		driver.get("https://pontoon.mozilla.org/");

		// Click on 'Start Localizing Now'
		WebElement startLocalizingButton = driver.findElement(By.linkText("Start Localizing Now"));
		startLocalizingButton.click();

		// Enter 'India' in the filter
		WebElement filterInput = driver.findElement(By.xpath("//input[@placeholder='Filter teams']"));
		filterInput.sendKeys("India");

		// Click on 'Bengali (India)'
		WebElement bengaliIndiaLink = driver.findElement(By.linkText("Bengali (India)"));
		bengaliIndiaLink.click();

		// Click on download icon
		WebElement downloadIcon = driver.findElement(By.xpath("//i[@class='fas fa-cloud-download-alt']"));
		downloadIcon.click();

		// Click on 'Download Terminology'
		WebElement downloadTerminologyLink = driver.findElement(By.linkText("Download Terminology"));
		downloadTerminologyLink.click();

		// Wait for download to complete
		Thread.sleep(5000);

		driver.close();
}
}