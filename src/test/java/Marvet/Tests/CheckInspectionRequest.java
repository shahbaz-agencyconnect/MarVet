package Marvet.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.InspectionRequestTemp;
import net.sourceforge.tess4j.TesseractException;

public class CheckInspectionRequest extends BaseTest{
	@Test
	public void checkInspectionRequest() throws IOException, TesseractException, InterruptedException {
		InspectionRequestTemp request = new InspectionRequestTemp(driver);
		request.inspectionRequest();
	}
}
