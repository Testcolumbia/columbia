/*
* Classname                                                        Sm_vpv_027_VODConfiguredURL 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that Live program plays with WMS delivery option using RSS 4000 Version5. (Slide, Polls, Surveys, Questions)<br>
* What the script does:											    1.A domain say “domain_new” configured with Socail Viewer Portal should exist in vcc6.0.
*                                                                   2.A 'Configured URL' delivery option say 'Conf_URL' should exist in above domain.
*                                                                   3.A download and vod access point with 'Window Media' format should exist in above delivery option.
*                                                                   4.A On Demand Program say 'vod_1' should be created using above Configuration URL delivery option.															 
* What Verification it performs:	 								1.On Demand program should be played successfully in Window Media player with 'Configured URL' delivery option.
*                                                                   2.Correct stream should be displayed in .asx file.							
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_027_VODConfiguredURL extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}		
	}		
	public void test_Sm_vpv_027_VODConfiguredURL() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="SVP_Sm_vpv_027_VODConfiguredURL.xml";
			

			//Setup script variables file name
			String local_path ="Setup_Script.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
			
			// Variable for Inistance IP
			String VAR_InstanceIP=utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");
			
			String Var_StorageName=utilityFunction.GetValue(globalVariableFile ,"Var_StorageName");
			
			
			String VAR_streamingMediaRSSDisc = utilityFunction.GetValue(local_path,"VAR_streamingMediaRSSDisc");
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			
			
			
			
			String VAR_DeliveryName=utilityFunction.GetValue(localVariableFile ,"VAR_DeliveryName");
			
			String VAR_AccespointDownloadName=utilityFunction.GetValue(localVariableFile ,"VAR_AccespointDownloadName");
			
			String VAR_AccespointVODName=utilityFunction.GetValue(localVariableFile ,"VAR_AccespointVODName");
			
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			 String VAR_MIN_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
			 
			// Variable for program name
				String VAR_StreamingMedia=utilityFunction.GetValue(localVariableFile ,"streamingMedia_DisplayName");

				String streamingMedia_FileName = utilityFunction.GetValue(localVariableFile, "VAR_fileType");
			 
			 
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			
			//upload streaming Media
    Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, streamingMedia_FileName);
//			
			selenium.click(EnvObjectMap_Rep.Lnk_content);
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_addItem, 300);
			Thread.sleep(10000);
			Advance_Search.AdvanceSearch(selenium, VAR_StreamingMedia);
			
			selenium.click("link="+VAR_StreamingMedia);
			
			
			Thread.sleep(3000);
		String str_Filename=selenium.getText(EnvObjectMap_Rep.select_filename);
			System.out.println(str_Filename);
			
			//click on details
			selenium.click(EnvObjectMap_Rep.Btn_fileDetails);
			
			String Location=selenium.getText(EnvObjectMap_Rep.TXT_fileLocation);
			System.out.println(Location);
			
			//close the dialog
			selenium.click(EnvObjectMap_Rep.Btn_crossdialog);
			
			
			String accesspointurl="http://"+VAR_InstanceIP+"/"+Var_StorageName+"/"+Location+str_Filename;
			

			//******************************Create configured Delivery option****************************************
			selenium.click(EnvObjectMap_Rep.Lnk_delivery);
			selenium.click(EnvObjectMap_Rep.Lnk_deliveryOptions);
			
			
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_addDeliveryOption, 300);
			selenium.click(EnvObjectMap_Rep.Btn_addDeliveryOption);
			selenium.addSelection(EnvObjectMap_Rep.Lst_addDeliveryOption, EnvObjectMap_Rep.Lst_addDeliveryOption_Configured_URL);
			selenium.click(EnvObjectMap_Rep.Select_Configured_URLDOPT);
			selenium.waitForPageToLoad("30000");
			
			selenium.type(EnvObjectMap_Rep.Txt_ConfiguredURLname, VAR_DeliveryName);
			selenium.click(EnvObjectMap_Rep.Btn_AddAccessPoint);
			selenium.addSelection(EnvObjectMap_Rep.SelectType_AP, EnvObjectMap_Rep.Lst_AccespointDownload);
	
			selenium.click(EnvObjectMap_Rep.Select_AccespointDownload);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointname, VAR_AccespointDownloadName);
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointURL, accesspointurl);
			selenium.click(EnvObjectMap_Rep.Btn_AccessPointsubmit);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			selenium.click(EnvObjectMap_Rep.Btn_AddAccessPoint);
			selenium.addSelection(EnvObjectMap_Rep.SelectType_AP, EnvObjectMap_Rep.Lst_AccespointVOD);
			selenium.click(EnvObjectMap_Rep.Select_AccespointVOD);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointname, VAR_AccespointVODName);
			selenium.select(EnvObjectMap_Rep.Drp_AccessPointformat, EnvObjectMap_Rep.select_AccessPointformat);
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointURL, accesspointurl);
			selenium.click(EnvObjectMap_Rep.Btn_AccessPointsubmit);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			
			selenium.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
			
	//Create program----------------------------------------------------------
			
			
			
			selenium.click(EnvObjectMap_Rep.Lnk_programming);
			
			selenium.click(EnvObjectMap_Rep.Lnk_programs);
			
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			
			selenium.click(EnvObjectMap_Rep.Btn_Add_Program);
			
			//Select the On-demand Program
			selenium.addSelection(EnvObjectMap_Rep.SelectType_Program_Live, EnvObjectMap_Rep.lst_ondemand);
			selenium.click(EnvObjectMap_Rep.LNK_OnDemand);    	
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Provide the program name
			selenium.type(EnvObjectMap_Rep.txt_ProgramName, VAR_program);    	
	    	//Click on Next button
			selenium.click(EnvObjectMap_Rep.btn_Next_programPage);	
			selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	if(!selenium.isElementPresent(EnvObjectMap_Rep.radio_Immediately))
			{
	    		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
	    		selenium.waitForPageToLoad(VAR_MED_WAIT);
			}
	    	//Select the listing as Immediately
	    	selenium.click(EnvObjectMap_Rep.radio_Immediately);
	    	//Click on Next button
	    	selenium.click(EnvObjectMap_Rep.btn_Next_programPage);    	
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);    	
	    	//Click on Add Media button
	    	selenium.click(EnvObjectMap_Rep.btn_selectMedia);    	
	    	utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.lbl_browseMedia, 300);    	
	    	selenium.focus(EnvObjectMap_Rep.lbl_browseMedia);    	
	    	//Navigate to Search tab
	    	selenium.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the search textbox
	    	selenium.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	
	    	//Type the streaming media name
	    	selenium.type(EnvObjectMap_Rep.txt_SearchMedia, VAR_streamingMediaRSSDisc);
	    	//Click on Find button
	    	selenium.click(EnvObjectMap_Rep.btn_mediaSearch);
	    	
	    	utilityFunction.waitForChangesToReflect();
	    	//Select the searched media
	    	Thread.sleep(10000);
	    	selenium.click(EnvObjectMap_Rep.Lnk_selectMedia);
	    	//Move the selected file to selected List box
	    	selenium.click(EnvObjectMap_Rep.lnk_moveToSelected);
	    	//Click on Save button
	    	selenium.click(EnvObjectMap_Rep.btn_saveSelectedMedia);
	    	
	    	//wait for page to load
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Click on Next button
	    	selenium.click(EnvObjectMap_Rep.btn_Next_programPage);
	    	
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	     	if (selenium.isElementPresent(EnvObjectMap_Rep.radio_audience))
	    	{
	    		//Select the delivery option radiobox
	     		selenium.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
	     		selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	}     	
	     	
	     	 for (int i = 2; i<50; i=i+1){
	    	    	String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.delivery_text, i));
	    	    	System.out.println(str_var);	   
	    	    	if (str_var.equals(VAR_DeliveryName)){
	    	    		selenium.click(MessageFormat.format(EnvObjectMap_Rep.delivery_chk, i));
	                break;
	           }    
	     	 }
	     	//Click next button on Content Delivery option
	     	selenium.click(EnvObjectMap_Rep.Btn_Next_Delivery);    	
	    	//wait for loading the page
	     	selenium.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Summary button on Program Assignment page
	     	selenium.click(EnvObjectMap_Rep.Btn_Summary);
	    	//wait for loading the page
	     	selenium.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Finish button on program Summary page
	     	selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
	    	//wait for page to load
	    	utilityFunction.waitForChangesToReflect();		
	
		   //launch Social viewer portal
			
			Launch_VP.Launch_SVP(selenium, VAR_domain);
			
		    //call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_domain, VAR_program);
		    
		    String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
			utilityFunction.waitForChangesToReflect();
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");
			selenium.openWindow(contentlink_final+"&debug=true", "ASX");
		    selenium.selectWindow("ASX");
		    Thread.sleep(2000);
		    //Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
		    assertTrue("Sm_vpv_027"," On Demand program is played successfully using 'Window Media' format in VOD access point in 'Configured URL' delivery option \n Correct stream should be displayed in .asx file.",date,utilityFunction.assertTextContains(htmlsource, str_Filename));
			utilityFunction=null;
			selenium.close();
			selenium.selectWindow("null");
			
		   }
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			selenium.close();
			selenium.stop();
		}
	}
	
	
}
