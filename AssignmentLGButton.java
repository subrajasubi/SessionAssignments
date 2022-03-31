package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLGButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		System.out.println(driver.getTitle());
		driver.navigate().to("http://leafground.com/pages/Button.html");
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("Location is" +location);
		String cssValue = driver.findElement(By.xpath("//button[text()='What color am I?']")).getCssValue("color");
	    System.out.println(cssValue);
        Dimension size = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
        System.out.println("Size is" +size);
	}

}
