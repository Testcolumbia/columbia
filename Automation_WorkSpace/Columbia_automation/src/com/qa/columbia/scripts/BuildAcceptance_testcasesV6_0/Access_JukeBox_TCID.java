/*
*  Classname                                                        Access_JukeBox 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure that Juke box is accessible on Social viewer portal.<br>
* What the script does:											    >Launch the Social viewer portal.<br> 
* 																	>Verify the Juke box element	
* What Verification it performs:									1.Verify that Juke box is accessible on Social viewer portal<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 07/06/2011
* Updated by/on date: 												QASource on 07/06/2011
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

public class Access_JukeBox_TCID extends TesterAsserter {
	
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
	public void test_Access_JukeBox() throws Exception
	{
		try
			{
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String globalVariableFile ="Global_variables.xml";
				//Domain name
				String Var_DomainName = utilityFunction.GetValue(globalVariableFile, "Var_DomainSocial");
				//Reusable action to launch viewer portal
				Launch_VP.Launch_SVP(selenium, Var_DomainName);
				selenium.click(EnvObjectMap_Rep.Lnk_browserJukeBox);
				assertTrue("TC_XXX", "TC_XXX:-Verify that Browse tab is displayed on Social viewer portal.", date, selenium.isElementPresent(EnvObjectMap_Rep.Lnk_browserJukeBox));
				selenium.click(EnvObjectMap_Rep.Lnk_showAllJukeBox);
				assertTrue("TC_XXX", "TC_XXX:-Verify that Show All tab is displayed on Social viewer portal.", date, selenium.isElementPresent(EnvObjectMap_Rep.Lnk_showAllJukeBox));
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