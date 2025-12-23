package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class VettingManagement extends AbstractComponent {
	WebDriver driver;

	public VettingManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Clearance Management']")
	WebElement clearanceMgmtMenu;
	
	@FindBy(xpath = "//input[@formcontrolname='filterText']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;	
	
	@FindBy(id = "dropdownButton")
	WebElement actionBtn;
	
	@FindBy(xpath = "//a[text()=' Start Vet ']")
	WebElement startVetOption;
	
	@FindBy(id = "kt_wrapper")
	WebElement loadSummaryPage;	
	
	@FindBy(xpath = "//button[text()=' ACCEPTED ']")
	WebElement acceptBtn;
	
	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void manageVetting(String vesselNumber) throws InterruptedException {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(clearanceMgmtMenu);
		clearanceMgmtMenu.click();
		Thread.sleep(2000);
		searchBox.sendKeys(vesselNumber);
		searchIcon.click();
		Thread.sleep(2000);
		actionBtn.click();
		startVetOption.click();
		waitForWebElementToAppear(loadSummaryPage);
//		acceptBtn.click();
//		confirmBtn.click();
	}
}
