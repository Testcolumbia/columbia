/*
 * This method is used to Launch LBC .
 * @param sel selenium object that runs the selenium commands
 * @throws Exception 
*/
package com.qa.columbia.functions.v5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Launch_LBC extends TesterAsserter {
	
    public static void LBC (Selenium sel ) throws Exception	{
	
    	Utility_Functions utilityFunction = new Utility_Functions();
    	
    	//Fetching values for Global Variables from XMl file
    	String str_path ="Global_variables.xml";
    	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
    	Date date=Calendar.getInstance().getTime();
    	//Open the Programming menu
    	sel.click(EnvObjectMap_Rep.LNK_Programming);
    	//Open the Programs age
    	sel.click(EnvObjectMap_Rep.LNK_Programs);
    	utilityFunction.waitForChangesToReflect();
    	//Click Live Broadcast icon
    	sel.click(EnvObjectMap_Rep.LNK_LBC);
    	//Click Launch Broadcast Now
    	sel.click(EnvObjectMap_Rep.LNK_Launch_Now);
		for (String windowName1 : sel.getAllWindowNames()) {
			if (windowName1.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.waitForPopUp(windowName1, VAR_MAX_WAIT);
			}
        }
		for (String windowName : sel.getAllWindowNames()) {
			if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.selectWindow(windowName);
            }
        }

		//Click Save button on LBC
		sel.click(EnvObjectMap_Rep.Btn_Save_LBC_Summary);
		//wait for changing the phase
		utilityFunction.waitForChangesToReflect();
		//Click Start Sources button
		sel.click(EnvObjectMap_Rep.Btn_Start_Source);
		//wait for changing the phase
		utilityFunction.waitForChangesToReflect();
		//Click Provision Network button
		sel.click(EnvObjectMap_Rep.Btn_Prov_Network);
		//wait for changing the phase
		utilityFunction.waitForChangesToReflect();
		//Click Start Broadcast button
		sel.click(EnvObjectMap_Rep.Btn_Start_Bcast);
		//wait for changing the phase
		utilityFunction.waitForChangesToReflect();	
		//Click Start Broadcast button on LBC
		sel.click(EnvObjectMap_Rep.Btn_Flip_Slide);
		//utilityFunction.waitForChangesToReflect();
	    //Check Point to test that Live Broadcast is started
		assertTrue("Columbia_LiveProgramVerification","Verify that Live Broadcast is started successfully.",date,sel.isElementPresent(EnvObjectMap_Rep.Btn_Pause_Archive));
		//Close the LBC window
		sel.close();
    }
    
    public static void test_LaunchLBC (Selenium sel,String str_scriptName, String str_ProgramName, String str_archiveName) throws Exception	{
    	
    	Utility_Functions utilityFunction = new Utility_Functions();    	
    	//Fetching values for Global Variables from XMl file
    	String str_path ="Global_variables.xml";
    	Date date=Calendar.getInstance().getTime();
    	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
    	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");	
    	//Open the Programming menu
    	sel.click(EnvObjectMap_Rep.LNK_Programming);
    	//Open the Programs age
    	sel.click(EnvObjectMap_Rep.LNK_Programs);
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	sel.type(EnvObjectMap_Rep.SelectType_Search_Program, str_ProgramName);
		sel.click(EnvObjectMap_Rep.Btn_Search_Program);
    	sel.waitForPageToLoad(VAR_MED_WAIT);
    	//Click Live Broadcast icon
    	sel.click(EnvObjectMap_Rep.LNK_LBC);
		//sel.click("//a[@onclick='serviceLocation.onClickLaunchLBCButtonEventNow(this, \"esc_program:601\", false );_closeSelectBroadcastDialog( \"master_button_${itemIteratorCount}\" )']");
		//sel.waitForPopUp("lbc_false_esc_program_601", "30000");
	
    	//utilityFunction.waitForChangesToReflect();
    	//Click Launch Broadcast Now
    	sel.click(EnvObjectMap_Rep.LNK_Launch_Now);
		for (String windowName1 : sel.getAllWindowNames()) {
			if (windowName1.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.waitForPopUp(windowName1, VAR_MAX_WAIT);
			}
        }
		for (String windowName : sel.getAllWindowNames()) {
			if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.selectWindow(windowName);
            }
        }
		if(!sel.isChecked(EnvObjectMap_Rep.chk_ArchiveLBC))
		{
		sel.click(EnvObjectMap_Rep.chk_ArchiveLBC);
		}
		sel.type("//tbody[2]/tr/td[2]/input", str_archiveName);
		//Click Save button on LBC
		sel.click(EnvObjectMap_Rep.Btn_Save_LBC_Summary);
		//wait for changing the phase
		utilityFunction.waitForChangesToReflect();
		//Click Start Sources button
		sel.click(EnvObjectMap_Rep.Btn_Start_Source);
		//wait for changing the phase
		for (int second = 0;; second++) {
			if (second >= 400) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Prov_Network)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Click Provision Network button
		sel.click(EnvObjectMap_Rep.Btn_Prov_Network);
		//wait for changing the phase
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isVisible(EnvObjectMap_Rep.Btn_Start_Bcast)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Click Start Broadcast button
		sel.click(EnvObjectMap_Rep.Btn_Start_Bcast);
		//wait for changing the phase

			for (int second = 0;; second++) {
				if (second >= 300) fail("timeout");
				try { if (sel.isVisible(EnvObjectMap_Rep.btn_stopBroadcast)) break; } catch (Exception e) {}
				Thread.sleep(1000);
		//}
		}
	    //Check Point to test that Live Broadcast is started
		assertTrue(str_scriptName,"Verify that Live Broadcast is started successfully.",date,sel.isElementPresent(EnvObjectMap_Rep.btn_stopBroadcast));
		//Click Start Broadcast button on LBC
		if(sel.isVisible(EnvObjectMap_Rep.Btn_Flip_Slide))
		{
			sel.click(EnvObjectMap_Rep.Btn_Flip_Slide);
			utilityFunction.waitForChangesToReflect();
			assertTrue(str_scriptName,"Verify that Slide is pushed successfully from LBC.",date,sel.isTextPresent("slide 1"));
		}

		if(sel.isElementPresent(EnvObjectMap_Rep.lnk_pushPoll))
		{
			sel.click(EnvObjectMap_Rep.lnk_pushPoll);
			utilityFunction.waitForChangesToReflect();
			assertTrue(str_scriptName,"Verify that Poll Question is pushed successfully from LBC.",date,sel.isElementPresent(EnvObjectMap_Rep.lnk_pushPollResult));
		}
		
	}
}
