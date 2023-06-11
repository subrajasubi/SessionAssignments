package week7.day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnExplicitWait {
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='I am here']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println(ele.getText());

		driver.findElement(By.xpath("(//h5[text()='Wait for Invisibility (1 - 10 Sec)']/following::span)[2]")).click();
		//	WebElement ele2 = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='I am about to hide']"))));

		// Click on click first button 
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-warning')]")).click();
		// wait for 3 message to invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-growl ui-widget']")));
		// wait for click second button to click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click Second']")));
		driver.findElement(By.xpath("//span[text()='Click Second']")).click();
		
		// Click on last Click button
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-danger')]")).click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//button[contains(@class,'ui-button-danger')]/following::button"), "Did you notice?"));
		WebElement changableText = driver.findElement(By.xpath("//button[contains(@class,'ui-button-danger')]/following::button"));
		System.out.println(changableText.getText());


		driver.get("https://leafground.com/window.xhtml");
		// Click on the open with delay button
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		// Wait to open to 2windows --> (current window + 2 new open windows) = 3 
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		driver.quit();


	}

}
