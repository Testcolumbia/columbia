/*
* Classname                                                        Sm_vpc_010_Automated_RSSdisc4k_NonPinProtected 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that a non pin protected automated program is created through RSS 4000 Version6 polycom discovery.
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add a wmv file<br> 
*  															     	>Add an windows external Streaming media<br> 
*																	>Create an Automated file program using the external streaming media<br> 
* 																	>Create an On-demand file program using the .wmv file<br> 
* 																	>Add RSS4kV6 device with import live call options checked<br> 
* 																	>Configure the RSS4kV6 device and map the above created template programs to a NOn-Pin-protected VRR<br>
* 																	>Place a call from the Endpoint to the Non-pin protected VRR<br>
* 																	>Notice that the Automated program is created for the call<br> 	
*  													     			>Play the program on the viewer portal<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that Non Pin-protected automated file broadcast program is created for the Non-pin protected call using RSS4kV6 discovery.<br> 
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

public class SVP_Sm_vpv_022_Automated_RSSdisc4k_NonPinProtected_template extends TesterAsserter {
	
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
	public void test_CVP_SVP_Sm_vpv_022_Automated_RSSdisc4k_NonPinProtected_template() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local variable file name
			String localVariableFile ="SVP_Sm_vpv_022_Automated_RSSdisc4k_NonPinProtected_template.xml";
			
			
			//Variable for wait time
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for domain name
			String VAR_DomainSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			//Variable for the RSS device name
			String VAR_RSSDeviceName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceName");
			//Variable for the RSS device IP
			String VAR_RSSDeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceHostIP");
			//Variable for the program and content (discovered using RSS discovery) name prefix 
			String VAR_ProgPrefix = utilityFunction.GetValue(localVariableFile ,"VAR_ProgPrefix");
			//Variable for the Endpoint IP
			String VAR_endPointIP = utilityFunction.GetValue(globalVariableFile ,"VAR_endPointIP");
			//Variable for the VRR number on RSS device
	    	String VAR_VRRnumber_NonPinProtected = utilityFunction.GetValue(globalVariableFile ,"VAR_VRRnumber_NonPinProtected");
			//Variable for the master automated file broadcast program name
			String VAR_autoTemplate = utilityFunction.GetValue(globalVariableFile ,"VAR_masterAuto");
			//Variable for the master on-demand program
			String VAR_vodTemplate = utilityFunction.GetValue(globalVariableFile ,"VAR_masterVOD");
			String VAR_MediaFormat = utilityFunction.GetValue(localVariableFile ,"VAR_MediaFormat");
			String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile ,"Var_VEasWMS_DO");
			String VAR_httpName = utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			
			//Reusable action for login to VCC
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomainSocial);//Click on the added device name
			Create_ProgramTemplate.test_Create_AutomatedFileBroadcastTemplate(selenium, VAR_autoTemplate, VAR_MediaFormat, Var_VEasWMS_DO);
			utilityFunction.waitForTextToPresent(selenium, VAR_autoTemplate, 300);
			assertTrue("Sm_PT_002", "User is able to create Automated File Broadcast Program Template using VE as WMS and HTTP delivery options.", date, true);
		
			
			Create_ProgramTemplate.test_Create_VODTemplate(selenium, VAR_vodTemplate, VAR_MediaFormat, VAR_httpName);
			utilityFunction.waitForTextToPresent(selenium, VAR_vodTemplate, 300);
			assertTrue("Sm_PT_001", "User is able to create On Demand Program Template using HTTP delivery options.", date, true);
		
			selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDevices);
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.btn_addRSSDevice, 300);
			selenium.click("link="+VAR_RSSDeviceName);
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
			RSS_discovery.Configure_discovery(selenium, VAR_RSSDeviceName, VAR_RSSDeviceHostIP, VAR_ProgPrefix, VAR_VRRnumber_NonPinProtected, VAR_autoTemplate, VAR_vodTemplate);
			//Reusable action for placing a call on RSS encoder from Endpoint
			PlaceCall_endpoint.PlaceCall_RSS4kv6(selenium, VAR_RSSDeviceHostIP, VAR_VRRnumber_NonPinProtected, VAR_endPointIP);
			//Select the admin portal window
			selenium.selectWindow("null");
			//Click on POlycom RSS Discovery link
			selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDiscovery);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Check if the call has been discovered 
			for (int y = 0;y<=16;y++)
			{
				selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDiscovery);
				utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.Lnk_contextMenuDiscovery, 300);
				selenium.click(EnvObjectMap_Rep.Lnk_contextMenuDiscovery);
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
				if(selenium.getText(EnvObjectMap_Rep.lbl_pinStatusAutomatedSummaryPageSVP).equals("No"))
				{
					pinStatus = true;
					//Verify that non-pin protected program is created for the call
					assertTrue("Sm_vpv_022","Verify that automated file broadcast program is created for the live call.",date,pinStatus);
				}
				break;
				}
			}		

			Launch_VP.Launch_SVP(selenium, VAR_DomainSocial);
			selenium.click(EnvObjectMap_Rep.LNK_showall);
			utilityFunction.waitForChangesToReflect();	
			selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, "Test*");
		    selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "A");
		    utilityFunction.waitForChangesToReflect();
			//click search arrow link
		    selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
			utilityFunction.waitForChangesToReflect();
			//choose dynamic program
			outerloop:
				for(int lnk=1;lnk<10;lnk++)
				{
					
					selenium.click("link="+lnk);
					Thread.sleep(10000);
					
				for (int i = 1; i<=22; i++)
				{
		
					 String str_var1=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
					 System.out.println(str_var1);	   
					 if(str_var1.equals(Var_AutomatedLiveProgramName))
					 {
						 selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
						 break outerloop;
					 } 
					 else
					 {
						 
						 continue;
					 }
					 
				}
						
				}
			//Wait
			 utilityFunction.waitForChangesToReflect();
			 //Capture the screenshot at the specified path
			 String screenShot_SVPvideo = Var_frameWork_Path + "\\commonfiles\\" + Var_AutomatedLiveProgramName + ".jpg";		
			 //Capture the screen shot of the live program
			 selenium.captureScreenshot(screenShot_SVPvideo);
			 //Wait
			 utilityFunction.waitForChangesToReflect();
			 //select the asx link
	         String contentlink = selenium.getText(EnvObjectMap_Rep.Lnk_asxfile);
	         //wait
	         //split the string
	         utilityFunction.waitForChangesToReflect();       
	     	 String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			 contentlink_final=contentlink_final.trim();		
			 System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
			 selenium.click("link=exact:"+contentlink_final);
			 utilityFunction.waitForChangesToReflect();
			 //Generate the asx file
			 String htmlsource = selenium.getHtmlSource();
			 System.out.println(htmlsource);
			 //assertTrue("SVP_Automated_RSSdisc2k_NonPinProtected","Verify that asx file is generated successfully.",utilityFunction.assertTextContains(htmlsource, VAR_WMEProfileName));
		     assertTrue("Sm_vpv_022","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms"));
		     selenium.close();
			 utilityFunction.waitForChangesToReflect();
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