package Datadriven.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	private WebDriver driver;
	
	public Login(WebDriver d){
		this.driver=d;
	}
	
	
	//locators using By class
	private By username =By.name("username");
	private By password =By.name("password");
	private By loginBtn =By.xpath("//button[contains(@class,' oxd-button--main')]");
	private By ErrorMssg=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	
	//actions
	
	public void userName(String un){
		
		if(driver.findElement(username).isDisplayed() && driver.findElement(username).isEnabled())
		driver.findElement(username).sendKeys(un);
		
	}

	public void password(String pass){
		if(driver.findElement(password).isDisplayed() && driver.findElement(password).isEnabled())
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin(){
		
		if(driver.findElement(loginBtn).isDisplayed() && driver.findElement(loginBtn).isEnabled())
		driver.findElement(loginBtn).click();
	}
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	
	public String getErrorMssg()
	{
		return driver.findElement(ErrorMssg).getText();
	}
	public void doLogin(String un,String psw)
	{
		userName(un);
		password(psw);
		clickLogin();
		
		
	}
	
	

}
