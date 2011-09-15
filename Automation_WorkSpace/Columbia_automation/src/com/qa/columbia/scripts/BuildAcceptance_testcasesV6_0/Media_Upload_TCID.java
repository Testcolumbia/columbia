package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class Media_Upload_TCID extends TesterAsserter {
	
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
	public void test_uploadMedia() throws Exception {
		{
			try
			{
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 
				String str_path ="Global_variables.xml";
				String local_path = "Media_Upload.xml";
				String Var_UserName = utilityFunction.GetValue(str_path, "VAR_USR");
				String Var_Password = utilityFunction.GetValue(str_path, "VAR_PWD");
				String Var_DomainName = utilityFunction.GetValue(str_path, "Var_DomainSocial");
				String streamingMedia_DisplayName = utilityFunction.GetValue(local_path, "streamingMedia_DisplayName");
				String streamingMedia_FileName = utilityFunction.GetValue(local_path, "streamingMediaFileName");
				String slide_DisplayName = utilityFunction.GetValue(local_path, "slide_DisplayName");
				String slide_FileName= utilityFunction.GetValue(local_path, "slideFileName");
				String poll_DisplayName = utilityFunction.GetValue(local_path, "poll_DisplayName");
				String question_DisplayName = utilityFunction.GetValue(local_path, "questionDisplayName");
				String question_Title = utilityFunction.GetValue(local_path, "questionTitle");
				Login.adminPortalLogin(selenium, Var_UserName, Var_Password, Var_DomainName);
				Upload_Media.Upload_streamingMedia(selenium, streamingMedia_DisplayName, streamingMedia_FileName);
				Advance_Search.AdvanceSearch(selenium, streamingMedia_DisplayName);
				utilityFunction.waitForElementToPresent(selenium, EnvObjectMap_Rep.Lbl_nameHeader, 300);
				assertTrue("TC_XXX", "Verify that streaming media (wmv) file is uploaded successfully in content.", date, selenium.isTextPresent(streamingMedia_DisplayName)) ;
				Upload_Media.Upload_slides(selenium, slide_DisplayName, slide_FileName);
				Advance_Search.AdvanceSearch(selenium, slide_DisplayName);
				assertTrue("TC_XXX", "Verify that slide is uploaded successfully in content.", date, selenium.isTextPresent(slide_DisplayName)) ;
				Upload_Media.Upload_pollorsurvey(selenium, poll_DisplayName, question_DisplayName, question_Title);
				Advance_Search.AdvanceSearchPoll(selenium, poll_DisplayName);
				assertTrue("TC_XXX", "Verify that poll/survey is uploaded successfully in content.", date, selenium.isTextPresent(poll_DisplayName)) ;
				utilityFunction = null;
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