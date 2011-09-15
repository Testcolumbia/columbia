/*
* Classname                                                        SVP_EGCupload_FLV 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that FLV file is uploaded from EGC portal..<br>
>Login to the application<br> 
* 																	>Create a EGC user<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the Simple Streaming Media radio button and upload a flv file<br> 
* 																	>Provide the Display name and save<br> 
* 																	>Create a VOD program and mark it Master program and select the WMV file created abpve.<br> 
* 																	>Create a channel for the VOD program and select the EGC checkbox.<br> 	
* 																	>Select the EGC admin to provide the permissions.
*  																    >Launch the viewer portal and login as EGC user.<br> 
*   																>Create a program under My Programs.<br>												 
* What Verification it performs:	 								1.Verify that EGC user is able to create program which contains a FLV file under My Program.<br> 
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 13/04/2011
* Updated by/on date: 												QASource on 13/04/2011
******************************************************************** <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

//import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_006_EGCupload_FLV extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_006_EGCupload_FLV() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile = "SVP_Sm_vpv_006_EGCupload_FLV.xml";
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(globalVariableFile,"Var_DomainSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");	
			String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			//Variable for EGC user's email id
		  	String VAR_userEmailID = utilityFunction.GetValue(localVariableFile, "VAR_userEmailID");
			//Variable for EGC user's password
			String VAR_userPassword = utilityFunction.GetValue(localVariableFile, "VAR_userPassword");
			//Variable for EGC user's First Name
			String VAR_userFirstName = utilityFunction.GetValue(localVariableFile ,"VAR_userFirstName");
			//Variable for EGC user's Last Name
			String VAR_userLastName = utilityFunction.GetValue(localVariableFile ,"VAR_userLastName");
			//Variable for Streaming Media Name
			String VAR_streamingMedia = utilityFunction.GetValue(localVariableFile, "VAR_streamingMedia");
			//Variable for Streaming Media type
			String VAR_streamingMediaType = utilityFunction.GetValue(localVariableFile, "VAR_streamingMediaType");
		    //Variable for Master VOD Name
			String VAR_MasterVOD = utilityFunction.GetValue(localVariableFile, "VAR_MasterVOD");
			//Variable for channel Name
			String VAR_ChannelName = utilityFunction.GetValue(localVariableFile, "VAR_ChannelName");
			//Variable for Program Name Created from SVP by EGC user
			String VAR_EGCprogramName = utilityFunction.GetValue(localVariableFile, "VAR_EGCprogramName");
			//Variable for Streaming Media uploaded by EGC user from SVP
			String VAR_streamingMediaEGC = utilityFunction.GetValue(localVariableFile, "VAR_streamingMediaEGC");
			// Variable for asx filename
			String VAR_asxfile = utilityFunction.GetValue(localVariableFile ,"VAR_ASXfileName");
					
		  //Reusable action for Login to VCC     		
		   Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);
     	    			     	   
   	      //click the Domains link in right pane
			selenium.click(EnvObjectMap_Rep.Lnk_domains);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			
			selenium.click(EnvObjectMap_Rep.LNK_selecteddomainName + VAR_DomSocial+ "')]");
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//verify the EGC Approval Required checkbox should not be checked
			if (selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox))
			{
			//System.out.println("checked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
			// if the checkbox is checked, following action will uncheck and save
			selenium.click(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox);	
			selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
			}
			else
			{
			// checkbox is not checked
			//	System.out.println("Unchecked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
				selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
				
			}
			selenium.waitForPageToLoad(VAR_MED_WAIT); 
						
     		//Reusable action for create User
     	    CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
     		//Reusable action to upload streaming media (wmv)
     	   Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, VAR_streamingMediaType);	
		  //Reusable action for creating the on-demand program 
          Create_Program.create_VODProgram(selenium, VAR_MasterVOD,"" ,VAR_streamingMedia);
		 
		    if(!selenium.isTextPresent(VAR_MasterVOD))
		    		{
		    			//Search the new created Live program
		    			selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
		    			//provide program name in Search field
		    			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_MasterVOD);
		    			//click Search button 
		    			selenium.click(EnvObjectMap_Rep.Btn_searchProgram);
		    			//wait for loading the page
		    			selenium.waitForPageToLoad(VAR_MED_WAIT);
		    		}
			   utilityFunction.waitForElementToPresent(selenium,"link=" + VAR_MasterVOD, 300);
		   selenium.click("link=" + VAR_MasterVOD);
		   selenium.waitForPageToLoad(VAR_MED_WAIT);
		   utilityFunction.waitForElementToPresent(selenium,EnvObjectMap_Rep.CHK_masterprogram, 300);
		   selenium.click(EnvObjectMap_Rep.CHK_masterprogram);
		   selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
		   selenium.waitForPageToLoad(VAR_MED_WAIT);	
     
		   //Reusable action for EGC enabled channel
          Create_Channel.Create_EGCChannel(selenium, VAR_ChannelName, VAR_MasterVOD, VAR_userEmailID);
		
			 //Navigate to Social Viewer portal
			Launch_VP.Launch_SVP(selenium, VAR_DomSocial);
          
			 //Login to Social Viewer portal as EGC uer.
			Login.EGC_SVPLogin(selenium, VAR_userEmailID, VAR_userPassword);
		utilityFunction.waitForChangesToReflect(); 
        	         
            //Create a program containing WMV file
            Upload_Media.Upload_EGCprogramSVP(selenium, VAR_EGCprogramName,VAR_streamingMediaEGC,VAR_ChannelName);
            //utilityFunction.waitForElementToVisible(selenium, "link="+VAR_EGCprogramName, 500);
                   	
            for (int second = 0;; second++) {
  	           if (second >= 600) fail("timeout");
  	           try { if (selenium.isElementPresent("link=" +VAR_EGCprogramName))
  	         	  assertTrue("Sm_vpv_006","Social VP: Ensure that Program is successfully created using the FLV file from SVP EGC portal.",date,selenium.isTextPresent(VAR_EGCprogramName));
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
		    assertTrue("Sm_vpv_006","Social VP: Ensure that FLV file is uploaded from EGC portal.",date,utilityFunction.assertTextContains(htmlsource, VAR_asxfile));
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
	
  