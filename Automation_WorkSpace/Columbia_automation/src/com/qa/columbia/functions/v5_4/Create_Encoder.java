/*
 * This method is used to Create Encoders in the Application.
 * */
package com.qa.columbia.functions.v5_4;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.Selenium;
import java.util.Calendar;
import java.util.Date;


public class Create_Encoder 
{
	//Create RS2k encoder
	public static void create_RSSv5enc(Selenium sel,String str_scriptName, String str_encName, String str_hostIP, String str_version, String str_userName, String str_password, String encProfileName, String str_bitRate) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();		
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		//Date date=Calendar.getInstance().getTime();
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		//Click on Resource menu
		sel.click(EnvObjectMap_Rep.LNK_Resources);		
		//Click on Encoder menu		
		sel.click(EnvObjectMap_Rep.LNK_Encoders);		
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
		//Click on Add button
		sel.click(EnvObjectMap_Rep.Btn_Add_Encoder);
		//Select RSS2000 from the listbox
		sel.addSelection(EnvObjectMap_Rep.lst_rss2k, "label=RSS 2000 Encoder");
		//Select RSS 2000 encoder
		sel.click(EnvObjectMap_Rep.lnk_rss2k);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
		//Provide the encoder name
		sel.type(EnvObjectMap_Rep.txt_rss2kEncName, str_encName);
		//Provide the host ip
		sel.type(EnvObjectMap_Rep.txt_rss2kHostIP, str_hostIP);
		//Provide the username
		sel.type(EnvObjectMap_Rep.txt_rss2kEncUserName, str_userName);
		//Select the RSS version
		sel.select(EnvObjectMap_Rep.drp_rss2kVerSelect, "label="+ str_version);
		//Click on Add button to add encoder profile
		sel.click(EnvObjectMap_Rep.btn_rss2kEncProfile);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
		//Provide the Encoder Profile Name
		sel.type(EnvObjectMap_Rep.txt_rss2kProfName, encProfileName);
		//Select the VideoSize
		sel.select(EnvObjectMap_Rep.drp_rss2kProfVideoSize, EnvObjectMap_Rep.drp_rss2kProfVideoSizeValue);
		//Provide the bit rate
		sel.type(EnvObjectMap_Rep.txt_rss2kProfBitRate, str_bitRate);
		//Check the H239 content
		sel.click(EnvObjectMap_Rep.chk_rss2kProfH239);
		//Save the Encoder Profile
		sel.click(EnvObjectMap_Rep.btn_rss2kProfSave);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
		//Provide the password
		sel.type(EnvObjectMap_Rep.txt_rss2kPassword, str_password);
		//Confirm the password
		sel.type(EnvObjectMap_Rep.txt_rss2kConfirmPassword, str_password);
		//Save the encoder
		sel.click(EnvObjectMap_Rep.btn_rss2kSave);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
	//	assertTrue(str_scriptName,"Verify that "+str_version+" encoder is created successfully.",date,sel.isTextPresent(str_encName));
	}
