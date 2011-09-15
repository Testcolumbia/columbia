/*
* Classname                                                        SVP_Sm_vpv_019_Content_Storage_Report 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that 'Content Storage' report is generated.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Reporting and select Reports<br> 
* 																	>Select a report type as "Content Storage".
*																	>Select the Start and End date for the report.<br> 
* What Verification it performs:	 								Verify that 'Content Storage' report is generated successfully<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 14/04/2011
* Updated by/on date: 												QASource on 14/04/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/

package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;
import java.util.Calendar;
import java.util.Date;

public class SVP_Sm_vpv_019_Content_Storage_Report extends TesterAsserter {
	

	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL"); 
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
		}

	}		
	public void test_SVP_Sm_vpv_019_Content_Storage_Report() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";		
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     		//wait
     		selenium.waitForPageToLoad("30000");
     		//Click 'Reporting' menu
    		selenium.click(EnvObjectMap_Rep.lnk_reporting);
    		//Click 'Reports' link
    		selenium.click(EnvObjectMap_Rep.lnk_reports);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//Select Report name
    		selenium.click(EnvObjectMap_Rep.radio_ContentStorage);
    		//Click 'Next' button
    		selenium.click(EnvObjectMap_Rep.btn_reportNext);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//select the past date as Start date
    	 	selenium.mouseDown("startDate_date");
    	 	selenium.click(EnvObjectMap_Rep.Cal_Startdate);
    		utilityFunction.waitForChangesToReflect();
    		//select the future date as End date
    		selenium.mouseDown("endDate_date");
    		selenium.click(EnvObjectMap_Rep.Cal_Enddate);
    		utilityFunction.waitForChangesToReflect();
    		//click the Run report button
    		selenium.click(EnvObjectMap_Rep.btn_runReport);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//verify that 'Content Storage' report is generated
    	    assertTrue("Sm_vpv_019","Social VP: Ensure that 'Content Storage' report is generated.",date, selenium.isTextPresent("Content Storage Report"));
		   // stop selenium
    	    utilityFunction=null;
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			 finally{
			selenium.close();
			selenium.stop();
			 }
		}					 
	}
}