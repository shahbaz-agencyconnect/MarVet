package Marvet.Tests;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.InspectionAudit;

public class InspectionRequest extends BaseTest{
	@Test
	public void inspectionServiceRequest() throws FileNotFoundException, InterruptedException {
		InspectionAudit audit = new InspectionAudit(driver);
		audit.inspectionAudit();
	}

}
