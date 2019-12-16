package automationfc.com;
 
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_11_PopUp_Frame_Window {
WebDriver driver;
WebDriverWait waitExplicit;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
waitExplicit = new WebDriverWait(driver, 10);

}
 
@Test
public void TC_01_Popup() throws InterruptedException {
	driver.get("https://kyna.vn/");
	Thread.sleep(5000);
	List <WebElement> fancyPopup = driver.findElements(By.xpath("//img[@class='fancybox-image']"));
	if(fancyPopup.size() > 0) {
		Assert.assertTrue(fancyPopup.get(0).isDisplayed());
		driver.findElement(By.cssSelector(".fancybox-close")).click();
	}
	driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fanpage']//iframe")));
	boolean facebookIframe = driver.findElement(By.cssSelector("#facebook")).isDisplayed();
	Assert.assertTrue(facebookIframe);
	String facebookLikes = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
	Assert.assertEquals(facebookLikes, "170K likes");
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	//waitExplicit.until(ExpectedConditions.elementToBeClickable(By.className("button-login")));
	driver.findElement(By.className("button-login")).click();
	driver.findElement(By.xpath("//input[@id='user-login']")).sendKeys("automationfc.vn@gmail.com");
	driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys("automationfc.vn@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='btn-submit-login']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//span[@class='user' and text()='Automation FC']")).isDisplayed());
}
 

@AfterClass
public void afterClass() {
driver.quit();
}
 
}