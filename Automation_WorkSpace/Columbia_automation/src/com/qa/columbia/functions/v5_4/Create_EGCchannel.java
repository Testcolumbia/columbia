/*
 * This method is used to Create an EGC enabled channel. 
*/

package com.qa.columbia.functions.v5_4;

//import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Create_EGCchannel extends TesterAsserter {
	
    public static void test_Create_EGCchannel(Selenium sel,String str_channelName, String str_vodMasterProgramName, String str_UserEmailID) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		Date date=Calendar.getInstance().getTime();
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		//Click on Programming
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Click on Channel link
		sel.click(EnvObjectMap_Rep.LNK_Channel);
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
    	//Verify that the channel is created successfully
		assertTrue(" ","Verify that EGC enabled channel is created successfully.",date,sel.isTextPresent(str_channelName));	
	}
}

