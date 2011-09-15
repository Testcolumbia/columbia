/**
 * This function is used to create Encoder.
 */
package com.qa.columbia.functions.v6_0;

import com.qa.columbia.executor.TesterAsserter;

import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Create_Encoder  extends TesterAsserter
{

	//Reusable function to create WME encoder
	public  static void Encoder_WME(Selenium sel,String str_WMEName, String str_WMEhost, String str_WMEcommPort, String str_WMEdocRoot,String str_WMEProName, String str_WMEPort,String str_WMEsavedFilepath)throws Exception
	{
		
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String global_path ="Global_variables.xml";
		
		//wait
		String VAR_MED_WAIT = utilityFunction.GetValue(global_path ,"VAR_MED_WAIT");
		
		String VAR_MAX_WAIT = utilityFunction.GetValue(global_path ,"VAR_MED_WAIT");
		
		//Fetching encoder name from the global file
		String Var_Select_WME= utilityFunction.GetValue(global_path ,"Var_Select_WME");
		
		String Var_WMEProf_VideoSize = utilityFunction.GetValue(global_path ,"Var_WMEProf_VideoSize");
		
		String Var_WMEProf_BitRate = utilityFunction.GetValue(global_path ,"Var_WMEProf_BitRate");
		
		//Click on Resources Menu
		sel.click(EnvObjectMap_Rep.Lnk_resources);	
		
		//Click on Encoder menu		
		sel.click(EnvObjectMap_Rep.Lnk_Encoders);	
		
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Click on Add button
		sel.click(EnvObjectMap_Rep.Btn_Add_Encoder);
		
		//Select the Windows Media Encoder from the panel
		sel.addSelection(EnvObjectMap_Rep.SelectType_Enc, Var_Select_WME);
		
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
		
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		//wait until object not found
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
		
		//Provide the Encoder outputPort 
		sel.type(EnvObjectMap_Rep.TXT_WMEProf_Port, str_WMEPort);
		
		//Choose the checkbox to select the WME profile settings from the saved .wme file
		sel.click(EnvObjectMap_Rep.Radio_WMEProf_wmeFile);
		
		//Provide the path of the saved .wme file name
		sel.type(EnvObjectMap_Rep.TXT_WMEProf_Path, str_WMEsavedFilepath);
		
		//Save the Encoder Profile
		sel.click(EnvObjectMap_Rep.Btn_Save_WMEProf);
		
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		//Save the WME
		sel.click(EnvObjectMap_Rep.Btn_Save_WME);
		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
	}
public static void create_RSSv5enc(Selenium sel, String str_encName, String str_hostIP, String str_version, String str_userName, String str_password, String encProfileName, String str_bitRate) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();		
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
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
	}
}
