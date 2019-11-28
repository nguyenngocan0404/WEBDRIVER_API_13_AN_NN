package automationfc.com;
 
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetText;
 
public class Topic_04_Execute_Selenium_API_Part_III {
WebDriver driver;
//Input data to new customer
String customerID;
String username = "mngr234594";
String password = "rUvUsUd";
String CustomerName = "An Nguyen";
String Gender = "male";
String DoB = "1993-05-21";
String Address = "10 PT";
String City = "HCM";
String State = "HCM";
String PIN = "700000";
String MobileNumber = "012345678";
String Email = "alohiphop" + randomNumber() + "@gmail.com";

//Input data to edit customer
String editAddress = "25 PT";
String editCity = "HN";
String ediState = "DN";
String ediPIN = "712345";
String ediMobileNumber = "0978643212";
String editEmail = "chennai" + randomNumber() + "@gmail.com";
By nameTextbox = By.name("name");
By genderRadio = By.xpath("//input[@value='m']");
By dobTextbox = By.xpath("//input[@id='dob']");
By editDoBTextbox = By.name("dob");
By addTextbox = By.xpath("//textarea[@name='addr']");
By cityTextbox = By.xpath("//input[@name='city']");
By stateTextbox = By.xpath("//input[@name='state']");
By pinTextbox = By.xpath("//input[@name='pinno']");
By phoneNumberTextbox = By.xpath("//input[@name='telephoneno']");
By emailTextbox = By.xpath("//input[@name='emailid']");
By passwordTextbox = By.name("password");



@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("http://demo.guru99.com/v4");
driver.findElement(By.name("uid")).sendKeys(username);
driver.findElement(By.name("password")).sendKeys(password);
driver.findElement(By.name("btnLogin")).click();
String WelcomeHomePagetext = driver.findElement(By.tagName("marquee")).getText();
Assert.assertEquals(WelcomeHomePagetext, "Welcome To Manager's Page of Guru99 Bank");
String Usernameshown = driver.findElement(By.xpath("//tr[@class='heading3']/td")).getText();
Assert.assertEquals(Usernameshown, "Manger Id : " + username);
}
@Test
public int randomNumber() {
	Random rand = new Random();
	return rand.nextInt(100000);
}
@Test
public void TC01_NewCustomer() {
	//Input data to new customer
	driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	driver.findElement(nameTextbox).sendKeys(CustomerName);
	driver.findElement(genderRadio).click();
	driver.findElement(dobTextbox).sendKeys(DoB);
	driver.findElement(addTextbox).sendKeys(Address);
	driver.findElement(cityTextbox).sendKeys(City);
	driver.findElement(stateTextbox).sendKeys(State);
	driver.findElement(pinTextbox).sendKeys(PIN);
	driver.findElement(phoneNumberTextbox).sendKeys(MobileNumber);
	driver.findElement(emailTextbox).sendKeys(Email);
	driver.findElement(passwordTextbox).sendKeys(password);
	driver.findElement(By.xpath("//input[@value='Submit']")).click();

	
	//Verify customer data
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer Registered Successfully!!!']")).isDisplayed());
	customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	System.out.println(customerID);
	Assert.assertEquals(customerID, driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText());
	Assert.assertEquals(CustomerName, driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
	Assert.assertEquals(DoB, driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
	Assert.assertEquals(Address, driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
	Assert.assertEquals(City, driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
	Assert.assertEquals(State, driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
	Assert.assertEquals(PIN, driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
	Assert.assertEquals(MobileNumber, driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
	Assert.assertEquals(Email, driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
}
@Test
public void TC02_EditCustomer() {
	driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	driver.findElement(By.name("cusid")).sendKeys(customerID);
	driver.findElement(By.name("AccSubmit")).click();
	//Verify value in edit customer page
	Assert.assertEquals(CustomerName, driver.findElement(nameTextbox).getAttribute("value"));
	Assert.assertEquals(DoB, driver.findElement(editDoBTextbox).getAttribute("value"));
	Assert.assertEquals(Address, driver.findElement(addTextbox).getText());
	Assert.assertEquals(Gender, driver.findElement(By.xpath("//input[@value='male']")).getAttribute("value"));
	Assert.assertEquals(City, driver.findElement(cityTextbox).getAttribute("value"));
	Assert.assertEquals(State, driver.findElement(stateTextbox).getAttribute("value"));
	Assert.assertEquals(PIN, driver.findElement(pinTextbox).getAttribute("value"));
	Assert.assertEquals(MobileNumber, driver.findElement(phoneNumberTextbox).getAttribute("value"));
	Assert.assertEquals(Email, driver.findElement(emailTextbox).getAttribute("value"));
	//Input new value 
	driver.findElement(addTextbox).clear();
	driver.findElement(addTextbox).sendKeys(editAddress);
	driver.findElement(cityTextbox).clear();
	driver.findElement(cityTextbox).sendKeys(editCity);
	driver.findElement(stateTextbox).clear();
	driver.findElement(stateTextbox).sendKeys(ediState);
	driver.findElement(pinTextbox).clear();
	driver.findElement(pinTextbox).sendKeys(ediPIN);
	driver.findElement(phoneNumberTextbox).clear();
	driver.findElement(phoneNumberTextbox).sendKeys(ediMobileNumber);
	driver.findElement(emailTextbox).clear();
	driver.findElement(emailTextbox).sendKeys(editEmail);
	driver.findElement(By.name("sub")).click();
	//Verify after edit sucessful
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer details updated Successfully!!!']")).isDisplayed());
	Assert.assertEquals(customerID, driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText());
	Assert.assertEquals(CustomerName, driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
	Assert.assertEquals(DoB, driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
	Assert.assertEquals(editAddress, driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
	Assert.assertEquals(editCity, driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
	Assert.assertEquals(ediState, driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
	Assert.assertEquals(ediPIN, driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
	Assert.assertEquals(ediMobileNumber, driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
	Assert.assertEquals(editEmail, driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
	
	
}

@AfterClass
public void afterClass() {
//driver.quit();
}
 
}