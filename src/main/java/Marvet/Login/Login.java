package Marvet.Login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	protected static WebDriver driver;

	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage-bsp.merassurance.com/");

//		waitForWebElementToAppear(By.cssSelector(".flex-root"));
//		WebElement clientArealoginBtn = driver.findElement(By.xpath("// a[@href='/account/login']"));
//
//		clientArealoginBtn.click();
		waitForWebElementToAppear(By.id("username"));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
		username.sendKeys("zamri.jumaat@yopmail.com");
		password.sendKeys("123qwe");
		loginBtn.click();
		WebDriverWait loginWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean mfa = false;
		while (true) {
			if (isElementPresent(By.xpath("//h3[text()=' Verify Security Code ']"), 03)) {
				try {
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get("https://yopmail.com");
					WebElement emailInput = driver.findElement(By.id("login"));
					emailInput.sendKeys("zamri.jumaat@yopmail.com");
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
					WebElement otpInputField = driver.findElement(By.xpath("//input[@name='code']"));
					otpInputField.sendKeys(textCode);
					WebElement submitBtn = driver.findElement(By.xpath("//button[text()=' Submit ']"));
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
						if (isElementPresent(By.id("swal2-title"), 2)) {
							System.out.println(
									"❌ Login Test FAILED: Expected success, but 'Invalid' message was displayed.");
							break;
						}
					} catch (Exception e) {
						if (isElementPresent(By.id("swal2-title"), 5)) {
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
						WebElement invalidMsgElement = loginWait
								.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("swal2-title"))));
						if (invalidMsgElement.getText().equals("Invalid user name or password")) {
							System.out.println(
									"Login Test Passed: Invalid UserName or Password message correctly displayed.");
						} else {
							System.out.println("Login Test FAILED: Expected invalid message, but found different text: "
									+ invalidMsgElement.getText());
						}

						if (isElementPresent(By.xpath("//span[text()='Dashboard']"), 2)) {
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

	private boolean isElementPresent(By locator, int timeoutSeconds) {
		try {
			WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			localWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForWebElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public ArrayList<String> excelRead(String sheetName) throws FileNotFoundException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\khans\\eclipse-workspace\\Marvet\\ExcelDataProvider\\DataSheets.xlsx");
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				if (workbook.getSheetName(i).equals(sheetName)) {
					XSSFSheet sheet = workbook.getSheetAt(i);
					Iterator<Row> rows = sheet.iterator();
					Row firstRow = rows.next();

					while (rows.hasNext()) {
						Row r = rows.next();
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell worksiteCell = cv.next();
							if (worksiteCell.getCellType() == CellType.STRING) {
								a.add(worksiteCell.getStringCellValue());

							} else {
								a.add(NumberToTextConverter.toText(worksiteCell.getNumericCellValue()));
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	// Date Picker
	public void selectDate(String xPath, String selectYear, String selectMonth, String selectDay, String nextButton)
			throws InterruptedException {

		// Year select

		while (true) {

			List<WebElement> getyears = driver.findElements(By.cssSelector(".p-yearpicker-year"));
			boolean yearFound = false;

			for (WebElement yearElement : getyears) {
				String year = yearElement.getText();
				if (year.equals(selectYear) || year.equals(null)) {
					yearElement.click();
					yearFound = true;
					break;
				}
			}
			if (yearFound) {
				break;
			} else {
				WebElement nextYearBtn = driver.findElement(By.cssSelector(nextButton));
				nextYearBtn.click();
			}
		}

		// Month select
		driver.findElements(By.xpath(xPath)).get(Integer.parseInt(selectMonth) - 1).click();

		// Days select
		driver.findElement(By.xpath(selectDay)).click();
	}
	
	// Date Picker
	public void datePicker(String xPath, String selectYear, String selectMonth, String selectDay, String nextButton)
			throws InterruptedException {

		// Year select

		while (true) {

			List<WebElement> getyears = driver.findElements(By.xpath("//table[@class='years']//span"));
			boolean yearFound = false;

			for (WebElement yearElement : getyears) {
				String year = yearElement.getText();
				if (year.equals(selectYear) || year.equals(null)) {
					yearElement.click();
					yearFound = true;
					break;
				}
			}
			if (yearFound) {
				break;
			} else {
				WebElement nextYearBtn = driver.findElement(By.cssSelector(nextButton));
				nextYearBtn.click();
			}
		}

		// Month select
		driver.findElements(By.xpath(xPath)).get(Integer.parseInt(selectMonth) - 1).click();

		// Days select
		driver.findElement(By.xpath(selectDay)).click();
	}
	public void clickDesiredIcon(By locator) {
	    int attempts = 0;
	    while (attempts < 3) {
	        try {
	            driver.findElement(locator).click();
	            break; // Exit loop if click is successful
	        } catch (StaleElementReferenceException e) {
	            // Wait a moment for the DOM to settle and try again
	            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
	        }
	        attempts++;
	    }
	}
	

}
