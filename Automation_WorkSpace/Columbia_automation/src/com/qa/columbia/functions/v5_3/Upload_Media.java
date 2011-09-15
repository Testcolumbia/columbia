/*
 * This method is used to Upload the Content in resourceBin. 
 * 
*/

package com.qa.columbia.functions.v5_3;

import com.qa.columbia.repository.v5_3.*;

import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Upload_Media extends TesterAsserter
{
	//Reusable action to upload image
	public static void Upload_img(Selenium sel,String str_imgName) throws Exception	{	
        
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		//String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_BROWSER_PATH = "*iexplore";
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		//String VAR_Upload_Content = utilityFunction.GetValue(str_path ,"VAR_Upload_Content");
				//Open the programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Select the Content link
		sel.click(EnvObjectMap_Rep.LNK_Content);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);	 
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible("addI")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		//Click Add Item button
		sel.click(EnvObjectMap_Rep.Btn_AddItem);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.btn_Img)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Select Slides radio button
		sel.click(EnvObjectMap_Rep.btn_Img);
		//Click next button
		sel.click(EnvObjectMap_Rep.Btn_Next);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Upload_Next)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		if (VAR_BROWSER_PATH=="*iexplore"){			
			//Wait for loading the page
		  //  utilityFunction.waitForChangesToReflect();
		    //Bring the focus on File upload field 
			sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
			//press tab
			sel.keyPressNative("9");
			//Press tab 
			sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
			//Wait for loading the page
			//utilityFunction.waitForChangesToReflect();
			//Path of the autoit file to upload file
			String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
			
			String filePath = Var_frameWork_Path + "\\commonfiles\\img1.jpg";;
			
			String []cmd = {auto_it_contentUpload, filePath};
			
			Runtime.getRuntime().exec(cmd);
		}
	
		//Click next button to upload the slides
		sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 600) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.TXT_Display_Name)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Provide the slide name
		sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_imgName);
		//Click Finish button
		sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
		//wait for loading the page
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
//		utilityFunction.waitForChangesToReflect();
	}
	//Reusable action to upload complex presentation
	public static void Upload_complexPresentation(Selenium sel,String str_presentationName,String streamingMediaType, String mediaDuration) throws Exception	{	
	    
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		//String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_BROWSER_PATH = "*iexplore";
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		//String VAR_Upload_Content = utilityFunction.GetValue(str_path ,"VAR_Upload_Content");
		//String VAR_complexPresentation_duration = utilityFunction.GetValue(str_path, "VAR_complexPresentation_duration");
		//Open the programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Select the Content link
		sel.click(EnvObjectMap_Rep.LNK_Content);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);	 
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible("addI")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		//Click Add Item button
		sel.click(EnvObjectMap_Rep.Btn_AddItem);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.btn_ComplexPresenation)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Select Slides radio button
		sel.click(EnvObjectMap_Rep.btn_ComplexPresenation);
		//Click next button
		sel.click(EnvObjectMap_Rep.Btn_Next);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Upload_Next)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		if (VAR_BROWSER_PATH=="*iexplore"){			
			//Wait for loading the page
		    //utilityFunction.waitForChangesToReflect();
		    //Bring the focus on File upload field 
			sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
			//press tab
			sel.keyPressNative("9");
			//Press tab 
			sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
			//Wait for loading the page
			//utilityFunction.waitForChangesToReflect();
			//Path of the autoit file to upload file
			String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
			
			String filePath = Var_frameWork_Path + "\\commonfiles\\" + streamingMediaType;
			
			String []cmd = {auto_it_contentUpload, filePath};
			
			Runtime.getRuntime().exec(cmd);
		}
			
		//Click next button to upload the slides
		sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
		//Wait for loading the page
		for (int second = 0;; second++) {
			if (second >= 600) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.TXT_Display_Name)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//Provide the slide name
		sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_presentationName);
		
		sel.type(EnvObjectMap_Rep.txt_Duration,mediaDuration);
		sel.select(EnvObjectMap_Rep.drp_VideoSize, EnvObjectMap_Rep.drp_VideoSize_val);
		//Click Finish button
		sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
		//wait for loading the page
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
	}
	//Reusable action to upload slides
	public static void Upload_Slides(Selenium sel,String str_SlideName, String str_Upload_Content) throws Exception	{	
    
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	//String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
	String VAR_BROWSER_PATH = "*iexplore";
	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	//String VAR_Upload_Content = utilityFunction.GetValue(str_path ,"VAR_Upload_Content");
		
	//Open the programming menu
	sel.click(EnvObjectMap_Rep.LNK_Programming);
	//Select the Content link
	sel.click(EnvObjectMap_Rep.LNK_Content);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);
	//sel.waitForPageToLoad(VAR_MAX_WAIT);	 
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.BTN_More_Search)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	sel.click(EnvObjectMap_Rep.BTN_More_Search);
	//Provide the Slide name to search
	sel.type(EnvObjectMap_Rep.TXT_Search_Name,str_SlideName);
	sel.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
	//Click Search button
	sel.click(EnvObjectMap_Rep.Btn_Search);
	//Wait for loading the page
	utilityFunction.waitForChangesToReflect();
	if(!sel.isTextPresent(str_SlideName))
	{
	//Click Add Item button
	sel.click(EnvObjectMap_Rep.Btn_AddItem);
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("//div[@id='contentTypeRadio_cont']/div[2]/label[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	//Select Slides radio button
	sel.click(EnvObjectMap_Rep.Rbtn_Slides);
	//Click next button
	sel.click(EnvObjectMap_Rep.Btn_Next);
	//Wait for loading the page
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Upload_Next)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	if (VAR_BROWSER_PATH=="*iexplore"){			
		//Wait for loading the page
	    utilityFunction.waitForChangesToReflect();
	    //Bring the focus on File upload field 
		sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
		//utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_Upload_Content;
		
		String []cmd = {auto_it_contentUpload, filePath};
		
		Runtime.getRuntime().exec(cmd);
	}
	
/*	if (VAR_BROWSER_PATH=="*firefox"){		
		//provide Slides location into Content
		sel.type(EnvObjectMap_Rep.TXT_Selected_File, VAR_Upload_Content);	
	}*/	
	
	//Click next button to upload the slides
	sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 400) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.TXT_Display_Name)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	//Provide the slide name
	sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_SlideName);
	//Click Finish button
	sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
	//wait for loading the page
	//sel.waitForPageToLoad(VAR_MAX_WAIT);
	utilityFunction.waitForChangesToReflect();
	utilityFunction.waitForChangesToReflect();
	//Click More button for Search
