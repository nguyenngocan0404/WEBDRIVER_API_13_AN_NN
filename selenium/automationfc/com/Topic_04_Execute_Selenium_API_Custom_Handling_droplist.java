package automationfc.com;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_04_Execute_Selenium_API_Custom_Handling_droplist {
WebDriver driver;
Select select;
String username = "";
String password = "";
By numberAllItems = By.xpath("//select[@name='number']/option");
WebDriverWait waitExplicit;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

}



@Test
public void TC_01_Handling_dropdownlist() {
	driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	driver.findElement(By.xpath("//span[text()='2']")).click();
	List <WebElement> allItems = driver.findElements(numberAllItems);
	waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(numberAllItems));
	for (WebElement item : allItems) {
		System.out.println(item.getTagName());
		if(item.getText().equals("19")) {
			item.click();
			break;
		
		}
	}
	//Thread.sleep(5000);
	
}
@AfterClass
public void afterClass() {

}
 
}