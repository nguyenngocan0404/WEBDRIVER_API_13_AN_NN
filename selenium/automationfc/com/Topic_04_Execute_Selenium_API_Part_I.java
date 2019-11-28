package automationfc.com;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class Topic_04_Execute_Selenium_API_Part_I {
WebDriver driver;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
}
@Test
public void TC01_Browser() {
	driver.get("http://live.demoguru99.com");
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	String LoginPage = driver.getCurrentUrl();
	System.out.println(LoginPage);
	Assert.assertEquals(LoginPage, "http://live.demoguru99.com/index.php/customer/account/login/");
	driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	String RegisterPage = driver.getCurrentUrl();
	System.out.println(RegisterPage);
	Assert.assertEquals(RegisterPage, "http://live.demoguru99.com/index.php/customer/account/create/");
	

}

@Test
public void TC02_Browser() {
	driver.get("http://live.demoguru99.com");
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	Assert.assertEquals(driver.getTitle(), "Customer Login");
	driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	
}

@Test
public void TC03_Browser() {
	driver.get("http://live.demoguru99.com");
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	driver.navigate().back();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
	driver.navigate().forward();
	Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	
}

@Test
public void TC04_Browser() {
	driver.get("http://live.demoguru99.com");
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
	driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
}
@AfterClass
public void afterClass() {
driver.quit();
}
 
}