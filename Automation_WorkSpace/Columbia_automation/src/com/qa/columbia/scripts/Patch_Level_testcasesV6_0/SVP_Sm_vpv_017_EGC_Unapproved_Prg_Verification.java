/*
* Classname                                                        SVP_EGC_Unapproved_Prg_Verification
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that unapproved EGC programs are not accessible to viewers.<br>
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
*   																>Observe that the unapproved program is not listed under the All Videos
*   																>Observe that the program has Pending status in admin portal.
* What Verification it performs:	 								1.Social VP: Ensure that unapproved EGC programs are not accessible to viewers.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 11/04/2011
* Updated by/on date: 												QASource on 11/04/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

//import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_017_EGC_Unapproved_Prg_Verification  extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_017_EGC_Unapproved_Prg_Verification() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			String localVariableFile ="SVP_Sm_vpv_017_EGC_Unapproved_Prg_Verification.xml";
			
			String local_path="Setup_Script.xml";
			
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
			String VAR_streamingMedia=utilityFunction.GetValue(local_path,"VAR_streamingMediaRSSDisc");
			String VAR_MasterVOD = utilityFunction.GetValue(localVariableFile, "VAR_MasterVOD");
			String VAR_ChannelName = utilityFunction.GetValue(localVariableFile, "VAR_ChannelName");
			String VAR_EGCprogramName = utilityFunction.GetValue(localVariableFile, "VAR_EGCprogramName");
			String VAR_streamingMediaEGC = utilityFunction.GetValue(localVariableFile, "VAR_streamingMediaEGC");
			String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");
			
			//Reusable action for Login to VCC     		
			 Login.adminPortalLogin(selenium, VAR_Username, VAR_Password, VAR_DomSocial);
				     	   
     	   //click the Domains link in right pane
			selenium.click(EnvObjectMap_Rep.Lnk_domains);
			selenium.waitForPageToLoad("50000");
			selenium.click(EnvObjectMap_Rep.LNK_selecteddomainName + VAR_DomSocial+ "')]");
			selenium.waitForPageToLoad("30000");
			
			//verify the EGC Approval Required checkbox should not be checked
			if (selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox))
			{
			System.out.println("checked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
			//if the checkbox is checked, following action will save the settings.
			
			selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
			}
			else
			{
			// If checkbox is not checked,  then following action will select the checkbox and save the settings.
				System.out.println("Unchecked" + selenium.isChecked(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox));
				selenium.click(EnvObjectMap_Rep.CHK_EGCApprovalRequiredchkbox);	
				selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
			}
				selenium.waitForPageToLoad("30000"); 
						
     		//Reusable action for create User if EGC user is not already available
     	    CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
     		//Reusable action for creating the on-demand program 
     	 Create_Program.create_VODProgram(selenium, VAR_MasterVOD,"",VAR_streamingMedia);
		 
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
            
            utilityFunction.waitForChangesToReflect();
            utilityFunction.waitForChangesToReflect();
        	boolean flag_program_created = false;
      
            utilityFunction.waitForChangesToReflect();
       	   	if(selenium.isTextPresent(VAR_EGCprogramName)){
        		flag_program_created= true;
        		System.out.println(flag_program_created);
        		selenium.click(EnvObjectMap_Rep.LNK_EditVODProgram);
                selenium.waitForPageToLoad("40000");	        	
       	   	}
        	for (int i = 1; i<=6; i++){
 			selenium.isElementPresent("selectedThumbnail" +i);
 			if(i==6)
 			{
 			assertTrue("SVP_Sm_vpv_020","Social VP: Ensure that thumbnails(6) are extracted for EGC content.",date,selenium.isElementPresent("selectedThumbnail" +i));
 		 	}
 			else{
 		     System.out.println("The Iterator has value less than 6, please try again" +i);
 			}
 			}
 		    //Capture the screenshot at the specified path
		    String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_EGCprogramName + ".jpg";		
		    //Capture the screen shot of the live program
            selenium.captureScreenshot(screenShot_locPath);  
       	   	//----------------------------code--------------------------
       	   	
       	   	
       	   	
       	    utilityFunction.waitForChangesToReflect();
        	selenium.click(EnvObjectMap_Rep.LNK_home);
        	selenium.waitForPageToLoad(VAR_MED_WAIT);
                 	   	
            utilityFunction.waitForChangesToReflect();	
    		//click on All videos link
			selenium.click(EnvObjectMap_Rep.LNK_showall);
			utilityFunction.waitForChangesToReflect();	
			//input the search term
			selenium.type(EnvObjectMap_Rep.TBX_SearchSVP,VAR_EGCprogramName);
			utilityFunction.waitForChangesToReflect();
			//Set focus on the search textbox
        	selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
        	//select the icon to perform search
        	selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
			//Wait
			utilityFunction.waitForChangesToReflect();	
			boolean flag_program_inlist = false;
			if(!selenium.isTextPresent(VAR_EGCprogramName)){
				flag_program_inlist=true;
				System.out.println(flag_program_inlist);
			}
     	   if (flag_program_inlist & flag_program_created){
     			 //Reusable action for Login to VCC     		
          	      Login.adminPortalLogin(selenium, VAR_Username, VAR_Password, VAR_DomSocial);
          	      utilityFunction.waitForChangesToReflect();
          	      //click on "Programming" link
          	 	  selenium.click("menu_programming_cont");
     		      utilityFunction.waitForChangesToReflect();
				  //Click on Program Approve menu link
		          selenium.click(EnvObjectMap_Rep.lnk_approveProgram);
		          //wait for page to load
		          utilityFunction.waitForChangesToReflect();	
		          //Select the show drop down as "Pending"
		   	       selenium.select(EnvObjectMap_Rep.drp_approvalStatus, EnvObjectMap_Rep.drp_approvalStatusValue + "Pending");
		           //Verify that program status is Unapproved
		           assertTrue("SVP_EGC_Unapproved_Prg_Verification","Social VP: Ensure that unapproved EGC programs are not accessible to viewers.",date,selenium.isTextPresent(VAR_EGCprogramName)); 
		           utilityFunction=null;
     	   }}catch(Exception e){
				e.printStackTrace();}
				 finally{
				selenium.close();
				selenium.stop();
			}
     	 }
	   }
	}
