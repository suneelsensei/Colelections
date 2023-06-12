package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EncoreLogin {

	public static void main(String[] args) {
		 System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://encore-demo.senseitech.com/encore-client");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("chitra");
        driver.findElement(By.className("password")).sendKeys("nadig@20");
        driver.findElement(By.className("btn btn-block btn-primary")).click();
	}

}
