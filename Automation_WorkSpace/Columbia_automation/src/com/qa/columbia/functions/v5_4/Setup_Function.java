package com.qa.columbia.functions.v5_4;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Setup_Function extends TesterAsserter {
	
public static void create_domainSocial(Selenium sel, String str_domainid, String str_domainname, String str_SiteURL) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		Date date=Calendar.getInstance().getTime();
		//Fetching values for local Variables from XMl file
		String local_path ="Setup_Script.xml";
		String VAR_Sto_Quota = utilityFunction.GetValue(local_path ,"VAR_Sto_Quota");
		String VAR_Sto_Threshold_Warn = utilityFunction.GetValue(local_path ,"VAR_Sto_Threshold_Warn");
		//Open the Domains page
		sel.click(EnvObjectMap_Rep.LNK_Domains);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);		
		//Click Add button
		sel.click(EnvObjectMap_Rep.BTN_AddDomain);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);		
		//provide Domain id
		sel.type(EnvObjectMap_Rep.LNK_DomainID,str_domainid);		
		//provide Domain name
		sel.type(EnvObjectMap_Rep.LNK_DomainName,str_domainname);		
		//Activate the Domain
		sel.click(EnvObjectMap_Rep.LNK_DomainActive);		
		//Save the domain
		sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
		//wait for loading the page
		utilityFunction.waitForTextToPresent(sel, "Domain Created", 300);		
		//Checkpoint for the newly created domain
		assertTrue("","Verify that domain is successfully created",date,sel.isTextPresent("Domain Created"));
		//Provide the Site URL
		sel.type(EnvObjectMap_Rep.TXT_SiteURL, str_SiteURL);		
		//Provide the Storage threshold quota
		sel.type(EnvObjectMap_Rep.TXT_Storage_Quota, VAR_Sto_Quota);		
		//Provide the Storage threshold warning percentage
		sel.type(EnvObjectMap_Rep.TXT_Storage_Threshold,VAR_Sto_Threshold_Warn);		
		//Check the checkbox to Use the social Viewer Portal
		sel.click(EnvObjectMap_Rep.CHK_Domain_Conf_SVP);		
		//Click on Save button
		sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
		//wait for loading the page
		utilityFunction.waitForTextToPresent(sel, "Domain Updated", 300);
		assertTrue("","Verify that domain "+str_domainname+" is Updated Successfully",date,sel.isTextPresent("Domain Updated"));	
}
public static void create_domainClassic(Selenium sel, String str_domainid, String str_domainname, String str_SiteURL) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions(); 
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	Date date=Calendar.getInstance().getTime();
	//Fetching values for local Variables from XMl file
	String local_path ="Setup_Script.xml";
	String VAR_Sto_Quota = utilityFunction.GetValue(local_path ,"VAR_Sto_Quota");
	String VAR_Sto_Threshold_Warn = utilityFunction.GetValue(local_path ,"VAR_Sto_Threshold_Warn");
	//Open the Domains page
	sel.click(EnvObjectMap_Rep.LNK_Domains);		
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);		
	//Click Add button
	sel.click(EnvObjectMap_Rep.BTN_AddDomain);		
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);		
	//provide Domain id
	sel.type(EnvObjectMap_Rep.LNK_DomainID,str_domainid);		
	//provide Domain name
	sel.type(EnvObjectMap_Rep.LNK_DomainName,str_domainname);		
	//Activate the Domain
	sel.click(EnvObjectMap_Rep.LNK_DomainActive);		
	//Save the domain
	sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
	//wait for loading the page
	utilityFunction.waitForTextToPresent(sel, "Domain Created", 300);			
	//Checkpoint for the newly created domain
	assertTrue("","Verify that domain is successfully created",date,sel.isTextPresent("Domain Created"));
	//Provide the Site URL
	sel.type(EnvObjectMap_Rep.TXT_SiteURL, str_SiteURL);		
	//Provide the Storage threshold quota
	sel.type(EnvObjectMap_Rep.TXT_Storage_Quota, VAR_Sto_Quota);		
	//Provide the Storage threshold warning percentage
	sel.type(EnvObjectMap_Rep.TXT_Storage_Threshold,VAR_Sto_Threshold_Warn);		
	//Click on Save button
	sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
	//wait for loading the page
	utilityFunction.waitForTextToPresent(sel, "Domain Updated", 300);
	assertTrue("","Verify that domain "+str_domainname+" is Updated Successfully",date,sel.isTextPresent("Domain Updated"));
}
public static void change_domain(Selenium sel, String str_domainname) throws Exception {
	String str_path ="Global_variables.xml";
	Date date=Calendar.getInstance().getTime();
	Utility_Functions utilityFunction = new Utility_Functions(); 
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	//Click on Change domain
	sel.click(EnvObjectMap_Rep.LNK_Chng_Domain);			
	//Choose the required domain
    for (int i = 2; i<50; i=i+1){
    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.LNK_Domain_select, i));
    	if (str_var.equals(str_domainname)){
    		sel.click(MessageFormat.format(EnvObjectMap_Rep.LNK_Domain_select, i));
            sel.waitForPageToLoad(VAR_MAX_WAIT);
            assertTrue("","Verify that domain changed to "+ str_domainname +" successfully.",date,sel.isElementPresent("link="+str_domainname));
            break;
        }                  
    }	
}

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


