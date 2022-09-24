package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameLeafground {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("https://www.leafground.com/frame.xhtml");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to frame1
		WebElement frame1 = driver
				.findElement(By.xpath("//h5[text() =' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame1);
		// Click the button from frame1
		driver.findElement(By.xpath("//button[@id = 'Click']")).click();
		String buttonText = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("Current text from first button : " + buttonText);
		// come out of frame1
		driver.switchTo().defaultContent();

		// Switch to frame2
		WebElement frame2 = driver
				.findElement(By.xpath("//h5[text() =' How many frames in this page?']/following-sibling::iframe"));
		driver.switchTo().frame(frame2);
		// Get the text of the button
		String buttonText2 = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("button text from second frame : " + buttonText2);
		// come out of frame2
		driver.switchTo().defaultContent();

		// Switch to frame3
		WebElement frame3 = driver
				.findElement(By.xpath("//h5[text() =' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame3);
		// switch to the another frame inside frame3
		driver.switchTo().frame("frame2");
		// Click the button from frame3
		driver.findElement(By.xpath("//button[@id = 'Click']")).click();
		String buttonText3 = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("Current text from third button : " + buttonText3);
	}

}
