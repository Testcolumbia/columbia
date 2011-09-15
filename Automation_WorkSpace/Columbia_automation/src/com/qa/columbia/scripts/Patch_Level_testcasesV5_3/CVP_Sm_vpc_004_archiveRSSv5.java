/*
* Classname                                                        CVP_Sm_vpc_004_archiveRSSv5 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Verify that ingest for the archive media created using Live program(RSS4000v5) is completed successfully.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Create RSS4kV5 encoder.<br> 
*  															     	>Create Live program using the above encoder.<br> 
*																	>Launch LBC and start broadcast.<br> 
* 																	>Play the Program on viewer portal.<br> 
* 																	>Stop the broadcast from LBC and wait for the archiving to complete<br> 
* 																	>Novigate to content and verify the ingest of archived content.<br>
* 																	>Verify the stream in the asx file															 
* What Verification it performs:	 								1.Verify that ingest for the archive media created using Live program(RSS4000v5) is completed successfully.<br> 
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


public class CVP_Sm_vpc_004_archiveRSSv5 extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_004_archiveRSSv5() throws Exception {
		{
			try{
			setUp();
			//Object for utility function
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file
			String local_path = "CVP_archiveRSSv5.xml";
			//Wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Encoder name
			String VAR_Encodername = utilityFunction.GetValue(local_path ,"VAR_Encodername");
			//Encoder Host IP
			String VAR_EncoderHostIP = utilityFunction.GetValue(local_path ,"VAR_EncoderHostIP");
			//Encoder version
			String VAR_EncoderVersion = utilityFunction.GetValue(local_path ,"VAR_EncoderVersion");
			//Encoder user name
			String VAR_EncoderUserName = utilityFunction.GetValue(local_path ,"VAR_EncoderUserName");
			//Encoder password
			String VAR_EncoderPassword = utilityFunction.GetValue(local_path ,"VAR_EncoderPassword");
			//Encoder Profile name
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Encoder bitrate
			String VAR_EncoderBitRate = utilityFunction.GetValue(local_path ,"VAR_EncoderBitRate");	
			//delivery option name
			String Var_deliveryOption = utilityFunction.GetValue(str_path, "VAR_WMSoriginName");
			//Live program name
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Archived content name
			String Var_ArchiveOfLiveRSSv5 = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveRSSv5");
			//framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for login 
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Reusable action for RSS4kv5 encoder
			Create_Encoder.create_RSSv5enc(selenium, VAR_Encodername, VAR_EncoderHostIP, VAR_EncoderVersion, VAR_EncoderUserName, VAR_EncoderPassword, VAR_EncoderProfileName, VAR_EncoderBitRate);
			//Reusable action for live program
			Live.test_Live(selenium,"Sm_vpc_004", Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, Var_deliveryOption);
			//Reusable action to launch LBC
			Launch_LBC.test_LaunchLBC(selenium,"Sm_vpc_004", Var_LiveProgramName, Var_ArchiveOfLiveRSSv5);
		    selenium.selectWindow("null");
			selenium.click("link=" + VAR_DomClassic);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.selectWindow("Qumu Program Browser Home");
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + Var_LiveProgramName);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + VAR_EncoderProfileName);
			utilityFunction.waitForChangesToReflect();
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
			assertTrue("Sm_vpc_004","Verify that Live program is played successfully on the viewer portal.",date,utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName));
			selenium.close();
			selenium.selectWindow(Var_LiveProgramName);
			selenium.close();
			selenium.selectWindow("null");
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			selenium.click("//div[@id='lbcTabControl']/span");
			selenium.click("stopBroadcastButton");
			utilityFunction.waitForChangesToReflect();
			selenium.close();
			selenium.selectWindow("null");
			 utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			selenium.waitForPageToLoad("50000");
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			utilityFunction.waitForChangesToReflect();
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_ArchiveOfLiveRSSv5);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();		
			assertTrue("Sm_vpc_004","Verify that ingest for the archive media created using Live program(RSS4000v5) is completed successfully.",date,selenium.isTextPresent(Var_ArchiveOfLiveRSSv5));
			utilityFunction=null;
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			finally
			{
			selenium.close();
			selenium.stop();		}
		}					 
	}
}
