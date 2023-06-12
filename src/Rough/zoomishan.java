package Rough;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zoomishan {
	static String url = "https://us05web.zoom.us/signin#/login";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
//		Actions a=new Actions(driver);
//		a.moveByOffset(346	, 48).build().perform();
		



		// user
		driver.findElement(
				By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/form/div[1]/div/div/input"))
				.sendKeys("ishan@sen-sei.in");
		// pass
		driver.findElement(
				By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/form/div[2]/div/div/input"))
				.sendKeys("Zoom_123");
		// sign in
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/form/div[3]/button"))
				.click();
		Thread.sleep(3000);
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("/html/body/div[1]/div[4]/div[3]/div[3]/div/div/div[1]/aside/ul/li[8]"))).click();
//		// Recordings
////		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[3]/div/div/div[1]/aside/ul/li[8]")).click();
//
//		String topic = driver.findElement(By.xpath(
//				"/html/body/div[1]/div[4]/div[3]/div[3]/div/div/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[3]/div/div[1]/div/table/tbody/tr[1]/td[2]/div/div/div/a/text()"))
//				.getText();
//
//		String time = driver.findElement(By.xpath(
//				"/html/body/div[1]/div[4]/div[3]/div[3]/div/div/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[3]/div/div[1]/div/table/tbody/tr[1]/td[4]/div/span"))
//				.getText();
//		String date = time.substring(0, 10);
//		System.out.println(topic + date);

//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();
//
//		driver.findElement(By.xpath("")).click();

	}

}
//driver.findElement(By.xpath("")).click();