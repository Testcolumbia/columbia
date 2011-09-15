package com.qa.columbia.functions.v5_3;

import java.text.MessageFormat;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v5_3.*;
/*import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;*/


public class RSS_discovery {
	
	public static void Add_device(Selenium sel, String str_rssDeviceName, String str_hostIP, String str_userName, String str_password) throws Exception {
		//Click on Resource menu
		sel.click(EnvObjectMap_Rep.LNK_Resources);
		//Click on Polycom RSS Devices menu
		sel.click(EnvObjectMap_Rep.lnk_PolycomRSSDevices);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Click on Add button to add an RSS device
		sel.click(EnvObjectMap_Rep.btn_addRSSDevice);
		//Select the RSS 4000 from the select box 
		sel.addSelection(EnvObjectMap_Rep.selectRSSDevice, "label=RSS 4000");
		//Click on RSS4000
		sel.click(EnvObjectMap_Rep.selectRSS4kV6);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Type the device name
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceName, str_rssDeviceName);
		//Type the Host IP
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceHostIP, str_hostIP);
		//Type the username
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceUsername, str_userName);
		//Type the password
		sel.type(EnvObjectMap_Rep.txt_rssV6DevicePassword, str_password);
		//Type teh confirm password
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceConfirmPassword, str_password);
		//sel.click("liveDiscoveryEnabled");
		//sel.click("archiveDiscoveryEnabled");
		//Save the RSS device
		sel.click(EnvObjectMap_Rep.btn_saveRSSv6Device);
		//Wait for the page to load
		sel.waitForPageToLoad("50000");
	}
	
	public static void Add_RSS2kdevice(Selenium sel, String str_rssDeviceName, String str_hostIP, String str_userName, String str_password) throws Exception {
		//Click on Resource menu
		sel.click(EnvObjectMap_Rep.LNK_Resources);
		//Click on Polycom RSS Devices menu
		sel.click(EnvObjectMap_Rep.lnk_PolycomRSSDevices);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Click on Add button to add an RSS device
		sel.click(EnvObjectMap_Rep.btn_addRSSDevice);
		//Select the RSS 4000 from the select box 
		sel.addSelection(EnvObjectMap_Rep.selectRSSDevice,  "label=RSS 2000/RSS 4000 v.4");
		//Click on RSS4000
		sel.click("rss2k_src_device");
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Type the device name
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceName, str_rssDeviceName);
		//Type the Host IP
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceHostIP, str_hostIP);
		//Type the username
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceUsername, str_userName);
		//Type the password
		sel.type(EnvObjectMap_Rep.txt_rssV6DevicePassword, str_password);
		//Type teh confirm password
		sel.type(EnvObjectMap_Rep.txt_rssV6DeviceConfirmPassword, str_password);
		//sel.click("liveDiscoveryEnabled");
		//sel.click("archiveDiscoveryEnabled");
		//Save the RSS device
		sel.click(EnvObjectMap_Rep.btn_saveRSSv6Device);
		//Wait for the page to load
		sel.waitForPageToLoad("50000");
	}
	
	public static void Configure_discovery(Selenium sel, String str_rssDeviceName, String str_hostIP,String str_prefixProgramName, String str_VRRnumber, String str_automatedMaster, String str_ondemandMaster) throws Exception {
		//Click on Programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Click on Polycom RSS Discovery 
		sel.click("link=Polycom RSS Discovery");
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Click on the add button
		sel.click(EnvObjectMap_Rep.btn_configureRSSDEvice);
		//Select the pre-requisite device
		sel.addSelection("selectselectTypeDialogrssSourceDevices", "label=RSS 4000: " +str_rssDeviceName+", host: "+str_hostIP);
		//Click on the pre-requisite device
		sel.click(EnvObjectMap_Rep.select_RSSDiscovery);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Type the prorgam prefix
		sel.type(EnvObjectMap_Rep.txt_prograPrefixDiscovery, str_prefixProgramName);
		//Type the content prefix
		sel.type(EnvObjectMap_Rep.txt_contentPrefixDiscovery, str_prefixProgramName);
		//Check the checkbox "Make the VRR owner the publisher of the program"
		sel.click(EnvObjectMap_Rep.chk_VRRownerPublisher);
		//Check the checkbox "Auto publish non-PIN Protected Calls on portal"
		sel.click(EnvObjectMap_Rep.chk_autoPublishNonPinLive);
		//Check the checkbox "Auto publish PIN Protected Calls on portal"
		sel.click(EnvObjectMap_Rep.chk_autoPublishPinLive);
		//Check the checkbox "Create program for non-PIN Protected Calls"
		sel.click(EnvObjectMap_Rep.chk_createVODNonPin);
		//Check the checkbox "Auto publish non-PIN Protected Calls on portal"
		sel.click(EnvObjectMap_Rep.chk_autoPublishNonPinVOD);
		//Check the checkbox "Create program for PIN Protected Calls"
		sel.click(EnvObjectMap_Rep.chk_createVODPin);
		//Check the checkbox "Auto publish PIN Protected Calls on portal"
		sel.click(EnvObjectMap_Rep.chk_autoPublishPinVOD);
		//sel.click("alwaysIngest");
		//Click the button "Load the list of available Virtual Recording Rooms"
		sel.click(EnvObjectMap_Rep.btn_LoadVRR);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		for (int i = 2;i<=200;i++)
		{
			if (str_VRRnumber.equals(sel.getText(MessageFormat.format(EnvObjectMap_Rep.lbl_rssV6VRRName, i))))
			{
				//Click on the pre-requisite VRR 
				sel.click(MessageFormat.format(EnvObjectMap_Rep.lnk_rssV6VRRname, i));
				//Wait for the page to load
				sel.waitForPageToLoad("60000");
				break;
			}
		}
		//Select the automated master program as template
		sel.select(EnvObjectMap_Rep.drp_templateLive, str_automatedMaster);
		//Select the On-demand master program as template
		sel.select(EnvObjectMap_Rep.drp_templateArchive, str_ondemandMaster);
		//Click on the Submit button
		sel.click(EnvObjectMap_Rep.btn_submitDiscovery);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Click on the Submit button
		sel.click(EnvObjectMap_Rep.btn_submitDiscovery);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
	}
	
	public static void Configure_RSS2kdiscovery(Selenium sel, String str_rssDeviceName, String str_hostIP,String str_prefixProgramName, String str_automatedMaster, String str_ondemandMaster) throws Exception {
		//Click on Programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Click on Polycom RSS Discovery 
		sel.click("link=Polycom RSS Discovery");
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		sel.click("//button[@type='button']");
		sel.addSelection("selectselectTypeDialogrssSourceDevices", "label=RSS 2000: "+str_rssDeviceName+", host: "+str_hostIP);
		//sel.addSelection("selectselectTypeDialogrssSourceDevices", "label=RSS 2000: RSS2kV6_01, host: 10.1.199.235");
		sel.click("//option[1]");
		//sel.click("rss2k-config-flow&rssSourceDeviceId=rss2k_src_device:3");
		sel.waitForPageToLoad("30000");
		sel.type("programPrefix", str_prefixProgramName);
		sel.type("contentPrefix", str_prefixProgramName);
		sel.click("useDefaultLiveTemplate");
		sel.click("useDefaultRecordedTemplate");
		sel.click("listNonPINLiveCalls");
		sel.click("listPINLiveCalls");
		sel.click("createNonPINRecordedCalls");
		sel.click("listNonPINRecordedCalls");
		sel.click("createPINRecordedCalls");
		sel.click("listPINRecordedCalls");
		sel.click("_eventId_submit");
		sel.waitForPageToLoad("30000");	
	}
	}