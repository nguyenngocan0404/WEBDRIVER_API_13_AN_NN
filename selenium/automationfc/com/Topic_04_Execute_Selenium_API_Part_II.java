package automationfc.com;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
@Test
public class Topic_04_Execute_Selenium_API_Part_II {
WebDriver driver;
By EmailTextboxBy = By.xpath("//input[@id='mail']");
By Age18RadioBy = By.xpath("//input[@id='under_18']");
By EduTextAreaBy = By.xpath("//textarea[@id='edu']");
By JobRole1DDLBy = By.xpath("//select[@id='job1']");
By InterestCBBy = By.xpath("//input[@id='development']");
By Slide1By = By.xpath("//input[@id='slider-1']");
By PasswordBy = By.xpath("//input[@id='password']");
By AgeDisButtonBy = By.xpath("//input[@id='radio-disabled']");
By BiographyBy = By.xpath("//textarea[@id='bio']");
By JobRole2DDLBy = By.xpath("//select[@id='job2']");
By InterestDisBy = By.xpath("//input[@id='check-disbaled']");
By Slide2By = By.xpath("//input[@id='slider-2']");






@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
}
public void TC01_Element() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	
	WebElement EmailTextbox = driver.findElement(EmailTextboxBy);
		if (EmailTextbox.isDisplayed()){
			EmailTextbox.sendKeys("Automation Testing");
		}
	WebElement Age18Radio = driver.findElement(Age18RadioBy);
		if (Age18Radio.isDisplayed()) {
			Age18Radio.click();
		}
	WebElement EduTextArea = driver.findElement(EduTextAreaBy);
		if(EduTextArea.isDisplayed()) {
			EduTextArea.sendKeys("automation testing");
		}
	

}

public void TC02_Element() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	
	WebElement EmailTextbox = driver.findElement(EmailTextboxBy);
	if (EmailTextbox.isEnabled()) {
		System.out.println("Element ["+ EmailTextboxBy + "] is enabled");
	} else {
		System.out.println("Element ["+ EmailTextboxBy + "] is disabled");
	}
	WebElement Age18Radio = driver.findElement(Age18RadioBy);
	if (Age18Radio.isEnabled()) {
		System.out.println("Element ["+ Age18RadioBy + "] is enabled");
	} else {
		System.out.println("Element ["+ Age18RadioBy + "] is disabled");
	}
	WebElement EduTextArea = driver.findElement(EduTextAreaBy);
	if (EduTextArea.isEnabled()) {
		System.out.println("Element ["+ EduTextAreaBy + "] is enabled");
	} else {
		System.out.println("Element ["+ EduTextAreaBy + "] is disabled");
	}
	WebElement JobRole1DDL = driver.findElement(JobRole1DDLBy);
	if (JobRole1DDL.isEnabled()) {
		System.out.println("Element ["+ JobRole1DDLBy + "] is enabled");
	} else {
		System.out.println("Element ["+ JobRole1DDLBy + "] is disabled");
	}
	WebElement InterstCB = driver.findElement(InterestCBBy);
	if (InterstCB.isEnabled()) {
		System.out.println("Element ["+ InterestCBBy + "] is enabled");
	} else {
		System.out.println("Element ["+ InterestCBBy + "] is disabled");
	}
	WebElement Slider1 = driver.findElement(Slide1By);
	if (Slider1.isEnabled()) {
		System.out.println("Element ["+ Slide1By + "] is enabled");
	} else {
		System.out.println("Element ["+ Slide1By + "] is disabled");
	}
	WebElement Password = driver.findElement(PasswordBy);
	if (Password.isEnabled()) {
		System.out.println("Element ["+ PasswordBy + "] is enabled");
	} else {
		System.out.println("Element ["+ PasswordBy + "] is disabled");
	}
	WebElement AgeDisabled = driver.findElement(AgeDisButtonBy);
	if (AgeDisabled.isEnabled()) {
		System.out.println("Element ["+ AgeDisButtonBy + "] is enabled");
	} else {
		System.out.println("Element ["+ AgeDisButtonBy + "] is disabled");
	}
	WebElement Biography = driver.findElement(BiographyBy);
	if (Biography.isEnabled()) {
		System.out.println("Element ["+ BiographyBy + "] is enabled");
	} else {
		System.out.println("Element ["+ BiographyBy + "] is disabled");
	}
	WebElement JobRole2DDL = driver.findElement(JobRole2DDLBy);
	if (JobRole2DDL.isEnabled()) {
		System.out.println("Element ["+ JobRole2DDLBy + "] is enabled");
	} else {
		System.out.println("Element ["+ JobRole2DDLBy + "] is disabled");
	}
	WebElement InterestDis = driver.findElement(InterestDisBy);
	if (InterestDis.isEnabled()) {
		System.out.println("Element ["+ InterestDisBy + "] is enabled");
	} else {
		System.out.println("Element ["+ InterestDisBy + "] is disabled");
	}
	WebElement Slider2 = driver.findElement(Slide2By);
	if (Slider2.isEnabled()) {
		System.out.println("Element ["+ Slide2By + "] is enabled");
	} else {
		System.out.println("Element ["+ Slide2By + "] is disabled");
	}
}

public void TC03_Element() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	
	driver.findElement(Age18RadioBy).click();
	WebElement Age18Radio = driver.findElement(Age18RadioBy);
	if (Age18Radio.isSelected()) {
		System.out.println("Element [" + Age18RadioBy + "] is selected");
	} else {
		System.out.println("Element [" + Age18RadioBy + "] is unselected");
	}
	driver.findElement(InterestCBBy).click();
	WebElement Interest = driver.findElement(InterestCBBy);
	if (Interest.isSelected()) {
		System.out.println("Element [" + InterestCBBy + "] is selected");
	} else {
		System.out.println("Element [" + InterestCBBy + "] is unselected");
	}
	driver.findElement(InterestCBBy).click();
	WebElement InterestUnselected = driver.findElement(InterestCBBy);
	if (InterestUnselected.isSelected()) {
		System.out.println("Element [" + InterestCBBy + "] is selected");
	} else {
		System.out.println("Element [" + InterestCBBy + "] is unselected");
	}

}



@AfterClass
public void afterClass() {
driver.quit();
}
 
}