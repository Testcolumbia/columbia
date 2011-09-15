package com.qa.columbia.functions.v5_4;

//import java.util.Calendar;
//import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.Selenium;



public class Login {
	//Reusable action to login to CVP
	public static void LoginCVP(Selenium sel, String str_Username, String str_Password) throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
      //  Date date=Calendar.getInstance().getTime();
	    String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT") ;
	    if(sel.isVisible(EnvObjectMap_Rep.lnk_LoginCVP))
        { 
		sel.click(EnvObjectMap_Rep.lnk_LoginCVP);
	  	for (int second = 0;second<=300; second++) {
			try { if (sel.isVisible(EnvObjectMap_Rep.txt_userNameCVP)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		sel.type(EnvObjectMap_Rep.txt_userNameCVP, str_Username);
		sel.type(EnvObjectMap_Rep.txt_passwordCVP, str_Password);
		sel.click(EnvObjectMap_Rep.btn_loginCVP);
		sel.waitForPageToLoad(VAR_MED_WAIT);
        }
		//assertTrue(" ","Verify that user is able to login to classic viewer portal.",date,sel.isElementPresent(EnvObjectMap_Rep.lnk_logOutCVP));
	}
	//Reusable action to login to SVP
	public static void LoginSVP(Selenium sel, String str_Username, String str_Password) throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions(); 
        if(!sel.isVisible(EnvObjectMap_Rep.lnk_logOutSVP))
        {  
        sel.click(EnvObjectMap_Rep.lnk_LoginSVP);
    	for (int second = 0;second<=300; second++) {
			try { if (sel.isVisible(EnvObjectMap_Rep.txt_userNameSVP)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		sel.type(EnvObjectMap_Rep.txt_userNameSVP, str_Username);
		sel.typeKeys(EnvObjectMap_Rep.txt_passwordSVP, str_Password);
		sel.click(EnvObjectMap_Rep.btn_loginSVP);
		utilityFunction.waitForChangesToReflect();
        }
		//assertTrue("Login_SVP","Verify that user is able to login to Social viewer portal.",date,sel.isElementPresent(EnvObjectMap_Rep.lnk_logOutSVP));
	}

	public static void test_login(Selenium sel, String str_Username, String str_Password, String str_DomainName) throws Exception {
	       
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
	//	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	    String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path ,"VAR_Columbia_APPURL");		
		// Open the browser and enter the URL
		sel.open(VAR_Columbia_APPURL);
		//wait
        sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Maximize browser window
		sel.windowMaximize();
	    sel.windowFocus();
		// Enter the User Name
		sel.type(EnvObjectMap_Rep.LNK_UserName, str_Username);			 
		// Enter the Password
		sel.type(EnvObjectMap_Rep.LNK_Password, str_Password);			
		//Select the Domain
		sel.select(EnvObjectMap_Rep.dropdown_Domain,str_DomainName);	
		//Click on Login button
        sel.click(EnvObjectMap_Rep.BTN_LOGIN);
	    //Wait function is used
	    sel.waitForPageToLoad(VAR_MAX_WAIT);
	    }
}
