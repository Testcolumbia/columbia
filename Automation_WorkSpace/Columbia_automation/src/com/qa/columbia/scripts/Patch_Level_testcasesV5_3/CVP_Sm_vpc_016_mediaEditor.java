/*
* Classname                                                        CVP_Sm_vpc_016_mediaEditor 
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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_3;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_3.*;
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
			selenium.setTimeout("0");
			utilityFunction=null;
		}

	}		
	public void test_CVP_Sm_vpc_016_mediaEditor() throws Exception {
		{
			try{
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			//File name holding the global variables details
			String str_path ="Global_variables.xml";
			//Script specific variables file name
			String local_path = "CVP_mediaEditor.xml";
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");	
			//Variable for the domain name
			String VAR_DomClassic = utilityFunction.GetValue(str_path,"VAR_DomClassic");			
			//Variable for filename name
		    String VAR_streamingMedia = utilityFunction.GetValue(local_path ,"VAR_WMV_fileName");
		    //Variable for File Type
			String streamingMediaType = utilityFunction.GetValue(local_path ,"VAR_fileType");
		    //Variable for slide name
			String VAR_SlideName = utilityFunction.GetValue(local_path,"VAR_SlideName");
			//Variable for the slide file name
			String VAR_Slidefile = utilityFunction.GetValue(local_path,"VAR_Slidefile");
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomClassic);
     		//Reusable action for slides
     		Upload_Media.Upload_Slides(selenium, VAR_SlideName, VAR_Slidefile);
     		//Reusable action to upload a streaming media
     		Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMedia, streamingMediaType);	
		   //Reusable action to Launch the media edito and add the caption, Chapter and slide. 		    
     		Launch_mediaEditor.test_Launch_mediaEditor(selenium,"Sm_vpc_016", VAR_streamingMedia, VAR_SlideName);	
     		utilityFunction=null;
			}catch(Exception e)
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