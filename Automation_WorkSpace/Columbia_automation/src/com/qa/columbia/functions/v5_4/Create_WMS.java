/*
 * This method is used to Create WMS delivery option in the Application.
 * @param sel selenium object that runs the selenium commands
 * @param str_WMS_name used to provide the Host name in the Browser. .
 * @param str_WMShost is used to provide the HTTP Host Name in the Browser.
 * @param str_HTTPport is used to provide HTTP port. 
 * @param str_webServiceUsername is used to provide web Service User name. 
 * @param str_webServicePWD is used to provide web Service Password.
*/

package com.qa.columbia.functions.v5_4;
/*
import java.util.Calendar;
import java.util.Date;*/

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Create_WMS extends TesterAsserter {
	
    public static void create_WMS(Selenium sel,String str_WMS_name, String str_WMShost, String str_HTTPport, String str_webServiceUsername, String str_webServicePWD) throws Exception	{
       
	    Utility_Functions utilityFunction = new Utility_Functions();
		
	    //Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		//String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	//	Date date=Calendar.getInstance().getTime();
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
		/*if (!sel.isTextPresent(str_WMS_name)){     
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
		assertTrue("Columbia_LiveProgramVerification","Verify that WMS delivery option is created successfully.",date,sel.isTextPresent(str_WMS_name));
		*/}
    }
}


