/*
* Classname                                                        CVP_Sm_vpc_022_AutomatedPT_RSSdisc4kV5_NonPinProtected 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that a non pin protected automated program is created through RSS 4000 Version6 polycom discovery.
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming template menu<br> 
*																	
*																	>Create an Automated file Broadcast Template<br> 
* 																	>Create an On-demand Program Template<br> 
* 																	>Add RSS4kV5 device with import live call options checked<br> 
* 																	>Configure the RSS4kV5 device and map the above created template programs to a NOn-Pin-protected VRR<br>
* 																	>Place a call from the Endpoint to the Non-pin protected VRR<br>
* 																	>Notice that the Automated program is created for the call<br> 	
*  													     			>Play the program on the viewer portal<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that protected automated file broadcast program is created for the Non-pin protected call using RSS4kV5 discovery.<br> 
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

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;

import com.qa.columbia.functions.v6_0.*;

import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_022_AutomatedPT_RSSdisc4kV5_NonPinProtected extends TesterAsserter {
	
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
		}

	}		
	public void test_Sm_vpc_021_AutomatedPT_RSSdisc4kv6_PinProtected() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local variable file name
			String localVariableFile ="CVP_Sm_vpc_021_AutomatedPT_RSSdisc4kv6_PinProtected.xml";
			
			//Variable for wait time
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for domain name
			String VAR_DomClassic = utilityFunction.GetValue(globalVariableFile,"Var_DomainClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			//Variable for the RSS device name
			String VAR_RSS4kv5DeviceName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceNamev4kv5");
			//Variable for the RSS device IP
			String VAR_RSS4kv5DeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceHostIP4kv5");
			//Variable for the program and content (discovered using RSS discovery) name prefix 
			String VAR_ProgPrefix = utilityFunction.GetValue(localVariableFile ,"VAR_ProgPrefix");
			//Variable for the Endpoint IP
			String VAR_endPointIP = utilityFunction.GetValue(globalVariableFile ,"VAR_endPointIP");
			
			String VAR_VRRPin_PinProtected = utilityFunction.GetValue(globalVariableFile, "VAR_VRRPin_PinProtected");
			// Variable for program name
			String VAR_AutofileBroadcastTemplatename=utilityFunction.GetValue(localVariableFile ,"TemplateAutofileBroadcast");
			
			// Variable for program name
			String VAR_VODTemplatename=utilityFunction.GetValue(localVariableFile ,"TemplateVODName");
			
			 //Variable for Media format
			 String VAR_MediaFormat=utilityFunction.GetValue(localVariableFile ,"MediaFormat");
			 String ContentHostIP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");	
			//Variable for Video net Edge delivery option
			 String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");

				
				
			 
			 String VAR_VRRnumber_NonPinProtected = utilityFunction.GetValue(globalVariableFile ,"VAR_VRRnumber_NonPinProtected");
			//Variable for the framework path
			//String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			//Reusable action for login to VCC
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			
	
			//Create AutomatedFileBroadcastTemplate
			Create_ProgramTemplate.test_Create_AutomatedFileBroadcastTemplate(selenium, VAR_AutofileBroadcastTemplatename, VAR_MediaFormat, Var_VEasWMS_DO);
			
			////Create VODTemplate
		Create_ProgramTemplate.test_Create_VODTemplate(selenium, VAR_VODTemplatename, VAR_MediaFormat, Var_VEasWMS_DO);
			
			
			selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDevices);
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.btn_addRSSDevice, 300);
			selenium.click("link="+VAR_RSS4kv5DeviceName);
	        //Wait for the page to load
			selenium.waitForPageToLoad("30000");
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_rssv6EnableLive))
			{
				//Click on the check box "Import Archive calls"
				selenium.click(EnvObjectMap_Rep.chk_rssv6EnableLive);
			}
			//Click on the Save button
			selenium.click(EnvObjectMap_Rep.btn_saveRSSv6Device);
			//wait for the page to load
			selenium.waitForPageToLoad("30000");
			
		
		if(selenium.isElementPresent(EnvObjectMap_Rep.Chk_selectDiscoveryDevice))
		{
			RSS_discovery.DeleteAll_RSSDiscoveryConfigurations(selenium);
		}
			//Reusable action for configuring an RSS4kV6 			
			RSS_discovery.Configure_RSS2kdiscovery(selenium, VAR_RSS4kv5DeviceName, VAR_RSS4kv5DeviceHostIP, VAR_ProgPrefix, VAR_AutofileBroadcastTemplatename, VAR_VODTemplatename);
			
		PlaceCall_endpoint.PlaceCall_RSS2k(selenium, VAR_RSS4kv5DeviceHostIP, VAR_endPointIP);
			
		selenium.selectWindow("null");
			PlaceCall_endpoint.StartRecording_RSS2k(selenium, VAR_RSS4kv5DeviceHostIP);
		selenium.selectWindow("null");
			selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDiscovery);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
		utilityFunction.waitForChangesToReflect();
			//Check if the call has been discovered 
			for (int y = 0;y<=16;y++)
			{
				selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDiscovery);
				utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.Lnk_contextMenuDiscovery, 300);
				selenium.click(EnvObjectMap_Rep.Lnk_contextMenuDiscovery);
				System.out.println("context menu link");
				if((selenium.getText(EnvObjectMap_Rep.Lnk_Discoveries)).equals("Discoveries (0)"))
				{
				//Click on Polycom RSS Discovery link
				selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDiscovery);
				//wait fo rthe page to load
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				//wait
				utilityFunction.waitForChangesToReflect();
				utilityFunction.waitForChangesToReflect();
				utilityFunction.waitForChangesToReflect();
			    }
				else
				{
					break;
				}
			}
			//Click on the discovered calls link
			selenium.click(EnvObjectMap_Rep.Lnk_Discoveries);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			String Var_AutomatedLiveProgramName = "";
			for (int i =4;i<=10;i++)
			{
				if(selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_DiscoveredProgram, i)).startsWith(VAR_ProgPrefix))
				{
				//check if the program is created with the program prefix				
					Var_AutomatedLiveProgramName = selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_DiscoveredProgram, i));
				//Click on the program name link
				selenium.click("link="+Var_AutomatedLiveProgramName);
				//Wait
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				boolean pinStatus;
				if(selenium.getText(EnvObjectMap_Rep.lbl_pinStatusAutomatedSummaryPage).equals("No"))
				{
					pinStatus = true;
					//Verify that non-pin protected program is created for the call
					assertTrue("Sm_vpc_022","Verify that automated file broadcast program is created for the live call.",date,pinStatus);
				}
				break;
				}
			}		

		Launch_VP.Launch_CVP(selenium, VAR_DomClassic);
		//Click on home tab
		selenium.click(EnvObjectMap_Rep.tab_HomeCVP);
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		//Click on the live program link
		selenium.click("link="+ Var_AutomatedLiveProgramName);
		//wait for page load
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		//Click on the live program stream link
		selenium.click("link="+ VAR_ProgPrefix+"*");
		//wait
		utilityFunction.waitForChangesToReflect();
			//Select the player window
		selenium.selectWindow("Qumu Program Player");
		//wait
		utilityFunction.waitForChangesToReflect();
		String htmlsource1 = selenium.getHtmlSource();
    	int start_URL1 = htmlsource1.indexOf("player.URL = ");
   	    int end_URL1 = htmlsource1.lastIndexOf("this.mediaEnded = false");    
   	    //String to hold the stream URL
    	String stream_URL1 = htmlsource1.substring(start_URL1, end_URL1);
    	int stream_URL1_length = stream_URL1.length();
    	stream_URL1 = stream_URL1.substring(14, stream_URL1_length-4);
    	//Open the window to generate the asx file
   		selenium.open(stream_URL1 + "&debug=true");  
   		selenium.waitForPageToLoad("90000");
   		//Generate the asx file
		String htmlsource2 = selenium.getHtmlSource();
		//Verify that asx file
		assertTrue("Sm_vpc_022","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + ContentHostIP	));
		assertTrue("Sm_vpc_022","Verify that mms protocol is displayed in asx file for the discovered automated file broadcast program.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
		
		selenium.close();
		selenium.selectWindow(Var_AutomatedLiveProgramName);
		selenium.close();
		selenium.selectWindow("null");
		PlaceCall_endpoint.HangCall_RSS4kv6(selenium, VAR_endPointIP);
		

		selenium.selectWindow("null");
		
		utilityFunction=null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				 selenium.close();
				 selenium.stop();
			}
		}
	}
}