public static void create_WMS(Selenium sel,String str_WMS_name, String str_WMShost, String str_HTTPport, String str_webServiceUsername, String str_webServicePWD) throws Exception	{
    
    Utility_Functions utilityFunction = new Utility_Functions();
	
    //Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	//String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	Date date=Calendar.getInstance().getTime();
	//Fetching values for local Variables from XMl file
	String local_path ="local_Variables.xml";
	String VAR_DeliveryType = utilityFunction.GetValue(local_path ,"VAR_DeliveryType");
	String VAR_APType = utilityFunction.GetValue(local_path ,"VAR_APType");
	String VAR_APName = utilityFunction.GetValue(local_path ,"VAR_APName");	
	//Open the delivery option page
	sel.click(EnvObjectMap_Rep.LNK_DeliveryOption);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Click Add button to add delivery option
	sel.click(EnvObjectMap_Rep.Btn_Adddelivery);
	//utilityFunction.waitForChangesToReflect();
	//Select Delivery Type
	sel.addSelection(EnvObjectMap_Rep.SelectType_DO_WMS, VAR_DeliveryType);
	//Select WMS option
	sel.click(EnvObjectMap_Rep.LNK_selectWMSdelivery);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Provide the Delivery Option Name
	sel.type(EnvObjectMap_Rep.TXT_WMSName,str_WMS_name);
	//Provide the Host Name
	sel.type(EnvObjectMap_Rep.TXT_Host,str_WMShost);
	//Select the MMS Support
	//sel.click(EnvObjectMap_Rep.CHK_MMS);
	//Select the RTSP Support
	//sel.click(EnvObjectMap_Rep.CHK_RTSP);
	//Select the HTTP Support
	sel.click(EnvObjectMap_Rep.CHK_HTTP);
	//Provide the HTTP Port 
	sel.type(EnvObjectMap_Rep.TXT_HTTP_Port,str_HTTPport);
	//Add Access Point
	sel.click(EnvObjectMap_Rep.Btn_AddAccessPoint);
	//Select Access Point Type
	sel.addSelection(EnvObjectMap_Rep.SelectType_AP,VAR_APType);
	//Select Live Access point
	sel.click(EnvObjectMap_Rep.LNK_Live);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	if(!sel.isTextPresent("You already have an object using this name. Please select an alternate name."))
	{
	//Provide the Access Point name
	sel.type(EnvObjectMap_Rep.TXT_APName,VAR_APName);
	//Select the Rebroadcast
	sel.click(EnvObjectMap_Rep.CHK_Rebroadcast);
	//Select the Multicast
	sel.click(EnvObjectMap_Rep.CHK_Unicast);
	//Select the Unicast
	sel.click(EnvObjectMap_Rep.CHK_Multicast);
	//Save the access point
	sel.click(EnvObjectMap_Rep.Btn_SaveAP);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Select the webservice
	sel.click(EnvObjectMap_Rep.CHK_WebServiceEnabled);
	//Provide the Webservice UserName 
	sel.type(EnvObjectMap_Rep.TXT_WebServiceUserName,str_webServiceUsername);
	//Provide the Webservice Password 
	sel.type(EnvObjectMap_Rep.TXT_WebServicePassword,str_webServicePWD);
	//Provide the Webservice Confirm Password
	sel.type(EnvObjectMap_Rep.TXT_WebServiceConfirmPassword,str_webServicePWD);
	//Save the WMS delivery Option
	sel.click(EnvObjectMap_Rep.Btn_SaveDeleveryOption);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	if (!sel.isTextPresent(str_WMS_name)){     
		for(int i=1; i<50; i++){
			String a = "link=" + i;
            sel.click(a) ;
            utilityFunction.waitForChangesToReflect();
            if (sel.isTextPresent(str_WMS_name)){
               break;
            }
        }
	}		
	//Check Point to test that WMS is created
	assertTrue("","Verify that WMS delivery option "+str_WMS_name+"is created successfully.",date,sel.isTextPresent(str_WMS_name));
	}
}
	
    public static void create_HTTP(Selenium sel,String str_HTTPName, String str_HTTPhost,String str_HTTPmpName, String str_storageName) throws Exception {
	    
    	Utility_Functions utilityFunction = new Utility_Functions();		
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		Date date=Calendar.getInstance().getTime();
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		String VAR_DeliveryType_Download = utilityFunction.GetValue(str_path ,"VAR_DeliveryType_Download");		
		//Fetching values for local Variables from XMl file
		String local_path ="local_Variables.xml";
		String VAR_DeliveryType_HTTP = utilityFunction.GetValue(local_path ,"VAR_DeliveryType_HTTP");
		String VAR_AP_HTTP = utilityFunction.GetValue(local_path ,"VAR_AP_HTTP");		
		//Open the delivery option page
		sel.click(EnvObjectMap_Rep.LNK_DeliveryOption);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Click Add button to add delivery option
		sel.click(EnvObjectMap_Rep.Btn_Adddelivery);
		//Select Delivery Type
		sel.addSelection(EnvObjectMap_Rep.SelectType_DO_WMS, VAR_DeliveryType_HTTP);
		//Select HTTP option
		sel.click(EnvObjectMap_Rep.LNK_selectHTTPdelivery);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Provide the Delivery Option Name
		sel.type(EnvObjectMap_Rep.TXT_HTTP_Name,str_HTTPName);
		//Provide the Host Name
		sel.type(EnvObjectMap_Rep.TXT_HTTP_Host,str_HTTPhost);
		//Click Add button to add select Downloadable access point
		sel.click(EnvObjectMap_Rep.LNK_Click_Add_Download);
		//Select Download Access Point 
		sel.addSelection(EnvObjectMap_Rep.SelectType_DO_Download_Type, VAR_DeliveryType_Download);
		//Select Download option
		sel.click(EnvObjectMap_Rep.LNK_selectDownloaddelivery);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Provide Access Point Name
		sel.type(EnvObjectMap_Rep.TXT_AP_HTTP_Name,VAR_AP_HTTP);
		//Provide Mount Point
		sel.type(EnvObjectMap_Rep.TXT_MP_HTTP,str_HTTPmpName);
		//Select Storage
		sel.select(EnvObjectMap_Rep.dropdown_Storage,str_storageName);	
		//Click Save button for Access Point
		sel.click(EnvObjectMap_Rep.Btn_Save_AP);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Click Save button for HTTP delivery Option
		sel.click(EnvObjectMap_Rep.Btn_Save_HTTP);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		if (!sel.isTextPresent(str_HTTPName)){ 
		    for(int i=1; i<50; i++){
		    	
	            String a = "link=" + i;
	            sel.click(a) ;	            
	            //Utility_Functions utilityFunction = new Utility_Functions();
	            utilityFunction.waitForChangesToReflect();
	            if (sel.isTextPresent(str_HTTPName))
	            break;
	        }
	    }

		//Check Point to test that HTTP is created
		assertTrue("","Verify that HTTP delivery option "+str_HTTPName+" is created successfully.",date,sel.isTextPresent(str_HTTPName));
	}
    //Create medianet with DNS
    public static void create_medianetDNS(Selenium sel,String str_medianetName, String str_originWMS, String str_edgeWMS, String str_edgeHost) throws Exception	{
		Date date=Calendar.getInstance().getTime();
	    Utility_Functions utilityFunction = new Utility_Functions();
    	//Click on Delivery Option
	    sel.click(EnvObjectMap_Rep.LNK_DeliveryOption);
	    //Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Clic on Add button
		sel.click(EnvObjectMap_Rep.Btn_Adddelivery);
		//Select the medianet option from the list box
		sel.addSelection(EnvObjectMap_Rep.SelectType_DO_WMS, "label=MediaNet");
		//Click on Medianet option
		sel.click(EnvObjectMap_Rep.selectMediaNet);
	    //Wait for the page to load
		sel.waitForPageToLoad("80000");
		//Type the name of the medianet
		sel.type(EnvObjectMap_Rep.txt_nameMedianet, str_medianetName);		
		String FirstWMS = sel.getText(EnvObjectMap_Rep.lst_FirstWMSdo);
		String SecondWMS = sel.getText(EnvObjectMap_Rep.lst_SecondWMSdo);
		if(FirstWMS.equals(str_originWMS))
				{
			sel.click(EnvObjectMap_Rep.lst_FirstWMSdo);
				}		
		else
		{
			if(SecondWMS.equals(str_originWMS))
			{
				sel.click(EnvObjectMap_Rep.lst_SecondWMSdo);
			}
			else
			{
			  for (int i = 3; i<50;i=i+1 ){
				  
			    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
			    	//System.out.println(str_var);			    	
			    	if (str_var.equals(str_originWMS)){
			    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
		              break;
		          }   			    	
		      }
			}
		}		
		sel.click(EnvObjectMap_Rep.lnk_originMoveToSelected);
		
		  for (int i = 1; i<50; i=i+1)
		  {
		    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
		    	if (str_var.equals(str_edgeWMS))
		    	{
		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
	            break;
		    	}                  
		  }
	 
	sel.click(EnvObjectMap_Rep.lnk_edgeMoveToSelected);
	//Type the edge IP
	sel.type(EnvObjectMap_Rep.txt_DNS, str_edgeHost);
	//Save the delivery option
	sel.click(EnvObjectMap_Rep.btn_submit);
    //Wait for the page to load
	sel.waitForPageToLoad("90000");
	if (!sel.isTextPresent(str_medianetName)){     
		for(int i=1; i<50; i++){
			String a = "link=" + i;
            sel.click(a) ;
            utilityFunction.waitForChangesToReflect();
            if (sel.isTextPresent(str_medianetName)){
               break;
            }
        }
	}		
	//Check Point to test that WMS is created
	assertTrue("","Verify that Medianet delivery option "+str_medianetName+" is created successfully.",date,sel.isTextPresent(str_medianetName));
	
}    
public static void create_WME(Selenium sel,String str_WMEName, String str_WMEhost, String str_WMEcommPort, String str_WMEdocRoot,String str_WMEProName, String str_WMEPort,String str_WMEsavedFilepath) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();
		Date date=Calendar.getInstance().getTime();
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
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
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.TXT_WMEProf_ExtURL, 300);
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
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.TXT_WME_CommPort, 300);
		//Save the WME
		sel.click(EnvObjectMap_Rep.Btn_Save_WME);
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//verifies the checkpoint for successful WME Creation
		assertTrue("","Verify that WME "+str_WMEName+" with profile is created successfully.",date,sel.isTextPresent(str_WMEName));		
	}
