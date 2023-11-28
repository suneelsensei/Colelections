package Samasta;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Redmine_edit_effort_update {

	static String url = "https://new-redmine5.senseitech.com/";
	static String username = "suneel.kumar@sen-sei.in";
	static String password = "Suneel@2021";
	static WebDriver driver;

	@BeforeTest
	public static void launch_browser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		driver.findElement(By.id("project-jump")).click();
		driver.findElement(By.xpath("//*[@title='Samasta']")).click();
	}

	@Test
	public void update_efforts() {

		driver.findElement(By.xpath("//*[@class='sprint']")).click();

		driver.findElement(By.xpath("//*[@title='Edit effort']")).click();

		List<String> user = Arrays.asList(/* Anil */"15", /* Dharm */"16", /* Bhargavi */ "17", /* Pinky */"18",
				/* Suneel */"19", /* Sharmila */ "28", /* Shijas "40",*/  /* Sima */"44", /*Darshan*/"32");
		for (int j = 0; j < user.size(); j++) {

			for (int i = 0; i < 12; i++) {
//				driver.findElement(By.id("user_" + user.get(j) + "_" + i)).clear();
				if (i != 5 && i != 6) {

					driver.findElement(By.id("user_" + user.get(j) + "_" + i)).sendKeys("8");
				}
			}
		}

	}

}
