package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element library
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMERS_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"citi\"]")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"group\"]")
	WebElement GROUP_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMERS_BUTTON_LOCATOR;

	// Method to interact with the elements
	public void ClickCustomersButton() {
		CUSTOMERS_BUTTON_LOCATOR.click();
	}

	public void ClickAddCustomersButton() {
		ADD_CUSTOMER_BUTTON_LOCATOR.click();
	}
	
	String enteredName;
	public void insertFullName(String fullname) {
		String enteredName = fullname + BasePage.RandomNumGenerator();
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}

	public void insertCompanyName(String company) {
		BasePage.dropDown(COMPANY_DROPDOWN_LOCATOR, company);
	}

	public void insertEmail(String email) {
		String enteredEmail = BasePage.RandomNumGenerator() + email;
		EMAIL_FIELD_LOCATOR.sendKeys(enteredEmail);
	}

	public void insertPhoneNumber(String PhoneNum) {
		PHONE_FIELD_LOCATOR.sendKeys(PhoneNum);
	}

	public void insertAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}

	public void insertGroup(String group) {
		BasePage.dropDown(GROUP_DROPDOWN_LOCATOR, group);
	}

	public void clickOnSaveButton() {
		SAVE_BUTTON_LOCATOR.click();
		BasePage.waitForElement(driver, 3, By.xpath("//*[@id=\"summary\"]"));
	}

	public void clickOnListCustomersButton() {
		LIST_CUSTOMERS_BUTTON_LOCATOR.click();
	}

	
	//DYNAMIC TABLE:
	
	
	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2] 
	
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";

	public void verifyEnteredCustomerAndDelete() {
    
		//reminder how for loop works:within () you have the conditions:1 starting point,2 ending point and 3 increment or decrement)
		for(int i = 1;i <= 5 ; i++ ) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//System.out.println(name);
			Assert.assertEquals(name, enteredName, "Name does not match!!!");
			
			if(name.contains(enteredName)) {
				System.out.println("Entered name exists");
				driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[3]/following-sibling::td[4]/a[2] ")).click();
				BasePage.waitForElement(driver, 2,By.xpath("/html/body/div[1]/div/div/div[2]/button[2]"));
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			}
			
			
			//line 108 to 111 you look for the pattern,wherever it is changing you will replace it into i,break it down into before_xpath and after_xpath.Then you will be using a for loop line 120,you will create a customized xpath line 121 and you save in a bucket (String name)
			// you don't need to print line 122. And you just need to do the assertion line 123
			//line 125 to 129 is not mandatory
			//line 120 to 123 will do the verification for your dynamic table
			
		    //From line 114 to line 124,it is the code for checking a dynamic web table:
			//if you want to do assertion line 120 to 123 will be enough
			//for the deletion,line 128 to 132 
			//line 120 to 123 minus 122 which is not needed will do the verification for your dynamic table
			//line 125 to 129 is not mandatory,it was done to check the delete feature
			
			//line 125 to 126 can consider as an assertion as well instead of 123. Line 123 is the regular practice 
			
			//So in summary LINE 114,115 AND 120 TO 123 THEY ARE GOOD ENOUGH TO CHECK THE DATA YOU ARE INSERTING INTO A DYNAMIC WEB TABLE !!!
		}
		
	}

}
