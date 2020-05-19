package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class DashboardTest {
	WebDriver driver;
	@Test
	public void dashboardVerification() {
		// connect with BrowserFactory
				driver = BrowserFactory.init();

				// create page factory to call the Page
				LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
				DashboardPage DashboardPage = PageFactory.initElements(driver, DashboardPage.class);
				// call the methods
				LoginPage.enterUserName("techfiosdemo@gmail.com");
				LoginPage.enterPassword("abc123");
				LoginPage.clickOnSignInButton();
				DashboardPage.dashboardPageVisibility();



}}