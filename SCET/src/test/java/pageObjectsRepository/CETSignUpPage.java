package pageObjectsRepository;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BrowserHelper;
import common.ExcelHelper;
import common.LibraryFunctions;

public class CETSignUpPage implements LibraryFunctions
{
	WebDriver driver;
	By byDegree = By.id("ddlgraduation_id");
	By byMobileNumber = By.id("stdfrm_login_id");
	By byEmail = By.id("stdfrm_email");
	By byFirstName = By.id("stdfrm_firstname");
	By byLastName = By.id("stdfrm_lastname");
	By byAdharNo = By.id("stdfrm_aadhaar");
	By byPassword = By.id("stdfrm_password");
	By byConfirmPassword = By.id("stdfrm_confirmPwd");
	By byRegister = By.id("sendotp");
	By byNotNRIStudent= By.xpath("//*[@id='stdfrm_is_NRI' and @value='N']");
	By byDOB = By.id("txtDate");
	By byGender = By.xpath("//*[@id='stdfrm_gender' and @value='M']");
	 
	
	public CETSignUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void studentRegistration(ExcelHelper objExcel) throws Exception
	{
		driver.navigate().to("http://14.143.45.237:8120/Student/Registration");
		Thread.sleep(5);
		try{
			driver.findElement(byDegree).click();
			WebElement degreeDrpDown = driver.findElement(byDegree);
			LibraryFunctions.selectDropDownValue(driver,degreeDrpDown,"UG-Under Graduate");
			driver.findElement(byNotNRIStudent).click();
			driver.findElement(byMobileNumber).sendKeys("9778457821");
			driver.findElement(byEmail).sendKeys("xyz@gmail.com");
			driver.findElement(byFirstName).sendKeys("abc");
			driver.findElement(byLastName).sendKeys("mnq");
			driver.findElement(byPassword).sendKeys("Abc@123");
			driver.findElement(byConfirmPassword).sendKeys("Abc@123");
			driver.findElement(byGender).click();
			driver.findElement(byDOB).click();
			LibraryFunctions.enterDOB(driver, "18/Jun/1989");
			driver.findElement(byRegister).click();
			LibraryFunctions.popUpHandle(driver);
			Thread.sleep(5);
		}
		catch(Exception e)
		{
			BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);
			e.printStackTrace();
			Assert.fail("Student Registration Failed due to exception!");
		}
		
	}
}
