/*
 * This method is used to upload various types of content. 
*/
package com.qa.columbia.functions.v6_0;

//import com.qa.columbia.executor.TesterAsserter;

import java.util.Calendar;
import java.util.Date;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.*;

public class Upload_Media extends TesterAsserter
{

	//Reusable action to upload streaming media
	
	public static void Upload_streamingMedia(Selenium sel,String mediaDisplayName, String mediaFileName) throws Exception	
	{	
		String str_path ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		sel.click(EnvObjectMap_Rep.Lnk_content);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addItem, 300);
		String streamingMedia = Var_frameWork_Path+"\\commonfiles\\"+mediaFileName;
		sel.click(EnvObjectMap_Rep.Btn_addItem);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_streamingMedia, 300);
		sel.click(EnvObjectMap_Rep.Radio_streamingMedia);
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.FileUpld_selectedFile, 300);
		sel.focus(EnvObjectMap_Rep.FileUpld_selectedFile);
		String abc = streamingMedia.toUpperCase();
		utilityFunction.keyEvent(sel, abc);
		sel.type(EnvObjectMap_Rep.FileUpld_selectedFile, "t");
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, mediaDisplayName);
		if(sel.isElementPresent(EnvObjectMap_Rep.Txt_width))
		{
			sel.type(EnvObjectMap_Rep.Txt_width, "5");	
		}
		
		if(sel.isElementPresent(EnvObjectMap_Rep.Txt_height))
		{
			sel.type(EnvObjectMap_Rep.Txt_height, "5");	
		}
		if(sel.isElementPresent(EnvObjectMap_Rep.Txt_duration))
		{
			sel.type(EnvObjectMap_Rep.Txt_duration, "00:05:00");	
		}
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);
		Thread.sleep(5000);
	
	}
	
	   //Upload external streaming media
		public static void Upload_externalStreamingMedia(Selenium sel,String str_esmName, String str_esmURL) throws Exception       {           //Object of Utility_Function class
		       Utility_Functions utilityFunction = new Utility_Functions();
		       sel.click(EnvObjectMap_Rep.Lnk_content);
		       utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_advSearch, 300);
		       sel.click("addI");
		       sel.click(EnvObjectMap_Rep.Btn_addItem);
		       utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_extStreamingMedia, 300);
		       sel.click(EnvObjectMap_Rep.Radio_extStreamingMedia);
		       sel.click(EnvObjectMap_Rep.Btn_next);
		       utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		       sel.type(EnvObjectMap_Rep.Txt_displayName, str_esmName);
		       sel.type(EnvObjectMap_Rep.Txt_externalURL, str_esmURL);
		       sel.select(EnvObjectMap_Rep.Drp_externalMediaFormatType, "label=Windows Media");
		       sel.type(EnvObjectMap_Rep.Txt_duration, "5:00:00");
		       sel.click(EnvObjectMap_Rep.Btn_Finish);
		       utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);
		   }
	
	public static void Upload_slides(Selenium sel,String slideDisplayName, String slideFileName) throws Exception	
	{
		String str_path ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		sel.click(EnvObjectMap_Rep.Lnk_content);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addItem, 300);
		String streamingMedia = Var_frameWork_Path+"\\commonfiles\\"+slideFileName;
		sel.click(EnvObjectMap_Rep.Btn_addItem);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_slide, 300);
		sel.click(EnvObjectMap_Rep.Radio_slide);
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.FileUpld_selectedFile, 300);
		sel.focus(EnvObjectMap_Rep.FileUpld_selectedFile);
		String abc = streamingMedia.toUpperCase();
		utilityFunction.keyEvent(sel, abc);
		sel.type(EnvObjectMap_Rep.FileUpld_selectedFile, "t");
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, slideDisplayName);
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);		
	}
	public static void Upload_pollorsurvey(Selenium sel,String pollDisplayName, String questionName, String questionExplanation) throws Exception	
	{
		Utility_Functions utilityFunction = new Utility_Functions();
		sel.click(EnvObjectMap_Rep.Lnk_content);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addItem, 300);
		sel.click(EnvObjectMap_Rep.Btn_addItem);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_poll, 300);
		sel.click(EnvObjectMap_Rep.Radio_poll);
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, pollDisplayName);
		sel.click(EnvObjectMap_Rep.Btn_addQuestion);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, questionName);
		sel.type(EnvObjectMap_Rep.Txt_questionTitle, questionExplanation);
		sel.select(EnvObjectMap_Rep.Drp_questionType, EnvObjectMap_Rep.Drp_questionType_checkbox);
		sel.type(EnvObjectMap_Rep.Txt_answerValue1, "1");
		sel.type(EnvObjectMap_Rep.Txt_answerValue2, "2");
		sel.type(EnvObjectMap_Rep.Txt_answerValue3, "3");
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addQuestion, 300);
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);	
	}
	
	public static void Upload_EGCprogramSVP(Selenium sel, String str_EGCprogramName, String str_streamingMediaFile,String str_EGCchannelname) throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
        Date date=Calendar.getInstance().getTime();
     	
        String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	  //  String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT") ;
	   // String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT") ;
	    
		//sel.waitForPageToLoad(VAR_MAX_WAIT);
		sel.click(EnvObjectMap_Rep.lnk_AddProgram_SVP);
		//sel.waitForPageToLoad(VAR_MED_WAIT);		
		
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.fileUPl_egcStreamingMediaSVP,500);
		//upload a wmv file 
		sel.focus(EnvObjectMap_Rep.fileUPl_egcStreamingMediaSVP);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload = Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_streamingMediaFile;
	    String []cmd = {auto_it_contentUpload, filePath};
		Runtime.getRuntime().exec(cmd);	
		utilityFunction.waitForChangesToReflect();
		if (sel.isElementPresent(EnvObjectMap_Rep.drp_egcchannel)){
			sel.select(EnvObjectMap_Rep.drp_egcchannel, "label="+str_EGCchannelname);
		}
		//sel.select("channel", "label="+str_EGCchannelname);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lnk_egc_rename, 500);
		sel.type(EnvObjectMap_Rep.txt_egcProgramNameSVP, str_EGCprogramName);
		sel.typeKeys(EnvObjectMap_Rep.txt_egcProgramNameSVP, "A");
				
		if(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramSVP))
		{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramSVP));
			//Variable to click the Submit button.
			sel.click(EnvObjectMap_Rep.btn_egcSubmitprogramSVP);
		}
		else
			{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSaveprogramSVP));
			//Variable to click the Submit button if Save button is present.
				sel.click(EnvObjectMap_Rep.btn_egcSaveprogramSVP);
			}
		
		//boolean flag_program_created=false;
		
		//utilityFunction.waitForElementToPresent(sel, str_EGCprogramName, 600);
	
		/*for (int second = 0;; second++) {
			if (second >= 600) fail("timeout");
			try { if (sel.isTextPresent(str_EGCprogramName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}*/
			 utilityFunction.waitForChangesToReflect();
	
		//assertTrue("Upload_EGCprogramSVP","Social VP: EGC program has been created successfully.",date,sel.isTextPresent(str_EGCprogramName));
    
	}
	
	public static void Upload_complexPresentation(Selenium sel,String complexpresentationDisplayName, String complexpresentationFileName) throws Exception	
	{
		String str_path ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		sel.click(EnvObjectMap_Rep.Lnk_content);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addItem, 300);
		String streamingMedia = Var_frameWork_Path+"\\commonfiles\\"+complexpresentationFileName;
		sel.click(EnvObjectMap_Rep.Btn_addItem);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_complexPresentation, 300);
		sel.click(EnvObjectMap_Rep.Radio_complexPresentation);
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.FileUpld_selectedFile, 300);
		sel.focus(EnvObjectMap_Rep.FileUpld_selectedFile);
		String abc = streamingMedia.toUpperCase();
		utilityFunction.keyEvent(sel, abc);
		sel.type(EnvObjectMap_Rep.FileUpld_selectedFile, "t");
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, complexpresentationDisplayName);
		sel.select(EnvObjectMap_Rep.Drp_videoSize, EnvObjectMap_Rep.Drp_videoSizeValue);
		sel.type(EnvObjectMap_Rep.Txt_duration, "05:00:00");
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);	
	}
	
	
	public static void Upload_image(Selenium sel,String imgDisplayName, String imgFileName) throws Exception	
	{
		String str_path ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		sel.click(EnvObjectMap_Rep.Lnk_content);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addItem, 300);
		String streamingMedia = Var_frameWork_Path+"\\commonfiles\\"+imgFileName;
		sel.click(EnvObjectMap_Rep.Btn_addItem);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Radio_image, 300);
		sel.click(EnvObjectMap_Rep.Radio_image);
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.FileUpld_selectedFile, 300);
		sel.focus(EnvObjectMap_Rep.FileUpld_selectedFile);
		String abc = streamingMedia.toUpperCase();
		utilityFunction.keyEvent(sel, abc);
		sel.type(EnvObjectMap_Rep.FileUpld_selectedFile, "t");
		sel.click(EnvObjectMap_Rep.Btn_next);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName, 300);
		sel.type(EnvObjectMap_Rep.Txt_displayName, imgDisplayName);
		sel.click(EnvObjectMap_Rep.Btn_Finish);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Txt_duration, 300);	
	}
	
	public static void Upload_EGCprogramCVP(Selenium sel, String str_EGCprogramName, String str_streamingMediaFile,String str_EGCchannelname)throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
        Date date=Calendar.getInstance().getTime();
     	
        String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	  //  String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT") ;
	    String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT") ;
	    
	  //Variable for the domain name
		String VAR_DomClassic = utilityFunction.GetValue(str_path,"Var_DomainClassic");
		
		//Variable for the domain name
		String VAR_InstanceIP = utilityFunction.GetValue(str_path,"VAR_InstanceIP");
		
      sel.open("http://"+VAR_InstanceIP+"/viewerportal/"+VAR_DomClassic+"/editVideo.do");
		//sel.click(EnvObjectMap_Rep.lnk_AddVideo_CVP);
	 
		
		utilityFunction.waitForElementToPresent(sel, EnvObjectMap_Rep.fileUPl_egcStreamingMediaCVP,500);
		//upload a wmv file 
		Thread.sleep(3000);
		sel.focus(EnvObjectMap_Rep.fileUPl_egcStreamingMediaCVP);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload = Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_streamingMediaFile;
	    String []cmd = {auto_it_contentUpload, filePath};
		Runtime.getRuntime().exec(cmd);	
		utilityFunction.waitForChangesToReflect();
		if (sel.isElementPresent(EnvObjectMap_Rep.drp_egcchannel)){
			sel.select(EnvObjectMap_Rep.drp_egcchannel, "label="+str_EGCchannelname);
		}
		//sel.select("channel", "label="+str_EGCchannelname);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.lnk_egc_rename, 500);
		sel.type(EnvObjectMap_Rep.txt_egcProgramNameCVP, str_EGCprogramName);
		sel.typeKeys(EnvObjectMap_Rep.txt_egcProgramNameCVP, "A");
				
		if(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramCVP))
		{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramCVP));
			//Variable to click the Submit button.
			sel.click(EnvObjectMap_Rep.btn_egcSubmitprogramCVP);
		}
		else
			{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSaveprogramCVP));
			//Variable to click the Submit button if Save button is present.
				sel.click(EnvObjectMap_Rep.btn_egcSaveprogramCVP);
			}

		for (int second = 0;; second++) {
			if (second >= 500) fail("timeout");
			try { if (sel.isAlertPresent()) break; } catch (Exception e) {}
			Thread.sleep(1000);
		
			if (sel.isAlertPresent())
		{
			 sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
			  sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		}

		
		//boolean flag_program_created=false;
		
		//utilityFunction.waitForElementToPresent(sel, str_EGCprogramName, 600);
	
		/*for (int second = 0;; second++) {
			if (second >= 600) fail("timeout");
			try { if (sel.isTextPresent(str_EGCprogramName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}*/
			
	
		//assertTrue("Upload_EGCprogramSVP","Social VP: EGC program has been created successfully.",date,sel.isTextPresent(str_EGCprogramName));
    
	}
	
	
	}
}
	
	
	
	
	

