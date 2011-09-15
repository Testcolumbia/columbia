/*
* Classname                                                        Sm_vpc_023_LiveProgram_Audience_ConfiguredURL 
*
* Version info
*
* Copyright notice
*                                                                 1.A domain say “domain_new” configured with Viewer Portal Classic should exist in vcc6.0.
                                                                  2.A 'Configured URL' delivery option say 'Conf_URL' should exist in above domain.
                                                                  3. Above 'Configured URL' should be added in an Audience say 'audi1' in above domain.
                                                                  4.A download and Live access point should exist in above delivery option.
                                                                  5.4.A Live Program say 'Live_1' should be created using above Configuration URL delivery option.
                                                                  6.Prerequisite 'Live_1' program should be broadcasting.
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


import java.util.Calendar;
import java.util.Date;


import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.Create_Audience;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_023_LiveProgram_Audience_ConfiguredURL extends TesterAsserter {
	
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
	public void test_Sm_vpc_023_LiveProgram_Audience_ConfiguredURL() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="CVP_Sm_vpc_023_LiveProgram_Audience_ConfiguredURL.xml";
			
			//Setup script variables file name
			String local_path ="Setup_Script.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			
			// Variable for Inistance IP
			String VAR_InstanceIP=utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");
			
			String Var_StorageName=utilityFunction.GetValue(globalVariableFile ,"Var_StorageName");
			String VAR_audienceName = utilityFunction.GetValue(localVariableFile ,"VAR_audienceName");
			String VAR_audienceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_audienceIP");
			String VAR_audienceHost = utilityFunction.GetValue(globalVariableFile ,"VAR_audienceHost");
			String VAR_audiencePort = utilityFunction.GetValue(globalVariableFile ,"VAR_audiencePort");
			
			String VAR_httpName = utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			
			
			// Variable for streaming media file name
			String VAR_StreamingMedia=utilityFunction.GetValue(localVariableFile ,"VAR_StreamingMedia");
			
			// Variable for source content file name used for uploading
			String VAR_sourceContentfile=utilityFunction.GetValue(localVariableFile ,"VAR_sourceContentFile");
			
			String VAR_DeliveryName=utilityFunction.GetValue(localVariableFile ,"VAR_DeliveryName");
			
			String VAR_AccespointDownloadName=utilityFunction.GetValue(localVariableFile ,"VAR_AccespointDownloadName");
			
			
		
			 String VAR_MIN_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
			 
			 String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");	
			
				
				//Variable for the Encoder Name
				 String VAR_WMEEncodername = utilityFunction.GetValue(local_path ,"VAR_WMEName");
				//Variable for the saved encoder profile file name (with path)
				String VAR_WMEEncoderProfileName= utilityFunction.GetValue(local_path ,"Var_WMEProName");
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			
			//upload the streaming Media content for get the location for the congigured Stream
			Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, VAR_sourceContentfile);
			
			
			selenium.click(EnvObjectMap_Rep.Lnk_content);
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_addItem, 300);
			Thread.sleep(10000);
			Advance_Search.AdvanceSearch(selenium, VAR_StreamingMedia);
			
			selenium.click("link="+VAR_StreamingMedia);
			
			
			Thread.sleep(3000);
		String Filename=selenium.getText(EnvObjectMap_Rep.select_filename);
			System.out.println(Filename);
			
			//click on details
			selenium.click(EnvObjectMap_Rep.Btn_fileDetails);
			
			String Location=selenium.getText(EnvObjectMap_Rep.TXT_fileLocation);
			System.out.println(Location);
			
			//close the dialog
			selenium.click(EnvObjectMap_Rep.Btn_crossdialog);
			
			
			String str_accesspointurl="http://"+VAR_InstanceIP+"/"+Var_StorageName+"/"+Location+Filename;
			

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
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointURL, str_accesspointurl);
			selenium.click(EnvObjectMap_Rep.Btn_AccessPointsubmit);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			

			selenium.click(EnvObjectMap_Rep.Btn_AddAccessPoint);
		selenium.addSelection(EnvObjectMap_Rep.SelectType_AP, EnvObjectMap_Rep.Lst_AccespointLive);
			
			selenium.click(EnvObjectMap_Rep.Select_AccespointLive);
			selenium.waitForPageToLoad("30000");
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointname, "live");
			selenium.select(EnvObjectMap_Rep.Drp_AccessPointformat, EnvObjectMap_Rep.select_AccessPointformat);
			
			selenium.type(EnvObjectMap_Rep.Txt_AccessPointURL, str_accesspointurl);
		selenium.click(EnvObjectMap_Rep.Btn_AccessPointsubmit);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			
			selenium.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
			
			//Create Audience
			
		Create_Audience.test_Create_Audience(selenium, VAR_audienceName, VAR_audienceHost, VAR_audienceIP, VAR_audiencePort, VAR_httpName, VAR_httpName, VAR_DeliveryName);
			
	//Create program with audience----------------------------------------------------------
			
		Create_Program.test_Live_audience(selenium, VAR_program, VAR_WMEEncodername, VAR_WMEEncoderProfileName, "", "", "",VAR_audienceName);
			
		  	assertTrue("","Verify that Live Program is created successfully.",date,selenium.isTextPresent(VAR_program));

	//Launch Broadcast
			Launch_LBC.StartBroadcast(selenium, VAR_program);
			//call to Launch classic view portal
			 Launch_VP.Launch_CVP(selenium, VAR_domain);
			 
			 selenium.selectWindow("Qumu Program Browser Home");
			 utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_home, 300);
				
			 
			  selenium.click(EnvObjectMap_Rep.LNK_program);
			  Thread.sleep(2000);
			  
			  selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, VAR_program);
			 selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);
			 
			utilityFunction.waitForChangesToReflect();	
			
		
		selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_program);
		Thread.sleep(20000);
		selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_WMEEncoderProfileName);
		
		utilityFunction.waitForChangesToReflect();	
	    //Capture the screenshot at the specified path
		String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_program + ".jpg";		
		//Capture the screen shot of the program
	    selenium.captureScreenshot(screenShot_locPath);   		
	    selenium.selectWindow("Qumu Program Player");
		//Maximize the window
		selenium.windowMaximize();
		String loca=selenium.getLocation();  
		System.out.println(loca);
		
		String[] temp;   
		String delimiter = "\\?";
		temp = loca.split(delimiter); 
		/* print substrings */ 
		for(int i =0; i < temp.length ; i++)  { 
			System.out.println(temp[i]);
			
			if(temp[i]==temp[0])
			{
			
			}
			else
			{
			 String test=temp[1];
			 
			 System.out.println(test);
			//Get the html source
			String htmlsource = selenium.getHtmlSource();
			int start_URL = htmlsource.indexOf("http://"+VAR_InstanceIP);
			System.out.println(start_URL);
			int end_URL = htmlsource.lastIndexOf(test);	    
			System.out.println(end_URL);
			String stream_URL1 = htmlsource.substring(start_URL, end_URL);
			int stream_URL_length = stream_URL1.length();
			String stream_URL = stream_URL1.substring(0, stream_URL_length-1);
			System.out.println(stream_URL+"?"+test);	
			
			//Open the stream URL in the browser
			selenium.open(stream_URL+"?"+test+ "&debug=true");
			selenium.waitForPageToLoad("90000");
			
			}
		}
				
		//get the html source code
		String htmlsource1 = selenium.getHtmlSource();		
		//Ensure that source content file is displayed in source
		assertTrue("Sm_vpc_023","Verify that asx file for live program is generated successfully for classic view portal\n Live program is played successfully using 'Configured URL' delivery option while added in Audience.",date,utilityFunction.assertTextContains(htmlsource1, str_accesspointurl));
	
		
		selenium.close();
		selenium.selectWindow("null");
		Launch_LBC.StopBroadcast(selenium, VAR_program);	
		selenium.close();
		utilityFunction=null;
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
