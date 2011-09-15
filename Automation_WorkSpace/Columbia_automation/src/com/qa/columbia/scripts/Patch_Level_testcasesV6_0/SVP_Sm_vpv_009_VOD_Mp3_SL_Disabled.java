/*
* Classname                                                        SVP_VOD_Mp3_SLDisabled 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that an On Demand program(MP3 file) plays with HTTP delivery option if SL is disabled in browser.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the simple streaming radio button<br> 
* 																	>Browse the mp3 file to upload<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the mp3 is uploaded in the content successfully<br> 	
*																	>Create a VOD program containing the mp3 file
*  																    >Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to play the mp3 file successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 04/04/2011
* Updated by/on date: 												QASource on 04/04/2011
* 
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
* Silver light should be disabled in the browser's Add-ons.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

//import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_009_VOD_Mp3_SL_Disabled extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
		
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
			utilityFunction=null;
		}

	}		
	public void test_SVP_Sm_vpv_009_VOD_Mp3_SL_Disabled() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile ="SVP_Sm_vpv_009_VOD_Mp3_SL_Disabled.xml";
			//String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
			//Variable for mp3 full file name
			String VAR_MP3file = utilityFunction.GetValue(localVariableFile ,"VAR_fileType");
			//Variable for mp3 file name
			String VAR_MP3_fileName = utilityFunction.GetValue(localVariableFile ,"VAR_MP3_fileName");
			//Variable for VOD program name
			String str_ProgName= utilityFunction.GetValue(localVariableFile, "Program_Name");
	
			// Variable for asx filename
			String VAR_asxfile = utilityFunction.GetValue(localVariableFile ,"VAR_ASXfileName");
			
			//Reusable action for Login to VCC
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     	    
     		//Reusable action for Mp3 file upload
     		Upload_Media.Upload_streamingMedia(selenium, VAR_MP3_fileName, VAR_MP3file);
     		   
     		//Reusable action for Create VOD with Mp3 file
     		Create_Program.create_VODProgram(selenium, str_ProgName,"", VAR_MP3_fileName);
			utilityFunction.waitForChangesToReflect();	
			
			//Reusable to launch the social viewerportal URL
			Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
    		
			//call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_DomSocial, str_ProgName);
		   
		    String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
			utilityFunction.waitForChangesToReflect();
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");
			selenium.openWindow(contentlink_final+"&debug=true", "ASX");
		    selenium.selectWindow("ASX");
		    Thread.sleep(2000);
		    
		    //Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
			
			//To verify the asx file
		    assertTrue("Sm_vpv_009","Social VP: Ensure that an On Demand program(FLV file) plays with HTTP delivery option if SL is enabled in browser.",date,utilityFunction.assertTextContains(htmlsource, VAR_asxfile));
		    
		    selenium.close();
		    selenium.selectWindow("null");
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
