package automationfc.com;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_05_Execute_Button_Checkbox_RadioButton_Alrt {
WebDriver driver;
JavascriptExecutor javascript;
Alert alert;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
javascript = (JavascriptExecutor) driver;
}
 
@Test
public void TC_01_Button() {
	driver.get("http://live.guru99.com/");
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	String loginPage = driver.getCurrentUrl();
	Assert.assertEquals(loginPage, "http://live.demoguru99.com/index.php/customer/account/login/");
	clickByJS("//span[text()='Create an Account']");
	//javascript.executeScript("argument[0].click();", driver.findElement(By.xpath("//span[text()='Create an Account']")));
	String registerPage =driver.getCurrentUrl();
	Assert.assertEquals(registerPage, "http://live.demoguru99.com/index.php/customer/account/create/");
}
 
@Test
public void TC_02_CheckBox() {
	String checkBoxInput = "//label[text()='Dual-zone air conditioning']/preceding-sibling::input";
	driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
	clickByJS(checkBoxInput);
	elementSelectedStatus(checkBoxInput);
	Assert.assertTrue(isElementSelected(checkBoxInput));
	clickByJS(checkBoxInput);
	elementSelectedStatus(checkBoxInput);
	Assert.assertFalse(isElementSelected(checkBoxInput));
	
}
@Test
public void TC_03_RadioButton() throws InterruptedException {
	String radioButtonInput = "//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input";
	driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
	clickByJS(radioButtonInput);
	Thread.sleep(5000);
	elementSelectedStatus(radioButtonInput);
	Assert.assertTrue(isElementSelected(radioButtonInput));
	
	
}

public void TC_05_HandleAlert() {
	String resultMessage = ("//p[@id='result']");
	driver.get("https://automationfc.github.io/basic-form/index.html");
	//Accept Alert
	driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "I am a JS Alert");
	alert.accept();
	Assert.assertEquals(driver.findElement(By.xpath(resultMessage)).getText(), "You clicked an alert successfully ");
	//Confirm Alert
	driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	alert =driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "I am a JS Confirm");
	alert.accept();
	Assert.assertEquals(driver.findElement(By.xpath(resultMessage)), "You clicked: Ok");
	//Prompt Alert
	driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	alert =driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "I am a JS Prompt");
	alert.sendKeys("12345");
	alert.accept();
	Assert.assertEquals(driver.findElement(By.xpath(resultMessage)), "You entered: 12345");
	
	
}

public void TC_06_AuthenticationAlert() {
	String username = "admin";
	String password = "admin";
	driver.get("http://the-internet.herokuapp.com");
	WebElement basicAuthLink = driver.findElement(By.xpath("//a[text()='Basic Auth']"));
	String url = basicAuthLink.getAttribute("href");
	PassAuthenticationAlert(url, username, password);
	Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	

	
	
}

public String PassAuthenticationAlert (String url, String username, String password) {
	String[] splitUrl = url.split("//");
	url = splitUrl[0] + "//" + username + ":" + password + splitUrl[1];
	return url;
	
	
}



public boolean isElementSelected(String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	if (element.isSelected()) {
		return true;
	}else {
		return false;
	}
}

public void clickByJS(String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	javascript.executeScript("arguments[0].click()", element);
	
}

public void elementSelectedStatus(String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	if (element.isSelected()) {
		System.out.println("Element is selected");
	}else {
		System.out.println("Element is deselected");
	}
	
}


 
@AfterClass
public void afterClass() {
driver.quit();
}
 
}