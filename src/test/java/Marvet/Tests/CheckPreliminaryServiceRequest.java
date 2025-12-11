package Marvet.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.PreliminaryMerVetServiceRequest;
import net.sourceforge.tess4j.TesseractException;

public class CheckPreliminaryServiceRequest extends BaseTest {
	@Test
	public void checkPreliminaryRequest() throws IOException, TesseractException, InterruptedException {
		PreliminaryMerVetServiceRequest preliminary = new PreliminaryMerVetServiceRequest(driver);
		preliminary.preliminaryService();
	}
}
