package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;

public class TwoFactorAuth extends AbstractComponent {
	WebDriver driver;

	public TwoFactorAuth(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "button-profile-menu")
	WebElement profileIcon;

	@FindBy(xpath = "//a[text()=' Account Settings ']")
	WebElement accountSettings;

	@FindBy(xpath = "//input[@id='emailMfaToggle']")
	WebElement mfaBtn;

	@FindBy(xpath = "//p[text()='Your one-time verification code is:']/parent::div//span")
	WebElement verificationCode;

	@FindBy(css = ".spinned-border")
	WebElement loader;

	@FindBy(id = "otpCodeInput")
	WebElement otpInputField;

	@FindBy(xpath = "//button[text()=' Verify ']")
	WebElement verifyBtn;

	public void authentication() throws FileNotFoundException {
		profileIcon.click();
		accountSettings.click();
		waitForWebElementToAppear(mfaBtn);
		mfaBtn.click();
		waitForWebElementToDisappear(loader);
		ArrayList<String> data = excelRead("Login");
		String username = data.get(0);
		String subject = "MER Assurance Verification Code";
		getMFACode(username, subject);
	}

	public void getMFACode(String userName, String subject) throws FileNotFoundException {
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://yopmail.com");
			WebElement emailInput = driver.findElement(By.id("login"));
			emailInput.sendKeys(userName);
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
			otpInputField.sendKeys(textCode);
			verifyBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
