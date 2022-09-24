package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAssignment {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Handling Alert - simple Dialog
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		String simpleText = driver.findElement(By.id("simple_result")).getText();
		System.out.println("text after the handling simple Dialog : " + simpleText);

		// Handling Alert - Confirm Dialog
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.dismiss();
		String confirmText = driver.findElement(By.id("result")).getText();
		System.out.println("text after the handling Confirm Dialog : " + confirmText);

		// Handling Sweet Alert - Simple Dialog
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		String alertText = driver.findElement(By.xpath("//div[@id = 'j_idt88:j_idt96']//p")).getText();
		System.out.println("Text in alert : " + alertText);
		driver.findElement(By.id("j_idt88:j_idt98")).click();

		// Handling Sweet Modal Dialog
		driver.findElement(By.id("j_idt88:j_idt100")).click();
		String modalText = driver.findElement(By.xpath("//div[@id = 'j_idt88:j_idt101']//p")).getText();
		System.out.println("Text in alert : " + modalText);
		driver.findElement(By.xpath("//div[@id = 'j_idt88:j_idt101']//a")).click();
		driver.findElement(By.xpath("//div[@id = 'j_idt88:j_idt101']//a")).click();

		// Handling Alert (Prompt Dialog)
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Anitha");
		promptAlert.accept();
		String promptText = driver.findElement(By.id("confirm_result")).getText();
		System.out.println("text after the handling Confirm Dialog : " + promptText);

		// Handling Sweet Alert (Confirmation)
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		String sweetText = driver
				.findElement(By.xpath("//div[@id = 'j_idt88:j_idt107'] //span[@class = 'ui-confirm-dialog-message']"))
				.getText();
		System.out.println("Text in alert : " + sweetText);
		driver.findElement(By.id("j_idt88:j_idt108")).click();

		// Handling Sweet Alert (Minimize and Maximize)
		driver.findElement(By.id("j_idt88:j_idt111")).click();
		String alertTitle = driver.findElement(By.id("j_idt88:j_idt112_title")).getText();
		System.out.println("Title of the alert : " + alertTitle);
		// minimus the alert
		driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-minus']")).click();
		driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-plus']")).click();
	}

}
