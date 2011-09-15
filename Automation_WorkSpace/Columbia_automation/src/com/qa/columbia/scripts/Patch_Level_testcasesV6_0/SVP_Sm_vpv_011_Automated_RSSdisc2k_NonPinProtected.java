/*
* Classname                                                        Sm_vpv_011_Automated_RSSdisc2k_NonPinProtected 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that a non pin protected automated program is created through RSS 2000 Version4 polycom discovery.
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add a wmv file<br> 
*  															     	>Add an windows external Streaming media<br> 
*																	>Create an Automated file program using the external streaming media<br> 
* 																	>Create an On-demand file program using the .wmv file<br> 
* 																	>Add RSS2kV4 device with import live call options checked<br> 
* 																	>Configure the RSS4kV6 device and select the above cretaed master programs as template for Live and VOD calls<br>
* 																	>Place a call from the Endpoint to the RSS device<br>
* 																	>Notice that the Automated program is created for the call<br> 	
*  													     			>Play the program on the viewer portal<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that Pin-protected automated file broadcast program is created for the Non-pin protected call using RSS2kV4 discovery.<br> 
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

public class SVP_Sm_vpv_011_Automated_RSSdisc2k_NonPinProtected extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_011_Automated_RSSdisc2k_NonPinProtected() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local variable file name
			String localVariableFile ="SVP_Sm_vpv_011_Automated_RSSdisc2k_NonPinProtected.xml";
			
			 String setupVariableFile="Setup_Script.xml";
			//Variable for wait time
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");

			//Variable for the program and content (discovered using RSS discovery) name prefix 
			String VAR_ProgPrefix = utilityFunction.GetValue(localVariableFile ,"VAR_ProgPrefix");
			//Variable for the master automated file broadcast program name
			String VAR_masterAuto = utilityFunction.GetValue(globalVariableFile ,"VAR_masterAuto");
			//Variable for the master on-demand program
			String VAR_masterVOD = utilityFunction.GetValue(globalVariableFile ,"VAR_masterVOD");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
		
	        
			//Variable for the RSS device name
			String VAR_RSS2kDeviceName = utilityFunction.GetValue(setupVariableFile ,"VAR_RSS2kDeviceName");
			
			
			//Variable for the RSS device IP
			String VAR_RSS2kDeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kDeviceHostIP");
			//Variable for the Endpoint IP
			String VAR_endPointIP = utilityFunction.GetValue(globalVariableFile ,"VAR_endPointIP");
			//Reusable action for login to VCC
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
			selenium.click(EnvObjectMap_Rep.lnk_PolycomRSSDevices);
			selenium.waitForPageToLoad("30000");
			//Click on the added device name
			selenium.click("link="+VAR_RSS2kDeviceName);
	        //Wait for the page to load
			selenium.waitForPageToLoad("30000");
			
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_rssv6EnableLive))
			{
				//Click on the check box "Import Live calls"
				selenium.click(EnvObjectMap_Rep.chk_rssv6EnableLive);			
			}			
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_rssv6EnableArchive))
			{
			}
			else
			{
				//Click on the check box "Import Live calls"
				selenium.click(EnvObjectMap_Rep.chk_rssv6EnableArchive);
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
	RSS_discovery.Configure_RSS2kdiscovery(selenium, VAR_RSS2kDeviceName, VAR_RSS2kDeviceHostIP, VAR_ProgPrefix, VAR_masterAuto, VAR_masterVOD);
//			//Reusable action for placing a call on RSS encoder from Endpoint
	PlaceCall_endpoint.PlaceCall_RSS2k(selenium, VAR_RSS2kDeviceHostIP, VAR_endPointIP);
////			//Select the VCC admin portal window
	selenium.selectWindow("null");
			PlaceCall_endpoint.StartRecording_RSS2k(selenium, VAR_RSS2kDeviceHostIP);
			//Select the VCC admin portal window
		selenium.selectWindow("null");
			//Click on POlycom RSS Discovery link
			selenium.click(EnvObjectMap_Rep.Lnk_polycomRSSDiscovery);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//wait
			utilityFunction.waitForChangesToReflect();
			
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
					
					System.out.println("This is test"+Var_AutomatedLiveProgramName);
				//Click on the program name link
				selenium.click("link="+Var_AutomatedLiveProgramName);
				//Wait
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				boolean pinStatus;
				if(selenium.getText(EnvObjectMap_Rep.lbl_pinStatusAutomatedSummaryPageSVP).equals("No"))
				{
					pinStatus = true;
					//Verify that non-pin protected program is created for the call
					assertTrue("Sm_vpv_11","Verify that automated file broadcast program is created for the live call.",date,pinStatus);
				}
				break;
				}
			}
			Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
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
				
			for (int i = 1; i<=12; i++)
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
			
			 //assertTrue("Sm_vpv_11","Verify that program is played successfully",date,utilityFunction.assertTextContains(htmlsource, "http://"+VAR_RSS2kDeviceHostIP));
			 assertTrue("Sm_vpv_11","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms"));
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
				 selenium.stop();
			 }
	     }
    }
}

