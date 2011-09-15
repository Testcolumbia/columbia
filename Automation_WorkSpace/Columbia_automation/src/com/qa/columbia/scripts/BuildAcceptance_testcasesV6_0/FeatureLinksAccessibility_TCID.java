/*
* Classname                                                        featurelinksaccessibility 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
* 																	>System /User Management/Resources/Delivery/Programming/Reports feature links accessibility<br> 															
* 																	>Verify that the all the above links are accessible<br>																
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;


import java.util.Date;
import java.util.Calendar;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Login;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class FeatureLinksAccessibility_TCID extends TesterAsserter{
	
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
		}
		utilityFunction=null;
	}		
	
	
	
	public void testLinkAccessibility() throws Exception
	{
	      try
	        {
	    //Call to setUp function
	    setUp();
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";
		
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
		
		// Variable for Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
		
		//Variable for Waiting time
		String wait=utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		
		//Call to Login function as a AdminProtal
		Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
		
		//**************************System Link Accessibility********************************************************************************//

		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Messages page", date, selenium.isTextPresent("Hello Super User, Welcome to VCC 6.0"));
		selenium.click(EnvObjectMap_Rep.Lnk_domains);
		
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Domain page", date, selenium.isTextPresent("Domain"));

		selenium.click(EnvObjectMap_Rep.Lnk_systemResourceMapping);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate System Resources Mapping page", date, selenium.isTextPresent("System Resources Mapping"));

		selenium.click(EnvObjectMap_Rep.Lnk_componentConfiguration);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Component Configuration page", date, selenium.isTextPresent("Component Configuration"));

		selenium.click(EnvObjectMap_Rep.Lnk_emailclientConfiguration);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Email Client Settings page", date, selenium.isTextPresent("Email Client Settings"));

		selenium.click(EnvObjectMap_Rep.Lnk_emails);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Edit Email Templates Editor page", date, selenium.isTextPresent("Edit Email Templates Editor"));

		selenium.click(EnvObjectMap_Rep.Lnk_csslayout);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate CSS Layouts page", date, selenium.isTextPresent("CSS Layouts"));

		selenium.click(EnvObjectMap_Rep.Lnk_scheduledprocess);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Scheduled Processes page", date,selenium.isTextPresent("Scheduled Processes"));

		selenium.click(EnvObjectMap_Rep.Lnk_videoEdgeconfiguration);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Edit VideoEdge System Configuration page", date, selenium.isTextPresent("Edit VideoEdge System Configuration"));

		selenium.click(EnvObjectMap_Rep.Lnk_ingests);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Ingests page", date, selenium.isTextPresent("Ingests"));

		selenium.click(EnvObjectMap_Rep.Lnk_fileTransfers);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate File Transfers page", date, selenium.isTextPresent("File Transfers"));

		selenium.click(EnvObjectMap_Rep.Lnk_buildinfo);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Ensure that User is successfully able to navigate Build Info page", date, selenium.isTextPresent("About Qumu VCC"));
		
		//************************************User Management Link Accessibility*****************************************************************************//
		
		selenium.click(EnvObjectMap_Rep.Lnk_UserManagement);
		selenium.click(EnvObjectMap_Rep.Lnk_Realms);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Realms page", date,selenium.isTextPresent("Realms"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_Roles);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Roles page", date, selenium.isTextPresent("Roles"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_Users);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Users page", date, selenium.isTextPresent("Users"));
	
		selenium.click(EnvObjectMap_Rep.Lnk_Groups);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Groups page", date, selenium.isTextPresent("Groups"));
	
		selenium.click(EnvObjectMap_Rep.Lnk_AccessControl);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Access Control page", date, selenium.isTextPresent("Access Control"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_yourProfile);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Build profile page", date, selenium.isTextPresent("Edit Super User"));
		
		//*************************************Resources**********************************************************************************************************//
		

		selenium.click(EnvObjectMap_Rep.Lnk_resources);
		selenium.click(EnvObjectMap_Rep.Lnk_Storage);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage  page", date, selenium.isTextPresent("Storage"));

		selenium.click(EnvObjectMap_Rep.Lnk_Encoders);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Encoders page", date, selenium.isTextPresent("Encoders"));
	
		selenium.click(EnvObjectMap_Rep.Lnk_Studios);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Studios page", date, selenium.isTextPresent("Studios"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_TranscodingNodes);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Transcoding Nodes page", date, selenium.isTextPresent("Transcoding Nodes"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_PolycomRSSDevices);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Polycom RSS Devices page", date, selenium.isTextPresent("Polycom RSS Devices"));
		
		//***************************************Delivery*********************************************************************************************************//
		
		selenium.click(EnvObjectMap_Rep.Lnk_delivery);
		selenium.click(EnvObjectMap_Rep.Lnk_deliveryOptions);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage profile page", date, selenium.isTextPresent("Delivery Options"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_audiences);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Audiences page", date, selenium.isTextPresent("Audiences"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_locations);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Locations page", date, selenium.isTextPresent("Locations"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_GlobalProximityConfiguration);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Global Proximity Configuration page", date, selenium.isTextPresent("Global Proximity Configuration"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_DeliveryRoutes);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Delivery Routes page", date, selenium.isTextPresent("Delivery Routes"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_VideoEdgeProfiles);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Device Profile page", date, selenium.isTextPresent("Device Profile"));
	
		selenium.click(EnvObjectMap_Rep.Lnk_VideoEdgeUpgrade);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate VideoEdge Upgrade Packages page", date, selenium.isTextPresent("VideoNet Edge Upgrade Packages"));
		
       //*******************************************Programming******************************************************************************//
		
		selenium.click(EnvObjectMap_Rep.Lnk_programming);
		selenium.click(EnvObjectMap_Rep.Lnk_content);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage Content page", date, selenium.isTextPresent("Content"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_programs);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage Programs page", date, selenium.isTextPresent("Programs"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_channels);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage Channels page", date, selenium.isTextPresent("Channels"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_categories);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Storage Categories page", date, selenium.isTextPresent("Categories"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_programTemplates);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Program Templates page", date, selenium.isTextPresent("Program Templates"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_tags);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Tags page", date, selenium.isTextPresent("Tags"));
		
	
		selenium.click(EnvObjectMap_Rep.Lnk_featuredItems);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Featured Items page", date, selenium.isTextPresent("Featured Items"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_moderatecomments);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Moderate Comments page", date, selenium.isTextPresent("Moderate Comments"));
		
		if(selenium.isElementPresent(EnvObjectMap_Rep.Lnk_approveprogram))
		{
		selenium.click(EnvObjectMap_Rep.Lnk_approveprogram);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Approve Programs page", date, selenium.isTextPresent("Approve Programs"));
		}
		
		if(selenium.isElementPresent(EnvObjectMap_Rep.Lnk_skins))
		{
		selenium.click(EnvObjectMap_Rep.Lnk_skins);
		
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Skins page", date, selenium.isTextPresent("Skins"));
		}
		selenium.click(EnvObjectMap_Rep.Lnk_broadcastMonitor);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Broadcast Monitor page", date, selenium.isTextPresent("Broadcast Monitor"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_customprogramattributes);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Custom Program Attributes page", date, selenium.isTextPresent("Custom Program Attributes"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_polycomRSSDiscovery);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigatePolycom RSS Discovery Configurations page", date, selenium.isTextPresent("Polycom RSS Discovery Configurations"));
		
		selenium.click(EnvObjectMap_Rep.Lnk_calendardiscovery);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("TC_XXX", "Verify that User is successfully able to navigate Exchange Discovery Configuration List page", date, selenium.isTextPresent("Exchange Discovery Configuration List"));
		
		//**************************Reports**************************************************************************
		selenium.click(EnvObjectMap_Rep.Lnk_reporting);
		selenium.click(EnvObjectMap_Rep.Lnk_reports);
		//wait
		selenium.waitForPageToLoad(wait);
		assertTrue("testLinkAccessibility", "TC_XXX:-Verify that User is successfully able to navigate Reports page", date, selenium.isTextPresent("Reports"));
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
