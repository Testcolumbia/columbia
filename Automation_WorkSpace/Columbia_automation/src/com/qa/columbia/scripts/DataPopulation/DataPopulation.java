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

package com.qa.columbia.scripts.DataPopulation;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.*;
import com.qa.columbia.functions.v5_4.*;
import com.thoughtworks.selenium.*;


public class DataPopulation extends TesterAsserter {
	
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
		}

	}	

	public void test_DataPopulation() throws Exception {
		{
			setUp();
		
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			//Variable for the user name
			String VAR_Username = utilityFunction.GetValue(str_path,"VAR_USR");
			//Variable for the Password
			String VAR_Password = utilityFunction.GetValue(str_path,"VAR_PWD");		
     		//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_Username, VAR_Password, "System Default Domain");     		
      		//Create_Category.create_Category(selenium, "Category");
     		//Reusable action for image upload
       	//	Create_Program.test_Create_vodProgram(selenium, "VOD1", "wmv1");
     		for(int i=100;i==100;i++)
     		{
         	/*	Create_Category.create_Category(selenium, "Category"+i);
         		Create_Channel.create_Channel(selenium, "Channel"+i);*/	
     			Upload_Media.Upload_streamingMedia(selenium, "wmv"+i, "wmv1.wmv");
         		Create_Program.test_Create_vodProgram(selenium, "VOD"+i, "wmv"+i);
     		}
     		selenium.stop();
     		
		}
	}
}