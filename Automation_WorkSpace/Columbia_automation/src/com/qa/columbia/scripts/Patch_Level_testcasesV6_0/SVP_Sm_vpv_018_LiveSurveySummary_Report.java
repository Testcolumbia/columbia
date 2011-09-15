/*
* Classname                                                        SVP_Sm_vpv_018_LiveSurveySummary_Report 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that 'Live Program Survey Summary' report is generated.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Reporting and select Reports<br> 
* 																	>Select a report type as "Live Program Poll/Survey Summary".
*																	>Select "Survey" from Poll or Survey drop down.<br> 
*																	>Select the Live program which was broadcasted.
*																	>Select Run report button
* What Verification it performs:	 								Verify that 'Live Program Poll/Survey Summary Report' report is generated successfully<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 14/04/2011
* Updated by/on date: 												QASource on 14/04/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/

package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

import java.util.Calendar;
import java.util.Date;

public class SVP_Sm_vpv_018_LiveSurveySummary_Report extends TesterAsserter {
	

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
			selenium.setTimeout("0");
			utilityFunction=null;
		}

	}		
	public void test_SVP_Sm_vpv_018_LiveSurveySummary_Report() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String globalVariableFile ="Global_variables.xml";
			String local_path="Setup_Script.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//local variable file name
			String localVariableFile="SVP_Sm_vpv_018_LiveSurveySummary_Report.xml";		
		    //String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			//Encoder Name
			String VAR_EncoderName = utilityFunction.GetValue(local_path, "VAR_RSSv5Encodername");
			//Variable for the encoder profile name
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_RSSv5EncoderProfileName");
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(localVariableFile ,"Var_LiveProgramName");
			//Variable for the Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"VAR_SurveyName");
		
			String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
				
			//Reusable action for Login to VCC
     		Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     		//Reusable to create a live program
     		Create_Program.create_LiveProgram(selenium, Var_LiveProgramName, VAR_EncoderName, VAR_EncoderProfileName,"", "", VAR_SurveyName, Var_VEasWMS_DO);
			//Launch the LBC
			Launch_LBC.StartBroadcast(selenium, Var_LiveProgramName);
	  	    //launch the social viewer portal	 
	        Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
		    //call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_DomSocial, Var_LiveProgramName);
		    //select the LBC window and stop the broadcast
			Launch_LBC.StopBroadcast(selenium, Var_LiveProgramName);
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
		    utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.LNK_SurveyWindow, 300);
		   
		    //select the answer on survey
		    selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
		    //submit the answer on survey
		    assertTrue("Sm_vpv_018","Verify that survey is displayed successfully on viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_SubmitSurveyanswer));
			selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
			utilityFunction.waitForChangesToReflect();
			//Select the parent window
			selenium.close();
		    selenium.selectWindow("null");
    		 //Click 'Reporting' menu
    		selenium.click(EnvObjectMap_Rep.Lnk_reporting);
    		//Click 'Reports' link
    		selenium.click(EnvObjectMap_Rep.Lnk_reports);
    		//wait
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
            //Select Report name
    		selenium.click(EnvObjectMap_Rep.radio_LiveProgramSurveySummary);
    		//Click 'Next' button
    		selenium.click(EnvObjectMap_Rep.btn_reportNext);
    		//wait
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
            //select Survey as the option
    		selenium.select(EnvObjectMap_Rep.drp_SelectPollorSurvey, EnvObjectMap_Rep.txt_Survey);
    		utilityFunction.waitForChangesToReflect();
    		selenium.select(EnvObjectMap_Rep.drp_selectProgramReport,"label=" +Var_LiveProgramName);
    		//wait
    		utilityFunction.waitForChangesToReflect();
    		//click the Run report button
    		selenium.click(EnvObjectMap_Rep.btn_reportNext);
    		//wait
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
    		//verify that 'Content Storage' report is generated
    	    assertTrue("Sm_vpv_018","Social VP: Ensure that 'Live Program Survey Summary' report is generated.",date, selenium.isTextPresent("Live Program Poll/Survey Summary Report"));
    	    assertTrue("Sm_vpv_018","Social VP: Ensure that correct Live program is displayed on 'Live Program Survey Summary' report.",date, selenium.isTextPresent(Var_LiveProgramName));
   
    	    utilityFunction=null;
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			finally
			{
			 //stop selenium
			selenium.close();
			selenium.stop();
			}
    	 }				 
	}
}