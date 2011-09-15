/*
* Classname                                                        CVP_Sm_vpc_018_vod_SurveySummaryReport 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that 'On Demand Survey Summary' report is generated.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add a survey<br> 
*																	>Add a wmv file<br> 
* 																	>Add an On-demand program using the wmv file<br> 
* 																	>Add the survey in the on-demand program<br> 
* 																	>Play the on-demand program on the viewer portal<br> 
* 																	>Close the player window<br> 
* 																	>Answer the survey question<br> 	
*  													     			>Submit the survey and close the survey window<br>
*  																	>Launch the admin portal<br>
*  																	>Navigate to Reports<br>
*  																	>Select the On-demand Survey Summary Report<br>
*  																	>Select the program and run the report<br>																	 
* What Verification it performs:	 								1.Verify that user is able to generate the on-demand survey Summary report<br> 
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


public class CVP_Sm_vpc_018_vod_SurveySummaryReport extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_018_vod_SurveySummaryReport() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//local variable file
			String local_path = "CVP_vod_SurveySummaryReport.xml";
			//Variable for the application URL
			String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			//Variable for the framework path (package path)
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//Variable for the wait		
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for the Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"SurveyName");		
			//Variable for the Question Name
			String VAR_QuestionName = utilityFunction.GetValue(local_path ,"QuestionName");		
			//Variable for the Question Explanation
			String VAR_QuestionExp = utilityFunction.GetValue(local_path ,"QuestionExp");		
			//Variable for the Question Type
			String VAR_QuestionType = utilityFunction.GetValue(local_path ,"QuestionType");		
			//Variable for the streaming media display name
			String VAR_StreamingMedia = utilityFunction.GetValue(local_path ,"StreamingMedia");		
			//Variable for the streaming media file name
			String VAR_StreamingMediaFileName = utilityFunction.GetValue(local_path ,"StreamingMediaFileName");		
			//Variable for the program name
			String VAR_VODName = utilityFunction.GetValue(local_path ,"VODName");		
			//Reusable action for Login to VCC     		
     	    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
        	//Maximize the window
        	selenium.windowMaximize();
        	//Get the html source
        	Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
        	//Add a streaming media
        	Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, VAR_StreamingMediaFileName);
        	//Create an On-demand program
        	Create_Program.test_Create_vodProgram(selenium, VAR_VODName, VAR_StreamingMedia);
        	//Click on Programs menu link
        	selenium.click(EnvObjectMap_Rep.LNK_Programs);
        	//wait
        	selenium.waitForPageToLoad(VAR_MED_WAIT);
         	//Search the new created Live program
        	selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
        	//provide program name in Search field
        	selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_VODName);
        	//click Search button 
        	selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
        	//wait
        	utilityFunction.waitForChangesToReflect();
        	//Click on the program link to edit
        	selenium.click("link=" + VAR_VODName);
        	//wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Click on Edit button for Program Assets section
        	selenium.click(EnvObjectMap_Rep.btn_editProgramAsset);
        	//wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Click o nAdd button for Survey
           	selenium.click(EnvObjectMap_Rep.btn_addSurvey);
           	//wait
        	utilityFunction.waitForChangesToReflect();
        	//Navigate to Search tab
        	selenium.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
        	//Set focus on the search textbox
        	selenium.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
        	//Provide the survey name to search
        	selenium.type(EnvObjectMap_Rep.txt_searchSurvey, VAR_SurveyName);
        	//Click on Find button
        	selenium.click(EnvObjectMap_Rep.btn_searchSurvey);
        	//wait
        	utilityFunction.waitForChangesToReflect();
        	//Select the searched survey
        	selenium.click(EnvObjectMap_Rep.lnk_selectSurvey);
        	//Click on the Save button
        	selenium.click(EnvObjectMap_Rep.btn_saveSelectedSurvey);
        	//wait
        	utilityFunction.waitForChangesToReflect();
        	//Click on Summary button
        	selenium.click(EnvObjectMap_Rep.btn_summary);
        	//wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Click on Finish button
        	selenium.click(EnvObjectMap_Rep.btn_FinishProgram);
        	//wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Reusable action to play the on-demand program
           	Play_Program.test_Play_vodCVP(selenium, VAR_DomClassic, VAR_VODName, VAR_StreamingMedia);
        	//Select the player window
        	selenium.selectWindow("Qumu Program Player");
        	//Close the player window
        	selenium.close();
        	    	//wait
        	utilityFunction.waitForChangesToReflect();
        	selenium.selectWindow("null");
        	utilityFunction.waitForChangesToReflect();
        	//Select the survey browser window
        	selenium.selectWindow(VAR_SurveyName);
        	selenium.click(EnvObjectMap_Rep.survey_answerCVP);        	
        	//selenium.click(EnvObjectMap_Rep.chk_selectOptionCVP);
        	//Click on Submit button to submit the survey answer
        	selenium.click(EnvObjectMap_Rep.btn_submitSurveyCVP);
        	//Close the survey window
        	selenium.close();
        	//Select the parent window
        	selenium.selectWindow("");
        	//Open teh admin portal
        	selenium.open(VAR_Columbia_APPURL);
        	//Reusabel action for login
     	    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
     	    //Click on Reporting menu
     	    selenium.click(EnvObjectMap_Rep.lnk_reporting);
     	    //Click on Reports menu link
     	    selenium.click(EnvObjectMap_Rep.lnk_reports);
     	    //wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Select the radio button "On demand survey Summary report"
     	    selenium.click(EnvObjectMap_Rep.radio_onDemandSurveySummary);
     	    //Click on Next button 
     	    selenium.click(EnvObjectMap_Rep.btn_reportNext);
     	    //wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Select the vod program
     	    selenium.select(EnvObjectMap_Rep.drp_selectProgramReport, VAR_VODName);
     	    //Click on Run report button
     	    selenium.click(EnvObjectMap_Rep.btn_runReport);
     	    //wait
           	selenium.waitForPageToLoad(VAR_MED_WAIT);
           	//Path for the screenhost
    		String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + "VOD_surveySummary" + ".jpg";	
    		//Take the screen shot of the generated report
            selenium.captureScreenshot(screenShot_locPath); 
            //Verify that the report is generated
	   		assertTrue("Sm_vpc_018","Classic VP: Ensure that 'On Demand Survey Summary' report is generated.",date,selenium.isTextPresent("On-Demand Program Survey Summary Report"));        	
	   		utilityFunction=null;
		}catch(Exception e){
			e.printStackTrace();}
			 finally{
			selenium.close();
			selenium.stop();
		}
	   	   
		}
					 
	}
}