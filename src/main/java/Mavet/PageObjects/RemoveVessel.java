package Mavet.PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveVessel extends AbstractComponent {
	WebDriver driver;

	public RemoveVessel(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Vessel Management']")
	WebElement vesselManagement;

	@FindBy(xpath = "//input[contains(@placeholder,'vessel name')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;

	public void removeVessel() throws InterruptedException {
		waitForWebElementToAppear(vesselManagement);
		vesselManagement.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("8541256");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
