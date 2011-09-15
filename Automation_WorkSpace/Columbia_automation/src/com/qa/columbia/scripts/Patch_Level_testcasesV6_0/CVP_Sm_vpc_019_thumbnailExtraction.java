/*
* Classname                                                        CVP_thumbnailExtraction 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that thumbnails are extracted for WMV file from Content page.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the Simple Streaming Media (Hosted) radio button<br> 
* 																	>Browse the wmv file<br> 
* 																	>Provide the Display name<br> 
* 																	>click on the wmv file name<br> 	
*  																    >Click on Pick thumbnail button<br> 
*   																>Verify the thumbnails displayed<br>
*  																	>Select a thumbnail<br> 	
*  																    >Click Save button<br> 
*   																>Click on Save button<br> 
*       															>Search the thumbnail and verify it if present<br> 	 	 
*   																			 
* What Verification it performs:	 								1.Verify that user is able to extract a thumbnail from the wmv file successfully under Content.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
* 
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_019_thumbnailExtraction extends TesterAsserter {
	
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
	public void test_Sm_vpc_019_thumbnailExtraction() throws Exception {
		{
			try
			{	
				//Global variables file name
				String globalVariableFile ="Global_variables.xml";
				//Local variable file name
				String localVariableFile = "CVP_Sm_vpc_019_thumbnailExtraction.xml";
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions();
				//Variable for the user name
				String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
				//Variable for the Password
				String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
				//Variable for domain name
				String Var_DomainName = utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");	
				//Variable for the streaming media file display name
				String VAR_wmvDisplayName = utilityFunction.GetValue(localVariableFile ,"VAR_wmvDisplayName");
				//Variable for the streaming media file name
				String VAR_wmvFileName = utilityFunction.GetValue(localVariableFile ,"VAR_wmvFileName");				
				
				Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, Var_DomainName);
				
				Upload_Media.Upload_streamingMedia(selenium, VAR_wmvDisplayName, VAR_wmvFileName);
				utilityFunction.waitForChangesToReflect();
				
				Advance_Search.AdvanceSearch(selenium, VAR_wmvDisplayName+ " thumbnail 1");
				assertTrue("Sm_vpc_019", "Classic VP: Ensure that thumbnails are extracted for WMV file from Content page.", date, selenium.isTextPresent(VAR_wmvDisplayName+" thumbnail 1")) ;
				
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				
			}
		}
	}
}

