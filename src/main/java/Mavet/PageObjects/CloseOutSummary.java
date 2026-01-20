package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class CloseOutSummary extends AbstractComponent {
	WebDriver driver;

	public CloseOutSummary(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[contains(@placeholder,'Vessel Name')]")
	WebElement searchVessel;	
	
	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;
	
	@FindBy(xpath = "//a[@title='MUHARIB (9856385)']")
	WebElement selectVessel;
	
	@FindBy(xpath = "//span[contains(text(),'Pre-Hire Inspection')]")
	WebElement preHireInspection;	
	
	@FindBy(xpath = "//button[text()=' Observation Close-outs ']")
	WebElement observationBtn;	
	
	@FindBy(xpath = "//span[text()=' Open ']")
	WebElement openBtn;	
	
	@FindBy(xpath = "//button[text()='Close-out Accepted']")
	WebElement closeOutAcceptedBtn;
	
	@FindBy(xpath = "//span[text()='Observation updated successfully']")
	WebElement confirmMsg;		
	
	public void closeOut() {
		searchVessel.sendKeys("MUHARIB");
		waitForWebElementToAppear(listLoad);
		selectVessel.click();
		preHireInspection.click();
		observationBtn.click();
		openBtn.click();
		closeOutAcceptedBtn.click();
		waitForWebElementToDisappear(confirmMsg);
		openBtn.click();
		closeOutAcceptedBtn.click();
		waitForWebElementToDisappear(confirmMsg);	
		openBtn.click();
		closeOutAcceptedBtn.click();
	}
}
