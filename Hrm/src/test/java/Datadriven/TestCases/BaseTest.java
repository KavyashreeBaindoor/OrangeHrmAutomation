package Datadriven.TestCases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Datadriven.Pages.AdminPage;
import Datadriven.Pages.Login;
import Datadriven.Pages.Logout;
import Datadriven.utility.Listener;
import Datadriven.utility.PropertiesConfig;
import Datadriven.utility.Utility;

public class BaseTest{
	
	public PropertiesConfig p1;
	public static WebDriver driver;
	public Login lp;
	public Logout lo;
	public AdminPage ad;
	
	
	
	@BeforeMethod//For all Pages Browser setup
	public void setUpBrowser()
	{
		p1=new PropertiesConfig();
		driver=new ChromeDriver();
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p1.getData("base_url"));
		Reporter.log("Log: Apllication is open",true);
		lp=new Login(driver);
		lo=new Logout(driver);
		ad=new AdminPage(driver);
		
		
		
	}
	
	
	
	 
	 
	  
	  @AfterMethod
	  public void teardown() {
		  driver.quit();
	  }
	
	
	
	public static String  screenshot() throws IOException {
		return Utility.getScreenshot(driver);
		
	}
	
	
	
	

	
	 
	 
	

}
