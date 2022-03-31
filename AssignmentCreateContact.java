package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCreateContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Subraja");
		driver.findElement(By.id("lastNameField")).sendKeys("Sivathanu");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Subi");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("S");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");
		WebElement description = driver.findElement(By.name("description"));
		System.out.println(description);
		description.sendKeys("Automation testing");
	    driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("subrajasubi@gmail.com");
		WebElement dropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select sec =new Select(dropdown);
		sec.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement desc = driver.findElement(By.name("description"));
		System.out.println(desc);
		desc.clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println(driver.getTitle());
		

	}

}
