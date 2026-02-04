package Marvet.UserRoles;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import Marvet.ChangePassword.ChangePassword;
import Marvet.ClearanceManagementModule.ClearanceManagement;
import Marvet.ClientGroup.ClientGroup;
import Marvet.InspectionManagement.InspectionManagement;
import Marvet.InspectorManagementModule.InspectorManagement;
import Marvet.Login.Login;
import Marvet.OutOfOffice.OutOfOffice;
import Marvet.PortManagementModule.PortManagement;
import Marvet.RequestService.RequestService;
import Marvet.Settings.InspectionTemplate;
import Marvet.Settings.InspectionType;
import Marvet.Settings.Question;
import Marvet.Settings.Section;
import Marvet.TerminalChartererModule.TerminalCharter;
import Marvet.UserModule.User;
import Marvet.VesselManagementModule.VesselManagement;
import Matvet.VTOManagement.VTOManagement;

public class ChartererRole extends Login {

	@Test
	public void charterUserRole() throws FileNotFoundException, InterruptedException {
		login();
		RequestService service = new RequestService();
//		service.vesselService();

		// User Module
		User user = new User();
		user.addNewUser();
		user.editUser();
		
		//Out Of Office Delegation
		OutOfOffice outOffice = new OutOfOffice();
		outOffice.enableOutOfOffice();

		// Inspector Management Module
		InspectorManagement inspectionManagement = new InspectorManagement();
//		inspectionManagement.updateInspectorReviewer();
//		inspectionManagement.inspectorDocUpload();
//		inspectionManagement.editInspectorDocument();
//		inspectionManagement.downloadDoc();
//		inspectionManagement.deleteDocument();
		user.deleteUser();

		// Vessel Management Module
		VesselManagement vesselManage = new VesselManagement();
//		vesselManage.addNewVessel();
//		vesselManage.editVessel();
//		vesselManage.vesselDocUpload();
//		vesselManage.editVesselDocument();
//		vesselManage.downloadDoc();
//		vesselManage.deleteDocument();
//		vesselManage.deleteVessel();

		// Port Management Module
		PortManagement portManage = new PortManagement();
//		portManage.addNewPort();
//		portManage.editPort();
//		portManage.portDocUpload();
//		portManage.editPortDocument();
//		portManage.downloadDoc();
//		portManage.deleteDocument();
//		portManage.deletePort();

		// Terminal or Charter Module
		TerminalCharter termChart = new TerminalCharter();
//		termChart.addNewTerminal();
//		termChart.editTerminal();
//		termChart.deleteTerminal();
//		termChart.addNewCharterer();
//		termChart.editCharterer();
//		termChart.deleteCharterer();

		// VTO Management Module
		VTOManagement vtoManage = new VTOManagement();
//		vtoManage.addVTO();
//		vtoManage.editVTO();
//		vtoManage.deleteVTO();

		// Client Group Module
		ClientGroup clientGroup = new ClientGroup();
//		clientGroup.addClientGroup();
//		clientGroup.editClientGroup();
//		clientGroup.deleteClientGroup();

		// Inspection Management Module
		InspectionManagement inspectManage = new InspectionManagement();
//		inspectManage.createInspection();
//		inspectManage.editInspection();
//		inspectManage.deleteInspection();

		// Clearance Management Module
		ClearanceManagement clearanceManage = new ClearanceManagement();
//		clearanceManage.startVet();
		
		//Section Module
		Section section = new Section();
//		section.addSection();
//		section.editSection();
//		section.deleteSection();

		//Question Module
		Question question = new Question();
//		question.addQuestion();
//		question.editQuestion();
//		question.deleteQuestion();
		
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
		
		ChangePassword pass = new ChangePassword();
		pass.resetPasssword();
	}
}
