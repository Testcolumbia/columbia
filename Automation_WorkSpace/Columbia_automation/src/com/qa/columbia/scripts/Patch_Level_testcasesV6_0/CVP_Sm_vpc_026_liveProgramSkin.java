
/*
* Class name                                                        CVP_Play_LiveProgramkin 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Classic VP:Play Live Program from Classic VP<br>
* What the script does:											    >Login to the application<br> 
*                                                                   >Create skin
*                                                                   >Create Encoders for the Live program													
* 																	>Create Live program with Skin<br>						
* 										                            >Launch classic viewer portal and assert the ASX file for lIve program<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;



import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;

public class CVP_Sm_vpc_026_liveProgramSkin extends TesterAsserter {
	
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
	public  void test_CVP_Play_LiveProgramskin()throws Exception {
		try{
		setUp();
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Global variables file name
		String globalVariableFile ="Global_variables.xml";		
		//Local Variable file name
		String localVariableFile="CVP_Sm_vpc_026_liveProgramSkin.xml";	
		
		//Setup script variables file name
		String local_path ="Setup_Script.xml";
		// Variable for Username
		String VAR_user=utilityFunction.GetValue(globalVariableFile ,"VAR_USR");		
		// Variable for Password
		String VAR_password=utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");		
		// Variable for login Domain
		String VAR_domain=utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
		String Var_ProgramName = utilityFunction.GetValue(localVariableFile, "LiveProgramName");
		
		
		String Var_VEasWMS_DO = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
		
		String Var_Endpoint= utilityFunction.GetValue(globalVariableFile,"VAR_endPointIP");
		
		//variable for instance IP used for viewer portal
		String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_VCCInstanceIP");			
		//framework path will user for screen shot saving
		String Var_frameWork_Path = utilityFunction.GetValue(globalVariableFile ,"Var_frameWork_Path");		
		
		//Variable for the Encoder Name
		 String VAR_WMEEncodername = utilityFunction.GetValue(local_path ,"VAR_WMEName");
		//Variable for the saved encoder profile file name (with path)
		String VAR_WMEEncoderProfileName= utilityFunction.GetValue(local_path ,"Var_WMEProName");
		//Call to reusable function for a admin portal
		
		
	
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		
		String VAR_Skinname=utilityFunction.GetValue(localVariableFile ,"VAR_SkinName");
		//Call to reusable function for a admin portal
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
	
		
		selenium.click(EnvObjectMap_Rep.Lnk_programming);
		selenium.click(EnvObjectMap_Rep.Lnk_programs);
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		selenium.click(EnvObjectMap_Rep.Btn_Add_Program);
		selenium.addSelection(EnvObjectMap_Rep.Select_programType, EnvObjectMap_Rep.Select_programType_Live);
		selenium.click(EnvObjectMap_Rep.LivePrgram);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Txt_liveProgramName, 300);
		selenium.type(EnvObjectMap_Rep.Txt_liveProgramName, Var_ProgramName);
		  	
    	//Click on Next button
		selenium.click(EnvObjectMap_Rep.Btn_skinexternal);
		//selenium.waitForPageToLoad(VAR_MED_WAIT);
		selenium.select(EnvObjectMap_Rep.Btn_skinselect,"label="+VAR_Skinname);
		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		selenium.waitForPageToLoad("90000");
		if(!selenium.isElementPresent(EnvObjectMap_Rep.Lnk_addEncoder))
		{
			selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		}
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Lnk_addEncoder, 300);
		selenium.click(EnvObjectMap_Rep.Lnk_deleteUpcomintOccurrences);
		selenium.click(EnvObjectMap_Rep.Radio_listingImmedtiately);
		selenium.click(EnvObjectMap_Rep.Lnk_addEncoder);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Lst_selectEncoder, 300);
		selenium.select(EnvObjectMap_Rep.Lst_selectEncoder, "label="+VAR_WMEEncodername);
		selenium.click(EnvObjectMap_Rep.Lst_selectEncoder_click);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Lst_selectEncoderProfile, 300);
		selenium.select(EnvObjectMap_Rep.Lst_selectEncoderProfile, "label="+VAR_WMEEncoderProfileName);
		selenium.click(EnvObjectMap_Rep.Lst_selectEncoderProfile_click);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_encoderProfile, 300);
		selenium.click(EnvObjectMap_Rep.Btn_encoderProfile);
		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		if(selenium.isElementPresent(EnvObjectMap_Rep.Txt_endPointIP))
		{
			selenium.type(EnvObjectMap_Rep.Txt_endPointIP, Var_Endpoint);
			selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
			selenium.waitForPageToLoad(VAR_MED_WAIT);
		}
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Chk_allowQuestionBeforeBroadacst, 300);	
		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		if(selenium.isElementPresent(EnvObjectMap_Rep.Radio_audience))
		{
			selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		selenium.waitForPageToLoad(VAR_MED_WAIT);
		}	
		for (int i = 2; i<50; i=i+1){
		    	String str_var=selenium.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_deliveryOptionText, i));   
		    	if (str_var.equals(Var_VEasWMS_DO)){
		    		selenium.click(MessageFormat.format(EnvObjectMap_Rep.Radio_deliveryOptionText, i));
	            break;
	       }                  
	    }
		selenium.click(EnvObjectMap_Rep.Btn_Next_liveProgram);
		selenium.waitForPageToLoad("90000");
		selenium.click(EnvObjectMap_Rep.Btn_Summary_liveProgram);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Btn_finish_liveProgram, 300);
		selenium.click(EnvObjectMap_Rep.Btn_finish_liveProgram);
		utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.Drp_Filter_Programs, 300);
		
		//----------------------------------------------------------------------------------------------------
		
		Launch_LBC.StartBroadcast(selenium, Var_ProgramName);
        Launch_VP.Launch_CVP(selenium, VAR_domain);
		 
		 selenium.selectWindow("Qumu Program Browser Home");
		 utilityFunction.waitForElementToVisible(selenium, EnvObjectMap_Rep.LNK_home, 300);
			
		 
		  selenium.click(EnvObjectMap_Rep.LNK_program);
		  Thread.sleep(2000);
		  
		  selenium.type(EnvObjectMap_Rep.TBX_SearchCVP, Var_ProgramName);
		 selenium.click(EnvObjectMap_Rep.Btn_SearchCVP);
		 
		utilityFunction.waitForChangesToReflect();	
		
	
	selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+Var_ProgramName);
	Thread.sleep(20000);
	selenium.click(EnvObjectMap_Rep.LNK_Searchresultvideo+VAR_WMEEncoderProfileName);
	
	utilityFunction.waitForChangesToReflect();	
    //Capture the screenshot at the specified path
	String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + Var_ProgramName + ".jpg";		
	//Capture the screen shot of the program
    selenium.captureScreenshot(screenShot_locPath);   		
    selenium.selectWindow("Qumu Program Player");
	//Maximize the window
	selenium.windowMaximize();
	//Get the html source
	String htmlsource = selenium.getHtmlSource();
	int start_URL = htmlsource.indexOf("http://"+VAR_InstanceIP);
	int end_URL = htmlsource.lastIndexOf("\";");	    
	String stream_URL1 = htmlsource.substring(start_URL, end_URL);
	int stream_URL_length = stream_URL1.length();
	String stream_URL = stream_URL1.substring(0, stream_URL_length);
	System.out.println(stream_URL);	
	//Open the stream URL in the browser
	selenium.open(stream_URL + "&debug=true");
	selenium.waitForPageToLoad("90000");		
	//get the html source code
	String htmlsource1 = selenium.getHtmlSource();		
	//Ensure that source content file is displayed in source
	assertTrue("Sm_vpc_026_liveProgramSkin","Verify that asx file for live program is generated successfully for classic view portal having skin",date,utilityFunction.assertTextContains(htmlsource1, VAR_WMEEncoderProfileName));
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
				 selenium.close();
				 selenium.stop();
			}
		}					 
	}

