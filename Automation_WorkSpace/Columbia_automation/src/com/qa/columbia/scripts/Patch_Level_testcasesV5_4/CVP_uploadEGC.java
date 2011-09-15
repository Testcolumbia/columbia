/*
* Classname                                                        CVP_img_upload 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that image file is uploaded in Content page.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the image radio button<br> 
* 																	>Browse the image file<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the image is uploaded in the content successfully<br> 	
*  																>Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to upload the image file successfully under Content.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class CVP_uploadEGC extends TesterAsserter {
	
	static boolean flag = false;
	
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
	public void test_CVP_uploadEGC() throws Exception {
		{
			try {
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
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//Variable for filename name
		    String VAR_userFirstName = utilityFunction.GetValue(local_path ,"VAR_userFirstName");
		    String VAR_userLastName = utilityFunction.GetValue(local_path ,"VAR_userLastName");
			String VAR_userEmailID = utilityFunction.GetValue(local_path, "VAR_userEmailID");
			String VAR_userPassword = utilityFunction.GetValue(local_path, "VAR_userPassword");
			String VAR_streamingMedia = utilityFunction.GetValue(local_path, "VAR_streamingMedia");
			String streamingMediaType = utilityFunction.GetValue(local_path, "streamingMediaType");
			String VAR_MasterVOD = utilityFunction.GetValue(local_path, "VAR_MasterVOD");
			String VAR_ChannelName = utilityFunction.GetValue(local_path, "VAR_ChannelName");
			String VAR_EGCPogramName = utilityFunction.GetValue(local_path, "VAR_EGCPogramName");
			String VAR_streamingMediaEGC = utilityFunction.GetValue(local_path, "VAR_streamingMediaEGC");
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Reusable action for Login to VCC     		
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
     		//Reusable action for create User
     		CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
     		//Reusable action to upload streaming media (wmv)
     		Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, streamingMediaType);	
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
		   
		   selenium.click(EnvObjectMap_Rep.chk_masterProgram);
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