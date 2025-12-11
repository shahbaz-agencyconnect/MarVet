package Marvet.Tests;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import Marvet.AbstractComponent.AbstractComponent;
import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.LandingPage;
import Mavet.PageObjects.UserDelegations;
import net.sourceforge.tess4j.TesseractException;

public class DelegateNewUser extends BaseTest{
	@Test
	public void delegateNewUser() throws IOException, TesseractException, InterruptedException {
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		ArrayList<String> data = abstractComponent.excelRead("Login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(data.get(0), data.get(1));
		UserDelegations delegation = new UserDelegations(driver);
		delegation.userDelegation();
	}

}
