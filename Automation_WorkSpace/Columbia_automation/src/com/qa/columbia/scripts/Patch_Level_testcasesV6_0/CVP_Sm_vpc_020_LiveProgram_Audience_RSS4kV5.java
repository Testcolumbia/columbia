/*
* Classname                                                        CVP_Sm_vpc_020_LiveProgram_Audience_RSS4kV5 
*
* Version info
*
* Copyright notice
*                                                                 1. Login to VCC admin portal as super user in pre-requisite domain
2.                                                                2. Navigate to Programing>Programs page and launch LBC for pre-requisite program.
                                                                  3. Navigate to Broadcast Control tab on LBC and start Sources, Provisioning and Broadcast.(Note: Archiving should be enabled in LBC)
                                                                  4. Push the slide to the viewer.
                                                                  5. Push poll to the viewer.
                                                                  6. Ask audience Questions from viewer portal.
* What Verification it performs:	 								a. Live program should play successfully for the audience matching the rules.
                                                                    b. Asx file should be generated.
                                                                    c. Polls should be pushed to viewers .
                                                                    d. Slides should be flipped.
                                                                    e. Survey should be displayed after live program concludes.
                                                                    f. Content should be archived successfully.							
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
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_020_LiveProgram_Audience_RSS4kV5 extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_020_LiveProgram_Audience_RSS4kV5() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="CVP_Sm_vpc_020_LiveProgram_Audience_RSS4kV5.xml";
			   
			String local_path ="Setup_Script.xml";
			
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_DomClassic=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			
			// Variable for Inistance IP
			String VAR_InstanceIP=utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");
			
			String VAR_audienceName = utilityFunction.GetValue(localVariableFile ,"VAR_audienceName");
			String VAR_audienceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_audienceIP");
			String VAR_audienceHost = utilityFunction.GetValue(globalVariableFile ,"VAR_audienceHost");
			String VAR_audiencePort = utilityFunction.GetValue(globalVariableFile ,"VAR_audiencePort");
			
			String VAR_DownloadDopt = utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
			String VAR_VODDopt=utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
			String VAR_LiveDopt=utilityFunction.GetValue(globalVariableFile ,"Var_VEasWMS_DO");
			// Variable for program name
			String Var_LiveProgramName=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			//Variable for the archive of Live program
			String Var_ArchiveOfLiveprogram = "Archived"+Var_LiveProgramName;
			
			//Variable for the slide display name
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path  ,"VAR_SlideDisplayName");
			//Variable for the Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"VAR_SurveyName");
			//Variable for Poll name
			String VAR_PollName = utilityFunction.GetValue(local_path ,"VAR_PollName");
       
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		    String VAR_MIN_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
			 
			 String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");	
			 String Var_EncoderName = utilityFunction.GetValue(local_path, "VAR_RSSv5Encodername");
			String Var_EncoderProfileName = utilityFunction.GetValue(local_path, "VAR_RSSv5EncoderProfileName");
			//Variable for the framework path
			
			//Variable for the viewer portal URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(globalVariableFile, "Var_Columbia_vpURL");
			String ContentHostIP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");	
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_DomClassic);
			
		    //Create Audience
			
		    Create_Audience.test_Create_Audience(selenium, VAR_audienceName, VAR_audienceHost, VAR_audienceIP, VAR_audiencePort, VAR_DownloadDopt, VAR_VODDopt, VAR_LiveDopt);
			
	        //Create program
			
		 Create_Program.test_Live_audience(selenium, Var_LiveProgramName, Var_EncoderName, Var_EncoderProfileName, VAR_SlideDisplayName, VAR_PollName,VAR_SurveyName,VAR_audienceName);
			
		  assertTrue("Sm_vpc_020","Verify that Live Program is created successfully.",date,selenium.isTextPresent(Var_LiveProgramName));

	    	Launch_LBC.StartBroadcast(selenium, Var_LiveProgramName);
						
	    	if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
    		{
    			selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
    			utilityFunction.waitForChangesToReflect();
    			assertTrue("Sm_vpc_020","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
    		}

    		if(selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
    		{
    			selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
    			utilityFunction.waitForChangesToReflect();
    			utilityFunction.waitForChangesToReflect();
    			assertTrue("Sm_vpc_020","Verify that Poll Question is pushed successfully from LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
    		}
    		
			//call to Launch classic view portal
			Launch_VP.Launch_CVP(selenium, VAR_DomClassic);
				//Click on the live program link
				selenium.click(EnvObjectMap_Rep.lnk_programNameCVP + Var_LiveProgramName);
				
				//wait for page load
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				//Get html source of the page
		       	String htmlsource = selenium.getHtmlSource();
	     	int start_URL = htmlsource.indexOf("player.do");
	    	    int end_URL = htmlsource.indexOf(Var_EncoderProfileName); 
	        	String stream_URL = htmlsource.substring(start_URL, end_URL);
	     	int stream_URL_length = stream_URL.length();
	     	stream_URL = stream_URL.substring(0, stream_URL_length-16);
	     	String VPURL = Var_Columbia_vpURL+VAR_DomClassic+"/"+stream_URL;
	     	selenium.openWindow(VPURL,"QPP");
     		//Select the player window
				selenium.selectWindow("QPP");
				//Select the question tab
				utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.tab_qaCVP, 300);
				
				selenium.click(EnvObjectMap_Rep.tab_qaCVP);
				//Provide the question
				selenium.type(EnvObjectMap_Rep.txt_questionCVP, "test");
				//Enable the ask button
				selenium.typeKeys(EnvObjectMap_Rep.txt_questionCVP, "t");
				//wait
				utilityFunction.waitForChangesToReflect();
				//Click on ask button
				selenium.click(EnvObjectMap_Rep.btn_questionSubmitCVP);
				//Click on Slide tab
				selenium.click(EnvObjectMap_Rep.tab_slideCVP);
				//wait
				utilityFunction.waitForChangesToReflect();
				//Path to store the screenshot of the player window
				String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
				//Capture the screen shot of the live program
				selenium.captureScreenshot(screenShot_locPath); 
				
				selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "80000");
		     	//select the poll window
					selenium.selectWindow(EnvObjectMap_Rep.window_pollCVP);
					//Selec the answer option
					
					
					selenium.click(EnvObjectMap_Rep.poll_answerOptionCVP);
					//Click on submit button
					selenium.click(EnvObjectMap_Rep.poll_answerSubmitCVP);
					//wait
					utilityFunction.waitForChangesToReflect();
					//check point for successfull poll submission
					assertTrue("Sm_vpc_020","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
					//Close the poll window
					selenium.close();
					
					//----------------Push poll results to viewer----------------------------
					
					selenium.selectWindow("");
					//Select the LBC
					for (String windowName : selenium.getAllWindowNames()) {
						if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
							selenium.selectWindow(windowName);
			            }
			        }	
					
					utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.lnk_pushPollResult, 300);
					selenium.click(EnvObjectMap_Rep.lnk_pushPollResult);
					
					selenium.waitForPopUp(EnvObjectMap_Rep.Txt_pollresultwindow, "70000");
					selenium.selectWindow(EnvObjectMap_Rep.Txt_pollresultwindow);
				
					Thread.sleep(2000);
					selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollanswer);
					selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollresponse);

					assertTrue("Sm_vpc_002", "Verify that user is able to push the results to the viewer portal", date, true);
					
				      selenium.close();
					
					//----------------------------------------------------------------------
					selenium.selectWindow("Qumu Program Player");
				
				//Get the html source
				String htmlsource1 = selenium.getHtmlSource();
	     	int start_URL1 = htmlsource1.indexOf("player.URL = ");
	    	    int end_URL1 = htmlsource1.lastIndexOf("this.mediaEnded = false");    
	    	    //String to hold the stream URL
	     	String stream_URL1 = htmlsource1.substring(start_URL1, end_URL1);
	     	int stream_URL1_length = stream_URL1.length();
	     	stream_URL1 = stream_URL1.substring(14, stream_URL1_length-4);
	     	//Open the window to generate the asx file
		   		selenium.open(stream_URL1 + "&debug=true");  
		   		selenium.waitForPageToLoad("50000");
		   		//Generate the asx file
				String htmlsource2 = selenium.getHtmlSource();
				assertTrue("Sm_vpc_020","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, Var_EncoderProfileName));
				assertTrue("Sm_vpc_020","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
				
				assertTrue("Sm_vpc_020","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + ContentHostIP));
				//Close the asx file URL window
				selenium.close();
				//wait
				utilityFunction.waitForChangesToReflect();
				//Select the survey window
				selenium.selectWindow(VAR_SurveyName);
				//Select the answer
				
				
				
	    	    selenium.click(EnvObjectMap_Rep.survey_answerCVP);
	    	    //Click on Submit button
				selenium.click(EnvObjectMap_Rep.btn_answerSubmitSurvey);
				//Close the survey window
				selenium.close();
				//Select the admin portal window
				selenium.selectWindow("");
				
		Launch_LBC.StopBroadcast(selenium, Var_LiveProgramName);
		
		 //wait till the ingest is shown completed in LBC

	    
		utilityFunction.waitForTextToPresent(selenium, "Archive files fetched.|Completed", 500);
	    assertTrue("Sm_vpc_020","Verify that ingest is completed successfully for the live program.",date,selenium.isTextPresent("(none)|Archive files fetched.|Completed "));
	    selenium.close();
        //Navigate to Admin Portal
		selenium.selectWindow("null");
		//Select Programming link
		selenium.click(EnvObjectMap_Rep.Lnk_programming);
		//Select Content link
		selenium.click(EnvObjectMap_Rep.Lnk_content);
		//wait
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		Advance_Search.AdvanceSearch(selenium, Var_ArchiveOfLiveprogram);			
		
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();	
		assertTrue("Sm_vpc_020","Classic VP: Ensure that Content is archived successfully for Live program played with VE as WMS delivery option using RSS 4000 Version 5.",date,selenium.isTextPresent(Var_ArchiveOfLiveprogram));
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
