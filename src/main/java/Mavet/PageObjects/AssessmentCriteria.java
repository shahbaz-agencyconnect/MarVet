package Mavet.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(css = ".la-angle-down")
	WebElement vesselPerformanceTab;

	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;

	@FindBy(linkText = "OVID Inspection Report")
	WebElement ovidInspection;

	@FindBy(linkText = "Pre Hire / Pre-Mobilization Inspection Report")
	WebElement preHire;

	@FindBy(linkText = "Condition Suitability Inspection")
	WebElement conditionSuitability;

	@FindBy(linkText = "Small Craft Inspection Report")
	WebElement smallCraft;

	@FindBy(linkText = "Hygiene Inspection Report")
	WebElement hygieneInspection;

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

	@FindBy(linkText = "Seafarer Training Matrix")
	WebElement seafarerTraining;

	@FindBy(linkText = "License to Operate (Non-Brunei Flag Vessels)")
	WebElement licenseToOperate;

	@FindBy(linkText = "Environmental Protection and Management Act")
	WebElement managementAct;

	@FindBy(linkText = "Radiation Protection Order")
	WebElement radiationProtection;

	@FindBy(linkText = "Class Survey Status Report")
	WebElement classSurvey;

	@FindBy(linkText = "Special Survey Report")
	WebElement specialSurvey;

	@FindBy(linkText = "Ultrasonic Thickness Measurement Report")
	WebElement ultrasonic;

	@FindBy(linkText = "Dry-dock Report")
	WebElement dryDock;

	public void assessmentCriteria() throws InterruptedException {
		String vesselNum = "1124225";
		VettingManagement management = new VettingManagement(driver);
		management.manageVetting(vesselNum);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(normalize-space(.), 'Vessel Performance')]")));
//		waitForWebElementToAppear(loadVesselDetails);
//		Thread.sleep(2000);
	}

	public void classStatus() {
		classStatusTab.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Class Status");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void shipStaff() {
		shipStaffTab.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Feedback");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void ovidInspectionReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		ovidInspection.click();
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test OVID Inspection Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void preHireMobilizationReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		preHire.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Mer Render");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void conditionSuitabilityInspection() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		conditionSuitability.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Condition Suitability");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void smallCraftInspectionReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		smallCraft.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Small Craft Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void hygieneInspectionReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		hygieneInspection.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Hygiene Inspection Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void seafarerTrainingMatrix() throws InterruptedException {
		vesselPerformanceTab.click();
		seafarerTraining.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Seafarer Training Matrix");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void licenseToOperate() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		licenseToOperate.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test License To Operate");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void environmentalProtectionandManagementAct() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		managementAct.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Environmental Protection and Management Act");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void radiationProtectionOrder() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		radiationProtection.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Environmental Protection and Management Act");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void classSurveyStatusReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		classSurvey.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Class Survey Status");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void specialSurveyReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		specialSurvey.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Special Survey Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void ultrasonicThicknessMeasurementReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		ultrasonic.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Ultrasonic Thickness Measurement Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
	}

	public void drydockReport() throws InterruptedException {
		Thread.sleep(1000);
		vesselPerformanceTab.click();
		dryDock.click();
		waitForWebElementToAppear(compliantCheckbox);
		compliantCheckbox.click();
		fileUpload.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		commentBox.sendKeys("This is a test Dry-dock Report");
		saveCommentBtn.click();
		waitForWebElementToAppear(successMsg);
//		waitForWebElementToDisappear(successMsg);
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

}
