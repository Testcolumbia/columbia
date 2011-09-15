/*
* Classname                                                        Channel 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that user is able to create the Channels<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to programming<br> 
*  															     	>Click on the channels link and add/save channel<br> 															
* 																	>Verify that user is able to create the Channel<br> 																
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
import com.thoughtworks.selenium.DefaultSelenium;

public class Channel_TCID extends TesterAsserter{
	
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
	
	public void test_createchannels() throws Exception
	{ 
		try{
			
	    //Call to setUp function
	    setUp();
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";
		//Local Variable file name
		String localVariableFile="channel.xml";
		
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
		
		// Variable for Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
		
		//Channel name
		String VAR_channelname=utilityFunction.GetValue(localVariableFile ,"VAR_ChannelName");
	
		//Call to Login function as a AdminProtal
		Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
		
		//Call to reusable function create_channel to create channel
		Create_Channel.createchannel(selenium, VAR_channelname);
		
		//Ensure that user is able to create channel
		assertTrue("TC_XXX", "Ensure that user is able to create channel", date, selenium.isTextPresent("Channel created"));
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
