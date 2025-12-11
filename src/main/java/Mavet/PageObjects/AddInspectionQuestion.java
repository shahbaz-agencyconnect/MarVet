package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddInspectionQuestion extends AbstractComponent {

	WebDriver driver;

	public AddInspectionQuestion(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Inspection Question ']")
	WebElement openInspectionQuestion;

	@FindBy(xpath = "//button[text()=' Add Inspection Question ']")
	WebElement addInspectionQuesBtn;

	@FindBy(xpath = "//label[text()='Inspection Type ']/parent::div//input")
	WebElement inspectionTypeDropdown;

	@FindBy(xpath = "//label[text()='Section ']/parent::div//input")
	WebElement sectionDropdown;

	@FindBy(xpath = "//input[@placeholder='Question No']")
	WebElement questionNum;

	@FindBy(xpath = "//input[@placeholder='Section Order']")
	WebElement sectionOrder;

	@FindBy(xpath = "//label[text()='Question ']/parent::div//input")
	WebElement questionDropdown;

	@FindBy(xpath = "//label[text()='Risk Level ']/parent::div//input")
	WebElement riskLevelDropdown;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void inspectionQuestion() throws FileNotFoundException {
		settingsMenu.click();
		openInspectionQuestion.click();
		addInspectionQuesBtn.click();
		ArrayList<String> data = excelRead("Inspection Question");

		inspectionTypeDropdown.click();
		String inspectionType = data.get(0);
		driver.findElement(By.xpath("//span[text()='" + inspectionType + "']")).click();

		sectionDropdown.click();
		String section = data.get(1);
		driver.findElement(By.xpath("//span[text()='" + section + "']")).click();

		String quesNum = data.get(2);
		questionNum.sendKeys(quesNum);

		String secOrder = data.get(3);
		sectionOrder.sendKeys(secOrder);

		questionDropdown.click();
		String question = data.get(4);
		driver.findElement(By.xpath("//span[text()='" + question + "']")).click();

		riskLevelDropdown.click();
		String riskLevel = data.get(5);
		driver.findElement(By.xpath("//span[text()='" + riskLevel + "']")).click();

		saveBtn.click();
	}
}
