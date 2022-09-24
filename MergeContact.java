package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		/*
		 * //Pseudo Code 1. Launch URL
		 * "http://leaftaps.com/opentaps/control/login" 2. Enter UserName and
		 * Password Using Id Locator 3. Click on Login Button using Class
		 * Locator 4. Click on CRM/SFA Link 5. Click on contacts Button 6. Click
		 * on Merge Contacts using Xpath Locator 7. Click on Widget of From
		 * Contact 8. Click on First Resulting Contact 9. Click on Widget of To
		 * Contact 10. Click on Second Resulting Contact 11. Click on Merge
		 * button using Xpath Locator 12. Accept the Alert 13. Verify the title
		 * of the page
		 */

		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter UserName Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// Enter Password Using Id Locator
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		// Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@class ='twoColumnForm']//a")).click();
		// Click on First Resulting Contact
		// Switch to the new window
		Set<String> windowHandles = driver.getWindowHandles();
		// Convery the Set values to List to get single value
		List<String> windows = new ArrayList<String>(windowHandles);
		// Switch to the second window using get method
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//table[@class = 'x-grid3-row-table']//a")).click();
		// Switch to parent window
		driver.switchTo().window(windows.get(0));
		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//table[@class ='twoColumnForm']//a)[2]")).click();
		// Click on First Resulting Contact
		// Switch to the new window
		Set<String> windowHandles1 = driver.getWindowHandles();
		// Convery the Set values to List to get single value
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		// Switch to the second window using get method
		driver.switchTo().window(windows1.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//table[@class = 'x-grid3-row-table'])[2]//a")).click();
		// Switch to parent window
		driver.switchTo().window(windows.get(0));
		// Click Merge button
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Verify the title of the page
		System.out.println(driver.getTitle());
	}

}
