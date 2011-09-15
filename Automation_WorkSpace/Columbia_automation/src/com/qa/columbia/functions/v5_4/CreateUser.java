/*
 * This method is used to Create ser in the Application.
 *
*/

package com.qa.columbia.functions.v5_4;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class CreateUser extends TesterAsserter {
	
    public static void test_Create_User(Selenium sel,String str_firstName, String str_lastName, String str_emailID, String str_password) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();
    	//Fetching values for Global Variables from XML file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		//Click on UserManagement
    	sel.click(EnvObjectMap_Rep.LNK_userManagement);
    	//Click on User link
    	sel.click(EnvObjectMap_Rep.LNK_Users);
    	//Wait for the page to load
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	//Click on Add button
    	sel.click(EnvObjectMap_Rep.btn_AddUser);
    	//Wait for the page to load
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	//Type the first name
    	sel.type(EnvObjectMap_Rep.txt_firstName, str_firstName);
    	//Type the last name
    	sel.type(EnvObjectMap_Rep.txt_lastname, str_lastName);
    	//Focus on the email field
        sel.focus(EnvObjectMap_Rep.txt_Email);
        sel.keyDownNative("113");
        sel.keyUpNative("113");
        //Type the email 
    	sel.type(EnvObjectMap_Rep.txt_Email, str_emailID);
    	//Type the password
    	sel.type(EnvObjectMap_Rep.txt_Password, str_password);
    	//Type the confirm password
    	sel.type(EnvObjectMap_Rep.txt_confirmPassword, str_password);
    	//Click on Save button
    	sel.click(EnvObjectMap_Rep.btn_saveUser);
    	sel.waitForPageToLoad(VAR_MED_WAIT);	
		//assertTrue(" ","Verify that user is created successfully.",sel.isTextPresent(str_firstName + " " + str_lastName));	
	}
}
