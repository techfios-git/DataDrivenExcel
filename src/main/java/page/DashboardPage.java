package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	//create constructor 
	//passing local driver
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	//element library
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Dashboard')]")
	WebElement DASHBOARD_TAB_LOCATOR;
	
	
	//method
	


	public void dashboardPageVisibility() {
		wetForElement(driver,2,DASHBOARD_TAB_LOCATOR);
		DASHBOARD_TAB_LOCATOR.click();
		
	}


	private void wetForElement(WebDriver driver, int time, WebElement locator) {
WebDriverWait wait =new WebDriverWait(driver,time);
wait.until(ExpectedConditions.visibilityOf(DASHBOARD_TAB_LOCATOR));
		
	}

}
