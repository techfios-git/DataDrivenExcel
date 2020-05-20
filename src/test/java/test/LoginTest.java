package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	ExcelReader reader = new ExcelReader("./Data/TF_TestData.xlsx");
	String userName = reader.getCellData("LoginInfo", "UserName", 3);
	String passWord = reader.getCellData("LoginInfo", "Password", 3);
	
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();
		
	}

}
