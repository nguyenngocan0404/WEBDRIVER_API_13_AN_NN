package automationfc.com;
 
import java.util.List;
import java.util.Set;
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

import com.thoughtworks.selenium.webdriven.commands.Click;
 
public class Topic_11_PopUp_Frame_Window_Part2 {
WebDriver driver;
WebDriverWait waitExplicit;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
waitExplicit = new WebDriverWait(driver, 10);

}
 

public void TC_01_Window() throws InterruptedException {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	String parentID = driver.getWindowHandle();
	driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
	switchToWindowByTitle("Google");
	Assert.assertEquals(driver.getTitle(), "Google");
	switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
	driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
	switchToWindowByTitle("Facebook - Đăng nhập hoặc đăng ký");
	Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
	switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
	driver.findElement(By.xpath("//a[text()='TIKI']")).click();
	switchToWindowByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
	Assert.assertEquals(driver.getTitle(), "Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
	closeAllWindowWithoutParent(parentID);
	Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
	
}


public void TC_02_Window() throws InterruptedException {
	driver.get("https://kyna.vn/");
	//String parentID = driver.getWindowHandle();
	Thread.sleep(5000);
	List <WebElement> fancyPopup = driver.findElements(By.xpath("//img[@class='fancybox-image']"));
	if(fancyPopup.size() > 0) {
		Assert.assertTrue(fancyPopup.get(0).isDisplayed());
		driver.findElement(By.cssSelector(".fancybox-close")).click();
	}
	driver.findElement(By.xpath("//img[@alt='facebook']")).click();
	switchToWindowByTitle("Kyna.vn - Trang chủ | Facebook");
	Assert.assertEquals(driver.getTitle(), "Kyna.vn - Trang chủ | Facebook");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//img[@alt='youtube']")).click();
	switchToWindowByTitle("Kyna.vn - YouTube");
	Assert.assertEquals(driver.getTitle(), "Kyna.vn - YouTube");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//img[@alt='zalo']")).click();
	switchToWindowByTitle("Kyna.vn");
	Assert.assertEquals(driver.getTitle(), "Kyna.vn");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	//driver.findElement(By.xpath("//img[@alt='apple-app-icon']")).click();
	//switchToWindowByTitle("‎KYNA on the App Store");
	//Assert.assertEquals(driver.getTitle(), "‎KYNA on the App Store");
	//switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//img[@alt='android-app-icon']")).click();
	switchToWindowByTitle("KYNA - Học online cùng chuyên gia - Apps on Google Play");
	Assert.assertEquals(driver.getTitle(), "KYNA - Học online cùng chuyên gia - Apps on Google Play");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//a[@title='Kyna.vn']")).click();
	switchToWindowByTitle("Kyna.vn - Trang chủ | Facebook");
	Assert.assertEquals(driver.getTitle(), "Kyna.vn - Trang chủ | Facebook");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//img[@alt='kynaforkids.vn']")).click();
	switchToWindowByTitle("Kynaforkids.vn trường học trực tuyến cho trẻ");
	Assert.assertEquals(driver.getTitle(), "Kynaforkids.vn trường học trực tuyến cho trẻ");
	switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
	
	driver.findElement(By.xpath("//img[@alt='kynabiz.vn']")).click();
	switchToWindowByTitle("Giải pháp đào tạo nhân sự online toàn diện - KynaBiz.vn");
	Assert.assertEquals(driver.getTitle(), "Giải pháp đào tạo nhân sự online toàn diện - KynaBiz.vn");
	closeAllWindowWithoutParent("Kyna.vn - Học online cùng chuyên gia");
	
	
	
}

@Test
public void TC_03_Window() {
	driver.get("http://live.guru99.com/index.php/");
	driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	driver.findElement(By.xpath("//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='The product Sony Xperia has been added to comparison list.']")).getText(), "The product Sony Xperia has been added to comparison list.");
	driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//parent::h2//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='The product Samsung Galaxy has been added to comparison list.']")).getText(), "The product Samsung Galaxy has been added to comparison list.");
	driver.findElement(By.xpath("//button[@title='Compare']")).click();
	switchToWindowByTitle("Products Comparison List - Magento Commerce");
	Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
	driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	switchToWindowByTitle("Mobile");
	driver.findElement(By.xpath("//a[text()='Clear All']")).click();
	driver.switchTo().alert().accept();
	Assert.assertTrue(driver.findElement(By.xpath("//span[text()='The comparison list was cleared.']")).isDisplayed());



}

public void switchToWindowByTitle(String title) {
	Set<String> allWindows = driver.getWindowHandles();
	for (String termID: allWindows) {
		driver.switchTo().window(termID);
		String currentWindow = driver.getTitle();
		if(currentWindow.equals(title)) {
			break;
		}
	}
	
}

public void closeAllWindowWithoutParent(String parentWindow) {
	Set<String> allWindows = driver.getWindowHandles();
	for(String runWindows: allWindows) {
		if(!runWindows.equals(parentWindow)) {
			driver.switchTo().window(runWindows);
			driver.close();
		}
	}
	driver.switchTo().window(parentWindow);
}
 

@AfterClass
public void afterClass() {
driver.quit();
}
 
}