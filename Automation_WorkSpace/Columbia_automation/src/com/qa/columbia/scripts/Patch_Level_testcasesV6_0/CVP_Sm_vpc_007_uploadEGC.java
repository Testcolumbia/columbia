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
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.*;

import com.qa.columbia.functions.v6_0.*;

import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
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
			String localVariableFile = "CVP_Sm_vpc_007_uploadEGC.xml";
			String setupVariableFile = "Setup_Script.xml";
			
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"Var_DomainClassic");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//wait variable
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			//User first name
		    String VAR_userFirstName = utilityFunction.GetValue(localVariableFile ,"VAR_userFirstName");
		    //User last name
		    String VAR_userLastName = utilityFunction.GetValue(localVariableFile ,"VAR_userLastName");
		    //User email ID
			String VAR_userEmailID = utilityFunction.GetValue(localVariableFile, "VAR_userEmailID");
			//User password
			String VAR_userPassword = utilityFunction.GetValue(localVariableFile, "VAR_userPassword");
			//Streaming media display name
			
			//Master VOD name
			String VAR_MasterVOD = utilityFunction.GetValue(localVariableFile, "VAR_MasterVOD");
			//Channel name
			String VAR_ChannelName = utilityFunction.GetValue(localVariableFile, "VAR_ChannelName");
			//EGC program name
			String VAR_EGCPogramName = utilityFunction.GetValue(localVariableFile, "VAR_EGCPogramName");
			//Streaming media file to be uploaded from EGC
			String VAR_streamingMediaEGC = utilityFunction.GetValue(localVariableFile, "VAR_streamingMediaEGC");
			
			String VAR_streamingMediaRSSDisc = utilityFunction.GetValue(setupVariableFile,"VAR_streamingMediaRSSDisc");	
			//Reusable action for Login to VCC     		
			Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);	
//			//Reusable action for create User
//     	   CreateUser.test_Create_User(selenium, VAR_userFirstName, VAR_userLastName, VAR_userEmailID, VAR_userPassword);
//     		
//		    //Reusable action for creating the on-demand program 
//    		Create_Program.create_VODProgram(selenium, VAR_MasterVOD,"" ,VAR_streamingMediaRSSDisc);
//     		
//     		utilityFunction.waitForChangesToReflect();
//		    if(!selenium.isTextPresent(VAR_MasterVOD))
//		    	{
//		    		//Search the new created Live program
//		    		selenium.click(EnvObjectMap_Rep.LNK_Search_Program);
//		    		//provide program name in Search field
//		    		selenium.type(EnvObjectMap_Rep.SelectType_Search_Program ,VAR_MasterVOD);
//		    		//click Search button 
//		    		selenium.click(EnvObjectMap_Rep.Btn_Search_Program);
//		    		//wait for loading the page
//		    		selenium.waitForPageToLoad(VAR_MED_WAIT);
//		    	}
//		    utilityFunction.waitForElementToPresent(selenium, "link=" + VAR_MasterVOD, 300);
//		    selenium.click("link=" + VAR_MasterVOD);
//		    selenium.waitForPageToLoad(VAR_MED_WAIT);
//		    if(!selenium.isChecked(EnvObjectMap_Rep.CHK_masterprogram))
//		    {
//		 	selenium.click(EnvObjectMap_Rep.CHK_masterprogram);
//		    }
//		   selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
//		   selenium.waitForPageToLoad(VAR_MED_WAIT);	
//		
//			 //Reusable action for EGC enabled channel
//	        Create_Channel.Create_EGCChannel(selenium, VAR_ChannelName, VAR_MasterVOD, VAR_userEmailID);
	 		
     		//Navigate to Social Viewer portal
			Launch_VP.Launch_CVP(selenium, VAR_DomClassic);
			//Login to  CVP as EGC user
        	Login.EGC_CVPLogin(selenium, VAR_userEmailID, VAR_userPassword);  
        	
        	//utilityFunction.waitForElementToVisible(selenium,"file",300);
			utilityFunction.waitForChangesToReflect(); 
        	         
            //Create a program containing WMV file
           Upload_Media.Upload_EGCprogramCVP(selenium, VAR_EGCPogramName,VAR_streamingMediaEGC,VAR_ChannelName);
        	
//       	
//           if(!selenium.isElementPresent(EnvObjectMap_Rep.lnk_AddVideo_CVP))
//           {
//        	   
//        	   selenium.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
//     		  selenium.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
//        	   
//           }
//           else
//           {
//       	utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.lnk_AddVideo_CVP,500);
//           }
           
           
//           
           selenium.waitForPageToLoad("20000");
		utilityFunction.waitForChangesToReflect();
  		assertTrue("Upload_EGCprogramCVP","Classic VP: Ensure that wmv file is uploaded from viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + VAR_EGCPogramName));
          Thread.sleep(5000);
    		//assertTrue("Sm_vpc_007","Classic VP: Ensure that wmv file is uploaded from viewer portal.",date,selenium.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + VAR_EGCPogramName));
    		
    		selenium.click(EnvObjectMap_Rep.Lnk_logoutCVP);
    		selenium.close();
    		//selenium.selectWindow("null");
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