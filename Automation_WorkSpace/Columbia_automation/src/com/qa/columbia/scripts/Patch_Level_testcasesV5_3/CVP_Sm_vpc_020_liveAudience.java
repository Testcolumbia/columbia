/*
* Classname                                                        CVP_Sm_vpc_020_liveAudience 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Live program plays with audience delivery option using RSS 4000 Version5. (Slide, Polls, Surveys, Questions and archive content)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery>Delivery Options and add a WMS delivery option<br> 
*																	>Navigate to Audience and create a new audience with the above WMS delivery option.<br> 
*  															     	>Navigate to Resources>Encoders and create a new RSSv5 encoder.<br> 
*																	>Navigate to Programming>Contents and add a poll.<br> 
* 																	>Navigate to Programming>Contents and add a survey.<br> 
* 																	>Navigate to Programming>Contents and add a slide.<br> 
* 																	>Navigate to Programming>Programs and add a live program using the above mentioned encoder, slide,poll,survey, audience and audience question.<br>
* 																	>Launch  the LBC and and start the broadcast (with archiving enabled)<br>
* 																	>Push the slide and poll from LBC<br> 	
*  													     			>Launch the viewer portal and play the live program<br> 
*   																>Answer the poll, view the streams and submit the survey<br>
*  													     			>Navigate to LBC and stop the broadcast and wait for the archiving to complete.<br> 
*   																>Navigate to Programming>Content and view the archied file.<br>  																			 
* What Verification it performs:	 								1.Verify that user is able to play the LIve program using the audience<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_020_liveAudience extends TesterAsserter {
	
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
			utilityFunction=null;
		}

	}		
	public void test_CVP_Sm_vpc_020_liveAudience() throws Exception {
		{
			try{
				setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file name
			String local_path = "CVP_liveProgramAudience.xml";
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the viewer portal URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path, "Var_Columbia_vpURL");
			//WMs name
			String VAR_wmsName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//WMS host IP
			String VAR_WMSHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//HTTP port on WMS
			String VAR_WMSHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//WMS user name
			String VAR_WMSUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//WMS password
			String VAR_WMSPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//HTTP delivery option name
			String VAR_httpName = utilityFunction.GetValue(str_path ,"VAR_httpName");
			//Audience name
			String VAR_audienceName = utilityFunction.GetValue(local_path ,"VAR_audienceName");
			//Audience rule IP
			String VAR_audienceIP = utilityFunction.GetValue(local_path ,"VAR_audienceIP");
			//Audience Host IP
			String VAR_audienceHost = utilityFunction.GetValue(str_path ,"VAR_Audience_Host");
			//Audience port
			String VAR_audiencePort = utilityFunction.GetValue(local_path ,"VAR_audiencePort");
			//Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"VAR_SurveyName");
			//Poll name
			String VAR_PollName = utilityFunction.GetValue(local_path ,"VAR_PollName");
			//Question name
			String VAR_QuestionName = utilityFunction.GetValue(local_path ,"VAR_QuestionName");
			//Question explanation
			String VAR_QuestionExp = utilityFunction.GetValue(local_path ,"VAR_QuestionExp");
			//Question Type
			String VAR_QuestionType = utilityFunction.GetValue(local_path ,"VAR_QuestionType");
			//Slide display name
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path ,"VAR_SlideDisplayName");
			//Slide file name
			String VAR_SlideFileName = utilityFunction.GetValue(local_path ,"VAR_SlideFileName");
			//Live program name
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Archine content name
			String Var_ArchiveOfLiveRSSv5 = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveRSSv5");
			//Encoder name
			String VAR_Encodername = utilityFunction.GetValue(local_path ,"VAR_Encodername");
			//Encoder Host IP
			String VAR_EncoderHostIP = utilityFunction.GetValue(local_path ,"VAR_EncoderHostIP");
			//Encoder version
			String VAR_EncoderVersion = utilityFunction.GetValue(local_path ,"VAR_EncoderVersion");
			//Encoder User name
			String VAR_EncoderUserName = utilityFunction.GetValue(local_path ,"VAR_EncoderUserName");
			//Encoder password
			String VAR_EncoderPassword = utilityFunction.GetValue(local_path ,"VAR_EncoderPassword");
			//Encoer Profile name
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Encoder bitrate
			String VAR_EncoderBitRate = utilityFunction.GetValue(local_path ,"VAR_EncoderBitRate");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for login
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			/*//Reusable action to create WMS delivery option
			Create_WMS.create_WMS(selenium, VAR_wmsName, VAR_WMSHost, VAR_WMSHTTPport, VAR_WMSUsername, VAR_WMSPassword);
			//Reusable action to create auience
			Create_Audience.test_Create_Audience(selenium, VAR_audienceName, VAR_audienceHost, VAR_audienceIP, VAR_audiencePort, VAR_httpName, VAR_httpName, VAR_wmsName);
			//Reusable action to create RSSv5 encoder
			Create_Encoder.create_RSSv5enc(selenium,VAR_Encodername, VAR_EncoderHostIP, VAR_EncoderVersion, VAR_EncoderUserName, VAR_EncoderPassword, VAR_EncoderProfileName, VAR_EncoderBitRate);
			//Reusable action to add poll
			Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action to add survey
			Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action to upload slide
			Upload_Media.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
			//Reusable action to create live program
			Create_Program.test_Live_audience(selenium, "Sm_vpc_020", Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_audienceName);
			*///Reusable action to launch LBC
			Launch_LBC.test_LaunchLBC(selenium, "Sm_vpc_020", Var_LiveProgramName, Var_ArchiveOfLiveRSSv5);
			//Select the admin portal window
		    selenium.selectWindow("null");
			//Click on Domain name link to launch the viewer portal
			selenium.click("link=" + VAR_DomClassic);
			//wait
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
       	    int end_URL = htmlsource.indexOf(VAR_EncoderProfileName); 
           	String stream_URL = htmlsource.substring(start_URL, end_URL);
        	int stream_URL_length = stream_URL.length();
        	stream_URL = stream_URL.substring(0, stream_URL_length-16);
        	String VPURL = Var_Columbia_vpURL+VAR_DomClassic+"/"+stream_URL;
        	selenium.open(VPURL);
        	//wait for the poll window
        	selenium.waitForPopUp(EnvObjectMap_Rep.window_pollCVP, "150000");
        	//select the poll window
			selenium.selectWindow("name="+EnvObjectMap_Rep.window_pollCVP);
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
			assertTrue("Sm_vpc_020","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName));
			assertTrue("Sm_vpc_020","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
			assertTrue("Sm_vpc_020","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + VAR_WMSHost +"/WMSControl/qumu_"));
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
			assertTrue("Sm_vpc_020","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			selenium.close();
			//Select the admin portal window
			selenium.selectWindow("null");
			utilityFunction=null;
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			finally{
			selenium.close();
			selenium.stop();
			}
		}
	}
}