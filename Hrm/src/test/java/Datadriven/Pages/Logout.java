package Datadriven.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
	
private WebDriver driver;
	
	Logout(WebDriver d){
		this.driver=d;
	}
	
	private By dropDownIcon=By.xpath("//span[@class='oxd-userdropdown-tab']/img[@alt='profile picture']");
	private By logoutBtn=By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a");
	
	public void logout() {
		driver.findElement(dropDownIcon).click();
		driver.findElement(dropDownIcon).click();
	}
	

}
