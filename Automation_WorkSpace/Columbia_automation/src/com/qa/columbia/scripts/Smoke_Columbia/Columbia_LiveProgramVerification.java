/*
* Classname                                                        Columbia_LiveProgramVerification 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Verify that user is able to Play Live Broadcast program on Social Viewer portal<br>
* What the script does:											>Login to the application<br> 
* 																	>Create a domain<br> 
*																	>Navigate inside the created domain<br> 
*  																>Create a storage<br> 
*																	>Create HTTP Server delivery option<br> 
* 																	>Create WMS delivery option<br> 
* 																	>Create a Windows Media Encoder<br> 
* 																	>Upload a Slide from Content<br> 
* 																	>Create a Category<br> 
* 																	>Create a channel<br> 
* 																	>Create a Live Broadcast Program<br> 
* 																	>Launch the LBC and Start the broadcast<br> 	
*  																>Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to play the Live Program.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar
*/

package com.qa.columbia.scripts.Smoke_Columbia;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.*;
import com.qa.columbia.functions.v5_4.*;
import com.thoughtworks.selenium.*;


public class Columbia_LiveProgramVerification extends TesterAsserter {
	
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
		}

	}	

	public void test_Columbia_LiveProgramVerification() throws Exception {
		{
			setUp();
		
			Utility_Functions utilityFunction = new Utility_Functions();
		
			//Variable to contain a random number
			String Rndm = utilityFunction.getRandomNumber();
		
			//Variable for global XML file name
			String str_path ="Global_variables.xml";
		
			//Variable for local XML file name
			String local_path ="local_Variables.xml";
		
			//Variable for domain ID
			String VAR_DomID = utilityFunction.GetValue(str_path ,"VAR_DomID");
			String DomainID_rndm = VAR_DomID + Rndm;
		
			//Variable for domain name
			String VAR_Dom = utilityFunction.GetValue(str_path ,"VAR_Dom");
			String DomainName_rndm = VAR_Dom + Rndm;
		
			//Variable for storage name
			String VAR_Storage = utilityFunction.GetValue(local_path ,"VAR_Storage");
			String StorageName_rndm = VAR_Storage + Rndm;
		
			//Variable for HTTP delivery option name
			String VAR_HTTP = utilityFunction.GetValue(local_path ,"VAR_HTTP");
			String HTTPName_rndm = VAR_HTTP + Rndm;
		
			//Variable for WMS delivery option name
			String VAR_WMS = utilityFunction.GetValue(local_path ,"VAR_WMS");
			String WMSName_rndm = VAR_WMS + Rndm;
		
			//Variable for Windows media encoder name
			String Var_WME = utilityFunction.GetValue(local_path ,"Var_WME");
			String WMEName_rndm = Var_WME + Rndm;
		
			//Variable for Windows Media Encoder Profile name
			String Var_WMEProf_Name = utilityFunction.GetValue(local_path ,"Var_WMEProf_Name");
			String WMEProName_rndm = Var_WMEProf_Name + Rndm;
		
			//Variable for display name of content (Slide)
			String VAR_DispName_Content = utilityFunction.GetValue(local_path ,"VAR_DispName_Content");
			String SlideName_rndm = VAR_DispName_Content + Rndm;
		
			//Variable for category name
			String VAR_Cat = utilityFunction.GetValue(local_path ,"VAR_Cat");
			String CategoryName_rndm =VAR_Cat + Rndm;
		
			//Variable for channel name
			String VAR_Chnl = utilityFunction.GetValue(local_path ,"VAR_Chnl");
			String ChannelName_rndm = VAR_Chnl + Rndm;
		
			//Variable for Live program name
			String VAR_Live_Program = utilityFunction.GetValue(local_path ,"VAR_Live_Program");
			String LiveProgramName_rndm = VAR_Live_Program + Rndm;
				
			//Fetching values for login function from XMl file
			//String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");
				
			//Fetching values for create_domain function from XMl file
			String VAR_SiteURL = utilityFunction.GetValue(str_path ,"VAR_SiteURL");
			String VAR_WMP_log_loc = utilityFunction.GetValue(str_path ,"VAR_WMP_log_loc");
				
			//Fetching values for create_storage function from XMl file
			String VAR_AP_Host = utilityFunction.GetValue(str_path ,"VAR_AP_Host");
			String VAR_AP_MountPoint = utilityFunction.GetValue(str_path ,"VAR_AP_MountPoint");
				
			//Fetching values for create_HTTP function from XMl file
			String VAR_HTTP_Host = utilityFunction.GetValue(str_path ,"VAR_HTTP_Host");
				
			//Fetching values for create_WMS function from XMl file
			String VAR_Host = utilityFunction.GetValue(str_path ,"VAR_Host");
			String VAR_HTTPPort = utilityFunction.GetValue(str_path ,"VAR_HTTPPort");
			String VAR_WebServiceUserName = utilityFunction.GetValue(str_path ,"VAR_WebServiceUserName");
			String VAR_WebServicePassword = utilityFunction.GetValue(str_path ,"VAR_WebServicePassword");
				
			//Fetching values for create_WME function from XMl file
			String Var_WME_Host = utilityFunction.GetValue(str_path ,"Var_WME_Host");
			String Var_WME_ComPort = utilityFunction.GetValue(str_path ,"Var_WME_ComPort");
			String Var_WME_DocRoot = utilityFunction.GetValue(str_path ,"Var_WME_DocRoot");
			String Var_WMEProf_Port = utilityFunction.GetValue(str_path ,"Var_WMEProf_Port");
			String Var_WMEProf_Path = utilityFunction.GetValue(str_path ,"Var_WMEProf_Path");
				
			//Fetching value for Variable used in upload_slides function from XMl file
			String VAR_Upload_Content = utilityFunction.GetValue(str_path ,"VAR_Upload_Content");
				
			//Call login function to login in application
			//Login.test_login(selenium,VAR_USR,VAR_PWD);
				
			//Call create_domain function to create domain and move to that domain
			Create_domain.create_domain(selenium, DomainID_rndm, DomainName_rndm,VAR_SiteURL, VAR_WMP_log_loc );
      
			//Call create_storage function to create the storage
		    Create_storage.create_storage(selenium,StorageName_rndm, VAR_AP_Host, VAR_AP_MountPoint);
				
			//Call create_HTTP function to create the HTTP delivery option
			Create_HTTP.create_HTTP(selenium,HTTPName_rndm, VAR_HTTP_Host, VAR_AP_MountPoint, StorageName_rndm);
	
			//Call create_WMS function to create the WMS delivery option
			Create_WMS.create_WMS(selenium,WMSName_rndm, VAR_Host, VAR_HTTPPort, VAR_WebServiceUserName, VAR_WebServicePassword);

			//call create_WME function to create a WME.
			Create_WME.create_WME(selenium,WMEName_rndm, Var_WME_Host, Var_WME_ComPort, Var_WME_DocRoot,WMEProName_rndm, Var_WMEProf_Port, Var_WMEProf_Path);

			//Call upload_slides function to upload content  
			upload_slides.Upload_Slides(selenium ,SlideName_rndm, VAR_Upload_Content);
	
			//call reusable action to create category
			Create_Category.create_Category(selenium, CategoryName_rndm);	
	
			//call the reusable action to create channel
			Create_Channel.create_Channel(selenium, ChannelName_rndm);
		
			//call reusable action to create Live Broadcast Program
			Create_liveProgram.create_LiveProgram(selenium, LiveProgramName_rndm,ChannelName_rndm,WMEName_rndm, WMEProName_rndm,SlideName_rndm);
				 
			//call the reusable action to start the broadcast of live program from LBC
			Launch_LBC.LBC(selenium);	
		
		    //Wait
			utilityFunction.waitForChangesToReflect();
		
			//Select the admin portal window
			selenium.selectWindow(null);
		
			//Close the admin portal window
			selenium.close();

			//call the reusable action to play the program on the Social Viewer portal
			Play_LiveProgram.Play_Live_Program(selenium,DomainID_rndm); 	
				   
		}
	}
}