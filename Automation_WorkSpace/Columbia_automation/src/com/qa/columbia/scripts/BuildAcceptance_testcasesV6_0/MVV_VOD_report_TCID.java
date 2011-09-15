/*
* Class name                                                        MVV_VOD_report 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: TC_XXX:- that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
*                                                                   >Upload content to the application
*                                                                   >Create VOD program
* 																	>Click on the Reporting link<br> 															
* 																	>Choose the "Media Viewing by Viewers (VOD)" option and verify the reports<br>																
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please TC_XXX:- that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class MVV_VOD_report_TCID extends TesterAsserter{
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	
	public void setUp() throws Exception 
	{
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag)
		{				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			utilityFunction=null;
			selenium.setTimeout("0");
		}

	}	
	
	public  void test_MVV_VOD_report() throws Exception
	{
		
		try{
			
		    //Call to setUp function
		    setUp();
			
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String global_path ="Global_variables.xml";
			
			//Global variables file name
			String local_path ="MVV_VOD_report_TCID.xml";
			
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(global_path ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(global_path ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(global_path ,"Var_DomainSocial");
			
			//Variable for Waiting time
			String wait=utilityFunction.GetValue(global_path ,"VAR_MED_WAIT");
			
			//variable for program name
			String VAR_program=utilityFunction.GetValue(local_path ,"VAR_programName");
			
			// Variable for streaming media file name
			String VAR_StreamingMedia=utilityFunction.GetValue(local_path ,"VAR_streamingMedia_Name");
			
			//variable to upload source file
			String VAR_StreamingMediasourcefile=utilityFunction.GetValue(local_path ,"VAR_streamingMediasource_file");
			
			
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
		//call to upload streaming Media function
		Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, VAR_StreamingMediasourcefile);
		
		//Call to Create VOD program function		
		Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);		
		
		//launch social viewer protal
			Launch_VP.Launch_SVP(selenium, VAR_domain);
			
			
			//call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_domain, VAR_program);
					  		    
		    selenium.selectWindow("null");
            utilityFunction.waitForChangesToReflect();
			//Reporting link
			selenium.click(EnvObjectMap_Rep.Lnk_reporting);
			//Report link
			selenium.click(EnvObjectMap_Rep.Lnk_reports);
			//wait
			selenium.waitForPageToLoad(wait);
			
			//choose the VOD radio button
			selenium.click(EnvObjectMap_Rep.Radio_VOD);
			selenium.click(EnvObjectMap_Rep.Btn_Next);
			selenium.waitForPageToLoad(wait);
			selenium.mouseDown("input_startDate_date");
			selenium.click(EnvObjectMap_Rep.Lbl_start);
			selenium.mouseDown("input_endDate_date");
			selenium.click(EnvObjectMap_Rep.Lbl_end);
			//select the program name
			selenium.select(EnvObjectMap_Rep.Drp_program, "label="+VAR_program);
			selenium.click(EnvObjectMap_Rep.Btn_runreport);
			selenium.waitForPageToLoad(wait);
			
			//TC_XXX:- that User is able to View Media viewing by Viewers (VOD) report
			assertTrue("TC_XXX", "Verify that User is able to View Media [viewing by Viewers (VOD) report]", date,selenium.isTextPresent("Media Viewing by Viewers (VOD)"));
				}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			//selenium.close();
			//selenium.selectWindow("Qumu Program Browser Home");
			selenium.close(); 
			selenium.stop();
			
		}
	}

}
