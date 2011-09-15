/*
* Classname                                                        TranscodedfileIngestVerification 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												To verify transcoding .wmv file to .flv and its ingest completion.<br>
* What the script does:											    >Pre-requisites:Ensure that Agility server is up and has transcoding profiles.
* 																	>Steps:                                 						
* 																	>Login to the application<br>  
* 																	>Navigate to Resource menu and Create a  transcoding node with a transcoding profile on the VCC for pre-requisites Agility server, if its not available.<br>  
* 																	>Upload a streaming media file e.g..wmv file<br>													
*																	>Edit this content file to select the transcoding node and its corresponding profile.<br>  
* 																	>Click Start Transcoding button.<br>  
* 																	>Ensure that the transcoded file is shown up in Content for the selected wmv file.<br>  
* 																	>Click the ingest icon for this transcoded file and verify the status as "INGESTCOMPLETE".<br>  
* 																	>Play the Ingested file and verify if it plays in the viewerportal<br>  
*  																	>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that file is transcoded sucessfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 04/05/2011
* Updated by/on date: 												QASource on 04/05/2011
* 
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
* Silver light should be Enabled in the browser's Add-ons.
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

public class TranscodeWMVfiletoFLV extends TesterAsserter {
	
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
	public void test_TranscodeWMVfiletoFLV() throws Exception 
		{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			String local_path ="TranscodeWMVfiletoflv.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");		
			//Variable for wmv file name
			String VAR_WMVfile = utilityFunction.GetValue(local_path ,"VAR_WMV_file");
			//Variable for the wmv fle name
			String VAR_WMV_fileName = utilityFunction.GetValue(local_path ,"VAR_WMVfileName");
			//Variable for framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Variable for VOD program name
			String str_ProgName= utilityFunction.GetValue(local_path, "VAR_Program_Name");
			//Variable for asx file 
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Variable for site URL
			String VAR_AP_Host=  utilityFunction.GetValue(str_path, "VAR_AP_Host");
			//Variable for agility server
			String VAR_AgilityServer_Host=  utilityFunction.GetValue(str_path, "VAR_AgilityServer_Host");
			//Variable for Transcoding node on agility server
			String VAR_TranscodingNode=  utilityFunction.GetValue(str_path, "VAR_TranscodingNode");
			//Variable for Transcoding profile on agility server
			String VAR_TranscodingFLVProfile=  utilityFunction.GetValue(str_path, "VAR_TranscodingFLVProfile");
			
			
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     		//wait
    		 selenium.waitForPageToLoad("30000");
    		 //click Resources in the left pane
    		selenium.click(EnvObjectMap_Rep.LNK_Resources);
    		
    		//click Transcoding Nodes
    		 selenium.click(EnvObjectMap_Rep.lnk_TranscodingNodes);
    		 //wait
    		 selenium.waitForPageToLoad("30000");
    		//verify if transcoding node exists otherwise create a new one
    		 
     		 if(!selenium.isTextPresent(VAR_TranscodingNode)){
     			//Create a new node  
     			 //Click Add button
 				selenium.click(EnvObjectMap_Rep.BT_AddNode);
 				
 				selenium.addSelection(EnvObjectMap_Rep.opt_selectNodeType, EnvObjectMap_Rep.val_nodevalue);
 				
 				selenium.click(EnvObjectMap_Rep.btn_transcodenode);
 				selenium.waitForPageToLoad("30000");
 				selenium.type(EnvObjectMap_Rep.txt_transcodenodename, VAR_TranscodingNode);
 				selenium.type(EnvObjectMap_Rep.txt_transcodenodehost, VAR_AgilityServer_Host);
 				selenium.type(EnvObjectMap_Rep.txt_transcodeinputfolder, "input");
 				selenium.type(EnvObjectMap_Rep.txt_transcodeoutputfolder, "output");
 				
 		    	selenium.click(EnvObjectMap_Rep.btn_transcodeloadprofilebtn);
 		    	for (int second = 0;; second++) {
 					if (second >= 80000) fail("timeout");
 					try { if (selenium.isElementPresent(EnvObjectMap_Rep.tbl_transcodeprofiletable)) break; } catch (Exception e) {}
 					Thread.sleep(1000);
 				}
 				for (int second = 0;; second++) {
 					if (second >= 1200000) fail("timeout");
 					try { if (selenium.isElementPresent(EnvObjectMap_Rep.tbl_transcodedprofilelisttable)) break; } catch (Exception e) {}
 					Thread.sleep(1000);
 		              for (int j = 2; j<100; j++){
 		           // 	String str_val=selenium.getText(MessageFormat.format("//table[@id='profileTable']/tbody/tr[{0}]/td[2]/a", j));
 		            	String str_val=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_transcodingprofiletext, j));     		            	
 		            	System.out.println(str_val);	   
 		    	    	if (str_val.equals(VAR_TranscodingFLVProfile)){
 		    	    	selenium.click(MessageFormat.format(EnvObjectMap_Rep.chk_transProfilechkbox, j));
 		               break;
 		    	    	}
 		        }
 		          //CLick save button
 		              selenium.click(EnvObjectMap_Rep.btn_Submitnodecreation);
 		              //wait
 		    		 selenium.waitForPageToLoad("30000");
 				}
     		 }else { System.out.println("Node already exists");}
 	 			  
         	//Reusable action for WMV file upload
     		 Upload_Media.Upload_streamingMedia(selenium, VAR_WMV_fileName, VAR_WMVfile);
     		 
     		 //wait
     		 utilityFunction.waitForChangesToReflect();			  					
     		 utilityFunction.waitForChangesToReflect();
     		 //Click on streaming media (wmv) link
     		 selenium.click("link="+VAR_WMV_fileName);
     		 for(int seconds = 0;; seconds++){
     			 if (seconds >= 80000) fail("timeout");
     			 try { 
     				 if (selenium.isVisible(EnvObjectMap_Rep.btn_transcodeEvent)){
     					 selenium.click(EnvObjectMap_Rep.btn_transcodeEvent);
     					 break;
     				  }	}catch (Exception e) {}
     		 }
     				 for(int sec = 0;; sec++) {
     					 if (sec >= 80000) fail("timeout");
     					 try { 
     						 if (selenium.isElementPresent(EnvObjectMap_Rep.lst_transcodetextfield)) {
     							 selenium.select(EnvObjectMap_Rep.lst_transcodetextfield, "label="+VAR_TranscodingNode);
     							 selenium.clickAt(EnvObjectMap_Rep.lst_transcodetextfield, "label="+VAR_TranscodingNode);
     							 utilityFunction.waitForChangesToReflect();
     							 utilityFunction.waitForChangesToReflect();
     							 selenium.select(EnvObjectMap_Rep.lst_transcodeprofilefield, "label=" +VAR_TranscodingFLVProfile);
     							 selenium.clickAt(EnvObjectMap_Rep.lst_transcodeprofilefield, "label=" +VAR_TranscodingFLVProfile);
     							 utilityFunction.waitForChangesToReflect();
     							 utilityFunction.waitForChangesToReflect();
     							 selenium.click(EnvObjectMap_Rep.btn_starttranscoding);
     							 utilityFunction.waitForChangesToReflect();
     							 utilityFunction.waitForChangesToReflect();
     							 assertTrue("TranscodeWMVfiletoFLV","Verify that file has transcoded successfully",date,selenium.isTextPresent(VAR_WMV_fileName));
     							 selenium.click(EnvObjectMap_Rep.icn_Closewindow); }break;} catch (Exception e) {}
     				 }
     				//wait so that transcoded file is shown up in the content
     				 utilityFunction.waitForChangesToReflect();
     				 utilityFunction.waitForChangesToReflect();
     				 utilityFunction.waitForChangesToReflect();
     				 utilityFunction.waitForChangesToReflect();
     				 utilityFunction.waitForChangesToReflect();
     		         utilityFunction.waitForChangesToReflect();
     		 //Open the programming menu
     		 selenium.click(EnvObjectMap_Rep.LNK_Programming);
     		 ///Select the Content link
     		selenium.click(EnvObjectMap_Rep.LNK_Content);
     		 //Wait for loading the page
     		 selenium.waitForPageToLoad("30000");	 
     		 utilityFunction.waitForChangesToReflect();
     		 utilityFunction.waitForChangesToReflect();			  					
     		 selenium.click(EnvObjectMap_Rep.BTN_More_Search);
     		 //Provide the Slide name to search
     		 selenium.type(EnvObjectMap_Rep.TXT_Search_Name,"transcoded");
     		 selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
     		 //Click Search button
     		 selenium.click(EnvObjectMap_Rep.Btn_Search);
     		 //Wait for loading the page
     		 utilityFunction.waitForChangesToReflect();		
     		 //Check Point to test that RSS Encoder is created
     		for (int secs = 0;; secs++) {
				 if (secs >= 80000) fail("timeout");
				 try { 
					 if (selenium.isTextPresent(VAR_WMV_fileName +","+" "+"transcoded"))
					 {
						 assertTrue("TranscodeWMVfiletoFLV","Ensure that Transcoded file is displayed on Content page.",date,selenium.isTextPresent(VAR_WMV_fileName +","+" "+"transcoded"));	
				     		
					 }
					 break; } catch (Exception e) {}
					 Thread.sleep(1000);
					 
			 }
     		 
			//select the transcoded file
     		 String str_var=selenium.getText(EnvObjectMap_Rep.lnk_transcodedfirstfilename);
     		 System.out.println(str_var);
     		 if (str_var.contains(VAR_WMV_fileName +","+" "+"transcoded")){
     			 selenium.click(EnvObjectMap_Rep.icn_transcodedfirstfileingesticon);
     		 }
     		 else{
     			 for (int i = 3; i<100; i++){
     				 String str_var2=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.lnk_transcodedfilename, i));
     				 System.out.println(str_var2);   
     				 if (str_var2.contains(VAR_WMV_fileName +","+" "+"transcoded")){
     					selenium.click(MessageFormat.format(EnvObjectMap_Rep.icn_transcodedfileicn, i));
     					 break;
     				 }
     			 }  
				}    
     			 selenium.waitForPageToLoad(VAR_MED_WAIT);
     			 for (int secs = 0;; secs++) {
     				 if (secs >= 80000) fail("timeout");
     				 try { 
     					 if (selenium.isTextPresent("INGESTCOMPLETE"))
     					 {
     						 assertTrue("TranscodeWMVfiletoFLV","Ensure that ingest is completed for the transcoded file.",date,selenium.isTextPresent("INGESTCOMPLETE"));
     					 }
     					 break; } catch (Exception e) {}
     					 Thread.sleep(1000);
     					 
     			 }
						
     			 //Variable for VOD program name
     			 String VAR_TranscodedWMV_fileName= VAR_WMV_fileName+", "+"transcoded";
     			 //Reusable action for Create VOD with transcoded WMV file
     			 Create_Program.test_Create_vodProgram(selenium, str_ProgName, VAR_TranscodedWMV_fileName);
     			 //Wait
     			 utilityFunction.waitForChangesToReflect();
     			 //Variable for complete viewerportal URL
     			 String str_viewerportal_URL = Var_Columbia_vpURL + VAR_DomSocial + "/home.vp?debug=true";
     			 //Open the viewerportal URL
     			 selenium.open(str_viewerportal_URL);
     			 selenium.waitForPageToLoad(VAR_MED_WAIT);
     			 //Select the time zone if prompted for
     			 if (selenium.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
     			 {
     				 selenium.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
     				 selenium.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
     				 selenium.waitForPageToLoad(VAR_MED_WAIT);
     			 } 
     			 selenium.selectWindow("Qumu Program Browser Home");
     			 selenium.windowMaximize();
     			 utilityFunction.waitForChangesToReflect();	
     			 for (int s = 0;; s++) {
     				 if (s >= 80000) fail("timeout");
     				 try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_AllVideos)) break; } catch (Exception e) {}
     				 Thread.sleep(1000);
     			 }
     			 //click on All videos link
     			 selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
     			 utilityFunction.waitForChangesToReflect();	
     			 selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, utilityFunction.GetValue(local_path, "VAR_Program_Name"));
     			 utilityFunction.waitForChangesToReflect();
     			 //Set focus on the search textbox
     			 selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
     			 //select the icon to perform search
     			 selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
     			 //Wait	
     			 utilityFunction.waitForChangesToReflect();	
     			 //Click the vod file in search results
     			 for (int i = 1; i<50; i++){
     				 String str_var1=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
     				 System.out.println(str_var1);	   
     				 if(str_var1.equals(str_ProgName)){
     					 selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
     					 break;
     				 }                  
     			 }
     			 
     			 //Wait
      			 utilityFunction.waitForChangesToReflect();
     			 utilityFunction.waitForChangesToReflect();
     			 //Capture the screenshot at the specified path
     			 String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + str_ProgName + ".jpg";		
     			 //Capture the screen shot of the live program
     			 selenium.captureScreenshot(screenShot_locPath);  
      			 //Wait
     			 utilityFunction.waitForChangesToReflect();
	        
     			 String contentlink = selenium.getText(Var_asxLink);
     			 utilityFunction.waitForChangesToReflect();       
     			 String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
     			 contentlink_final=contentlink_final.trim();		
     			 System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
     			 selenium.click("link=exact:"+contentlink_final);
     			 utilityFunction.waitForChangesToReflect();
     			 
     			 //Generate the asx file
     			 String htmlsource = selenium.getHtmlSource();
     			 System.out.println(htmlsource);	
     			 
     			 //To verify the asx file
     			 assertTrue("TranscodeWMVfiletoFLV","Verify that asx file is generated successfully for a WMV file transcoded into a flv file.",date,utilityFunction.assertTextContains(htmlsource, VAR_WMV_fileName+","+" "+"transcoded"));
     			 assertTrue("TranscodeWMVfiletoFLV","Verify that wmv file is displayed in the asx file for a WMV file transcoded into a flv file.",date,utilityFunction.assertTextContains(htmlsource, "Transcode.flv"));
     		      selenium.stop();
			
  			}
		}
	
		
			
		
		
		
	
