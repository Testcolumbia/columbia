/*
* Classname                                                        CVP_Sm_vpc_003_liveRSSv6_medianet 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Live program plays with Medianet delivery option using RSS 4000 Version6. (Slide, Polls, Surveys, Questions)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and create two WMS delivery options<br> 
*  																	>Create a medianet delivery option<br> 
*																	>Navigate to Encoders and add an RSSv6 encoder<br> 
*  															     	>Navigate to Content and add a poll<br> 
*																	>Navigate to Content and add a slide<br> 
* 																	>Navigate to Content and add a survey<br> 
* 																	>Navigate to Programming and Create the Live program with above mentioned encoder, poll, slide, survey, viewer question and medianet delivery option<br> 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_003_liveRSSv6_medianet extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
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
			utilityFunction=null;
		}
	}		
	public void test_CVP_Sm_vpc_003_liveRSSv6_medianet() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file name
			String local_path = "CVP_liveRSSv6_medianet.xml";
			//wait variable
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
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//Variable for the host IP
			String VAR_WMSoriginHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//Variable for the wms HTTP port
			String VAR_WMSoriginHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//Variable for the wms user name
			String VAR_WMSoriginUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//Variable for the wms password
			String VAR_WMSoriginPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//Variable for the edge WMS name
			String VAR_WMSedgeName = utilityFunction.GetValue(str_path ,"VAR_WMSedgeName");
			//Variable for the edge WMS host IP
			String VAR_WMSedgeHost = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHost");
			//Variable for the edge WMS HTTP port
			String VAR_WMSedgeHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHTTPport");
			//Variable for the edge WMS user-name
			String VAR_WMSedgeUsername = utilityFunction.GetValue(str_path ,"VAR_WMSedgeUsername");
			//Variable for the edge WMS password
			String VAR_WMSedgePassword = utilityFunction.GetValue(str_path ,"VAR_WMSedgePassword");
			//Variable for the medianet name
			String VAR_medianetName = utilityFunction.GetValue(local_path ,"VAR_medianetName");
			//Variables for 1st IP range for CIDR block
			String VAR_CIDR1 = utilityFunction.GetValue(local_path ,"VAR_CIDR1");		
			//Variables for Metric for the 1st CIDR block
			String VAR_Metric1 = utilityFunction.GetValue(local_path ,"VAR_Metric1");		
			//Variables for 2nd IP range for CIDR block
			String VAR_CIDR2 = utilityFunction.GetValue(local_path ,"VAR_CIDR2");		
			//Variables for Metric for the 2nd CIDR block
			String VAR_Metric2 = utilityFunction.GetValue(local_path ,"VAR_Metric2");		
			//Variable for the encoder name
			String VAR_EncoderName = utilityFunction.GetValue(local_path ,"VAR_EncoderName");
			//Variable for the encoder host IP
			String VAR_EncoderHostIP = utilityFunction.GetValue(local_path ,"VAR_EncoderHostIP");
			//Variable for the encoder user name
			String VAR_EncoderUserName = utilityFunction.GetValue(local_path ,"VAR_EncoderUserName");
			//Variable for the encoder password
			String VAR_EncoderPassword = utilityFunction.GetValue(local_path ,"VAR_EncoderPassword");
			//Variable for the encoder profile name
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Variable for the maximum number of live streams
			String VAR_MaxStreams = utilityFunction.GetValue(local_path ,"VAR_MaxStreams");
			//Variable for the Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"SurveyName");
			//Variable for Poll name
			String VAR_PollName = utilityFunction.GetValue(local_path ,"PollName");
			//Variable for the Question Name
			String VAR_QuestionName = utilityFunction.GetValue(local_path ,"QuestionName");		
			//Variable for the Question Explanation
			String VAR_QuestionExp = utilityFunction.GetValue(local_path ,"QuestionExp");		
			//Variable for the Question Type
			String VAR_QuestionType = utilityFunction.GetValue(local_path ,"QuestionType");	
			//Variable for the slide display name
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path ,"VAR_SlideDisplayName");		
			//Variable for the Slide's file name
			String VAR_SlideFileName = utilityFunction.GetValue(local_path ,"VAR_SlideFileName");	
			//Variable for the Live Program name			
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the name of the archive file created for the live program
			String Var_ArchiveOfLiveProgram = utilityFunction.GetValue(local_path ,"Var_ArchiveOfLiveProgram");
			//Variable for the framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Reusable action for login to VCC
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
			//Reusable action for creating WMS 
			Create_WMS.create_WMS(selenium, VAR_WMSoriginName, VAR_WMSoriginHost, VAR_WMSoriginHTTPport, VAR_WMSoriginUsername, VAR_WMSoriginPassword);
			//Reusable action for creating WMS 
			Create_WMS.create_WMS(selenium, VAR_WMSedgeName, VAR_WMSedgeHost, VAR_WMSedgeHTTPport, VAR_WMSedgeUsername, VAR_WMSedgePassword);
			//Reusable action for medianet
			Create_medianet.create_medianetProximity(selenium,VAR_medianetName, VAR_WMSoriginName, VAR_WMSedgeName,VAR_CIDR1, VAR_Metric1, VAR_CIDR2, VAR_Metric2);			
			//Create_medianet.create_medianetProximity(selenium,VAR_medianetName, VAR_WMSoriginName, VAR_WMSedgeName,"192.16.17.0/24", "1", "10.1.60.0/24", "2");
			//Reusable action for creating RSSv5 encoder 
			Create_Encoder.create_RSSv6enc(selenium, VAR_EncoderName, VAR_EncoderHostIP, VAR_EncoderUserName, VAR_EncoderPassword, VAR_MaxStreams, VAR_EncoderProfileName);
			//Reusable action for adding survey in content
			Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action for uploading slides
			Upload_Media.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
			//Reusable action for adding poll in content
			Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action for creating live program having slide, poll, survey and question option defined
			Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_EncoderName, VAR_EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_medianetName);
			//Reusable action for Launching LBC and start the broadcast
			Launch_LBC.test_LaunchLBC(selenium, "Sm_vpc_003", Var_LiveProgramName, Var_ArchiveOfLiveProgram);
			//Select the admin portal window
		    selenium.selectWindow("null");
			//Click on Domain name link to launch the viewer portal
			selenium.click("link=" + VAR_DomClassic);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//utilityFunction.waitForChangesToReflect();
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
        	selenium .waitForPageToLoad("50000");
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
			assertTrue("Sm_vpc_003","Verify that Poll is submitted successfully from the viewer portal.",date,selenium.isTextPresent("Your response has been submitted.\n\nYou may now close this window."));
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
			assertTrue("Sm_vpc_003","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource2, VAR_EncoderProfileName));
			assertTrue("Sm_vpc_003","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "mms"));
			assertTrue("Sm_vpc_003","Verify that multicast stream from the edge server is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource2, "http://" + VAR_WMSedgeHost +"/WMSControl/qumu_"));
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
			assertTrue("Sm_vpc_003","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast 
			selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
			//Close the LBC window
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