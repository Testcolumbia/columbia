/*
*  Classname                                                        Login_page 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure that admin portal Login page is successfully displayed.<br>
* What the script does:											    >Open the login page<br>  
* 																	>Verify the objects displayed.
* What Verification it performs:									1.Verify that 'Login' page is displayed successfully.<br> 
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

public class Login_page_TCID extends TesterAsserter {
	
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
	public void test_Launch_SVP() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			//Global Variables file
			String globalVariableFile ="Global_variables.xml";
			//Application URL
			String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			//Open the application URL in browser
			selenium.open(VAR_Columbia_APPURL);
			//wait for the username text box
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Txt_userName, 300);
			//Verify that login page is displayed
			assertTrue("TC_XXX","Verify that 'Login' page is displayed successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.Btn_login));
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