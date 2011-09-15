/*
* Classname                                                        SVP_Content_upload_WMV 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that WMV file is uploaded in Content page.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the Simple Streaming Media radio button<br> 
* 																	>Browse the WMV file<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the image is uploaded in the content successfully<br> 	
*  																    >Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to upload the WMV file successfully under Content.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 05/04/2011
* Updated by/on date: 												QASource on 05/04/2011
*  ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_016_Content_upload_Slides extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
		}

	}		
	public void test_SVP_Sm_vpv_016_Content_upload_Slides() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile="SVP_Sm_vpv_016_Content_upload_Slides.xml";
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_Username = utilityFunction.GetValue(globalVariableFile,"VAR_USR");
			//Variable for the Password
			String VAR_Password = utilityFunction.GetValue(globalVariableFile,"VAR_PWD");		
			//Variable for WMV file name
			String VAR_Slidename = utilityFunction.GetValue(localVariableFile,"VAR_Slide_fileName");
			//Variable for WMV file name
			String VAR_Slide = utilityFunction.GetValue(localVariableFile,"VAR_Slidefile");
						
			//Reusable action for Login to VCC
			Login.adminPortalLogin(selenium, VAR_Username, VAR_Password, VAR_DomSocial);	
     		
     		//Reusable action for image upload
     		Upload_Media.Upload_slides(selenium, VAR_Slidename, VAR_Slide);
     		
     		//Provide the slide name to search
     		Advance_Search.AdvanceSearch(selenium, VAR_Slidename);
     		
			//Wait for loading the page
			utilityFunction.waitForChangesToReflect();		
			//Check Point to test that RSS Encoder is created
			assertTrue("Sm_vpv_016","Social VP: Ensure that Slides are uploaded in Content page.",date,selenium.isTextPresent(VAR_Slidename));			
			utilityFunction=null;
		}catch(Exception e){
			e.printStackTrace();}
			 finally{
			selenium.close();
			selenium.stop();
		}
		}
					 
	}
}