package Rough;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoacateName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.name("field-keywords")).sendKeys("watch");
		driver.findElement(By.linkText("Today's Deals")).click();
		//WaitUtils.waitForDataToLoad(getDriver());
       // WebElement memberSelection =  driver.findElement(By.className("a-checkbox checkbox a-spacing-micro"));
        //for(int count =1;  count<=10; count++){
           // memberSelection.click();
	driver.findElement(By.className("a-row layer backGround")).click();
	}
}
