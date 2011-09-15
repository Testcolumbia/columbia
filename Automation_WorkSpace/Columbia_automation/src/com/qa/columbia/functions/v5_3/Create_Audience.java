/*
 * This reusable action is defined to create an audience
 */
package com.qa.columbia.functions.v5_3;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Create_Audience extends TesterAsserter
{	
	public static void test_Create_Audience(Selenium sel, String str_audienceName, String str_audienceRuleHost, String str_audienceRuleIP, String str_audienceRulePort, String str_downloadDelivery, String str_vodDelivery, String str_liveDelivery) throws Exception {
	//Click on Delivery menu
	sel.click(EnvObjectMap_Rep.LNK_Deliverymenu);
	//Click on Audience link
	sel.click(EnvObjectMap_Rep.lnk_Audience);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Click on Add button
	sel.click(EnvObjectMap_Rep.btn_audienceAdd);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Provide the audience name
	sel.type(EnvObjectMap_Rep.txt_audienceName, str_audienceName);
	//Click on Next button
	sel.click(EnvObjectMap_Rep.btn_audienceNext);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Add rule
	sel.click(EnvObjectMap_Rep.lnk_audienceAddRule);
	sel.type(EnvObjectMap_Rep.fld_audienceRule+"3", str_audienceRuleHost);
	sel.click(EnvObjectMap_Rep.btn_audienceSaveRule);
	sel.click(EnvObjectMap_Rep.lnk_audienceAddRulePair);
	sel.select(EnvObjectMap_Rep.fld_audienceRule+"1", "label=Server Port");
	sel.select(EnvObjectMap_Rep.fld_audienceRule+"4", "label=Request IP");
	sel.type(EnvObjectMap_Rep.fld_audienceRule+"3", str_audienceRulePort);
	sel.select(EnvObjectMap_Rep.fld_audienceRule+"5", "label=like");
	sel.type(EnvObjectMap_Rep.fld_audienceRule+"6", str_audienceRuleIP);
	sel.click(EnvObjectMap_Rep.btn_audienceSaveRulePair);
	sel.click(EnvObjectMap_Rep.btn_audienceNext);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Add the delivery options
	sel.addSelection(EnvObjectMap_Rep.lst_audienceDownload, "label="+str_downloadDelivery);
	sel.click(EnvObjectMap_Rep.lnk_audienceDownloadMoveToSelected);
	sel.addSelection(EnvObjectMap_Rep.lst_audienceVOD, "label="+str_vodDelivery);
	sel.click(EnvObjectMap_Rep.lnk_audienceVODMoveToSelected);
	sel.addSelection(EnvObjectMap_Rep.lst_audienceLive, "label="+str_liveDelivery);
	sel.click(EnvObjectMap_Rep.lnk_audienceLiveMoveToSelected);
	//Click on Next button
	sel.click(EnvObjectMap_Rep.btn_audienceNext);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Click on Next button
	sel.click(EnvObjectMap_Rep.btn_audienceNext);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	//Click on Finish button
	sel.click(EnvObjectMap_Rep.btn_audienceFinish);
	//Wait for the page to load
	sel.waitForPageToLoad("60000");
	}
}