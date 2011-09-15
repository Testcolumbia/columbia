/*
* Class name                                                        CVP_TCID_VOD_Program 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP:Play VOD Program from Classic VP<br>
* What the script does:											    >Login to the application<br> 
*                                                                   >Upload content														
* 																	>Create VOD program<br>						
* 										                            >Launch classic viewer portal and assert the ASX file<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/

package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;


import java.util.Calendar;
import java.util.Date;


import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class CVP_VOD_Program_TCID  extends TesterAsserter

{
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
			utilityFunction=null;
			selenium.setTimeout("0");
		}

	}		
	
	public void test_CVP_VOD_Program() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String global_path ="Global_variables.xml";
			
			//Local Variable file name
			String local_path="CVP_VOD_Program.xml";
			
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(global_path ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(global_path ,"VAR_PWD");
			
			// Variable for login Domain
			String VAR_domain=utilityFunction.GetValue(global_path ,"Var_DomainClassic");
	
			
			// Variable for streaming media file name
			String VAR_StreamingMedia=utilityFunction.GetValue(local_path ,"VAR_streamingMedia_Name");
			
			// Variable for source content file name used for uploading
			String VAR_sourceContentfile=utilityFunction.GetValue(local_path ,"VAR_sourceContentFile");
			
			
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(local_path ,"VAR_programName");
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
		
			//variable for instance IP used for viewer portal
			String VAR_InstanceIP = utilityFunction.GetValue(global_path ,"VAR_VCCInstanceIP");	
			
			//framework path will user for screen shot saving
			String Var_frameWork_Path = utilityFunction.GetValue(global_path ,"Var_frameWork_Path");
			
			//upload the streaming Media content
			Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, VAR_sourceContentfile);
			
			//Call to Create VOD program function
			Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);			 
			//call to Launch classic view portal
			Launch_VP.Launch_CVP(selenium, VAR_domain);
			selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, VAR_program);
			selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);				 
			utilityFunction.waitForChangesToReflect();				
			selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_program);
			Thread.sleep(20000);
			selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_StreamingMedia);			
			utilityFunction.waitForChangesToReflect();	
			//Capture the screenshot at the specified path
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + VAR_program + ".jpg";		
			//Capture the screen shot of the program
			selenium.captureScreenshot(screenShot_locPath);			
			selenium.selectWindow("Qumu Program Player");
			//Maximize the window
			selenium.windowMaximize();
			//Get the html source
			Thread.sleep(2000);
			String htmlsource = selenium.getHtmlSource();
			int start_URL = htmlsource.indexOf("http://"+VAR_InstanceIP);
       		int end_URL = htmlsource.lastIndexOf("\";");       	    
       		String stream_URL1 = htmlsource.substring(start_URL, end_URL);
       		int stream_URL_length = stream_URL1.length();
       		String stream_URL = stream_URL1.substring(0, stream_URL_length);
     		System.out.println(stream_URL);     	
     		//Open the stream URL in the browser
     		selenium.open(stream_URL + "&debug=true");
	   		selenium.waitForPageToLoad("90000");	   		
	   		//get the html source code
	   		String htmlsource1 = selenium.getHtmlSource();	   		
	   		//Ensure that source content file is displayed in source
	   		assertTrue("TC_XXX","Verify that asx file for on-demand program is generated successfully for classic view portal",date,utilityFunction.assertTextContains(htmlsource1, VAR_sourceContentfile));
	   		selenium.close();
	   		selenium.selectWindow(VAR_program);
	   		selenium.close();
	   		utilityFunction=null;
		   }
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			selenium.selectWindow("null");
			selenium.close();
			selenium.stop();
		}
	}
	
	
}
