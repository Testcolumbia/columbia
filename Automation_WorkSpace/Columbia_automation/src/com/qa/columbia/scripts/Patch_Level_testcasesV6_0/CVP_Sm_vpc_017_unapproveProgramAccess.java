/*
* Class name                                                        MVV_VOD_report 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
* 																	>Click on the programming link<br> 															
* 																	>Create VOD program<br>						
* 										                            >After creating the program search the program in programs page<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class CVP_Sm_vpc_017_unapproveProgramAccess extends TesterAsserter {
	
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
		}
		utilityFunction=null;
	}	
	public  void test_CVP_unapproveProgramAccess() throws Exception
	{
		
try{
			
		    //Call to setUp function
		    setUp();
			
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="CVP_Sm_vpc_017_unapproveProgramAccess.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			
			//Variable for Waiting time
			String VAR_MED_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			
			// Variable for program name
			String VAR_StreamingMedia=utilityFunction.GetValue(localVariableFile ,"streamingMedia_DisplayName");

			String streamingMedia_FileName = utilityFunction.GetValue(localVariableFile, "VAR_fileType");
			
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
		    selenium.click(EnvObjectMap_Rep.Lnk_domains);
  		//wait for loading the page
   		     selenium.waitForPageToLoad(VAR_MED_WAIT);
    		//Click on the required domain
    		String VAR_domainLink = EnvObjectMap_Rep.lnk_editDomain + VAR_domain + "')]";
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
			//Call to Create VOD program function
    		Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, streamingMedia_FileName);
			Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);
			
			//search by program name
			selenium.type(EnvObjectMap_Rep.lnk_VODProgramsearch, VAR_program);
			
			selenium.click(EnvObjectMap_Rep.Btn_programsearch);
			
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			Launch_VP.Launch_CVP(selenium, VAR_domain);
			selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, VAR_program);
			selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);				 
			utilityFunction.waitForChangesToReflect();	
			
			//Ensure that program is successfully created and visible in programs page
			assertTrue("CVP_unapproveProgramAccess","Classic VP: Ensure that unapproved programs are not accessible to viewers.",date,!selenium.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + VAR_program));
	Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			selenium.click(EnvObjectMap_Rep.Lnk_domains);
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
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
	selenium.close();
	selenium.stop();
}

	}

}
