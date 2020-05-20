package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.BasePage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {
	
WebDriver driver;
	
	ExcelReader reader = new ExcelReader("./Data/TF_TestData.xlsx");
	String userName = reader.getCellData("LoginInfo", "UserName", 2);
	String passWord = reader.getCellData("LoginInfo", "Password", 2);
	
	String fullName = reader.getCellData("AddContactInfo", "FullName", 2);
	String CompanyName = reader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String phone = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	
	@Test
	public void userShouldBeAbleAddContact() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();
		
		AddContactPage addContact = PageFactory.initElements(driver, AddContactPage.class);
		
		addContact.crmButton();
		addContact.addContactButton();
		
		addContact.fullNameField(fullName);
		addContact.companyField(CompanyName);
		addContact.emailField(email);
		addContact.phoneField(phone);
		addContact.addressField(address);
		addContact.cityField(city);
		addContact.stateField(state);
		addContact.zipField(zip);
		addContact.submitButtonClick();
		addContact.clickListContacts();
		
		addContact.verifyEnteredContactAndDelete();
		
		
		
	}

}
