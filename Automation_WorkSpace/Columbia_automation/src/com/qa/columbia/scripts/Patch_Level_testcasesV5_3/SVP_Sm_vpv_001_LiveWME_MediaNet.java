/*
* Classname                                                        SVP_Sm_vpv_001_LiveWME_MediaNet 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_001_LiveWME_MediaNet extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_001_LiveWME_MediaNet() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//String local_path = "SVP_LiveProgramArchived_MediaNet_WME.xml";
			String local_path = "SVP_LiveProgram_MediaNet_WME.xml";
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
			//Variable for the WMS name
			String VAR_WMSoriginName = utilityFunction.GetValue(str_path ,"VAR_WMSoriginName_new");
			//Variable for the host IP
			String VAR_WMSoriginHost = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHost");
			//Variable for the wms HTTP port
			String VAR_WMSoriginHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSoriginHTTPport");
			//Variable for the wms user name
			String VAR_WMSoriginUsername = utilityFunction.GetValue(str_path ,"VAR_WMSoriginUsername");
			//Variable for the wms password
			String VAR_WMSoriginPassword = utilityFunction.GetValue(str_path ,"VAR_WMSoriginPassword");
			//Variable for the edge WMS name
			String VAR_WMSedgeName = utilityFunction.GetValue(str_path ,"VAR_WMSedgeName_new");
			//Variable for the edge WMS host IP
			String VAR_WMSedgeHost = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHost");
			//Variable for the edge WMS HTTP port
			String VAR_WMSedgeHTTPport = utilityFunction.GetValue(str_path ,"VAR_WMSedgeHTTPport");
			//Variable for the edge WMS user-name
			String VAR_WMSedgeUsername = utilityFunction.GetValue(str_path ,"VAR_WMSedgeUsername");
			//Variable for the edge WMS password
			String VAR_WMSedgePassword = utilityFunction.GetValue(str_path ,"VAR_WMSedgePassword");
			//Variable for the Encoder Name
			String VAR_Encodername = utilityFunction.GetValue(str_path ,"VAR_Encodername");
			//Variable for the encoder host name
			String VAR_EncoderHostIP = utilityFunction.GetValue(str_path ,"VAR_EncoderHostIP");
			//Variable for the Qumu Encoder service Port 
			String VAR_EncoderServicePort = utilityFunction.GetValue(str_path ,"VAR_EncoderServicePort");
			//Variable for the Qumu Encoder Profile
			String VAR_EncoderProfileName = utilityFunction.GetValue(str_path ,"VAR_EncoderProfileName");
			//Variable for the Document root directory path
			String VAR_EncoderDocRoot = utilityFunction.GetValue(str_path ,"VAR_EncoderDocRoot");
			//Variable for the Encoder Port
			String VAR_EncoderPort = utilityFunction.GetValue(str_path ,"VAR_EncoderPort");
			//Variable for the saved encoder profile file name (with path)
			String VAR_EncoderProfileFileName= utilityFunction.GetValue(str_path ,"VAR_EncoderProfileFileName");
			//variable for media net name
			String VAR_MedianetName = utilityFunction.GetValue(local_path ,"VAR_medianetName");
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
			String VAR_SurveyName = utilityFunction.GetValue(local_path ,"SurveyName");
			//Variable for Poll name
			String VAR_PollName = utilityFunction.GetValue(local_path ,"PollName");
			//Variable for the Question Name
			String VAR_QuestionName = utilityFunction.GetValue(local_path ,"QuestionName");		
			//Variable for the Question Explanation
			String VAR_QuestionExp = utilityFunction.GetValue(local_path,"QuestionExp");		
			//Variable for the Question Type
			String VAR_QuestionType = utilityFunction.GetValue(local_path ,"QuestionType");	
			//Variable for the slide display name
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path ,"VAR_SlideDisplayName");		
			//Variable for the Slide's file name
			String VAR_SlideFileName = utilityFunction.GetValue(local_path ,"VAR_SlideFileName");				
			//Reusable to login to admin viewer portal
		    Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
		    //Create a Origin WMS
		    Create_WMS.create_WMS(selenium, VAR_WMSoriginName, VAR_WMSoriginHost, VAR_WMSoriginHTTPport, VAR_WMSoriginUsername, VAR_WMSoriginPassword);
			//Reusable action for creating WMS 
			Create_WMS.create_WMS(selenium, VAR_WMSedgeName, VAR_WMSedgeHost, VAR_WMSedgeHTTPport, VAR_WMSedgeUsername, VAR_WMSedgePassword);
			//Reusable action to create a Medianet 
		    Create_medianet.create_medianetDNS(selenium, VAR_MedianetName, VAR_WMSoriginName, VAR_WMSedgeName, VAR_WMSedgeHost);
		    //Reusable to create WME
		    Create_WME.create_WME(selenium,VAR_Encodername, VAR_EncoderHostIP, VAR_EncoderServicePort, VAR_EncoderDocRoot, VAR_EncoderProfileName, VAR_EncoderPort, VAR_EncoderProfileFileName);
		  	//Reusable action for adding survey in content
			Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action for uploading slides
			Upload_Media.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
			//Reusable action for adding poll in content
		    Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
			//Reusable action for creating live program having slide, poll, survey and question option defined
		    Create_Program.test_create_LiveProg(selenium, Var_LiveProgramName, VAR_Encodername, VAR_EncoderProfileName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName, VAR_MedianetName);
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
			assertTrue("Sm_vpv_001","Verify that Live Broadcast is started successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_stopBroadcast));
			//Click Start Broadcast button on LBC
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
			{
				selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
				utilityFunction.waitForChangesToReflect();
				assertTrue("Sm_vpv_001","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
			}			
		    
		    
	        selenium.selectWindow("null");	        
			utilityFunction.waitForChangesToReflect();
			//Launch the viewer portal video
			selenium.openWindow(Var_Columbia_vpURL+VAR_DomSocial+"/home.vp?debug=true", "SVP");
			//Select the viewer portal	
			selenium.selectWindow("SVP");
			selenium.windowMaximize();					
			utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_AllVideos, 300);	
			//click the All Videos link to search the live program
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
			utilityFunction.waitForChangesToReflect();
		   selenium.type(EnvObjectMap_Rep.TBX_SearchSVP,Var_LiveProgramName);
		   //utilityFunction.waitForChangesToReflect();
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
			    for (int second = 0;second >= 1000; second++) {
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.LNK_PollWindow))
					assertTrue("Sm_vpv_001","Verify that poll window is displayed successfully on the player window.",date,selenium.isElementPresent(EnvObjectMap_Rep.LNK_PollWindow));
				break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			 //select the checkbox for an answer   
	        selenium.click(EnvObjectMap_Rep.CHK_PollWindow);
	        //submit the poll
	        selenium.click(EnvObjectMap_Rep.BTN_PollWindow);
	        //wait
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
			assertTrue("Sm_vpv_001","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_EncoderProfileName));
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
			assertTrue("Sm_vpv_001","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
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
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			finally{
			selenium.close();
			selenium.stop();
			}
	    }				 
	}	
}