public static void Map_Resources(Selenium sel,String DomainName,String ResourceType, String ResourceName) throws Exception
{
Date date=Calendar.getInstance().getTime();
Utility_Functions utilityFunction = new Utility_Functions();
sel.click("link=System Resource Mapping");
sel.waitForPageToLoad("30000");
sel.select("domainId", "label="+DomainName+" ("+DomainName+")");
sel.waitForPageToLoad("30000");
for(int x=3;x<50;x=x+2)
{
	String str_var=sel.getText("//div["+x+"]/b");
	if (str_var.equals(ResourceType)){
		x=x+1;
		for(int a=1;a<50;a=a+1)
		{
			
			String str_var1=sel.getText("//div["+x+"]/div["+a+"]/div[1]/a");
	    	//System.out.println(str_var);			    	
	    	if (str_var1.equals(ResourceName))
	    	{
	    		if(!sel.isChecked("//div["+x+"]/div["+a+"]/div[2]/input"))
	    		{
	    			sel.click("//div["+x+"]/div["+a+"]/div[2]/input");
	    			break;
	    		}	
	    		break;
	    	} 
	    	
		 }
			
		break;		      
	}
	
}
 	
sel.click("update_button");
utilityFunction.waitForTextToPresent(sel, "Records updated", 300);
assertTrue("","Verify that resource "+ResourceName+" is mapped to the domain '"+DomainName+"' successfully.",date,sel.isTextPresent("Records updated"));
}
/*public static void Map_Resources(Selenium sel,String DomainName, String ResourceName) throws Exception
	{
	Date date=Calendar.getInstance().getTime();
	Utility_Functions utilityFunction = new Utility_Functions();
	sel.click("link=System Resource Mapping");
	sel.waitForPageToLoad("30000");
	sel.select("domainId", "label="+DomainName+" ("+DomainName+")");
	sel.waitForPageToLoad("30000");
		for (int i = 4; i<50;i=i+2 ){
		
			for(int a=1;a<50;a=a+1)
			{
				try
				{
				String str_var=sel.getText("//div["+i+"]/div["+a+"]/div[1]/a");
		    	//System.out.println(str_var);			    	
		    	if (str_var.equals(ResourceName)){
		    		if(!sel.isChecked("//div["+i+"]/div["+a+"]/div[2]/input"))
		    		{
		    			sel.click("//div["+i+"]/div["+a+"]/div[2]/input");
		    		}	         
		    	}  		    	
			    }
				catch(Exception e)
				{
					  break;
				}
			}	    	
        }   	
	sel.click("update_button");
	utilityFunction.waitForTextToPresent(sel, "Records updated", 300);
	assertTrue("","Verify that resource "+ResourceName+" is mapped to the domain '"+DomainName+"' successfully.",date,sel.isTextPresent("Records updated"));
	}*/
