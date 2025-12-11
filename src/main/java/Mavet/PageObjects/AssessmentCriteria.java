package Mavet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AssessmentCriteria extends AbstractComponent {
	WebDriver driver;

	public AssessmentCriteria(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".p-component")
	WebElement loadVesselDetails;

	@FindBy(linkText = "Class Status")
	WebElement classStatusTab;

	@FindBy(xpath = "//span[text()=' Item is compliant ']")
	WebElement compliantCheckbox;

	@FindBy(xpath = "//input[@type='file']")
	WebElement fileUpload;

	@FindBy(css = ".ck-editor__editable")
	WebElement commentBox;

	@FindBy(xpath = "//button[text()='Save Comment']")
	WebElement saveCommentBtn;

	@FindBy(xpath = "//a[contains(normalize-space(), 'Ships Staff & MLC Compliance')]")
	WebElement shipStaffTab;

	@FindBy(xpath = "//span[contains(normalize-space(.), 'Vessel Performance')]")
	WebElement vesselPerformanceTab;

	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;

	@FindBy(linkText = "Terminal Performance Report")
	WebElement terminalPerformance;

	@FindBy(linkText = "MER Render")
	WebElement merRender;

	@FindBy(linkText = "MER Line")
	WebElement merLine;

	@FindBy(linkText = "MER Gas")
	WebElement merGas;

	@FindBy(linkText = "MER Maintain")
	WebElement merMaintain;
	
	@FindBy(xpath = "//span[contains(normalize-space(.), 'Port State Control')]")
	WebElement portState;
	
	@FindBy(xpath = "//span[text()='PSC Compliance comments saved']")
	WebElement portStateSuccessmsg;	
	
	@FindBy(xpath = "//button[text()=' Save Comment ']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[text()=' Previous PSC requirements met ']")
	WebElement pcsRequirementCheckbox;
	
	@FindBy(linkText = "Incident History")
	WebElement incidentHistory;
	
	@FindBy(xpath = "//span[text()='Incident History Compliance comments saved']")
	WebElement incidentHistorySuccessmsg;	
	
	@FindBy(xpath = "//span[text()=' Previous Incident History requirements met ']")
	WebElement incidenHistoryCheckbox;
	
	@FindBy(linkText = "BVIQ Feedback")
	WebElement bviqFeedback;

	@FindBy(linkText = "TVAQ Feedback")
	WebElement tvaqFeedback;

	public void assessmentCriteria() throws InterruptedException {
		String vesselNum = "1125025";
		VettingManagement management = new VettingManagement(driver);
		management.manageVetting(vesselNum);
//		waitForWebElementToAppear(loadVesselDetails);
		Thread.sleep(2000);
	}

	public void classStatus() {
		classStatusTab.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Class Status");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void shipStaff() {
		shipStaffTab.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Feedback");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void terminalPerformanceReport() {
		vesselPerformanceTab.click();
		terminalPerformance.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Terminal Performance Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void merRender() {
		vesselPerformanceTab.click();
		merRender.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Mer Render");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void merLine() {
		vesselPerformanceTab.click();
		merLine.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Mer Line");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void merGas() {
		vesselPerformanceTab.click();
		merGas.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Mer Gas");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);	}

	public void merMaintain() {
		vesselPerformanceTab.click();
		merMaintain.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Mer Maintain");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}
	
	public void portStateControl() {
//		vesselPerformanceTab.click();
		portState.click();
		waitForWebElementToAppear(pcsRequirementCheckbox);
		pcsRequirementCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Port State Control");
		saveBtn.click();
		waitForWebElementToAppear(portStateSuccessmsg);
		waitForWebElementToDisappear(portStateSuccessmsg);
	}
	
	public void incidentHistory() {
//		vesselPerformanceTab.click();
		incidentHistory.click();
		waitForWebElementToAppear(incidenHistoryCheckbox);
		incidenHistoryCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Incident History");
		saveBtn.click();
		waitForWebElementToAppear(incidentHistorySuccessmsg);
		waitForWebElementToDisappear(incidentHistorySuccessmsg);
	}

	public void bviqFeedback() {
		vesselPerformanceTab.click();
		bviqFeedback.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test BVIQ Feedback");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

	public void tvaqFeedback() {
		vesselPerformanceTab.click();
		tvaqFeedback.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test TVAQ Feedback");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
		waitForWebElementToDisappear(successMsg);
	}

}
