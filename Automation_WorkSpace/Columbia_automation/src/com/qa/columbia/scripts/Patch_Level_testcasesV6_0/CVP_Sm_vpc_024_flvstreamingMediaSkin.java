/*
* Class name                                                        wmvstreamingMedia 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP: Ensure that Build Version is displayed in build info<br>
* What the script does:											    >Login to the application<br> 
* 																	>Click on the programming link<br> 															
* 																	>Create VOD program<br>						
* 										                            >After creating the program search the program in programs page<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class CVP_Sm_vpc_024_flvstreamingMediaSkin extends TesterAsserter {
	
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
			
			selenium.setTimeout("0");
		}
		utilityFunction=null;
	}	
	public  void test_CVP_flvstreamingMedia() throws Exception
	{
		
try{
			
		    //Call to setUp function
		    setUp();
			
			Utility_Functions utilityFunction = new Utility_Functions(); 
			
			//Global variables file name
			String globalVariableFile ="Global_variables.xml";
			//Local Variable file name
			String localVariableFile="CVP_Sm_vpc_024_flvstreamingMediaSkin.xml";
			// Variable for Username
			String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
			
			// Variable for Password
			String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
			
			// Variable for Domain
			String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			
			//Variable for Waiting time
			String VAR_MED_WAIT=utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
			
			// Variable for program name
			String VAR_program=utilityFunction.GetValue(localVariableFile ,"VAR_programName");
			// Variable for program name
			String VAR_Skinname=utilityFunction.GetValue(localVariableFile ,"VAR_SkinName");
			
			// Variable for program name
			String VAR_StreamingMedia=utilityFunction.GetValue(localVariableFile ,"streamingMedia_DisplayName");

			String streamingMedia_FileName = utilityFunction.GetValue(localVariableFile, "VAR_fileType");
			
			//Call to Login function as a AdminProtal
			Login.adminPortalLogin(selenium, VAR_user, VAR_password, VAR_domain);
			
		    selenium.click(EnvObjectMap_Rep.Lnk_domains);
  		//wait for loading the page
   		     selenium.waitForPageToLoad(VAR_MED_WAIT);
    		//Click on the required domain
    		String VAR_domainLink = EnvObjectMap_Rep.lnk_editDomain + VAR_domain + "')]";
    		selenium.click(VAR_domainLink);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
     		//Check the Approval required checkbox
    		if (!selenium.isChecked(EnvObjectMap_Rep.chk_skin))
    		{
    			//check the "Require Program Approval checkbox
   			selenium.click(EnvObjectMap_Rep.chk_skin);
    		}
     		//Save the domain settings
    		selenium.click(EnvObjectMap_Rep.BTN_DomainSave);
    		//wait for loading the page
    		selenium.waitForPageToLoad(VAR_MED_WAIT);
			
    		//upload streaming Media
    		Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, streamingMedia_FileName);
    		
    		selenium.click(EnvObjectMap_Rep.Lnk_programming);
    		
    		selenium.click(EnvObjectMap_Rep.Lnk_programs);
    		 selenium.click(EnvObjectMap_Rep.Lnk_skins);
    		 selenium.waitForPageToLoad(VAR_MED_WAIT);
    		 selenium.click(EnvObjectMap_Rep.Btn_Add_skin);
    		 selenium.waitForPageToLoad(VAR_MED_WAIT);
    		 //utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_skinpage, 300);
    		 selenium.type(EnvObjectMap_Rep.Btn_skinname, VAR_Skinname);
    		 
    		 selenium.click(EnvObjectMap_Rep.Btn_skinsave);
    		
    		 selenium.waitForPageToLoad(VAR_MED_WAIT);
    		 
    		 //upload streaming Media
    		//Upload_Media.Upload_streamingMedia(selenium, VAR_StreamingMedia, streamingMedia_FileName);
    	
			selenium.click(EnvObjectMap_Rep.Lnk_programming);
			
			selenium.click(EnvObjectMap_Rep.Lnk_programs);
			
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			
			selenium.click(EnvObjectMap_Rep.Btn_Add_Program);
			
			//Select the On-demand Program
			selenium.addSelection(EnvObjectMap_Rep.SelectType_Program_Live, EnvObjectMap_Rep.lst_ondemand);
			selenium.click(EnvObjectMap_Rep.LNK_OnDemand);    	
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			//Provide the program name
			selenium.type(EnvObjectMap_Rep.txt_ProgramName, VAR_program);    	
	    	//Click on Next button
			selenium.click(EnvObjectMap_Rep.Btn_skinexternal);
			//selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.select(EnvObjectMap_Rep.Btn_skinselect,"label="+VAR_Skinname);
		
			
			selenium.click(EnvObjectMap_Rep.btn_Next_programPage);	
			selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	if(!selenium.isElementPresent(EnvObjectMap_Rep.radio_Immediately))
			{
	    		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
	    		selenium.waitForPageToLoad(VAR_MED_WAIT);
			}
	    	//Select the listing as Immediately
	    	selenium.click(EnvObjectMap_Rep.radio_Immediately);
	    	//Click on Next button
	    	selenium.click(EnvObjectMap_Rep.btn_Next_programPage);    	
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);    	
	    	//Click on Add Media button
	    	selenium.click(EnvObjectMap_Rep.btn_selectMedia);    	
	    	utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.lbl_browseMedia, 300);    	
	    	selenium.focus(EnvObjectMap_Rep.lbl_browseMedia);    	
	    	//Navigate to Search tab
	    	selenium.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
	    	//Set focus on the search textbox
	    	selenium.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
	    	
	    	//Type the streaming media name
	    	selenium.type(EnvObjectMap_Rep.txt_SearchMedia, VAR_StreamingMedia);
	    	//Click on Find button
	    	selenium.click(EnvObjectMap_Rep.btn_mediaSearch);
	    	
	    	utilityFunction.waitForChangesToReflect();
	    	//Select the searched media
	    	selenium.click(EnvObjectMap_Rep.Lnk_selectMedia);
	    	//Move the selected file to selected List box
	    	selenium.click(EnvObjectMap_Rep.lnk_moveToSelected);
	    	//Click on Save button
	    	selenium.click(EnvObjectMap_Rep.btn_saveSelectedMedia);
	    	
	    	//wait for page to load
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	//Click on Next button
	    	selenium.click(EnvObjectMap_Rep.btn_Next_programPage);
	    	
	    	selenium.waitForPageToLoad(VAR_MED_WAIT);
	     	if (selenium.isElementPresent(EnvObjectMap_Rep.radio_audience))
	    	{
	    		//Select the delivery option radiobox
	     		selenium.click(EnvObjectMap_Rep.Btn_Next_Delivery_Select);
	     		selenium.waitForPageToLoad(VAR_MED_WAIT);
	    	}     	
	     	//Click next button on Content Delivery option
	     	selenium.click(EnvObjectMap_Rep.Btn_Next_Delivery);    	
	    	//wait for loading the page
	     	selenium.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Summary button on Program Assignment page
	     	selenium.click(EnvObjectMap_Rep.Btn_Summary);
	    	//wait for loading the page
	     	selenium.waitForPageToLoad(VAR_MED_WAIT);	
	    	//Click Finish button on program Summary page
	     	selenium.click(EnvObjectMap_Rep.Btn_Finish_Program);
	    	//wait for page to load
	    	utilityFunction.waitForChangesToReflect();	
			
		
			//search by program name
			selenium.type(EnvObjectMap_Rep.lnk_VODProgramsearch, VAR_program);
			
			selenium.click(EnvObjectMap_Rep.Btn_programsearch);
			
			selenium.waitForPageToLoad(VAR_MED_WAIT);
			selenium.click(EnvObjectMap_Rep.Lnk_contextMenu);
			
			selenium.click(EnvObjectMap_Rep.Lnk_programproperties);
			Thread.sleep(9000);
			//utilityFunction.waitForChangesToReflect();
			selenium.click(EnvObjectMap_Rep.img_externalskin);
	    
	    	 utilityFunction.waitForChangesToReflect();		 
	    	//selenium.selectWindow(VAR_program);
	    	
     
        String htmlsource = selenium.getHtmlSource();
        
	   		assertTrue("Sm_vpc_024","Verify that vod FLV streaming media program is playing having skin.",date,utilityFunction.assertTextContains(htmlsource,VAR_program ));
			//Ensure that program is successfully created and visible in programs page
	   	 
		   //selenium.close();
			utilityFunction=null;		
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
	selenium.close();
	selenium.stop();
}

	}

}
