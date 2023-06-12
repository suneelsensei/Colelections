package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("women's watch");
        
     //   driver.findElement(By.id("nav-search-submit-text")).click();
        WebElement searchBox=driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
        searchBox.sendKeys("Book");
        
        WebElement searchButton=driver.findElement(By.cssSelector((".nav-search-submit")));
        searchButton.click();
        driver.quit();
	}

}
