package Marvet.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.ServiceRequest;
import net.sourceforge.tess4j.TesseractException;

public class VesselServiceRequest extends BaseTest{
	@Test
	public void serviceRequest() throws IOException, TesseractException, InterruptedException {
		ServiceRequest serviceRequest = new ServiceRequest(driver);
		serviceRequest.vesselService();
	}
}