/*	sel.click(EnvObjectMap_Rep.BTN_More_Search);
	//Provide the Slide name to search
	sel.type(EnvObjectMap_Rep.TXT_Search_Name,str_SlideName);
	//Click Search button
	sel.click(EnvObjectMap_Rep.Btn_Search);
	//Wait for loading the page
	utilityFunction.waitForChangesToReflect();

	//Check Point to test that RSS Encoder is created
	assertTrue("Columbia_LiveProgramVerification","Verify that content is uploaded successfully",sel.isTextPresent(str_SlideName));
*/}
	}
	//Reusable action to upload streaming media
	public static void Upload_streamingMedia(Selenium sel,String str_streamingMediaName, String Streaming_media) throws Exception	{	
    
	Utility_Functions utilityFunction = new Utility_Functions();
	
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	//String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
	//String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
 	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	//Open the programming menu
	sel.click(EnvObjectMap_Rep.LNK_Programming);
	//Select the Content link
	sel.click(EnvObjectMap_Rep.LNK_Content);
	//Wait for loading the page
	sel.waitForPageToLoad(VAR_MAX_WAIT);	 
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("addI")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	Thread.sleep(5000);
	//	utilityFunction.waitForChangesToReflect();
	//Click Add Item button
	sel.click(EnvObjectMap_Rep.Btn_AddItem);
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("//div[@id='contentTypeRadio_cont']/div[2]/label[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	//Click next button
	sel.click(EnvObjectMap_Rep.Btn_Next);
	//Wait for loading the page
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Upload_Next)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
    //Bring the focus on File upload field 
		sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
		//utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + Streaming_media;
		
		String []cmd = {auto_it_contentUpload, filePath};
		
		Runtime.getRuntime().exec(cmd);			
	//Click next button to upload the slides
	sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
	//Wait for loading the page
	utilityFunction.waitForChangesToReflect();
	for (int second = 0;; second++) {
           if (second >= 600) fail("timeout");
           try { if (sel.isElementPresent(EnvObjectMap_Rep.TXT_Display_Name)) break; } catch (Exception e) {}
           Thread.sleep(1000);
       }
	utilityFunction.waitForChangesToReflect();
	
	//Provide the media name
	sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_streamingMediaName);
	if(sel.isElementPresent(EnvObjectMap_Rep.drp_VideoSize))
	{
	sel.select(EnvObjectMap_Rep.drp_VideoSize, EnvObjectMap_Rep.drp_VideoSize_val);
	}
	sel.type(EnvObjectMap_Rep.txt_Duration,"3");

	//Click Finish button
	sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
	//wait for loading the page
	utilityFunction.waitForChangesToReflect();
	utilityFunction.waitForChangesToReflect();
	}
	//utilityFunction.waitForChangesToReflect();
	//utilityFunction.waitForChangesToReflect();
	//Reusable ation to add survey
	public static void Add_Survey(Selenium sel, String str_surveyName, String str_questionName, String str_questionExplanation, String str_questionType) throws Exception {
	
	Utility_Functions utilityFunction = new Utility_Functions(); 
	sel.click(EnvObjectMap_Rep.LNK_Content);
	sel.waitForPageToLoad("50000");
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.BTN_More_Search)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	sel.click(EnvObjectMap_Rep.BTN_More_Search);
	//Provide the Slide name to search
	sel.type(EnvObjectMap_Rep.TXT_Search_Name,str_surveyName);
	//sel.select(EnvObjectMap_Rep.drp_Active, EnvObjectMap_Rep.drp_Active_val);
	//Click Search button
	sel.click(EnvObjectMap_Rep.Btn_Search);
	//Wait for loading the page
	utilityFunction.waitForChangesToReflect();
	if(!sel.isTextPresent(str_surveyName))
	{
	sel.click(EnvObjectMap_Rep.Btn_AddItem);
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible(EnvObjectMap_Rep.radio_contentTypePoll)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	sel.click(EnvObjectMap_Rep.radio_contentTypePoll);
	//Click next button
	sel.click(EnvObjectMap_Rep.Btn_Next);
	//Wait for loading the page
	for (int second = 0;second<=300; second++) {
		try { if (sel.isVisible(EnvObjectMap_Rep.txt_pollDispName)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	sel.type(EnvObjectMap_Rep.txt_pollDispName, str_surveyName);
	sel.click(EnvObjectMap_Rep.btn_addQuestion);
	utilityFunction.waitForChangesToReflect();
	sel.type(EnvObjectMap_Rep.txt_questionDispName, str_questionName);
	sel.type(EnvObjectMap_Rep.txt_questionExplanation, str_questionExplanation);
	sel.select(EnvObjectMap_Rep.drp_questionType, "label=" + str_questionType);
	sel.type(EnvObjectMap_Rep.txt_questionAnswer1, "1");
	sel.type(EnvObjectMap_Rep.txt_questionAnswer2, "2");
	sel.type(EnvObjectMap_Rep.txt_questionAnswer3, "3");		
	sel.click(EnvObjectMap_Rep.btn_questionSave);
	utilityFunction.waitForChangesToReflect();
	sel.click(EnvObjectMap_Rep.btn_questionSave);
	utilityFunction.waitForChangesToReflect();	
	}
}
public static void Upload_externalStreamingMedia(Selenium sel,String str_esmName, String str_esmURL) throws Exception	{	
    
	Utility_Functions utilityFunction = new Utility_Functions();		
	//Fetching values for Global Variables from XMl file
	String str_path ="Global_variables.xml";
	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");

	//Select the Content link
	sel.click("link=Content");
	sel.waitForPageToLoad(VAR_MED_WAIT);
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("addI")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	Thread.sleep(5000);
	sel.click("addI");
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("//div[@id='contentTypeRadio_cont']/div[2]/label[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	sel.click("contentTypeRadio_2");
	//verifyTrue(sel.isElementPresent("//div[@id='contentTypeRadio_cont']/div[2]/label[2]"));
	sel.click("_eventId_next");
	for (int second = 0;; second++) {
		if (second >= 300) fail("timeout");
		try { if (sel.isVisible("displayName")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	//sel.waitForPageToLoad("30000");
	sel.type("displayName", str_esmName);
	sel.type("link", str_esmURL);
	sel.select("formatType", "label=Windows Media");
	sel.type("duration", "3");
	sel.click("_eventId_finish");
	//sel.waitForPageToLoad("30000");
	utilityFunction.waitForChangesToReflect();
}
}