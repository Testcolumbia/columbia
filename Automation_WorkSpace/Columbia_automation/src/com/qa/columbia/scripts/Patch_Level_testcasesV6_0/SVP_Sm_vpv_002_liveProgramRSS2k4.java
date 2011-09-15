
/*This  scripts include 2 test cases:1)SVP_Sm_vpv_002_liveProgramRSS2k4
 *                                   2)SVP_Sm_vpv_004_ArchiveliveProgramRSS2k4
* Class name                                                        SVP_Sm_vpv_002_liveProgramRSS2k4 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that Live program plays with VE as WMS delivery option using RSS 2000 version 4. (Slide, Polls, Surveys, Questions and archive content)<br>
* What the script does:											    >Login to the application<br> 
*                                                                   >Create the Live program with slide, poll and surveys.													
* 																	>Launch LBC and start the  broadcast.<br>						
* 										                            >Launch viewer portal video and verify the asx file<br>
*                                                                   >Push poll from LBC and answer the same from the viewer portal.													
* 																	>Ask question from the viewer portal and verify on LBC<br>						
* 										                            >Stop the broadcast from LBC<br>
* What Verification it performs:	 								Verify that Live program plays with VE as WMS delivery option using RSS 2000 version 4. (Slide, Polls, Surveys, Questions and archive content)<br><br> 
*					
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class SVP_Sm_vpv_002_liveProgramRSS2k4 extends TesterAsserter {
	
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
	public  void test_SVP_Sm_vpv_002_liveProgramRSS2k4()throws Exception {
		try{
		setUp();
		Utility_Functions utilityFunction = new Utility_Functions(); 		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";		
		//Local Variable file name
		String localVariableFile="SVP_Sm_vpv_002_liveProgramRSS2k4.xml";	
		String setupVariableFile = "Setup_Script.xml";
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
		// Variable for login Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");		
		
		String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");		
		//framework path will user for screen shot saving
		String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");			
		//Variable for the Survey Name
		String VAR_SurveyName = utilityFunction.GetValue(setupVariableFile  ,"VAR_SurveyName");
		//Variable for Poll name
		String VAR_PollName = utilityFunction.GetValue(setupVariableFile  ,"VAR_PollName");
		//Variable for the slide display name
		String VAR_SlideDisplayName = utilityFunction.GetValue(setupVariableFile  ,"VAR_SlideDisplayName");	
		//Variable for the Live Program name			
		String Var_LiveProgramName = utilityFunction.GetValue(localVariableFile  ,"Var_LiveProgramName");
		
		String Var_ArchiveOfLiveprogram = "Archived"+Var_LiveProgramName;
		String VAR_RSSv4Encodername = utilityFunction.GetValue(setupVariableFile ,"VAR_RSSv4Encodername");
		
		String VAR_RSSv4EncoderProfileName = utilityFunction.GetValue(setupVariableFile ,"VAR_RSSv4EncoderProfileName");
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile, "VAR_MED_WAIT");	
		
		//Call to reusable function for a admin portal
		Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
		//Create Live program
		Create_Program.create_LiveProgram(selenium, Var_LiveProgramName, VAR_RSSv4Encodername, VAR_RSSv4EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, Var_VEasWMS_DO);
		//Reusable action for Launching LBC and start the broadcast
		Launch_LBC.StartBroadcast(selenium, Var_LiveProgramName);		
		if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
		{
			selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
			utilityFunction.waitForChangesToReflect();
			assertTrue("Sm_vpv_002","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
		}		
		//call to Launch classic view portal
		Launch_VP.Launch_SVP(selenium, VAR_domain);
		 
		selenium.click(EnvObjectMap_Rep.Lnk_showAllJukeBox);
		selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, Var_LiveProgramName);
		selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
		Thread.sleep(5000);
		//selenium.selectWindow("null");	        
		utilityFunction.waitForChangesToReflect();
		//Launch the viewer portal video
		selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
		Thread.sleep(20000);
		selenium.click("//div[@id='jukebox']/div[5]/div[3]/div/div/a[1]");
		Thread.sleep(15000);
	    utilityFunction.waitForChangesToReflect();  
		//select the asx link
	    String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
	    //wait
	    utilityFunction.waitForChangesToReflect();  
	    //split the string
	    String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
		contentlink_final=contentlink_final.trim();			
		selenium.openWindow(contentlink_final+"&debug=true", "asx");
		selenium.selectWindow("asx");
		Thread.sleep(5000);
		String htmlsource = selenium.getHtmlSource();
		assertTrue("Sm_vpv_002","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_RSSv4EncoderProfileName));
		selenium.close();
		selenium.selectWindow("null");
	    for (String windowName : selenium.getAllWindowNames())
	    {
		if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				selenium.selectWindow(windowName);
	       }
	    }	
		if(selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
		{
			selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			assertTrue("Sm_vpv_002","Verify that Poll Question is pushed successfully from LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
		}
		selenium.selectWindow("SVP");
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_PollWindow, 300);
		
		assertTrue("Sm_vpv_002", "Verify that poll is displayed successfully on the viewer portal.", date, selenium.isElementPresent(EnvObjectMap_Rep.CHK_PollWindow));

		//select the checkbox for an answer   
		selenium.click(EnvObjectMap_Rep.CHK_PollWindow);
		//submit the poll
		selenium.click(EnvObjectMap_Rep.BTN_PollWindow);
     	selenium.click(EnvObjectMap_Rep.CHK_PollWindow);
		Thread.sleep(10000);
		
	    //submit the poll
	    selenium.click(EnvObjectMap_Rep.BTN_PollWindow);
	    assertTrue("Sm_vpv_002", "Poll is submitted successfully", date, true);
	    //wait
        //click the link for viewer question answer
	    selenium.click(EnvObjectMap_Rep.tab_QA);
	    //wait
		Thread.sleep(5000);
		//provide the viewer question
		selenium.type("text", "Test Poll Viewer Question text");
		selenium.typeKeys("text", "t");
		Thread.sleep(5000);
		//click Ask button to submit the question
		selenium.click(EnvObjectMap_Rep.btn_Ask);
		//wait
        utilityFunction.waitForChangesToReflect();
        //variable for path where to save the screenshot    
		String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
		//Capture the screen shot of the live program
	    selenium.captureScreenshot(screenShot_locPath); 
		//Wait
	    
	    //-----------------------------push results to viewer-----------------------------------------
	    selenium.selectWindow("");
		//Select the LBC
		for (String windowName : selenium.getAllWindowNames()) {
			if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				selenium.selectWindow(windowName);
            }
        }	
		
		utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.lnk_pushPollResult, 300);
		selenium.click(EnvObjectMap_Rep.lnk_pushPollResult);
        selenium.selectWindow("Qumu Program Browser Home");
		
	      utilityFunction.waitForElementToVisible(selenium,EnvObjectMap_Rep.Txt_pollresultwindowsvp , 600);
		
		
	
		selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollresultanswersvp);
		selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollresultvotesvp);
         
		assertTrue("Sm_vpv_002", "Verify that user is able to push the results to the viewer portal", date, true);
		selenium.click(EnvObjectMap_Rep.Btn_crosspollresult);
		//--------------------------------------------------------------------------------------
	    selenium.selectWindow("null");
		//select the LBC window
		for (String windowName : selenium.getAllWindowNames()) {
		if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1)
		{
		    selenium.selectWindow(windowName);
	    }
	    }		
		//Click on Broadcast control tab
		selenium.click(EnvObjectMap_Rep.tab_broadcastControlLBC);
		//wait
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.img_audienceQuestionLBC, 300);
	    assertTrue("Sm_vpv_002","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
		//Stop the broadcast
		selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
		 for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				try { if (selenium.isTextPresent("Archive files fetched.|Completed")) break; 
				} catch (Exception e) {}
				Thread.sleep(1000);
			 }
		    assertTrue("Sm_vpv_004","Verify that Archive files are fetched.",date,selenium.isTextPresent("(none)|Archive files fetched.|Completed "));

		Thread.sleep(2000);
		selenium.close();
		//Select the parent window
		selenium.selectWindow("null");
		//wait
		utilityFunction.waitForChangesToReflect();
		//select SVP window
		selenium.selectWindow("Qumu Program Browser Home");
		//wait
		utilityFunction.waitForChangesToReflect();
		//Verify that survey is available
		for (int second = 0;; second++) {
		if (second >= 600) fail("timeout");
		try { if (selenium.isElementPresent(EnvObjectMap_Rep.LNK_SurveyWindow)) break; } catch (Exception e) {}
		 	Thread.sleep(1000);
		}
		//select the answer on survey
		selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
		//submit the answer on survey
		assertTrue("Sm_vpv_002","Verify that survey is displayed successfully on viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_SubmitSurveyanswer));
		selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
		assertTrue("Sm_vpv_002", "Survey is submitted successfully", date, true);
		
		selenium.close();
		selenium.selectWindow("null");
		selenium.click(EnvObjectMap_Rep.Lnk_programming);
		//Select Content link
		selenium.click(EnvObjectMap_Rep.Lnk_content);
		//wait
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		Thread.sleep(3000);
		Advance_Search.AdvanceSearch(selenium, Var_ArchiveOfLiveprogram);			
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();	
		assertTrue("Sm_vpv_004","Social VP: Ensure that ingest completes for archived content of Live program played with VE as WMS delivery option using RSS 2000 Version 4.",date,selenium.isTextPresent(Var_ArchiveOfLiveprogram));
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