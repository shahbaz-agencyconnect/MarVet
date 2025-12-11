package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddInspectionType extends AbstractComponent {
	WebDriver driver;

	public AddInspectionType(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Inspection Type ']")
	WebElement openInspectionType;

	@FindBy(xpath = "//button[text()=' Add Inspection Type ']")
	WebElement addInspectionBtn;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement inspectionName;

	@FindBy(xpath = "//input[@placeholder='Title Bar']")
	WebElement titleBar;

	@FindBy(xpath = "//input[@placeholder='Summary']")
	WebElement summary;

	@FindBy(xpath = "(//div[contains(@id,'searchable-select')]//input)[2]")
	WebElement categoryDropdown;

	@FindBy(xpath = "//span[text()='BVIQ']")
	WebElement selectCategory;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void addInspectionType() {
		settingsMenu.click();
		openInspectionType.click();
		addInspectionBtn.click();
		inspectionName.sendKeys("Pre-hire/pre mobilisation inspection");
		titleBar.sendKeys("Pre-hire/pre ");
		summary.sendKeys("Cuts, excessive fuzzing, or flattening of the rope fibers, especially at points of contact with fairleads, chocks, or the quay.");
		categoryDropdown.click();
		selectCategory.click();
		saveBtn.click();
	}
}
