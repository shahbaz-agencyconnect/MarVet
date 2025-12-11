package Marvet.Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import Marvet.AbstractComponent.AbstractComponent;
import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.AssessmentCriteria;
import Mavet.PageObjects.LandingPage;
import net.sourceforge.tess4j.TesseractException;

public class AssessmentCriteriaCompliance extends BaseTest {
	@Test
	public void assessmentCriteriaCompliance() throws InterruptedException, IOException, TesseractException {
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		ArrayList<String> data = abstractComponent.excelRead("Login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(data.get(0), data.get(1));
		AssessmentCriteria assessment = new AssessmentCriteria(driver);
		assessment.assessmentCriteria();
//		assessment.classStatus();
//		assessment.shipStaff();
//		assessment.terminalPerformanceReport();
//		assessment.merRender();
//		assessment.merLine();
//		assessment.merGas();
//		assessment.merMaintain();
		assessment.portStateControl();
		assessment.incidentHistory();
//		assessment.bviqFeedback();
//		assessment.tvaqFeedback();
	}
}
