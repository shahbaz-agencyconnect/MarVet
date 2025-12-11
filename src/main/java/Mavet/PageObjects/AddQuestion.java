package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddQuestion extends AbstractComponent{
	WebDriver driver;
	public AddQuestion(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Question ']")
	WebElement openQuestion;

	@FindBy(xpath = "//button[text()=' Add Question ']")
	WebElement addQuestionBtn;

	@FindBy(xpath = "//textarea[@placeholder='Question']")
	WebElement questionName;
	
	@FindBy(xpath = "//input[@placeholder='Short Name']")
	WebElement shortName;
	
	@FindBy(xpath = "//textarea[@placeholder='Note']")
	WebElement guidanceNote;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	public void addQuestion() {
		settingsMenu.click();
		openQuestion.click();
		addQuestionBtn.click();
		questionName.sendKeys("What are the three main components of a mooring line that you should inspect regularly?");
		shortName.sendKeys("General Hull");
		guidanceNote.sendKeys("Cuts, excessive fuzzing, or flattening of the rope fibers, especially at points of contact with fairleads, chocks, or the quay.");
		saveBtn.click();
		
	}
}
