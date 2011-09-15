package com.qa.columbia.functions.v6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Create_Program extends TesterAsserter
{

	 public static void create_VODProgram(Selenium sel,String programname,String str_SurveyName,String str_StreamingMedia) throws Exception
		{
			
	        Utility_Functions utilityFunction = new Utility_Functions();
			
			//Fetching values for Global Variables from XMl file
			String globalVariableFile ="Global_variables.xml";
			//wait
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//String VAR_MEX_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MEX_WAIT");
			
			sel.click(EnvObjectMap_Rep.Lnk_programming);
			
			sel.click(EnvObjectMap_Rep.Lnk_programs);
			
			sel.waitForPageToLoad(VAR_MED_WAIT);
			
			sel.click(EnvObjectMap_Rep.Btn_Add_Program);
			
			//Select the On-demand Program
	    	sel.addSelection(EnvObjectMap_Rep.SelectType_Program_Live, EnvObjectMap_Rep.lst_ondemand);
	    	sel.click(EnvObjectMap_Rep.LNK_OnDemand);    	
			sel.waitForPageToLoad(VAR_MED_WAIT);
			//Provide the program name
	    	sel.type(EnvObjectMap_Rep.txt_ProgramName, programname);    	
	    	//Click on Next button
	    	sel.click(EnvObjectMap_Rep.btn_Next_programPage);	
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	if(!sel.isElementPresent(EnvObjectMap_Rep.radio_Immediately))
			{
				sel.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		    	sel.waitForPageToLoad(VAR_MED_WAIT);
			}
	    	//Select the listing as Immediately
	    	sel.click(EnvObjectMap_Rep.radio_Immediately);
	    	//Click on Next button
	    	sel.click(EnvObjectMap_Rep.btn_Next_programPage);    	
	    	sel.waitForPageToLoad(VAR_MED_WAIT);  
	    	
	    	    	   	
	    utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.btn_selectMedia, 300); 
	    	
	    	//Click on Add Media button
	    	sel.click(EnvObjectMap_Rep.btn_selectMedia);    	
	    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lbl_browseMedia, 300);    	
	    	sel.focus(EnvObjectMap_Rep.lbl_browseMedia);    	
	    	//Navigate to Search tab
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the search textbox
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	
	    	//Type the streaming media name
	    	sel.type(EnvObjectMap_Rep.txt_SearchMedia, str_StreamingMedia);
	    	//Click on Find button
	    	sel.click(EnvObjectMap_Rep.btn_mediaSearch);
	    	
	    	utilityFunction.waitForChangesToReflect();
	    	//Select the searched media
	    	sel.click(EnvObjectMap_Rep.Lnk_selectMedia);
	    	//Move the selected file to selected List box
	    	sel.click(EnvObjectMap_Rep.lnk_moveToSelected);
	    	//Click on Save button
	    	sel.click(EnvObjectMap_Rep.btn_saveSelectedMedia);
	    		    	//wait for page to load
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.btn_selectSurveyLive, 300); 
	    	if(str_SurveyName!=""){
	    		sel.click(EnvObjectMap_Rep.btn_selectSurveyLive);
		    	//wait for changing the phase
		    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lblsurvey_browseMedia, 300);
		    	//Move to the Search section
		    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
		    	//Set focus on the searcg textbox
		    	sel.focus(EnvObjectMap_Rep.txt_searchSurveyVOD);
		    //	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
		    	//provide Poll name to Search it from Panel
		    	sel.type(EnvObjectMap_Rep.txt_searchSurveyVOD, str_SurveyName);
		    	//Click Search button 
		    	sel.click(EnvObjectMap_Rep.btn_searchSurveyVOD);
		    	//wait for changing the phase
		    	utilityFunction.waitForChangesToReflect();
		    	//Select Slides from Search results
		    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedSurveyVOD);
		    	//Click next button on Program Content page           
		    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedSurveyVOD);	
	    	}
	    	
	    	//Click on Next button
	    	sel.click(EnvObjectMap_Rep.btn_Next_programPage);
	    	
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	     	if (sel.isElementPresent(EnvObjectMap_Rep.radio_audience))
	    	{
	    		//Select the delivery option radiobox
	    		sel.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
	    		sel.waitForPageToLoad(VAR_MED_WAIT);
	    	}     	
	     	//Click next button on Content Delivery option
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Delivery);    	
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Summary button on Program Assignment page
	    	sel.click(EnvObjectMap_Rep.Btn_Summary);
	    	//wait for loading the page
	    	
	    	 sel.waitForPageToLoad(VAR_MED_WAIT);
	         sel.click("makeMaster");
	            //Click Finish button on program Summary page
	            sel.click(EnvObjectMap_Rep.Btn_Finish_Program);
	            sel.waitForPageToLoad(VAR_MED_WAIT);
	    	
	    	utilityFunction.waitForChangesToReflect();		
		}
		
		 
	 
	 
 public static void create_LiveProgram(Selenium sel, String LiveProgName,String str_encName, String str_encProName, String str_slideName, String str_PollName, String str_SurveyName, String str_deliveryOption) throws Exception {
			
	    	Utility_Functions utilityFunction = new Utility_Functions();	
	    	//Fetching values for Global Variables from XMl file
	    	String globalVariableFile  ="Global_variables.xml";
	    	Date date=Calendar.getInstance().getTime();
	    	String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile  ,"VAR_MED_WAIT");
	    	String VAR_MAX_WAIT = utilityFunction.GetValue(globalVariableFile  ,"VAR_MAX_WAIT");
	    	String VAR_endPointIP = utilityFunction.GetValue(globalVariableFile  ,"VAR_endPointIP");
	    	String VAR_VRRname_NonPinProtected = utilityFunction.GetValue(globalVariableFile  ,"VAR_VRRname_NonPinProtected");

	    	
	    	//Open the Programming menu
	    	sel.click(EnvObjectMap_Rep.Lnk_programming);
	    	//Open the Programs age
	    	sel.click(EnvObjectMap_Rep.LNK_Programs);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MAX_WAIT);	
	    	//Click Add button 
	    	sel.click(EnvObjectMap_Rep.Btn_Add_Program);
	    	//Select the program type
	    	sel.addSelection(EnvObjectMap_Rep.SelectType_Program_Live,"Live Broadcast");
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
	    	Thread.sleep(2000);
	    	
	    	if(sel.isElementPresent(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence))
	    	{
	    	sel.click(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence);
	    	}
	    	//Delete upcoming occurrences
	    	
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
	    	utilityFunction.waitForChangesToReflect();
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
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	}	    		   	
	    	if (str_slideName!=""){
	    	//Click Select button for adding Slides
	         sel.click(EnvObjectMap_Rep.Btn_Select_Slides);
	    	//Wait
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_4", 300);
	    	//Move to the Search section

	    	sel.focus("dijit_layout__TabButton_4");
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	       	sel.focus("//div[@id='dijit_layout_ContentPane_12']/div[1]/input[1]");
	    	//provide Slide name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.SelectType_Search_Panel, str_slideName);
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
	    	}
	    	if (str_PollName!=""){
	    	//Click Select button for adding Poll
	    	sel.click(EnvObjectMap_Rep.btn_selectPollLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_6", 300);
	    	//Move to the Search section
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.focus(EnvObjectMap_Rep.txt_searchPollLive);
	   // 	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	//provide Poll name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.txt_searchPollLive, str_PollName);
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
	    	}
	    	if (str_SurveyName!=""){
	    	//Click Select button for adding Survey
	    	sel.click(EnvObjectMap_Rep.btn_selectSurveyLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_8", 300);
	    	//Move to the Search section
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.focus(EnvObjectMap_Rep.txt_searchSurveyLive);
	    //	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	//provide Poll name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.txt_searchSurveyLive, str_SurveyName);
	    	//Click Search button 
	    	sel.click(EnvObjectMap_Rep.btn_searchSurveyLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForChangesToReflect();
	    	//Select Slides from Search results
	    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedSurvey);
	    	//Click next button on Program Content page           
	    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedSurveyLive);
	    	
	    	}
	    	//Click on checkbox
	    	sel.click(EnvObjectMap_Rep.chk_questionBeforeBcast);
	    	sel.click(EnvObjectMap_Rep.chk_questionDuringBcast);
	    	sel.click(EnvObjectMap_Rep.chk_questionAskAnonymous);	
	    	//Click next button on Program Content page           
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	
	    	
	    	//Check if the audience is defined
	    	if (sel.isElementPresent(EnvObjectMap_Rep.radio_audience))
	    	{
	    		//Select the delivery option radiobox
	    		sel.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
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
	    	//Click next button on Content Delivery option
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Delivery);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Summary button on Program Assignment page
	    	sel.click(EnvObjectMap_Rep.Btn_Summary);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Finish button on program Summary page
	    	sel.click(EnvObjectMap_Rep.Btn_Finish_Program);
	       	Thread.sleep(10000);
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + "");
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
	    	//assertTrue(" ","Verify that Live Program is created successfully.",date,sel.isTextPresent(LiveProgName));
	    	}
 // Create Automated File broadcast program

 public static void create_AutoFileProgram(Selenium sel,String str_ProgramName, String str_StreamingName,String str_deliveryOption) throws Exception {
                Utility_Functions utilityFunction = new Utility_Functions();              //Fetching values for Global Variables from XMl file
      String str_path ="Global_variables.xml";
      String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
      //Open the Programming menu
      sel.click(EnvObjectMap_Rep.Lnk_programming);
      //Open the Programs age
      sel.click("link=Programs");
      //Wait for the page to load
      sel.waitForPageToLoad(VAR_MED_WAIT);
      //Click on Add button
      sel.click(EnvObjectMap_Rep.Btn_Add_Program);
      sel.addSelection("selectselectTypeDialogprogramTypes", "label=Automated File Broadcast");
      sel.click(EnvObjectMap_Rep.LNK_fileBroadcast);
      //Wait for the page to load
      sel.waitForPageToLoad(VAR_MED_WAIT);
      sel.type(EnvObjectMap_Rep.txt_ProgramName, str_ProgramName);
      sel.click(EnvObjectMap_Rep.btn_Next_programPage);
      //Wait for the page to load
      sel.waitForPageToLoad(VAR_MED_WAIT);
      sel.click(EnvObjectMap_Rep.radio_listImmadiately);
      
      Thread.sleep(2000);
  	
  	if(sel.isElementPresent(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence))
  	{
  	sel.click(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence);
  	}
      sel.click(EnvObjectMap_Rep.btn_Next);
      //Wait for the page to load
      sel.waitForPageToLoad(VAR_MED_WAIT);
      //Click on Add Media button
      sel.click(EnvObjectMap_Rep.btn_selectMedia);
      //sel.click(EnvObjectMap_Rep.Btn_Select_Slides);
      //Wait
      utilityFunction.waitForChangesToReflect();
      sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
      sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
      sel.focus(EnvObjectMap_Rep.txt_searchMedia);
      //Type the media name
      sel.type(EnvObjectMap_Rep.txt_searchMedia, str_StreamingName);
      //Click on Find button
      sel.click(EnvObjectMap_Rep.btn_findMedia);
      utilityFunction.waitForChangesToReflect();
      //Select the searched media
      sel.click(EnvObjectMap_Rep.lnk_searchedMedia);
      sel.click(EnvObjectMap_Rep.btn_moveToSelected);
      //Click on Save button
      sel.click(EnvObjectMap_Rep.btn_saveSearchedMedia);
      //wait for changing the phase
      utilityFunction.waitForChangesToReflect();              //Click on Next button
      sel.click(EnvObjectMap_Rep.btn_Next);
      //Wait for the page to load
      sel.waitForPageToLoad(VAR_MED_WAIT);
      //Check if the audience is defined in the domain
      if (sel.isElementPresent(EnvObjectMap_Rep.radio_audience))
      {
          //Select the delivery option radiobox
          sel.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
          //Wait for the page to load
          sel.waitForPageToLoad(VAR_MED_WAIT);
      }
      //Choose the delivery  option
         for (int i = 2; i<50; i=i+1){
              String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.delivery_text, i));                     if (str_var.equals(str_deliveryOption)){
                  sel.click(MessageFormat.format(EnvObjectMap_Rep.delivery_chk, i));
              break;
         }                            }
         //Click next button on Content Delivery option
         sel.click(EnvObjectMap_Rep.Btn_Next_Delivery);
         //wait for loading the page
         sel.waitForPageToLoad(VAR_MED_WAIT);  
         //Click Summary button on Program Assignment page
         sel.click(EnvObjectMap_Rep.Btn_Summary);
         //wait for loading the page
         sel.waitForPageToLoad(VAR_MED_WAIT);
      sel.click("makeMaster");
         //Click Finish button on program Summary page
         sel.click(EnvObjectMap_Rep.Btn_Finish_Program);
         sel.waitForPageToLoad(VAR_MED_WAIT);
      }
	 
	 public static void test_Live_audience(Selenium sel, String str_LiveProgName,String str_encName, String str_encProName, String str_slideName, String str_pollName, String str_surveyName, String str_audienceName) throws Exception {
			
	    	Utility_Functions utilityFunction = new Utility_Functions();	
	    	//Fetching values for Global Variables from XMl file
	    	String globalVariableFile ="Global_variables.xml";
	    	Date date=Calendar.getInstance().getTime();
	    	String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
	    	String VAR_endPointIP = utilityFunction.GetValue(globalVariableFile ,"VAR_endPointIP");
	    	String VAR_VRRname_NonPinProtected = utilityFunction.GetValue(globalVariableFile ,"VAR_VRRname_NonPinProtected");
	    	//Fetching values for local Variables from XMl file
	    	   	
	    	//Open the Programming menu
	    	sel.click(EnvObjectMap_Rep.Lnk_programming);
	    	//Open the Programs age
	    	sel.click(EnvObjectMap_Rep.LNK_Programs);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Add button 
	    	sel.click(EnvObjectMap_Rep.Btn_Add_Program);
	    	//Select the program type
	    	sel.addSelection(EnvObjectMap_Rep.SelectType_Program_Live, EnvObjectMap_Rep.Select_Program_Live);
	    	//Select the Live program
	    	sel.click(EnvObjectMap_Rep.LNK_Live_Broadcast);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	//Provide the Live Program Name
	    	sel.type(EnvObjectMap_Rep.TXT_Program_Name,str_LiveProgName);
	    	//Click Next button
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Prog_Info);
	    	//Wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	Thread.sleep(2000);
	    	
	    	if(sel.isElementPresent(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence))
	    	{
	    	sel.click(EnvObjectMap_Rep.lnk_deleteUpcomingOccurrence);
	    	}
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
	    	if(str_slideName!="")
	    	{
	        sel.click(EnvObjectMap_Rep.Btn_Select_Slides);
	    	//Wait
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_4", 300);
	    	sel.focus("dijit_layout__TabButton_4");
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	       	sel.focus("//div[@id='dijit_layout_ContentPane_12']/div[1]/input[1]");
	    	//provide Slide name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.SelectType_Search_Panel, str_slideName);
	    	//Click Search button 
	    	sel.click(EnvObjectMap_Rep.Btn_Search_Slides);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.LNK_Select_Slides, 300);
	    	//utilityFunction.waitForChangesToReflect();
	    	//Select Slides from Search results
	    	sel.click(EnvObjectMap_Rep.LNK_Select_Slides);
	    	//Click Save button
	    	sel.click(EnvObjectMap_Rep.Btn_Save_Slides);
	    	//wait for changing the phase
	    	utilityFunction.waitForChangesToReflect();	
	    	}
	    	
	    	if(str_pollName!="")
	    	{
	    	
	    	sel.click(EnvObjectMap_Rep.btn_selectPollLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_6", 300);
	    	//Move to the Search section
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.focus(EnvObjectMap_Rep.txt_searchPollLive);
	   // 	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	//provide Poll name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.txt_searchPollLive, str_pollName);
	    	//Click Search button 
	    	sel.click(EnvObjectMap_Rep.btn_searchPollLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lnk_selectSearchedPoll, 300);
	    	//utilityFunction.waitForChangesToReflect();
	    	//Select Slides from Search results
	    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedPoll);
	    	//Click next button on Program Content page           
	    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedPollLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForChangesToReflect();	
	    	}
	    	
	    	if(str_surveyName!="")
	    	{
	    	
	    	sel.click(EnvObjectMap_Rep.btn_selectSurveyLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, "dijit_layout__TabButton_8", 300);
	    	//Move to the Search section
	    	sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the searcg textbox
	    	sel.focus(EnvObjectMap_Rep.txt_searchSurveyLive);
	    //	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	//provide Poll name to Search it from Panel
	    	sel.type(EnvObjectMap_Rep.txt_searchSurveyLive, str_surveyName);
	    	//Click Search button 
	    	sel.click(EnvObjectMap_Rep.btn_searchSurveyLive);
	    	//wait for changing the phase
	    	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lnk_selectSearchedSurvey, 300);
	    	//utilityFunction.waitForChangesToReflect();
	    	//Select Slides from Search results
	    	sel.click(EnvObjectMap_Rep.lnk_selectSearchedSurvey);
	    	//Click next button on Program Content page           
	    	sel.click(EnvObjectMap_Rep.btn_selectedSearchedSurveyLive);
	    	//Click on checkbox
	    	
	    	}
	    	sel.click(EnvObjectMap_Rep.chk_questionBeforeBcast);
	    	sel.click(EnvObjectMap_Rep.chk_questionDuringBcast);
	    	sel.click(EnvObjectMap_Rep.chk_questionAskAnonymous);	
	    	//Click next button on Program Content page 
	    	//Click next button on Program Content page           
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
	    	sel.waitForPageToLoad("80000");
	    	//Select the delivery option radiobox
	    	
	    	
	    	sel.click(EnvObjectMap_Rep.radio_audience);
	    	
	    	
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	utilityFunction.waitForChangesToReflect();
	    	if 	(str_audienceName.equals(sel.getText(EnvObjectMap_Rep.audience_text1)))
	    	{
	    		System.out.println(sel.getText(EnvObjectMap_Rep.audience_text1));
	    		sel.click(EnvObjectMap_Rep.audience_chk1);
	    	}
	    	else
	    	{
	    		for (int i = 1; i<50; i=i+1)
	    		   {		   
	    			   String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.audience_text, i));
	    		    	System.out.println(str_var);	   
	    		    	if (str_var.equals(str_audienceName)){
	    		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.audience_chk, i));
	    	               break;
	    	          }                  
	    	       }
	    	}
	    	sel.focus("_eventId_next");
	    	utilityFunction.waitForChangesToReflect();
	    	sel.click(EnvObjectMap_Rep.Btn_Next_Content);
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
	    	sel.type(EnvObjectMap_Rep.SelectType_Search_Program ,str_LiveProgName);
	    	//click Search button 
	    	sel.click(EnvObjectMap_Rep.Btn_Search_Program);
	    	//wait for loading the page
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Check Point to test that program is created
	
	    	}
}
