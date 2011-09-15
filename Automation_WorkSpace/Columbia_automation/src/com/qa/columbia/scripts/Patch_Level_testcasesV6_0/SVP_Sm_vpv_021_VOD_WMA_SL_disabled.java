/*
* Classname                                                       SVP_VOD_WMA_SL_disabled
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that an On Demand program(Wma file) plays with HTTP delivery option if SL is disabled in browser.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the Simple Streaming Media radio button<br> 
* 																	>Browse the wma file to upload<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the wma file is uploaded in the content successfully<br> 	
*  																    >Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to play the wma file successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 05/04/2011
* Updated by/on date: 												QASource on 05/04/2011
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

public class SVP_Sm_vpv_021_VOD_WMA_SL_disabled extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_021_VOD_WMA_SL_disabled() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile ="SVP_Sm_vpv_021_VOD_WMA_SL_disabled.xml";
			//String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
			//Variable for wma file type
			String VAR_WMAfile = utilityFunction.GetValue(localVariableFile ,"VAR_fileType");
			//Variable for wma file name
			String VAR_WMA_fileName = utilityFunction.GetValue(localVariableFile ,"VAR_WMA_fileName");
			//Variable for VOD program name
			String str_ProgName= utilityFunction.GetValue(localVariableFile, "Program_Name");
				
			// Variable for asx filename
			String VAR_asxfile = utilityFunction.GetValue(localVariableFile ,"VAR_ASXfileName");
			//Reusable action for Login to VCC
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     		//Reusable action for wma file upload
     		Upload_Media.Upload_streamingMedia(selenium, VAR_WMA_fileName, VAR_WMAfile);
     		   
     		//Reusable action for Create VOD with wma file
     		Create_Program.create_VODProgram(selenium, str_ProgName,"", VAR_WMA_fileName);
			
        	//Wait
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
			 assertTrue("Sm_vpv_021","Social VP: Ensure that an On Demand program(Wma file) plays with HTTP delivery option if SL is disabled in browser.",date,utilityFunction.assertTextContains(htmlsource, VAR_asxfile));
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
