/*
 * This method is used to Create an EGC enabled channel. 
*/

package com.qa.columbia.functions.v6_0;

//import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.repository.v6_0.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;


public class Create_EGCchannel extends TesterAsserter {
	
    public static void Create_EGCChannel(Selenium sel,String str_channelName, String str_vodMasterProgramName) throws Exception {
		
    	Utility_Functions utilityFunction = new Utility_Functions();
    	//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		Date date=Calendar.getInstance().getTime();
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
		
		utilityFunction.waitForChangesToReflect();
		//Click on SAve button to save the channel
		sel.click(EnvObjectMap_Rep.btn_saveEGC_Channel);
	
	}
}

