/*
* Classname                                                        CVP_unapproveProgramAccess
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that unapproved programs are not accessible to viewers.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Check the "Require program Approval" checkbox on the Edit Domain page<br> 
*																	>Upload a wmv file<br> 
*  															     	>Create an on-demand program using the above mentioned wmv file<br> 
*																	>Verify that the program status is displayed as un-approved<br> 
* 																	>Launch the viewer  portal for teh domain<br> 
* 																	>Search the newly cretaed program<br> 
* 																	>click on the wmv file name<br> 	
*  																    >Verify that the newly created program is not accessible<br> 	 	 
*   																			 
* What Verification it performs:	 								1.Verify that un-approved programs are not listed on the classic viewer portal.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
* 
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_unapproveProgramAccess extends TesterAsserter {
	
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
	public void test_CVP_unapproveProgramAccess() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			//Script specific variables file name
			String local_path = "CVP_unapproveProgramAccess.xml";
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//Variable for filename name
		    String VAR_streamingMedia = utilityFunction.GetValue(local_path ,"VAR_WMV_fileName");
		    //Variable for File Type
			String VAR_streamingMediaType = utilityFunction.GetValue(local_path ,"VAR_fileType");
			//Variable for Program Name
			String VAR_programName = utilityFunction.GetValue(local_path, "VAR_programName");
			//Viewer Portal link
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path, "Var_Columbia_vpURL");
			//wait
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Viewer Portal URL
			String CVP_url = Var_Columbia_vpURL + VAR_DomClassic + "/home.do";
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Navigate to Domains
    		selenium.click(EnvObjectMap_Rep.LNK_Domains);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Click on the required domain
    		String VAR_domainLink = EnvObjectMap_Rep.lnk_editDomain + VAR_DomClassic + "')]";
    		selenium.click(VAR_domainLink);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Check the Approval required checkbox
    		if (!selenium.isChecked(EnvObjectMap_Rep.chk_approveProram))
    		{
    			//check the "Require Program Approval checkbox
    			selenium.click(EnvObjectMap_Rep.chk_approveProram);
    		}
     		//Save the domain settings
    		selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Reusable action for streaming media (wmv) upload
    		
    		//Click on Programming link
			selenium.click(EnvObjectMap_Rep.LNK_Programming);
			//Select the Content link
			selenium.click(EnvObjectMap_Rep.LNK_Content);
			//Wait for loading the page
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			utilityFunction.waitForChangesToReflect();
			//Click on advanced search button
			selenium.click(EnvObjectMap_Rep.BTN_More_Search);
			//Provide the Slide name to search
			selenium.type(EnvObjectMap_Rep.TXT_Search_Name, VAR_streamingMedia);
			selenium.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
			//Click Search button
			selenium.click(EnvObjectMap_Rep.Btn_Search);
			//Wait for loading the page
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			if(!selenium.isTextPresent(VAR_streamingMedia))
			{
    		
    		Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, VAR_streamingMediaType);
    		
			}
		    //Click on streaming media (wmv) link	  
    		Create_Program.test_Create_vodProgram(selenium, VAR_programName,VAR_streamingMedia);
		    //wait
			//utilityFunction.waitForChangesToReflect();	
			//Click on Program Approve menu link
			selenium.click(EnvObjectMap_Rep.lnk_approveProgram);
			//wait for page to load
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Select the show drop down as "Pending"
			selenium.select(EnvObjectMap_Rep.drp_approvalStatus, EnvObjectMap_Rep.drp_approvalStatusValue + "Pending");
			//Verify that program status is Unapproved
			assertTrue("","Ensure that newely created program is in unapproved status.",date,selenium.isTextPresent(VAR_programName));
			//Launch the viewer portal
			selenium.open(CVP_url);
			selenium.waitForPageToLoad("90000");
			//Check if Select Time Zone is displayed
			if (selenium.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
			{
				//Select the time zone
				selenium.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
				//wait
				selenium.waitForPageToLoad(VAR_MED_WAIT);
				//Save the selected time zone
				selenium.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
				//wait for page to load
				selenium.waitForPageToLoad(VAR_MED_WAIT);			
			}
			//Type the Program name in the search text box 
			selenium.type(EnvObjectMap_Rep.txt_SearchCVP, VAR_programName);
			//Click on Search button
			selenium.click(EnvObjectMap_Rep.btn_SearchCVP);
			//wait
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Verify that un-approved programs are not listed
			assertTrue("CVP_unapproveProgramAccess","Classic VP: Ensure that unapproved programs are not accessible to viewers.",date,!selenium.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + VAR_programName));
			Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
			//Navigate to Domains
    		selenium.click(EnvObjectMap_Rep.LNK_Domains);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Click on the required domain
    		selenium.click(VAR_domainLink);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Check the Approval required checkbox
    		if (selenium.isChecked(EnvObjectMap_Rep.chk_approveProram))
    		{
    			//check the "Require Program Approval checkbox
    			selenium.click(EnvObjectMap_Rep.chk_approveProram);
    		}
     		//Save the domain settings
    		selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
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