package Samasta;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Redmine_status_update {

	String subject = "28-11-2023";
	String comments = "1. Team meeting 2. Internal server error 3. Audit clarification 4. Backdated issue ";

	@BeforeTest
	public void lb() {
		Redmine_edit_effort_update.launch_browser();
	}

	@Test(priority = 1)
	public void create_issue() {
		Redmine_edit_effort_update.driver.findElement(By.id("new-object")).click();

		Redmine_edit_effort_update.driver.findElement(By.xpath("//a[text()='New issue']")).click();

		Select Tracker = new Select(Redmine_edit_effort_update.driver.findElement(By.id("issue_tracker_id")));

		Tracker.selectByVisibleText("Support");

		Redmine_edit_effort_update.driver.findElement(By.id("issue_subject"))
				.sendKeys("Production support on " + subject);

		Redmine_edit_effort_update.driver.findElement(By.id("issue_parent_issue_id")).sendKeys("363");

		Redmine_edit_effort_update.driver.findElement(By.xpath("//*[@data-id=19]")).click();

		Select Done = new Select(Redmine_edit_effort_update.driver.findElement(By.id("issue_done_ratio")));
		Done.selectByValue("100");

		try {

			Select sprint = new Select(Redmine_edit_effort_update.driver.findElement(By.id("issue_sprint_id")));
			List<WebElement> options = sprint.getOptions();
			sprint.selectByIndex(options.size() - 1);
		} catch (Exception e) {
			Select sprint = new Select(Redmine_edit_effort_update.driver.findElement(By.id("issue_sprint_id")));
			List<WebElement> options = sprint.getOptions();
			sprint.selectByIndex(options.size() - 1);
		}

		Redmine_edit_effort_update.driver.findElement(By.xpath("//*[@value='Create']")).click();

	}

	@Test(priority = 2)
	public void log_time() {
		Redmine_edit_effort_update.driver.findElement(By.xpath("//*[@class='icon icon-time-add']")).click();

		Redmine_edit_effort_update.driver.findElement(By.id("time_entry_hours")).sendKeys("8");

		Redmine_edit_effort_update.driver.findElement(By.id("time_entry_comments")).sendKeys(comments);

		Select Activity = new Select(Redmine_edit_effort_update.driver.findElement(By.id("time_entry_activity_id")));
		Activity.selectByVisibleText("Support");

		Redmine_edit_effort_update.driver.findElement(By.xpath("//*[@value='Create']")).click();
	}

}
