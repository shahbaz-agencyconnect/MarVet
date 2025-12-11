package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveSection extends AbstractComponent {
	WebDriver driver;
	public RemoveSection(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Section ']")
	WebElement openSection;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search section')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeSection() throws InterruptedException {
		settingsMenu.click();
		openSection.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Navigation");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
