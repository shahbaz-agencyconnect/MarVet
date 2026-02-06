package Marvet.ForgotPassword;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
	public void resetForgottenPassword() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage-bsp.merassurance.com/account/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forget-password")));
		WebElement forgotPassBtn = driver.findElement(By.id("forget-password"));
		forgotPassBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailAddress")));
		WebElement emailAddress = driver.findElement(By.name("emailAddress"));
		emailAddress.sendKeys("ardella4@yopmail.com");
		WebElement submitBtn = driver.findElement(By.className("btn-primary-light"));
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail sent']")));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		Thread.sleep(2000);

		// Generate Reset Password Link
		String subject = "BVIQ Password Recovery Email";

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			driver.navigate().to("https://yopmail.com");

			WebElement emailInput = driver.findElement(By.id("login"));
			emailInput.sendKeys("ardella4@yopmail.com");
			driver.findElement(By.cssSelector(".f36")).click();

			WebDriverWait waitForLink = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement iframe = waitForLink
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
			driver.switchTo().frame(iframe);

//			WebElement subjectLine = 
			waitForLink.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]"))));
			String subjectLine = driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]")).getText();
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

		String password = "123qwe";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Change password']")));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='Password']"));
		passwordField.sendKeys(password);
		WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='PasswordRepeat']"));
		confirmPasswordField.sendKeys(password);
		WebElement submitPassBtn = driver.findElement(By.cssSelector(".btn-primary-light"));
		submitPassBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".d-flex ")));
		driver.quit();
	}
}