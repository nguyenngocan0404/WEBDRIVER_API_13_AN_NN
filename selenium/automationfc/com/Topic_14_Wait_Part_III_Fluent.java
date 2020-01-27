package automationfc.com;
 
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;
 
public class Topic_14_Wait_Part_III_Fluent {
WebDriver driver;
WebDriverWait explicitWait;
FluentWait<WebDriver> fluentDriver;
FluentWait<WebLElement> fluentElement;

 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
fluentElement = new FluentWait<WebElement>(input);
}
 
@Test
public void TC_01_() {
	 driver = new FirefoxDriver();
	 driver.get("https://automationfc.github.io/fluent-wait/");
	 WebElement countdown = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
	 fluentElement = new FluentWait<WebLElement>(countdown);
	 fluentElement.withTimeout(15,TimeUnit.SECONDS)
	 .pollingEvery(1, TimeUnit.SECONDS)
	 .ignoring(NoSuchElementException.class)
	 boolean status = (Boolean) fluentElement.until(new Function<WebElement, Boolean>(){
		 public Boolean apply(WebElement element) {
			 boolean flag = element.getText().endsWith("02");
			 return flag;
		 }
	 });
	 Assert.assertTrue(status);
	 
}
 
 
@AfterClass
public void afterClass() {
driver.quit();
}
 
}