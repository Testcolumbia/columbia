/*
* Classname                                                        CVP_Sm_vpc_006_archiveRSSv6_medianet
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Verify that ingest for the archive media created using Live program(RSS4000v6)is completed successfully.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to delivery option and add two WMS delivery options.<br> 
*  															     	>Add a medianet delivery option.<br> 
*  																	>Navigate to Encoders and add RSS4kV6 encoder.<br>
*																	>Create an Live broadcast program using RSS encoder and medianet delivery option<br> 
* 																	>Launch the LBC (enable archiving)and Start the broadcast<br> 
* 																	>Play the program on viewer portal<br> 
* 																	>Stop the broadcast and wait for the archiving to complete.<br>
* 																	>Check the archived media under Contents<br>						 
* What Verification it performs:	 								1.Verify that ingest for the archive media created using Live program(RSS4000v6)is completed successfully.<br> 
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

public class CVP_Sm_vpc_006_archiveRSSv6_medianet extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_006_archiveRSSv6_medianet() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			String local_path = "CVP_archiveRSSv6_medianet.xml";
			//wait vaiable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for WMS origin name
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//Variable for WMS origin Host IP
			String VAR_WMSoriginHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//Variable for WMS origin HTTP port
			String VAR_WMSoriginHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//Variable for WMS origin user name
			String VAR_WMSoriginUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//Variable for WMS origin password
			String VAR_WMSoriginPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//Variable for WMS edge name
			String VAR_WMSedgeName = utilityFunction.GetValue(str_path ,"VAR_WMSedgeName");
			//Variable for WMS edge IP
			String VAR_WMSedgeHost = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHost");
			//Variable for WMS edge HTTP Port
			String VAR_WMSedgeHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHTTPport");
			//Variable for WMS edge username
			String VAR_WMSedgeUsername = utilityFunction.GetValue(str_path ,"VAR_WMSedgeUsername");
			//Variable for WMS edge password
			String VAR_WMSedgePassword = utilityFunction.GetValue(str_path ,"VAR_WMSedgePassword");
			//Variable for medianet name
			String VAR_medianetName = utilityFunction.GetValue(local_path ,"VAR_medianetName");
			//Variable for Encoder name
			String VAR_EncoderName = utilityFunction.GetValue(local_path ,"VAR_EncoderName");
			//Variable for Encoder Host IP
			String VAR_EncoderHostIP = utilityFunction.GetValue(local_path ,"VAR_EncoderHostIP");
			//Variable for Encoder username
			String VAR_EncoderUserName = utilityFunction.GetValue(local_path ,"VAR_EncoderUserName");
			//Variable for Encoder password
			String VAR_EncoderPassword = utilityFunction.GetValue(local_path ,"VAR_EncoderPassword");
			//Variable for Encoder profile name
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Variable for maximum number of live streams
			String VAR_MaxStreams = utilityFunction.GetValue(local_path ,"VAR_MaxStreams");
			//Variable for live program name
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for Archive media name
			String Var_ArchiveOfLiveRSSv6 = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveRSSv6");
			//Variable for framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for Login to admin portal
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Reusable action for Creating WMS
			Create_WMS.create_WMS(selenium, VAR_WMSoriginName, VAR_WMSoriginHost, VAR_WMSoriginHTTPport, VAR_WMSoriginUsername, VAR_WMSoriginPassword);
			//Reusable action for Creating WMS
			Create_WMS.create_WMS(selenium, VAR_WMSedgeName, VAR_WMSedgeHost, VAR_WMSedgeHTTPport, VAR_WMSedgeUsername, VAR_WMSedgePassword);
			//Reusable action for medianet
			Create_medianet.create_medianetDNS(selenium,VAR_medianetName, VAR_WMSoriginName, VAR_WMSedgeName, VAR_WMSedgeHost);
			//Reusable action for Creating RSS4kV6 encoder
			Create_Encoder.create_RSSv6enc(selenium, VAR_EncoderName, VAR_EncoderHostIP, VAR_EncoderUserName, VAR_EncoderPassword, VAR_MaxStreams, VAR_EncoderProfileName);
			//Reusable action for Creating Live program
			Live.test_Live(selenium,"Sm_vpc_006", Var_LiveProgramName, VAR_EncoderName, VAR_EncoderProfileName, VAR_medianetName);
			//Reusable action for Launching the LBC
			Launch_LBC.test_LaunchLBC(selenium,"Sm_vpc_006", Var_LiveProgramName, Var_ArchiveOfLiveRSSv6);
			//Select the admin portal window
		    selenium.selectWindow("null");
		    //Click on Domain name link
			selenium.click("link=" + VAR_DomClassic);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Select the viewer portal
			selenium.selectWindow("Qumu Program Browser Home");
			//Click on the live program name link
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + Var_LiveProgramName);
			//Wait for the page to load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Click on encoder profile link
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + VAR_EncoderProfileName);
			utilityFunction.waitForChangesToReflect();
			//Select the player window
			selenium.selectWindow("Qumu Program Player");	
			utilityFunction.waitForChangesToReflect();
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
	   		selenium.open(stream_URL + "&debug=true");     
	   		//Generate the asx file
			String htmlsource2 = selenium.getHtmlSource();
			System.out.println(htmlsource2);	
			utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName);
			//Checkpoint to check the asx file
			assertTrue("Sm_vpc_006","Verify that Live program is played successfully on the viewer portal.",date,utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName));
			//Close the window
			selenium.close();
			//Select the window with live program details
			selenium.selectWindow(Var_LiveProgramName);
			//Close the window
			selenium.close();
			//select the LBC window
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			//Navigate to Broadcast Control tab
			selenium.click(EnvObjectMap_Rep.tab_broadcastControl);
			//Stop the broacast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			utilityFunction.waitForChangesToReflect();
			//wait for the ingest to complete
			for (int second = 0;; second++) {
				if (second >= 500) fail("timeout");
				try { if (selenium.isTextPresent("(none)|Archive files fetched.|Completed")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Close the LBC
			selenium.close();
			//Select the main window
			selenium.selectWindow("null");
			utilityFunction.waitForChangesToReflect();
			//Click on Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//Wait for the page to load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			utilityFunction.waitForChangesToReflect();
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_ArchiveOfLiveRSSv6);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();		
			assertTrue("Sm_vpc_006","Verify that ingest for the archive media created using Live program(RSS4000v6)is completed successfully.",date,selenium.isTextPresent(Var_ArchiveOfLiveRSSv6));
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
