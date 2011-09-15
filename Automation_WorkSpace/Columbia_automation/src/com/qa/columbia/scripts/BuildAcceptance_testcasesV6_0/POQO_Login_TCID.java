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

public class POQO_Login_TCID extends TesterAsserter {
	
	static Date date=Calendar.getInstance().getTime();
	
	public void test_POQO_TCID_Login() throws Exception {
		{
			try{
			Utility_Functions utilityFunction = new Utility_Functions(); 
			//Gloval Variables file
			String global_path ="Global_variables.xml";
			 //Wait value for page to load
		    String VAR_MED_WAIT = utilityFunction.GetValue(global_path,"VAR_MED_WAIT");
			//Application URL
			String VAR_POQO_APPURL = utilityFunction.GetValue(global_path, "VAR_POQO_APPURL");
			String VAR_POQOUsername= utilityFunction.GetValue(global_path, "VAR_POQOUsername");
			String VAR_POQOPassword= utilityFunction.GetValue(global_path, "VAR_POQOPassword");
			
		    //Open the application URL in browser
			selenium.open(VAR_POQO_APPURL);
            selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Verify that login page is displayed
		 	for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.Lnk_loginPoqo))
					assertTrue("TC_XXX","Verify that POQO 'Login' page is displayed successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.Lnk_loginPoqo));
				assertTrue("TCID","Verify that Apache Tomcat Service is up.",date,selenium.isElementPresent(EnvObjectMap_Rep.Lnk_loginPoqo));      
				break; } catch (Exception e) {
					e.printStackTrace();
				}
				Thread.sleep(1000);
			}
		 // Reusable to log into the application.
		   Login.POQOLogin(selenium, VAR_POQOUsername, VAR_POQOPassword);		
		// Verify that user is successfully logged into application.	
		     for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (selenium.isElementPresent(EnvObjectMap_Rep.Lnk_logoutPoqo))
					 assertTrue("TC_XXX","Verify that User is successfully able to log into POQO.",date,selenium.isElementPresent(EnvObjectMap_Rep.Lnk_logoutPoqo));
				   break; } catch (Exception e) {
					   e.printStackTrace();
				   }
				Thread.sleep(1000);
			}
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