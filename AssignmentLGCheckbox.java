package week1.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLGCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='example'][1]//input")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='example'][2]//input")).isEnabled());
		driver.findElement(By.xpath("//div[@class='example'][3]//input[2]")).click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//label[contains(text(),'below checkboxes ')]/following::input"));
		for (int i = 0; i < ele.size(); i++) {
//			boolean selected = ele.get(i).isSelected();
//			if(selected==false) {
				ele.get(i).click();
			}
		}

	}

//}
