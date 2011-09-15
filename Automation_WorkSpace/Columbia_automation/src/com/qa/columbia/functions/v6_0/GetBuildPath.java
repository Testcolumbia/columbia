/**
 * This function is used to get the path of the build on build server.
 */
package com.qa.columbia.functions.v6_0;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import java.text.MessageFormat;

public class GetBuildPath
{	

	public static String cb_adminportalPath(Selenium sel,String BuildNumber) throws Exception	
	{
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String globalPath ="Global_variables.xml";
				
				String VAR_Hudson_URL = utilityFunction.GetValue(globalPath, "VAR_Hudson_URL");
				sel.open(VAR_Hudson_URL);
				sel.waitForPageToLoad("80000");
				sel.windowMaximize();
				sel.click(EnvObjectMap_Rep.Lnk_vccallContinuous);
				sel.waitForPageToLoad("30000");
				for (int i = 2; i<15; i=i+1)
				{
			    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i));  
			    	Thread.sleep(5000);
			    	System.out.println(str_var);
			    	if (str_var.equals("#"+BuildNumber))
			    	{
			    		System.out.println("Build No."+sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i)));
			    		sel.click(MessageFormat.format(EnvObjectMap_Rep.Lnk_latestBuild, i));
		            break;
			    	}                  
				}
				sel.waitForPageToLoad("70000");
				sel.click(EnvObjectMap_Rep.Lnk_adminportal);
				sel.waitForPageToLoad("30000");
				sel.focus(EnvObjectMap_Rep.Lnk_adminportalFile);
				String htmlSource=sel.getHtmlSource();
				int lastIndex = htmlSource.indexOf("adminportal.war");
				String subString = htmlSource.substring(0, lastIndex);
				int startIndex = subString.lastIndexOf("artifact");
				String buildURL = htmlSource.substring(startIndex, lastIndex);
				int startURL = htmlSource.indexOf("job");
				int endURL = htmlSource.indexOf("adminportal");
				String URL = htmlSource.substring(startURL, endURL);
				String apBuildURL = VAR_Hudson_URL+"/"+URL+"adminportal"+"/"+buildURL+"adminportal.war";
				return apBuildURL;
				
 	}
	
	public static String cb_viewerportalPath(Selenium sel,String BuildNumber) throws Exception	
	{
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String globalPath ="Global_variables.xml";
				
				String VAR_Hudson_URL = utilityFunction.GetValue(globalPath, "VAR_Hudson_URL");
				sel.open(VAR_Hudson_URL);
				sel.waitForPageToLoad("80000");
				sel.windowMaximize();
				sel.click(EnvObjectMap_Rep.Lnk_vccallContinuous);
				sel.waitForPageToLoad("30000");
				for (int i = 2; i<15; i=i+1)
				{
			    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i));  
			    	Thread.sleep(5000);
			    	System.out.println(str_var);
			    	if (str_var.equals("#"+BuildNumber))
			    	{
			    		System.out.println("Build No."+sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i)));
			    		sel.click(MessageFormat.format(EnvObjectMap_Rep.Lnk_latestBuild, i));
		            break;
			    	}                  
				}
				sel.waitForPageToLoad("70000");
				sel.click(EnvObjectMap_Rep.Lnk_viewerportal);
				sel.waitForPageToLoad("30000");
				sel.focus(EnvObjectMap_Rep.Lnk_viewerportalFile);
				String htmlSource=sel.getHtmlSource();
				int lastIndex = htmlSource.indexOf("viewerportal.war");
				String subString = htmlSource.substring(0, lastIndex);
				int startIndex = subString.lastIndexOf("artifact");
				String buildURL = htmlSource.substring(startIndex, lastIndex);
				int startURL = htmlSource.indexOf("job");
				int endURL = htmlSource.indexOf("viewerportal");
				String URL = htmlSource.substring(startURL, endURL);
				String vpBuildURL = VAR_Hudson_URL+"/"+URL+"viewerportal"+"/"+buildURL+"viewerportal.war";
				return vpBuildURL;
				
 	}
	
	public static String cb_serviceportalPath(Selenium sel,String BuildNumber) throws Exception	
	{
				Utility_Functions utilityFunction = new Utility_Functions(); 
				//Global Variables file
				String globalPath ="Global_variables.xml";
				
				String VAR_Hudson_URL = utilityFunction.GetValue(globalPath, "VAR_Hudson_URL");
				sel.open(VAR_Hudson_URL);
				sel.waitForPageToLoad("80000");
				sel.windowMaximize();
				sel.click(EnvObjectMap_Rep.Lnk_vccallContinuous);
				sel.waitForPageToLoad("30000");
				for (int i = 2; i<15; i=i+1)
				{
			    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i));  
			    	Thread.sleep(5000);
			    	System.out.println(str_var);
			    	if (str_var.equals("#"+BuildNumber))
			    	{
			    		System.out.println("Build No."+sel.getText(MessageFormat.format(EnvObjectMap_Rep.Lbl_buildNumber, i)));
			    		sel.click(MessageFormat.format(EnvObjectMap_Rep.Lnk_latestBuild, i));
		            break;
			    	}                  
				}
				sel.waitForPageToLoad("70000");
				sel.click(EnvObjectMap_Rep.Lnk_serviceportal);
				sel.waitForPageToLoad("30000");
				sel.focus(EnvObjectMap_Rep.Lnk_serviceportalFile);
				String htmlSource=sel.getHtmlSource();
				int lastIndex = htmlSource.indexOf("serviceportal.war");
				String subString = htmlSource.substring(0, lastIndex);
				int startIndex = subString.lastIndexOf("artifact");
				String buildURL = htmlSource.substring(startIndex, lastIndex);
				int startURL = htmlSource.indexOf("job");
				int endURL = htmlSource.indexOf("serviceportal");
				String URL = htmlSource.substring(startURL, endURL);
				String spBuildURL = VAR_Hudson_URL+"/"+URL+"serviceportal"+"/"+buildURL+"serviceportal.war";
				return spBuildURL;				
 	}
}