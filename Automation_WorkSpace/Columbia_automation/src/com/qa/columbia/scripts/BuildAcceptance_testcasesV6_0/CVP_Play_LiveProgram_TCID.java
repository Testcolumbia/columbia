
/*
* Class name                                                        CVP_Play_LiveProgram 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP:Play Live Program from Classic VP<br>
* What the script does:											    >Login to the application<br> 
*                                                                   >Create Encoders for the Live program													
* 																	>Create Live program<br>						
* 										                            >Launch classic viewer portal and assert the ASX file for lIve program<br>
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

public class CVP_Play_LiveProgram_TCID extends TesterAsserter {
	
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
			utilityFunction=null;
			selenium.setTimeout("0");
		}
	}		
	public  void test_CVP_Play_LiveProgram()throws Exception {
		try{
		setUp();
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";		
		//Local Variable file name
		String local_path="CVP_Play_LiveProgram.xml";		
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
		// Variable for login Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
		String Var_ProgramName = utilityFunction.GetValue(local_path, "LiveProgramName");
		String Var_EncoderName = utilityFunction.GetValue(local_path, "EncoderName");
		String Var_EncoderProfileName = utilityFunction.GetValue(local_path, "EncoderProfileName");
		String VAR_EncoderHostIP = utilityFunction.GetValue(globalVariableFile, "VAR_EncoderHostIP");
		String VAR_EncoderCommPort = utilityFunction.GetValue(globalVariableFile, "VAR_EncoderCommPort");
		String VAR_EncoderDocRoot = utilityFunction.GetValue(globalVariableFile, "VAR_EncoderDocRoot");
		String VAR_EncoderPort = utilityFunction.GetValue(globalVariableFile, "VAR_EncoderPort");
		String VAR_EncoderProfile_File = utilityFunction.GetValue(globalVariableFile, "VAR_EncoderProfile_File");
		String Var_VEasWMS_IP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");
		String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
		String Var_VideoNetEdge_ProfileName = utilityFunction.GetValue(globalVariableFile, "Var_VideoNetEdge_ProfileName");
		//variable for instance IP used for viewer portal
		String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_VCCInstanceIP");			
		//framework path will user for screen shot saving
		String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");	
		String Var_Endpoint= utilityFunction.GetValue(globalVariableFile,"VAR_endPointIP");
		//Call to reusable function for a admin portal
		Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);		
		//Call to reusable function for Create WME encoder
		Create_Encoder.Encoder_WME(selenium, Var_EncoderName, VAR_EncoderHostIP, VAR_EncoderCommPort, VAR_EncoderDocRoot, Var_EncoderProfileName, VAR_EncoderPort, VAR_EncoderProfile_File);
		
		//create delivery option
		Create_DeliveryOption.Create_VideoNetEdge(selenium, Var_VEasWMS_DO, Var_VEasWMS_IP, Var_VideoNetEdge_ProfileName);
		
		//Create Live program
		Create_Program.create_LiveProgram(selenium, Var_ProgramName, Var_EncoderName, Var_EncoderProfileName,"","","", Var_VEasWMS_DO);
		
		Launch_LBC.StartBroadcast(selenium, Var_ProgramName);
		//call to Launch classic view portal
		 Launch_VP.Launch_CVP(selenium, VAR_domain);
		 
		 selenium.selectWindow("Qumu Program Browser Home");
			
		 for (int s = 0;; s++)
		 {
			 if (s >= 80000) fail("timeout");
			 try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_home)) break; } catch (Exception e) {}
			 Thread.sleep(1000);
		 }
		 
		  selenium.click(EnvObjectMap_Rep.LNK_program);
		  Thread.sleep(2000);
		  
		  selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, Var_ProgramName);
		 selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);
		 
		utilityFunction.waitForChangesToReflect();	
		
	
	selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+Var_ProgramName);
	Thread.sleep(20000);
	selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+Var_EncoderProfileName);
	
	utilityFunction.waitForChangesToReflect();	
    //Capture the screenshot at the specified path
	String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_ProgramName + ".jpg";		
	//Capture the screen shot of the program
    selenium.captureScreenshot(screenShot_locPath);   		
    selenium.selectWindow("Qumu Program Player");
	//Maximize the window
	selenium.windowMaximize();
	//Get the html source
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
	assertTrue("TC_XXX","Verify that asx file for live program is generated successfully for classic view portal",date,utilityFunction.assertTextContains(htmlsource1, Var_EncoderProfileName));
	selenium.close();
	selenium.selectWindow("null");
	Launch_LBC.StopBroadcast(selenium, Var_ProgramName);	
	selenium.close();
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
