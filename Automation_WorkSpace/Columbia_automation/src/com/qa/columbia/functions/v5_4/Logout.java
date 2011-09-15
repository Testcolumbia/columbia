/*
 * This method is used to Logout from the Application.
 * @param sel selenium object that runs the selenium commands 
 * @throws Exception 
*/

package com.qa.columbia.functions.v5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Logout extends TesterAsserter{
	public static void logout(Selenium sel) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions();	
		Date date=Calendar.getInstance().getTime();
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			
		//Verifies that 'SIGN OUT" text is present on the page. 
		assertTrue(sel.isTextPresent("Log Out"));		
		//Clicking the 'Log OUT' link to log out from the application.
		sel.click(EnvObjectMap_Rep.LNK_LOGOUT);		
		// Checkpoint to verify that user is able to logout from the application 
		sel.waitForPageToLoad(VAR_MED_WAIT);		
		// Checkpoint to verify that user is successfully logout from the Application. 
		assertTrue(" ","Verify that user is able to logout",date,sel.isElementPresent(EnvObjectMap_Rep.LNK_LOGIN_BTN));		
		sel.stop();	
	}		
}


