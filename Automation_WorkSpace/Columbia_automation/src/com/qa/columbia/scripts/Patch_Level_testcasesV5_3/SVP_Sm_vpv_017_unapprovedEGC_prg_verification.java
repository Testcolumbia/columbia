/*
* Classname                                                        SVP_Sm_vpv_017_unapprovedEGC_prg_verification
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.util.Calendar;
import java.util.Date;

//import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Sm_vpv_017_unapprovedEGC_prg_verification extends TesterAsserter {
	
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
	public void test_SVP_Sm_vpv_017_unapprovedEGC_prg_verification() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Local variable file
			String local_path ="SVP_EGC_Unapproved_Prg_Verification.xml";
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_Username = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_Password = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for User first name
		    String VAR_userFirstName = utilityFunction.GetValue(local_path ,"VAR_userFirstName");
		    //User lastname
		    String VAR_userLastName = utilityFunction.GetValue(local_path ,"VAR_userLastName");
		    //User email ID
			String VAR_userEmailID = utilityFunction.GetValue(local_path, "VAR_userEmailID");
			//User password
			String VAR_userPassword = utilityFunction.GetValue(local_path, "VAR_userPassword");
			//Streaming media display name
			String VAR_streamingMedia = utilityFunction.GetValue(local_path, "VAR_streamingMedia");
			//Streaming media file name
			String VAR_streamingMediaType = utilityFunction.GetValue(local_path, "VAR_streamingMediaType");
			//Master VOD program name
			String VAR_MasterVOD = utilityFunction.GetValue(local_path, "VAR_MasterVOD");
			//Channel name
			String VAR_ChannelName = utilityFunction.GetValue(local_path, "VAR_ChannelName");
			//EGC program name
			String VAR_EGCprogramName = utilityFunction.GetValue(local_path, "VAR_EGCprogramName");
			//Streaming media fiel to be uploaded from EGC
			String VAR_streamingMediaEGC = utilityFunction.GetValue(local_path, "VAR_streamingMediaEGC");
			//Application URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");			
			//Reusable action for Login to VCC     		
     	    Login.test_login(selenium, VAR_Username, VAR_Password, VAR_DomSocial);
     	    selenium.waitForPageToLoad("30000");			     	   
     	   //click the Domains link in right pane
			selenium.click(EnvObjectMap_Rep.LNK_Domains);
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
     		//Reusable action to upload streaming media (wmv)
     	     Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, VAR_streamingMediaType);	
		    //Reusable action for creating the on-demand program 
     	    Create_Program.test_Create_vodProgram(selenium, VAR_MasterVOD ,VAR_streamingMedia);
		 
		    if(!selenium.isTextPresent(VAR_MasterVOD))
		    		{
		    			//Search the new created Live program
		    			selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
		    			//provide program name in Search field
		    			selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_MasterVOD);
		    			//click Search button 
		    			selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
		    			//wait for loading the page
		    			selenium.waitForPageToLoad(VAR_MED_WAIT);
		    		}
		   selenium.click("link=" + VAR_MasterVOD);
		   selenium.waitForPageToLoad(VAR_MED_WAIT);
		   if(!selenium.isChecked(EnvObjectMap_Rep.chk_masterProgram))
		   {
		   selenium.click(EnvObjectMap_Rep.chk_masterProgram);
		   }
		   selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
		   selenium.waitForPageToLoad(VAR_MED_WAIT);	
		   	
		   //Reusable action for EGC enabled channel
           Create_EGCchannel.test_Create_EGCchannel(selenium, VAR_ChannelName, VAR_MasterVOD, VAR_userEmailID);
       	//variable for social viewer portal url
 		  String SVP_url = Var_Columbia_vpURL + VAR_DomSocial + "/home.vp"; 
 			// navigate to social viewer portal
         	selenium.open(SVP_url);
         	selenium.waitForPageToLoad(VAR_MED_WAIT);

         	//select the time zone
     		if (selenium.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
     		{
     			selenium.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
     			selenium.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
     			selenium.waitForPageToLoad(VAR_MED_WAIT);
     		}    
     		selenium.selectWindow("Qumu Program Browser Home");
 			selenium.windowMaximize();
     		utilityFunction.waitForChangesToReflect();
     		utilityFunction.waitForChangesToReflect();
     		 //Login to Social Viewer portal as EGC user 
         	Login.LoginSVP(selenium, VAR_userEmailID, VAR_userPassword);  
         	//wait
         	utilityFunction.waitForChangesToReflect(); 
             utilityFunction.waitForChangesToReflect();
          //Create a program containing WMV file
           Upload_EGCprogramSVP.test_Upload_EGCprogramSVP(selenium, VAR_EGCprogramName,VAR_ChannelName, VAR_streamingMediaEGC);
           utilityFunction.waitForChangesToReflect();
            utilityFunction.waitForChangesToReflect();
        	boolean flag_program_created = false;
      
           utilityFunction.waitForChangesToReflect();
       	   	if(selenium.isTextPresent(VAR_EGCprogramName)){
        		flag_program_created= true;
        		System.out.println(flag_program_created);
        		        	 }
       	    utilityFunction.waitForChangesToReflect();
        	selenium.click(EnvObjectMap_Rep.LNK_HomeSVP);
        	selenium.waitForPageToLoad(VAR_MED_WAIT);
                 	   	
            utilityFunction.waitForChangesToReflect();	
    		//click on All videos link
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
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
          	      Login.test_login(selenium, VAR_Username, VAR_Password, VAR_DomSocial);
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
		           assertTrue("Sm_vpv_017","Social VP: Ensure that unapproved EGC programs are not accessible to viewers.",date,selenium.isTextPresent(VAR_EGCprogramName)); 
		           utilityFunction=null;
     	   }
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
