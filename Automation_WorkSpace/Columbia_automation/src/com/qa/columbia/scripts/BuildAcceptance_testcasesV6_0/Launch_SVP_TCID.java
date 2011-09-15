/*
*  Classname                                                        Launch_SVP 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure that Social Viewer portal is launched successfully.<br>
* What the script does:											    >Launch the admin portal.<br> 
* 																	>Open the SVP URL in the browser. 	
* 																	>Verify the element present	
* What Verification it performs:									1.Verify that Social Viewer portal is launched successfully.<br> 
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

public class Launch_SVP_TCID extends TesterAsserter {
	
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
			try
			{
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String globalVariableFile ="Global_variables.xml";
				//Domain
				String Var_DomainName = utilityFunction.GetValue(globalVariableFile, "Var_DomainSocial");
			    //Application instance
				String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");	
				String VPURL = "http://"+VAR_InstanceIP+"/viewerportal/"+Var_DomainName+"/home.vp";
				selenium.open(VPURL);
				selenium.windowMaximize();
				utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.logo_SVP, 300);
				for(int seconds=0;seconds<=300;seconds++)
				{
					try{
						selenium.isVisible(EnvObjectMap_Rep.Drp_selectTimeZone);
						selenium.select(EnvObjectMap_Rep.Drp_selectTimeZone, "label=(GMT-8:00) Pacific Standard Time");
						selenium.click(EnvObjectMap_Rep.Btn_selectTimeZone);
						utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Lnk_loginSVP, 300);
						break;
						}
					catch(Exception e)
						{	
						if(selenium.isVisible(EnvObjectMap_Rep.Lnk_loginSVP))
							break;
							continue;	
						}					
					}
				assertTrue("TC_XXX", "TC_XXX:-Verify that Social Viewer portal is launched successfully.", date, selenium.isVisible(EnvObjectMap_Rep.Lnk_loginSVP));
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
	