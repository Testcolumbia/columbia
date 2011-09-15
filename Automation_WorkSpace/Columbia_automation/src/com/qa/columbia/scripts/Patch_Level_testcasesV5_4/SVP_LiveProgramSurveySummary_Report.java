/*
* Classname                                                        SVP_LiveProgramSurveySummary_Report 
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

package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

public class SVP_LiveProgramSurveySummary_Report extends TesterAsserter {
	

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
		}

	}		
	public void test_SVP_LiveProgramSurveySummary_Report() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			String local_path="SVP_LiveProgramSurveySummary_Report.xml";		
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for Origin WMS
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
						
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archive of Live program
			String Var_LiveProgramArchive = utilityFunction.GetValue(local_path ,"Var_LiveProgramArchive");
		    //Variable for the Framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//variable for Encoder Host
			
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");		
			
			//RSS2kv4 encoder variables
			String VAR_RSS2kv4Encodername = utilityFunction.GetValue(str_path, "VAR_RSS2kv4Encodername");
			
			String VAR_RSS2kv4EncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_RSS2kv4EncoderProfileName");
			
            String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");	
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
     		 //Create a Origin WMS
    		
     		//Reusable to create a live program
			
     		Live.test_Live(selenium, "SVP_LiveProgramSurveySummary_Report", Var_LiveProgramName, VAR_RSS2kv4Encodername, VAR_RSS2kv4EncoderProfileName, VAR_WMSoriginName) ;
     		//Type program name
     		selenium.type(EnvObjectMap_Rep.SelectType_Search_Program, Var_LiveProgramName);
     		//Click on search button
     		selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
     		//wait for the page to load
     		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Edit program
     		selenium.click("link="+Var_LiveProgramName);
     		//wait for the page to load
     		selenium.waitForPageToLoad("60000");
     		//Click on Edit for Program Assets 
     		selenium.click(EnvObjectMap_Rep.btn_editProgramAsset);
    		selenium.waitForPageToLoad("30000");
    		selenium.click("selectSurvey");
    		selenium.click(EnvObjectMap_Rep.btn_selectSurveyLive);
        	//wait for changing the phase
        	utilityFunction.waitForElementToVisible(selenium, "dijit_layout__TabButton_8", 300);
        	//Move to the Search section
        	selenium.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
        	//Set focus on the searcg textbox
        	selenium.focus(EnvObjectMap_Rep.txt_searchSurveyLive);
        //	sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
        	//provide Poll name to Search it from Panel
        	selenium.type(EnvObjectMap_Rep.txt_searchSurveyLive, VAR_SurveyName);
        	//Click Search button 
        	selenium.click(EnvObjectMap_Rep.btn_searchSurveyLive);
        	//wait for changing the phase
        	utilityFunction.waitForChangesToReflect();
        	//Select Slides from Search results
        	selenium.click(EnvObjectMap_Rep.lnk_selectSearchedSurvey);
        	//Click next button on Program Content page           
        	selenium.click(EnvObjectMap_Rep.btn_selectedSearchedSurveyLive);
        	
        	utilityFunction.waitForChangesToReflect();
        	selenium.click(EnvObjectMap_Rep.btn_summary);
        	
        	selenium.waitForPageToLoad("60000");
        	selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);  	
    		
		    //Launch the LBC
		    Launch_LBC.test_LaunchLBC(selenium, "SVP_LiveProgramSurveySummary_Report", Var_LiveProgramName, Var_LiveProgramArchive);
     		//wait
     		//selenium.waitForPageToLoad("30000");
		    selenium.selectWindow("null");

		    String SVP_url = Var_Columbia_vpURL + VAR_DomSocial + "/home.vp"; 
		    //open the URL
		     selenium.openWindow(SVP_url +"?debug=true", "SVP");
		     selenium.selectWindow("SVP");
		     utilityFunction.waitForChangesToReflect();
		     for (int second = 0;second<=500; second++) {
				try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_AllVideos)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//selenium.setTimeout("90000");
			//utilityFunction.waitForChangesToReflect();
			//click the Live program from all videos			
		    selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
		    utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.TBX_SearchSVP, 300)	;	
	    	selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, Var_LiveProgramName);
		  //  utilityFunction.waitForChangesToReflect();			
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
	
	        //wait
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
		    selenium.selectWindow("SVP");
		    //wait
		    utilityFunction.waitForChangesToReflect();
		    //Verify that survey is available
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.CHK_SurveyWindow))
					assertTrue("SVP_LiveProgramSurveySummary_Report","Verify that Survey is displayed successfully on SVP after the broadcast is stopped on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.CHK_SurveyWindow));
					break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
			selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
			utilityFunction.waitForChangesToReflect();
			selenium.close();
			selenium.selectWindow("null");     		
			//Click 'Reporting' menu
    		selenium.click(EnvObjectMap_Rep.lnk_reporting);
    		//Click 'Reports' link
    		selenium.click(EnvObjectMap_Rep.lnk_reports);
    		//wait
    		selenium.waitForPageToLoad("60000");
    		//Select Report name
    		selenium.click(EnvObjectMap_Rep.radio_LiveProgramSurveySummary);
    		//Click 'Next' button
    		selenium.click(EnvObjectMap_Rep.btn_reportNext);
    		//wait
    		selenium.waitForPageToLoad("60000");
            //select Survey as the option
    		selenium.select(EnvObjectMap_Rep.drp_SelectPollorSurvey, EnvObjectMap_Rep.txt_Survey);
    		utilityFunction.waitForChangesToReflect();
    	//	selenium.select("input_programId","label=" +"LiveBcast_RSS2K4_MediaNet");
    		selenium.select("input_programId","label=" +Var_LiveProgramName);
    		//wait
    		utilityFunction.waitForChangesToReflect();
    		//click the Run report button
    		selenium.click(EnvObjectMap_Rep.btn_runReport);
    		//wait
    		selenium.waitForPageToLoad("30000");
    		//verify that 'Content Storage' report is generated
    	    assertTrue("SVP_LiveProgramSurveySummary_Report","Social VP: Ensure that 'Live Program Survey Summary' report is generated.",date, selenium.isTextPresent("Live Program Poll/Survey Summary Report"));
    	    assertTrue("SVP_LiveProgramSurveySummary_Report","Social VP: Ensure that correct Live program is displayed on 'Live Program Survey Summary' report.",date, selenium.isTextPresent(Var_LiveProgramName));
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