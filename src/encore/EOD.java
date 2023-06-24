package encore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EOD {
	static String url = "https://encore-demo.senseitech.com/encore/login#/login";
	static String username = "admin123";
	static String password = "Conatus@123";
	//How many times want to run
	static int times = 26;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		driver.findElement(By.id("proceed")).click();
		Thread.sleep(2000);
		// click on internal
		driver.findElement(By.xpath("//*[text()='Internal']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Batch']")).click();

		for (int i = 1; i <= times; i++) {
			driver.findElement(By.xpath("//*[contains(@href,'internal/batch/jobs/execute/eodJob')]")).click();
			driver.findElement(By.id("proceed")).click();
			System.out.println(i);
			Thread.sleep(30000);
		}
		driver.quit();
	}
}
//driver.findElement(By.xpath("")).click();