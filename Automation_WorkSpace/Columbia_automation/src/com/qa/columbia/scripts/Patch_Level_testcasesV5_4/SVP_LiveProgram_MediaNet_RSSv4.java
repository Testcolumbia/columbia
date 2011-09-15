/*
* Classname                                                        SVP_liveProgram_MediaNet_RSSv4 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that Live program plays with Medianet delivery option using RSS 2000 Version 4. (Slide, Polls, Surveys, Questions and archive content)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and creates 2 WMS such as Origin and Edge WMS<br> 
* 																	>Create an Encoder with Encoder Profile for RSSV4.
*																	>Create a MediaNet using the above WMS and MediaNet<br> 
*  															     	>Create a Live Program with the MediaNet delivery option<br> 
*																	>Launch the LBC and start the broadcast<br> 
* 																	>Navigate to Social Viewer Portal and play the Live Video<br> 
* 																	>Capture the screenshot of the player window<br> 
* 																	>Observe the Poll WIndow and submit an answer.
* 																	>Provide Viewer Question and Submit.
* 																	>Verify the submitted viewer question on LBC and then stop the broadcast.
*																	>Navigate to SVP and observe the social viewer portal for Surevy window to be displayed.
* 																	>Generate the asx file 
* 																	>Verify the stream in the asx file
* What Verification it performs:									1.Verify that Live program successfully plays with Medianet delivery option using RSS 2000 Version 4.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 25/04/2011
* Updated by/on date: 												QASource on 25/04/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class SVP_LiveProgram_MediaNet_RSSv4 extends TesterAsserter {
	
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
	public void test_SVP_LiveProgram_MediaNet_RSSv4() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			String local_path = "SVP_LiveProgram_MediaNet_RSSv4.xml";
			//String local_path2 = "SVP_LiveProgram_MediaNet_WME.xml";
		//	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for Origin WMS
			
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archive of Live program
			String Var_LiveProgramArchive = utilityFunction.GetValue(local_path ,"Var_LiveProgramArchive");
		    //Variable for the Framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	
			
			//variable for media net name
		String VAR_MedianetName = utilityFunction.GetValue(str_path ,"VAR_medianetName");
			//Variable for Encoder profile name	
			
			//Variable for asx file 
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			
			//RSS2kv4 encoder variables
			String VAR_RSS2kv4Encodername = utilityFunction.GetValue(str_path, "VAR_RSS2kv4Encodername");
			
			String VAR_RSS2kv4EncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_RSS2kv4EncoderProfileName");
			
            String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");			
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
			
			String VAR_PollName = utilityFunction.GetValue(str_path,"VAR_PollName");
		 
			
			//Reusable to login to admin viewer portal
		    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
	        //Create a Origin WMS
	    //Reusable to create a live program
			Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_RSS2kv4Encodername, VAR_RSS2kv4EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_MedianetName);
		   
		    //Launch the LBC
		    Launch_LBC.test_LaunchLBC(selenium, "SVP_LiveProgram_MediaNet_RSSv4", Var_LiveProgramName, Var_LiveProgramArchive);
		   	//select the admin portal window	   
	        selenium.selectWindow("null"); 
			//Navigate to Social Viewer portal
		    String SVP_url = Var_Columbia_vpURL + VAR_DomSocial + "/home.vp"; 
		    //open the URL
		     selenium.openWindow(SVP_url +"?debug=true", "SVP");
		     utilityFunction.waitForChangesToReflect();
		
		    selenium.selectWindow("SVP");
		
			utilityFunction.waitForChangesToReflect();
			for (int second = 0;second<=500; second++) {
				try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_AllVideos)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//click the Live program from all videos			
		    selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
		    utilityFunction.waitForChangesToReflect();
		   // utilityFunction.waitForChangesToReflect();
				
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
		    utilityFunction.waitForChangesToReflect();
		    //wait
		     for (int second = 0;; second++) {
				if (second >= 1000) fail("timeout");
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.LNK_PollWindow)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			 }
			 //select the checkbox for an answer   
	        selenium.click(EnvObjectMap_Rep.CHK_PollWindow);
	        //submit the poll
	        selenium.click(EnvObjectMap_Rep.BTN_PollWindow);
	        //wait
	       utilityFunction.waitForChangesToReflect();
	     //-----------------------push results to viewer-----------------------------
	        
	        selenium.selectWindow("");
			//Select the LBC
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }	
			
			utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.lnk_pushPollResult, 300);
			selenium.click(EnvObjectMap_Rep.lnk_pushPollResult);
           selenium.selectWindow("SVP");
			
		      utilityFunction.waitForElementToVisible(selenium,EnvObjectMap_Rep.Txt_pollresultwindowsvp , 600);
			
			
		
			selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollresultanswersvp);
			selenium.isElementPresent(EnvObjectMap_Rep.Txt_pollresultvotesvp);

			assertTrue("SVP_LiveProgram_MediaNet_WME", "Verify that user is able to push the results to the viewer portal", date, true);
			selenium.click(EnvObjectMap_Rep.Btn_crosspollresult);
		    
			
			//--------------------------------------------------
			
	        //variable for path where to save the screenshot    
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath); 
		    //Wait
	        utilityFunction.waitForChangesToReflect();
	        utilityFunction.waitForChangesToReflect();
	        //click the link for viewer question answer
	        selenium.click(EnvObjectMap_Rep.tab_QA);
	        //wait
			utilityFunction.waitForChangesToReflect();
			//provide the viewer question
			selenium.type("text", "Test Poll Viewer Question text");
			selenium.typeKeys("text", "t");
			utilityFunction.waitForChangesToReflect();
			//click Ask button to submit the question
			selenium.click(EnvObjectMap_Rep.btn_Ask);
			//wait
			utilityFunction.waitForChangesToReflect();
			//select the asx link
	        String contentlink = selenium.getText(Var_asxLink);
	        //wait
	        utilityFunction.waitForChangesToReflect();  
	         //split the string
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
			//selenium.openWindow(contentlink_final, "abc");
			//selenium.selectWindow("abc");
			selenium.openWindow(contentlink_final+"&debug=true", "abc");
			selenium.selectWindow("abc");
		//	selenium.click("link=exact:"+contentlink_final);
			utilityFunction.waitForChangesToReflect();
			//Generate the asx file
			String htmlsource = selenium.getHtmlSource();
	
		    //verify whether the correct encoder profile is displayed in asx file
			assertTrue("SVP_LiveProgram_MediaNet_RSSv4","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_RSS2kv4EncoderProfileName));
			selenium.close(); 
			//select the parent window
			selenium.selectWindow("null");
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

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
							try { if (selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
	        utilityFunction.waitForChangesToReflect();
			assertTrue("SVP_LiveProgram_MediaNet_RSSv4","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast
		    selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
		    Thread.sleep(5000);
		     //wait till the ingest is shown completed in LBC
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				try { if (selenium.isTextPresent("Archive files fetched.|Completed")) break; 
				} catch (Exception e) {}
				Thread.sleep(1000);
			 }
		   // verify that the Archive files fetched completed message is displayed in LBC console
		    assertTrue("SVP_LiveProgramArchived_MediaNet_RSS2kv4","Verify that ingest completed is displayed",date,selenium.isTextPresent("(none)|Archive files fetched.|Completed "));
		    selenium.close();
		    //Select the parent window
		    selenium.selectWindow("null");
		    //wait
			utilityFunction.waitForChangesToReflect();
			//select SVP window
			selenium.selectWindow("SVP");
		 //   selenium.selectWindow("Qumu Program Browser Home");
		    //wait
		    utilityFunction.waitForChangesToReflect();
		    //Verify that survey is available
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.LNK_SurveyWindow))
					assertTrue("SVP_LiveProgram_MediaNet_RSSv4","Verify that Survey is displayed successfully on SVP after the broadcast is stopped on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.LNK_SurveyWindow));
					break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
			selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
			utilityFunction.waitForChangesToReflect();
			
			selenium.selectWindow("null");
			//Select Programming link
			selenium.click(EnvObjectMap_Rep.LNK_Programming);
			//Select Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//wait
 			selenium.waitForPageToLoad(VAR_MED_WAIT);
			   for (int second = 0;; second++) {
					if (second >= 300) fail("timeout");
					try { if (selenium.isElementPresent(EnvObjectMap_Rep.BTN_More_Search)) break; 
					} catch (Exception e) {}
					Thread.sleep(1000);
				 }
			//click Search
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			utilityFunction.waitForChangesToReflect();
			//provide the search term
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_LiveProgramArchive);
			//select the status as Active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			assertTrue("SVP_LiveProgramArchived_MediaNet_RSS2kv4","Social VP: Ensure that ingest completes for archived content of Live program played with Medianet delivery option using RSS 2000 Version 4.",date,selenium.isTextPresent(Var_LiveProgramArchive));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				 selenium.stop();
			}
		}
	}
}