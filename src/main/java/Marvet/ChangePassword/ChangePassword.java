package Marvet.ChangePassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Marvet.Login.Login;

public class ChangePassword extends Login{
	
	public void resetPasssword() {

//		waitForWebElementToAppear(By.id("button-profile-menu"));
		WebElement profileIcon=driver.findElement(By.id("button-profile-menu"));
		profileIcon.click();
		
		WebElement changePassItem=driver.findElement(By.xpath("//a[text()=' Change Password ']"));
		changePassItem.click();
		
		waitForWebElementToAppear(By.id("CurrentPassword"));
				
		WebElement oldPassField=driver.findElement(By.id("CurrentPassword"));
		oldPassField.sendKeys("Admin@123");
		
		WebElement newPassField=driver.findElement(By.id("NewPassword"));
		newPassField.sendKeys("123qwe");
		
		WebElement confirmPassField=driver.findElement(By.id("NewPasswordRepeat"));
		confirmPassField.sendKeys("123qwe");
		
		WebElement updateBtn=driver.findElement(By.xpath("//span[text()='Update']"));
		updateBtn.click();
	}

}
