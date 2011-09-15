/*
* Classname                                                        BuildVersionVerification 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to System<br> 
*  															     	>Click on the Build info link<br> 															
* 																	>Verify that the Build version is displayed<br> 													
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
import com.qa.columbia.functions.v6_0.Login;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;



public class BuildVersionVerification_TCID extends TesterAsserter{
	
	
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
	

	public void test_BuildVersionVerification_TCID() throws Exception
	{
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
			// variable for build number
			String Var_BuildNumber = utilityFunction.GetValue(globalVariableFile, "Var_BuildNumber");	
			//Variable for Waiting time
			String wait=utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
			
			//Call to reusable function for a admin portal Login
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			selenium.waitForPageToLoad(wait);
			selenium.click(EnvObjectMap_Rep.Lnk_buildinfo);
			selenium.waitForPageToLoad(wait);
			
			//Ensure that Build version is getting displayed
			assertTrue("TC_XXX", "TC_XXX:Verify that Build Version is displayed", date, selenium.isElementPresent(EnvObjectMap_Rep.Label_version));
			assertTrue("TC_XXX", "TC_XXX:Verify that correct Build number is displayed", date,selenium.isTextPresent("Build-Number:"+ Var_BuildNumber));
			utilityFunction=null;
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