//Create RSS4kV6 encoder
public static void create_RSSv6enc(Selenium sel,String str_scriptName, String str_encName, String str_hostIP, String str_userName, String str_password, String str_maxStreams, String encProfileName) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	//Date date=Calendar.getInstance().getTime();
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	//Click on Resource menu
	sel.click(EnvObjectMap_Rep.LNK_Resources);		
	//Click on Encoder menu		
	sel.click(EnvObjectMap_Rep.LNK_Encoders);		
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Click on Add button
	sel.click(EnvObjectMap_Rep.Btn_Add_Encoder);
	//select the RSS 4000 Encoder option
	sel.addSelection(EnvObjectMap_Rep.select_EncoderType, "label=RSS 4000 Encoder");
	sel.click(EnvObjectMap_Rep.rss_v6Encoder);
	//Wait for the page to load
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Type the encoder name
	sel.type(EnvObjectMap_Rep.txt_nameRSSv6, str_encName);
	//Type the host IP
	sel.type(EnvObjectMap_Rep.txt_hostRSSv6, str_hostIP);
	//Type the encoder username
	sel.type(EnvObjectMap_Rep.txt_userRSSv6, str_userName);
	//Enable USE SSL
	sel.click(EnvObjectMap_Rep.chk_useSSLv6);
	//Type the number of live streams
	sel.type(EnvObjectMap_Rep.txt_maxStreamRSSv6, str_maxStreams);
	//Click on Add profile button
	sel.click(EnvObjectMap_Rep.btn_profileRSSv6);
	//Wait for the page to load
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Type the encoder profile name
	sel.type(EnvObjectMap_Rep.txt_profileNameRSSv6, encProfileName);
	//Click on Save profile name
	sel.click(EnvObjectMap_Rep.btn_saveProfileRSSv6);
	//Wait for the page to load
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Type the encoder password
	sel.type(EnvObjectMap_Rep.txt_passwordRSSv6, str_password);
	//Confirm the encoder password
	sel.type(EnvObjectMap_Rep.txt_confirmPasswordRSSv6, str_password);
	//Click on Save encoder button
	sel.click(EnvObjectMap_Rep.btn_saveRSSv6);
	//Wait for the page to load
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//assertTrue(str_scriptName,"Verify that RSS4000V6 encoder is created successfully.",date,sel.isTextPresent(str_encName));
}
//Create windows media encoder
public static void create_WME(Selenium sel,String str_WMEName, String str_WMEhost, String str_WMEcommPort, String str_WMEdocRoot,String str_WMEProName, String str_WMEPort,String str_WMEsavedFilepath) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	//Date date=Calendar.getInstance().getTime();
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String Var_WMEProf_VideoSize = utilityFunction.GetValue(str_path ,"Var_WMEProf_VideoSize");
	String Var_WMEProf_BitRate = utilityFunction.GetValue(str_path ,"Var_WMEProf_BitRate");
	//String Var_WME_Host = utilityFunction.GetValue(str_path ,"Var_WME_Host");
    
	//Fetching values for local Variables from XMl file
	String local_path ="local_Variables.xml";
	String Var_Select_WME = utilityFunction.GetValue(local_path ,"Var_Select_WME");
	
	//Click on Resources Menu
	sel.click(EnvObjectMap_Rep.LNK_Resources);		
	//Click on Encoder menu		
	sel.click(EnvObjectMap_Rep.LNK_Encoders);		
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	//Click on Add button
	sel.click(EnvObjectMap_Rep.Btn_Add_Encoder);
	//Select the Windows Media Encoder from the panel
	sel.addSelection(EnvObjectMap_Rep.SelectType_Enc, Var_Select_WME);
	//Click on Windows Media Encoder
	sel.click(EnvObjectMap_Rep.LNK_WME);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Provide the WME name
	sel.type(EnvObjectMap_Rep.TXT_WME_Name, str_WMEName);
	//Provide the Host name
	sel.type(EnvObjectMap_Rep.TXT_WME_Host, str_WMEhost);
	//Provide the Communication Port
	sel.type(EnvObjectMap_Rep.TXT_WME_CommPort, str_WMEcommPort);
	//Provide the document root 
	sel.type(EnvObjectMap_Rep.TXT_WME_DocRoot, str_WMEdocRoot);
	//Click on Add button to add the encoder profile
	sel.click(EnvObjectMap_Rep.Btn_AddWMEProfile);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	for (int second = 0;; second++) {
		if (second >= 300) break;
		try { if (sel.isVisible(EnvObjectMap_Rep.TXT_WMEProf_Name)) break;
		} catch (Exception e) {}
		Thread.sleep(1000);
	}
	//Provide the encoder profile name
	sel.type(EnvObjectMap_Rep.TXT_WMEProf_Name, str_WMEProName);
	//Choose the appropriate Video Size 
	sel.select(EnvObjectMap_Rep.Drp_WMEProf_VideoSize, Var_WMEProf_VideoSize);
	//Provide the Video bitrate
	sel.type(EnvObjectMap_Rep.TXT_WMEProf_Bitrate,Var_WMEProf_BitRate);
	//External URL of the encoder
	String URL = "http://" + str_WMEhost + ":" + str_WMEPort;
	//Provide the Encoder URL
	sel.type(EnvObjectMap_Rep.TXT_WMEProf_ExtURL, URL);
	//Provide the Encoder Port 
	sel.type(EnvObjectMap_Rep.TXT_WMEProf_Port, str_WMEPort);
	//Choose the checkbox to select the WME profile settings from the saved .wme file
	sel.click(EnvObjectMap_Rep.Radio_WMEProf_wmeFile);
	//Provide the path of the saved .wme file 
	sel.type(EnvObjectMap_Rep.TXT_WMEProf_Path, str_WMEsavedFilepath);
	//Save the Encoder Profile
	sel.click(EnvObjectMap_Rep.Btn_Save_WMEProf);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	//Save the WME
	sel.click(EnvObjectMap_Rep.Btn_Save_WME);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	//verifies the checkpoint for successful WME Creation
	//assertTrue("Columbia_LiveProgramVerification","Verify that WME with profile is created successfully.",date,sel.isTextPresent(str_WMEName));	
}	
	
}
