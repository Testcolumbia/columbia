
/*
 * What Setup  Script does:
 * 1)Create Domains(Social,Classic).
 * 2)Create Storage
 * 3)Create VE Delivery option/HTTP delivery option
 * 4)Create VE Profile
 * 5)Create Encoders(WME,RSS2000,RSS4000)
 * 6)Create Devices(2k,4k)
 * 7)Map all resources that scripts has created
 * 8)Add poll/Slide/survey
 * 9)Ad Master VODprogram/Automate File Broadcast Program
 * 10)Upload External Streaming Media
 * 11)Upload Simple Streaming Media
 * 
*/

package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.*;
import com.thoughtworks.selenium.*;

public class Setup_Script extends TesterAsserter {
	
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
				//Local variable file name
				String localVariableFile = "Setup_Script.xml";
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions();
				//Variable for the user name
				String VAR_USR = utilityFunction.GetValue(globalVariableFile ,"VAR_USR");
				//Variable for the Password
				String VAR_PWD = utilityFunction.GetValue(globalVariableFile ,"VAR_PWD");
				//Variable for domain name
			String Var_DomainNameClassic = utilityFunction.GetValue(globalVariableFile ,"Var_DomainClassic");
			String Var_DomainNameSocial = utilityFunction.GetValue(globalVariableFile ,"Var_DomainSocial");
				String VAR_DomDefault = utilityFunction.GetValue(localVariableFile, "VAR_DomDefault");
				String VAR_VCCInstanceIP = utilityFunction.GetValue(globalVariableFile,"VAR_VCCInstanceIP");
				String Var_StorageName = utilityFunction.GetValue(globalVariableFile,"Var_StorageName");				
				String VAR_AP_Host = utilityFunction.GetValue(localVariableFile,"VAR_AP_Host");				
				String VAR_AP_MountPoint = utilityFunction.GetValue(localVariableFile,"VAR_AP_MountPoint");
				String Var_HTTPName = utilityFunction.GetValue(globalVariableFile,"VAR_httpName");
				
				String VAR_HTTP_Host = utilityFunction.GetValue(globalVariableFile,"VAR_HTTP_Host");
				String Var_WMEName = utilityFunction.GetValue(localVariableFile,"VAR_WMEName");
				
				String Var_WME_Host = utilityFunction.GetValue(localVariableFile,"VAR_WME_Host");
				
				String Var_WME_ComPort = utilityFunction.GetValue(localVariableFile,"VAR_WME_ComPort");
				
				String Var_WME_DocRoot = utilityFunction.GetValue(localVariableFile,"VAR_WME_DocRoot");
				
				String WMEProName = utilityFunction.GetValue(localVariableFile,"VAR_WMEProName");
				
				String Var_WMEProf_Port = utilityFunction.GetValue(localVariableFile,"VAR_WMEProf_Port");
				
				String Var_WMEProf_Path = utilityFunction.GetValue(localVariableFile,"VAR_WMEProf_Path");
				//VideoNet Edge profile name
				String Var_VideoNetEdge_ProfileName = utilityFunction.GetValue(globalVariableFile, "Var_VideoNetEdge_ProfileName");
				//VOD publishing point name
				String Var_vodPP_Name = utilityFunction.GetValue(localVariableFile, "VAR_vodPP_Name");
				//Live publishing point name
				String Var_LivePP_Name = utilityFunction.GetValue(localVariableFile, "VAR_LivePP_Name");
				
				
				//Variable for the RSS4k device name
				String VAR_RSS4kv6DeviceName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceName");
				
				//Variable for the RSS device IP
				String VAR_RSS4kv6DeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceHostIP");
				
				//Variable for the RSS device name
				String VAR_RSS2kDeviceName = utilityFunction.GetValue(localVariableFile ,"VAR_RSS2kDeviceName");
				
				
				//Variable for the RSS device IP
				String VAR_RSS2kDeviceUsername = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kDeviceUsername");
				//Variable for the RSS device IP
				String VAR_RSS2kDevicePassword = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kDevicePassword");
				
				
				//Variable for the RSS device name
				String VAR_RSS4kv5DeviceName = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceNamev4kv5");
				//Variable for the RSS device IP
				String VAR_RSS4kv5DeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSSDeviceHostIP4kv5");
				
