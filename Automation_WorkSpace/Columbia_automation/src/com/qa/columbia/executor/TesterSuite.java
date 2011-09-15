package com.qa.columbia.executor;

/**
 * This class contains the file to be executed
 * 
 */	 
public class TesterSuite {

  protected TesterSuite() {
  }

  /**
   * This method contains the name of the scripts to be executed. You need to pass the name of the java file (i.e. script) to be executed as below:
   * ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "TestFile Name");
   * @return ranMethods Number of scripts executed
   */
   /**  
   * Before running the test, please ensure that your Selenium Remote Server
   * is up and running. Server can be started using the java -jar selenium-server.jar
   */

  public static int runTestSuite() {
   	

	  String testPackageName = null;
	  
	  TesterUtilities utils = new TesterUtilities();
	  int ranMethods = 0;
	   
	  //	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  //	Put the name of the scripts to be executed below
	  //	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  
	  //	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  //	Please enter all the Scripts related to Login Object
	  //	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   
	     if(TesterGrouping.Patch_Level_testcasesV5_4)
	     {		
		   testPackageName = TesterConstants.TEST_SUITE_PACKAGE_NAME; 	
		   
		               // ranMethods +=utils.runTestMethodsOfTestClass(testPackageName + "Setup_Script_5_4");
//		              ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "TranscodeWMVfiletoFLV");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "TranscodedfileIngestVerification");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "TranscodeFLVfiletoWMV");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_img_upload");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_complexPresentation_upload");
		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Content_upload_WMV");
	               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Content_upload_Slides");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_thumbnailExtraction");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_mediaEditor");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Content_Storage_Report");
//
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_vod_msProducer");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_vod_QT");
	               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_unapproveProgramAccess");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_uploadEGC");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_FLV_SL_Enabled");
               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_Mp3_SL_Disabled");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_SWF_SL_disabled");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_WMA_SL_disabled");
	               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_WMV_SL_Enabled");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_EGC_PrgThumbnail_Verification");
//            
	               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_EGCupload_WMV");
//
//		               
//		               
		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_vod_SurveySummaryReport");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_EGCupload_FLV");
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_EGC_Unapproved_Prg_Verification"); 
		     //-------------------------------------------------------------------------------------------------------------------------------------          
		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_liveProgramWME");
		            		           

		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_liveProgramRSSv5");
		             

		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_liveRSSv6_medianet");
	             
		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_LiveProgram_MediaNet_WME");

		            

		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_LiveProgram_MediaNet_RSSv4"); 
		             
		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_liveProgramAudience");
		             
		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_sm_vpv_022_LiveProgram_AudiencewithPoll");
		             
//		               ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Automated_RSSdisc4k_NonPinProtected");
//		                 ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Automated_RSSdisc4k_PinProtected");
//		                 ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_VOD_RSSdisc4k_PinProtected");
//		                 ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_VOD_RSSdisc4k_NonPinProtected");
               
		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_LiveProgramSurveySummary_Report");
