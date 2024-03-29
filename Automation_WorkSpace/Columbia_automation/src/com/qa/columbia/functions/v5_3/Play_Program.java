package com.qa.columbia.functions.v5_3;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.repository.v5_3.EnvObjectMap_Rep;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class Play_Program extends TesterAsserter
{
public static void Play_Live_Program (Selenium sel, String str_DomainID ) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		Date date=Calendar.getInstance().getTime();
		//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_Host = utilityFunction.GetValue(str_path ,"VAR_Host");
		
		//String VAR_BROWSER = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_BROWSER_PATH = "*iexplore";
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
		
		//Variable to hold the viewer portal URL
	    String viewerportal_URL = Var_Columbia_vpURL + str_DomainID + "/home.vp?debug=true";
		//Selenium object
	    sel = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, viewerportal_URL);
	    
	    //Start the selenium
		sel.start();
		
		//open the Viewer Portal		
	    sel.open(viewerportal_URL);	
	    
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		//for Maximize the window
		sel.windowMaximize();
		
		//Verify that select Timezone option is displayed		
		if (sel.isElementPresent(EnvObjectMap_Rep.Btn_Select_Timezone)){
			//Click Select button 
			sel.click(EnvObjectMap_Rep.Btn_Select_Timezone);
			//Wait for loading the page
			sel.waitForPageToLoad(VAR_MAX_WAIT);	
		}
		//wait
		utilityFunction.waitForChangesToReflect();
		if (VAR_BROWSER_PATH=="*iexplore"){
			//Wait
			utilityFunction.waitForChangesToReflect();
			String auto_it_liveProgram = Var_frameWork_Path + "\\commonfiles\\clickLiveNow_ie.exe";
			//Click program under Live Now tab
			Runtime.getRuntime().exec(auto_it_liveProgram);
		}
		if (VAR_BROWSER_PATH == "*firefox"){
			utilityFunction.waitForChangesToReflect();
			String auto_it_liveProgram = Var_frameWork_Path + "\\commonfiles\\clickLiveNow_ff.exe";
			//Click program under Live Now tab
			Runtime.getRuntime().exec(auto_it_liveProgram);
		}		
		
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
		
	    //Capture the screenshot at the specified path
		String screenShot_locPath =Var_frameWork_Path + "\\commonfiles\\Live_Program.jpg";
		
		//Capture the screen shot of the live program
        sel.captureScreenshot(screenShot_locPath);
        
        //Wait
        utilityFunction.waitForChangesToReflect();
        String contentlink = sel.getText(Var_asxLink);
        utilityFunction.waitForChangesToReflect();       
     	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
		contentlink_final=contentlink_final.trim();		
		System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
		sel.click("link=exact:"+contentlink_final);
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
	    //Generate the asx file
		String htmlsource = sel.getHtmlSource();
		System.out.println(htmlsource);	
		
		//To verify the asx file
		utilityFunction.assertTextContains(htmlsource, "mms");
		utilityFunction.assertTextContains(htmlsource, "WMEProfile");
		utilityFunction.assertTextContains(htmlsource, "http://" + VAR_Host +"/WMSControl/qumu_");   
		assertTrue("Columbia_LiveProgramVerification","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, "WMEProfile"));
		assertTrue("Columbia_LiveProgramVerification","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms"));
		assertTrue("Columbia_LiveProgramVerification","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "http://10.1.202.247/WMSControl/qumu_"));
		sel.selectWindow(null);
		sel.close();
	}