				//Variable for the RSS device IP
				String VAR_RSS2kDeviceHostIP = utilityFunction.GetValue(globalVariableFile ,"VAR_RSS2kDeviceHostIP");
				//Variable for the Endpoint IP
			//	String VAR_EndPointIP = utilityFunction.GetValue(local_path ,"VAR_EndPointIP");
				//Variable for the RSS user name
				String VAR_RSSUsername = utilityFunction.GetValue(localVariableFile ,"VAR_RSSUsername");
				//Variable for the RSS password
				String VAR_RSSPassword = utilityFunction.GetValue(localVariableFile ,"VAR_RSSPassword");
				
				//RSS2kv4 encoder variables
				String VAR_RSS2kv4Encodername = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4Encodername");
				String VAR_RSS2kv4EncoderHostIP = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderHostIP");
				String VAR_RSS2kv4EncoderVersion = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderVersion");
				String VAR_RSS2kv4EncoderUserName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderUserName");
				String VAR_RSS2kv4EncoderPassword = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderPassword");
				String VAR_RSS2kv4EncoderProfileName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderProfileName");
				String VAR_RSS2kv4EncoderBitRate = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv4EncoderBitRate");	
				
				
				//RSS2kv5 encoder variables
				String VAR_RSSv5Encodername = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5Encodername");
				String VAR_RSSv5EncoderHostIP = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderHostIP");
				String VAR_RSSv5EncoderVersion = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderVersion");
				String VAR_RSSv5EncoderUserName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderUserName");
				String VAR_RSSv5EncoderPassword = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderPassword");
				String VAR_RSSv5EncoderProfileName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderProfileName");
				String VAR_RSSv5EncoderBitRate = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv5EncoderBitRate");
				
				//VideoNet edge device name
				String Var_VideoNetEdgeDO_Name = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_DO");
				
				//RSS4kv6 encoder variables
				String VAR_RSSv6Encodername = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6Encodername");
				String VAR_RSSv6EncoderHostIP = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6EncoderHostIP");
				String VAR_RSSv6EncoderMaxStreams = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6EncoderMaxStreams");
				String VAR_RSSv6EncoderUserName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6EncoderUserName");
				String VAR_RSSv6EncoderPassword = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6EncoderPassword");
				String VAR_RSSv6EncoderProfileName = utilityFunction.GetValue(localVariableFile ,"VAR_RSSv6EncoderProfileName");	
				
				
				String VAR_SurveyName = utilityFunction.GetValue(localVariableFile,"VAR_SurveyName");			
				String VAR_QuestionName = utilityFunction.GetValue(localVariableFile,"VAR_QuestionName");			
				String VAR_QuestionExp = utilityFunction.GetValue(localVariableFile,"VAR_QuestionExp");			
				String VAR_QuestionType = utilityFunction.GetValue(localVariableFile,"VAR_QuestionType");			
				String VAR_SlideDisplayName = utilityFunction.GetValue(localVariableFile,"VAR_SlideDisplayName");
				String VAR_SlideFileName = utilityFunction.GetValue(localVariableFile,"VAR_SlideFileName");			
				String VAR_PollName = utilityFunction.GetValue(localVariableFile,"VAR_PollName");
				String VAR_esmName = utilityFunction.GetValue(localVariableFile,"VAR_esmName");
				String VAR_esmURL = utilityFunction.GetValue(localVariableFile,"VAR_esmURL");
				String VAR_MasterVOD_ProgramName = utilityFunction.GetValue(localVariableFile,"VAR_MasterVOD_ProgramName");
				String VAR_MasterAutomated_ProgName = utilityFunction.GetValue(localVariableFile,"VAR_MasterAutomated_ProgName");
				String VAR_streamingMediaRSSDisc = utilityFunction.GetValue(localVariableFile,"VAR_streamingMediaRSSDisc");
				String VAR_streamingMediaFile = utilityFunction.GetValue(localVariableFile,"VAR_streamingMediaFile");		
				//Host name for VideoNet Edge device
				String ContentHostIP = utilityFunction.GetValue(globalVariableFile, "Var_VEasWMS_IP");	
				
				//Login to the admin portal
				Login.adminPortalLogin(selenium, VAR_USR, VAR_PWD, Var_DomainNameClassic);
				
