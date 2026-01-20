import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import Marvet.AbstractComponent.AbstractComponent;
import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.LandingPage;
import Mavet.PageObjects.UpdateValidity;
import net.sourceforge.tess4j.TesseractException;

public class ReviewerValidityPeriod extends BaseTest {
	@Test
	public void reviewerValidity() throws IOException, TesseractException, InterruptedException {
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		ArrayList<String> data = abstractComponent.excelRead("Login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(data.get(0), data.get(1));
		UpdateValidity validity = new UpdateValidity(driver);
		validity.setValidity();
	}
}
