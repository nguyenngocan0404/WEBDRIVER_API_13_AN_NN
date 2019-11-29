package automationfc.com;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Topic_04_Execute_Selenium_API_Handling_droplist {
WebDriver driver;
Select select;
String username = "";
String password = "";
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

}



@Test
public void TC_01_Handling_dropdownlist() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	select = new Select(driver.findElement(By.name("user_job1")));
	Assert.assertFalse(select.isMultiple());
	select.selectByVisibleText("Mobile Testing");
	Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
	select.selectByValue("mobile");
	Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
	select.selectByIndex(3);
	Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
	Assert.assertEquals(10, select.getOptions().size());
	select = new Select(driver.findElement(By.name("user_job2")));
	Assert.assertTrue(select.isMultiple());
	select.selectByVisibleText("Automation");
	select.selectByVisibleText("Mobile");
	select.selectByVisibleText("Desktop");
	List <WebElement> optionSelected = select.getAllSelectedOptions();
	List <String> arraySelected = new ArrayList<String>();
	for (WebElement select: optionSelected) {
		arraySelected.add(select.getText());
	}
	Assert.assertTrue(arraySelected.contains("Automation"));
	Assert.assertTrue(arraySelected.contains("Mobile"));
	Assert.assertTrue(arraySelected.contains("Desktop"));
	
	select.deselectAll();
}
@Test
public int randomNumber() {
	Random rand = new Random();
	return rand.nextInt(100000);
}
 
@Test
public void TC_02_Handling_dropdownlist() {
	driver.get("https://demo.nopcommerce.com/");
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	driver.findElement(By.xpath("//input[@value='M']")).click();
	driver.findElement(By.name("FirstName")).sendKeys("Nguyen");
	driver.findElement(By.name("LastName")).sendKeys("An");
	select = new Select(driver.findElement(By.name("DateOfBirthDay")));
	Assert.assertEquals(32, select.getOptions().size());
	select.selectByValue("1");
	select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
	Assert.assertEquals(13, select.getOptions().size());
	select.selectByValue("5");
	select = new Select(driver.findElement(By.name("DateOfBirthYear")));
	Assert.assertEquals(112, select.getOptions().size());
	select.selectByValue("1980");
	driver.findElement(By.name("Email")).sendKeys("nnan"+ randomNumber() + "@gmail.com.vn");
	driver.findElement(By.name("Company")).sendKeys("TMA");
	driver.findElement(By.name("Password")).sendKeys("123456");
	driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='register-button']")).click();
	String registerCompleted = driver.findElement(By.xpath("//div[@class='result']")).getText();
	Assert.assertEquals(registerCompleted, "Your registration completed");
	String account = driver.findElement(By.xpath("//a[@class='ico-account']")).getText();
	Assert.assertEquals(account, "My account");
	String logout = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
	Assert.assertEquals(logout, "Log out");
}
 




@AfterClass
public void afterClass() {
driver.quit();
}
 
}