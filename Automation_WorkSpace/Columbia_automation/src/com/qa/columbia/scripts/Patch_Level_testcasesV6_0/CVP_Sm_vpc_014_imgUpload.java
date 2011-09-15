/*
* Classname                                                        Sm_vpc_014_imgUpload 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that image file is uploaded in Content page.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming>Content<br> 
*																	>Upload an image file<br>
*																	>Verify the uploaded file.<br>																		 
* What Verification it performs:	 								1.Verify that image file is uploaded in Content page.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 22/07/2011
* Updated by/on date: 												QASource on 22/07/2011
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.repository.v6_0.*;

public class CVP_Sm_vpc_014_imgUpload extends TesterAsserter {
	
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
			selenium.setTimeout("0");
			utilityFunction=null;
		}
	}	
	public void test_Sm_vpc_014_imgUpload() throws Exception {
		{
			try
			{	
				//Global variables file name
				String globalVariableFile ="Global_variables.xml";
				//Local variable file name
				String localVariableFile = "CVP_Sm_vpc_014_imgUpload.xml";
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions();
				//Variable for the user name
				String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
				//Variable for the Password
				String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
				//Variable for domain name
				String Var_DomainName = utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");				
				// Variable for image display name
				String Var_imageDisplayName=utilityFunction.GetValue(localVariableFile ,"Var_imageDisplayName");				
				// Variable for image file name
				String Var_imageFileName=utilityFunction.GetValue(localVariableFile ,"Var_imageFileName");
				Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, Var_DomainName);
				Upload_Media.Upload_image(selenium, Var_imageDisplayName, Var_imageFileName);
				utilityFunction.waitForChangesToReflect();
				Advance_Search.AdvanceSearch(selenium, Var_imageDisplayName);
				utilityFunction.waitForElementToPresent(selenium,EnvObjectMap_Rep.Lbl_nameHeader, 300);
				assertTrue("Sm_vpc_014", "Classic VP: Ensure that image file is uploaded in Content page.", date, selenium.isTextPresent(Var_imageDisplayName)) ;
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
