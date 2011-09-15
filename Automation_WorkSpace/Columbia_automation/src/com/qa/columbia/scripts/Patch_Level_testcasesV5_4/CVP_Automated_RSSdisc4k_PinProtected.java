/*
* Classname                                                        CVP_Automated_RSSdisc4k_PinProtected 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that a pin protected automated program is created through RSS 4000 Version6 polycom discovery.
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add a wmv file<br> 
*  															     	>Add an windows external Streaming media<br> 
*																	>Create an Automated file program using the external streaming media<br> 
* 																	>Create an On-demand file program using the .wmv file<br> 
* 																	>Add RSS4kV6 device with import live call options checked<br> 
* 																	>Configure the RSS4kV6 device and map the above created template programs to a Pin-protected VRR<br>
* 																	>Place a call from the endpoint to the pin protected VRR<br>
* 																	>Notice that the Pin protected program is created for the call<br> 	
*  													     			>Play the program on the viewer portal<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that Pin-protected automated file broadcast program is created for the pin-protected call using RSS4kV6 discovery.<br> 
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

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_Automated_RSSdisc4k_PinProtected extends TesterAsserter {
	
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
	public void test_CVP_Automated_RSSdisc4k_PinProtected() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file name
			String local_path ="CVP_Automated_RSSdisc4k_PinProtected.xml";
			//Variable for wait time
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the external streaming media name
			String VAR_esmName = utilityFunction.GetValue(local_path ,"VAR_esmName");
			//Variable for the external streaming media URL
			String VAR_esmURL = utilityFunction.GetValue(local_path ,"VAR_esmURL");
			//Variable for the RSS device name
			String VAR_RSSDeviceName = utilityFunction.GetValue(local_path ,"VAR_RSSDeviceName");
			//Variable for the RSS device IP
			String VAR_RSSDeviceHostIP = utilityFunction.GetValue(local_path ,"VAR_RSSDeviceHostIP");
			//Variable for the Endpoint IP
			//String VAR_EndPointIP = utilityFunction.GetValue(local_path ,"VAR_EndPointIP");
			//Variable for the RSS user name
			String VAR_RSSUsername = utilityFunction.GetValue(local_path ,"VAR_RSSUsername");
			//Variable for the RSS password
			String VAR_RSSPassword = utilityFunction.GetValue(local_path ,"VAR_RSSPassword");
			//Variable for the program and content (discovered using RSS discovery) name prefix 
			String VAR_ProgPrefix = utilityFunction.GetValue(local_path ,"VAR_ProgPrefix");
			//Variable for the VRR number on RSS device
			//String VAR_RSSv6_VRR_Number = utilityFunction.GetValue(local_path ,"VAR_RSSv6_VRR_Number");
			//Variable for the pin of VRR
		//	String VAR_VRR_Pin = utilityFunction.GetValue(local_path, "VAR_VRR_Pin");
			String VAR_VRRPin_PinProtected = utilityFunction.GetValue(str_path, "VAR_VRRPin_PinProtected");
			//Variable for the Endpoint IP
			String VAR_endPointIP = utilityFunction.GetValue(str_path ,"VAR_endPointIP");
			//Variable for the VRR number on RSS device
	    	String VAR_VRRnumber_PinProtected = utilityFunction.GetValue(str_path ,"VAR_VRRnumber_PinProtected");
			//Variable for the master automated file broadcast program name
			String VAR_masterAuto = utilityFunction.GetValue(local_path ,"VAR_masterAuto");
			//Variable for the master on-demand program
			String VAR_masterVOD = utilityFunction.GetValue(local_path ,"VAR_masterVOD");
			//Variable for the wmv name
			String VAR_wmvFile = utilityFunction.GetValue(local_path ,"VAR_wmvFile");
			//Variable for the wmv source file name
			String VAR_wmvSourceFile = utilityFunction.GetValue(local_path ,"VAR_wmvSourceFile");
			//Variable for the WMS delivery option name
			String VAR_WMSName = utilityFunction.GetValue(str_path, "VAR_WMSoriginName");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for login to VCC
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Navigate to Domains
    		selenium.click(EnvObjectMap_Rep.LNK_Domains);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Click on the required domain
    		String VAR_domainLink = EnvObjectMap_Rep.lnk_editDomain + VAR_DomClassic + "')]";
    		selenium.click(VAR_domainLink);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Check the Approval required checkbox
    		if (!selenium.isChecked(EnvObjectMap_Rep.chk_allowDuplicatePasscode))
    		{
    			//check the "Require Program Approval checkbox
    			selenium.click(EnvObjectMap_Rep.chk_allowDuplicatePasscode);
    		}
     		//Save the domain settings
    		selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
    		selenium.click(EnvObjectMap_Rep.LNK_Programming);
			//Select the Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//Wait for loading the page
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name, VAR_wmvFile);
			//Select the status as active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//Wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			if(!selenium.isTextPresent(VAR_wmvFile))
			{
				Upload_Media.Upload_streamingMedia(selenium, VAR_wmvFile, VAR_wmvSourceFile);
			}
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//Wait for loading the page
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name, VAR_esmName);
		//	selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//Wait for loading the page
			utilityFunction.waitForChangesToReflect();
		//	utilityFunction.waitForChangesToReflect();
			if(!selenium.isTextPresent(VAR_esmName))
			{
			Upload_Media.Upload_externalStreamingMedia(selenium, VAR_esmName, VAR_esmURL);
			}
			//Open the Programs age
	    	selenium.click(EnvObjectMap_Rep.LNK_Programs);
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Search for automated file broadcast program
	    	selenium.type(EnvObjectMap_Rep.SelectType_Search_Program, VAR_masterAuto);
			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Check if program exists
	    	if(!selenium.isElementPresent("link="+VAR_masterAuto))
	    	{
	    		//Reusable action to create the program
	    		Create_Program.create_AutoFileProgram(selenium, VAR_masterAuto, VAR_esmName, VAR_WMSName);
	        	
				//Search the new created Live program
				selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
				//Provide program name in Search field
				selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_masterAuto);
				//Click Search button 
				selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
				//wait for loading the page
				selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	}
	        selenium.click("link=" + VAR_masterAuto);		    
			selenium.waitForPageToLoad(VAR_MED_WAIT);	
			//Check if the program is saved as master program
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_masterProgram))
			{
				selenium.click(EnvObjectMap_Rep.chk_masterProgram);	
			}
			selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Click Programs menu
	    	selenium.click(EnvObjectMap_Rep.LNK_Programs);
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Provide program name in Search field
			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_masterVOD);
			//click Search button 
			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
			//wait for loading the page
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Check if master program exists
	    	if(!selenium.isElementPresent("link="+VAR_masterVOD))
	    	{
			Create_Program.test_Create_vodProgram(selenium, VAR_masterVOD, VAR_wmvFile);
	    	
			//Search the new created Live program
			selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
			//Provide program name in Search field
			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_masterVOD);
			//Click Search button 
			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
			//wait for loading the page
			selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	}
		    selenium.click("link=" + VAR_masterVOD);		    
			selenium.waitForPageToLoad(VAR_MED_WAIT);	
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_masterProgram))
			{
				selenium.click(EnvObjectMap_Rep.chk_masterProgram);	
			}
			selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
			//Wait for the page to load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.click("link=Polycom RSS Devices");
			selenium.waitForPageToLoad("30000");
			if(selenium.isTextPresent(VAR_RSSDeviceHostIP))
			{
				for (int i = 4; i<50;i=i+1 )
				{
			    	String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lbl_deviceHost, i));
			    	//System.out.println(str_var);				    	
			    	if (str_var.equals(VAR_RSSDeviceHostIP))
			    	{
			    		//Check the checkbox next to the RSS device
			    		selenium.click(MessageFormat.format(EnvObjectMap_Rep.chk_deviceSelect, i));
			    		//Click on Delete button
			    		selenium.click(EnvObjectMap_Rep.btn_deleteRSSDevice);
			    		//Click on Confirm Delete
			    		selenium.click(EnvObjectMap_Rep.btn_confirmDeleteRSSDevice);
			    		//Wait for teh page to load
			    		selenium.waitForPageToLoad("30000");
		              break;
		          }  				    	
			   }					
			}	
			//Reusable action for adding an RSS4kV6 device
			RSS_discovery.Add_device(selenium, VAR_RSSDeviceName, VAR_RSSDeviceHostIP, VAR_RSSUsername, VAR_RSSPassword);
			//Click on the added device name
			selenium.click("link="+VAR_RSSDeviceName);
	        //Wait for the page to load
			selenium.waitForPageToLoad("30000");
			//Click on teh check box "Import Live calls"
			selenium.click(EnvObjectMap_Rep.chk_rssv6EnableLive);
			//Click on the Save button
			selenium.click(EnvObjectMap_Rep.btn_saveRSSv6Device);
			//wait for the page to load
			selenium.waitForPageToLoad("30000");
			//Reusable action for configuring an RSS4kV6 
			RSS_discovery.Configure_discovery(selenium, VAR_RSSDeviceName, VAR_RSSDeviceHostIP, VAR_ProgPrefix, VAR_VRRnumber_PinProtected, VAR_masterAuto, VAR_masterVOD);
			//Reusable action for placing a call on RSS encoder from Endpoint
			PlaceCall_endpoint.PlaceCall_RSS4kv6(selenium, VAR_RSSDeviceHostIP, VAR_VRRnumber_PinProtected, VAR_endPointIP);
			//Select the VCC admin portal window
			selenium.selectWindow("null");
			//Click on POlycom RSS Discovery link
			selenium.click("link=Polycom RSS Discovery");
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Check if the call has been discovered 
			for (int y = 0;y<=6;y++)
			{
				if((selenium.getText(EnvObjectMap_Rep.lbl_discoveredCalls)).equals("n/a"))
				{
			selenium.click("link=Polycom RSS Discovery");
			//wait 
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			utilityFunction.waitForChangesToReflect();
			}
			}
			//Click on the discovered calls link
			selenium.click(EnvObjectMap_Rep.lnk_discoveredCalls);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			String Var_LiveProgramName = "";
			for (int i =4;i<=10;i++)
			{
				if(selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_DiscoveredProgram, i)).startsWith(VAR_ProgPrefix))
					{
					//check if the program is created with the program prefix				
					Var_LiveProgramName = selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_DiscoveredProgram, i));
					selenium.click("link="+Var_LiveProgramName);
					selenium.waitForPageToLoad(VAR_MED_WAIT);
					boolean pinStatus;
					if(selenium.getText("//div[11]/div[4]/div[3]/div[2]").equals("Yes"))
					{
						pinStatus = true;
						assertTrue("CVP_Automated_RSSdisc4k_PinProtected","Verify that automated file broadcast program is created for a pin-protected live call.",date,pinStatus);
					}
					break;
					}			
			}
			//Click on the domain name link to launch the viewer portal
			selenium.click("link=" + VAR_DomClassic);			
			//wait
			utilityFunction.waitForChangesToReflect();
			//Select the viewer portal
			selenium.selectWindow("Qumu Program Browser Home");
			//wait
			utilityFunction.waitForChangesToReflect();
			//Click on home tab
			selenium.click(EnvObjectMap_Rep.tab_HomeCVP);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Click on the live program link
			selenium.click("link="+ Var_LiveProgramName);
			//wait for page load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Type the pincode
			selenium.type(EnvObjectMap_Rep.txt_privateCode, VAR_VRRPin_PinProtected);
			assertTrue("CVP_Automated_RSSdisc4k_PinProtected","Verify that Pin is asked on viewer portal on plying the automated file broadcast program, created for a pin-protected call.",date,selenium.isElementPresent(EnvObjectMap_Rep.txt_privateCode));
			//Click on the submit button
			selenium.click(EnvObjectMap_Rep.btn_privateCodeSub);
			//Wait for the page to load
			selenium.waitForPageToLoad(VAR_MED_WAIT);			
			//Click on the live stream
			selenium.click("link="+ Var_LiveProgramName+"hi");
			//wait
			utilityFunction.waitForChangesToReflect();
 			//Select the player window
			selenium.selectWindow("Qumu Program Player");
			//wait
			utilityFunction.waitForChangesToReflect();
			//Path to store the screenshot of the player window
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
			selenium.captureScreenshot(screenShot_locPath); 
			//Get the html source
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
			assertTrue("CVP_Automated_RSSdisc4k_PinProtected","Verify that asx file is generated successfully for the discovered automated file broadcast program.",date,utilityFunction.assertTextContains(htmlsource2, Var_LiveProgramName + "hi"));
			assertTrue("CVP_Automated_RSSdisc4k_PinProtected","Verify that mms protocol is displayed in asx file for the discovered automated file broadcast program.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
			selenium.close();
			selenium.selectWindow(Var_LiveProgramName);
			selenium.close();
			selenium.selectWindow("null");
			PlaceCall_endpoint.HangCall_RSS4kv6(selenium, VAR_endPointIP);
			selenium.selectWindow("null");
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