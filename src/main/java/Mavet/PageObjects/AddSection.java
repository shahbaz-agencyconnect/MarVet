package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddSection extends AbstractComponent {

	WebDriver driver;

	public AddSection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Section ']")
	WebElement openSection;

	@FindBy(xpath = "//button[text()=' Add Section ']")
	WebElement addSectionBtn;

	@FindBy(xpath = "//input[@placeholder='Section Name']")
	WebElement sectionName;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void addSection() {
		settingsMenu.click();
		openSection.click();
		addSectionBtn.click();
		sectionName.sendKeys("Navigation Bridge");
		saveBtn.click();

	}
}
