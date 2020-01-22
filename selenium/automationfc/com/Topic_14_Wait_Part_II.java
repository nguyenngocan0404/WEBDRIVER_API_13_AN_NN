package automationfc.com;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_14_Wait_Part_II {
WebDriver driver;
WebDriverWait waitExplicit;
By startButtonBy = By.xpath("//div[@id='start']/button");
By loadingImgBy = By.xpath("//div[@id='loading']/img");
By helloWorldTextBy = By.xpath("//div[@id='finish']/h4[text()='Hello World!']");
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
waitExplicit = new WebDriverWait(driver, 10);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

}
 
@Test
public void TC_01_Implicit_Wait() {
	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	WebElement startButton = driver.findElement(startButtonBy);
	Assert.assertTrue(startButton.isDisplayed());
	startButton.click();
	WebElement helloWorldText = driver.findElement(helloWorldTextBy);
	Assert.assertTrue(helloWorldText.isDisplayed());
	
}
 
@Test
public void TC_02_Explicit_Wait_Visible() {
	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	waitExplicit.until(ExpectedConditions.elementToBeClickable(startButtonBy));
	driver.findElement(startButtonBy).click();
	waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(helloWorldTextBy));
	Assert.assertTrue(driver.findElement(helloWorldTextBy).isDisplayed());
	
}
 
@Test
public void TC_03_Explicit_Wait_Invisible() {
	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	waitExplicit.until(ExpectedConditions.elementToBeClickable(startButtonBy));
	driver.findElement(startButtonBy).click();
	waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loadingImgBy));
	Assert.assertTrue(driver.findElement(helloWorldTextBy).isDisplayed());
	
}

@Test
public void TC_04_Explicit_Wait_date() {
	driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
	WebElement dateSelectedText = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
	Assert.assertEquals(dateSelectedText.getText(),"No Selected Dates to display.");
	driver.findElement(By.xpath("//a[text()='7']")).click();
	waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@style,'position: absolute;')]/div[@class='raDiv']")));
	Assert.assertTrue(driver.findElement(By.xpath("//td[@class='rcSelected']//a[text()='7']")).isDisplayed());
	dateSelectedText = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
	Assert.assertEquals(dateSelectedText.getText(), "Tuesday, January 07, 2020");
	
}

@AfterClass
public void afterClass() {
driver.quit();
}
 
}