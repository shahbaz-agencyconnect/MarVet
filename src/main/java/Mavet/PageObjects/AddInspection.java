package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddInspection extends AbstractComponent {
	WebDriver driver;

	public AddInspection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Inspection Management']")
	WebElement inspectionMenu;
	
	@FindBy(xpath = "//span[text()='Create Inspection']")
	WebElement addInspectionBtn;
	
	@FindBy(css = ".modal-content")
	WebElement inspectionDialog;
	
	@FindBy(xpath = "//label[text()='Inspection ']/parent::div//input")
	WebElement inspectionName;
	
	@FindBy(xpath = "//span[text()='Loading...']")
	WebElement listLoader;	
	
	@FindBy(xpath = "//label[text()='Client ']/parent::div//input")
	WebElement clientName;

	@FindBy(xpath = "//label[text()='DOC ']/parent::div//input")
	WebElement docName;
	
	@FindBy(xpath = "//label[text()='Vessel ']/parent::div//input")
	WebElement vesselName;
	
	@FindBy(xpath = "//label[text()='Port ']/parent::div//input")
	WebElement portName;
	
	@FindBy(xpath = "//label[text()='Inspector ']/parent::div//input")
	WebElement inspectorName;
	
	@FindBy(id="date")
	WebElement datePicker;

	@FindBy(xpath = "(//button[contains(@class,'current')])[2]")
	WebElement selectYear;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;		
	
	public void addInspection() throws InterruptedException, FileNotFoundException {
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		ArrayList<String> data = abstractComponent.excelRead("Add Inspection");	
		String inspection=data.get(0);
		String client=data.get(1);
		String doc=data.get(2);
		String vessel=data.get(3);		
		String port=data.get(4);
		String inspector=data.get(5);		
		String monthFromXpath = "//table[@class='months']//span";
		String year = data.get(6);
		String month = data.get(7);
		String day = data.get(8);
		String fromDay = "//span[@class='ng-star-inserted' and text()='"+day+"']";
		String nextButton = ".next";
		
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(inspectionMenu);
		inspectionMenu.click();
		addInspectionBtn.click();
		waitForWebElementToAppear(inspectionDialog);
		inspectionName.click();
		waitForWebElementToDisappear(listLoader);
		
		//Inspection List
		List<WebElement> inspectionList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedInspection:inspectionList) {
			if(expectedInspection.getText().equals(inspection)) {
				expectedInspection.click();
				break;
			}
		}
		clientName.click();
		waitForWebElementToDisappear(listLoader);

		//Client List
		List<WebElement> clientList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedClient:clientList) {
			if(expectedClient.getText().equals(client)) {
				expectedClient.click();
				break;
			}
		}
		
		docName.click();
		waitForWebElementToDisappear(listLoader);

		//Doc List
		List<WebElement> docList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedDoc:docList) {
			if(expectedDoc.getText().equals(doc)) {
				expectedDoc.click();
				break;
			}
		}
		
		vesselName.click();
		waitForWebElementToDisappear(listLoader);

		//Vessel List
		List<WebElement> vesselList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedVessel:vesselList) {
			if(expectedVessel.getText().equals(vessel)) {
				expectedVessel.click();
				break;
			}
		}
		portName.click();
		waitForWebElementToDisappear(listLoader);

		//Port List
		List<WebElement> portList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedPort:portList) {
			if(expectedPort.getText().equals(port)) {
				expectedPort.click();
				break;
			}
		}
		inspectorName.click();
		waitForWebElementToDisappear(listLoader);

		//Port List
		List<WebElement> inspectorList = driver.findElements(By.cssSelector(".ng-option"));
		for(WebElement expectedInspector:inspectorList) {
			if(expectedInspector.getText().equals(inspector)) {
				expectedInspector.click();
				break;
			}
		}
		datePicker.click();
		selectYear.click();
		datePicker(monthFromXpath, year, month, fromDay, nextButton);
		saveBtn.click();
	}
}
