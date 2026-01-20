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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;

public class PostRegisteredLogin extends AbstractComponent {
	WebDriver driver;
	String extractedEmail;
	String extractedPassword;
	public PostRegisteredLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;
	
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//h1[text()='MER Assurance Login ']")
	WebElement loginPage;	
	
	public void loginOnPostRegistration() throws FileNotFoundException, InterruptedException {
		AddUser user = new AddUser(driver);
		user.addnewUser();
		waitForWebElementToAppear(successMsg);
		logoutBtn.click();
		waitForWebElementToAppear(loginPage);
		ArrayList<String> data = excelRead("Add User");
		String username = data.get(2);
		getUserCreds(username, "BVIQ Credentials");
	}

	public void getUserCreds(String userName, String subject) throws FileNotFoundException {
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
			String subjectLine = driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]")).getText();
			System.out.println("Subject: " + subjectLine);

			String useremail = driver.findElement(By.xpath("//p[4]")).getText();
			String regexMail = "Login Email:\\s*(\\S+@\\S+\\.\\S+)";
			Pattern patternMail = Pattern.compile(regexMail);
			Matcher matcherMail = patternMail.matcher(useremail);
			
			if (matcherMail.find()) {
				// Group 1 contains the text captured by the parentheses (the email address)
				extractedEmail = matcherMail.group(1);
				System.out.println("✅ Extracted Email: " + extractedEmail);
			} else {
				System.out.println("❌ Email not found using the pattern.");
			}

			String userPassword = driver.findElement(By.xpath("//p[5]")).getText();
			String regexPass = "Password:\\s*(\\S+)";

			Pattern patternPass = Pattern.compile(regexPass);
			Matcher matcherPass = patternPass.matcher(userPassword);

			
			if (matcherPass.find()) {
				// Group 1 contains the captured password
				extractedPassword = matcherPass.group(1);
				System.out.println("✅ Extracted Password: " + extractedPassword);
			} else {
				System.out.println("❌ Password not found using the pattern.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://stage-bsp.merassurance.com/account/login");
		username.sendKeys(extractedEmail);
		password.sendKeys(extractedPassword);
		loginBtn.click();
	}
}
