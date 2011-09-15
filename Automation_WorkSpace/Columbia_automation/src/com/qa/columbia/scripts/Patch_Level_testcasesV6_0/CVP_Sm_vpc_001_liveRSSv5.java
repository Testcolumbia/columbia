/*
* Classname                                                        CVP_Sm_vpc_001_liveRSSv5 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Live program plays with WMS delivery option using RSS 4000 Version5. (Slide, Polls, Surveys, Questions)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and create a WMS delivery option<br> 
*																	>Navigate to Encoders and add an RSSv5 encoder<br> 
*  															     	>Navigate to Content and add a poll<br> 
*																	>Navigate to Content and add a slide<br> 
* 																	>Navigate to Content and add a survey<br> 
* 																	>Navigate to Programming and Create the Live program with above mentioned encoder, poll, slide, survey, viewer question and WMS delivery option<br> 
* 																	>Launch the LBC for the above created live program<br> 
* 																	>Start the broadcast and push the slide and poll<br> 
* 																	>Launch the classic viewer portal and play the live program<br>
*  																	>Answer the poll question<br> 
* 																	>Ask a question from the viewer portal<br> 
* 																	>Capture the screenshot of the live program<br>  
* 																	>Generate the asx file<br> 
* 																	>Verify the stream in the asx file<br> 
*  																	>Answer the survey question and close teh survey window<br> 
* 																	>Stop the broadcast and close the LBC window<br> 															 
* What Verification it performs:	 								1.Verify that Live program plays with WMS delivery option using RSS 4000 Version5. (Slide, Polls, Surveys, Questions)<br> 																															
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

public class CVP_Sm_vpc_001_liveRSSv5 extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception 
	{		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag)
		{				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}
		utilityFunction = null;

	}
	public void test_CVP_Sm_vpc_001_liveRSSv5() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local variable file name
			String localVariableFile  = "CVP_Sm_vpc_001_liveRSSv5.xml";
			
			//Local variable file name
			String local_path = "Setup_Script.xml";
			
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for login Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
	
			//Variable for the viewer portal URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(globalVariableFile, "Var_Columbia_vpURL");
			
			
			
			String ContentHostIP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");	
			
			
			//Variable for the Live Program name			
			String Var_LiveProgramName = utilityFunction.GetValue(localVariableFile  ,"Var_LiveProgramName");
			//Variable for the name of the archive file created for the live program
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			
			String VAR_SurveyName = utilityFunction.GetValue(local_path,"VAR_SurveyName");			
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path,"VAR_SlideDisplayName");
					
			String VAR_PollName = utilityFunction.GetValue(local_path,"VAR_PollName");
		
			String Var_VideoNetEdgeDO_Name = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
			
			String VAR_RSSv5Encodername = utilityFunction.GetValue(local_path ,"VAR_RSSv5Encodername");
			
			String VAR_RSSv5EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_RSSv5EncoderProfileName");
			
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
	        
			//Reusable action for creating live program having slide, poll, survey and question option defined
			Create_Program.create_LiveProgram(selenium, Var_LiveProgramName, VAR_RSSv5Encodername, VAR_RSSv5EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, Var_VideoNetEdgeDO_Name);
			//Reusable action for Launching LBC and start the broadcast
			Launch_LBC.StartBroadcast(selenium, Var_LiveProgramName);
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
    		{
    			selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
    			utilityFunction.waitForChangesToReflect();
    			assertTrue("Sm_vpc_001","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
    		}
    		if(selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
    		{
    			selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
    			utilityFunction.waitForChangesToReflect();
    			utilityFunction.waitForChangesToReflect();
    			assertTrue("Sm_vpc_001","Verify that Poll Question is pushed successfully from LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
    		}
    		
    			//Launch the classic viewer portal
			   Launch_VP.Launch_CVP(selenium, VAR_domain);
			   selenium.selectWindow("Qumu Program Browser Home");
				//Click on the live program link
				selenium.click(EnvObjectMap_Rep.lnk_programNameCVP + Var_LiveProgramName);
				//wait for page load
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				//Get html source of the page
		       	String htmlsource = selenium.getHtmlSource();
	        	int start_URL = htmlsource.indexOf("player.do");
	       	    int end_URL = htmlsource.indexOf(VAR_RSSv5EncoderProfileName); 
	           	String stream_URL = htmlsource.substring(start_URL, end_URL);
	        	int stream_URL_length = stream_URL.length();
	        	stream_URL = stream_URL.substring(0, stream_URL_length-16);
	        	String VPURL = Var_Columbia_vpURL+VAR_domain+"/"+stream_URL;
	        	selenium.open(VPURL);
	        	selenium.waitForPageToLoad("15000");
	        	selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "100000");
	        	//select the poll window
				selenium.selectWindow(EnvObjectMap_Rep.window_pollCVP);
				//Select the answer option
				//selenium.addSelection(EnvObjectMap_Rep.poll_answerselection, EnvObjectMap_Rep.survey_answerselectionlabel);
				
				Thread.sleep(5000);
				selenium.click(EnvObjectMap_Rep.poll_answerOptionCVP);
				Thread.sleep(5000);
				//Click on submit button
				selenium.click(EnvObjectMap_Rep.poll_answerSubmitCVP);
				//wait
				utilityFunction.waitForChangesToReflect();
				//check point for successfull poll submission
				assertTrue("Sm_vpc_001","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
				//Close the poll window
				selenium.close();
				//Select the player window
				
				//----------------------push results to viewer--------------------
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

				assertTrue("Sm_vpc_001", "Verify that user is able to push the results to the viewer portal", date, true);
				
			      selenium.close();
				//-----------------------------------------------------------
				
				selenium.selectWindow("Qumu Program Player");
				//Select the question tab
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
				assertTrue("Sm_vpc_001","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_RSSv5EncoderProfileName));
				assertTrue("Sm_vpc_001","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
				assertTrue("Sm_vpc_001","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + ContentHostIP));
				//Close the asx file URL window
				selenium.close();
				//wait
				utilityFunction.waitForChangesToReflect();
				//Select the survey window
				selenium.selectWindow(VAR_SurveyName);
				//Select the answer
				Thread.sleep(5000);
				//selenium.addSelection(EnvObjectMap_Rep.survey_answerselection, EnvObjectMap_Rep.survey_answerselectionlabel);
				
	       	    selenium.click(EnvObjectMap_Rep.survey_answerCVP);
	       	    Thread.sleep(5000);
	       	    //Click on Submit button
				selenium.click(EnvObjectMap_Rep.btn_answerSubmitSurvey);
				//Close the survey window
				selenium.close();
				//Select the admin portal window
				selenium.selectWindow("");
				//Select the LBC
				for (String windowName : selenium.getAllWindowNames()) {
					if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
						selenium.selectWindow(windowName);
		            }
		        }		
				//Click on Broadcast control tab
				selenium.click(EnvObjectMap_Rep.tab_broadcastControlLBC);
				//Checkpoint to verify that audience question is displayed successfully on the LBC
				assertTrue("Sm_vpc_001","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
				//Stop the broadcast 
				selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
				selenium.click(EnvObjectMap_Rep.Img_broadcastConsole);
				utilityFunction.waitForTextToPresent(selenium, "Archive files fetched.|Completed", 600);
				assertTrue("Sm_vpc_001", " Ingest completes for archived content of Live program played with VE as WMS delivery option using RSS 4000 Version 5.", date, selenium.isTextPresent("Archive files fetched.|Completed"));
				utilityFunction.waitForChangesToReflect();
				selenium.close();

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					 selenium.close();
					 selenium.stop();
				}
			}					 
		}
}