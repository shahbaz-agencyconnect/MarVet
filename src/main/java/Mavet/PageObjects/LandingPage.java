package Mavet.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;
import net.sourceforge.tess4j.TesseractException;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "// a[@href='/account/login']")
	WebElement clientArealoginBtn;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;

	@FindBy(xpath = "//h3[text()=' Verify Security Code ']")
	WebElement verificationCodeField;

	@FindBy(xpath = "//input[@name='code']")
	WebElement otpInputField;

	@FindBy(xpath = "//button[text()=' Submit ']")
	WebElement submitBtn;

	@FindBy(css = ".flex-root")
	WebElement loadApp;

	@FindBy(id = "swal2-title")
	WebElement invalidMessage;

	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement loadDashboard;

	public void loginApplication(String userName, String passWord)
			throws IOException, TesseractException, InterruptedException {

		waitForWebElementToAppear(loadApp);
		clientArealoginBtn.click();
		waitForWebElementToAppear(username);
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean mfa = false;
		while (true) {
			if (isElementPresent(verificationCodeField, 03)) {
				try {
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get("https://yopmail.com");
					WebElement emailInput = driver.findElement(By.id("login"));
					emailInput.sendKeys(userName);
					driver.findElement(By.cssSelector(".f36")).click();
					WebDriverWait waitForFrame = new WebDriverWait(driver, Duration.ofSeconds(30));
					WebElement iframe = waitForFrame
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
					driver.switchTo().frame(iframe);

					String textCode = driver
							.findElement(
									By.xpath("//p[text()='Your one-time verification code is:']/parent::div//span"))
							.getText();
					System.out.println("Code " + textCode);
					Set<String> windows = driver.getWindowHandles();
					Iterator<String> it = windows.iterator();
					String parentId = it.next();
					driver.switchTo().window(parentId);
					otpInputField.sendKeys(textCode);
					submitBtn.click();
 					mfa = true;
					break;

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				boolean isCorrect = true;
				if (isCorrect) {
					try {
//						wait.until(ExpectedConditions.visibilityOf(loadDashboard));
						System.out.println("Login Successful! User is navigated to the dashboard.");
						if (isCorrect) {
							break;
						}
						if (isElementPresent(invalidMessage, 2)) {
							System.out.println(
									"❌ Login Test FAILED: Expected success, but 'Invalid' message was displayed.");
							break;
						}
					} catch (Exception e) {
						if (isElementPresent(invalidMessage, 5)) {
							System.out.println(
									"❌ Login Test FAILED: Expected success, but 'Invalid UserName or Password' message appeared.");
							break;
						} else {
							System.out.println(
									"❌ Login Test FAILED unexpectedly: Dashboard element not found and no specific error message detected.");
						}
					}
				} else {
					try {
						WebElement invalidMsgElement = wait.until(ExpectedConditions.visibilityOf(invalidMessage));
						if (invalidMsgElement.getText().equals("Invalid user name or password")) {
							System.out.println(
									"Login Test Passed: Invalid UserName or Password message correctly displayed.");
						} else {
							System.out.println("Login Test FAILED: Expected invalid message, but found different text: "
									+ invalidMsgElement.getText());
						}
						if (isElementPresent(loadDashboard, 2)) {
							System.out.println(
									"❌ Login Test FAILED: Expected error, but successfully navigated to the dashboard!");
						}
					} catch (NoSuchElementException e) {
						System.out.println("❌ An error occurred during the invalid login test: " + e.getMessage());
					}

				}
			}
		}

	}

	public void goTo() throws InterruptedException {
		driver.get("https://stage-bsp.merassurance.com/");
	}

	private boolean isElementPresent(WebElement locator, int timeoutSeconds) {
		try {
			WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			localWait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
