package Marvet.UserRoles;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import Marvet.ChangePassword.ChangePassword;
import Marvet.ClearanceDocuments.ClearanceDocuments;
import Marvet.ClearanceManagementModule.ClearanceManagement;
import Marvet.ClientGroup.ClientGroup;
import Marvet.ForgotPassword.ForgotPassword;
import Marvet.InspectionManagement.InspectionManagement;
import Marvet.InspectorManagementModule.InspectorManagement;
import Marvet.Login.Login;
import Marvet.ObservationCloseOut.ObservationCloseOut;
import Marvet.OutOfOffice.OutOfOffice;
import Marvet.PortManagementModule.PortManagement;
import Marvet.RequestService.RequestService;
import Marvet.Settings.InspectionTemplate;
import Marvet.Settings.InspectionType;
import Marvet.Settings.Question;
import Marvet.Settings.Section;
import Marvet.TerminalChartererModule.TerminalCharter;
import Marvet.TwoFactorAuth.TwoFactorAuthentication;
import Marvet.UserModule.User;
import Marvet.VesselManagementModule.VesselManagement;
import Matvet.VTOManagement.VTOManagement;

public class RunSampleMethods extends Login {

	@Test
	public void charterUserRole() throws FileNotFoundException, InterruptedException {
		login();
		//Section Module
		Section section = new Section();
		section.addSection();
		section.editSection();
		section.deleteSection();

		//Question Module
		Question question = new Question();
		question.addQuestion();
		question.editQuestion();
		question.deleteQuestion();
		
		//Inspection Type Module
		InspectionType inspectionType = new InspectionType();
//		inspectionType.addInspectionType();
//		inspectionType.editInspectionType();
//		inspectionType.deleteInspectionType();
	
		//Inspection Template Module
		InspectionTemplate inspectionTemplate = new InspectionTemplate();
//		inspectionTemplate.addInspectionTemplate();		
//		inspectionTemplate.editInspectionTemplate();
//		inspectionTemplate.deleteInspectionTemplate();
	}
	
	
}
