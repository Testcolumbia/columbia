/*
 * Classname                                                        CVP_complexPresentation_upload 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Complex presentation file is uploaded in Content page.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the complex presentation radio button<br> 
* 																	>Browse the complex presentation file<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the complex presentation is uploaded in the content successfully<br> 	
* What Verification it performs:	 								1.Verify that user is able to upload the complex presentation file successfully under Content.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_complexPresentation_upload extends TesterAsserter {
	
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
			//selenium.setTimeout("0");
			utilityFunction=null;
		}

	}		
	public void test_CVP_complexPresentation_upload() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			String local_path ="CVP_complexPresentation_upload.xml";
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");		
			//Variable for image name
			String VAR_complexPresentationName = utilityFunction.GetValue(local_path ,"VAR_complexpresenationName");
			String VAR_complexPresentationFile = utilityFunction.GetValue(local_path ,"VAR_complexpresenationFile");
			//Variable for duration
			String streamingMediaDuration = utilityFunction.GetValue(local_path, "MediaDuration");
			
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Reusable action for image upload
		    Upload_Media.Upload_complexPresentation(selenium, VAR_complexPresentationName, VAR_complexPresentationFile, streamingMediaDuration);
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			utilityFunction.waitForChangesToReflect();	
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,VAR_complexPresentationName);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//Wait for loading the page
			utilityFunction.waitForChangesToReflect();		
			//Check Point to test that RSS Encoder is created
			assertTrue("CVP_complexPresentation_upload","Classic VP: Ensure that Complex presentation file is uploaded in Content page.",date,selenium.isTextPresent(VAR_complexPresentationName));
			
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