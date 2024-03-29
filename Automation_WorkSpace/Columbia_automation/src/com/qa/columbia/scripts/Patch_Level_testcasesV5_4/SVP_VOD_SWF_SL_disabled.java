/*
* Classname                                                        SVP_VOD_SWF_SL_disabled
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Social VP: Ensure that an On Demand program(SWF file) plays with HTTP delivery option if SL is disabled in browser.<br>
* What the script does:											    >Login to the application<br> 
* 																	>Navigate to Programming menu<br> 
*																	>Navigate to Content<br> 
*  															     	>Click on Add Item button<br> 
*																	>Select the simple streaming radio button<br> 
* 																	>Browse the .swf file to upload<br> 
* 																	>Provide the Display name<br> 
* 																	>Verify that the swf is uploaded in the content successfully<br> 	
*																	>Create a VOD program containing the mp3 file
*  																    >Launch the viewer portal and play the program<br> 
*   																>Verify the stream in the .asx file<br> 																			 
* What Verification it performs:	 								1.Verify that user is able to play the swf file successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 04/04/2011
* Updated by/on date: 												QASource on 04/04/2011
* 
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
* A domain having a valid storage should exist.
* Silver light should be disabled in the browser's Add-ons.
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v5_4.*;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;

public class SVP_VOD_SWF_SL_disabled extends TesterAsserter {
	
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
			utilityFunction=null;
		}

	}		
	public void test_SVP_VOD_SWF_SL_disabled() throws Exception {
		{
			try {
			setUp();
			Utility_Functions utilityFunction = new Utility_Functions();
			String str_path ="Global_variables.xml";
			String local_path ="SVP_VOD_SWF_SLDisabled.xml";
			String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
			
			//Variable for the domain name
			String VAR_DomSocial = utilityFunction.GetValue(str_path,"VAR_DomSocial");
			//Variable for the user name
			String VAR_USR = utilityFunction.GetValue(str_path ,"VAR_USR");
			//Variable for the Password
			String VAR_PWD = utilityFunction.GetValue(str_path ,"VAR_PWD");		
			//Variable for SWF full file name
			String VAR_SWFfile = utilityFunction.GetValue(local_path ,"VAR_fileType");
			//Variable for SWF file name
			String VAR_SWF_fileName = utilityFunction.GetValue(local_path ,"VAR_SWF_fileName");
			//Variable for framework path
			String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
			//Variable for VOD program name
			String str_ProgName= utilityFunction.GetValue(local_path, "Program_Name");
			//Variable for asx file 
			String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
			//Variable for viewer portal
			String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
			//Variable for storage host
			String VAR_AP_Host = utilityFunction.GetValue(str_path ,"VAR_AP_Host");
			//Variable for storage mount point
			String VAR_AP_MountPoint = utilityFunction.GetValue(str_path ,"VAR_AP_MountPoint");
			//Reusable action for Login to VCC
     		Login.test_login(selenium, VAR_USR, VAR_PWD, VAR_DomSocial);	
     	    
     		//Reusable action for SWF file upload
     		Upload_Media.Upload_streamingMedia(selenium, VAR_SWF_fileName, VAR_SWFfile);
     		utilityFunction.waitForChangesToReflect();
     		//Reusable action for Create VOD with SWF file
     		Create_Program.test_Create_vodProgram(selenium, str_ProgName, VAR_SWF_fileName);
			utilityFunction.waitForChangesToReflect();	
			//Variable for complete viewerportal URL
			String str_viewerportal_URL = Var_Columbia_vpURL + VAR_DomSocial + "/home.vp?debug=true";
			//Open the viewerportal URL
			selenium.open(str_viewerportal_URL); 
			selenium.waitForPageToLoad("120000");
			//Select the time zone if prompted for
		if (selenium.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
    		{
    			selenium.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
    			selenium.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
    			selenium.waitForPageToLoad(VAR_MED_WAIT);
    		} 
    		selenium.selectWindow("Qumu Program Browser Home");
			selenium.windowMaximize();
    		utilityFunction.waitForChangesToReflect();	
    		//selenium.waitForPageToLoad(VAR_MED_WAIT);
			  for (int second = 0;; second++) {
		           if (second >= 80000) fail("timeout");
		           try { if (selenium.isVisible(EnvObjectMap_Rep.LNK_AllVideos)) break; } catch (Exception e) {}
		           Thread.sleep(1000);
		       }
    		//click on All videos link
			selenium.click(EnvObjectMap_Rep.LNK_AllVideos);
			utilityFunction.waitForChangesToReflect();	
			selenium.type(EnvObjectMap_Rep.TBX_SearchSVP, utilityFunction.GetValue(local_path, "Program_Name"));
			utilityFunction.waitForChangesToReflect();
				
			//Set focus on the search textbox
        	selenium.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "t");
        	//select the icon to perform search
			selenium.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
			//Wait
			utilityFunction.waitForChangesToReflect();	
			//Click the vod file in search results
			//Click the vod file in search results
            for (int i = 1; i<50; i++){
			        String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
			    	System.out.println(str_var);	   
			    	if(str_var.equals(str_ProgName)){
			    		selenium.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
		               break;
		          }                  
		       }
			
			//Wait      
			utilityFunction.waitForChangesToReflect();
			utilityFunction.waitForChangesToReflect();
			//Capture the screenshot at the specified path
			String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + str_ProgName + ".jpg";		
			//Capture the screen shot of the live program
	        selenium.captureScreenshot(screenShot_locPath);  
	       	//Wait
	        utilityFunction.waitForChangesToReflect();
	        String contentlink = selenium.getText(Var_asxLink);
	        utilityFunction.waitForChangesToReflect();       
	     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
			contentlink_final=contentlink_final.trim();		
			System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
			selenium.click("link=exact:"+contentlink_final);
			utilityFunction.waitForChangesToReflect();
			
		    //Generate the asx file
			String htmlsource = selenium.getHtmlSource();
			System.out.println(htmlsource);	
			
			//To verify the asx file
			assertTrue("SVP_VOD_SWF_SL_disabled","Verify that asx file is generated successfully for a SVP containing .swf file with HTTP delivery option and SL disabled.",date,utilityFunction.assertTextContains(htmlsource, VAR_SWFfile));
			assertTrue("SVP_VOD_SWF_SL_disabled","Verify that http protocol is displayed in asx file for a SVP containing .swf file with HTTP delivery option and SL disabled.",date,utilityFunction.assertTextContains(htmlsource, "http://" + VAR_AP_Host + ":80/" + VAR_AP_MountPoint));
			utilityFunction=null;
		}catch(Exception e){
			e.printStackTrace();}
			 finally{
			selenium.close();
			selenium.stop();
		}
			
		}
	}
	}
