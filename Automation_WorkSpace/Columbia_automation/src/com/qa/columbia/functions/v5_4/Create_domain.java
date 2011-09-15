/*
 * This method is used to Create new domain in the Application.
 * @param sel selenium object that runs the selenium commands
 * @param str_domainid is used to pass domain Id when domain is created. 
 * @param str_domainname is used to pass domain name when domain is created.
 * @param str_SiteURL is used to pass Site URL when domain is created.
 * @param str_WMPlogLoc is used to provide the location for the logs of WMP to be received in the Browser.
 * @throws Exception 
*/

package com.qa.columbia.functions.v5_4;

import com.qa.columbia.repository.v5_4.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;
import java.text.MessageFormat; 
import java.util.Calendar;
import java.util.Date;


public class Create_domain extends TesterAsserter{
	
	public static void create_domain(Selenium sel, String str_domainid, String str_domainname, String str_SiteURL, String str_WMPlogLoc) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		Date date=Calendar.getInstance().getTime();
		//Fetching values for local Variables from XMl file
		String local_path ="local_Variables.xml";
		String VAR_Sto_Quota = utilityFunction.GetValue(local_path ,"VAR_Sto_Quota");
		String VAR_Sto_Threshold_Warn = utilityFunction.GetValue(local_path ,"VAR_Sto_Threshold_Warn");
		//Open the Domains page
		sel.click(EnvObjectMap_Rep.LNK_Domains);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);		
		//Click Add button
		sel.click(EnvObjectMap_Rep.BTN_AddDomain);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);		
		//provide Domain id
		sel.type(EnvObjectMap_Rep.LNK_DomainID,str_domainid);		
		//provide Domain name
		sel.type(EnvObjectMap_Rep.LNK_DomainName,str_domainname);		
		//Activate the Domain
		sel.click(EnvObjectMap_Rep.LNK_DomainActive);		
		//Save the domain
		sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);			
		//Checkpoint for the newly created domain
		assertTrue("Columbia_LiveProgramVerification","Verify that domain is successfully created",date,sel.isTextPresent("Domain Created"));
		//Provide the Site URL
		sel.type(EnvObjectMap_Rep.TXT_SiteURL, str_SiteURL);		
		//Enable the receiving of Windows Media Player logs
		sel.click(EnvObjectMap_Rep.CHK_WMP_logs);		
		//Provide the path for the logs to received
		sel.type(EnvObjectMap_Rep.TXT_WMP_logs_location, str_SiteURL.concat(str_WMPlogLoc));		
		//Provide the Storage threshold quota
		sel.type(EnvObjectMap_Rep.TXT_Storage_Quota, VAR_Sto_Quota);		
		//Provide the Storage threshold warning percentage
		sel.type(EnvObjectMap_Rep.TXT_Storage_Threshold,VAR_Sto_Threshold_Warn);		
		//Check the checkbox to Use the social Viewer Portal
		sel.click(EnvObjectMap_Rep.CHK_Domain_Conf_SVP);		
		//Click on Save button
		sel.click(EnvObjectMap_Rep.BTN_DomainSave);		
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);			
		//Click on Change domain
		sel.click(EnvObjectMap_Rep.LNK_Chng_Domain);			
		//Choose the required domain
	    for (int i = 2; i<50; i=i+1){
	    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.LNK_Domain_select, i));
	    	if (str_var.equals(str_domainname)){
	    		sel.click(MessageFormat.format(EnvObjectMap_Rep.LNK_Domain_select, i));
                sel.waitForPageToLoad(VAR_MED_WAIT);
                break;
            }                  
        }
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);		
		//Checkpoint for the newly created domain		
		assertTrue("Columbia_LiveProgramVerification","Verify that newly created domain is listed on Domains page.",date,sel.isTextPresent(str_domainname));
		//assertTrue("Columbia_MainScript","Verify that domain is listed on Domains page",sel.isTextPresent(VariablesEnv_Rep.VAR_Dom));

    }
	
}	




