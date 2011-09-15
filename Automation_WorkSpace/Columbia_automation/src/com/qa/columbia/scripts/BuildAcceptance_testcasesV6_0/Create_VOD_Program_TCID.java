/*
* Class name                                                        MVV_VOD_report 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
* 																	>Click on the programming link<br> 															
* 																	>Create VOD program<br>						
* 										                            >After creating the program search the program in programs page<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class Create_VOD_Program_TCID extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
			selenium.setTimeout("0");
		}

	}	
	public  void test_Create_VOD_Program() throws Exception
	{
		
try{
			
		    //Call to setUp function
		    setUp();
			
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="Create_VOD_Program.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
			
			//Variable for Waiting time
			String VAR_MED_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			
			// Variable for program name
			String VAR_StreamingMedia=utilityFunction.GetValue(localVariableFile ,"VAR_StreamingMedia");
			
			
		
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			//Call to Create VOD program function
			Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);
			
			//search by program name
			selenium.type(EnvObjectMap_Rep.lnk_VODProgramsearch, VAR_program);
			
			selenium.click(EnvObjectMap_Rep.Btn_programsearch);
			
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			
			//Ensure that program is successfully created and visible in programs page
			assertTrue("TC_XXX","Verify that an On Demand program is successfully created",date,selenium.isTextPresent(VAR_program));
					
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
	selenium.close();
	selenium.stop();
}

	}

}
