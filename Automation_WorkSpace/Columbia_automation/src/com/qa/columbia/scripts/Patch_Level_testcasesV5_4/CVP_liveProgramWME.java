/*
* Classname                                                        CVP_liveProgramWME 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Live program plays with WMS delivery option using WME. (Slide, Polls, Surveys, Questions)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and create a WMS delivery option<br> 
*																	>Navigate to Encoders and add a Windows Media Encoder<br> 
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
* What Verification it performs:	 								1.Verify that Live program plays with WMS delivery option using Windows Media Encoder. (Slide, Polls, Surveys, Questions)<br> 																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_liveProgramWME extends TesterAsserter {
	
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
	public void test_CVP_liveProgramWME() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			String local_path = "CVP_liveProgramWME.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
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
			//Variable for the wms HTTP port
			
			String VAR_WMEEncodername = utilityFunction.GetValue(str_path ,"VAR_Encodername");
			
			String VAR_WMEEncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_EncoderProfileName");
			
			String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");			
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
			
			String VAR_PollName = utilityFunction.GetValue(str_path,"VAR_PollName");
		
						
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archived media name
			String VAR_archiveMediaName = utilityFunction.GetValue(local_path, "VAR_archiveMediaName");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for Login to VCC
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
	
			//Create Live program			
			//Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_WMEEncodername, VAR_WMEEncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_WMSName);
			
			
			//Open the Programs age
			selenium.click(EnvObjectMap_Rep.LNK_Programs);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program, Var_LiveProgramName);
			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Click Live Broadcast icon
			selenium.click(EnvObjectMap_Rep.LNK_LBC);
         	//Click Launch Broadcast Now
			selenium.click(EnvObjectMap_Rep.LNK_Launch_Now);
			for (String windowName1 : selenium.getAllWindowNames()) {
				if (windowName1.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.waitForPopUp(windowName1, VAR_MED_WAIT);
				}
	        }
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_ArchiveLBC))
			{
				selenium.click(EnvObjectMap_Rep.chk_ArchiveLBC);
			}
			selenium.type("//tbody[2]/tr/td[2]/input", VAR_archiveMediaName);
			//Click Save button on LBC
			selenium.click(EnvObjectMap_Rep.Btn_Save_LBC_Summary);
			//wait for changing the phase
			utilityFunction.waitForChangesToReflect();
			//Click Start Sources button
			selenium.click(EnvObjectMap_Rep.Btn_Start_Source);
			//wait for changing the phase
			for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isVisible(EnvObjectMap_Rep.Btn_Prov_Network)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Click Provision Network button
			selenium.click(EnvObjectMap_Rep.Btn_Prov_Network);
			//wait for changing the phase
			for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isVisible(EnvObjectMap_Rep.Btn_Start_Bcast)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Click Start Broadcast button
			selenium.click(EnvObjectMap_Rep.Btn_Start_Bcast);
			//wait for changing the phase

				for (int second = 0;; second++) {
					if (second >= 300) fail("timeout");
					try { if (selenium.isVisible(EnvObjectMap_Rep.btn_stopBroadcast)) break; } catch (Exception e) {}
					Thread.sleep(1000);
			//}
			}
		    //Check Point to test that Live Broadcast is started
			assertTrue("CVP_liveProgramWME","Verify that Live Broadcast is started successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_stopBroadcast));
			//Click Start Broadcast button on LBC
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
			{
				selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
				utilityFunction.waitForChangesToReflect();
				assertTrue("CVP_liveProgramWME","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
			}			
			
			
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
       	    int end_URL = htmlsource.indexOf(VAR_WMEEncoderProfileName); 
           	String stream_URL = htmlsource.substring(start_URL, end_URL);
        	int stream_URL_length = stream_URL.length();
        	stream_URL = stream_URL.substring(0, stream_URL_length-16);
        	String VPURL = Var_Columbia_vpURL+VAR_DomClassic+"/"+stream_URL;
        	selenium.open(VPURL);
        	selenium .waitForPageToLoad("50000");
			//Select the player window
			selenium.selectWindow("Qumu Program Player");
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
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
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//Path to store the screenshot of the player window
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
			selenium.captureScreenshot(screenShot_locPath); 		
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }	
			selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
		
		//	selenium.selectWindow("Qumu Program Browser Home");
        	//wait for the poll window
        	selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "250000");
        	//select the poll window
			selenium.selectWindow("name="+EnvObjectMap_Rep.window_pollCVP);
			//Selec the answer option
			selenium.click(EnvObjectMap_Rep.poll_answerOptionCVP);
			//Click on submit button
			selenium.click(EnvObjectMap_Rep.poll_answerSubmitCVP);
			//wait
			utilityFunction.waitForChangesToReflect();
			//check point for successfull poll submission
			assertTrue("CVP_liveProgramWME","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
			//Close the poll window
			selenium.close();
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

			assertTrue("CVP_liveProgramWME", "Verify that user is able to push the results to the viewer portal", date, true);
			
		      selenium.close();
		      //-----------------------------------------
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
			assertTrue("CVP_liveProgramWME","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_WMEEncoderProfileName));
			assertTrue("CVP_liveProgramWME","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
			assertTrue("CVP_liveProgramWME","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + VAR_WMSHost +"/WMSControl/qumu_"));
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
			assertTrue("CVP_liveProgramWME","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			
			//wait
			utilityFunction.waitForChangesToReflect();
			//wait for the ingest to complete
			for (int second = 0;; second++) {
				if (second >= 700) fail("timeout");
				try { if (selenium.isTextPresent("(none)|Archive files fetched.|Completed")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Close the LBC
			selenium.close();
			//Select the main window
			selenium.selectWindow("null");
			//wait
			utilityFunction.waitForChangesToReflect();
			//Click on Content
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//wait for the page to load
			selenium.waitForPageToLoad("50000");
			utilityFunction.waitForChangesToReflect();
			//click on advanced search
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Provide the archived media name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,VAR_archiveMediaName);
			//select the upload status as Active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();		
			assertTrue("CVP_ArchiveWME","Ensure that ingest completes for archived content of Live program played with WMS delivery option using WME.",date,selenium.isTextPresent(VAR_archiveMediaName));
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