package encore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EODjob {
	static String url = "http://52.136.57.225/erflencore/login ";
	static String username = "";
	static String password = "Samfin@321";
	static int times = 40;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		driver.findElement(By.id("proceed")).click();
		Thread.sleep(3000);
		// click on internal
		driver.findElement(By.xpath("/html/body/div/div[1]/div/ul[1]/li[2]/a")).click();
		Thread.sleep(3000);
		// click on batches
		driver.findElement(By.xpath("/html/body/div/div[1]/div/ul[1]/li[2]/ul/li[3]/a")).click();

		List<WebElement> totalsize = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/table/tbody/tr"));
		for (int j = 1; j <= times; j++) {

			for (int i = 2; i <= totalsize.size(); i++) {
				// click on EOD JOB
//    	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/table/tbody/tr[7]/td[2]/a")).click();
				// for DEMO
				String job = driver
						.findElement(By.xpath("/html/body/div/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[1]"))
						.getText();
				if (job.equalsIgnoreCase("EODjob")) {
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[2]/a"))
							.click();
					driver.findElement(By.id("proceed")).click();
					Thread.sleep(30000);
					System.out.println(j);
					break;
				}

			}
		}
		driver.close();

	}

}
