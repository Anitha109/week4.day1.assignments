package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameChercherAssignments {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Switch to frame1
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id = 'topic']/following-sibling::input")).sendKeys("Selenium");
		// switch to frame3 (nested frame)
		driver.switchTo().frame("frame3");
		// Click the check box
		driver.findElement(By.id("a")).click();
		// come out of both frames (frame1 and frame3)
		driver.switchTo().defaultContent();
		// switch to frame2
		driver.switchTo().frame("frame2");
		// Choose value from dropdown
		WebElement animals = driver.findElement(By.className("col-lg-3"));
		Select dropdown = new Select(animals);
		dropdown.selectByVisibleText("Avatar");
	}

}
