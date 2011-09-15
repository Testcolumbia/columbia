/*
 * This class contains reusable actions to Login to VCC admin portal and viewer portals.
 */


package com.qa.columbia.functions.v6_0;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.*;
import java.awt.event.KeyEvent;

import org.apache.tools.ant.types.Environment;


public class Login
	{

		
		//Function for login to admin portal
		
		public static void adminPortalLogin(Selenium sel, String usrName, String password, String domainName) throws Exception
		{
			//Global Variables File
			String globalVariableFile ="Global_variables.xml";
			//Object of Utility_Function class
			Utility_Functions utilityFunction = new Utility_Functions();
	        //Wait value for page to load
		    String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile,"VAR_MED_WAIT");
		    //Application URL
			String VAR_Columbia_APPURL = utilityFunction.GetValue(globalVariableFile ,"VAR_Columbia_APPURL");	
			sel.open(VAR_Columbia_APPURL);
			utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_userName, 300);
			//Maximize browser window
			sel.windowMaximize();
		    sel.windowFocus();
			sel.type(EnvObjectMap_Rep.Txt_userName, usrName);
			sel.type(EnvObjectMap_Rep.Txt_password, password);
			sel.select(EnvObjectMap_Rep.Drp_domain, "label="+domainName);
			sel.click(EnvObjectMap_Rep.Btn_login);
			utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_logout, 300);
		}
		
		//Function for login to classic viewer portal
		
		public void classicVPLogin(Selenium sel, String usrName, String password) throws Exception
		{
			//Global Variables File
			String globalVariableFile ="Global_variables.xml";
			//Object of Utility_Function class
			Utility_Functions utilityFunction = new Utility_Functions();
	        //Wait value for page to load
		    String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile,"VAR_MED_WAIT");
			sel.click(EnvObjectMap_Rep.Lnk_loginCVP);
			utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_loginCVP, 300);
			sel.type(EnvObjectMap_Rep.Txt_loginCVP, usrName);
			sel.type(EnvObjectMap_Rep.Txt_passwordCVP, password);
			sel.click(EnvObjectMap_Rep.Btn_loginCVP);
			sel.waitForPageToLoad(VAR_MED_WAIT);
		}
		
		//Function for login to social viewer portal
		
		public void socialVPLogin(Selenium sel, String usrName, String password) throws Exception
		{
			//Object of Utility_Function class
			Utility_Functions utilityFunction = new Utility_Functions();
			sel.click(EnvObjectMap_Rep.Lnk_loginSVP);
			//Wait for Textbox to present
			utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_loginCVP, 300);
			sel.type(EnvObjectMap_Rep.Txt_loginSVP, usrName);
			sel.type(EnvObjectMap_Rep.Txt_passwordSVP, password);
			sel.click(EnvObjectMap_Rep.Btn_loginSVP);
			utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_logoutSVP, 300);
		}
		
   //Function for login to social viewer portal
		
		public static void POQOLogin(Selenium sel, String usrName, String password) throws Exception
		{
			//Global Variables file
			String global_path ="Global_variables.xml";
			//Object of Utility_Function class
			Utility_Functions utilityFunction = new Utility_Functions();
			 //Wait value for page to load
		    String VAR_MED_WAIT = utilityFunction.GetValue(global_path,"VAR_MED_WAIT");
		    sel.windowMaximize();
			sel.click(EnvObjectMap_Rep.Lnk_loginPoqo);
			sel.waitForPageToLoad(VAR_MED_WAIT);
			sel.type(EnvObjectMap_Rep.Txt_UsernamePoqologin, usrName);
			sel.type(EnvObjectMap_Rep.Txt_PasswordPoqologin, password);
			sel.click(EnvObjectMap_Rep.Btn_loginPoqo);
			sel.waitForPageToLoad(VAR_MED_WAIT);						
		}
	//Function for login to social viewer portal by EGC user
	public static void EGC_SVPLogin(Selenium sel, String str_usrName, String str_password)throws Exception{
		//Global Variables file
		//String global_path ="Global_variables.xml";	
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
    	 if(!sel.isVisible(EnvObjectMap_Rep.Lnk_logoutSVP))  {  
        sel.click(EnvObjectMap_Rep.Lnk_loginSVP);
    	    for (int second = 0;second<=300; second++) {
			try { if (sel.isVisible(EnvObjectMap_Rep.txt_userNameSVP)) break; } catch (Exception e) {}
			Thread.sleep(1000);}
		sel.type(EnvObjectMap_Rep.txt_userNameSVP, str_usrName);
		sel.type(EnvObjectMap_Rep.txt_passwordSVP, str_password);
		sel.typeKeys(EnvObjectMap_Rep.txt_passwordSVP, "A");
		sel.click(EnvObjectMap_Rep.btn_loginSVP);
		utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.lnk_AddProgram_SVP,300);
		} else{
			utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.lnk_AddProgram_SVP,300);
			sel.click(EnvObjectMap_Rep.lnk_AddProgram_SVP); }}
		
//Function for login to Classic viewer portal by EGC user
	public static void EGC_CVPLogin	(Selenium sel, String str_usrName, String str_password)throws Exception{
//Object of Utility_Function class
	Utility_Functions utilityFunction = new Utility_Functions();
		    
	if(!sel.isTextPresent(EnvObjectMap_Rep.Txt_logoutCVP))  {  
   sel.click(EnvObjectMap_Rep.Lnk_loginCVP);
     utilityFunction.waitForTextToPresent(sel, EnvObjectMap_Rep.Txt_login, 300);
	sel.type(EnvObjectMap_Rep.txt_userNameCVP, str_usrName);
	sel.type(EnvObjectMap_Rep.txt_passwordCVP, str_password);
	sel.typeKeys(EnvObjectMap_Rep.txt_passwordCVP, "A");
	sel.click(EnvObjectMap_Rep.btn_loginCVP);
		utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.lnk_AddVideo_CVP,300);
	} else{
	utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.lnk_AddVideo_CVP,300);
			
	}
	}
}
