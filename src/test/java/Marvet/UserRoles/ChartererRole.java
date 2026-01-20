package Marvet.UserRoles;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import Marvet.InspectorManagementModule.InspectorManagement;
import Marvet.Login.Login;
import Marvet.UserModule.User;
import VesselManagementModule.VesselManagement;

public class ChartererRole extends Login{

	@Test
	public void charterUserRole() throws FileNotFoundException, InterruptedException {
		login();
		
		//User Module
		User user = new User();
//		user.addNewUser();
//		user.editUser();
//		user.deleteUser();
		
		//Inspector Management Module
		InspectorManagement inspectionManagement = new InspectorManagement();
//		inspectionManagement.updateInspectorReviewer();
//		inspectionManagement.inspectorDocUpload();
//		inspectionManagement.editInspectorDocument();
//		inspectionManagement.deleteDocument();

		//Vessel Management Module
		VesselManagement vesselManage = new VesselManagement();
		vesselManage.addNewVessel();
		vesselManage.editVessel();
		vesselManage.vesselDocUpload();
		vesselManage.editVesselDocument();
		vesselManage.downloadDoc();
		vesselManage.deleteDocument();
		vesselManage.deleteVessel();
	}

}
