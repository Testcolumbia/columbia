/*
* Classname                                                        CVP_mediaEditor 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that media editor is launched for WMV file.(Captions, Chapters, Slides).<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Add a streaming media (wmv file)<br> 
*  																	>Select a slide deck
*																	>Click on Launch Media Editor<br> 
* 																	>Add a caption<br> 
* 																	>Add a chapter<br> 
* 																	>Add a slide<br> 	
*  																	>Save the changes<br> 																		 
* What Verification it performs:	 								Verify that user is able to add the caption, chapter and slide to the streaming media.<br> 
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

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.thoughtworks.selenium.*;

public class CVP_Sm_vpc_016_mediaEditor extends TesterAsserter {
	
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
			utilityFunction=null;
			selenium.setTimeout("0");
		}

	}		
	public void test_CVP_mediaEditor() throws Exception {
		{
			try
			{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//File name holding the global variables details
			String globalVariableFile ="Global_variables.xml";
			//Script specific variables file name
			String localVariableFile = "CVP_Sm_vpc_016_mediaEditor.xml";
			//Variable for the user name
            String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for login Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");			
			//Variable for filename name
		    String VAR_streamingMedia = utilityFunction.GetValue(localVariableFile ,"VAR_WMV_fileName");
		    //Variable for File Type
			String streamingMediaType = utilityFunction.GetValue(localVariableFile ,"VAR_fileType");
		    //Variable for slide name
			String VAR_SlideDisplayName = utilityFunction.GetValue(localVariableFile  ,"VAR_SlideDisplayName");		
			//Variable for the Slide's file name
			String VAR_SlideFileName = utilityFunction.GetValue(localVariableFile  ,"VAR_SlideFileName");	
			//Variable for the Live Program name			
			//Reusable action for Login to VCC
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
     		Upload_Media.Upload_slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
     		//Reusable action to upload a streaming media
     		Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, streamingMediaType);	
		   //Reusable action to Launch the media edito and add the caption, Chapter and slide. 		    
     		Launch_mediaEditor.test_Launch_mediaEditor(selenium, VAR_streamingMedia, VAR_SlideDisplayName);	
     		//Reusable action to log out of teh application
     		utilityFunction=null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				 selenium.close();
				 selenium.stop();
			}
		}
					 
	}
}