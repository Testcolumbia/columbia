/*
* Classname                                                        Category 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that user is able to create the Category<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to programming<br> 
*  															     	>Click on the Categories link and add/save Category<br> 															
* 																	>Verify that user is able to create the Category<br> 																
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

public class Category_TCID extends TesterAsserter{
	
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

	public  void test_CreateCategory() throws Exception
	{
		
		
		try{
			
		    //Call to setUp function
		    setUp();
			
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="Category.xml";
			// Variable for User name
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
			
			//Category name
			String VAR_categoryname=utilityFunction.GetValue(localVariableFile ,"VAR_CategoryName");
		
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			//Call to reusable function create_category to create channel
			Create_Category.createCategory(selenium, VAR_categoryname);
			//Ensure that user is able to create category
			assertTrue("TC_XXX", "Ensure that user is able to create category", date, selenium.isTextPresent("Category created"));
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
