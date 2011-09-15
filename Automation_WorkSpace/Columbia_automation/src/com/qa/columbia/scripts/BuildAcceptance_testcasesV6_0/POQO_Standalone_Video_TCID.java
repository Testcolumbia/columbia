package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Login;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class POQO_Standalone_Video_TCID extends TesterAsserter {

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
	
	
	public void test_POQO_Standalone_Video() throws Exception 
		{
			try
			{
				setUp();
			Utility_Functions utilityFunction = new Utility_Functions(); 
			//Global Variables file
			String global_path ="Global_variables.xml";
			
			//Global Variables file
			String local_path ="POQO_Standalone_Video.xml";			
			
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
		
			
			   //Open the application URL in browser
				selenium.open(VAR_POQO_APPURL);
	            selenium.waitForPageToLoad(VAR_MED_WAIT);
	 	
	            if(selenium.isElementPresent(EnvObjectMap_Rep.Lnk_loginPoqo))
	            {
			 // Reusable to log into the application.
			   Login.POQOLogin(selenium, VAR_POQOUsername, VAR_POQOPassword);
	            }
			   
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
//				selenium.waitForPageToLoad("90000"); 
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
	            //utilityFunction.waitForChangesToReflect();
	                        
	            if (selenium.isAlertPresent())
	            {
	            	String SuccessMsg=selenium.getAlert();
	                 if (SuccessMsg=="Succesful connection to the server.")
	                 {
	                	 utilityFunction.waitForChangesToReflect();
	                	//Press space
	         			selenium.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
	                 }
	                 selenium.click(EnvObjectMap_Rep.Btn_saveconfigpoqo);
	            }
			   
			   selenium.click(EnvObjectMap_Rep.lnk_samplepage);
				selenium.waitForPageToLoad("30000");
				selenium.click(EnvObjectMap_Rep.Btn_standalonevideo);
				Thread.sleep(5000);
				
				String Var_frameWork_Path = utilityFunction.GetValue(global_path ,"Var_frameWork_Path");
				
				String streamingMedia = Var_frameWork_Path+"\\commonfiles\\"+Var_poqovideofile;
				selenium.focus(EnvObjectMap_Rep.Txt_browsepoqo);
				String abc = streamingMedia.toUpperCase();
				utilityFunction.keyEvent(selenium, abc);
				selenium.type(EnvObjectMap_Rep.Txt_browsepoqo, "t");
				selenium.type(EnvObjectMap_Rep.Txt_poqovideofilename, Var_poqovideoTitle);
				selenium.click(EnvObjectMap_Rep.Btn_addVideo);
				utilityFunction.waitForTextToPresent(selenium, "Program was created successfully.", 300);
				assertTrue("TC_XXX", "Verify that stand alone video is added successfully.", date, selenium.isTextPresent("Program was created successfully."));

				selenium.click("link=My Videos");
				selenium.waitForPageToLoad("90000"); 
				
				for (int i = 1; i<8; i=i+1)
				{
			    	String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_ProgName_MyVideos, i));  
			    	System.out.println(str_var);
			    	if (str_var.equals(Var_poqovideoTitle))
			    	{
			    		selenium.click(MessageFormat.format(EnvObjectMap_Rep.Btn_Preview_MyVideos, i));
			    		utilityFunction.waitForChangesToReflect();
			    		break;
			    	}                  
				}
				selenium.click(EnvObjectMap_Rep.Img_getASX);
				selenium.waitForPopUp("", "60000");
				selenium.selectWindow("name=undefined");
				assertTrue("TC_XXX", "Verify that added stand alone video is played successfully from My Videos page.", date, selenium.isTextPresent(Var_poqovideofile));
				
			}
			
			catch(Exception e )
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
