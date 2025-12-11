package Marvet.AbstractComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForWebElementToDisappear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
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

	public void verificationLink(String userName, String subject) throws FileNotFoundException {
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
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
