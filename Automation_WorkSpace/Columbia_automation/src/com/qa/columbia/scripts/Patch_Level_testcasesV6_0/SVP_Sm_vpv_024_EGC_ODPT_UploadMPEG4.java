/*
* Classname                                                        SVP_EGC_PrgThumbnail_Verification 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that thumbnails(6) are extracted for EGC content.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Create a EGC user<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the Simple Streaming Media radio button and upload a wmv file<br> 
* 																	>Provide the Display name and save<br> 
* 																	>Create a VOD program and mark it Master program and select the WMV file created abpve.<br> 
* 																	>Create a channel for the VOD program and select the EGC checkbox.<br> 	
* 																	>Select the EGC admin to provide the permissions.
*  																    >Launch the viewer portal and login as EGC user.<br> 
*   																>Create a program under My Programs.<br>												 
*   																>Edit the program and observe
* What Verification it performs:	 								1.Verify that thumbnails(6) are extracted for EGC content.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 12/04/2011
* Updated by/on date: 												QASource on 12/04/2011
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

public class SVP_Sm_vpv_024_EGC_ODPT_UploadMPEG4 extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String globalVariableFile ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(globalVariableFile ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(globalVariableFile ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
			utilityFunction=null;
		}
	}		
	public void test_SVP_Sm_vpv_024_EGC_ODPT_UploadMPEG4() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile ="SVP_Sm_vpv_024_EGC_ODPT_UploadMPEG4.xml";
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_Username = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_Password = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");	
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for filename name
		   String VAR_userFirstName = utilityFunction.GetValue(localVariableFile ,"VAR_userFirstName");
		   String VAR_userLastName = utilityFunction.GetValue(localVariableFile ,"VAR_userLastName");
			String VAR_userEmailID = utilityFunction.GetValue(localVariableFile, "VAR_userEmailID");
			String VAR_userPassword = utilityFunction.GetValue(localVariableFile, "VAR_userPassword");
			String VAR_ChannelName = utilityFunction.GetValue(localVariableFile, "VAR_ChannelName");
			String VAR_EGCprogramName = utilityFunction.GetValue(localVariableFile, "VAR_EGCprogramName");
			String VAR_streamingMediaEGC = utilityFunction.GetValue(localVariableFile, "VAR_streamingMediaEGC");
			 String VAR_HTTPDOPT=utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
	         String VAR_ProgramTemplateName = utilityFunction.GetValue(localVariableFile, "VAR_ProgramTemplateName");
			 String VAR_MediaFormat = utilityFunction.GetValue(localVariableFile, "VAR_MediaFormat");
			// Variable for asx filename
	        String VAR_asxfile = utilityFunction.GetValue(localVariableFile ,"VAR_ASXfileName");

				//Reusable action for Login to VCC     		
			 Login.adminPortalLogin(selenium, VAR_Username, VAR_Password, VAR_DomSocial);

			     	   
     	 //click the Domains link in right pane
			selenium.click(EnvObjectMap_Rep.Lnk_domains);
			selenium.waitForPageToLoad("50000");
			selenium.click(EnvObjectMap_Rep.LNK_selecteddomainName + VAR_DomSocial+ "')]");
			selenium.waitForPageToLoad("30000");
			//select the emploiyee generated content checkbox 
			if (!selenium.isChecked(EnvObjectMap_Rep.Chk_EnableEmployeeGeneratedContent))
			{
				selenium.click(EnvObjectMap_Rep.Chk_EnableEmployeeGeneratedContent);	
			}
			
			//verify the EGC Approval Required checkbox should not be checked
			if (selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox))
			{
			//System.out.println("checked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
			//if the checkbox is checked, following action will save the settings.
			selenium.click(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox);	
			selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
			selenium.waitForPageToLoad("50000");
			}
			else
			{
			// If checkbox is not checked,  then following action will select the checkbox and save the settings.
				//System.out.println("Unchecked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
				selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
				selenium.waitForPageToLoad("50000");
			}
										
     		//Reusable action for create User if EGC user is not already available
     	   CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
     		
     	   		    
     	    //Reusable action for creating the on-demand program 
     	  Create_ProgramTemplate.test_Create_VODTemplate(selenium, VAR_ProgramTemplateName, VAR_MediaFormat,VAR_HTTPDOPT);
     	  
		   selenium.waitForPageToLoad(VAR_MED_WAIT);	
		   //Reusable action for EGC enabled channel
	       Create_Channel.Create_EGCChannel(selenium, VAR_ChannelName, VAR_ProgramTemplateName+"*", VAR_userEmailID);
    
	       
	       //Navigate to Social Viewer portal
			Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
         
		   //Login to Social Viewer portal as EGC uer.
			Login.EGC_SVPLogin(selenium, VAR_userEmailID, VAR_userPassword);
		    utilityFunction.waitForChangesToReflect(); 
		    
          
           //Create a program containing MPEG4 file
           Upload_Media.Upload_EGCprogramSVP(selenium, VAR_EGCprogramName,VAR_streamingMediaEGC,VAR_ChannelName);
          
           for (int second = 0;; second++) {
  	           if (second >= 600) fail("timeout");
  	           try { if (selenium.isElementPresent("link=" +VAR_EGCprogramName))
  	         	  assertTrue("Sm_vpv_024","Social VP: Ensure that Program is successfully created using the MPEG4 file from SVP EGC portal.",date,selenium.isTextPresent(VAR_EGCprogramName));
  	             Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
        		     //selenium.waitForPageToLoad(VAR_MED_WAIT);
        		     break; } catch (Exception e) {}
        		
  	           Thread.sleep(1000);
  	       }
                    	//call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_DomSocial, VAR_EGCprogramName);
            
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
			System.out.println(htmlsource);	
			
			//To verify the asx file
		    assertTrue("Sm_vpv_024","SVP: Verify that user can create an EGC program with 'MPEG4' file as streaming media, if 'Media Format' is selected as MPEG4 in on-demand program template..",date,utilityFunction.assertTextContains(htmlsource, VAR_asxfile));
			utilityFunction=null;
           
           
            utilityFunction=null;
		}catch(Exception e){
			e.printStackTrace();}
			 finally{
			selenium.close();
			selenium.stop();
		}
		}
     	 }
									 
	
	}
