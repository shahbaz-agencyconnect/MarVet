package Marvet.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.UserVetServiceRequest;
import net.sourceforge.tess4j.TesseractException;

public class CheckUserVetServiceRequest extends BaseTest {
	@Test
	public void userVerServiceRequest() throws IOException, TesseractException, InterruptedException {
		UserVetServiceRequest request = new UserVetServiceRequest(driver);
		request.userVetRequest();
	}
}
