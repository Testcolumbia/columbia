/*
* Classname                                                        CVP_vod_msProducer 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that an On Demand program (MS-Producer file) plays with HTTP delivery option.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add an MSProducer file<br> 
*																	>Create an On-demand program using the MSProducer file as streaming media<br> 
* 																	>Play the on-demand program on the viewer portal<br>
* 																	>Capture the screenshot of the player window<br> 
* 																	>Generate the asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to play the on-demand program using the MSProducer file<br> 
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

public class CVP_vod_msProducer extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
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
			utilityFunction=null;
		}
	}		
	public void test_CVP_vod_msProducer() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variables file name
			String local_path = "CVP_vod_msProducer.xml";
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//Variable for filename name
		    String VAR_streamingMedia = utilityFunction.GetValue(local_path ,"VAR_msProducer_fileName");
			//Variable for filetype
			String streamingMediaType = utilityFunction.GetValue(local_path ,"VAR_fileType");
			//Variable for duration
			String streamingMediaDuration = utilityFunction.GetValue(local_path, "MediaDuration");
			//Variable for program name
			String VAR_PogramName = utilityFunction.GetValue(local_path, "Program_Name");
			//Reusable action for Login to VCC     		
     	    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Reusable action for streaming media upload
     	    Upload_Media.Upload_complexPresentation(selenium, VAR_streamingMedia, streamingMediaType, streamingMediaDuration);	
		    //Create a vod program using the above mentioned streaming media
     	    Create_Program.test_Create_vodProgram(selenium, VAR_PogramName ,VAR_streamingMedia);
      	   	utilityFunction.waitForChangesToReflect();
		    //Play the vod program on the viewer portal
        	Play_Program.test_Play_vodCVP(selenium,VAR_DomClassic, VAR_PogramName, VAR_streamingMedia);
        	assertTrue("CVP_vod_msProducer","Classic VP: Ensure that an On Demand program (MS-Producer file) plays with HTTP delivery option.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_videoProgramCVP + VAR_streamingMedia));
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