/*
* Classname                                                        CVP_Sm_vpc_005_archiveWME
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that ingest completes for archived content of Live program played with WMS delivery option using WME.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to delivery option and add a Windows Media Server<br> 
*  																	>Navigate to Encoders and add RSS4kV6 encoder.<br>
*																	>Create an Live broadcast program using RSS encoder and medianet delivery option<br> 
* 																	>Launch the LBC (enable archiving)and Start the broadcast<br> 
* 																	>Play the program on viewer portal<br> 
* 																	>Stop the broadcast and wait for the archiving to complete.<br>
* 																	>Check the archived media under Contents<br>						 
* What Verification it performs:	 								1.Verify that ingest for the archive media created using Live program(WME)is completed successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_005_archiveWME extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_005_archiveWME() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local path
			String local_path = "CVP_archiveWME.xml";
			//Wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the Encoder Name
			String VAR_Encodername = utilityFunction.GetValue(str_path ,"VAR_Encodername");
			//Variable for the encoder host name
			String VAR_EncoderHostIP = utilityFunction.GetValue(str_path ,"VAR_EncoderHostIP");
			//Variable for the Qumu Encoder service Port 
			String VAR_EncoderServicePort = utilityFunction.GetValue(str_path ,"VAR_EncoderServicePort");
			//Variable for the Qumu Encoder Profile
			String VAR_EncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_EncoderProfileName");
			//Variable for the Document root directory path
			String VAR_EncoderDocRoot = utilityFunction.GetValue(str_path ,"VAR_EncoderDocRoot");
			//Variable for the Encoder Port
			String VAR_EncoderPort = utilityFunction.GetValue(str_path ,"VAR_EncoderPort");
			//Variable for the saved encoder profile file name (with path)
			String VAR_EncoderProfileFileName= utilityFunction.GetValue(str_path ,"VAR_EncoderProfileFileName");
			//Delivery option name
			String Var_deliveryOption = utilityFunction.GetValue(str_path, "VAR_WMSoriginName");
			//Variable for the Live program name
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archived media name
			String VAR_archiveMediaName = utilityFunction.GetValue(local_path, "VAR_archiveMediaName");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Variable for the WMS name
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//Variable for the host IP
			String VAR_WMSoriginHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//Variable for the wms HTTP port
			String VAR_WMSoriginHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//Variable for the wms user name
			String VAR_WMSoriginUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//Variable for the wms password
			String VAR_WMSoriginPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//Reusable action for Login to VCC
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Create WMS delivery option
			Create_WMS.create_WMS(selenium, VAR_WMSoriginName, VAR_WMSoriginHost, VAR_WMSoriginHTTPport, VAR_WMSoriginUsername, VAR_WMSoriginPassword);
			//Reusable action to create WME encoder
			Create_Encoder.create_WME(selenium, VAR_Encodername, VAR_EncoderHostIP, VAR_EncoderServicePort, VAR_EncoderDocRoot, VAR_EncoderProfileName, VAR_EncoderPort, VAR_EncoderProfileFileName);
			//Create  a Live program
			Live.test_Live(selenium,"Sm_vpc_005", Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, Var_deliveryOption);
			//Launch the LBC and start the broadcast
			Launch_LBC.test_LaunchLBC(selenium, "Sm_vpc_005", Var_LiveProgramName, VAR_archiveMediaName);
			//Select the main winodow
			selenium.selectWindow("null");
			selenium.click("link=" + VAR_DomClassic);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//Select the viewer portal window
			selenium.selectWindow("Qumu Program Browser Home");
			//Click on the live program link
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + Var_LiveProgramName);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Click on the Encoder profile link
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + VAR_EncoderProfileName);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Select the player window
			selenium.selectWindow("Qumu Program Player");	
			//wait
			utilityFunction.waitForChangesToReflect();
			//Path for the screenshot to be saved
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath); 
			String htmlsource = selenium.getHtmlSource();
        	int start_URL = htmlsource.indexOf("player.URL = ");
       	    int end_URL = htmlsource.lastIndexOf("this.mediaEnded = false");    
       	    //String to hold the stream URL
        	String stream_URL1 = htmlsource.substring(start_URL, end_URL);
        	int stream_URL_length = stream_URL1.length();
        	String stream_URL = stream_URL1.substring(14, stream_URL_length-4);
	   		//Open the URL to generate the asx file
	   		selenium.open(stream_URL + "&debug=true"); 
	   		selenium.waitForPageToLoad("50000");
	   		//Get the asx file
			String htmlsource2 = selenium.getHtmlSource();
			//System.out.println(htmlsource2);
			//Verify that the asx file is correct
			assertTrue("Sm_vpc_005","Verify that Live program is played successfully on the viewer portal.",date,utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName));
			//Close the player window
			selenium.close();
			selenium.selectWindow(Var_LiveProgramName);
			selenium.close();
			selenium.selectWindow("null");
			//selenium.selectWindow("null");
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			//Navigate to Broadcast Control tab
			selenium.click(EnvObjectMap_Rep.tab_broadcastControl);
			//Stop the broacast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			//wait
			utilityFunction.waitForChangesToReflect();
			//wait for the ingest to complete
			for (int second = 0;; second++) {
				if (second >= 700) fail("timeout");
				try { if (selenium.isTextPresent("(none)|Archive files fetched.|Completed")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Close the LBC
			selenium.close();
			//Select the main window
			selenium.selectWindow("null");
			//wait
			utilityFunction.waitForChangesToReflect();
			//Click on Content
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//wait for the page to load
			selenium.waitForPageToLoad("50000");
			utilityFunction.waitForChangesToReflect();
			//click on advanced search
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Provide the archived media name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,VAR_archiveMediaName);
			//select the upload status as Active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();		
			assertTrue("Sm_vpc_005","Ensure that ingest completes for archived content of Live program played with WMS delivery option using WME.",date,selenium.isTextPresent(VAR_archiveMediaName));
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