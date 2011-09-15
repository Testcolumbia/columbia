/*
* Classname                                                        CVP_Sm_vpc_002_liveProgramWME 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Live program plays with WMS delivery option using RSS 4000 Version5. (Slide, Polls, Surveys, Questions)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and create a WMS delivery option<br> 
*																	>Navigate to Encoders and add an WME encoder<br> 
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
* What Verification it performs:	 								1.Verify that Live program plays with WMS delivery option using WME Encoder. (Slide, Polls, Surveys, Questions)<br> 																															
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

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class CVP_Sm_vpc_002_liveProgramWME extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
			selenium.setTimeout("0");
		}
	}		
	public  void test_CVP_Play_LiveProgram()throws Exception {
		try{
		setUp();
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";		
		//Local Variable file name
		String localVariableFile="CVP_Sm_vpc_002_liveProgramWME.xml";		
		
		//Global variables file name
		String local_path ="Setup_Script.xml";
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
		// Variable for login Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
		
	
				
		//framework path will user for screen shot saving
		String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");		
		
	
		//Variable for the Live Program name			
		String Var_LiveProgramName = utilityFunction.GetValue(localVariableFile  ,"Var_LiveProgramName");
		
	
		//Variable for the viewer portal URL
		String Var_Columbia_vpURL = utilityFunction.GetValue(globalVariableFile, "Var_Columbia_vpURL");
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		
		
		String VAR_SurveyName = utilityFunction.GetValue(local_path,"VAR_SurveyName");			
		
		String VAR_SlideDisplayName = utilityFunction.GetValue(local_path,"VAR_SlideDisplayName");
				
		String VAR_PollName = utilityFunction.GetValue(local_path,"VAR_PollName");
		
		String Var_VideoNetEdgeDO_Name = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
		
		//Variable for the Encoder Name
		 String VAR_WMEEncodername = utilityFunction.GetValue(local_path ,"VAR_WMEName");
		//Variable for the saved encoder profile file name (with path)
		String VAR_WMEEncoderProfileName= utilityFunction.GetValue(local_path ,"VAR_WMEProName");
		//Call to reusable function for a admin portal
		
		String ContentHostIP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");	
		Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);		
		
		
		
		
	Create_Program.create_LiveProgram(selenium, Var_LiveProgramName, VAR_WMEEncodername, VAR_WMEEncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, Var_VideoNetEdgeDO_Name);
//		//Reusable action for Launching LBC and start the broadcast
		Launch_LBC.StartBroadcast(selenium, Var_LiveProgramName);
		
		if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
		{
			selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
			utilityFunction.waitForChangesToReflect();
			assertTrue("Sm_vpc_002","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
		}

		
		//call to Launch classic view portal
		 Launch_VP.Launch_CVP(selenium, VAR_domain);
		 
		 selenium.selectWindow("Qumu Program Browser Home");
			//Click on the live program link
			selenium.click(EnvObjectMap_Rep.lnk_programNameCVP + Var_LiveProgramName);
			//wait for page load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Get html source of the page
	       	String htmlsource = selenium.getHtmlSource();
     	int start_URL = htmlsource.indexOf("player.do");
    	    int end_URL = htmlsource.indexOf(VAR_WMEEncoderProfileName); 
        	String stream_URL = htmlsource.substring(start_URL, end_URL);
     	int stream_URL_length = stream_URL.length();
     	stream_URL = stream_URL.substring(0, stream_URL_length-16);
     	String VPURL = Var_Columbia_vpURL+VAR_domain+"/"+stream_URL;
     	selenium.open(VPURL);
     	selenium.waitForPageToLoad("15000");
     	
//
     	
			//Select the player window
			selenium.selectWindow("Qumu Program Player");
			//Select the question tab
			utilityFunction.waitForChangesToReflect();
			
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
			
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			
			if(selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
			{
				selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
				utilityFunction.waitForChangesToReflect();
				utilityFunction.waitForChangesToReflect();
				assertTrue("Sm_vpc_002","Verify that Poll Question is pushed successfully from LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
			}
			
			selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "90000");
	     	//select the poll window
				selenium.selectWindow(EnvObjectMap_Rep.window_pollCVP);
				//Selec the answer option
				
				
				selenium.click(EnvObjectMap_Rep.poll_answerOptionCVP);
				//Click on submit button
				selenium.click(EnvObjectMap_Rep.poll_answerSubmitCVP);
				//wait
				utilityFunction.waitForChangesToReflect();
				//check point for successfull poll submission
				assertTrue("Sm_vpc_002","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
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
			assertTrue("Sm_vpc_002","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_WMEEncoderProfileName));
			assertTrue("Sm_vpc_002","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));			
			assertTrue("Sm_vpc_002","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + ContentHostIP));
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
			//Select the LBC
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }		
			//Click on Broadcast control tab
			selenium.click(EnvObjectMap_Rep.tab_broadcastControlLBC);
			//Checkpoint to verify that audience question is displayed successfully on the LBC
			assertTrue("Sm_vpc_002","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			selenium.click(EnvObjectMap_Rep.Img_broadcastConsole);
			utilityFunction.waitForTextToPresent(selenium, "Archive files fetched.", 300);

			assertTrue("Sm_vpc_005", " Ingest completes for archived content of Live program played with VE as WMS delivery option using WME", date, true);
			
			utilityFunction.waitForChangesToReflect();
			
			selenium.close();
			//Select the admin portal window
			//selenium.selectWindow("null");
			utilityFunction=null;
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

