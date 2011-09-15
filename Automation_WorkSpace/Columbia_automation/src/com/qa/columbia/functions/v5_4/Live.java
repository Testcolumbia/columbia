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

package com.qa.columbia.functions.v5_4;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Live extends TesterAsserter {
	
    public static void test_Live(Selenium sel,String str_scriptName, String LiveProgName,String str_encName, String str_encProName, String str_deliveryOption) throws Exception {
		
	Utility_Functions utilityFunction = new Utility_Functions();	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	Date date=Calendar.getInstance().getTime();
	String VAR_endPointIP = utilityFunction.GetValue(str_path ,"VAR_endPointIP");
	String VAR_VRRname_NonPinProtected = utilityFunction.GetValue(str_path ,"VAR_VRRname_NonPinProtected");
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
	//Click Next button
	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Info);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Select Program Listing
	sel.click(EnvObjectMap_Rep.Radio_btn_Immediately);
	//Click Add Encoder Profile
	sel.click(EnvObjectMap_Rep.Btn_Add_Enc);
	//Select Encoder Type
	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Panel, str_encName);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	//Click Encoder Type
	sel.click(EnvObjectMap_Rep.LNK_Select_Enc);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	//Select Add Encoder profile 
	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Profile, str_encProName);
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
	if(sel.isElementPresent(EnvObjectMap_Rep.txt_EndPointIP))
	{
    	sel.type(EnvObjectMap_Rep.txt_EndPointIP, VAR_endPointIP);
    	if(sel.isElementPresent(EnvObjectMap_Rep.drp_VRR))
    	{
    	sel.select(EnvObjectMap_Rep.drp_VRR, "label="+VAR_VRRname_NonPinProtected);
    	}
    	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Listing);
    	sel.waitForPageToLoad("30000");
    	}	
	//Click next button on Program Content page           
	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Check if the audience is defined
	if (sel.isElementPresent(EnvObjectMap_Rep.radio_audience)){
		//Select the delivery option radiobox
		sel.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
	}

	for (int i = 2; i<50; i=i+1){
	    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.delivery_text, i));
	    	System.out.println(str_var);	   
	    	if (str_var.equals(str_deliveryOption)){
	    		sel.click(MessageFormat.format(EnvObjectMap_Rep.delivery_chk, i));
               break;
          }                  
       }
	sel.click(EnvObjectMap_Rep.Btn_Next_Delivery);
	//wait for loading the page
	sel.waitForPageToLoad(VAR_MED_WAIT);	
	//Click Summary button on Program Assignment page
	sel.click(EnvObjectMap_Rep.Btn_Summary);
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
	utilityFunction.waitForChangesToReflect();
	//Check Point to test that program is created
	assertTrue(str_scriptName,"Verify that Live Program is created successfully.",date,sel.isTextPresent(LiveProgName));
	}
    
    public static void Live_audience(Selenium sel,String str_scriptName, String LiveProgName,String str_encName, String str_encProName, String str_slideName, String str_pollName, String str_surveyName, String str_deliveryOption) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();	
    	//Fetching values for Global Variables from XMl file
    	String str_path ="Global_variables.xml";
    	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
    	String VAR_endPointIP = utilityFunction.GetValue(str_path ,"VAR_endPointIP");
    	String VAR_VRRname_NonPinProtected = utilityFunction.GetValue(str_path ,"VAR_VRRname_NonPinProtected");

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
    	//Click Next button
    	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Info);
    	//Wait for loading the page
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	//Select Program Listing
    	sel.click(EnvObjectMap_Rep.Radio_btn_Immediately);
    	//Click Add Encoder Profile
    	sel.click(EnvObjectMap_Rep.Btn_Add_Enc);
    	//Select Encoder Type
    	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Panel, str_encName);
    	//wait for loading the page
    	utilityFunction.waitForChangesToReflect();
    	//Click Encoder Type
    	sel.click(EnvObjectMap_Rep.LNK_Select_Enc);
    	//wait for loading the page
    	utilityFunction.waitForChangesToReflect();
    	//Select Add Encoder profile 
    	sel.select(EnvObjectMap_Rep.SelectType_Add_Encoder_Profile, str_encProName);
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
    	if(sel.isElementPresent(EnvObjectMap_Rep.txt_EndPointIP))
     		{
    	    	sel.type(EnvObjectMap_Rep.txt_EndPointIP, VAR_endPointIP);
    	    	if(sel.isElementPresent(EnvObjectMap_Rep.drp_VRR))
    	    	{
    	    	sel.select(EnvObjectMap_Rep.drp_VRR, "label="+VAR_VRRname_NonPinProtected);
    	    	}
    	    	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Listing);
    	    	sel.waitForPageToLoad("30000");
    	    	}
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
    	//Click Search button 
    	sel.click(EnvObjectMap_Rep.Btn_Search_Slides);
    	//wait for changing the phase
    	//utilityFunction.waitForChangesToReflect();
    	//Select Slides from Search results
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.LNK_Select_Slides)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
    	sel.click(EnvObjectMap_Rep.LNK_Select_Slides);
    	//wait for changing the phase
    	//utilityFunction.waitForChangesToReflect();
    	//Click Save button
    	sel.click(EnvObjectMap_Rep.Btn_Save_Slides);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();		
    	sel.click(EnvObjectMap_Rep.btn_selectPollLive);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();
    	//Move to the Search section
    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
    	//Set focus on the searcg textbox
    	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
    	//provide Poll name to Search it from Panel
    	sel.type(EnvObjectMap_Rep.txt_searchPollLive, str_pollName);
    	//Click Search button 
    	sel.click(EnvObjectMap_Rep.btn_searchPollLive);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();
    	//Select Slides from Search results
    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedPoll);
    	//Click next button on Program Content page           
    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedPollLive);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();	
    	sel.click(EnvObjectMap_Rep.btn_selectSurveyLive);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();
    	//Move to the Search section
    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
    	//Set focus on the searcg textbox
    	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
    	//provide Poll name to Search it from Panel
    	sel.type(EnvObjectMap_Rep.txt_searchSurveyLive, str_surveyName);
    	//Click Search button 
    	sel.click(EnvObjectMap_Rep.btn_searchSurveyLive);
    	//wait for changing the phase
    	utilityFunction.waitForChangesToReflect();
    	//Select Slides from Search results
    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedSurvey);
    	//Click next button on Program Content page           
    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedSurveyLive);
    	//Click on checkbox
    	sel.click(EnvObjectMap_Rep.chk_questionBeforeBcast);
    	sel.click(EnvObjectMap_Rep.chk_questionDuringBcast);
    	sel.click(EnvObjectMap_Rep.chk_questionAskAnonymous);	
    	//Click next button on Program Content page 
    	//Click next button on Program Content page          
    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
    	sel.waitForPageToLoad("30000");
    	//Select the delivery option radiobox
    	sel.click(EnvObjectMap_Rep.radio_audience);
    	
    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
    	//wait for loading the page
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	utilityFunction.waitForChangesToReflect();
    	
    	if(!sel.isTextPresent("Select/unselect all below"))
    			{
    			sel.click("audiences_1");
    			}
    	else
    	{
    		for (int i = 1; i<50; i=i+1)
 		   {		   
 			   String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.audience_text, i));
 		    	System.out.println(str_var);	   
 		    	if (str_var.equals(str_deliveryOption)){
 		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.audience_chk, i));
 	               break;
 	          }                  
 	       }
    	}
    	/*if 	(str_deliveryOption.equals(sel.getText("//div[3]/div[1]/div[2]/div/div")))
    	{
    		System.out.println(sel.getText("//div[@id='set_audiences']/div"));
    		sel.click("audiences_1");
    	}
    	else
    	{
    		for (int i = 1; i<50; i=i+1)
    		   {		   
    			   String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.audience_text, i));
    		    	System.out.println(str_var);	   
    		    	if (str_var.equals(str_deliveryOption)){
    		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.audience_chk, i));
    	               break;
    	          }                  
    	       }
    	}*/
    	sel.focus("_eventId_next");
    	utilityFunction.waitForChangesToReflect();
    	sel.click("_eventId_next");
    	//wait for loading the page
    	sel.waitForPageToLoad(VAR_MED_WAIT);	
    	//Click Summary button on Program Assignment page
    	sel.click(EnvObjectMap_Rep.Btn_Summary);
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
    	assertTrue(str_scriptName,"Verify that Live Program is created successfully.",date,sel.isTextPresent(LiveProgName));
    	}

}
