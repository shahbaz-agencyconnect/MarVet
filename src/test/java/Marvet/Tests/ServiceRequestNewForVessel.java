package Marvet.Tests;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.NewVesselService;

public class ServiceRequestNewForVessel extends BaseTest {
	@Test
	public void serviceRequest() throws FileNotFoundException, InterruptedException {
		NewVesselService service = new NewVesselService(driver);
		service.newVesselServiceRequest();
	}
}	