public static void test_Play_vodCVP (Selenium sel, String str_DomainID, String str_ProgName, String str_videoName) throws Exception {
	Utility_Functions utilityFunction = new Utility_Functions();
	String str_path ="Global_variables.xml";
	String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
	String CVP_url = Var_Columbia_vpURL + str_DomainID + "/home.do";
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	sel.open(CVP_url);
	sel.waitForPageToLoad(VAR_MED_WAIT);
	if (sel.isElementPresent(EnvObjectMap_Rep.drp_selectTimeZoneCVP))
	{
		sel.select(EnvObjectMap_Rep.drp_selectTimeZoneCVP, EnvObjectMap_Rep.drp_selectTimeZone_valueCVP);
	//	sel.waitForPageToLoad(VAR_MED_WAIT);
		sel.click(EnvObjectMap_Rep.btn_selectTimeZoneCVP);
		sel.waitForPageToLoad(VAR_MED_WAIT);			
	}
	sel.type(EnvObjectMap_Rep.txt_SearchCVP, str_ProgName);
	sel.click(EnvObjectMap_Rep.btn_SearchCVP);
	sel.waitForPageToLoad(VAR_MED_WAIT);
	sel.click(EnvObjectMap_Rep.lnk_ProgramNameCVP + str_ProgName);
	sel.waitForPageToLoad(VAR_MED_WAIT);
	//Click on the 
	sel.click(EnvObjectMap_Rep.lnk_videoProgramCVP + str_videoName);
	//wait
/*	utilityFunction.waitForChangesToReflect();
	utilityFunction.waitForChangesToReflect();	
	utilityFunction.waitForChangesToReflect();*/
	utilityFunction.waitForChangesToReflect();	
    //Capture the screenshot at the specified path
	String screenShot_locPath = Var_frameWork_Path + "\\commonfiles\\" + str_ProgName + ".jpg";		
	//Capture the screen shot of the program
    sel.captureScreenshot(screenShot_locPath);      
}
public static void test_PlayLiveProgram (Selenium sel, String str_DomainID ) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	Date date=Calendar.getInstance().getTime();
	//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	String Var_Columbia_vpURL = utilityFunction.GetValue(str_path ,"Var_Columbia_vpURL");
	String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
	String VAR_Host = utilityFunction.GetValue(str_path ,"VAR_Host");
	
	//String VAR_BROWSER = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
	String VAR_BROWSER_PATH = "*iexplore";
	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	String Var_asxLink = utilityFunction.GetValue(str_path ,"Var_asxLink");
	
	//Variable to hold the viewer portal URL
    String viewerportal_URL = Var_Columbia_vpURL + str_DomainID + "/home.vp?debug=true";
	//Selenium object
    sel = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, viewerportal_URL);
    
    //Start the selenium
	sel.start();
	
	//open the Viewer Portal		
    sel.open(viewerportal_URL);	
    
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	
	//for Maximize the window
	sel.windowMaximize();
	
	//Verify that select Timezone option is displayed		
	if (sel.isElementPresent(EnvObjectMap_Rep.Btn_Select_Timezone)){
		//Click Select button 
		sel.click(EnvObjectMap_Rep.Btn_Select_Timezone);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);	
	}
	//wait
	utilityFunction.waitForChangesToReflect();
	if (VAR_BROWSER_PATH=="*iexplore"){
		//Wait
		utilityFunction.waitForChangesToReflect();
		String auto_it_liveProgram = Var_frameWork_Path + "\\commonfiles\\clickLiveNow_ie.exe";
		//Click program under Live Now tab
		Runtime.getRuntime().exec(auto_it_liveProgram);
	}
	if (VAR_BROWSER_PATH == "*firefox"){
		utilityFunction.waitForChangesToReflect();
		String auto_it_liveProgram = Var_frameWork_Path + "\\commonfiles\\clickLiveNow_ff.exe";
		//Click program under Live Now tab
		Runtime.getRuntime().exec(auto_it_liveProgram);
	}		
	
	utilityFunction.waitForChangesToReflect();
	utilityFunction.waitForChangesToReflect();
	
    //Capture the screenshot at the specified path
	String screenShot_locPath =Var_frameWork_Path + "\\commonfiles\\Live_Program.jpg";
	
	//Capture the screen shot of the live program
    sel.captureScreenshot(screenShot_locPath);
    
    //Wait
    utilityFunction.waitForChangesToReflect();
    String contentlink = sel.getText(Var_asxLink);
    utilityFunction.waitForChangesToReflect();       
 	String contentlink_final= StringUtils.substringAfter(contentlink, "Loading content from"); 
	contentlink_final=contentlink_final.trim();		
	System.out.println("exact:"+contentlink_final+"&playerType=silverlightembed");		
	sel.click("link=exact:"+contentlink_final);
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	
    //Generate the asx file
	String htmlsource = sel.getHtmlSource();
	System.out.println(htmlsource);	
	
	//To verify the asx file
	utilityFunction.assertTextContains(htmlsource, "mms");
	utilityFunction.assertTextContains(htmlsource, "WMEProfile");
	utilityFunction.assertTextContains(htmlsource, "http://" + VAR_Host +"/WMSControl/qumu_");   
	assertTrue("Columbia_LiveProgramVerification","Verify that asx file is generated successfully.",date,utilityFunction.assertTextContains(htmlsource, "WMEProfile"));
	assertTrue("Columbia_LiveProgramVerification","Verify that mms protocol is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "mms"));
	assertTrue("Columbia_LiveProgramVerification","Verify that multicast stream is displayed in asx file.",date,utilityFunction.assertTextContains(htmlsource, "http://10.1.202.247/WMSControl/qumu_"));
	sel.selectWindow(null);
	sel.close();
}


}
