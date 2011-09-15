/*
 * This method is used to Launch the media Editor for the streaming media and attach the captions, Chapters and slide to it.  
*/

package com.qa.columbia.functions.v5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Launch_mediaEditor extends TesterAsserter{
	
	public static void test_Launch_mediaEditor(Selenium sel,String str_scriptName,String str_steamingMediaName, String str_slideName) throws Exception	{	
        
		String local_path = "CVP_mediaEditor.xml";
		Date date=Calendar.getInstance().getTime();
		Utility_Functions utilityFunction = new Utility_Functions();
		//Variable for the caption name
		String VAR_CaptionName = utilityFunction.GetValue(local_path,"VAR_CaptionName");
		//Variable for the caption time
		String VAR_CaptionTime = utilityFunction.GetValue(local_path,"VAR_CaptionTime");
		//Variable for the chapter Title
		String VAR_chapterTitle = utilityFunction.GetValue(local_path,"VAR_ChapterTitle");
		//Variable for the chapter time
		String VAR_ChapterTime = utilityFunction.GetValue(local_path,"VAR_ChapterTime");
		//Variable for the caption desc.
		String VAR_ChapterDesc = utilityFunction.GetValue(local_path,"VAR_ChapterDesc");
		//Variable for the slide time
		String VAR_SlideTime = utilityFunction.GetValue(local_path,"VAR_SlideTime");
		//Variable for the slide display name
		String VAR_SlideDispName = utilityFunction.GetValue(local_path,"VAR_SlideDispName");
    	//Open the programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Select the Content link
		sel.click(EnvObjectMap_Rep.LNK_Content);
		//wait
		utilityFunction.waitForChangesToReflect();	
		//click on the streaming media		
	    sel.click("link="+str_steamingMediaName);
	    //wait
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.btn_AttachSlide)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		//click on Add Slide button
		sel.click(EnvObjectMap_Rep.btn_AttachSlide);
		//wait
		utilityFunction.waitForChangesToReflect();
		//Move to the Search section
		sel.keyPressNative(java.awt.event.KeyEvent.VK_RIGHT + "");
		//Set focus on the search text box
		sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
		//provide Slide name to Search it from Panel
		sel.type(EnvObjectMap_Rep.txt_searchSlide, str_slideName);
		//Click Search button 
		sel.click(EnvObjectMap_Rep.btn_findSlide);
		//wait
		utilityFunction.waitForChangesToReflect();
		//select slide
		sel.click(EnvObjectMap_Rep.lnk_selectSlide);
		//click on Save button
		sel.click(EnvObjectMap_Rep.btn_saveSelectedSlide);
		//wait
		utilityFunction.waitForChangesToReflect();	
		//click on Launch MediaEditor button
		sel.click(EnvObjectMap_Rep.btn_LaunchMediaEditor);
		for (int second = 0;; second++) 
		{
			if (second >= 600) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.btn_addCaption)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Verify if MediaEditor window is launched
		assertTrue(str_scriptName,"Classic VP: Ensure that media editor is launched for WMV file.(Captions, Chapters, Slides).",date,sel.isElementPresent(EnvObjectMap_Rep.btn_addCaption));
		//Click on Add caption button
		sel.click(EnvObjectMap_Rep.btn_addCaption);
		//Type the time stamp for caption
		sel.type(EnvObjectMap_Rep.txt_captionTimeStamp, VAR_CaptionTime);
		//Type the caption text
		sel.type(EnvObjectMap_Rep.txt_addCaption, VAR_CaptionName);
		//Save the caption
		sel.click(EnvObjectMap_Rep.btn_saveCaption);
		//click on Add chapter button
		sel.click(EnvObjectMap_Rep.btn_addChapter);
		//Provide the chapter time stamp
		sel.type(EnvObjectMap_Rep.txt_chapterTimeStamp, VAR_ChapterTime);
		//Type the chapter title
		sel.type(EnvObjectMap_Rep.txt_chapterName, VAR_chapterTitle);
		//Type the chapter description
		sel.type(EnvObjectMap_Rep.txt_chapterDesc, VAR_ChapterDesc);
		//Save the chapter
		sel.click(EnvObjectMap_Rep.btn_saveChapter);
		//click on add slide button
		sel.click(EnvObjectMap_Rep.btn_addSlide);
		//click on slide display name;
		sel.type(EnvObjectMap_Rep.txt_slideName, VAR_SlideDispName);
		//Type the time stamp for slide
		sel.type(EnvObjectMap_Rep.txt_slideTimeStamp, VAR_SlideTime);
		//select the slide
		sel.select(EnvObjectMap_Rep.drp_slideChoose,"label=Slide 2");
		//click on Save button for slide
		sel.click(EnvObjectMap_Rep.btn_saveSlide);	
		//Verify that caption is added to the streaming media
		assertTrue(str_scriptName,"Ensure that caption is successfully added to the streaming media.",date,sel.isElementPresent(EnvObjectMap_Rep.img_captionMediaEditor));
		//Verify that chapter is added to the streaming media
		assertTrue(str_scriptName,"Ensure that chapter is successfully added to the streaming media.",date,sel.isElementPresent(EnvObjectMap_Rep.img_chapterMediaEditor));
		//Verify that slide is added to the streaming media
		assertTrue(str_scriptName,"Ensure that slide is successfully added to the streaming media.",date,sel.isElementPresent(EnvObjectMap_Rep.img_slideMediaEditor));
		//click on Save button
		sel.click(EnvObjectMap_Rep.btn_saveMediaEditor);
		//wait
		utilityFunction.waitForChangesToReflect();
		//Save the Edit streaming media page
		sel.click(EnvObjectMap_Rep.btn_saveEditContent);
		//wait
		utilityFunction.waitForChangesToReflect();
	}
}
