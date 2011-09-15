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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class SVP_Content_upload_Slides extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
		}

	}		
	public void test_SVP_Content_upload_Slides() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
		
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_Username = utilityFunction.GetValue(str_path,"VAR_USR");
			//Variable for the Password
			String VAR_Password = utilityFunction.GetValue(str_path,"VAR_PWD");		
			//Variable for WMV file name
			String VAR_Slidename = utilityFunction.GetValue(str_path,"VAR_Slide_fileName");
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_Username, VAR_Password, VAR_DomSocial);
     		
     		
     		//Open the programming menu
     		selenium.click(EnvObjectMap_Rep.LNK_Programming);
     		//Select the Content link
     		selenium.click(EnvObjectMap_Rep.LNK_Content);
     	    		
     		//sel.waitForPageToLoad(VAR_MAX_WAIT);	 
     		for (int second = 0;; second++) {
     			if (second >= 300) fail("timeout");
     			try { if (selenium.isVisible(EnvObjectMap_Rep.BTN_More_Search)) break; } catch (Exception e) {}
     			Thread.sleep(1000);
     		}
     		
		    selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			
			//Provide the wmv file name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,VAR_SlideDisplayName);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//Wait for loading the page
			utilityFunction.waitForChangesToReflect();		
			//Check Point to test that RSS Encoder is created
			assertTrue("SVP_Content_upload_Slides","Social VP: Ensure that Slides are uploaded in Content page.",date,selenium.isTextPresent(VAR_Slidename));			
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