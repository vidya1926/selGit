package newLearnings;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionStorage {

	public static void main(String[] args)  {
	
		  try {
			ChromeDriver driver = new ChromeDriver();
			  
			        // *** Step 1: Perform Login and Save Session Data ***
			        driver.get("http://leaftaps.com/opentaps/control/main");
			        // Login actions
			        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			        driver.findElement(By.id("password")).sendKeys("crmsfa");
			        driver.findElement(By.className("decorativeSubmit")).click();
			        driver.findElement(By.linkText("CRM/SFA")).click();	         	            
			        // Wait for login to complete
			        Thread.sleep(5000);
			        // Capture session storage data
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        List<String> sessionKeys = (List<String>) js.executeScript("return Object.keys(sessionStorage);");
			        try (FileWriter sessionFile = new FileWriter("sessionData.json")) {
			            for (String key : sessionKeys) {
			                String value = (String) js.executeScript("return sessionStorage.getItem(arguments[0]);", key);
			                sessionFile.write(key + "=" + value + "\n");
			            }
			            System.out.println("Session storage saved.");
			        }
			        // Capture cookies
			        try (FileWriter cookieFile = new FileWriter("cookies.json")) {
			            for (Cookie cookie : driver.manage().getCookies()) {
			                cookieFile.write(cookie.getName() + "=" + cookie.getValue() + "\n");
			            }
			            System.out.println("Cookies saved.");
			            }
			        
			        LearnStatic.loadUrl();
			        
			        // Close the browser after saving data
			        driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  

	        }
	

  }


