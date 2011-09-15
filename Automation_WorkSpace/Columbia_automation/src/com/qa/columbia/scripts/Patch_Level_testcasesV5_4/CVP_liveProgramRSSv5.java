/*
* Classname                                                        CVP_liveProgramRSSv5 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_liveProgramRSSv5 extends TesterAsserter {
	
	static boolean flag = false;
	
	public void setUp() throws Exception {
		
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
	}		
	public void test_CVP_liveProgramRSSv5() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file name
			String local_path = "CVP_liveProgramRSSv5.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the viewer portal URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path, "Var_Columbia_vpURL");
			//Variable for the WMS name
			String VAR_WMSName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//Variable for the host IP
			String VAR_WMSHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			
            String VAR_RSSv5EncoderName = utilityFunction.GetValue(str_path ,"VAR_RSSv5EncoderName");
			
			//Variable for the encoder profile name
			String VAR_RSSv5EncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_RSSv5EncoderProfileName");
			//Variable for the Live Program name			
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the name of the archive file created for the live program
			String Var_ArchiveOfLiveProgram = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveProgram");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			
			 String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");			
				
				String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
				
				String VAR_PollName = utilityFunction.GetValue(str_path,"VAR_PollName");
			//Reusable action for login to VCC
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Reusable action for creating WMS 
									
			
			//Reusable action for creating live program having slide, poll, survey and question option defined
			Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_RSSv5EncoderName, VAR_RSSv5EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_WMSName);
			//Reusable action for Launching LBC and start the broadcast
			Launch_LBC.test_LaunchLBC(selenium, "CVP_liveProgramRSSv5", Var_LiveProgramName, Var_ArchiveOfLiveProgram);
			//Select the admin portal window
		    selenium.selectWindow("null");
			//Click on Domain name link to launch the viewer portal
			selenium.click("link=" + VAR_DomClassic);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//select the viewer portal window
			selenium.selectWindow("Qumu Program Browser Home");
			//Click on the live program link
			selenium.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + Var_LiveProgramName);
			//wait for page load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Get html source of the page
	       	String htmlsource = selenium.getHtmlSource();
        	int start_URL = htmlsource.indexOf("player.do");
       	    int end_URL = htmlsource.indexOf(VAR_RSSv5EncoderProfileName); 
           	String stream_URL = htmlsource.substring(start_URL, end_URL);
        	int stream_URL_length = stream_URL.length();
        	stream_URL = stream_URL.substring(0, stream_URL_length-16);
        	String VPURL = Var_Columbia_vpURL+VAR_DomClassic+"/"+stream_URL;
        	selenium.open(VPURL);
        	selenium.waitForPageToLoad("50000");
        	//selenium.open("http://10.1.202.130/viewerportal/domain_old/"+stream_URL);
        	//wait for the poll window
        	selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "80000");
        	//select the poll window
			selenium.selectWindow("name="+EnvObjectMap_Rep.window_pollCVP);
			//Selec the answer option
			selenium.click(EnvObjectMap_Rep.poll_answerOptionCVP);
			//Click on submit button
			selenium.click(EnvObjectMap_Rep.poll_answerSubmitCVP);
			//wait
			utilityFunction.waitForChangesToReflect();
			//check point for successfull poll submission
			assertTrue("CVP_liveProgramRSSv5","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
			//Close the poll window
			selenium.close();
			//Select the player window
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

			assertTrue("CVP_liveProgramRSSv5", "Verify that user is able to push the results to the viewer portal", date, true);
			
		      selenium.close();
		      //-----------------------------------------
		      selenium.selectWindow("Qumu Program Player");
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
			assertTrue("CVP_liveProgramRSSv5","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_RSSv5EncoderProfileName));
			assertTrue("CVP_liveProgramRSSv5","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
			assertTrue("CVP_liveProgramRSSv5","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + VAR_WMSHost +"/WMSControl/"));
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
			selenium.selectWindow("null");
			//Select the LBC
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }		
			//Click on Broadcast control tab
			selenium.click(EnvObjectMap_Rep.tab_broadcastControlLBC);
			//Checkpoint to verify that audience question is displayed successfully on the LBC
			assertTrue("CVP_liveProgramRSSv5","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			utilityFunction.waitForChangesToReflect();			
			utilityFunction.waitForTextToPresent(selenium, "(none)|Archive files fetched.|Completed", 300);
			assertTrue("CVP_archiveRSSv5", "Verify that archiving is displayed as successfull under LBC", date, selenium.isTextPresent("(none)|Archive files fetched.|Completed"));
			selenium.close();
			selenium.selectWindow("null");
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			selenium.waitForPageToLoad("50000");
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			utilityFunction.waitForChangesToReflect();
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_ArchiveOfLiveProgram);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();		
			assertTrue("CVP_archiveRSSv5","Verify that ingest for the archive media created using Live program(RSS4000v5) is completed successfully.",date,selenium.isTextPresent(Var_ArchiveOfLiveProgram));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				 selenium.stop();
			}
		}					 
	}
}