public static void Add_Survey(Selenium sel, String str_surveyName, String str_questionName, String str_questionExplanation, String str_questionType) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions(); 
	sel.click(EnvObjectMap_Rep.LNK_Content);
	sel.waitForPageToLoad("50000");
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.BTN_More_Search, 300);
	sel.click(EnvObjectMap_Rep.Btn_AddItem);
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.radio_contentTypePoll, 300);
	sel.click(EnvObjectMap_Rep.radio_contentTypePoll);
	//Click next button
	sel.click(EnvObjectMap_Rep.Btn_Next);
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.txt_pollDispName, 300);
	sel.type(EnvObjectMap_Rep.txt_pollDispName, str_surveyName);
	sel.click(EnvObjectMap_Rep.btn_addQuestion);
	utilityFunction.waitForChangesToReflect();
	sel.type(EnvObjectMap_Rep.txt_questionDispName, str_questionName);
	sel.type(EnvObjectMap_Rep.txt_questionExplanation, str_questionExplanation);
	sel.select(EnvObjectMap_Rep.drp_questionType, "label=" + str_questionType);
	sel.type(EnvObjectMap_Rep.txt_questionAnswer1, "1");
	sel.type(EnvObjectMap_Rep.txt_questionAnswer2, "2");
	sel.type(EnvObjectMap_Rep.txt_questionAnswer3, "3");		
	sel.click(EnvObjectMap_Rep.btn_questionSave);
	utilityFunction.waitForChangesToReflect();
	sel.click(EnvObjectMap_Rep.btn_questionSave);
	utilityFunction.waitForChangesToReflect();	
	assertTrue("","Verify that poll/survey '"+str_surveyName+"' is uploaded successfully",date,sel.isTextPresent(str_surveyName));
	}
