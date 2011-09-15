/*
 * This method is used to Create HTTP Delivery option in the Application.
 * 
*/

package com.qa.columbia.functions.v5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Create_HTTP extends TesterAsserter{
	
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
		assertTrue("Columbia_LiveProgramVerification","Verify that HTTP delivery option is created successfully.",date,sel.isTextPresent(str_HTTPName));
	}

}

