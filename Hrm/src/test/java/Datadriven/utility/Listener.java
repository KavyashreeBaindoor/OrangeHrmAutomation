package Datadriven.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Datadriven.TestCases.BaseTest;

public class Listener extends BaseTest  implements ITestListener  {
	
	public  ExtentReports extent;
    public ExtentTest test;
    public ExtentSparkReporter s;
    public ExtentSparkReporterConfig c;
    public String path;
    
    
    
	
	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("test started");
	test=extent.createTest(result.getMethod().getMethodName()).assignAuthor("kavya").assignCategory("smoke suite").assignDevice("chrome");
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success");
		
	
	try {
		
		test
		.info("this is a info mssg")
		.pass("passed")
		.addScreenCaptureFromPath(screenshot(),"home page of orangehrm captured");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
		
		try {
			
			test
			.info("this is a info mssg")
			.fail("failed")
			.addScreenCaptureFromPath(screenshot(),"home page of orangehrm captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("testskipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("test failed with timeout");
	}

	@Override
	public void onStart(ITestContext context) {
	System.out.println("execution started");
	
	if(extent==null) {
		 extent = new ExtentReports();
		}
	
	 s=new ExtentSparkReporter("Reports/report.html");
	 extent.setSystemInfo("os", System.getProperty("os.version"));
	 extent.setSystemInfo("os", System.getProperty("java.version"));
	 extent.setSystemInfo("os", System.getProperty("os.name"));
	 
	 c=s.config();
	 c.setTheme(Theme.DARK);
	 c.setDocumentTitle("orangeHrm");
	 c.setReportName("AUtomation");
	 c.setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
	 c.setJs( "document.getElementsByClassName('logo')[0].style.display='none'");
	 
	 extent.attachReporter(s);
	 
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("execution finsihed");
		  extent.flush();
		  
		  try {
			Desktop.getDesktop().browse(new File("Reports/report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
