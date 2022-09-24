package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		 * 1.Load the URL https://www.amazon.in/ 2.search as oneplus 9 pro 3.Get
		 * the price of the first product 4. Print the number of customer
		 * ratings for the first displayed product 5. Click the first text link
		 * of the first image 6. Take a screen shot of the product displayed 7.
		 * Click 'Add to Cart' button 8. Get the cart subtotal and verify if it
		 * is correct. 9.close the browser
		 */
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("https://www.amazon.in/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// search as oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		// Print the price of the first product
		String price = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("Price of the first product : " + price);

		// Print the number of customer ratings for the first displayed product
		String customerRating = driver.findElement(By.xpath("//span[@class = 'a-size-base s-underline-text']"))
				.getText();
		System.out.println("The number of customer ratings for the first displayed product : " + customerRating);

		// Click the first text link of the first image
		driver.findElement(By
				.xpath("//a[@class = 'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"))
				.click();

		// Take a screen shot of the product displayed
		// Get the list of window/tab using getWindowsHandles
		Set<String> windowHandles = driver.getWindowHandles();
		// Convery the Set values to List to get single value
		List<String> windows = new ArrayList<String>(windowHandles);
		// Switch to the second window using get method
		driver.switchTo().window(windows.get(1));
		// Print the title of new tab
		System.out.println("Navigated tab title : " + driver.getTitle());

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/screenshot.png");
		FileUtils.copyFile(screenshotAs, destination);

		// Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();

		// Get the cart subtotal and verify if it is correct

		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-cart-count")).click();
		String subtotal = driver.findElement(By.id("sc-subtotal-label-buybox")).getText();
		if (subtotal.contains("1")) {
			System.out.println("Subtotal number is correct " + subtotal);
		} else {
			System.out.println("Subtotal number is wrong " + subtotal);
		}
		// Close the browser
		driver.quit();
	}

}