public static void Upload_Slides(Selenium sel,String str_SlideName, String str_Upload_Content) throws Exception	{	
    
	Utility_Functions utilityFunction = new Utility_Functions();
	Date date=Calendar.getInstance().getTime();
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");		
	//Open the programming menu
	sel.click(EnvObjectMap_Rep.LNK_Programming);
	//Select the Content link
	sel.click(EnvObjectMap_Rep.LNK_Content);
	//Wait for loading the page
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.BTN_More_Search, 300);
	//Click Add Item button
	sel.click(EnvObjectMap_Rep.Btn_AddItem);
	//Wait for loading the page
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Rbtn_Slides, 300);
	//Select Slides radio button
	sel.click(EnvObjectMap_Rep.Rbtn_Slides);
	//Click next button
	sel.click(EnvObjectMap_Rep.Btn_Next);
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_Upload_Next, 300);
	//Bring the focus on File upload field 
	sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
	//press tab
	sel.keyPressNative("9");
	//Press tab 
	sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
	//Path of the autoit file to upload file
	String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";	
	String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_Upload_Content;	
	String []cmd = {auto_it_contentUpload, filePath};	
	Runtime.getRuntime().exec(cmd);    
	//Click next button to upload the slides
	sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 400) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.TXT_Display_Name)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	//Provide the slide name
	sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_SlideName);
	//Click Finish button
	sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
	utilityFunction.waitForChangesToReflect();
	//Click More button for Search
	sel.click(EnvObjectMap_Rep.BTN_More_Search);
	//Provide the Slide name to search
	sel.type(EnvObjectMap_Rep.TXT_Search_Name,str_SlideName);
	//Click Search button
	sel.click(EnvObjectMap_Rep.Btn_Search);
	//Wait for loading the page
	utilityFunction.waitForChangesToReflect();
	assertTrue("","Verify that slide '"+str_SlideName+"' is uploaded successfully",date,sel.isTextPresent(str_SlideName));
}

//Create RS2k encoder
public static void create_RSS2kenc(Selenium sel, String str_encName, String str_hostIP, String str_version, String str_userName, String str_password, String encProfileName, String str_bitRate) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions();		
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	Date date=Calendar.getInstance().getTime();
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
	assertTrue("","Verify that "+str_version+" encoder is created successfully.",date,sel.isTextPresent(str_encName));
}
//Create RSS4kV6 encoder
public static void create_RSSv6enc(Selenium sel, String str_encName, String str_hostIP, String str_userName, String str_password, String str_maxStreams, String encProfileName) throws Exception {

Utility_Functions utilityFunction = new Utility_Functions();

//Fetching values for Global Variables from XMl file
String str_path ="Global_variables.xml";
Date date=Calendar.getInstance().getTime();
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
assertTrue("","Verify that RSS4000V6 encoder is created successfully.",date,sel.isTextPresent(str_encName));
}
}
