package Engrow_web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application_workflow {
	static WebDriver driver;
	static String url = "https://engrow-uat.senseitech.com/engrow-test-new";

	static String application = "rafi v";
	static String fee_amount = "5000";
	static String payment_ref = "574896";
	static String Aff_amount = "50000";
	static String Fin_amount = "65810";
	static String assetvalue = "9999999";
	static String chequeno = "458765";
	static String purpose = "Required amount";
	static String cheque_amount = "45865";

	static String bmuser = "100129";
	static String bcmuser = "100066";
	static String acmuser = "100135";
	static String ncmuser = "100011";
	static String crouser = "100001";
	static String makeruser = "100031";
	static String checkeruser = "100030";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// URL
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		BMReview();
//		PrePdStage();
//		PdStage();
		ProvisionalBCM();

		try {
			ProvisionalACM();
		} catch (Exception e) {
			signout();
			System.out.println("Provisional ACM stage is not required for this application");
		}
		try {
			ProvisionalNCM();
		} catch (Exception e) {
			signout();
			System.out.println("Provisional NCM stage is not required for this application");
		}

		try {
			ProvisionalCRO();
		} catch (Exception e) {
			signout();
			System.out.println("Provisional CRO stage is not required for this application");
		}

		try {
			PreDisCondition();
			PreDisConditionApp();
		} catch (Exception e) {
			signout();
			System.out.println("PreDisCondition stage is not required for this application");
		}

		try {
			BCMlegalstage();
		} catch (Exception e) {
			signout();
			System.out.println("BCM-Legal stage is not required for this application");
		}
		try {
			FinalACM();
		} catch (Exception e) {
			signout();
			System.out.println("Final ACM stage is not required for this application");
		}
		DocumentExecution();
		DisbursementMaker();
		Disbursementchecker();

	}

	public static void signout() throws Exception {
		driver.findElement(By.xpath("//*[text()='more_vert']")).click();
		driver.findElement(By.xpath("//*[text()='logout']")).click();
	}

	public static void Gotoapplication() throws Exception {

		Thread.sleep(3000);
		// Click on sign IN
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();

		// Click on Applications
		driver.findElement(By.xpath("//*[text()='source']")).click();
		
		
		
		

		// Open the Application
		List<WebElement> list = driver.findElements(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application/mat-sidenav-container/mat-sidenav-content/div[2]/table/tbody/tr"));

		for (int i = 1; i <= list.size(); i++) {
			WebElement name = driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application/mat-sidenav-container/mat-sidenav-content/div[2]/table/tbody/tr["
							+ i + "]/td[3]"));

			if ((name.getText()).equalsIgnoreCase(application)) {
				name.click();

				WebElement open = driver.findElement(By.xpath(
						"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application/mat-sidenav-container/mat-sidenav/div/div/mat-card[1]/div/mat-icon"));

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(open));
				open.click();
				break;
			}
		}
	}

	public static void Proceedtonextstage() throws Exception {
		Thread.sleep(2000);
		// Click on Decision card
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav/div/div/mat-card[2]/mat-icon[2]"))
				.click();
		// Click on Proceed Radio button
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav/div/div/div/mat-card[2]/mat-card-content/mat-radio-group/mat-radio-button[1]/label"))
				.click();
		// Click on OK
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav/div/div/div/mat-card[2]/mat-card-content/div/div[1]/span[2]"))
				.click();
		Thread.sleep(3000);
		// Click on sign OUT
		signout();
	}

	public static void SelectallCB() throws Exception {
		try {
			List<WebElement> totalCB = driver.findElements(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card"));

			for (int e1 = 2; e1 <= totalCB.size(); e1++) {
				driver.findElement(By.xpath(
						"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card["
								+ e1 + "]/mat-card-content/div[3]/div/div/mat-checkbox"))
						.click();
			}
		} catch (Exception e) {
		}
	}

	public static void BMReview() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();
		Proceedtonextstage();

	}

	public static void PrePdStage() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		// Click on Application
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[1]"))
				.click();
		// Click on Fee Payment
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[1]/div/div/mat-nav-list/mat-list-item[7]"))
				.click();
		// CLick on Add
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/div[2]/mat-card/mat-card-title/div[2]/div/button"))
				.click();

		// Select the Fee charge drop-down
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/form/div/mat-card/mat-card-content/fieldset/div/div[1]/div[1]/div[2]/mat-form-field/div/div[1]"))
				.click();
		// Select Processing Fee
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]")).click();

		// Enter Amount
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/form/div/mat-card/mat-card-content/fieldset/div/div[1]/div[2]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(fee_amount);

		// Select payment mode
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/form/div/mat-card/mat-card-content/fieldset/div/div[2]/div[1]/div[2]/mat-form-field/div/div[1]"))
				.click();

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[1]")).click();
		// Enter Payment reference
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/form/div/mat-card/mat-card-content/fieldset/div/div[2]/div[2]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(payment_ref);

		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-fee-payment/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		// Enter the details for applicant and co-applicant
		for (int j = 3; j <= 4; j++) {
			Thread.sleep(3000);
			// Click on Applicant/Co-Applicant
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel["
							+ j + "]"))
					.click();
			Thread.sleep(3000);
			// CLick on BUREAU Reports
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel["
							+ j + "]/div/div/mat-nav-list/mat-list-item[7]"))
					.click();
			// Click on ADD button
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-bureau-reports/div/div[2]/mat-card/mat-card-title/div[2]/div/button"))
					.click();
			// Click on Report Type
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-bureau-reports/div/div[3]/form/div/mat-card/mat-card-content/div/div[1]/div[1]/div[2]/mat-form-field/div/div[1]/div"))
					.click();
			// Select the CIBIL
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[1]")).click();
			// Enter the score
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-bureau-reports/div/div[3]/form/div/mat-card/mat-card-content/div/div[1]/div[2]/div[2]/mat-form-field/div/div[1]/div/input"))
					.sendKeys("845");

			// Click on save
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-bureau-reports/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
					.click();

		}

		Proceedtonextstage();
	}

	public static void PdStage() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Application
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[1]"))
				.click();
		// Click on Repayment Account
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[1]/div/div/mat-nav-list/mat-list-item[3]"))
				.click();

		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-repayment-account/div/div/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the radio button
		try {
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-repayment-account/div/form/div[2]/mat-card/mat-card-content/div/div[1]/div[1]/mat-radio-group/mat-radio-button"))
					.click();
		} catch (Exception e) {
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-repayment-account/div/form/div[2]/mat-card/mat-card-content/div[1]/div[1]/div[1]/mat-radio-group/mat-radio-button"))
					.click();
		}
		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-repayment-account/div/div/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		// Click on Loan Proposed
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[1]/div/div/mat-nav-list/mat-list-item[2]"))
				.click();

		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-loan-proposed/div/div/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Enter Affordable EMI
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-loan-proposed/div/form/div[1]/mat-card/mat-card-content/fieldset/div/div[4]/mat-form-field[1]/div/div[1]/div/input"))
				.clear();
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-loan-proposed/div/form/div[1]/mat-card/mat-card-content/fieldset/div/div[4]/mat-form-field[1]/div/div[1]/div/input"))
				.sendKeys(Aff_amount);

		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-loan-proposed/div/div/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Thread.sleep(3000);
		// Click on Financials and CFA
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[6]"))
				.click();

		// Click on CFA
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[6]/div/div/mat-nav-list/mat-list-item[1]"))
				.click();
		// Click on Radio button
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-cfa/div/div[3]/mat-card/mat-card-content/div[2]/div[1]/mat-radio-group/mat-radio-button"))
				.click();

		// Click on Finalize CFA
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-cfa/div/div[4]/mat-card/mat-card-content/div[2]/button"))
				.click();

		Proceedtonextstage();

	}

	public static void ProvisionalBCM() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);

		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the checkbox

		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card/mat-card-content/div[2]/div/div/mat-checkbox"))
				.click();

		SelectallCB();

		// Click on SAVE
		driver.findElement(By.xpath(
				"html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void ProvisionalACM() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(acmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the checkbox
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card/mat-card-content/div[2]/div/div/mat-checkbox"))
				.click();

		SelectallCB();

		// Click on SAVE
		driver.findElement(By.xpath(
				"html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void ProvisionalNCM() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(ncmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the checkbox
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card/mat-card-content/div[2]/div/div/mat-checkbox"))
				.click();

		SelectallCB();

		// Click on SAVE
		driver.findElement(By.xpath(
				"html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void ProvisionalCRO() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(crouser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the checkbox
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card/mat-card-content/div[2]/div/div/mat-checkbox"))
				.click();

		SelectallCB();

		// Click on SAVE
		driver.findElement(By.xpath(
				"html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void PreDisCondition() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);

		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-pre-condition/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select checkbox
		List<WebElement> CB = driver.findElements(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-pre-condition/div/div[3]/form/div/mat-card"));

		for (int s = 1; s <= CB.size(); s++) {

			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-pre-condition/div/div[3]/form/div/mat-card["
							+ s + "]/mat-card-content/div[2]/div/div/mat-checkbox"))
					.click();
		}

		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-pre-condition/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void PreDisConditionApp() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);

		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-approval-pre-condition/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select checkbox
		List<WebElement> CB = driver.findElements(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-approval-pre-condition/div/div[3]/form/div/mat-card"));

		for (int s = 1; s <= CB.size(); s++) {

			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-approval-pre-condition/div/div[3]/form/div/mat-card["
							+ s + "]/mat-card-content/div[2]/div/div/mat-checkbox"))
					.click();
		}

		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-approval-pre-condition/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void BCMlegalstage() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-collateral-verification/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();
		// Enter Asset value
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-collateral-verification/div/form/div[2]/mat-card/mat-card-content/fieldset/div/div[1]/div[1]/div[2]/mat-form-field/div/div[1]/div/input"))
				.clear();

		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-collateral-verification/div/form/div[2]/mat-card/mat-card-content/fieldset/div/div[1]/div[1]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(assetvalue);

		// Click on SAVE
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-collateral-verification/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Thread.sleep(3000);
		// Click on Collateral
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[5]"))
				.click();
		// Click on Collateral summary
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[5]/div/div/mat-nav-list/mat-list-item[3]"))
				.click();
		// Finalize collateral
		WebElement Finalize = driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-collateral-summary/div/div[2]/mat-card/mat-card-content/div/div[4]/button"));
		if (Finalize.isEnabled()) {
			Finalize.click();
		} else {
			System.out.println(assetvalue + " Asset value is not satisfied");
			System.exit(0);
		}

		Proceedtonextstage();

	}

	public static void FinalACM() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(acmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Edit
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[1]"))
				.click();

		// Select the checkbox
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[2]/form/div/mat-card/mat-card-content/div[2]/div/div/mat-checkbox"))
				.click();

		// Click on SAVE
		driver.findElement(By.xpath(
				"html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-decision/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
				.click();

		Proceedtonextstage();
	}

	public static void DocumentExecution() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(bcmuser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on Post Approval
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[9]"))
				.click();

		// Click on Post Date Cheque
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[9]/div/div/mat-nav-list/mat-list-item[1]"))
				.click();
		// Click on Add button
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-post-datecheque/div/div[2]/mat-card/mat-card-title/div[2]/div/button"))
				.click();
		// Enter CHEQUE number
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-post-datecheque/div/form/div/mat-card/mat-card-content/fieldset/div/div[1]/div[1]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(chequeno);

		// Enter Purpose
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-post-datecheque/div/form/div/mat-card/mat-card-content/fieldset/div/div[2]/div[1]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(purpose);

		// Enter Amount
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-post-datecheque/div/form/div/mat-card/mat-card-content/fieldset/div/div[2]/div[2]/div[2]/mat-form-field/div/div[1]/div/input"))
				.sendKeys(cheque_amount);

		// Click on Save
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-post-datecheque/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]/button"))
				.click();

		Thread.sleep(3000);
		// Click on OPERATIONS
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[10]"))
				.click();
		// Click on OPS Checklist
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[10]/div/div/mat-nav-list/mat-list-item[1]"))
				.click();
		try {
			// Click on Add
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-check-list/div/div[2]/mat-card/mat-card-title/div[2]/div/button"))
					.click();
			// Click on OK
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-check-list/div/div[2]/mat-card/mat-card-title/div[2]/div/div/mat-card/button"))
					.click();
			Thread.sleep(3000);
			// Click on SAVE
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-check-list/div/div[1]/mat-card/mat-card-header/mat-button-toggle-group/mat-button-toggle[2]"))
					.click();
		} catch (Exception e) {
		}
		Thread.sleep(3000);
		Proceedtonextstage();
	}

	public static void DisbursementMaker() throws Exception {
		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(makeruser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);

		Proceedtonextstage();
	}

	public static void Disbursementchecker() throws Exception {

		// Enter User name
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(checkeruser);
		// Enter Password
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Engrow@1");

		Gotoapplication();

		Thread.sleep(3000);
		// Click on OPERATIONS
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[10]"))
				.click();
		// Click on Book Loan in Side nav
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel[10]/div/div/mat-nav-list/mat-list-item[2]"))
				.click();
		// Click on Book Loan
//		driver.findElement(By.xpath(
//				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[2]/eng-book-loan/div/div[2]/mat-card[1]/mat-card-title/div[2]/button"))
//				.click();

	}

}

//driver.findElement(By.xpath("")).click();