package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class close_window {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
	   driver.get("http://15.206.3.173/encollectest/login");
       driver.manage().window().maximize();
       driver.findElement(By.id("j_username")).sendKeys("adminstpl");
       driver.findElement(By.id("j_password")).sendKeys("Admin@123");
       driver.findElement(By.id("proceed")).click();
       //To close the browser
       driver.close();
}
}
