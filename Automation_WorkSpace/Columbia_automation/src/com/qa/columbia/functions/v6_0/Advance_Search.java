/*
 * This method is used to perform Advanced search. 
*/
package com.qa.columbia.functions.v6_0;


import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v6_0.*;



public class Advance_Search 
{	

	public static void AdvanceSearch(Selenium sel,String mediaDisplayName) throws Exception	
	{
	Utility_Functions utilityFunction = new Utility_Functions(); 
	sel.click(EnvObjectMap_Rep.Lnk_advSearch);
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName_advanceSearch, 300);
	sel.type(EnvObjectMap_Rep.Txt_displayName_advanceSearch, mediaDisplayName);
	sel.select(EnvObjectMap_Rep.Drp_status_advSearch, EnvObjectMap_Rep.Drp_statuc_advSearch_value);
	sel.click(EnvObjectMap_Rep.Btn_submit_advSearch);
	utilityFunction.waitForElementToPresent(sel, EnvObjectMap_Rep.Lbl_nameHeader, 300);
	}

	public static void AdvanceSearchPoll(Selenium sel,String pollDisplayName) throws Exception	
	{
	Utility_Functions utilityFunction = new Utility_Functions(); 
	sel.click(EnvObjectMap_Rep.Lnk_advSearch);
	utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_displayName_advanceSearch, 300);
	sel.type(EnvObjectMap_Rep.Txt_displayName_advanceSearch, pollDisplayName);
	sel.click(EnvObjectMap_Rep.Btn_submit_advSearch);
	utilityFunction.waitForElementToPresent(sel, EnvObjectMap_Rep.Lbl_nameHeader, 300);
	}
}

