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
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_008_vod_msProducer extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag)
		{				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}
	}		
	public void test_CVP_vod_msProducer() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local variables file name
			String localVariableFile = "CVP_Sm_vpc_008_vod_msProducer.xml";
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(globalVariableFile,"Var_DomainClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");	
			//Variable for filename name
		    String VAR_streamingMedia = utilityFunction.GetValue(localVariableFile ,"VAR_msProducer_fileName");
			//Variable for filetype
			String streamingMediaType = utilityFunction.GetValue(localVariableFile ,"VAR_fileType");
			//Variable for duration
			String streamingMediaDuration = utilityFunction.GetValue(localVariableFile, "MediaDuration");
			//Variable for program name
			String VAR_PogramName = utilityFunction.GetValue(localVariableFile, "Program_Name");
			//variable for instance IP used for viewer portal
			String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_VCCInstanceIP");	
			
			//framework path will user for screen shot saving
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			//Reusable action for Login to VCC     		
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Reusable action for streaming media upload
     	    Upload_Media.Upload_complexPresentation(selenium, VAR_streamingMedia, streamingMediaType);	
		    //Create a vod program using the above mentioned streaming media
     	    Create_Program.create_VODProgram(selenium, VAR_PogramName,"" ,VAR_streamingMedia);
     	    //wait
      	   	utilityFunction.waitForChangesToReflect();
		    
      	   	//Play the vod program on the viewer portal
      	  Launch_VP.Launch_CVP(selenium, VAR_DomClassic);
      	  
			
			selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, VAR_PogramName);
			selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);				 
			utilityFunction.waitForChangesToReflect();				
			selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_PogramName);
			Thread.sleep(20000);
			selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_streamingMedia);			
			utilityFunction.waitForChangesToReflect();	
			//Capture the screenshot at the specified path
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_PogramName + ".jpg";		
			//Capture the screen shot of the program
			selenium.captureScreenshot(screenShot_locPath);			
        	
        	assertTrue("CVP_vod_msProducer","Classic VP: Ensure that an On Demand program (MS-Producer file) plays with HTTP delivery option.",date,selenium.isElementPresent(EnvObjectMap_Rep.LNK_Searchresultvideo + VAR_streamingMedia));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				 selenium.stop();
			}
		}					 
	}
}