				//Create Domain classic
				//Setup_Function.create_domainClassic(selenium, Var_DomainNameClassic, Var_DomainNameClassic, "http://"+VAR_VCCInstanceIP);
				
				//Change domainClassic
				//Setup_Function.change_domain(selenium, Var_DomainNameClassic);
				
				//Create domain Social
				//Setup_Function.create_domainSocial(selenium, Var_DomainNameSocial, Var_DomainNameSocial, "http://"+VAR_VCCInstanceIP);
				
				//Call create_storage function to create the storage
				//Setup_Function.create_storage(selenium,Var_StorageName, VAR_AP_Host, VAR_AP_MountPoint);
				
				//Call create_HTTP function to create the HTTP delivery option
	  //Setup_Function.create_HTTP(selenium,Var_HTTPName, VAR_HTTP_Host, VAR_AP_MountPoint, Var_StorageName);
//				
//			  //Call reusable action to create the VE profile
		   //Create_profileVE.Create_VideoEdge_Profile(selenium, Var_VideoNetEdge_ProfileName, Var_vodPP_Name, Var_StorageName, Var_LivePP_Name);
//			
//		   //Call reusable action to create the VE as WMS device
	//Create_DeliveryOption.Create_VideoNetEdge(selenium, Var_VideoNetEdgeDO_Name, ContentHostIP, Var_VideoNetEdge_ProfileName);
//				
//		//Call reusable action to create WME
		Setup_Function.create_WME(selenium,Var_WMEName, Var_WME_Host, Var_WME_ComPort, Var_WME_DocRoot,WMEProName, Var_WMEProf_Port, Var_WMEProf_Path);
//			
			//Call reusable action to Create 4kv6 device
//			RSS_discovery.Add_4kdevice(selenium, VAR_RSS4kv6DeviceName, VAR_RSS4kv6DeviceHostIP, VAR_RSSUsername, VAR_RSSPassword);
//			
//			//Call reusable action to Create 2kv4 device
//			RSS_discovery.Add_RSS2kdevice(selenium, VAR_RSS2kDeviceName, VAR_RSS2kDeviceHostIP, VAR_RSS2kDeviceUsername, VAR_RSS2kDevicePassword);
//			
//			//Call reusable action to Create 4kv5 device
//			RSS_discovery.Add_RSS2kdevice(selenium, VAR_RSS4kv5DeviceName, VAR_RSS4kv5DeviceHostIP, VAR_RSS2kDeviceUsername, VAR_RSS2kDevicePassword);
//			
			//Call reusable action to Create RSS4kv5 Encoder
			Setup_Function.create_RSS2kenc(selenium, VAR_RSSv5Encodername, VAR_RSSv5EncoderHostIP, VAR_RSSv5EncoderVersion, VAR_RSSv5EncoderUserName, VAR_RSSv5EncoderPassword, VAR_RSSv5EncoderProfileName, VAR_RSSv5EncoderBitRate);
			
			//Call reusable action to Create RSS4kv6 device
			Setup_Function.create_RSSv6enc(selenium, VAR_RSSv6Encodername, VAR_RSSv6EncoderHostIP, VAR_RSSv6EncoderUserName, VAR_RSSv6EncoderPassword, VAR_RSSv6EncoderMaxStreams, VAR_RSSv6EncoderProfileName);
			
