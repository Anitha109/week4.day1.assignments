package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindowAssignment {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("https://www.leafground.com/window.xhtml");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("j_idt88:new")).click();
		// Switch to the new window
		Set<String> windowHandles = driver.getWindowHandles();
		// Convery the Set values to List to get single value
		List<String> windows = new ArrayList<String>(windowHandles);
		// Switch to the second window using get method
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		System.out.println("Title of New window : " + driver.getTitle());
		// Switch to parent window
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		// window handles
		Set<String> windowHandles1 = driver.getWindowHandles();
		// get the number of opened tabs and print
		System.out.println("Number of opened tabs : " + windowHandles1.size());
		// Switch to parent window
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		// window handles for new windows and close all other than parent window
		String originalHandle = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
		driver.findElement(By.id("j_idt88:j_idt95")).click();

	}

}