//		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Automated_RSSdisc2k_NonPinProtected");
//		             ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_RSSdisc2k_NonPinProtected");

		            

	     }
	     else if(TesterGrouping.Patch_Level_testcasesV5_3)
	       {		
			   testPackageName = TesterConstants.TEST_SUITE_PACKAGE_NAME_V5_3;	
				  
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_015_wmvUpload");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_014_imgUpload");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Transcoding_Sm_tcd_001_fileIngestVerification");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Transcoding_Sm_tcd_003_FLVtoWMV");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Transcoding_Sm_tcd_002_WMVtoFLV");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_015_complexPresentationUpload");
		       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_016_slideUpload");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_019_thumbnailExtraction");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_016_mediaEditor");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_019_Content_Storage_Report");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_018_vod_SurveySummaryReport");
	   		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_008_vod_msProducer");
	   		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_009_vod_QT");
	   		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_007_uploadEGC");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_008_VOD_FLV_SL_Enabled");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_009_VOD_Mp3_SL_Disabled");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_010_VOD_SWF_SL_disabled");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_021_VOD_WMA_SL_disabled");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_007_VOD_WMV_SL_enabled");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_020_EGC_PrgThumbnail_Verification");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_017_unapprovedEGC_prg_verification");   
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_005_EGCupload_WMV");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_006_EGCupload_FLV");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_017_unapproveProgramAccess");
			  
			   /*ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_020_liveAudience");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_001_liveRSSv5");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_004_archiveRSSv5");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_006_archiveRSSv6_medianet");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_003_liveRSSv6_medianet");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_005_archiveWME");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_002_liveWME");
		       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_010_NonPin_Automated_RSSdisc4k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_012_PinProtected_Automated_RSSdisc4k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_013_PinProtected_VOD_RSSdisc4k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_011_NonPin_VOD_RSSdisc4k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_001_LiveWME_MediaNet"); 
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_004_Archived_RSSv4_MediaNet");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_002_LiveRSSv4_MediaNet");		
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_018_LiveSurveySummary_Report");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_011_NonPin_Automated_RSSdisc2k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_012_NonPin_VOD_RSSdisc2k");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_003_Archived_WME_MediaNet"); */
		   
	       }
	     else if(TesterGrouping.BuildAcceptance_testcasesV6_0)
	       {		
			   testPackageName = TesterConstants.TEST_SUITE_PACKAGE_NAME_V6_0;
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Deploy_warfiles_local_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Cleanup_Script");
			  
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Access_Carousal_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Access_JukeBox_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "BuildVersionVerification_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Channel_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Category_TCID"); 
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Login_page_TCID"); 
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "LoginVerification_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Create_VEasWMS_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "FeatureLinksAccessibility_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Media_Upload_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Create_VOD_Program_TCID");
			   
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "MVV_VOD_report_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Launch_SVP_TCID");
			  
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Play_LiveProgram_TCID");			  
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Play_LiveProgram_TCID"); 
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_VOD_Program_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_VOD_Program_TCID");
			   
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "TomcatService_Startup_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "POQO_setup_script");	
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName +" POQO_Login_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "POQO_ConfServPortal_TCID"); 
			   
	ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "POQO_Standalone_Video_TCID");
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "POQO_extractVideosUsingChannel_TCID");
			   
			   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "QumuService_Startup_TCID");
			   
			   
			
		   }
	     else if(TesterGrouping.Patch_Level_testcasesV6_0)
	       {		
			   testPackageName = TesterConstants.TEST_SUITE_PATCHLEVEL_TESTCASES_V6_0;
			 ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Cleanup_Script");
			 // ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Setup_Script");
			 
			 //------------------------------------------------Live program--------------------------------
//			 //ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_011_Automated_RSSdisc2k_NonPinProtected");
//             ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_012_VOD_RSSdisc2k_NonPinProtected");
//
//             //ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_010_Automated_RSSdisc4k_NonPinProtected");
//          ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_011_VOD_RSSdisc4k_NonPinProtected");
//          //ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_012_Automated_RSSdisc4k_PinProtected");
//          ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_013_VOD_RSSdisc4k_PinProtected");
//         ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_021_AutomatedPT_RSSdisc4kv6_PinProtected");
//          ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"CVP_Sm_vpc_022_AutomatedPT_RSSdisc4kV5_NonPinProtected");
//           ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_022_Automated_RSSdisc4k_NonPinProtected_template");
//-------------------------------------------------------------------------------------------------------
			 		 // ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_026_liveProgramSkin");
//	          
	            ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_002_liveProgramWME");
	        
	        //ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_002_liveProgramRSS2k4");
			 //ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_020_LiveProgram_Audience_RSS4kV5");  
			ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_001_liveProgramWME");
			 //---------------------------------------------------------------------------------------
		 //  ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Sm_tcd_001_Transcoding_fileIngestVerification");
////		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Sm_tcd_003_Transcoding_FLVtoWMV");
////	       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "Sm_tcd_002_Transcoding_WMVtoFLV");
	    	ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_028_LiveProgram_Audience");
			   // ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_001_liveRSSv5");
//			    ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_018_LiveSurveySummary_Report");
////
////
//		 	 ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_023_LiveProgram_Audience_ConfiguredURL");  
//			  
				 //---------------------------------------------------------Par------------------------------------
//         ranMethods += utils.runTestMethodsOfTestClass(testPackageName +"SVP_Sm_vpv_019_Content_Storage_Report"); 
//		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_014_imgUpload");
//		   ranMethods += utils.runTestMethodsOfTestClass(testPackageName +   "SVP_Sm_vpv_009_VOD_Mp3_SL_Disabled");
//
//	       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_008_VOD_FLV_SL_Enabled");
//         ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_010_VOD_SWF_SL_disabled");
//	       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_005_EGCupload_WMV");
//	       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_006_EGCupload_FLV");
//	       ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_024_EGC_ODPT_UploadMPEG4"); 
//         ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_025_EGC_ODPT_UploadFLV"); 
//			  ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_026_EGC_ODPT_UploadWMV");
//			  ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_016_Content_upload_Slides");
//
// 	ranMethods += utils.runTestMethodsOfTestClass(testPackageName +  "SVP_Sm_vpv_007_VOD_WMV_SL_Enabled");
//	   ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_021_VOD_WMA_SL_disabled");
// 
//	  ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_017_EGC_Unapproved_Prg_Verification");	
//		    
//			    //-------------------------------------------------------Mal--------------------------------
//	  ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_018_vod_SurveySummaryReport");  
//      ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_016_mediaEditor");
//      ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_017_unapproveProgramAccess");
//     ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_015_complexPresentationUpload");
//      ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_019_thumbnailExtraction");
//      ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_008_vod_msProducer");
//     ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_024_flvstreamingMediaSkin");      
//     ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_009_vod_QT");
//    ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_025_wmvstreamingMediaSkin");
//      ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "CVP_Sm_vpc_007_uploadEGC");
//       
//     
//         ranMethods += utils.runTestMethodsOfTestClass(testPackageName + "SVP_Sm_vpv_027_VODConfiguredURL");
//   

	
			
	       }
	  //Return the number of scripts executed
	  return ranMethods;

  }



}
