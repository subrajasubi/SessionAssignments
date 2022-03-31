package week1.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLGLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
		WebElement withoutClick = driver.findElement(By.partialLinkText("Find where"));
		String attribute = withoutClick.getAttribute("href");
		System.out.println(attribute);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("404")) {
			System.out.println("Link is broken");
		}
		else {
			System.out.println("Not broken");
		}
		driver.navigate().back();
		String link1 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		String link2 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		if(link1.equals(link2)) {
			driver.navigate().to(link2);
			System.out.println("Element Interacted");
		}
		else {
			System.out.println("Not interacted");
			
		}
		
	    List<WebElement> tags = driver.findElements(By.tagName("a"));
	    int size = tags.size();
	    System.out.println(size);
	    driver.navigate().back();
		
	}

}
