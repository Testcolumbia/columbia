/*
 * This method is used to create channel. 
*/
package com.qa.columbia.functions.v6_0;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Create_Channel extends TesterAsserter{
	
	
	public static void createchannel(Selenium sel, String str_ChannelName) throws Exception
	
	{
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String globalVariableFile ="Global_variables.xml";
		//wait
		String VAR_MAX_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MAX_WAIT");
		
		
		//Click on Programming link
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		//click on channels
		sel.click(EnvObjectMap_Rep.Lnk_channels);
		
		//wait
		sel.waitForPageToLoad(VAR_MAX_WAIT);
    	
    	if(sel.isTextPresent(str_ChannelName))
    	{
    		sel.click(EnvObjectMap_Rep.chk_selectAllChannel);
    		sel.click(EnvObjectMap_Rep.btn_deleteChannel);
    		sel.click(EnvObjectMap_Rep.btn_confirmDeleteChannel);
    		sel.waitForPageToLoad("80000");
    	}
    	//Click on the add button
		
		//Add channel
		sel.click(EnvObjectMap_Rep.Btn_addchannel);
		//Wait
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		//Provide channel name
		sel.type(EnvObjectMap_Rep.TXT_ChannelName, str_ChannelName);	
		
		//Save channel
		sel.click(EnvObjectMap_Rep.Btn_savechannel);
		//wait
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		
		
	}

	/*public static void createchannelwithcategory(Selenium sel, String str_ChannelName,String EGCUsername) throws Exception
	{
		Utility_Functions utilityFunction = new Utility_Functions();
		//Fetching values for Global Variables from XMl file
		String globalVariableFile ="Global_variables.xml";
		
		String VAR_MAX_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MAX_WAIT");
		//Click on Programming link
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		//click on channels
		sel.click(EnvObjectMap_Rep.Lnk_channels);
		
		//wait
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		//Add channel
		sel.click(EnvObjectMap_Rep.Btn_addchannel);
		//Wait
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		
		//Provide channel name
		sel.type(EnvObjectMap_Rep.TXT_ChannelName, str_ChannelName);	
		
		sel.click("active.channel.listing");
		sel.click("egc.enabled");
		sel.select("egc.template", "label=vod1");
		sel.click("//button[@type='button' and @onclick=\"dialogManager.instantiate ('egcAuthorRolePrincipalAssignmentDialog', {} ).show()\"]");
		sel.type("//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[2]/td/input[1]", "pkuhar@qasource.com");
		sel.click("//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[2]/td/button");
		sel.click("defaultdomain-MPI2");
		sel.click("//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[5]/td[2]/a[2]");
		sel.click("//div[@id='egcAuthorRolePrincipalAssignmentDialog']/div/div/div[1]/div[3]/button[1]");
		sel.click("//div[@value='esc_category:201']");
		sel.click("//div[@id='mpiwidget_form_SloshBucket_0']/div[2]/a[2]");
		sel.click("_eventId_submit");
		sel.waitForPageToLoad("30000");
		assertTrue(sel.isTextPresent("Channel created"));
	}*/
	//Method for EGC channel creation	
	  public static void Create_EGCChannel(Selenium sel,String str_channelName, String str_vodMasterProgramName, String str_UserEmailID) throws Exception {
				
		    	Utility_Functions utilityFunction = new Utility_Functions();
		    	//Fetching values for Global Variables from XMl file
				String str_path ="Global_variables.xml";
				//Date date=Calendar.getInstance().getTime();
				String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
				//Click on Programming
				sel.click(EnvObjectMap_Rep.Lnk_programming);
				//Click on Channel link
				sel.click(EnvObjectMap_Rep.Lnk_channels);
				//wait
		    	sel.waitForPageToLoad(VAR_MED_WAIT);
			
			if(sel.isTextPresent(str_channelName))
	    	{
	    		sel.click(EnvObjectMap_Rep.chk_selectAllChannel);
	    		sel.click(EnvObjectMap_Rep.btn_deleteChannel);
	    	    sel.click(EnvObjectMap_Rep.btn_confirmDeleteChannel);
	    		sel.waitForPageToLoad("80000");
	    	}
	    	//Click on the add button
			sel.click(EnvObjectMap_Rep.btn_addChannel);
			//wait
	    	sel.waitForPageToLoad(VAR_MED_WAIT);
	    	//Provide the channel name
			sel.type(EnvObjectMap_Rep.txt_channelName, str_channelName);
			//Check the active checkbox
			sel.check(EnvObjectMap_Rep.chk_channelActive);
			//Check the checkbox for enabling the EGC in the channel
			sel.click(EnvObjectMap_Rep.chk_egcChannel);
			//Select the master program
			sel.select(EnvObjectMap_Rep.drp_channel_chooseEGCmaster, "label=" + str_vodMasterProgramName);
			//Click on Add button to add the author
			sel.click(EnvObjectMap_Rep.btn_addEGC_Author);
			//Wait
			utilityFunction.waitForChangesToReflect();
			//Bring the focus on the textbox
			sel.focus(EnvObjectMap_Rep.txt_searchEGC_Author);
			//Provide the user email for searching
			sel.type(EnvObjectMap_Rep.txt_searchEGC_Author, str_UserEmailID);
			//Click on Find button
			sel.click(EnvObjectMap_Rep.btn_searchEGC_Author);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Check the searched user
			sel.click(EnvObjectMap_Rep.chk_selectSearchedEGC_author);
			//wait
			utilityFunction.waitForChangesToReflect();
			//Move the searche duser to teh selected 
			sel.click(EnvObjectMap_Rep.lnk_EGCauthor_moveToSelected);
			//check the selected user
			///sel.click(EnvObjectMap_Rep.chk_selectSearchedEGC_author);
			//Bring the focus on to the selected user
			sel.focus(EnvObjectMap_Rep.chk_selectSearchedEGC_author1);
			//Bring the focus on to the save button
			sel.keyPressNative(java.awt.event.KeyEvent.VK_TAB + "");
			//wait
			//utilityFunction.waitForChangesToReflect();
			//Click on Save button
			sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + "");
		    //Wait
			utilityFunction.waitForChangesToReflect();
			//Click on SAve button to save the channel
			sel.click(EnvObjectMap_Rep.btn_saveEGC_Channel);
			//wait
	    	sel.waitForPageToLoad(VAR_MED_WAIT);	
			
		}
}
