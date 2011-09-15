package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;





import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Login;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class POQO_extractVideosUsingChannel_TCID extends TesterAsserter {
	
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
	public void test_POQO_extractVideosUsingChannel() throws Exception 
		{
			try
			{
				
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String global_path ="Global_variables.xml";
				
				//Global Variables file
				String local_path ="POQO_extractVideosUsingChannel.xml";				
				
				 //Wait value for page to load
			    String VAR_MED_WAIT = utilityFunction.GetValue(global_path,"VAR_MED_WAIT");
				//Application URL
				String VAR_POQO_APPURL = utilityFunction.GetValue(global_path, "VAR_POQO_APPURL");
				
				//Variable for POQO username
				String VAR_POQOUsername= utilityFunction.GetValue(global_path, "VAR_POQOUsername");				

				//Variable for POQO password
				String VAR_POQOPassword= utilityFunction.GetValue(global_path, "VAR_POQOPassword");
				
				//variable for POQO  Webservice Host IP
				String VAR_VCCInstanceIP =utilityFunction.GetValue(global_path,"VAR_VCCInstanceIP");
				
				//variable for POQO  webservice port
				String VAR_POQO_WebServicePort=utilityFunction.GetValue(global_path, "VAR_POQO_WebServicePort");
				
				//variable for POQO  configuration channel
				String VAR_POQO_Channel=utilityFunction.GetValue(global_path, "VAR_POQO_Channel");
				
				//variable for POQO  configuration domain
				String Var_DomainSocial=utilityFunction.GetValue(global_path, "Var_DomainSocial");
				
				//Variable for poqo video file Title
				String Var_poqovideoTitle=utilityFunction.GetValue(local_path, "VAR_poqoVideotitle");
				
				//Variable for poqo video file to upload
				String Var_poqovideofile=utilityFunction.GetValue(local_path, "VAR_poqoVideofile");
				
				//Variable for Extract Video library
				String Var_poqoExtractVideoLibrary=utilityFunction.GetValue(local_path, "Var_poqoExtractVideoLibrary");
				
				//Open the application URL in browser
				selenium.open(VAR_POQO_APPURL);
	            selenium.waitForPageToLoad(VAR_MED_WAIT);
	            selenium.windowMaximize(); 
	            
	            if(selenium.isElementPresent(EnvObjectMap_Rep.Lnk_loginPoqo))
	            {
			 // Reusable to log into the application.
			   Login.POQOLogin(selenium, VAR_POQOUsername, VAR_POQOPassword);
	            }
			   
			   for (int second = 0;; second++) {
					if (second >= 300) fail("timeout");
					try { if (selenium.isElementPresent(EnvObjectMap_Rep.Tab_Config))
						assertTrue("POQO_extractVideosUsingChannel","Verify that Config tab is displayed successfully.",date,selenium.isElementPresent(EnvObjectMap_Rep.Tab_Config));
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
	            }
	            selenium.click(EnvObjectMap_Rep.lnk_samplepage);
	    		selenium.waitForPageToLoad("30000");
	    		utilityFunction.waitForChangesToReflect();
	    		selenium.click(EnvObjectMap_Rep.Btn_ExtractVideoLibrary);
	    		selenium.type(EnvObjectMap_Rep.Txt_TitleExtractVideoLibrary, Var_poqoExtractVideoLibrary);
	    		//selenium.click("vlType_CHANNEL_EXTRACT");
	    		selenium.click(EnvObjectMap_Rep.Btn_CreateExtractVideoLibrary);
	    		Thread.sleep(10000);
	    		selenium.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + "");
//	    		selenium.chooseOkOnNextConfirmation();
	    		Thread.sleep(5000);
	    		utilityFunction.waitForTextToPresent(selenium, Var_poqovideoTitle, 300);
	    		
	    		
	    		try{
				for (int i = 1; i<50; i=i+1)
				{
			    	String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_videoLibrary, i));  
			    	System.out.println(str_var);
			    	if (str_var.equals(Var_poqoExtractVideoLibrary))
			    	{
			    		for (int a = 2; a<8; a=a+1)
						{
			    		String str_var1=selenium.getText("//div["+i+"]/div["+a+"]/div/a/span");  
				    	System.out.println(str_var1);
				    	if (str_var1.equals(Var_poqovideoTitle))
				    	{
//				    		assertTrue("POQO_Standalone_Video", "Verify that Video is extracted from Channel.", date, selenium.isTextPresent(Var_poqovideoTitle));
				    		selenium.click("//div["+i+"]/div["+a+"]/div/a/span");
				    		utilityFunction.waitForChangesToReflect();
				    		selenium.click(EnvObjectMap_Rep.Img_getASX);
							selenium.waitForPopUp("", "60000");
							selenium.selectWindow("name=undefined");
							assertTrue("TC_XXX", "Verify that asx file for extracted video is generated successfully.", date, selenium.isTextPresent(Var_poqovideofile));
						
							break;
				    	}   
						}
			    	break;
			    	}   
			    	Thread.sleep(1000);
				}}
	    		catch(Exception e)
	    		{
	    			System.out.println("Exception");
		    		selenium.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + "");
		    		for (int i = 1; i<50; i=i+1)
					{
		    		String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_videoLibrary, i));  
			    	System.out.println(str_var);
			    	if (str_var.equals(Var_poqoExtractVideoLibrary))
			    	{
			    		for (int a = 2; a<8; a=a+1)
						{
			    		String str_var1=selenium.getText("//div["+i+"]/div["+a+"]/div/a/span");  
				    	System.out.println(str_var1);
				    	if (str_var1.equals(Var_poqovideoTitle))
				    	{
				    		assertTrue("POQO_Standalone_Video", "Verify that Video is extracted from Channel.", date, selenium.isTextPresent(Var_poqovideoTitle));
				    		selenium.click("//div["+i+"]/div["+a+"]/div/a/span");
				    		utilityFunction.waitForChangesToReflect();
				    		selenium.click(EnvObjectMap_Rep.Img_getASX);
							selenium.waitForPopUp("", "60000");
							selenium.selectWindow("name=undefined");
							assertTrue("POQO_extractVideosUsingChannel", "Verify that asx file for extracted video is generated successfully.", date, selenium.isTextPresent(Var_poqovideofile));
				    		break;
				    	}   
						}
			    	break;
			    	}   
			    	Thread.sleep(1000);
				}
	    		}
	    		Thread.sleep(50000);
	            
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
}