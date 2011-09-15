/*
* Classname                                                        SVP_Sm_vpv_028_LiveProgram_Audience
*
* Version info
*
* Copyright notice
*                                                                 1.A domain say “domain_new” configured with Viewer Portal Classic should exist in vcc6.0.
                                                                  2.A 'Configured URL' delivery option say 'Conf_URL' should exist in above domain.
                                                                  3. Above 'Configured URL' should be added in an Audience say 'audi1' in above domain.
                                                                  4.A download and Live access point should exist in above delivery option.
                                                                  5.4.A Live Program say 'Live_1' should be created using above Configuration URL delivery option.
                                                                  6.Prerequisite 'Live_1' program should be broadcasting.
* What Verification it performs:	 								1.On Demand program should be played successfully in Window Media player with 'Configured URL' delivery option.
*                                                                   2.Correct stream should be displayed in .asx file.							
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
import org.apache.commons.lang.StringUtils;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_028_LiveProgram_Audience extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalvariableFile ="Global_Variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalvariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalvariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalvariableFile, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}		
	}		
	public void test_SVP_Sm_vpv_028_LiveProgram_Audience() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global Variables file name
			String globalvariableFile ="Global_Variables.xml";
			//Variables from Setup file 
			String local_path ="Setup_Script.xml";
			//Local VARiable file name
			String localvariableFile="SVP_Sm_vpv_028_LiveProgram_Audience.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalvariableFile ,"VAR_USR");
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalvariableFile ,"VAR_PWD");
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalvariableFile ,"Var_DomainSocial");
			//Variable for audience name
			String VAR_audienceName = utilityFunction.GetValue(localvariableFile ,"VAR_audienceName");
			//Variable for audience web host
			String VAR_audienceIP = utilityFunction.GetValue(globalvariableFile ,"VAR_audienceIP");
			//Variable for audience local host 
			String VAR_audienceHost = utilityFunction.GetValue(globalvariableFile ,"VAR_audienceHost");
			//Variable for audience port
			String VAR_audiencePort = utilityFunction.GetValue(globalvariableFile ,"VAR_audiencePort");
			////Variable for http Dopt
			String VAR_httpName = utilityFunction.GetValue(globalvariableFile ,"VAR_httpName");
			// Variable for program name
			String VAR_LiveProgramName=utilityFunction.GetValue(localvariableFile ,"VAR_programName");
			//Variable for framework path
			 String VAR_frameWork_Path = utilityFunction.GetValue(globalvariableFile ,"Var_frameWork_Path");	
			//Variable for window media encoder name	
			 String VAR_WMEName = utilityFunction.GetValue(local_path,"VAR_WMEName");
			//Variable for window media encoder profile name	
			String VAR_WMEProName = utilityFunction.GetValue(local_path,"VAR_WMEProName");
			//VideoNet edge device name
			String VAR_VideoNetEdgeDO_Name = utilityFunction.GetValue(globalvariableFile, "Var_VEasWMS_DO");
			//Variable for survey name	
			String VAR_SurveyName = utilityFunction.GetValue(local_path,"VAR_SurveyName");			
			//Variable for slide name			
			String VAR_SlideDisplayName = utilityFunction.GetValue(local_path,"VAR_SlideDisplayName");
			//Variable for poll name	
			String VAR_PollName = utilityFunction.GetValue(local_path,"VAR_PollName");
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			//Reusable to create audience Dopt
		Create_Audience.test_Create_Audience(selenium, VAR_audienceName, VAR_audienceHost, VAR_audienceIP, VAR_audiencePort, VAR_httpName, VAR_httpName, VAR_VideoNetEdgeDO_Name);
			
	        //Create program
	Create_Program.test_Live_audience(selenium, VAR_LiveProgramName, VAR_WMEName, VAR_WMEProName, VAR_SlideDisplayName, VAR_PollName, VAR_SurveyName,VAR_audienceName);
		 assertTrue("Sm_vpv_028","Verify that Live Program is created successfully.",date,selenium.isTextPresent(VAR_LiveProgramName));

		    //Reusable action for Launching LBC and start the broadcast
			Launch_LBC.StartBroadcast(selenium, VAR_LiveProgramName);
			if(selenium.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
			{
				selenium.click(EnvObjectMap_Rep.Btn_Flip_Slide);
				utilityFunction.waitForChangesToReflect();
				assertTrue("Sm_vpv_028","Verify that Slide is pushed successfully from LBC.",date,selenium.isTextPresent("slide 1"));
				}
				
				//call to Launch classic view portal
				 Launch_VP.Launch_SVP(selenium, VAR_domain);
		        	//call to reusable function for play VOD
				    Play_Program.play_Porgram(selenium, VAR_domain, VAR_LiveProgramName);
		            
				   String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
					utilityFunction.waitForChangesToReflect();
			     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
					contentlink_final=contentlink_final.trim();		
					System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");
					selenium.openWindow(contentlink_final+"&debug=true", "ASX");
				    selenium.selectWindow("ASX");
				    Thread.sleep(2000);
				    
				    //Generate the asx file
					String htmlsource = selenium.getHtmlSource();
					//System.out.println(htmlsource);	
				 	assertTrue("Sm_vpv_028","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, VAR_WMEProName));
					selenium.close();
				selenium.selectWindow("null");
				   
					for (String windowName : selenium.getAllWindowNames()) {
						if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
							selenium.selectWindow(windowName);
			            }
			        }	
					if(selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
					{
						selenium.click(EnvObjectMap_Rep.lnk_pushPoll);
						utilityFunction.waitForChangesToReflect();
						utilityFunction.waitForChangesToReflect();
						assertTrue("Sm_vpv_028","Verify that Poll Question is pushed successfully from LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
					}
					//select the viewer portal
			   	selenium.selectWindow("SVP");
							
			      utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_PollWindow, 600);
						 //select the checkbox for an answer   
				        selenium.click(EnvObjectMap_Rep.CHK_PollWindow);
				        //submit the poll
				        selenium.click(EnvObjectMap_Rep.BTN_PollWindow);
				        //wait
					       Thread.sleep(10000);
					        assertTrue("Sm_vpv_028", "Verify that poll answer is submitted successfully from the viewer portal.", date, !(selenium.isVisible(EnvObjectMap_Rep.CHK_PollWindow)));
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
							String screenShot_locPath = VAR_frameWork_Path + "\\commonfiles\\" + VAR_LiveProgramName + ".jpg";		
							//Capture the screen shot of the live program
					        selenium.captureScreenshot(screenShot_locPath); 
						    //Wait
					        
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

							assertTrue("Sm_vpv_028", "Verify that user is able to push the results to the viewer portal", date, true);
							selenium.click(EnvObjectMap_Rep.Btn_crosspollresult);
						      //---------------------------------------------------------------------------
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
						    utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.img_audienceQuestionLBC, 300);
						    assertTrue("Sm_vpv_028","Verify that viewer question is displayed successfully on LBC.",date,selenium.isElementPresent(EnvObjectMap_Rep.img_audienceQuestionLBC));
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
						    utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_SurveyWindow, 600);
						    //select the answer on survey
						    selenium.click(EnvObjectMap_Rep.CHK_SurveyWindow);
						    //submit the answer on survey
						    assertTrue("Sm_vpv_028","Verify that survey is displayed successfully on viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.btn_SubmitSurveyanswer));
							selenium.click(EnvObjectMap_Rep.btn_SubmitSurveyanswer);
							utilityFunction.waitForChangesToReflect();
					utilityFunction=null;
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
