package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class SVP_Play_LiveProgram_TCID extends TesterAsserter {
	
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
			selenium.setTimeout("0");
		}		
	}		
	public void test_SVP_Play_LiveProgram() throws Exception {
		{
			try
			{
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 
				String globalVariableFile ="Global_variables.xml";
				String local_path = "SVP_Play_LiveProgram.xml";
				String Var_UserName = utilityFunction.GetValue(globalVariableFile, "VAR_USR");
				String Var_Password = utilityFunction.GetValue(globalVariableFile, "VAR_PWD");
				String Var_DomainName = utilityFunction.GetValue(globalVariableFile, "Var_DomainSocial");
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
				Login.adminPortalLogin(selenium, Var_UserName, Var_Password, Var_DomainName);
				String Var_Endpoint= utilityFunction.GetValue(globalVariableFile,"VAR_endPointIP");
				Create_Encoder.Encoder_WME(selenium, Var_EncoderName, VAR_EncoderHostIP, VAR_EncoderCommPort, VAR_EncoderDocRoot, Var_EncoderProfileName, VAR_EncoderPort, VAR_EncoderProfile_File);
				Create_Program.create_LiveProgram(selenium, Var_ProgramName, Var_EncoderName, Var_EncoderProfileName,"","","", Var_VEasWMS_DO);
				
				Launch_LBC.StartBroadcast(selenium, Var_ProgramName);
				Launch_VP.Launch_SVP(selenium, Var_DomainName);
				selenium.click(EnvObjectMap_Rep.Lnk_showAllJukeBox);
				selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, Var_ProgramName);
				selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
				Thread.sleep(5000);
				selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
				Thread.sleep(20000);
				selenium.click("//div[@id='jukebox']/div[5]/div[3]/div/div/a[1]");
				Thread.sleep(15000);
		        utilityFunction.waitForChangesToReflect();  
				//select the asx link
		        String contentlink = selenium.getText(EnvObjectMap_Rep.Var_asxLink);
		        //wait
		        utilityFunction.waitForChangesToReflect();  
		         //split the string
		     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
				contentlink_final=contentlink_final.trim();			
				selenium.openWindow(contentlink_final+"&debug=true", "asx");
				selenium.selectWindow("asx");
				Thread.sleep(5000);
				String htmlsource = selenium.getHtmlSource();
				assertTrue("TC_XXX","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, Var_EncoderProfileName));
				assertTrue("TC_XXX","Verify that multicast stream is displayed successfully in the asx file.",date,utilityFunction.assertTextContains(htmlsource, "http://"+Var_VEasWMS_IP+"/WMSControl"));
				assertTrue("TC_XXX","Verify that mms stream is displayed successfully in the asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms:"));
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
				selenium.selectWindow("null");
				selenium.close();
				selenium.stop();
			}
			
		}
	}
}