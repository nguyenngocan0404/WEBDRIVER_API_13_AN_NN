package automationfc.com;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_13_Upload_file {
WebDriver driver;
String projectPath = System.getProperty("user.dir");
String pic1 = projectPath + "\\uploadfiles\\1.jpg";
String pic2 = projectPath + "\\uploadfiles\\2.jpg";
String pic3 = projectPath + "\\uploadfiles\\3.jpg";
String pic4 = projectPath + "\\uploadfiles\\4.jpg";
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

}
 
@Test
public void TC_01_Upload_files() throws InterruptedException {
	driver.get("http://blueimp.github.io/jQuery-File-Upload/");
	WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFile.sendKeys(pic1);
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFile.sendKeys(pic2);
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFile.sendKeys(pic3);
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFile.sendKeys(pic4);
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='1.jpg']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='2.jpg']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='3.jpg']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='4.jpg']")).isDisplayed());
	
	
}
 
 
@AfterClass
public void afterClass() {
driver.quit();
}
 
}