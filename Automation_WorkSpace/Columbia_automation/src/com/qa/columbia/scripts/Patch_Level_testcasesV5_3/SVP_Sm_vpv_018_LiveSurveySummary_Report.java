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

package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

public class SVP_Sm_vpv_018_LiveSurveySummary_Report extends TesterAsserter {
	

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
	public void test_SVP_Sm_vpv_018_LiveSurveySummary_Report() throws Exception {
		{
			try{
				setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			//local variable file name
			String local_path="SVP_LiveProgramSurveySummary_Report.xml";		
		    //String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Encoder Name
			String VAR_Encodername = utilityFunction.GetValue(local_path, "VAR_Encodername");
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archive of Live program
			String Var_LiveProgramArchive = utilityFunction.GetValue(local_path ,"Var_LiveProgramArchive");
		    //Variable for the Framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//variable for media net name
			String VAR_MedianetName = utilityFunction.GetValue(local_path ,"VAR_medianetName");
			//Variable for Encoder profile name	
			String VAR_EncoderProfileName = utilityFunction.GetValue(local_path ,"VAR_EncoderProfileName");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
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
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     		//Reusable action to add survey
     		//Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
		    //Reusable to create a live program
			Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_MedianetName);
		    //Launch the LBC
		    Launch_LBC.test_LaunchLBC(selenium, "Sm_vpv_018", Var_LiveProgramName, Var_LiveProgramArchive);
     		//wait
     		//selenium.waitForPageToLoad("30000");
		    selenium.selectWindow("null");
			utilityFunction.waitForChangesToReflect();
			//Launch the viewer portal video
			selenium.openWindow(Var_Columbia_vpURL+VAR_DomSocial+"/home.vp?debug=true", "SVP");
			//Select the viewer portal	
			selenium.selectWindow("SVP");
			selenium.windowMaximize();					
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_AllVideos, 300);	
			//selenium.setTimeout("90000");
			//utilityFunction.waitForChangesToReflect();
			//click the Live program from all videos			
		    selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
		    utilityFunction.waitForChangesToReflect();
		    utilityFunction.waitForChangesToReflect();
				
	    	selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, utilityFunction.GetValue(local_path ,"Var_LiveProgramName"));
		    utilityFunction.waitForChangesToReflect();
			
		    //Set focus on the search textbox
		    selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
		    //select the icon to perform search
		    selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
		    //Wait
		    utilityFunction.waitForChangesToReflect();	
		    //select the Live program from all Videos in search results					
		    for (int i = 1; i<50; i++){
			   String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
			   System.out.println(str_var);	   
			   if(str_var.equals(Var_LiveProgramName)){
				   selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
				   break;
			   }                  
		     }
		     //Wait      
		    utilityFunction.waitForChangesToReflect();
	        //variable for path where to save the screenshot    
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath); 
		    //Wait
	    //    utilityFunction.waitForChangesToReflect();
	      //select the LBC window
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }		
			//Click on Broadcast control tab
			selenium.click(EnvObjectMap_Rep.tab_broadcastControlLBC);
		    //wait
		    utilityFunction.waitForChangesToReflect();
			//Stop the broadcast
		    selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
		    utilityFunction.waitForChangesToReflect();
		    selenium.close();
		    //Select the parent window
		    selenium.selectWindow("null");
		    //wait
		//	utilityFunction.waitForChangesToReflect();
			//select SVP window
		    selenium.selectWindow("Qumu Program Browser Home");
		    //wait
		    utilityFunction.waitForChangesToReflect();
		    //Verify that survey is available
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.LNK_SurveyWindow))
					assertTrue("Sm_vpv_018","Verify that Survey is displayed successfully on SVP after the broadcast is stopped on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.LNK_SurveyWindow));
					break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
			selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
			utilityFunction.waitForChangesToReflect();
			selenium.selectWindow("null");     		
			//Click 'Reporting' menu
    		selenium.click(EnvObjectMap_Rep.lnk_reporting);
    		//Click 'Reports' link
    		selenium.click(EnvObjectMap_Rep.lnk_reports);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//Select Report name
    		selenium.click(EnvObjectMap_Rep.radio_LiveProgramSurveySummary);
    		//Click 'Next' button
    		selenium.click(EnvObjectMap_Rep.btn_reportNext);
    		//wait
    		selenium.waitForPageToLoad("30000");
            //select Survey as the option
    		selenium.select(EnvObjectMap_Rep.drp_SelectPollorSurvey, EnvObjectMap_Rep.txt_Survey);
    		utilityFunction.waitForChangesToReflect();
    		selenium.select("input_programId","label=" +Var_LiveProgramName);
    		//wait
    		utilityFunction.waitForChangesToReflect();
    		//click the Run report button
    		selenium.click(EnvObjectMap_Rep.btn_runReport);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//verify that 'Content Storage' report is generated
    	    assertTrue("Sm_vpv_018","Social VP: Ensure that 'Live Program Survey Summary' report is generated.",date, selenium.isTextPresent("Live Program Poll/Survey Summary Report"));
    	    assertTrue("Sm_vpv_018","Social VP: Ensure that correct Live program is displayed on 'Live Program Survey Summary' report.",date, selenium.isTextPresent(Var_LiveProgramName));
    	    selenium.close();
    	    //stop selenium
    	    utilityFunction=null;
			}catch(Exception e)
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