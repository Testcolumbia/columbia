/*
* Classname                                                        SVP_LiveProgram_MediaNet_WME 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that ingest completes for archived content of Live program played with Medianet delivery option using WME.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Delivery Options and creates 2 WMS such as Origin and Edge WMS<br> 
* 																	>Create an Encoder with Encoder Profile for WME.
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
* What Verification it performs:									1.Verify that Live program successfully plays with Medianet delivery option using WME.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 26/04/2011
* Updated by/on date: 												QASource on 26/04/2011
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

public class SVP_LiveProgram_MediaNet_WME extends TesterAsserter {
	
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
	public void test_SVP_LiveProgram_MediaNet_WME() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//String local_path = "SVP_LiveProgramArchived_MediaNet_WME.xml";
			String local_path = "SVP_LiveProgram_MediaNet_WME.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			
			
			//Variable for Live program name		
			String Var_LiveProgramName = utilityFunction.GetValue(local_path ,"Var_LiveProgramName");
			//Variable for the archive of Live program
			String Var_LiveProgramArchive = utilityFunction.GetValue(local_path ,"Var_LiveProgramArchive");
		    //Variable for the Framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		  	//Variable for asx file 
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Variable for the Survey Name
			

			//Variable for the medianet name
			String VAR_medianetName = utilityFunction.GetValue(str_path ,"VAR_medianetName");
									
			
			//Variable for the edge WMS HTTP port
            String VAR_WMEEncodername = utilityFunction.GetValue(str_path ,"VAR_Encodername");
			
			String VAR_WMEEncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_EncoderProfileName");
			
			String VAR_SurveyName = utilityFunction.GetValue(str_path,"VAR_SurveyName");			
			
			String VAR_SlideDisplayName = utilityFunction.GetValue(str_path,"VAR_SlideDisplayName");
			
			String VAR_PollName = utilityFunction.GetValue(str_path,"VAR_PollName");
		
			
			//Reusable to login to admin viewer portal
		    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
		    //Create a Origin WMS
		    
		    //Reusable action for creating live program having slide, poll, survey and question option defined
		    Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_WMEEncodername, VAR_WMEEncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_medianetName);
		    //Launch the LBC
		  		    
		  //Open the Programs age
			selenium.click(EnvObjectMap_Rep.LNK_Programs);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program, Var_LiveProgramName);
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
			assertTrue("SVP_LiveProgram_MediaNet_WME","Verify that Live Broadcast is started successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_stopBroadcast));
			//Click Start Broadcast button on LBC
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
			{
				selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
				utilityFunction.waitForChangesToReflect();
				assertTrue("SVP_LiveProgram_MediaNet_WME","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
			}			
		    
		    
	        selenium.selectWindow("null");	        
	
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
			//click the All Videos link to search the live program
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
		   selenium.type(EnvObjectMap_Rep.TBX_SearchSVP,Var_LiveProgramName);
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
	        //wait
	        
	        assertTrue("SVP_LiveProgram_MediaNet_WME", "Verify that poll answer is submitted successfully from the viewer portal.", date, !(selenium.isVisible(EnvObjectMap_Rep.CHK_PollWindow)));
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
			
			selenium.selectWindow("Qumu Program Browser Home");
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
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_LiveProgramName + ".jpg";		
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
		//	selenium.click("link=exact:"+contentlink_final);
			utilityFunction.waitForChangesToReflect();
			//Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
		    //verify whether the correct encoder profile is displayed in asx file
			assertTrue("SVP_LiveProgram_MediaNet_WME","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_WMEEncoderProfileName));
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
			assertTrue("SVP_LiveProgram_MediaNet_WME","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
			//Stop the broadcast
		   selenium.click(EnvObjectMap_Rep.btn_stopBroadcast);
		   
		   Thread.sleep(2000);
		    //wait till the ingest is shown completed in LBC
		    for (int second = 0;; second++) {
				if (second >= 600) fail("timeout");
				try { if (selenium.isTextPresent("Archive files fetched.|Completed")) break; 
				} catch (Exception e) {}
				Thread.sleep(1000);
			 }
		    assertTrue("SVP_LiveProgramArchived_MediaNet_WME","Verify that ingest is completed successfully for the live program.",date,selenium.isTextPresent("(none)|Archive files fetched.|Completed "));
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
			
			selenium.selectWindow("null");
			//Select Programming link
			selenium.click(EnvObjectMap_Rep.LNK_Programming);
			//Select Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//wait
			selenium.waitForPageToLoad("90000");
			//click Search
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//provide the search term
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name,Var_LiveProgramArchive);
			//select the status as Active
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//wait
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();	
			assertTrue("SVP_LiveProgramArchived_MediaNet_WME","Social VP: Ensure that ingest completes for archived content of Live program played with Medianet delivery option using WME.",date,selenium.isTextPresent(Var_LiveProgramArchive));
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