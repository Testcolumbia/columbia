/*
* Classname                                                        SVP_Sm_vpv_004_Archived_RSSv4_MediaNet
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that ingest completes for archived content of Live program played with Medianet delivery option using RSS 2000 Version 4.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and creates 2 WMS such as Origin and Edge WMS<br> 
* 																	>Create an RSS 2000 V4 Encoderand then Encoder Profile for RSS 2000 V4.
*																	>Create a MediaNet using the above WMS and MediaNet<br> 
*  															     	>Create a Live Program with the MediaNet delivery option<br> 
*																	>Launch the LBC and starts the broadcast<br> 
* 																	>Navigate to Social Viewer Portal and play the Live Video<br> 
* 																	>Capture the screenshot of the player window<br> 
* 																	>Generate the asx file 
* 																	>Verify the stream in the asx file
* 																	>Navigate to LBC and Stop the broadcast<br> 	
*  													     			>Wait till the message "Archive files fetched.|Completed" is displayed in Console for LBC<br> 
*   																>Navigate to Admin portal<br>
*   																>Navigate to Content and search for the archive created  with status "Active" 																			 
* What Verification it performs:	 								1.Verify that ingest completes for archived content of Live program played with Medianet delivery option using RSS 2000 Version<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 18/04/2011
* Updated by/on date: 												QASource on 18/04/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_004_Archived_RSSv4_MediaNet extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_004_Archived_RSSv4_MediaNet() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//local variable file name
			String local_path = "SVP_LiveProgramArchived_MediaNet_RSS2kv4.xml";
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//doamain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the WMS name
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName_new");
			//Variable for the host IP
			String VAR_WMSoriginHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//Variable for the wms HTTP port
			String VAR_WMSoriginHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//Variable for the wms user name
			String VAR_WMSoriginUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//Variable for the wms password
			String VAR_WMSoriginPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//Variable for the edge WMS name
			String VAR_WMSedgeName = utilityFunction.GetValue(str_path ,"VAR_WMSedgeName_new");
			//Variable for the edge WMS host IP
			String VAR_WMSedgeHost = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHost");
			//Variable for the edge WMS HTTP port
			String VAR_WMSedgeHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHTTPport");
			//Variable for the edge WMS user-name
			String VAR_WMSedgeUsername = utilityFunction.GetValue(str_path ,"VAR_WMSedgeUsername");
			//Variable for the edge WMS password
			String VAR_WMSedgePassword = utilityFunction.GetValue(str_path ,"VAR_WMSedgePassword");
			//variable for Encoder name
			String VAR_Encodername = utilityFunction.GetValue(local_path ,"VAR_Encodername");
			//variable for Encoder Host
			String VAR_EncoderHostIP = utilityFunction.GetValue(local_path ,"VAR_EncoderHostIP");
			//variable for Encoder Version
			String VAR_EncoderVersion = utilityFunction.GetValue(local_path ,"VAR_EncoderVersion");
			//variable for media net name
			String VAR_medianetName = utilityFunction.GetValue(local_path ,"VAR_medianetName");
			//Variable for Encoder User name			
			String VAR_EncoderUserName = utilityFunction.GetValue(local_path ,"VAR_EncoderUserName");
			//Variable for Encoder password		
			String VAR_EncoderPassword = utilityFunction.GetValue(local_path ,"VAR_EncoderPassword");
			//Variable for Encoder profile name	
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Variable for Encoder bit rate		
			String VAR_EncoderBitRate = utilityFunction.GetValue(local_path ,"VAR_EncoderBitRate");	
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archive of Live program
			String Var_ArchiveOfLiveRSSv5 = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveRSSv5");
		    //Variable for the Framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Variable for asx file 
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Reusable to login to admin viewer portal
		    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
		    //Create a Origin WMS
		    Create_WMS.create_WMS(selenium, VAR_WMSoriginName, VAR_WMSoriginHost, VAR_WMSoriginHTTPport, VAR_WMSoriginUsername, VAR_WMSoriginPassword);
			//Reusable action for creating WMS 
			Create_WMS.create_WMS(selenium, VAR_WMSedgeName, VAR_WMSedgeHost, VAR_WMSedgeHTTPport, VAR_WMSedgeUsername, VAR_WMSedgePassword);
			//Reusable to create a RSS Encoder 2000 v4
		    Create_Encoder.create_RSSv5enc(selenium, VAR_Encodername, VAR_EncoderHostIP, VAR_EncoderVersion, VAR_EncoderUserName, VAR_EncoderPassword, VAR_EncoderProfileName, VAR_EncoderBitRate);
			//Create a Medianet 
		    Create_medianet.create_medianetDNS(selenium, VAR_medianetName, VAR_WMSoriginName, VAR_WMSedgeName, VAR_WMSedgeHost);
			//Reusable to create a live program
		    Live.test_Live(selenium, "Sm_vpv_004", Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, VAR_medianetName);
		    //Launch the LBC
		    Launch_LBC.test_LaunchLBC(selenium, "Sm_vpv_004", Var_LiveProgramName, Var_ArchiveOfLiveRSSv5);
		   	//select the admin portal window	   
	        selenium.selectWindow("null");		
			//Launch the viewer portal video
			selenium.openWindow(Var_Columbia_vpURL+VAR_DomSocial+"/home.vp?debug=true", "SVP");
			//Select the viewer portal	
			selenium.selectWindow("SVP");
			selenium.windowMaximize();					
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_AllVideos, 300);	
			//click the All Videos link to search the live program
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
			utilityFunction.waitForChangesToReflect();
		   selenium.type(EnvObjectMap_Rep.TBX_SearchSVP,Var_LiveProgramName);
		   //utilityFunction.waitForChangesToReflect();
		   //Set focus on the search textbox
		   selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
		   //select the icon to perform search
		   selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
		   //Wait
		   utilityFunction.waitForChangesToReflect();	
		   //select the Live program from all Videos in search results					
		   for (int i = 1; i<50; i++){
			   String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
			   System.out.println(str_var);	   
			   if(str_var.equals(Var_LiveProgramName)){
				   selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
				   break;
			   }                  
		   }
		   //Wait      
		   utilityFunction.waitForChangesToReflect();
		     //variable for path where to save the screenshot    
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath); 
		    //Wait
	        utilityFunction.waitForChangesToReflect();
	       
	        
	        //select the asx link
	        String contentlink = selenium.getText(Var_asxLink);
	        //wait
	        utilityFunction.waitForChangesToReflect();  
	         //split the string
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
			selenium.click("link=exact:"+contentlink_final);
			utilityFunction.waitForChangesToReflect();
			//Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
		    //verify whether the correct encoder profile is displayed in asx file
			assertTrue("Sm_vpv_004","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_EncoderProfileName));
		    assertTrue("Sm_vpv_004","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms"));
			//utilityFunction.waitForChangesToReflect();
			selenium.close();
			selenium.selectWindow("null");
		    for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        } 
		    //Stop the broadcast
		    selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
		    Thread.sleep(5000);
		     //wait till the ingest is shown completed in LBC
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				try { if (selenium.isTextPresent("Archive files fetched.|Completed")) break; 
				} catch (Exception e) {}
				Thread.sleep(1000);
			 }
		   // verify that the Archive files fetched completed message is displayed in LBC console
		    assertTrue("Sm_vpv_004","Verify that ingest completed is displayed",date,selenium.isTextPresent("(none)|Archive files fetched.|Completed "));
		    selenium.close();
		    //Navigate to Admin Portal
			selenium.selectWindow("null");
			//Select Programming link
			selenium.click(EnvObjectMap_Rep.LNK_Programming);
			//Select Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//wait
 			selenium.waitForPageToLoad(VAR_MED_WAIT);
			   for (int second = 0;; second++) {
					if (second >= 300) fail("timeout");
					try { if (selenium.isElementPresent(EnvObjectMap_Rep.BTN_More_Search)) break; 
					} catch (Exception e) {}
					Thread.sleep(1000);
				 }
			//click Search
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			utilityFunction.waitForChangesToReflect();
			//provide the search term
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_ArchiveOfLiveRSSv5);
			//select the status as Active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			assertTrue("Sm_vpv_004","Social VP: Ensure that ingest completes for archived content of Live program played with Medianet delivery option using RSS 2000 Version 4.",date,selenium.isTextPresent(Var_ArchiveOfLiveRSSv5));
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