package automationfc.com;
 
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class Topic_10_User_Interaction {
WebDriver driver;
Actions action;
 
@BeforeClass
public void beforeClass() {
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();


}
 
@Test
public void TC_01_MoveMouseToElement() {
// Login Page Url matching
	driver.get("https://www.myntra.com/");
	//WebElement hoverText = driver.findElement(By.xpath("//a[@data-group='discover']"));
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[@data-group='discover']"))).perform();
	driver.findElement(By.xpath("//a[@class='desktop-categoryLink' and text()='American Eagle']")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title-title' and text()='American Eagle']")).getText(), "American Eagle");
	
	

}
 
@Test
public void TC_02_ClickandHoldElement() {
// Login Page title
	driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
	List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	int numberSize = listItems.size();
	Actions moveItems= new Actions(driver);
	moveItems.clickAndHold(listItems.get(0)).moveToElement(listItems.get(3)).release().perform();
	List<WebElement> selectedItems = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
	int selectedSize = selectedItems.size();
	for (WebElement number : selectedItems) {
		Assert.assertEquals(selectedItems.size(), 4);
	}
}
 
@Test
public void TC_03_ClickandSelectElement() {
// Login Page title
	driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
	Actions action = new Actions(driver);
	List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	int numberSize = listItems.size();
	System.out.println(numberSize);
	action.keyDown(listItems.get(0), Keys.CONTROL).perform();
	listItems.get(2).click();
	listItems.get(5).click();
	listItems.get(10).click();
	action.keyUp(Keys.CONTROL).perform();
	List<WebElement> selectedItems = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
	for (WebElement number : selectedItems) {
		System.out.println(number.getText());
		Assert.assertEquals(selectedItems.size(), 4);
	}
}
 
@Test
public void TC_04_DoubleClick() {

	driver.get("https://automationfc.github.io/basic-form/index.html");
	Actions action = new Actions(driver);
	action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
	Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo' and text()='Hello Automation Guys!']")).getText(), "Hello Automation Guys!");

}

@Test
public void TC_05_RightClick() {

	driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	Actions action = new Actions(driver);
	action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
	action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]/span[text()='Quit']")).isDisplayed());

}

@Test
public void TC_06_DragAndDrop() {

	driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
	Actions action = new Actions(driver);
	WebElement sourceButton = driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement targetButton = driver.findElement(By.xpath("//div[@id='droptarget']"));
	action.dragAndDrop(sourceButton, targetButton).build().perform();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='droptarget' and text()='You did great!']")).isDisplayed());

}

@Test
public void TC_07_DragAndDropHTML5() {

	driver.get("http://the-internet.herokuapp.com/drag_and_drop");
	Actions action = new Actions(driver);
	WebElement sourceButton = driver.findElement(By.xpath("//div[@id='column-a']"));
	WebElement targetButton = driver.findElement(By.xpath("//div[@id='column-b']"));
	action.dragAndDrop(sourceButton, targetButton).build().perform();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']")).isDisplayed());

}
@AfterClass
public void afterClass() {
driver.quit();
}
 
}