			//Call reusable action to Create RSS2kv4 device
			Setup_Function.create_RSS2kenc(selenium, VAR_RSS2kv4Encodername, VAR_RSS2kv4EncoderHostIP, VAR_RSS2kv4EncoderVersion, VAR_RSS2kv4EncoderUserName, VAR_RSS2kv4EncoderPassword, VAR_RSS2kv4EncoderProfileName, VAR_RSS2kv4EncoderBitRate);
			
//				String[][] ResourceName;
//				ResourceName = new String [2][10];
//				ResourceName[0][0]=Var_StorageName;
//				System.out.println(ResourceName[0][0]);
//				ResourceName[1][0]=Resource.Storage.toString();
//				
//				ResourceName[0][1]=Var_HTTPName;
//				System.out.println(ResourceName[0][1]);
//				ResourceName[1][1]=Resource.HTTP.toString();
//			
//				ResourceName[0][2]=Var_VideoNetEdgeDO_Name;
//				System.out.println(ResourceName[0][2]);
//				ResourceName[1][2]=Resource.VideoNetEdge.toString();
//				
//				ResourceName[0][3]=Var_WMEName;
//				System.out.println(ResourceName[0][3]);
//						
//						ResourceName[1][3]=Resource.Encoders.toString();	
//				ResourceName[0][4]=VAR_RSSv5Encodername;
//				System.out.println(ResourceName[0][4]);
//				ResourceName[1][4]=Resource.Encoders.toString();	
//				ResourceName[0][5]=VAR_RSSv6Encodername;
//				System.out.println(ResourceName[0][5]);
//				ResourceName[1][5]=Resource.Encoders.toString();	
//				ResourceName[0][6]=VAR_RSS2kv4Encodername;
//				System.out.println(ResourceName[0][6]);
//				ResourceName[1][6]=Resource.Encoders.toString();	
//			
//					
//				ResourceName[0][7]=VAR_RSS4kv6DeviceName;
//				System.out.println(ResourceName[0][7]);
//				ResourceName[1][7]=Resource.PolycomRSS4000Devices.toString();
//				
//				
//				ResourceName[0][8]=VAR_RSS2kDeviceName;
//				System.out.println(ResourceName[0][8]);
//				ResourceName[1][8]=Resource.PolycomRSS2000Devices.toString();
//				
//				ResourceName[0][9]=VAR_RSS4kv5DeviceName;
//				System.out.println(ResourceName[0][9]);
//				ResourceName[1][9]=Resource.PolycomRSS2000Devices.toString();
//				
//				
//				
//				
//				System.out.println("Rows: "+ResourceName.length);
//				for(int x=0;x<ResourceName[0].length;x++)
//				{
//					int i = 0;
//					//Map resources
//					Setup_Function.Map_Resources(selenium,Var_DomainNameSocial,ResourceName[i+1][x],ResourceName[i][x]);
//				}
				
////				//Add survey in classic domain
//		Setup_Function.Add_pollOrSurvey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
//		
//		//Add Poll in classic domain
//		Setup_Function.Add_pollOrSurvey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
//			
//		//Add Slide in classic domain
//		Setup_Function.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
//		
		//Add external Streaming Media in classic domain
		//Upload_Media.Upload_externalStreamingMedia(selenium, VAR_esmName, VAR_esmURL);
//		
//		//upload Streaming Media
//	Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMediaRSSDisc, VAR_streamingMediaFile);
////	
////	//Call reusable action to Create Master Automated File Broadcast Program
//	Create_Program.create_AutoFileProgram(selenium, VAR_MasterAutomated_ProgName, VAR_esmName, Var_VideoNetEdgeDO_Name);
////			
////	//Call reusable action to Create Master VOD Program
//	Create_Program.create_VODProgram(selenium, VAR_MasterVOD_ProgramName,"", VAR_streamingMediaRSSDisc);
////		
//	//-------------------Change Domain for Social----------------------------------------
//	Setup_Function.change_domain(selenium, Var_DomainNameSocial);
//	
//	//Add Survey
	//Setup_Function.Add_pollOrSurvey(selenium, VAR_SurveyName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
	
	//Add Poll
	Setup_Function.Add_pollOrSurvey(selenium, VAR_PollName, VAR_QuestionName, VAR_QuestionExp, VAR_QuestionType);
    
	//Add Slide
	Setup_Function.Upload_Slides(selenium, VAR_SlideDisplayName, VAR_SlideFileName);
		
	//Add external Streaming Media
	Upload_Media.Upload_externalStreamingMedia(selenium, VAR_esmName, VAR_esmURL);
	
	//Add Simple Streaming Media
	Upload_Media.Upload_streamingMedia(selenium, VAR_streamingMediaRSSDisc, VAR_streamingMediaFile);
	
	//Create Master Automated File Program
	Create_Program.create_AutoFileProgram(selenium, VAR_MasterAutomated_ProgName, VAR_esmName, Var_VideoNetEdgeDO_Name);
		
	//Create Master VOD Program
    Create_Program.create_VODProgram(selenium, VAR_MasterVOD_ProgramName,"", VAR_streamingMediaRSSDisc);
    
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

