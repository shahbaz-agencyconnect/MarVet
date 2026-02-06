package Marvet.TwoFactorAuth;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class TwoFactorAuthentication extends Login {
	public void twoFactorAuth() {
		waitForWebElementToAppear(By.id("button-profile-menu"));
		WebElement profileIcon = driver.findElement(By.id("button-profile-menu"));
		profileIcon.click();

		WebElement accountSettings = driver.findElement(By.xpath("//a[text()=' Account Settings ']"));
		accountSettings.click();

		clickDesiredIcon(By.id("emailMfaToggle"));
//		WebElement mfaBtn = driver.findElement(By.xpath("//input[@id='emailMfaToggle']"));
//		mfaBtn.click();
		waitForWebElementToDisappear(By.cssSelector(".spinned-border"));

		String username = "zamri.jumaat@yopmail.com";
		String subject = "MER Assurance Verification Code";

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://yopmail.com");
			WebElement emailInput = driver.findElement(By.id("login"));
			emailInput.sendKeys(username);
			driver.findElement(By.cssSelector(".f36")).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement iframe = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
			driver.switchTo().frame(iframe);

			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]"))));
			String subjectLine = driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]")).getText();
			System.out.println("Subject: " + subjectLine);
			String textCode = driver
					.findElement(By.xpath("//p[text()='Your one-time verification code is:']/parent::div//span"))
					.getText();
			System.out.println("Code " + textCode);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentId = it.next();
			driver.switchTo().window(parentId);
			WebElement otpInputField = driver.findElement(By.id("otpCodeInput"));
			otpInputField.sendKeys(textCode);
			WebElement verifyBtn = driver.findElement(By.xpath("//button[text()=' Verify ']"));
			verifyBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
