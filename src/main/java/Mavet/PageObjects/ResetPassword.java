package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;

public class ResetPassword extends AbstractComponent {
	WebDriver driver;

	public ResetPassword(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "// a[@href='/account/login']")
	WebElement clientArealoginBtn;

	@FindBy(id = "forget-password")
	WebElement forgotPassBtn;

	@FindBy(xpath = "//input[@name='emailAddress']")
	WebElement email;

	@FindBy(css = ".btn-primary-light ")
	WebElement submitBtn;

	@FindBy(xpath = "//h2[text()='Mail sent']")
	WebElement successMessage;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//h1[text()='Change password']")
	WebElement passwordScreen;	

	@FindBy(xpath = "//input[@name='Password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@name='PasswordRepeat']")
	WebElement confirmPasswordField;
	
	@FindBy(css = ".btn-primary-light")
	WebElement submitPassBtn;	
	
	@FindBy(css = ".d-flex ")
	WebElement landingPage;	

	public void resetPassword() throws FileNotFoundException, InterruptedException {
		waitForWebElementToAppear(clientArealoginBtn);
		clientArealoginBtn.click();
		forgotPassBtn.click();
		email.sendKeys("alia.rohan17@yopmail.com");
		submitBtn.click();
		waitForWebElementToAppear(successMessage);
		confirmBtn.click();
		Thread.sleep(2000);
		ArrayList<String> data = excelRead("Reset Password");
		String username = data.get(0);
		String password=data.get(1);
		String subject = "BVIQ Password Recovery Email";
		resetPasswordLink(username, subject);
		waitForWebElementToAppear(passwordScreen);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		submitPassBtn.click();
		waitForWebElementToAppear(landingPage);
	}
	public void resetPasswordLink(String userName, String subject) throws FileNotFoundException {
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			driver.navigate().to("https://yopmail.com");

			WebElement emailInput = driver.findElement(By.id("login"));
			emailInput.sendKeys(userName);
			driver.findElement(By.cssSelector(".f36")).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement iframe = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
			driver.switchTo().frame(iframe);

//			WebElement subjectLine = 
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]"))));
			String subjectLine = driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]"))
					.getText();
			System.out.println("Subject: " + subjectLine);
			String link = driver.findElement(By.xpath("//p[4]")).getText();
			String regex = "(https?://\\S+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(link);
			if (matcher.find()) {
	            // Group 1 contains the text captured by the parentheses
	            String extractedLink = matcher.group(1);
	            driver.navigate().to(extractedLink);
	            System.out.println("✅ Extracted Link: " + extractedLink);
	        } else {
	            System.out.println("❌ Link not found in the text.");
	        }
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
