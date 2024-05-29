package Datadriven.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Utility {
	
	
	//screenshot
	public static String getScreenshot(WebDriver driver) throws IOException {
		
		 addWait();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE); 
		File dest=new File("./Screenshots/"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(f,dest);
		
		return dest.getAbsolutePath();
		
		
	}
	
	public static void addWait()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//WebDriverWait()=Explicit Wait
			
			public static WebElement waitForPresenceOfElement(WebDriver driver,By loc)
			{
				WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
				return obj.until(ExpectedConditions.presenceOfElementLocated(loc));
			}
			
			public static WebElement waitForElementClickable(WebDriver driver,By loc)
			{
				WebDriverWait btnobj=new WebDriverWait(driver,Duration.ofSeconds(5));
				return btnobj.until(ExpectedConditions.elementToBeClickable(loc));
			}
			
			public static WebElement waitForVisibilityOfElement(WebDriver driver,By loc)
			{
				WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
				return obj.until(ExpectedConditions.visibilityOfElementLocated(loc));
			}

			
			public static boolean waitForUrlContains(WebDriver driver,String url)
			{
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				return wait.until(ExpectedConditions.urlContains(url));
						
			}
			
			public static boolean waitForTitleContains(WebDriver driver,String title)
			{
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				return wait.until(ExpectedConditions.titleContains(title));
						
			}
			
	

}
