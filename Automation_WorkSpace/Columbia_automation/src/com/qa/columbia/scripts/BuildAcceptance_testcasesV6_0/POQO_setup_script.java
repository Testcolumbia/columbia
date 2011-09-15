/*
*  Classname                                                        POQO setup script
*
* Version info
*
* Copyright notice
*
* Test Case reference:												<>This script will create master program/channel for poqo<br>
* What the script does:											    >Login into the application<br>  
* 																	>Upload content
*                                                                   >Create Master program
*                                                                   >Create EGC channel
* What Verification it performs:									>Successfully create the Master program and channel<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 06/06/2011
* Updated by/on date: 												QASource on 06/06/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class POQO_setup_script extends TesterAsserter
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
	
	public void test_POQO_setup_script() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String global_path ="Global_variables.xml";
			
			String local_path="POQO_setup_script.xml";
			
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(global_path ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(global_path ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(global_path ,"Var_DomainSocial");
			//Variable for Waiting time
			String VAR_MIN_WAIT=utilityFunction.GetValue(global_path ,"VAR_MIN_WAIT");
		
			// Variable for streaming media file name
			String VAR_StreamingMedia=utilityFunction.GetValue(local_path ,"VAR_streamingMedia_Name");
			
			// Variable for source content file name used for uploading
			String VAR_sourceContentfile=utilityFunction.GetValue(local_path ,"VAR_sourceContentFile");
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(global_path ,"VAR_POQO_MasterProgram");
			

			// Variable for program name
			String VAR_EGCchannel=utilityFunction.GetValue(global_path ,"VAR_POQO_Channel");
			
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			
			//upload the streaming Media content
			Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, VAR_sourceContentfile);
			
			//Call to Create VOD program function
			Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);
			
			Thread.sleep(50000);
			//search by program name
			selenium.type(EnvObjectMap_Rep.lnk_VODProgramsearch, VAR_program);
			
			selenium.click(EnvObjectMap_Rep.Btn_programsearch);
			
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			selenium.click(EnvObjectMap_Rep.Lnk_masterprogram+VAR_program);
			selenium.waitForPageToLoad(VAR_MIN_WAIT);
			
			selenium.click(EnvObjectMap_Rep.CHK_masterprogram);
			
			selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
			
			selenium.click(EnvObjectMap_Rep.Lnk_domains);
			selenium.waitForPageToLoad("50000");
			
			
			 for (int i = 1; i<50; i++){
				 String str_var1=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult_domain,i));
				 System.out.println(str_var1);	   
				 if(str_var1.equals(VAR_domain)){
					 selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult_domain, i));
					 break;
				 }                  
			 }			
			 selenium.waitForPageToLoad(VAR_MIN_WAIT);			 
			if(selenium.isChecked(EnvObjectMap_Rep.chk_egcenabled))
			{
				
			}
			else{
				selenium.click(EnvObjectMap_Rep.chk_egcenabled);
			}
			
			selenium.click(EnvObjectMap_Rep.Btn_savedomain);
			
			Create_EGCchannel.Create_EGCChannel(selenium, VAR_EGCchannel, VAR_program);
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
