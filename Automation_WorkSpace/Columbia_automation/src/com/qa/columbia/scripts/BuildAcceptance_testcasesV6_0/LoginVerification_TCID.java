/*
*  Classname                                                        LoginVerification 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure that user is able to Login to admin portal successfully.<br>
* What the script does:											    >Open the login page<br> 
* 																	>Provide username/Password	
* 																	>Provide username/Password	
* 																	>Select domain	 
* 																	>Click Login button	
* What Verification it performs:									1.Verify that user is logged in to admin portal successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 06/06/2011
* Updated by/on date: 												QASource on 06/06/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class LoginVerification_TCID extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception 
	{		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag)
		{				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}
		utilityFunction = null;

	}
	public void test_LoginPageVerification() throws Exception {
		{
			try
			{
			Utility_Functions utilityFunction = new Utility_Functions(); 
			setUp();
			//Global Variables file
			String str_path ="Global_variables.xml";
			//User name
			String Var_UserName = utilityFunction.GetValue(str_path, "VAR_USR");
			//Password
			String Var_Password = utilityFunction.GetValue(str_path, "VAR_PWD");
			//Domain
			String Var_DomainName = utilityFunction.GetValue(str_path, "Var_DomainSocial");
			//Reusable action to login to admin portal
			Login.adminPortalLogin(selenium, Var_UserName, Var_Password, Var_DomainName);
			
			assertTrue("TC_XXX","Verify that user is able to login.",date,selenium.isElementPresent(EnvObjectMap_Rep.Lnk_Systemlink));
			//Verify that Logout link is displayed
			assertTrue("TC_XXX","Verify that user is able to Login to admin portal successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.Lnk_logout));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				selenium.close();
				selenium.stop();
			}
		}
	}

}