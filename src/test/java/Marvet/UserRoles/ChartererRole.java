package Marvet.UserRoles;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import Marvet.InspectorManagementModule.InspectorManagement;
import Marvet.Login.Login;
import Marvet.PortManagementModule.PortManagement;
import Marvet.TerminalChartererModule.TerminalCharter;
import Marvet.UserModule.User;
import Marvet.VesselManagementModule.VesselManagement;
import Matvet.VTOManagement.VTOManagement;

public class ChartererRole extends Login{

	@Test
	public void charterUserRole() throws FileNotFoundException, InterruptedException {
		login();
		
		//User Module
		User user = new User();
		user.addNewUser();
		user.editUser();
		user.deleteUser();
		
		//Inspector Management Module
		InspectorManagement inspectionManagement = new InspectorManagement();
		inspectionManagement.updateInspectorReviewer();
		inspectionManagement.inspectorDocUpload();
		inspectionManagement.editInspectorDocument();
		inspectionManagement.downloadDoc();
		inspectionManagement.deleteDocument();

		//Vessel Management Module
		VesselManagement vesselManage = new VesselManagement();
		vesselManage.addNewVessel();
		vesselManage.editVessel();
		vesselManage.vesselDocUpload();
		vesselManage.editVesselDocument();
		vesselManage.downloadDoc();
		vesselManage.deleteDocument();
		vesselManage.deleteVessel();
		
		//Port Management Module
		PortManagement portManage = new PortManagement();
		portManage.addNewPort();
		portManage.editPort();
		portManage.portDocUpload();
		portManage.editPortDocument();
		portManage.downloadDoc();
		portManage.deleteDocument();
		portManage.deletePort();
		
		//Terminal or Charter  Module
		TerminalCharter termChart=new TerminalCharter();
		termChart.addNewTerminal();
		termChart.editTerminal();
		termChart.deleteTerminal();
		termChart.addNewCharterer();
		termChart.editCharterer();
		termChart.deleteCharterer();
		
		//VTO Management Module
		VTOManagement vtoManage = new VTOManagement();
		vtoManage.addVTO();
		vtoManage.editVTO();
		vtoManage.deleteVTO();
	}

}
