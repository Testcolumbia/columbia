
/*
 * What Setup  Script does:
 * 1)Create Domains(Social,Classic).
 * 2)Create Storage
 * 3)Create WMS Delivery option/HTTP delivery option
 * 4)Create Encoders(WME,RSS2000,RSS4000)
 * 5)Map all resources that scripts has created
 * 6)Add poll/Slide/survey
 * 7)Upload External Streaming Media
 * 8)Upload Simple Streaming Media
 * 
*/

package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v5_4.*;

import com.thoughtworks.selenium.*;

public class Setup_Script_5_4 extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
			utilityFunction=null;
		}
	}	
	
	public void test_Setup_Script() throws Exception {
		{
			try
			{	
				//Global variables file name
				String globalVariableFile ="Global_variables.xml";
				
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions();
				//Variable for the user name
				String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
				//Variable for the Password
				String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
				//Variable for domain name
			    String Var_DomainNameClassic = utilityFunction.GetValue(globalVariableFile ,"VAR_DomClassic");
			    String Var_DomainNameSocial = utilityFunction.GetValue(globalVariableFile ,"VAR_DomSocial");
				String VAR_DomDefault = utilityFunction.GetValue(globalVariableFile, "VAR_DomDefault");

				String Var_StorageName = utilityFunction.GetValue(globalVariableFile,"VAR_Storage");				
				String VAR_AP_Host = utilityFunction.GetValue(globalVariableFile,"VAR_AP_Host");				
				String VAR_AP_MountPoint = utilityFunction.GetValue(globalVariableFile,"VAR_AP_MountPoint");
				String Var_HTTPName = utilityFunction.GetValue(globalVariableFile,"VAR_httpName");
				
				//variable for WMS Name
				String VAR_wmsName = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSoriginName");
				String VAR_WMSHost = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSoriginHost");
				String VAR_WMSHTTPport = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSoriginHTTPport");
				String VAR_WMSUsername = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSoriginUsername");
				String VAR_WMSPassword = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSoriginPassword");
				
				String VAR_HTTP_Host = utilityFunction.GetValue(globalVariableFile,"VAR_HTTP_Host");
				//Variable for the Encoder Name
				String VAR_WMEEncodername = utilityFunction.GetValue(globalVariableFile ,"VAR_Encodername");
				//Variable for the encoder host name
				String VAR_WMEEncoderHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderHostIP");
				//Variable for the Qumu Encoder service Port 
				String VAR_WMEEncoderServicePort = utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderServicePort");
				//Variable for the Qumu Encoder Profile
				String VAR_WMEEncoderProfileName = utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderProfileName");
				//Variable for the Document root directory path
				String VAR_WMEEncoderDocRoot = utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderDocRoot");
				//Variable for the Encoder Port
				String VAR_WMEEncoderPort = utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderPort");
				//Variable for the saved encoder profile file name (with path)
				String VAR_WMEEncoderProfileFileName= utilityFunction.GetValue(globalVariableFile ,"VAR_EncoderProfileFileName");
				//VideoNet Edge profile name
				
				String VAR_VCCInstanceIP = utilityFunction.GetValue(globalVariableFile,"VAR_VCCInstanceIP");
				
		
				//RSS2kv4 encoder variables
				String VAR_RSS2kv4Encodername = utilityFunction.GetValue(globalVariableFile, "VAR_RSS2kv4Encodername");
				//Variable for Encoder User name			
			 	String VAR_RSS2kv4EncoderUserName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderUserName");
				//Variable for Encoder password		
				String VAR_RSS2kv4EncoderPassword = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderPassword");
				//Variable for Encoder bit rate		
				String VAR_RSS2kv4EncoderBitRate = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderBitRate");	
				String VAR_RSS2kv4EncoderHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderHostIP");
				//variable for Encoder Version
				String VAR_RSS2kv4EncoderVersion = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderVersion");
				String VAR_RSS2kv4EncoderProfileName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kv4EncoderProfileName");
				//----------------------------RSS2kv5 encoder variables--------------------------------
				String VAR_RSSv5EncoderName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderName");
				//Variable for the encoder hostIP
				String VAR_RSSv5EncoderHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderHostIP");
				//Variable for the encoder version
				String VAR_RSSv5EncoderVersion = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderVersion");
				//Variable for the encoder user name
				String VAR_RSSv5EncoderUserName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderUserName");
				//Variable for the encoder password
				String VAR_RSSv5EncoderPassword = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderPassword");
				//Variable for the encoder profile name
				String VAR_RSSv5EncoderProfileName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderProfileName");
				//Variable for the encoder bit rate
				String VAR_RSSv5EncoderBitRate = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSv5EncoderBitRate");	
				
				//---------------------------------RSS4kv6 encoder variables-----------------------------------
				String VAR_RSS4kv6EncoderName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS4kv6EncoderName");
				//Variable for the encoder host IP
				String VAR_RSS4kv6EncoderHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS4kv6EncoderHostIP");
				//Variable for the encoder user name
				String VAR_RSS4kv6EncoderUserName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS4kv6EncoderUserName");
				//Variable for the encoder password
				String VAR_RSS4kv6EncoderPassword = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS4kv6EncoderPassword");
				//Variable for the encoder profile name
				String VAR_RSS4kv6EncoderProfileName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS4kv6EncoderProfileName");
				
				//Variable for the maximum number of live streams
				String VAR_MaxStreams = utilityFunction.GetValue(globalVariableFile ,"VAR_MaxStreams");
				//------------------------Poll/slide/survey----------------------------------------------------
				String VAR_SurveyName = utilityFunction.GetValue(globalVariableFile,"VAR_SurveyName");			
				String VAR_QuestionName = utilityFunction.GetValue(globalVariableFile,"VAR_QuestionName");			
				String VAR_QuestionExp = utilityFunction.GetValue(globalVariableFile,"VAR_QuestionExp");			
				String VAR_QuestionType = utilityFunction.GetValue(globalVariableFile,"VAR_QuestionType");			
				String VAR_SlideDisplayName = utilityFunction.GetValue(globalVariableFile,"VAR_SlideDisplayName");
				String VAR_SlideFileName = utilityFunction.GetValue(globalVariableFile,"VAR_SlideFileName");			
				String VAR_PollName = utilityFunction.GetValue(globalVariableFile,"VAR_PollName");
				
				//------------------------------Medianet-------------------------------------------
				
				//Variable for the edge WMS name
				String VAR_WMSedgeName = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSedgeName");
				//Variable for the edge WMS host IP
				String VAR_WMSedgeHost = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSedgeHost");
				//Variable for the edge WMS HTTP port
				String VAR_WMSedgeHTTPport = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSedgeHTTPport");
				//Variable for the edge WMS user-name
				String VAR_WMSedgeUsername = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSedgeUsername");
				//Variable for the edge WMS password
				String VAR_WMSedgePassword = utilityFunction.GetValue(globalVariableFile ,"VAR_WMSedgePassword");
				//Variable for the medianet name
				String VAR_medianetName = utilityFunction.GetValue(globalVariableFile ,"VAR_medianetName");
				//Variables for 1st IP range for CIDR block
				String VAR_CIDR1 = utilityFunction.GetValue(globalVariableFile ,"VAR_CIDR1");		
				//Variables for Metric for the 1st CIDR block
				String VAR_Metric1 = utilityFunction.GetValue(globalVariableFile ,"VAR_Metric1");		
				//Variables for 2nd IP range for CIDR block
				String VAR_CIDR2 = utilityFunction.GetValue(globalVariableFile ,"VAR_CIDR2");		
				//Variables for Metric for the 2nd CIDR block
				String VAR_Metric2 = utilityFunction.GetValue(globalVariableFile ,"VAR_Metric2");	
								
				//Variable for the wmv name
				String VAR_wmvFile = utilityFunction.GetValue(globalVariableFile ,"VAR_wmvFile");
				//Variable for the wmv source file name
				String VAR_wmvSourceFile = utilityFunction.GetValue(globalVariableFile ,"VAR_wmvSourceFile");
				
				//Variable for the external streaming media name
				String VAR_esmName = utilityFunction.GetValue(globalVariableFile ,"VAR_esmName");
				//Variable for the external streaming media URL
				String VAR_esmURL = utilityFunction.GetValue(globalVariableFile ,"VAR_esmURL");
				
				//Login to the admin portal
				Login.test_login(selenium, VAR_USR, VAR_PWD, Var_DomainNameClassic);
				
				//Create Domain classic
//				Setup_Function.create_domainClassic(selenium, Var_DomainNameClassic, Var_DomainNameClassic, "http://"+VAR_VCCInstanceIP);
//				
//				//Change domainClassic
//				Setup_Function.change_domain(selenium, Var_DomainNameClassic);
//				
//				//Create domain Social
//				Setup_Function.create_domainSocial(selenium, Var_DomainNameSocial, Var_DomainNameSocial, "http://"+VAR_VCCInstanceIP);
//				
//				//Call create_storage function to create the storage
//				Setup_Function.create_storage(selenium,Var_StorageName, VAR_AP_Host, VAR_AP_MountPoint);
				
				//Call create_HTTP function to create the HTTP delivery option
				//Create_HTTP.create_HTTP(selenium, Var_HTTPName, VAR_HTTP_Host, VAR_AP_MountPoint, Var_StorageName);
		  
		
			Create_WMS.create_WMS(selenium, VAR_wmsName, VAR_WMSHost, VAR_WMSHTTPport, VAR_WMSUsername, VAR_WMSPassword);
		   //Call reusable action to create the VE as WMS device
			
		//Call reusable action to create WME
			Create_Encoder.create_WME(selenium, VAR_WMEEncodername, VAR_WMEEncoderHostIP, VAR_WMEEncoderServicePort, VAR_WMEEncoderDocRoot, VAR_WMEEncoderProfileName, VAR_WMEEncoderPort, VAR_WMEEncoderProfileFileName);
			
			//Call reusable action to Create RSS4kv5 Encoder
			Create_Encoder.create_RSSv5enc(selenium, "RSSv5Encoder", VAR_RSSv5EncoderName, VAR_RSSv5EncoderHostIP, VAR_RSSv5EncoderVersion, VAR_RSSv5EncoderUserName, VAR_RSSv5EncoderPassword, VAR_RSSv5EncoderProfileName, VAR_RSSv5EncoderBitRate);
			
			//Call reusable action to Create RSS4kv6 Encoder
			
			Create_Encoder.create_RSSv6enc(selenium,"RSSv6Encoder", VAR_RSS4kv6EncoderName, VAR_RSS4kv6EncoderHostIP, VAR_RSS4kv6EncoderUserName, VAR_RSS4kv6EncoderPassword, VAR_MaxStreams, VAR_RSS4kv6EncoderProfileName);
			
			//Call reusable action to Create RSS2kv4 ENcoder
			
		 	Create_Encoder.create_RSSv5enc(selenium, "RSSv4Encoder", VAR_RSS2kv4Encodername, VAR_RSS2kv4EncoderHostIP, VAR_RSS2kv4EncoderVersion, VAR_RSS2kv4EncoderUserName, VAR_RSS2kv4EncoderPassword, VAR_RSS2kv4EncoderProfileName, VAR_RSS2kv4EncoderBitRate);
			
			
			//Reusable action for creating WMS Edge host
		Create_WMS.create_WMS(selenium, VAR_WMSedgeName, VAR_WMSedgeHost, VAR_WMSedgeHTTPport, VAR_WMSedgeUsername, VAR_WMSedgePassword);
				//Reusable action for medianet
				Create_medianet.create_medianetProximity(selenium,VAR_medianetName, VAR_wmsName, VAR_WMSedgeName,VAR_CIDR1, VAR_Metric1, VAR_CIDR2, VAR_Metric2);			
				
			    String[][] ResourceName;
				ResourceName = new String [2][9];
				
				ResourceName[1][0]=Resource.Storage.toString();
				ResourceName[0][0]=Var_StorageName;
				System.out.println(ResourceName[0][0]);
				
				ResourceName[1][1]=Resource.HTTP.toString();
				ResourceName[0][1]=Var_HTTPName;
				System.out.println(ResourceName[0][1]);
						
				ResourceName[1][2]=Resource.WindowsMediaServer.toString();
				ResourceName[0][2]=VAR_wmsName;
				System.out.println(ResourceName[0][2]);
										
				ResourceName[1][3]=Resource.WindowsMediaServer.toString();	
				ResourceName[0][3]=VAR_WMSedgeName;
				System.out.println(ResourceName[0][3]);
				
				
				ResourceName[1][4]=Resource.Encoders.toString();	
				ResourceName[0][4]=VAR_WMEEncodername;
				System.out.println(ResourceName[0][4]);
						
				ResourceName[1][5]=Resource.Encoders.toString();			
				ResourceName[0][5]=VAR_RSSv5EncoderName;
				System.out.println(ResourceName[0][5]);
				
				ResourceName[1][6]=Resource.Encoders.toString();
				ResourceName[0][6]=VAR_RSS4kv6EncoderName;
				System.out.println(ResourceName[0][6]);
				
				ResourceName[1][7]=Resource.Encoders.toString();	
				ResourceName[0][7]=VAR_RSS2kv4Encodername;
				System.out.println(ResourceName[0][7]);
			
				
				ResourceName[1][8]=Resource.MediaNet.toString();	
				ResourceName[0][8]=VAR_medianetName;
				System.out.println(ResourceName[0][8]);
				
																														System.out.println("Rows: "+ResourceName.length);
				for(int x=0;x<ResourceName[0].length;x++)
				{
					int i = 0;
					//Map resources
					Setup_Function.Map_Resources(selenium,Var_DomainNameSocial,ResourceName[i+1][x],ResourceName[i][x]);
				}
				
				//upload Poll
				Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
				
				//Upload survey
				Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
				
				//Upload slides
		         Setup_Function.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
		         
		        
		         //upload Simple streaming Media
		         Upload_Media.Upload_streamingMedia(selenium, VAR_wmvFile, VAR_wmvSourceFile);
		         
		         //upload External Streaming Media
		         Upload_Media.Upload_externalStreamingMedia(selenium, VAR_esmName, VAR_esmURL);
		         
	//-------------------Change Domain for Social----------------------------------------
	     Setup_Function.change_domain(selenium, Var_DomainNameSocial);
	
	     //upload Poll
	    Upload_Media.Add_Survey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
	     
	    //upload survey
	    Upload_Media.Add_Survey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
	
	    //upload Slide
        Setup_Function.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
           
        //upload Simple streaming Media
        Upload_Media.Upload_streamingMedia(selenium, VAR_wmvFile, VAR_wmvSourceFile);
        
        //upload External Streaming Media
        Upload_Media.Upload_externalStreamingMedia(selenium, VAR_esmName, VAR_esmURL);
	
    utilityFunction=null;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				selenium.close();
				selenium.stop();
			}
		}
	}
}

