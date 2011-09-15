/*
* Classname                                                        SVP_LiveProgram_AudiencewithPoll 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that Live program plays with audience delivery option using WME. (Slide, Polls, Surveys, Questions and archive content)<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery>Delivery Options and add a WMS delivery option<br> 
*																	>Navigate to Audience and create a new audience with the above WMS delivery option.<br> 
*  															     	>Navigate to Resources>Encoders and create a new WME encoder.<br> 
*																	>Navigate to Programming>Contents and add a poll.<br> 
* 																	>Navigate to Programming>Contents and add a survey.<br> 
* 																	>Navigate to Programming>Contents and add a slide.<br> 
* 																	>Navigate to Programming>Programs and add a live program using the above mentioned encoder, slide,poll,survey, audience and audience question.<br>
* 																	>Launch  the LBC and and start the broadcast (with archiving enabled)<br>
* 																	>Push the slide and poll from LBC<br> 	
*  													     			>Launch the viewer portal and play the live program<br> 
*   																>Answer the poll, view the streams and submit the survey<br>
*  													     			>Navigate to LBC and stop the broadcast and wait for the archiving to complete.<br> 
*   																>Navigate to Programming>Content and view the archived file.<br>  																			 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;


import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;

import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class SVP_sm_vpv_022_LiveProgram_AudiencewithPoll extends TesterAsserter {
	
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
	public void test_LiveProgram_AudiencewithPoll() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String str_path ="Global_variables.xml";
								//Local Variable file name
			String local_path="SVP_sm_vpv_022_LiveProgram_AudiencewithPoll.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(str_path ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(str_path ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(str_path ,"VAR_DomSocial");
			
			String VAR_MED_WAIT=utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			
			
			String VAR_audienceName = utilityFunction.GetValue(local_path ,"VAR_audienceName");
			String VAR_audienceIP = utilityFunction.GetValue(local_path ,"VAR_audienceIP");
			String VAR_audienceHost = utilityFunction.GetValue(local_path ,"VAR_audienceHost");
			String VAR_audiencePort = utilityFunction.GetValue(local_path ,"VAR_audiencePort");
			
			
			String VAR_httpName = utilityFunction.GetValue(str_path ,"VAR_httpName");
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			
			// Variable for streaming media file name
			String VAR_WMSName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName");
			//Variable for the host IP
			
			//Variable for the edge WMS HTTP port
            String VAR_WMEEncodername = utilityFunction.GetValue(str_path ,"VAR_Encodername");
			
			String VAR_WMEEncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_EncoderProfileName");
			
			String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");			
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
			
			String VAR_PollName = utilityFunction.GetValue(str_path,"VAR_PollName");
		
											
				String VAR_scriptName="LiveProgram_Audiencewithpoll";
				
				String Var_LiveProgramArchive = utilityFunction.GetValue(local_path ,"Var_LiveProgramArchive");
				String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
				
				//login to the application
			Login.test_login(selenium, VAR_user, VAR_password, VAR_domain);
			
	
			//Create Audience
	Create_Audience.test_Create_Audience(selenium, VAR_audienceName, VAR_audienceHost, VAR_audienceIP, VAR_audiencePort, VAR_httpName, VAR_httpName, VAR_WMSName);
			
	//Create program with audience----------------------------------------------------------
			
	Create_Program.test_Live_audience(selenium, VAR_scriptName, VAR_program, VAR_WMEEncodername, VAR_WMEEncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_audienceName);
		
		 assertTrue("sm_vpv_022","Verify that Live Program is created successfully.",date,selenium.isTextPresent(VAR_program));

		    				 
		  //Open the Programs age
			selenium.click(EnvObjectMap_Rep.LNK_Programs);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program, VAR_program);
			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Click Live Broadcast icon
			selenium.click(EnvObjectMap_Rep.LNK_LBC);
        	//Click Launch Broadcast Now
			selenium.click(EnvObjectMap_Rep.LNK_Launch_Now);
			for (String windowName1 : selenium.getAllWindowNames()) {
				if (windowName1.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.waitForPopUp(windowName1, VAR_MED_WAIT);
				}
	        }
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }
			if(!selenium.isChecked(EnvObjectMap_Rep.chk_ArchiveLBC))
			{
				selenium.click(EnvObjectMap_Rep.chk_ArchiveLBC);
			}
			selenium.type("//tbody[2]/tr/td[2]/input", Var_LiveProgramArchive);
			//Click Save button on LBC
			selenium.click(EnvObjectMap_Rep.Btn_Save_LBC_Summary);
			//wait for changing the phase
			utilityFunction.waitForChangesToReflect();
			//Click Start Sources button
			selenium.click(EnvObjectMap_Rep.Btn_Start_Source);
			//wait for changing the phase
			for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isVisible(EnvObjectMap_Rep.Btn_Prov_Network)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Click Provision Network button
			selenium.click(EnvObjectMap_Rep.Btn_Prov_Network);
			//wait for changing the phase
			for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isVisible(EnvObjectMap_Rep.Btn_Start_Bcast)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//Click Start Broadcast button
			selenium.click(EnvObjectMap_Rep.Btn_Start_Bcast);
			//wait for changing the phase

				for (int second = 0;; second++) {
					if (second >= 300) fail("timeout");
					try { if (selenium.isVisible(EnvObjectMap_Rep.btn_stopBroadcast)) break; } catch (Exception e) {}
					Thread.sleep(1000);
			//}
			}
		    //Check Point to test that Live Broadcast is started
			assertTrue("sm_vpv_022","Verify that Live Broadcast is started successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_stopBroadcast));
			//Click Start Broadcast button on LBC
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
			{
				selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
				utilityFunction.waitForChangesToReflect();
				assertTrue("sm_vpv_022","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
			}			
		    
		    
	        selenium.selectWindow("null");	        
	
		    String SVP_url = Var_Columbia_vpURL + VAR_domain + "/home.vp"; 
		    //open the URL
		     selenium.openWindow(SVP_url +"?debug=true", "SVP");
		     utilityFunction.waitForChangesToReflect();
		     selenium.selectWindow("SVP");
		     utilityFunction.waitForChangesToReflect();
		     for (int second = 0;second<=500; second++) {
				try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_AllVideos)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			//click the All Videos link to search the live program
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
		   selenium.type(EnvObjectMap_Rep.TBX_SearchSVP,VAR_program);
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
			   if(str_var.equals(VAR_program)){
				   selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
				   break;
			   }                  
		   }
		   //Wait      
		   utilityFunction.waitForChangesToReflect();
		   utilityFunction.waitForChangesToReflect();
		   
		   
		   
			for (String windowName : selenium.getAllWindowNames()) {
				if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
					selenium.selectWindow(windowName);
	            }
	        }	
			selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
			
			selenium.selectWindow("Qumu Program Browser Home");
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
	        
	        assertTrue("Sm_vpv_022", "Verify that poll answer is submitted successfully from the viewer portal.", date, !(selenium.isVisible(EnvObjectMap_Rep.CHK_PollWindow)));
	        //wait
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

			assertTrue("Sm_vpv_022", "Verify that user is able to push the results to the viewer portal", date, true);
			selenium.click(EnvObjectMap_Rep.Btn_crosspollresult);
		      //--------------------------------------------------
			selenium.selectWindow("Qumu Program Browser Home");
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
			 //variable for path where to save the screenshot    
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_program + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath); 
		    //Wait
	        utilityFunction.waitForChangesToReflect();
	      //select the asx link
	        String contentlink = selenium.getText(Var_asxLink);
	        //wait
	        utilityFunction.waitForChangesToReflect();  
	         //split the string
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");
			selenium.openWindow(contentlink_final+"&debug=true", "abc");
			selenium.selectWindow("abc");
		
			utilityFunction.waitForChangesToReflect();
			//Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
		    //verify whether the correct encoder profile is displayed in asx file
			assertTrue("Sm_vpv_022","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_WMEEncoderProfileName));
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
				if (second >= 300) fail("timeout");
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		     utilityFunction.waitForChangesToReflect();
			assertTrue("sm_vpv_022","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast
		   selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
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
			selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
			utilityFunction.waitForChangesToReflect();
				
			
		utilityFunction=null;
		   }
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			selenium.close();
			selenium.stop();
		}
	}
	
	
}
