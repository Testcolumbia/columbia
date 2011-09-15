/**
 * This function is used to launch the viewer portals.
 */
package com.qa.columbia.functions.v6_0;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v6_0.*;


public class Launch_VP {

	//Function to launch viewer portal classic
	
	public static void Launch_CVP(Selenium sel, String domainName) throws Exception
	{
		//Global Variables File
		String globalVariableFile ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
	    //Application instance
		String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");	
		String VPURL = "http://"+VAR_InstanceIP+"/viewerportal/"+domainName+"/home.do";
		sel.openWindow(VPURL, "CVP");
		Thread.sleep(2000);
		sel.selectWindow("CVP");
		sel.windowMaximize();
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.logo_CVP, 300);
		for (int second = 0;second<=300; second++)
		{
			try
			{
				sel.isVisible(EnvObjectMap_Rep.Drp_selectTimeZone);
				sel.click(EnvObjectMap_Rep.Btn_selectTimeZone);
				utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_loginCVP, 300);
			}
			catch(Exception e)
			{	
			if(sel.isVisible(EnvObjectMap_Rep.Lnk_loginCVP))
			break;
			continue;	
			}	
		}
	}
	
	//Function to launch Social viewer portal 
	
	public static void Launch_SVP(Selenium sel, String domainName) throws Exception
	{
		//Global Variables File
		String globalVariableFile ="Global_variables.xml";
		//Object of Utility_Function class
		Utility_Functions utilityFunction = new Utility_Functions();
	    //Application instance
		String VAR_InstanceIP = utilityFunction.GetValue(globalVariableFile ,"VAR_InstanceIP");	
		String VPURL = "http://"+VAR_InstanceIP+"/viewerportal/"+domainName+"/home.vp?debug=true";
		sel.openWindow(VPURL, "SVP");
		Thread.sleep(2000);
		sel.selectWindow("SVP");
		sel.windowMaximize();
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.logo_SVP, 300);
		for (int second = 0;second<=300; second++)
		{
			try{
				sel.isVisible(EnvObjectMap_Rep.Drp_selectTimeZone);
				sel.select(EnvObjectMap_Rep.Drp_selectTimeZone, "label=(GMT-8:00) Pacific Standard Time");
				sel.click(EnvObjectMap_Rep.Btn_selectTimeZone);
				utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_loginSVP, 300);
				break;
				}
			catch(Exception e)
				{	
				Thread.sleep(1000);
				if(sel.isVisible(EnvObjectMap_Rep.Lnk_loginSVP))
				break;
				continue;	
			}					
		}
	}
}
	

