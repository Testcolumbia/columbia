/*
 * This method is used to Create Storage in the Application.
 * @param sel selenium object that runs the selenium commands
 * @param str_StorageName is used to provide storage name.
 * @param str_StorageHost is used to provide the HTTP Host Name in the Browser.
 * @param str_mountPoint is used to provide the mount point (Virtual Directory need to be created on IIS) name in the Browser. 
 * @throws Exception 
*/

package com.qa.columbia.functions.v5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Create_storage extends TesterAsserter{
	
	public static void create_storage(Selenium sel, String str_StorageName, String str_StorageHost, String str_mountPoint) throws Exception	{
		
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		Date date=Calendar.getInstance().getTime();
		//Fetching values for local Variables from XMl file
		String local_path ="local_Variables.xml";
		String LBL_LocalStorage = utilityFunction.GetValue(local_path ,"LBL_LocalStorage");
		String LBL_HTTPAPStorage = utilityFunction.GetValue(local_path ,"LBL_HTTPAPStorage");
		
		//Click on Resources menu.
		sel.click(EnvObjectMap_Rep.LNK_Resources);			
		//Click on Storage link.
		sel.click(EnvObjectMap_Rep.LNK_Storage);		
		// Wait for the page to load
		sel.waitForPageToLoad(VAR_MAX_WAIT);		
		//Click on Add button 
		sel.click(EnvObjectMap_Rep.BTN_AddStorage);		
		//Select the Local Storage on Select Type popup window.		
		sel.addSelection(EnvObjectMap_Rep.SelectType_AddStorage, LBL_LocalStorage);		
		//Click on Local storage link in the Select Type popup window.
		sel.click(EnvObjectMap_Rep.LNK_LocalStorage);		
		// Wait for the page to load
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.TXT_StorageName, 300);
		//Provide the storage name.
		sel.type(EnvObjectMap_Rep.TXT_StorageName, str_StorageName);
		//Storage Path
		String storage_Path = "\\\\" + str_StorageHost + "\\" + str_StorageName;
		//Provide the storage path.
		sel.type(EnvObjectMap_Rep.TXT_StoragePath, storage_Path);		
		//Click on Add button to add the "Download" access point.
		sel.click(EnvObjectMap_Rep.BTN_AddAPStorage);		
		//Select the HTTP Access Point on Select Type popup window. 		
		sel.addSelection(EnvObjectMap_Rep.SelectType_AddAPStorage, LBL_HTTPAPStorage);		
		//Click on Click on HTTP Access Pint link in the Select Type popup window.
		sel.click(EnvObjectMap_Rep.LNK_HTTP_AP_Storage);		
		// Wait for the page to load
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.TXT_NameMountPoint_AP_Storage, 300);		
		//Provide the Access point name.
		sel.type(EnvObjectMap_Rep.TXT_NameAP_Storage, LBL_HTTPAPStorage);		
		//Provide the Host name.
		sel.type(EnvObjectMap_Rep.TXT_NameHOST_AP_Storage, str_StorageHost);		
		//Provide the Mount Point name.
		sel.type(EnvObjectMap_Rep.TXT_NameMountPoint_AP_Storage, str_mountPoint);		
		//Check the Select All Roles checkbox
		sel.click(EnvObjectMap_Rep.CHK_AllRoles_APStorage);		
		//Click on "Save" button to save the access point.
		sel.click(EnvObjectMap_Rep.BTN_SaveAP_Storage);		
		// Wait for the page to load
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.BTN_AddAPStorage, 300);	
		//Click on "Save" button to save the storage.
		sel.click(EnvObjectMap_Rep.BTN_SaveStorage);		
		// Wait for the page to load
		utilityFunction.waitForElementToVisible(sel, "link="+str_StorageName, 300);
		//Verify that storage is created successfully.
		assertTrue("","Verify that storage "+str_StorageName+" is created successfully.",date,sel.isTextPresent(str_StorageName));		
	}
	
}


