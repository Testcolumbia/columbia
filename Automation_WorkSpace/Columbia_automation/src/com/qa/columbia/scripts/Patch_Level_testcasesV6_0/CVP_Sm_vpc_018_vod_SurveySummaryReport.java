/*
* Classname                                                        CVP_vod_SurveySummaryReport 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
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
		}

	}		
	public void test_CVP_vod_SurveySummaryReport() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//local Variable file
			String localVariableFile = "CVP_Sm_vpc_018_vod_SurveySummaryReport.xml";
			//Setup script variable file
			String local_path ="Setup_Script.xml";
		
			//Variable for the framework path (package path)
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			//Variable for the domain name
	        String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for login Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for the Survey Name
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"VAR_SurveyName");		
			//Variable for the Question Name
					
		
			String VAR_streamingMediaRSSDisc = utilityFunction.GetValue(local_path,"VAR_streamingMediaRSSDisc");		
			//Variable for the program name
			String VAR_VODName = utilityFunction.GetValue(localVariableFile ,"VODName");	
			
				
			//Reusable action for Login to VCC     		
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
     
     
        	//Create an On-demand program
        	//Create_Program.create_VODProgram(selenium, VAR_VODName, VAR_SurveyName, VAR_streamingMediaRSSDisc);
        	//Click on Programs menu link
	       utilityFunction.waitForChangesToReflect();
		    
      	   	//Play the vod program on the viewer portal
      	  Launch_VP.Launch_CVP(selenium, VAR_domain);
      	  
      	selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, VAR_VODName);
		selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);				 
		utilityFunction.waitForChangesToReflect();				
		selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_VODName);
		Thread.sleep(20000);
		selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_streamingMediaRSSDisc);			
		utilityFunction.waitForChangesToReflect();	
		//Capture the screenshot at the specified path
		String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_VODName + ".jpg";		
		//Capture the screen shot of the program
		selenium.captureScreenshot(screenShot_locPath);	
		
		selenium.selectWindow("Qumu Program Player");
    	//Close the player window
    	selenium.close();
    	//wait
    	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	//Select the survey browser window
    	selenium.selectWindow(VAR_SurveyName);
    	Thread.sleep(40000);
    	selenium.click(EnvObjectMap_Rep.survey_answerCVP);        	
    	//selenium.click(EnvObjectMap_Rep.chk_selectOptionCVP);
    	//Click on Submit button to submit the survey answer
    	selenium.click(EnvObjectMap_Rep.btn_submitSurveyCVP);
    	//Close the survey window
    	selenium.close();
    	//Select the parent window
        	
    	selenium.selectWindow("null");
        utilityFunction.waitForChangesToReflect();
		//Reporting link
		selenium.click(EnvObjectMap_Rep.Lnk_reporting);
		//Report link
		selenium.click(EnvObjectMap_Rep.Lnk_reports);
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
 	    selenium.click(EnvObjectMap_Rep.Btn_runreport);
 	    //wait
       	selenium.waitForPageToLoad(VAR_MED_WAIT);
       	//Path for the screenhost
		String screenShot_locPath1 = Var_frameWork_Path + "\\commonfiles\\" + "VOD_surveySummary" + ".jpg";	
		//Take the screen shot of the generated report
        selenium.captureScreenshot(screenShot_locPath1); 
            //Verify that the report is generated
	   		assertTrue("Sm_vpc_018","Classic VP: Ensure that 'On Demand Survey Summary' report is generated.",date,selenium.isTextPresent("On-Demand Program Survey Summary Report"));        	
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