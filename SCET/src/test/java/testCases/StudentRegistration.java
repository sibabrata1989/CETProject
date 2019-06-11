package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;
import pageObjectsRepository.*;

public class StudentRegistration
{
	WebDriver driver = null;
	ExcelHelper objExcel = null;
	
	
	@BeforeClass
	public void classSetup()
	{
		objExcel = new ExcelHelper();
		objExcel.SetListHeader(TestConfig.testDataDir + "TestData_Google.xlsx", 0);
		driver = BrowserHelper.LaunchBrowser(driver);
	}

	@BeforeTest
	public void TestSetUp()
	{
		TestConfig.SetCommonEnv();
	}
	
	@Test
	public void TC01_StudentRegistration() throws Exception
	{
		
		String tcName = "TC01_SearchSelenium";
		System.out.println(tcName);
		objExcel.SetListData(TestConfig.testDataDir + "TestData_Google.xlsx", tcName);
		driver.get((TestConfig.SCETUrl));
		CETSignUpPage registrationPage = new CETSignUpPage(driver);
		registrationPage.studentRegistration(objExcel);
	}

	
	@AfterMethod
	public void MethodCleanUp()
	{
		objExcel.ClearDataList();
		
	}
	@AfterClass
	public void CloseDriver()
	{
		//driver.close();
	}
	
}
