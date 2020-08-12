package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
   WebDriver driver;
   
   ExcelReader reader = new ExcelReader("./data/Book1.xlsx");
   String userName = reader.getCellData("LoginInfo", "UserName", 2);
   String password = reader.getCellData("LoginInfo", "Password", 2);
   
   
   @Test
   public void UserShouldBeAbleToLogin() {
	   driver = BrowserFactory.init();
	   
	   LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	   loginpage.enterUserName(userName);
	   loginpage.enterPassword(password);
	   loginpage.clickSignInButton();
	   
	   DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
	   dashboard.verifyDashBoardElement();
	   
	   BrowserFactory.teardown();
}
   
}
