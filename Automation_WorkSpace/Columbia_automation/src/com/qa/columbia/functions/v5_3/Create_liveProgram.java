/*
 * This method is used to Create Live Program in the Application.
 * @param sel selenium object that runs the selenium commands
 * @param LiveProgName is used to provide Live program name. 
 * @param str_ChannelName is used to provide channel name.
 * @param str_WMEName is used to provide Windows media encoder name.
 * @param str_WMEProName is used to provide Windows Media Encoder Profile name.
 * @param str_slideName is used to provide display name of content (Slide).
 * @throws Exception  
*/

package com.qa.columbia.functions.v5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Create_liveProgram extends TesterAsserter {
	
    public static void create_LiveProgram(Selenium sel, String LiveProgName,String str_ChannelName,String str_WMEName, String str_WMEProName, String str_slideName) throws Exception {
		
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	Date date=Calendar.getInstance().getTime();
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");

	//Fetching values for local Variables from XMl file
	String local_path ="local_Variables.xml";
	String VAR_DeliveryType_Live = utilityFunction.GetValue(local_path ,"VAR_DeliveryType_Live");
	//Open the Programming menu
	sel.click(EnvObjectMap_Rep.LNK_Programming);
	//Open the Programs age
	sel.click(EnvObjectMap_Rep.LNK_Programs);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Click Add button 
	sel.click(EnvObjectMap_Rep.Btn_Add_Program);
	//Select the program type
	sel.addSelection(EnvObjectMap_Rep.SelectType_Program_Live, VAR_DeliveryType_Live);
	//Select the Live program
	sel.click(EnvObjectMap_Rep.LNK_Live_Broadcast);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Provide the Live Program Name
	sel.type(EnvObjectMap_Rep.TXT_Program_Name,LiveProgName);
	//Select the Channel
	sel.select(EnvObjectMap_Rep.Dropdown_channel,str_ChannelName);
	//Click Next button
	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Info);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Select Program Listing
	sel.click(EnvObjectMap_Rep.Radio_btn_Immediately);
	//Click Add Encoder Profile
	sel.click(EnvObjectMap_Rep.Btn_Add_Enc);
	//Select Encoder Type
	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Panel, str_WMEName);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	//Click Encoder Type
	sel.click(EnvObjectMap_Rep.LNK_Select_Enc);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	//Select Add Encoder profile 
	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Profile, str_WMEProName);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	//Click Encoder Profile 
	sel.click(EnvObjectMap_Rep.LNK_Select_Profile);
	//Click Add Encoder Profile button
	sel.click(EnvObjectMap_Rep.Btn_Add_Profile);
	//Click Next button on Program Listing page
	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Listing);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Click Select button for adding Slides
     sel.click(EnvObjectMap_Rep.Btn_Select_Slides);
	//Wait
	utilityFunction.waitForChangesToReflect();
	//Move to the Search section
	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	//Set focus on the searcg textbox
	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	//provide Slide name to Search it from Panel
	sel.type(EnvObjectMap_Rep.SelectType_Search_Panel, str_slideName);
	//wait for changing the phase
	utilityFunction.waitForChangesToReflect();
	//Click Search button 
	sel.click(EnvObjectMap_Rep.Btn_Search_Slides);
	//wait for changing the phase
	utilityFunction.waitForChangesToReflect();
	//Select Slides from Search results
	sel.click(EnvObjectMap_Rep.LNK_Select_Slides);
	//wait for changing the phase
	utilityFunction.waitForChangesToReflect();
	//Click Save button
	sel.click(EnvObjectMap_Rep.Btn_Save_Slides);
	//wait for changing the phase
	utilityFunction.waitForChangesToReflect();
	//Click next button on Program Content page           
	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
	//Check if the audience is defined
	if (sel.isElementPresent(EnvObjectMap_Rep.Btn_Next_Delivery_Select)){
		//Select the delivery option radiobox
		sel.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
	}
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Select HTTP delivery option
	sel.click(EnvObjectMap_Rep.Radio_Btn_Select_HTTP);
	//Select WMS delivery option
	sel.click(EnvObjectMap_Rep.Radio_Btn_Select_WMS);
	//Click next button on Content Delivery option
	sel.click(EnvObjectMap_Rep.Btn_Next_Delivery);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Click Summary button on Program Assignment page
	sel.click(EnvObjectMap_Rep.Btn_Summary);
	Thread.sleep(10000);
	//Move to the Search section
	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	//Set focus on the search textbox
	sel.keyPressNative(java.awt.event.KeyEvent.VK_ENTER + "");
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Click Finish button on program Summary page
	sel.click(EnvObjectMap_Rep.Btn_Finish_Program);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Search the new created Live program
	sel.click(EnvObjectMap_Rep.LNK_Search_Program);
	//provide program name in Search field
	sel.type(EnvObjectMap_Rep.SelectType_Search_Program ,LiveProgName);
	//click Search button 
	sel.click(EnvObjectMap_Rep.Btn_Search_Program);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Check Point to test that program is created
	assertTrue(" ","Verify that Live Program is created successfully.",date,sel.isTextPresent(LiveProgName));
	}
}
