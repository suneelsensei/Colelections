package Encore_collections_admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Role_BM {

	public static void main(String[] args) throws InterruptedException, AWTException {
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
		Thread.sleep(5000);
// ======================================== 

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

//======================================================================

		// Last page
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/mat-card/mat-paginator/div/div/div[2]/button[4]"))
				.click();
		Thread.sleep(2000);

		// Edit BM
		//Change
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/table/tbody/tr[6]/td[3]/button[2]"))
				.click();
		Thread.sleep(2000);

		// click on Authority
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role-edit/mat-card/mat-card-content/form/mat-form-field[3]/div/div[1]/div/mat-select"))
				.click();
		Thread.sleep(2000);

//------------------------------------------------------		
		// click on check box - 2 times
		for (int j = 1; j <= 2; j++)       //Remove for new creation
		{
			driver.findElement(By.xpath(
					"/html/body/div[2]/div[2]/div/div/div/mat-option/span/ngx-mat-select-search/div/mat-checkbox"))
					.click();
		}

		Thread.sleep(2000);
		
		// select the authority
		int list = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/mat-option")).size();

		for (int i = 1; i <= list; i++) {

			WebElement role = driver
					.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/mat-option[" + i + "]/span"));
			String role1 = role.getText();
//		System.out.println("auth.add("+role1+");");

			ArrayList<String> auth = new ArrayList<String>();
			auth.add("CreateAgencies");
			auth.add("CreateBranches");
			auth.add("CreateBranchSet");
			auth.add("CreateDepositBatches");
			auth.add("CreateDepositSlips");
			auth.add("CreateReceipts");
			auth.add("CreateRoles");
			auth.add("CreateSms");
			auth.add("CreateTasks");
			auth.add("CreateUsers");
			auth.add("DashBoardData");
			auth.add("DeleteAgencies");
			auth.add("DeleteAgents");
			auth.add("DeleteBranches");
			auth.add("DeleteBranchSet");
			auth.add("DeleteDepositSlips");
			auth.add("DeleteEmployees");
			auth.add("DeleteReceipts");
			auth.add("DeleteRoles");
			auth.add("DeleteUsers");
			auth.add("GenerateReports");
			auth.add("GetAgencies");
			auth.add("GetAgenciesById");
			auth.add("GetAgentsByAgencyId");
			auth.add("GetAgentsById");
			auth.add("GetBranchById");
			auth.add("GetBranches");
			auth.add("GetBranchSetById");
			auth.add("GetCollectionItemsById");
			auth.add("GetDepositBatchesById");
			auth.add("GetDepositSlipsById");
			auth.add("GetEmployees");
			auth.add("GetEmployeesById");
			auth.add("GetReceiptsById");
			auth.add("GetRolesById");
			auth.add("GetScheduleJobInfoById");
			auth.add("GetTasksById");
			auth.add("GetUsersById");
			auth.add("ListAuthorities");
			auth.add("ListBranchUsers");
			auth.add("ListCollectionItems");
			auth.add("ListCollectionItemsOpen");
			auth.add("ListCollectorBankAccounts");
			auth.add("ListDepositBatches");
			auth.add("ListDepositSlips");
			auth.add("ListReceipts");
			auth.add("ListUsersByEmailId");
			auth.add("SubmitDepositSlips");
			auth.add("UpdateAgencies");
			auth.add("UpdateAgents");
			auth.add("UpdateBranches");
			auth.add("UpdateBranchSet");
			auth.add("UpdateDepositBatches");
			auth.add("UpdateDepositSlips");
			auth.add("UpdateEmployees");
			auth.add("UpdateReceipts");
			auth.add("UpdateRoles");
			auth.add("UpdateTasks");
			auth.add("UpdateUsers");
			auth.add("UploadTasks");

			for (String val : auth) {

				if (role1.equals(val)) {
					role.click();
				}
			}

		}

		Thread.sleep(2000);
		// To exit the Auth pop-up
		Robot exit = new Robot();
		exit.keyPress(KeyEvent.VK_ESCAPE);
		exit.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);

		// click on Submit
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role-edit/mat-card/mat-card-content/form/mat-card-actions/button[1]"))
				.click();

		Thread.sleep(1500);
		WebElement sms= driver.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/div/div/simple-snack-bar/span"));
		System.out.println(sms.getText());

	}

}
