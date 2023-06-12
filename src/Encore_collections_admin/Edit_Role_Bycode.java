package Encore_collections_admin;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edit_Role_Bycode {
	static String code="OTH";  		//code

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.name("username")).sendKeys("admin@123");
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();
		Thread.sleep(2000);
// ========================================  

		// Click on maximize
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[3]")).click();
		Thread.sleep(5000);

		// Click on Admin
		driver.findElement(By
				.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[10]/app-side-nav-list/a/div"))
				.click();
		Thread.sleep(2000);

		// Click on Role
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[1]/mat-accordion/mat-expansion-panel/div/div/mat-nav-list/div[3]/a/div"))
				.click();
		Thread.sleep(2000);

		// ======================================================================

		// Last page
//		driver.findElement(By.xpath(
//				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/mat-card/mat-paginator/div/div/div[2]/button[4]"))
//				.click();
//		Thread.sleep(2000);

		// view ops
//		driver.findElement(By.xpath(
//				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/table/tbody/tr[5]/td[3]/button[1]"))
//				.click();
//		Thread.sleep(2000);
First:
for(int j=1;j<100;j++)
{
		
		
	for(int i=1;i<=10;i++) {
		
		String xpath="/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/table/tbody/tr["+i+"]/td[2]";
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath));
			}
		catch (Exception e) 
		{
			System.out.println("Code is not matching");
			break First;
		}
//		System.out.println(bm.getText());
		
		String text;
		try
		{
		 text = driver.findElement(By.xpath(xpath)).getText();
		}
		catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath(xpath));
			text = driver.findElement(By.xpath(xpath)).getText();
		}
		
		
		if(text.equals(code)) 
		{
			//click on Edit
			driver.findElement(By.xpath(xpath+"/../td[3]/button[2]")).click();
			System.out.println("Clicked on Edit for "+ code);
			break First;
		}
		
		
	}
			//Go to next page
			WebElement next=driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/mat-card/mat-paginator/div/div/div[2]/button[3]"));
			
			if(next.isEnabled())
			{
				next.click();
			}
			else
			{
				break;
			}
	
		
		}

	
		
		
		
		
		
		
		
		
		
//		WebElement test=driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/table/tbody/tr[1]/td[2]"));
//		
//		System.out.println(test.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println('"'+"auth.add("+bm.getText()+")"+'"');
//		char c='"';
//		System.out.println("auth.add("+c+""+bm.getText()+""+c+");");	
		
		
		// driver.findElement(By.xpath("")).click();
	}
	
}

