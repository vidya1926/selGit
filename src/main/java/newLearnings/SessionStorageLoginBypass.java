package newLearnings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionStorageLoginBypass {

    public static void main(String[] args) throws IOException, InterruptedException {
      

            // *** Step 2: Restore Session and Skip Login ***
            ChromeDriver newDriver = new ChromeDriver();
           newDriver.get("http://leaftaps.com/opentaps/control/login");

            // Restore session storage
            BufferedReader sessionReader = new BufferedReader(new FileReader("sessionData.json"));
            String sessionLine;
            while ((sessionLine = sessionReader.readLine()) != null) {
                String[] sessionParts = sessionLine.split("=", 2);
                ((JavascriptExecutor) newDriver).executeScript(
                    "sessionStorage.setItem(arguments[0], arguments[1]);", sessionParts[0], sessionParts[1]);
            }
            sessionReader.close();

            // Restore cookies
            BufferedReader cookieReader = new BufferedReader(new FileReader("cookies.json"));
            String cookieLine;
            while ((cookieLine = cookieReader.readLine()) != null) {
                String[] cookieParts = cookieLine.split("=", 2);
                Cookie cookie = new Cookie(cookieParts[0], cookieParts[1]);
                newDriver.manage().addCookie(cookie);
            }
            cookieReader.close();
            // Refresh the page to apply session and cookies
            newDriver.navigate().to("http://leaftaps.com/crmsfa/control/main");
           Thread.sleep(3000);
            newDriver.findElement(By.linkText("Leads")).click();

            // Validate the result
            if (newDriver.getCurrentUrl().contains("crmsfa/control")) {
                System.out.println("Login skipped successfully!");
            } else {
                System.out.println("Login page is still displayed. Debug further.");
            }

            WebDriver newWindow = newDriver.switchTo().newWindow(WindowType.TAB);
            newWindow.get("http://www.amazon.in");
            // Close the browser
            newDriver.quit();

        } }