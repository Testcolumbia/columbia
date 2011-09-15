/*
* Classname                                                        CVP_Sm_vpc_007_uploadEGC 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that wmv file is uploaded from viewer portal.<br>
* What the script does:											    >Login to the application<br> 
* *   																>Navigate to Users page<br> 		
* *   																>Create a new user.<br> 		
*																	>Navigate to Content<br> 
* 																	>Add a wmv file.<br> 
* 																	>Create a master on-demand program<br> 	
*  																	>Creaet an EGC channel using the above mentioned wmv file and above created user as EGC author.<br> 
*   																>Login to viewer portal using teh above created user credentials.<br> 	
*   *   															>Upload a wmv file from My Programs tab<br> 																				 
* What Verification it performs:	 								1.Verify that wmv file is uploaded from viewer portal.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_007_uploadEGC extends TesterAsserter {
	
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
	public void test_CVP_Sm_vpc_007_uploadEGC() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//Global variables file name
			String str_path ="Global_variables.xml";
			String local_path = "CVP_uploadEGC.xml";
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//User first name
		    String VAR_userFirstName = utilityFunction.GetValue(local_path ,"VAR_userFirstName");
		    //User last name
		    String VAR_userLastName = utilityFunction.GetValue(local_path ,"VAR_userLastName");
		    //User email ID
			String VAR_userEmailID = utilityFunction.GetValue(local_path, "VAR_userEmailID");
			//User password
			String VAR_userPassword = utilityFunction.GetValue(local_path, "VAR_userPassword");
			//Streaming media display name
			String VAR_streamingMedia = utilityFunction.GetValue(local_path, "VAR_streamingMedia");
			//Streaming media file name
			String streamingMediaType = utilityFunction.GetValue(local_path, "streamingMediaType");
			//Master VOD name
			String VAR_MasterVOD = utilityFunction.GetValue(local_path, "VAR_MasterVOD");
			//Channel name
			String VAR_ChannelName = utilityFunction.GetValue(local_path, "VAR_ChannelName");
			//EGC program name
			String VAR_EGCPogramName = utilityFunction.GetValue(local_path, "VAR_EGCPogramName");
			//Streaming media file to be uploaded from EGC
			String VAR_streamingMediaEGC = utilityFunction.GetValue(local_path, "VAR_streamingMediaEGC");
			//Application URL
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Reusable action for Login to VCC     		
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Reusable action for create User
     		CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
     		//Reusable action to upload streaming media (wmv)
     		Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, streamingMediaType);	
		    //Reusable action for creating the on-demand program 
     		Create_Program.test_Create_vodProgram(selenium, VAR_MasterVOD ,VAR_streamingMedia);		    
     		utilityFunction.waitForChangesToReflect();
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
			String CVP_url = Var_Columbia_vpURL + VAR_DomClassic + "/home.do";    	
        	selenium.open(CVP_url);
        	selenium.waitForPageToLoad(VAR_MED_WAIT);
    		if (selenium.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
    		{
    			selenium.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
    			selenium.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
    			selenium.waitForPageToLoad(VAR_MED_WAIT);
    		}    		
        	Login.LoginCVP(selenium, VAR_userEmailID, VAR_userPassword);        	
        	Upload_EGCprogramCVP.test_Upload_EGCprogramCVP(selenium, VAR_EGCPogramName, VAR_streamingMediaEGC);
        	utilityFunction.waitForChangesToReflect();
    		assertTrue("Sm_vpc_007","Classic VP: Ensure that wmv file is uploaded from viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + VAR_EGCPogramName));
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