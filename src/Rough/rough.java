package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class rough {
	static String url="https://encore-demo.senseitech.com/encore/login?logout";
	static String username ="suneel";
	static String password = "Suneel@123";
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
	   driver.get(url);
       driver.manage().window().maximize();
       driver.findElement(By.id("j_username")).sendKeys(username);
       driver.findElement(By.id("j_password")).sendKeys(password);
       driver.findElement(By.id("proceed")).click();
       Thread.sleep(3000);
       //click on base
       driver.findElement(By.xpath("//*[@id='header']/div/ul[1]/li[1]")).click();
       Thread.sleep(3000);
       //Location
       driver.findElement(By.xpath("//*[@id='header']/div/ul[1]/li[1]/ul/li[1]/a")).click();

       WebElement element = driver.findElement(By.id("_countryName_id"));
       Select country =new Select(element);
       country.selectByVisibleText("JAP-Japan");
       Thread.sleep(3000);
       country.selectByValue("England");
       Thread.sleep(3000);
       country.selectByIndex(1);
      
       
       
	}

}
//driver.findElement(By.xpath(""));