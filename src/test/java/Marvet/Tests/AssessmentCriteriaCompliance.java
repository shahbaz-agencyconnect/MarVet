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
		assessment.ovidInspectionReport();
//		assessment.preHireMobilizationReport();
//		assessment.conditionSuitabilityInspection();
//		assessment.smallCraftInspectionReport();
//		assessment.hygieneInspectionReport();
//		assessment.seafarerTrainingMatrix();
//		assessment.licenseToOperate();
//		assessment.environmentalProtectionandManagementAct();
//		assessment.radiationProtectionOrder();	
//		assessment.classSurveyStatusReport();
//		assessment.specialSurveyReport();
//		assessment.ultrasonicThicknessMeasurementReport();
		assessment.drydockReport();
//		assessment.portStateControl();
//		assessment.incidentHistory();
//		assessment.bviqFeedback();
//		assessment.tvaqFeedback();
	}
}
