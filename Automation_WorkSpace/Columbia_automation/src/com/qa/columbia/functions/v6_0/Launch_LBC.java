/**
 * This function is used to launch the broadcast.
 */
package com.qa.columbia.functions.v6_0;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Launch_LBC extends TesterAsserter
{

	public static void StartBroadcast(Selenium sel,String ProgramName) throws Exception
	{	
		Utility_Functions utilityFunction = new Utility_Functions();    	
    	//Fetching values for Global Variables from XMl file
    	String str_path ="Global_variables.xml";
    	Date date=Calendar.getInstance().getTime();
    	String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
    	String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");	
    	//Open the Programming menu
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		sel.click(EnvObjectMap_Rep.Lnk_programs);
		sel.waitForPageToLoad(VAR_MED_WAIT);
    	sel.type(EnvObjectMap_Rep.Txt_searchProgram, ProgramName);
    	sel.click(EnvObjectMap_Rep.Btn_searchProgram);
    	sel.waitForPageToLoad(VAR_MED_WAIT);   
    	
    	sel.click(EnvObjectMap_Rep.Lnk_contextMenu);
    	sel.click(EnvObjectMap_Rep.Lnk_broadcastsContextMenu);
    	sel.click(EnvObjectMap_Rep.Lnk_LaunchNow_ContextMenu);
    	utilityFunction.waitForChangesToReflect();
		for (String windowName : sel.getAllWindowNames()) {
			if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.selectWindow(windowName);
            }
        }
		
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_Save_LBC_tab, 300);
		sel.click(EnvObjectMap_Rep.Btn_Save_LBC_tab);
		if(!sel.isChecked(EnvObjectMap_Rep.chk_ArchiveLBC))
		{
		sel.click(EnvObjectMap_Rep.chk_ArchiveLBC);
		}
		sel.type(EnvObjectMap_Rep.Txt_ArchiveProgram, "Archived"+ProgramName);
		//Click Save button on LBC
		sel.click(EnvObjectMap_Rep.Btn_Save_LBC_Summary);
	
		
		
	
/*		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Tab_BroadcastControl, 300);*/
		sel.click(EnvObjectMap_Rep.Tab_BroadcastControl);
		//Click Start Sources button
		Thread.sleep(2000);
		for(int x=0;x<=10;x++)
		{
		if(sel.isEditable(EnvObjectMap_Rep.Btn_Start_Source))
		{
			sel.click(EnvObjectMap_Rep.Btn_Start_Source);
			Thread.sleep(5000);
		}
		else
		{
			break;
		}
		}
		//wait for changing the phase
		utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.Btn_Prov_Network, 300);

		//Click Provision Network button
		sel.click(EnvObjectMap_Rep.Btn_Prov_Network);
		//wait for changing the phase
		utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.Btn_Start_Bcast, 300);
		//Click Start Broadcast button
		sel.click(EnvObjectMap_Rep.Btn_Start_Bcast);
		//wait for changing the phase
		utilityFunction.waitForElementToVisible(sel,EnvObjectMap_Rep.Btn_Stop_Bcast, 300);		
	}
	
	public static void StopBroadcast(Selenium sel,String ProgramName) throws Exception
	{
		Utility_Functions utilityFunction = new Utility_Functions(); 
		for (String windowName : sel.getAllWindowNames()) {
			if (windowName.indexOf(EnvObjectMap_Rep.Select_LBC) != -1){
				sel.selectWindow(windowName);
            }
        }
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Tab_BroadcastControl, 300);
		sel.click(EnvObjectMap_Rep.Tab_BroadcastControl);
		sel.click(EnvObjectMap_Rep.Btn_Stop_Bcast);
		utilityFunction.waitForElementTodisappear(sel, EnvObjectMap_Rep.Btn_Stop_Bcast, 300);
			
	}	
}