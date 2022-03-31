package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssignment {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Subraja");
		driver.findElement(By.name("lastname")).sendKeys("Subi");
		driver.findElement(By.name("reg_email__")).sendKeys("9176027896");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Iniyan@123");
		WebElement day = driver.findElement(By.id("day"));
		Select sec = new Select(day);
		sec.selectByVisibleText("27");
		WebElement month = driver.findElement(By.id("month"));
		Select sec1 = new Select(month);
		sec1.selectByVisibleText("Nov");
		WebElement year = driver.findElement(By.id("year"));
		Select sec2 = new Select(year);
		sec2.selectByVisibleText("1992");
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

	}

}
