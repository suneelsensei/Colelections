package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("createAccountSubmit")).click();
       
	}

}
