package pagesTest;

import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {
	@Test
	public void newUserRegistrationTest() {
		newUserRegistration.directingToNewUserRegistration();
		newUserRegistration.validationNewUserRegistration();
		newUserRegistration.searchKeyword();

	}
}
