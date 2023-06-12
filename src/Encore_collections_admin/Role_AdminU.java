package Encore_collections_admin;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Role_AdminU {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter User name
		driver.findElement(By.name("username")).sendKeys("sharan");
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath("//*[text()='Sign In Securely']")).click();
		Thread.sleep(5000);
// ======================================== 

		// Click on Admin
		driver.findElement(By.xpath("//*[text()='ADMIN']")).click();
		Thread.sleep(2000);

		// Click on Access Matrix
		driver.findElement(By.xpath("//*[text()='ACCESS MATRIX']")).click();
		Thread.sleep(2000);

		// Click on Role
		driver.findElement(By.xpath("//*[text()='ROLE']")).click();
		Thread.sleep(2000);

//======================================================================

//		//LAst page
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/mat-card/mat-paginator/div/div/div[2]/button[4]")).click();
//		Thread.sleep(2000);
//		
//		//Edit Admin
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-role/table/tbody/tr[8]/td[3]/button[2]")).click();
//		Thread.sleep(2000);

		String code = "12"; // Role code
		/*
		 * Scanner myObj = new Scanner(System.in);
		 * System.out.println("Please Enter the CODE"); String code = myObj.nextLine();
		 */

		WebElement nextpage = driver.findElement(By.xpath("//*[@aria-label='Next page']"));

		String edit = "//*[text()=' " + code + " ']/../td/button[@title='Edit']";

		while (true) {
			try {
				driver.findElement(By.xpath(edit)).click();
				break;
			} catch (Exception e) {
				if (nextpage.isEnabled() == false) {
					System.out.println("Code is not matching");
					System.exit(0);
				}
				nextpage.click();
			}
		}

//		driver.findElement(By.xpath("")).click();

		Thread.sleep(2000);

		// click on Authority
		driver.findElement(By.xpath("//*[@role='combobox']")).click();
		Thread.sleep(2000);

//------------------------------------------------------		

		// click on check box 2 times
		for (int j = 1; j <= 2; j++) {
			driver.findElement(By.xpath("//*[@class='mat-checkbox-layout']")).click();

		}

		Thread.sleep(2000);
		// select the authority
		String checkbox = "//*[@role='option' and @tabindex=0]";

		int list = driver.findElements(By.xpath(checkbox)).size();

		for (int i = 1; i <= list; i++) {

			WebElement role = driver.findElement(By.xpath(checkbox + "[" + i + "]"));
			String role1 = role.getText();

			// System.out.println("auth.add("+role1+");");
			ArrayList<String> auth = new ArrayList<String>();

			if (code.equals("ADMIN")) {

				auth.add("CreateAgencies");
				auth.add("CreateAgents");
				auth.add("CreateBranchSet");
				auth.add("CreateBranches");
				auth.add("CreateDepositBatches");
				auth.add("CreateDepositSlips");
				auth.add("CreateEmployees");
				auth.add("CreateReceipts");
				auth.add("CreateRoles");
				auth.add("CreateTasks");
				auth.add("CreateTransactionToken");
				auth.add("CreateUsers");
				auth.add("DashBoardData");
				auth.add("DeleteJob");
				auth.add("DeleteReceipts");
				auth.add("GenerateReports");
				auth.add("GetAgencies");
				auth.add("GetAgenciesById");
				auth.add("GetAgentsByAgencyId");
				auth.add("GetAgentsById");
				auth.add("GetBranchById");
				auth.add("GetBranchSetById");
				auth.add("GetBranches");
				auth.add("GetCollectionItemsById");
				auth.add("GetDepositBatches");
				auth.add("GetDepositBatchesById");
				auth.add("GetDepositSlipsById");
				auth.add("GetEmployees");
				auth.add("GetEmployeesById");
				auth.add("GetReceiptsById");
				auth.add("GetRolesById");
				auth.add("GetScheduleJobInfoById");
				auth.add("GetTasksById");
				auth.add("GetUsersById");
				auth.add("LaunchJob");
				auth.add("ListAgencies");
				auth.add("ListAuthorities");
				auth.add("ListBranchSets");
				auth.add("ListBranchUsers");
				auth.add("ListBranches");
				auth.add("ListCashDeposits");
				auth.add("ListChequeDeposits");
				auth.add("ListCities");
				auth.add("ListCollectionItems");
				auth.add("ListCollectionItemsOpen");
				auth.add("ListCollectorBankAccounts");
				auth.add("ListCountries");
				auth.add("ListDepositBatches");
				auth.add("ListDepositSlips");
				auth.add("ListDistricts");
				auth.add("ListJobDetails");
				auth.add("ListJobs");
				auth.add("ListPGTransaction");
				auth.add("ListPendingPGTransactions");
				auth.add("ListReceipts");
				auth.add("ListRoles");
				auth.add("ListStates");
				auth.add("ListUPIReceipts");
				auth.add("ListUsers");
				auth.add("ListUsersByEmailId");
				auth.add("ROListReceipts");
				auth.add("SubmitDepositSlips");
				auth.add("UpdateAgencies");
				auth.add("UpdateAgents");
				auth.add("UpdateBranchSet");
				auth.add("UpdateBranches");
				auth.add("UpdateDepositBatches");
				auth.add("UpdateDepositSlips");
				auth.add("UpdateEmployees");
				auth.add("UpdateReceipts");
				auth.add("UpdateRoles");
				auth.add("UpdateUsers");
			} else if (code.equals("AGENT")) {
				auth.add("CheckPGOrderStatus");
				auth.add("CreateDepositBatches");
				auth.add("CreateDepositSlips");
				auth.add("CreateQrCode");
				auth.add("GenerateOTP");
				auth.add("ListCollectionItemsOpen");
				auth.add("ListCollectorBankAccounts");
				auth.add("ListPendingPGTransactions");
				auth.add("ROListReceipts");
				auth.add("SendPaymentLink");
				auth.add("UpdateTasks");
				auth.add("ValidateOTP");
			} else if (code.equals("BM")) {
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

			} else if (code.equals("OPS")) {
				auth.add("GetReceiptsById");
				auth.add("ListCashDeposits");
				auth.add("ListChequeDeposits");
				auth.add("ListCollectorBankAccounts");
				auth.add("ListPGTransaction");
				auth.add("ListUPIReceipts");
				auth.add("UpdateReceipts");

			} else {
				auth.add("ListBranches");
			}

			for (String val : auth) {

				if (role1.equals(val)) {
					role.click();
				}
			}

		}

		Thread.sleep(2000);
		// To exit the Auth pop-up
		/*
		 * Robot exit = new Robot(); exit.keyPress(KeyEvent.VK_ESCAPE);
		 * exit.keyRelease(KeyEvent.VK_ESCAPE);
		 */

		Actions co_ord = new Actions(driver);
		co_ord.moveByOffset(500, 500).click().perform();

		Thread.sleep(2000);

		// click on Submit
		driver.findElement(By.xpath("//*[text()='Submit']")).click();

		Thread.sleep(1500);
		WebElement sms = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/div/div/simple-snack-bar/span"));
		System.out.println(sms.getText());
//	driver.findElement(By.xpath("")).click();	

	}

}
