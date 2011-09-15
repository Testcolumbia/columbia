/*
*  Classname                                                        Login to poqo application 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure the Login to poqo application.<br>
* What the script does:											    >Open the Poqo login page<br>  
* 																	>Verify the objects displayed.
* What Verification it performs:									1.Verify that 'Login' page is displayed successfully.<br> 
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

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class POQO_ConfServPortal_TCID extends TesterAsserter {
	
	
	
	static Date date=Calendar.getInstance().getTime();
	
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
	
	public void test_ConfServPortal() throws Exception {
		{
			try{
				setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			//Global Variables file
			String global_path ="Global_variables.xml";
			
			 //Wait value for page to load
		    String VAR_MED_WAIT = utilityFunction.GetValue(global_path,"VAR_MED_WAIT");
			//Application URL
			String VAR_POQO_APPURL = utilityFunction.GetValue(global_path, "VAR_POQO_APPURL");
			
			//Variable for POQO username
			String VAR_POQOUsername= utilityFunction.GetValue(global_path, "VAR_POQOUsername");
			

			//Variable for POQO password
			String VAR_POQOPassword= utilityFunction.GetValue(global_path, "VAR_POQOPassword");
			

			//Variable for poqo webhost ip
			
			String VAR_VCCInstanceIP =utilityFunction.GetValue(global_path,"VAR_VCCInstanceIP");
			
			String VAR_POQO_WebServicePort=utilityFunction.GetValue(global_path, "VAR_POQO_WebServicePort");
			
			String VAR_POQO_Channel=utilityFunction.GetValue(global_path, "VAR_POQO_Channel");
			String Var_DomainSocial=utilityFunction.GetValue(global_path, "Var_DomainSocial");

			
		 //Open the application URL in browser
			selenium.open(VAR_POQO_APPURL);
			
            selenium.waitForPageToLoad(VAR_MED_WAIT);
 	
		 // Reusable to log into the application.
		   Login.POQOLogin(selenium, VAR_POQOUsername, VAR_POQOPassword);		
		// Verify that user is successfully logged into application.	
		   for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.Tab_Config))
					assertTrue("TC_XXX","Verify that Config tab is displayed successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.Tab_Config));
				    selenium.click(EnvObjectMap_Rep.Tab_Config);
				    selenium.waitForPageToLoad(VAR_MED_WAIT);
				    break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type(EnvObjectMap_Rep.Tbx_WebServiceHost, VAR_VCCInstanceIP);
			selenium.type(EnvObjectMap_Rep.Tbx_WebServicePort, VAR_POQO_WebServicePort);
			selenium.type(EnvObjectMap_Rep.Tbx_WebServiceDomain, Var_DomainSocial);
			selenium.type(EnvObjectMap_Rep.Tbx_DefaultChannel, VAR_POQO_Channel);
			
			selenium.click(EnvObjectMap_Rep.Btn_TestConnection);
			for(int i = 0;1<=50; i++)
			{
				try
				{
					if(selenium.isAlertPresent())
					break;
				}
				catch(Exception e)
				{
					Thread.sleep(2000);
				}
			}
                        
            if (selenium.isAlertPresent())
            {
            	String SuccessMsg=selenium.getAlert();
                 if (SuccessMsg=="Succesful connection to the server.")
                 {
                	//Press space
         			selenium.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
                 }
                 selenium.click(EnvObjectMap_Rep.Btn_saveconfigpoqo);
            	 selenium.waitForPageToLoad(VAR_MED_WAIT);	
                 utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			assertTrue("TC_XXX","Verify that Config settings are saved successfully",date,selenium.isElementPresent("//div[@id='defaultLibrary']/div"));
			selenium.click(EnvObjectMap_Rep.Lnk_logoutPoqo);
            }
		   
            
		  	
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