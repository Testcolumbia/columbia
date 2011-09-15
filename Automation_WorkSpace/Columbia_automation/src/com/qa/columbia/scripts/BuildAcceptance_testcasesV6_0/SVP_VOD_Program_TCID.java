package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.DefaultSelenium;

public class SVP_VOD_Program_TCID  extends TesterAsserter

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
	
	public void test_SVP_VOD_Program() throws Exception
	{
		
		try
		   {
			
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String global_path ="Global_variables.xml";
			//Local Variable file name
			String local_path="SVP_VOD_Program.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(global_path ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(global_path ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(global_path ,"Var_DomainSocial");
			
			// Variable for program name
			String VAR_StreamingMedia=utilityFunction.GetValue(local_path ,"VAR_StreamingMedia");
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(local_path ,"VAR_programName");
			// Variable for program name
			String VAR_asxfile=utilityFunction.GetValue(local_path ,"VAR_ASXfileName");
			
			//Call to reusable function for a admin portal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
			//Call to Create VOD program function
			Create_Program.create_VODProgram(selenium, VAR_program,"", VAR_StreamingMedia);
			Launch_VP.Launch_SVP(selenium, VAR_domain);
		    //call to reusable function for play VOD
		    Play_Program.play_Porgram(selenium, VAR_domain, VAR_program);
		    String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
			utilityFunction.waitForChangesToReflect();
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");
			selenium.openWindow(contentlink_final+"&debug=true", "ASX");
		    selenium.selectWindow("ASX");
		    Thread.sleep(2000);
		    //Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
		    assertTrue("TC_XXX","Verify that VOD program is successfully played",date,utilityFunction.assertTextContains(htmlsource, VAR_asxfile));
			utilityFunction=null;
			selenium.close();
			selenium.selectWindow("null");
			
		   }
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			selenium.close();
			selenium.stop();
		}
	}
	
	
}
