package Marvet.Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import Marvet.AbstractComponent.AbstractComponent;
import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.LandingPage;
import Mavet.PageObjects.VettingManagement;
import net.sourceforge.tess4j.TesseractException;

public class HandleVetting extends BaseTest {
	@Test
	public void handleVetting() throws IOException, TesseractException, InterruptedException {
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		ArrayList<String> data = abstractComponent.excelRead("Login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(data.get(0), data.get(1));
		String vesslNum ="1234567";
		VettingManagement vetting = new VettingManagement(driver);
		vetting.manageVetting(vesslNum);
	}
}
