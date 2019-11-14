package automationfc.com;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class Topic_02_Execute_Xpath_exercises {
WebDriver driver;
String username = "";
String password = "";
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

}

@BeforeMethod(description = "Chạy trước cho mỗi test bên dưới")
public void beforemethod() {
	driver.get("http://live.demoguru99.com/");
	driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	
}

@Test
public void TC_01_LoginWithEmptyEmailandPassword() {
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
	driver.findElement(By.xpath(".//button[@id='send2']")).click();
	
	String EmailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	Assert.assertEquals(EmailErrorMsg, "This is a required field.");
	
	String PassErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	Assert.assertEquals(PassErrorMsg, "This is a required field.");
}
 
@Test
public void TC_02_LoginWithInvalidEmail() {
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("12345@12345");
	driver.findElement(By.xpath("//button[@id='send2']")).click();
	
	String InvalidEmailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	Assert.assertEquals(InvalidEmailErrorMsg, "Please enter a valid email address. For example johndoe@domain.com.");

}
 
@Test
public void TC_03_LoginWithLessThan6Characters() {
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmai.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	driver.findElement(By.xpath("//button[@id='send2']")).click();
	
	String InvalidPasswordLessThan6Characters = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	Assert.assertEquals(InvalidPasswordLessThan6Characters, "Please enter 6 or more characters without leading or trailing spaces.");

}
 

@Test
public void TC_04_LoginWithIncorrectPassword() {
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmai.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123123");
	driver.findElement(By.xpath("//button[@id='send2']")).click();
	
	String WrongPassword = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//span[contains(text(),'Invalid login or password.')]")).getText();
	Assert.assertEquals(WrongPassword, "Invalid login or password.");

}

@Test
public void TC_05_LoginWithCorrectAccount() {
	driver.findElement(By.xpath("//form[@id='login-form']//span[contains(text(),'Create an Account')]")).click();
	driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("An");
	driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Ngoc");
	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Nguyen");
	driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("admin12311@gmai.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc@12345");
	driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("abc@12345");
	driver.findElement(By.xpath("//button[@title='Register']")).click();
	
	String SuccessMsg = driver.findElement(By.xpath("//div[@class='dashboard']//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
	Assert.assertEquals(SuccessMsg, "Thank you for registering with Main Website Store.");

}

@Test
public void TC_06_ReLoginWithCorrectAc() {
	driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();
	driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin12311@gmai.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc@12345");
	driver.findElement(By.xpath("//button[@id='send2']")).click();
	
	String WrongPassword = driver.findElement(By.xpath("//div[@class='col-main']//h1[text()='My Dashboard']")).getText();
	Assert.assertEquals(WrongPassword, "MY DASHBOARD");
	
	String WrongPassword = driver.findElement(By.xpath("//div[@class='col-main']//strong[text()='Hello, An Ngoc Nguyen!']")).getText();
	Assert.assertEquals(WrongPassword, "Hello, An Ngoc Nguyen!");
	
	String WrongPassword = driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'An Ngoc Nguyen')]")).getText();
	Assert.assertEquals(WrongPassword, "An Ngoc Nguyen");

}

@AfterClass
public void afterClass() {
driver.quit();
}
 
}