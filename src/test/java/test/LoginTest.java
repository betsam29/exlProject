package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;

	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");

	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboradValidationText = "Dasboard";
	String alertValidationText = "Please enter your user name";
	String alertValidationText2 = "Please enter your password";

	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.loginSubmit();
		// DashboardPage dashboardpage = PageFactory.initElements(driver,
		// DashboardPage.class);
		// dashboardpage.valitateDashboardPage(dashboradValidationText);
		BrowserFactory.tearDown();

	}

	public void validateLoginAlertMesg() {
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginSubmit();

	}

}
