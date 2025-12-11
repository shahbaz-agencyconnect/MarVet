package Marvet.Tests;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Marvet.TestComponents.BaseTest;
import Mavet.PageObjects.ResetPassword;

public class RecoverPassword extends BaseTest{
	@Test
	public void recoverPassword() throws FileNotFoundException, InterruptedException {
		ResetPassword pass = new ResetPassword(driver);
		pass.resetPassword();
	}

}
