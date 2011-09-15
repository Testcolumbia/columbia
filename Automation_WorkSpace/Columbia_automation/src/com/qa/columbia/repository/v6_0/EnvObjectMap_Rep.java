/*
 * This class is used to declares Object properties
 * 
 */

package com.qa.columbia.repository.v6_0;

public interface EnvObjectMap_Rep
{
	
	
//*************************************Admin Portal*************************************//
	
	/***********************************Login Page***********************************/
	
		//User Name text box on Login page	 
		static final String Txt_userName ="loginbox";
		
		//Password text box on Login page	 
		static final String Txt_password ="passwordbox";
		
		//Domain drop down on Login page	 
		static final String Drp_domain ="domainselect";
		
		//Login button on Login page	 
		static final String Btn_login ="loginbutton";
		
		//VCC logo
		static final String logo = "logoDiv";
		
		//logout link on admin portal
		static final String Lnk_logout = "link=Log Out";
		
		static final String Lnk_Systemlink="menu_system_cont";
		static final String Btn_AddUser="id=add_button";
		
		//*********************************BDCAST*********************************
		static final String Txt_broadcastConsoleimg="//div[@id='consoleLog']/div/img";
		//********************************Build Info***********************************************//
		//Build Info link
		static final String Lnk_buildinfo="link=Build Info";
		
		//Build Version
		static final String Label_version="//table[@id='menuContentLayout']/tbody/tr/td[3]/div[@id='contentContainer']/table[1]/tbody/tr[1]/td[2]";
	//****System /User Management/Resources/Delivery/Programming/Reports feature links accessibility*******//
		
		
		//************************System Links************************************
		static final String Lnk_Systemmenu="menu_system_cont";
		static final String Lnk_domains="link=Domains";
		static final String Lnk_systemResourceMapping="link=System Resource Mapping";
		static final String Lnk_componentConfiguration="link=Component Configuration";
		static final String Lnk_emailclientConfiguration="link=Email Client Configuration";
		static final String Lnk_emails="link=Emails";
		
		static final String Lnk_csslayout="link=CSS Layouts";
		static final String Lnk_scheduledprocess="link=Scheduled Processes";
		static final String Lnk_videoEdgeconfiguration="link=VideoNet Edge Configuration";
		static final String Lnk_ingests="link=Ingests";
		static final String Lnk_fileTransfers="link=File Transfers";
		
		 //choose domain link
	    static final String LST_Searchresult_domain = "//div[{0}]/div[2]/table/tbody/tr/td/div[2]/a";
	    
	    //submit domain
	    static final String Btn_savedomain = "_eventId_submit";
	    
	  //Object map declaration to Save the Domain
		
		static final String BTN_DomainSave= "//button[@id='_eventId_submit']";
		
		//************************User Management Links****************************
		static final String Lnk_UserManagement="menu_security_cont";
		static final String Lnk_Realms="link=Realms";
		static final String Lnk_Roles="link=Roles";
		static final String Lnk_Users="link=Users";
		static final String Lnk_Groups="link=Groups";
		static final String Lnk_AccessControl="link=Access Control";
		
		static final String Lnk_yourProfile="link=Your Profile";
		
		//*************************Resources*****************************************
		static final String Lnk_resources="menu_resourcebin_cont";
		static final String Lnk_Storage="link=Storage";
		static final String Lnk_Encoders="link=Encoders";
		static final String Lnk_Studios="link=Studios";
		static final String Lnk_TranscodingNodes="link=Transcoding Nodes";
		static final String Lnk_PolycomRSSDevices="link=Polycom RSS Devices";
		
		//************************Delivery*********************************************
		
		static final String Lnk_delivery="menu_config_cont";
		static final String Lnk_deliveryOptions="link=Delivery Options";
		static final String Lnk_audiences="link=Audiences";
		static final String Lnk_locations="link=Locations";
		static final String Lnk_GlobalProximityConfiguration="link=Global Proximity Configuration";
		static final String Lnk_DeliveryRoutes="link=Delivery Routes";
		static final String Lnk_VideoEdgeProfiles="link=VideoNet Edge Profiles";
		static final String Lnk_VideoEdgeUpgrade="link=VideoNet Edge Upgrade";
		
		
		//*************************Programming******************************************
		
		static final String Lnk_programming="menu_programming_cont";
		static final String Lnk_programs="link=Programs";
		static final String Lnk_channels="link=Channels";
		static final String Lnk_categories="link=Categories";
		static final String Lnk_programTemplates="link=Program Templates";
		static final String Lnk_tags="link=Tags";
		static final String Lnk_featuredItems="link=Featured Items";
		static final String Lnk_moderatecomments="link=Moderate Comments";
		static final String Lnk_approveprogram="link=Approve Programs";
		static final String Lnk_skins="link=Skins";
		static final String Lnk_broadcastMonitor="link=Broadcast Monitor";
		static final String Lnk_customprogramattributes="link=Custom Program Attributes";
		static final String Lnk_polycomRSSDiscovery="link=Polycom RSS Discovery";
		static final String Lnk_calendardiscovery="link=Calendar Discovery";
		
// *************************Polycom RSS devices Page Object Map**********************************	
		
		 //Polycom RSS discovery link
	    static final String lnk_PolycomRSSDiscovery = "link=Polycom RSS Discovery";
		// Object map declaration for Polycom RSS Devices menu
		
		static final String lnk_PolycomRSSDevices = "link=Polycom RSS Devices";
		
		// Object map declaration for Add RSS Device button
		
		static final String btn_addRSSDevice = "//button[@type='button']";
		
		// Object map declaration for Select RSS Device option
		
		static final String selectRSSDevice = "selectselectTypeDialoginfoTypes";
		
		// Object map declaration for RSS4kV6 device option
		
		static final String selectRSS4kV6 = "rss_src_device";
		
		// Object map declaration for name text box 
		
		static final String txt_rssV6DeviceName = "name";
		
		// Object map declaration for Host textbox
		
		static final String txt_rssV6DeviceHostIP = "host";
		
		// Object map declaration for username textbox
		
		static final String txt_rssV6DeviceUsername = "login";
		
		// Object map declaration for password textbox
		
		static final String txt_rssV6DevicePassword = "password";
		
		// Object map declaration for confirm password text box
		
		static final String txt_rssV6DeviceConfirmPassword = "password_confirm";
		
		// Object map declaration for Enable Live checkbox
		
		static final String chk_rssv6EnableLive = "liveDiscoveryEnabled";
		
		// Object map declaration for Enable archive textbox
		
		static final String chk_rssv6EnableArchive = "archiveDiscoveryEnabled";
		
		// Object map declaration for save button
		
		static final String btn_saveRSSv6Device = "submit_button";
		
		// Object map declaration for delete RSS Device button 
		
		static final String btn_deleteRSSDevice = "delete";
		
		// Object map declaration for confirm Delete button
		
		static final String btn_confirmDeleteRSSDevice = "//div[@id='mpiwidget_layout_ConfirmDialog_0']/div[2]/button[1]";
		
		// Object map declaration for VRR name label
			
		static final String lbl_rssV6VRRName = "//tr[{0}]/td[3]";//table[@id='mappingTable']/tbody/tr[{0}]/td[3]";
		
		// Object map declaration for VRR name link
		
		static final String lnk_rssV6VRRname = "//tr[{0}]/td[2]/a";
		
		// Object map declaration for  label to the device host
		
		static final String lbl_deviceHost = "//tr[{0}]/td[5]";
		
		// Object map declaration for checkbox to select device
		
		static final String chk_deviceSelect = "//tr[{0}]/td[1]/input";
		
		// Object map declaration for label for the discovered media
		
		static final String lbl_discoveredCallDevice = "//tr[{0}]/td[12]";
		
		// Object map declaration for link to the discovered media
		
		static final String lnk_discoveredCallDevice = "//tr[{0}]/td[12]/a";
		
		static final String Chk_Discovery = "//table[@id='mpiwidget_form_HoverComboButton_0']/tbody/tr/td[2]/div[1]";
		
		static final String Lnk_contextMenuDiscovery = "//table[@id='mpiwidget_form_HoverComboButton_0']/tbody/tr/td[2]/div[1]";
		
		static final String Lbl_DiscoveryCount = "";
		
		
		
		//*********************************VOD Program******************************************
		
		// On-demand selection from the Program Type listbox 
		static final String lst_ondemand = "label=On-Demand";
		
		//Object map declaration for on-demand program option
	    static final String LNK_OnDemand = "esc_program.type.1";
	    
	    //Object map declaration for program name textbox
	    static final String txt_ProgramName ="name";
	   
	    //Object map declaration for next button 
	    static final String btn_Next_programPage = "//button[@id='_eventId_next']";
	    
	    //Object map declaration for Immediate listing radio button
	    static final String radio_Immediately = "availableDateSetting_3";

	    //Object map declaration for Select button to choose streaming media
	    static final String btn_selectMedia = "//button[@id='selectMedia']";
	   
	    //Object map declaration for browse label on add streaming media popup window
	    static final String lbl_browseMedia = "dijit_layout__TabButton_2";
	    
	    static final String lblsurvey_browseMedia = "dijit_layout__TabButton_6";
	    
	    //Object map declaration for textbox to searching streaming media 
	    static final String txt_SearchMedia = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[1]";
	  
	    //Object map declaration for button to fing streaming media
	    static final String btn_mediaSearch = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[2]";
	    
	    //Object map declaration for Link to select streaming media
	    static final String Lnk_selectMedia = "//div[@id='dijit_layout_ContentPane_8']/div/div/div";
	    
	    //Object map declaration for link button to move teh media to the selected list box
	    static final String lnk_moveToSelected = "//div[@id='dijit_layout_ContentPane_9']/a[2]";
	    
	     //Object map declaration for save button
	    static final String btn_saveSelectedMedia = "mpiwidget_form_ContentSelection_1_submit";
	    
	    // Object map declaration for radio button to choose audience during program creation
		static final String radio_audience = "deliveryType";
		
		//Object map declaration for clicking next button  on Program Delivery Selection Page 
		static final String Btn_Next_Delivery_Select = "_eventId_next";
		
		//Object map declaration for clicking next button  on Content Delivery Option Page 
		 static final String Btn_Next_Delivery = "_eventId_next";
		 
		 static final String Btn_Summary = "//button[3]";
		 
		 //finish button
		 static final String Btn_Finish_Program = "//button[3]";

	     
		 //Video Link in the program
		  static final String lnk_VODProgramsearch= "query";
		  
		  static final String Btn_programsearch="//button[@type='submit']";

		  //Search program
		  static final String Txt_searchProgram= "query";
		  
		  //Search program
		  static final String Btn_searchProgram = "//button[@type='submit']";
//master program variable
		  static final String CHK_masterprogram="makeMaster";
		  
		  static final String Lnk_masterprogram="link=";

		  
		  //***************************************Live Program*****************************************************

		  //Add Program
		  static final String Btn_addProgram = "//table[@id='bindContainer']/thead/tr[1]/td/div[1]/button[2]";
		  
		  //Select ProgramType
		  static final String Select_programType = "selectselectTypeDialogprogramTypes";
		  
		  //Add Program
		  static final String Select_programType_Live = "label=Live Broadcast";
		  
		  //Add Program
		  static final String LivePrgram = "esc_program.type.2";
		  
		  //Add Program
		  static final String Txt_liveProgramName = "name";
		  
		  //Add Program
		  static final String Btn_Next_liveProgram = "_eventId_next";
		  
		  static final String Btn_Summary_liveProgram = "_eventId_summary";
		  
		  //Add Program
		  static final String Lnk_deleteUpcomintOccurrences = "dateDelete_occurrences";
		  
		  static final String Radio_listingImmedtiately = "availableDateSetting_2";
		  
		  static final String Lnk_addEncoder = "//td[@onclick='doItLiveMedia()']";
		  
		  static final String Lst_selectEncoder = "encSel";
		  
		  static final String Lst_selectEncoder_click = "//option";
		  
		  static final String Lst_selectEncoderProfile = "profSelPD";
		  
		  static final String Lst_selectEncoderProfile_click = "//div/select/option";
		  
		  static final String Btn_encoderProfile = "//button[@type='button' and @onclick=\"doProfAdd(get('profSelPD'))\"]";
		  
		  static final String Txt_endPointIP = "aliasValue_0";
		  
		  static final String Chk_allowQuestionBeforeBroadacst = "allowQuestionsBefore";
		  //Add Program
		  static final String Btn_finish_liveProgram = "_eventId_finish";
		  
		  static final String Radio_audience = "deliveryType";
		  
		  //Delivery Option Text
		  static final String Lbl_deliveryOptionText = "//div[3]/div[1]/div[2]/div[{0}]/div[1]";
		  
		  //Delivery Option radio button
		  static final String Radio_deliveryOptionText = "//div[{0}]/div[1]/input";
		  
		  static final String Drp_Filter_Programs = "filterBy";


			//*****************************Live program******************//

			// Object map declaration for select poll button
			
		    static final String btn_selectPollLive = "selectPoll";

			// Object map declaration for search poll text box
			    
		    static final String txt_searchPollLive = "//div[@id='dijit_layout_ContentPane_18']/div[1]/input[1]";

			// Object map declaration for Find button to searching poll
				
		    static final String btn_searchPollLive = "//div[@id='dijit_layout_ContentPane_18']/div[1]/input[2]"; 

			// Object map declaration for link to select the searched poll
			
		    static final String lnk_selectSearchedPoll = "//div[@id='dijit_layout_ContentPane_19']/div/div[1]/div";

			// Object map declaration for button to save selected poll
			
		    static final String btn_selectedSearchedPollLive = "mpiwidget_form_ContentSelection_3_submit"; 

			// Object map declaration for button to select survey
			
		    static final String btn_selectSurveyLive = "selectSurvey";

			// Object map declaration for textbox to search survey
			
		    static final String txt_searchSurveyLive = "//div[@id='dijit_layout_ContentPane_24']/div[1]/input[1]"; 

			// Object map declaration for find button to search survey
			
		    static final String btn_searchSurveyLive = "//div[@id='dijit_layout_ContentPane_24']/div[1]/input[2]"; 

			// Object map declaration for link to select the search the survey
		    static final String btn_searchSurveyLive1 = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[2]"; 
		    
		    static final String txt_searchSurveyLive1 = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[1]"; 
		    static final String lnk_selectSearchedSurvey1 = "//div[@id='dijit_layout_ContentPane_18']/div/div[1]/div";
		    static final String btn_selectedSearchedSurveyLive1 = "mpiwidget_form_ContentSelection_3_submit"; 
			
		 // Object map declaration for link to select the select survey for VOD
		    
		    static final String txt_searchSurveyVOD = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[1]"; 
		    static final String lnk_selectSearchedSurveyVOD = "//div[@id='dijit_layout_ContentPane_18']/div/div[1]/div";
		    static final String btn_selectedSearchedSurveyVOD = "mpiwidget_form_ContentSelection_3_submit"; 
		    static final String btn_searchSurveyVOD = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[2]";  
	    
		    static final String lnk_selectSearchedSurvey = "//div[@id='dijit_layout_ContentPane_25']/div/div[1]/div";

			// Object map declaration for button to save the selected survey
			
		    static final String btn_selectedSearchedSurveyLive = "mpiwidget_form_ContentSelection_4_submit"; 

			// Object map declaration for checkbox to ask question before broadcast 
			
		    static final String chk_questionBeforeBcast = "allowQuestionsBefore";

			// Object map declaration for checkbox to Allow question during broadcast
			
		    static final String chk_questionDuringBcast = "allowQuestionsDuring";

			// Object map declaration for checkbox to enable anonymous question
			
		    static final String chk_questionAskAnonymous = "allowQuestionsAnonymous";

			// Object map declaration for label to check delivery option name
			
		    static final String delivery_text = "//div[3]/div[1]/div[2]/div[{0}]/div[1]";
		    //static final String delivery_text =  "//div[{0}]/div[1]/input";
		    
			// Object map declaration for radiobutton to select delivery option
		    
		    static final String delivery_chk = "//div[2]/div[{0}]/div[1]/input";


			// Object map declaration for audience checkbox
			
		    static final String chk_audience = "//div[2]/div[1]/input";

			// Object map declaration for audience
			
		    static final String chk_audience1 = "//div[2]/div/div[2]/div[1]";

			// Object map declaration for label to the audience text
			
		    static final String audience_text = "//div[2]/div/div[2]/div[{0}]";

			// Object map declaration for checkbox to choose the audience
			
		    static final String audience_chk = "//div[2]/div[{0}]/input";

			// Object map declaration for audience text
			
		    static final String audience_text1 = "//div[@id='set_audiences']/div";

			// Object map declaration for 
			
		    static final String audience_chk1 = "audiences_1";

			// Object map declaration for Text box for endpoint IP 
			
		    static final String txt_EndPointIP = "aliasValue_0";

			// Object map declaration for dropdown for selecting the VRR
			
		    static final String drp_VRR  = "vrr_0";
		   

	   
	   
	
		//***********************************Reports*****************************************
		
		static final String Lnk_reporting="menu_reports_cont";
		static final String Lnk_reports="link=Reports";
		
		//VOD radio button
		static final String Radio_VOD="//input[@name='reportName' and @value='Thick_MediaViewingByViewersVOD']";
		//Content Storage report radio  button
		static final String Radio_ContentStorageReport="//input[@name='reportName' and @value='Thin_Content_Storage_Report']";
		//Next Button
		static final String Btn_Next="//button[@type='submit']";
		
		//select start date from table
		static final String Lbl_start="//td[1]/span";
		
		//select start date textbox from table
		static final String Txt_startdate="startDate_date";
		
		//select end date textbox from table
		static final String Txt_enddate="endDate_date";
		
		//select End date from table
		static final String Lbl_end="//tr[5]/td[7]/span";
		
		//select program from drop down
		static final String Drp_program="input_programId";
		
		//Run Report button
		static final String Btn_runreport="runReportButton";
	
//**********************************EGC channel****************************//
	    
		//Object map declaration for Channel menu link
		
	    static final String LNK_channel = "link=Channels";

		//Object map declaration for button to add channel
		
	    static final String btn_addChannel = "//button[@type='button']";    

		//Object map declaration for textbox for channel name
		
	    static final String txt_channelName = "name";

		//Object map declaration for checkbox to activate channel
		
	    static final String chk_channelActive = "active.channel.listing";

		//Object map declaration for checkbox to enable channel
		
	    static final String chk_egcChannel = "egc.enabled";
	    
	    
      //Object map declaration for checkbox to enable EGC
		
	    static final String chk_egcenabled = "enableEGC";
	    
		//Object map declaration for dropdown to choose master program
		
	    static final String drp_channel_chooseEGCmaster = "egc.template";

		//Object map declaration for button to add EGC author
		
	    static final String btn_addEGC_Author = "//button[@type='button' and @onclick=\"dialogManager.instantiate ('egcAuthorRolePrincipalAssignmentDialog', {} ).show()\"]";

		//Object map declaration for textbox to search EGC author
		
	    static final String txt_searchEGC_Author = "//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[2]/td/input[1]";

		//Object map declaration for Button to Find egc author
		
	    static final String btn_searchEGC_Author = "//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[2]/td/button";

		//Object map declaration for checkbox to select searched egc author
		
	    static final String chk_selectSearchedEGC_author = "//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[4]/td[1]/div/b/div/input";

		//Object map declaration for checkbox to select all the EGC authors searched
		
	    static final String chk_selectSearchedEGC_author1 = "//td[3]/div/div[2]/input";//"//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[4]/td[1]/div/b/div/input";
	    
	    //static final String chk_selectSearchedEGC_author = "defaultdomain-MPI4";
	    
	    static final String lnk_EGCauthor_moveToSelected = "//div[@id='egcAuthorRolePrincipalAssignmentTemplate']/form/table/tbody/tr[5]/td[2]/a[2]";

		//Object map declaration for button to save EGC author
		
	    static final String btn_saveEGCAuthor = "//div[@id='egcAuthorRolePrincipalAssignmentDialog']/div/div/div[1]/div[3]/button[1]";

		//Object map declaration for button to save channel
		
	    static final String btn_saveEGC_Channel = "_eventId_submit";

		//Object map declaration for link to edit channel
		
	    static final String lnk_channel = "//tr[{0}]/td[2]/div/a";

		//Object map declaration for checkbox to select channel
		
	    static final String chk_channel = "//tr[{0}]/td[1]/input";    
	    
	    //Object map declaration for select all channel checkbox
	    
	    static final String chk_selectAllChannel = "allbox";
	    
	    static final String Btn_delete = "delete";
		static final String Chk_selectAll = "allbox";
		 
		static final String Chk_selectDiscoveryDevice = "//tbody[@id='theContent']/tr[2]/td/input";
		static final String Btn_rssdicoveryDeleteConfirmation = "//div[@id='mpiwidget_layout_ConfirmDialog_0']/div[2]/button[1]";
	    
	    //Object map declaration for delete channel button
	    
	    static final String btn_deleteChannel = "delete";
	    
	    //Object map declaration for confirm delete button
	    
	    static final String btn_confirmDeleteChannel = "//div[@id='mpiwidget_layout_ConfirmDialog_0']/div[2]/button[1]";
	     static final String Lnk_asxfile="//div[@id='mpi_util_DebugConsole_0']/div[3]";
	     
		//************************************Add channel***************************************
		
	     
		//add button of channel
		static final String Btn_addchannel="//button[@type='button']";
		
		//Channel name
		static final String TXT_ChannelName = "name";
		
		//channel active/inactive
		static final String TXT_channelactiv="active.channel.listing";
		//content Enabled
		static final String TXT_employeeContent_Enabled="egc.enabled";
 
		
		//EGC author button
		static final String Btn_EGCauthor="//div[@id='grid_egcAuthorsPrincipalsTable_pageTitle']/div/button";
		
		//Search EGC authorBox
		static final String TXT_searchEGCbox_author="//div[2]/div/form/table/tbody/tr[2]/td/input[1]";
		
		//Search EGC author button
		static final String Btn_SearchEGC="//div[2]/div/form/table/tbody/tr[2]/td/button";
		
		//Available Author
		static final String Chk_authorname="//input[@name='defaultdomain-MPI2']";
		
		//Move available author to Assigned through button
		static final String Btn_authormove="//div[2]/div/form/table/tbody/tr[5]/td[2]/a[2]";
		
		//Assign Button
		static final String Btn_assign="//div[4]/div/div/div[1]/div[3]/button[1]";
		
		//channel categories
		 static final String TXT_categoreis="//div[@id='mpiwidget_form_SloshBucket_0']/div[1]/div/div[1]";
		 
		 //move channel
		 static final String Btn_categorymove="//div[@id='mpiwidget_form_SloshBucket_0']/div[2]/a[2]";
		 
			//save channel
		static final String Btn_savechannel="_eventId_submit";
		
		
		//*********************************Add category****************************************************
		
		//Add category button
		static final String Btn_Add_Cat="//button[@type='button']";
		
		//Category name
		static final String Lnk_Cat_Name="//input[@id='name']";
		
		//Category active
		static final String Lnk_Cat_Active="//input[@id='active']";
		//save category
		static final String Btn_Cat_Save="//button[@id='_eventId_submit']";
		//**********************************NV****************************************************
		
	
			
		/********************************Delivery Option**********************************/
			
			//Delivery Option name
			static final String Lnk_deliveryOption = "link=Delivery Options";
			
			//Add delivery option
			static final String Btn_addDeliveryOption = "//table[@id='bindContainer']/thead/tr[1]/td/table/tbody/tr/td[1]/div/button[2]";
			
			
			//Text box to Search delivery option by name
			static final String Txt_searchDO_Name = "doptNameInput";
			
			//Dropdown to search delivery option by Type
			static final String Drp_searchDO_Type = "doptTypeSelect";
			
			//List box to add delivery option
			static final String Lst_addDeliveryOption= "selectselectTypeDialogdoptTypes";
			
			//VideoNet Edge delivery option value in teh list box
			static final String Lst_addDeliveryOption_VideoNet_EdgeDO = "label=VideoNet Edge";
			
			//List box to add delivery option
			static final String Select_VideoNet_edgeDOPT= "dlvryimpl_ve_device";
			
			//Videonet Edge name
			static final String Txt_videoNet_name = "name";
			
			//Visible in Program/Audience
			static final String Chk_visible_in_Program_and_Audience = "assignableToProgram";
			
			//Select Role
			static final String Chk_ServerRole = "//input[@type='checkbox' and @onclick=\"adminMultiCheckAll('roles',this)\"]";
			
			//Proximity CIDR range
			static final String Txt_rangeCIDR_Proximity = "//div[@id='mpiwidget_form_Proximity_0']/div[1]/div/div[2]/div/input[1]";
			
			//Proximity Metric
			static final String Txt_metric_Proximity = "//div[@id='mpiwidget_form_Proximity_0']/div[1]/div/div[2]/div/input[2]";
			
			//Control Host or IP
			static final String Txt_controlHost_or_IP = "managementHost";
			
			//Profile Dropdown
			static final String Drp_Profile = "deviceProfile";
			
			//VideoEdge managed device
			static final String Chk_VideoNetEdge_ManagedDevice = "managedDevice";
			
			//Active check box
			static final String Chk_Active = "active";
			
			//Save VideoNet Edge delivery option
			static final String Btn_saveVideoNetEdge_deliveryOption = "_eventId_submit";
			
			//Cancel link
			static final String Lnk_cancel = "link=Cancel";
			
		/********************************VideoNet Edge Profile******************************/
			
			//VideoNet Edge Delivery Profile 
			static final String Lnk_videoNetEdgeProfile = "link=VideoNet Edge Profiles";
			
			//Add button
			static final String Btn_addVideoNetEdge_Profile = "//button[@type='button']";
			
			//Name textbox
			static final String Txt_nameVideoNetEdge_Profile = "name";
			
			//WMS Service Active checkbox
			static final String Chk_WMS_Service_Active = "wmsServiceActive";
			
			//Enable HTTP streaming
			static final String Chk_enableHTTP_streaming = "wmsHttpStreamingEnabled";
			
			//HTTP port
			static final String Txt_HTTP_port = "wmsHttpStreamingPort";
			
			//RTSP port
			static final String Txt_RTSP_port = "wmsRtspStreamingPort";
			
			//Enable RTSP streaming
			static final String Chk_enableRTSP_streaming = "wmsRtspStreamingEnabled";
			
			//Enable Multicast Checkbox
			static final String Chk_enableMulticast = "multicastEnabled";
			
			//Multicast address
			static final String Txt_multicastAddress = "multicastAddress";
			
			//VOD publishing Point name 
			static final String Txt_vodPP_name = "//div[@id='mpiwidget_form_StoragePublishingPointList_1']/div[1]/input";
			
			//Storage for VOD publishing point
			static final String Drp_vodPP_storage = "//div[@id='mpiwidget_form_StoragePublishingPointList_1']/div[1]/select";
			
			//Add button for VOD publishing point
			static final String Btn_addVOD_PP = "//div[@id='mpiwidget_form_StoragePublishingPointList_1']/div[1]/button";
			
			//Live Named Publishing Point
			static final String Txt_livePP = "//div[@id='mpiwidget_form_MutableList_0']/div[1]/input";
			
			//Add button for live publishing point
			static final String Btn_addlivePP = "//div[@id='mpiwidget_form_MutableList_0']/div[1]/button";
			
			//Save VideoNet Edge Profile
			static final String Btn_saveVideoNetEdge_Profile = "_eventId_submit";
			
	/***********************************Content Page***********************************/		
	
		//Content link 
		static final String Lnk_content ="link=Content";
		
		//Add Item button on Content page	 
		static final String Btn_addItem ="addI";
		
		//Name content header
		static final String Lbl_nameHeader = "link=Name";
		
		//Simple Streaming Media (Hosted) radio button 
		static final String Radio_streamingMedia ="contentTypeRadio_1";
		
		//Image radio button 
		static final String Radio_image ="contentTypeRadio_5";	
		
		//Poll/Survey radio button 
		static final String Radio_poll ="contentTypeRadio_6";	
		
		//Slide radio button 
		static final String Radio_slide ="contentTypeRadio_7";	
		
		//Complex Presentation radio button 
		static final String Radio_complexPresentation ="contentTypeRadio_8";				
		
		//Next button on New Item window 
		static final String Btn_next ="_eventId_next";
		
		//Select File FileUpload field while uploading media
		static final String FileUpld_selectedFile = "mpiwidget_form_FileUpload_0";
		
		//Display Name text box
		static final String Txt_displayName = "displayName";
		
		//Duration text box
		static final String Txt_duration = "duration";
		
		//Video Size drop down
		static final String Drp_videoSize = "predefinedSize";
		
		//video value
		static final String Drp_videoSizeValue = "label=352x288";
		
		//Add question button
		static final String Btn_addQuestion = "addQuestion";
		
		//Question Title
		static final String Txt_questionTitle = "title";		
		
		//Question Type
		static final String Drp_questionType = "type";
		
		//Question type dropdown value
		static final String Drp_questionType_checkbox = "label=Select Box";
		
		//Answer value1
		static final String Txt_answerValue1 = "//div[@id='answersDiv']/div[1]/input[1]";
		
		//Answer value2
		static final String Txt_answerValue2 = "//div[@id='answersDiv']/div[2]/input[1]";
		
		//Answer value3
		static final String Txt_answerValue3 = "//div[@id='answersDiv']/div[3]/input[1]";
		
		//Finish button
		static final String Btn_Finish = "_eventId_finish";
		
		//Advance search link
		static final String Lnk_advSearch = "link=Advanced Search";
		
		//Display Name on Advance search textbox
		static final String Txt_displayName_advanceSearch = "_adv_name";
		
		//Status drop-down on Advance search button
		static final String Drp_status_advSearch = "_advs_status";
		
		//Status dropdown value
		static final String Drp_statuc_advSearch_value = "label=ACTIVE";
		
		//Submit button on Advance search button
		static final String Btn_submit_advSearch = "searchSubmit";

		
		
		//Width text box
		static final String Txt_width ="id=width";
		
		//Height text box
		static final String Txt_height ="id=height";
		
	
	//**********************************Social Viewer Portal**********************************//
	
		//Login link 	 
		static final String Lnk_loginSVP ="loginLink";
		
		//User Name text box on Login page	 
		static final String Txt_loginSVP ="//div[@id='__loginDialog__']/div[2]/input[1]";
		
		//Password text box on Login page	 
		static final String Txt_passwordSVP ="//input[@type='password']";
		
		//Login button on Login page	 
		static final String Btn_loginSVP ="//input[@value='Login']";
		
		//Logout link 
		static final String Lnk_logoutSVP ="logoutLink";			
		
		//application logo
		static final String logo_SVP = "//div[@onclick=\"document.location.href='home.vp';\"]";
		
		//Title image
		static final String img_Qumu_SVP = "fmaInner";
		
		//Featured link on Carousal
		static final String Lnk_featuredCarousal = "link=Featured";
		
		//Live link on Carousal
		static final String Lnk_liveCarousal = "link=Live";
		
		//Browser link on Juke box
		static final String Lnk_browserJukeBox = "link=Browse";
		
		//Show All link on Juke box
		static final String Lnk_showAllJukeBox = "link=Show All";
		//Login link 	 
		//Logout link 
		static final String lnk_LoginSVP = "link=Login";
	    
	    static final String txt_userNameSVP = "//div[@id='__loginDialog__']/div[2]/input";
	    
	    static final String txt_passwordSVP = "//input[@type='password']";
	    
	    static final String btn_loginSVP = "//input[@value='Login']";
	    
	    static final String lnk_logOutSVP = "logoutLink";
	
	//**********************************Classic Viewer Portal**********************************//
	
	    //Home page link
	    static final String tab_HomeCVP = "link=Home";
	    
	    //Search text box
	    static final String txt_SearchCVP = "hdrSearchQuery";
	    
	    //Button for Search
	    static final String btn_SearchCVP = "hdrSearchBtn";
	    
		//Login link 	 
		static final String Lnk_loginCVP ="loginLink";
		
		//User Name text box on Login page	 
		static final String Txt_loginCVP ="principalID";
		
		//Password text box on Login page	 
		static final String Txt_passwordCVP ="password";
		
		//Login button on Login page	 
		static final String Btn_loginCVP ="//input[@value='Login']";
		
		//Logout link
		static final String Lnk_logoutCVP = "logoutLink";
		
		//Logout link
		static final String Txt_logoutCVP = "Logout";
		
		static final String Txt_login="Login";
		
		//Select Time Zone dropdown
		static final String Drp_selectTimeZone = "tzSelection";
		
		//TimeZone select button
		static final String Btn_selectTimeZone = "tzSelectButton";
		
		//application logo
		static final String logo_CVP = "//div[@id='logoDiv']/a/img";
		
	    //link show all
	    static final String  LNK_home="link=Home";
	    
	    //link show all
	    static final String  LNK_program="link=Programs";
	    
	  //type program 
	    static final String TBX_SearchCVP="hdrSearchQuery";
	    //search button
	    
	    static final String Btn_SearchCVP="hdrSearchBtn";
	    
	    //choose video link
	 
	    static final String LNK_Searchresultvideo ="link=";
	   
	
        static final String txt_userNameCVP = "principalID";
	    
	    static final String txt_passwordCVP = "password";
	    
	    static final String btn_loginCVP = "//input[@value='Login']";
	    
	    static final String lnk_logOutCVP = "logoutLink";
	    
	    
	    static final String txt_privateCode = "privateCode";
	    
	    static final String btn_privateCodeSub = "privateCodeSubmit";
		
		//**************************************Social Viewer Portal****************************************
		
		//Select Time Zone drop down
	    static final String drp_selectTimeZoneCVP = "tzSelection";
	    
	    //Select Time Zone drop down value
	    static final String drp_selectTimeZone_valueCVP = "label=(GMT-8:00) Pacific Standard Time";
	    
	    //Select Time zone button
	    static final String btn_selectTimeZoneCVP = "tzSelectButton";
	    
	    //link show all
	    static final String  LNK_showall="link=Show All";
	    //search program 
	    static final String TBX_SearchSVP="document.forms[6].elements[0]";
	    
	    //arrow link
	    static final String ICN_SearchBoxArrowlinkSVP="//div[3]/table/tbody/tr[1]/td/form/div/a[2]";
	    
	    //choose video link
	    static final String LST_Searchresult = "//div[5]/div[3]/div/div[{0}]/a[2]";
	    
	    static final String Var_asxLink = "//div[@id='mpi_util_DebugConsole_0']/div[3]";
	    
	   
		static final String lbl_pinStatusAutomatedSummaryPageSVP = "//div[10]/div[4]/div[3]/div[2]";
		static final String lbl_pinStatusVODSummaryPageSVP = "//div[9]/div[4]/div[3]/div[2]";
	     

	    
//**********************************POQO**********************************//
		
		//POQO Login link 	 
		static final String Lnk_loginPoqo ="link=Login";
		
		//POQO Test Connection button 
		static final String Btn_saveconfigpoqo="execute";
		
		//User Name text box on Poqo Login page	 
		static final String Txt_UsernamePoqologin = "j_username";
		
		//Password text box on Poqo Login page	 
		static final String Txt_PasswordPoqologin = "j_password";
		
		//Submit Query button on Poqo Login page	 
		static final String Btn_loginPoqo = "submit";
		
		//POQO Logout link 
		static final String Lnk_logoutPoqo="link=Logout";
		
		//POQO Config link 
		static final String Tab_Config="link=Config";
		
		//POQO Web Service Host text box 
		static final String Tbx_WebServiceHost="wsHost";
		
		//POQO Web Service Host text box 
		static final String Tbx_WebServicePort="wsPort";
		
		//POQO Web Service Host text box 
		static final String Tbx_WebServiceDomain="wsDomain";
		
		//POQO Web Service Host text box 
		static final String Tbx_DefaultChannel="defaultChannel";
		
		//POQO Test Connection button 
		static final String Btn_TestConnection="//button";
		
		static final String Txt_browsepoqo="mediaFile";
		
		
		static final String lnk_samplepage="link=Sample Page";
		
		static final String Btn_standalonevideo="//input[@value='Add Stand Alone Video']";
		
		static final String Txt_poqovideofilename="sav_title";
		
	
		static final String Btn_addVideo="//input[@value='Create']";
		
		
		static final String Lbl_ProgName_MyVideos = "//div[{0}]/table/tbody/tr[1]/td/div";
		
		static final String Btn_Preview_MyVideos = "//div[{0}]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/button[1]";
		
		static final String Img_getASX = "//a[@id='metafile_render']/img";
		
		static final String Btn_ExtractVideoLibrary = "//input[@value='Add Video Library Extract']";
		
		static final String Txt_TitleExtractVideoLibrary = "extract_title";
		
		static final String Btn_CreateExtractVideoLibrary = "//input[@value='Create' and @type='button' and @onclick=\"createExtractVl(); hideForm('#extractLibraryCreate_container'); return false;\"]";
		
		
		static final String Lbl_videoLibrary = "//body/div[2]/div[{0}]/div[1]";
		
		static final String Lnk_ProgName_Library = "//div[3]/div[{0}]/div/a/span";
		
//************************************Add Encoder*****************************************
		
		static final String Btn_Add_Encoder="//button[@type='button']";
		
		// Object map declaration for clicking Windows Media Encoder option.
		 
		static final String LNK_WME  = "//option[@id='winEnc1']" ;
		
		//Object map declaration for the panel for selecting the Windows Media Encoder
		
		static final String SelectType_Enc="//select[@id='selectselectTypeDialogencoderTypes']";
		
		// Object map declaration for providing the WME name
		 
		static final String TXT_WME_Name = "//input[@id='name']";
		
		// Object map declaration for providing the Host machine address for the WME.
		 
	    static final String TXT_WME_Host = "//input[@id='hostAddress']";
		
	    //Object map declaration for providing the Qumu Encoder Service Port number.
		
	    static final String TXT_WME_CommPort = "//input[@id='commPort']";
		
	    // Object map declaration for providing the WME Document Root path
		 
	    static final String TXT_WME_DocRoot = "//input[@id='docroot']";
		
	    //Object map declaration for adding the WME profile
		
	    static final String Btn_AddWMEProfile = "//button[@type='button']";
	    
	    // Object map declaration for providing the WME profile name.
		 
	    static final String TXT_WMEProf_Name = "//input[@id='name']";
	   
		
	    // Object map declaration for selecting the VideoSize
		 
	    static final String Drp_WMEProf_VideoSize = "//select[@id='videoSize']";
		
	    // Object map declaration for providing the Bitrate
		 
	    static final String TXT_WMEProf_Bitrate = "//input[@id='bitRate']";
		
	    // Object map declaration for providing the encoder stream URL
		 
	    static final String TXT_WMEProf_ExtURL = "//input[@id='publicURL']";
		
	    // Object map declaration for providing the server port
		
	    static final String TXT_WMEProf_Port = "//input[@id='serverport']";
	    
	 // Object map declaration for clicking the radio button option (to user the .wme file)
		 
	    static final String Radio_WMEProf_wmeFile = "//input[@id='usewmefilename_1']";
		
	    // Object map declaration for providing the .wme file (profile settings) path
		 
	    static final String TXT_WMEProf_Path = "//input[@id='wmefilename']";
		
	    // Object map declaration for clicking save button for WME profile.
		 
	    static final String Btn_Save_WMEProf = "//button[@id='_eventId_submit']";
	    
	 // Object map declaration for clicking save button for the WME
		 
	    static final String Btn_Save_WME = "//button[@id='_eventId_submit']";
		
		//***************************************LBC*****************************************************************
	    static final String Lnk_contextMenu = "//table[@id='mpiwidget_form_HoverComboButton_0']/tbody/tr/td[2]/div[1]";
		  
		  static final String Lnk_broadcastsContextMenu = "bcastInstMenuContainer_text";
		  
		  static final String Lnk_LaunchNow_ContextMenu = "dijit_MenuItem_7_text";
		  
		  static final String Select_LBC = "lbc_false_esc_program";
		  
		  static final String Btn_Save_LBC_Summary = "archSubmit";
		  static final String Btn_Save_LBC_tab="//div[@id='lbcTabSummary']/span";
		  
		  static final String Tab_BroadcastControl = "lbcTabControl";
		  
		  static final String Btn_Start_Source = "startSourcesButton";

		  static final String Btn_Prov_Network = "provisionNetworkButton";

		  static final String Btn_Start_Bcast = "startBroadcastButton";
		  
		  static final String Btn_Stop_Bcast = "stopBroadcastButton";
		// Object map declaration for broadcast control tab
		    
		    static final String tab_broadcastControlLBC = "//div[@id='lbcTabControl']/span";
		 // Object map declaration for image for the audience question 
		    
		   static final String img_audienceQuestionLBC = "//div[@id='mpiwidget_lbc_Questions_0']/div[3]/div[1]/div/div[4]/img";
		   
		 //************************Live Broadcast Control****************************//
			
			// Object map declaration for clicking LBC icon
			 
			static final String LNK_LBC = "//img[@alt='Live Broadcast']";
			
			// Object map declaration for Launching LBC 
			 

			static final String LNK_Launch_Now = "link=Launch Broadcast Now";
			
			
			//Object map declaration for Flipping Slides
			
			static final String Btn_Flip_Slide = "//img[@title='Next Slide']";
			
			// Object map declaration for Archiving(Checkpoint that Broadcast is started)
			
			static final String Btn_Pause_Archive = "pauseArchivingButton";
			
			// Object map declaration for checkbox to enable archiving for the live broadcast
			
		    static final String chk_ArchiveLBC = "//td[1]/input";
		    
		    static final String Txt_ArchiveProgram="//tbody[2]/tr/td[2]/input";
		    
		    // Object map declaration for Link to push poll
		    
		    static final String lnk_pushPoll = "//img[@title='Start Poll']";

		    // Object map declaration for Link push poll result 
		    
		    static final String lnk_pushPollResult = "//img[@title='Push Results to Viewers']";

		    // Object map declaration for link question moderation link
		    
		    static final String lnk_askModeratorQuestion = "showAskQuestionBox";

		    // Object map declaration for broadcast control tab
		    
		    static final String tab_broadcastControl = "//div[@id='lbcTabControl']/span";

		    // Object map declaration for Stop broadcast button
		    
		    static final String btn_stopBroadcast = "stopBroadcastButton"; 

		    // Object map declaration for image for the audience question 
		
			
		
		    static final String Img_broadcastConsole="//div[@id='consoleLog']/div/img";
		    
     
		    
		    static final String Txt_pollresultwindow = "pollresult";
		    
		   static final String Txt_pollanswer="//table/tbody/tr/td/div/div/span[@value='ejsc-hint']/span[text()='1']/b[text()='Answer:']";
		   
		   
		   static final String Txt_pollresponse="//table/tbody/tr/td/div/div/span[@value='ejsc-hint']/span[text()='1']/b[text()='Responses:']";
		    
		   static final String Txt_pollresultwindowsvp="//div[@id='mpi_vp_Chart_0']/div[@class='titleBar']";
		    
		   
		   static final String Txt_pollresultanswersvp="//body/center/div[@id='mpi_vp_Chart_0']/div[@class='contents']/div/div/span[@class='ejsc-hint']/span[text()='Answer: 1']";
		    
		   static final String Txt_pollresultvotesvp="//body/center/div[@id='mpi_vp_Chart_0']/div[@class='contents']/div/div/span[@class='ejsc-hint']/span[text()='Vote: 1']";
		    
          static final String Btn_crosspollresult="//div[@id='mpi_vp_Chart_0']/div[@class='titleBar']/img[@class='closeButton']";
            
			//******************************Hundson********************************//
			
			static final String Lnk_vccallContinuous = "link=vcc-all-continuous-600";
			
			static final String Img_buildSuccess = "//img[@alt='Success']";
			
			static final String Lnk_latestBuild = "//tr[{0}]/td[2]/a";
			
			static final String Lnk_buildSuccess = "//div[2]/table/tbody/tr[{0}]/td[1]/img";
			
			static final String Lbl_buildNumber = "//div[2]/table/tbody/tr[{0}]/td[1]";
			
			static final String Lnk_adminportal = "link=Qumu Video Control Center";
			
			static final String Lnk_adminportalFile = "link=adminportal.war";
			
			static final String Lnk_viewerportal = "link=Qumu Viewer Portal";
			
			static final String Lnk_viewerportalFile = "link=viewerportal.war";
			
			static final String Lnk_serviceportal = "link=Mr. Humphries";
			
			static final String Lnk_serviceportalFile = "link=serviceportal.war";
		
	
		//**************************************WMS Delivery option***********************************
			//Object map declaration for the Delivery Options page. 
			 
			static final String LNK_DeliveryOption= "//a[contains(text(),'Delivery Options')]";	

			//Object map declaration for Add Delivery button. 
			 
			static final String Btn_Adddelivery = "//button[2]";	
			
			
			//***************Windows Media Server**********************
			
			//Object map declaration for selecting the WMS Delivery Options. 
			
			static final String LNK_selectWMSdelivery = "//option[@id='dlvryimpl_ve_device']";

			//Object map declaration for providing the WMS name. 
			 	
			static final String TXT_WMSName = "//input[@id='name']";
			
			//Object map declaration for providing the WMS name. 
			 	
			static final String TXT_Host = "//input[@id='host']";
			
			// Object map declaration for selecting MMS protocol
			 
			static final String CHK_MMS = "//input[@id='supportsMms']";
			
			// Object map declaration for selecting RTSP protocol
			 
			static final String CHK_RTSP = "//input[@id='supportsRtspStreaming']";
			
			// Object map declaration for selecting HTTP protocol
			
			static final String CHK_HTTP = "//input[@id='supportsHttpStreaming']";
			
			// Object map declaration for selecting HTTP port
			 
			static final String TXT_HTTP_Port = "//input[@id='httpPort']";
			
			//Object map declaration for enabling WebService
			
			static final String CHK_WebServiceEnabled = "//input[@id='soapEnabled']";
			
			// Object map declaration for enabling WebServiceUserName
			 	
			static final String TXT_WebServiceUserName = "//input[@id='soapUser']";
			
			// Object map declaration for enabling WebservicePassword
				
			static final String TXT_WebServicePassword = "//input[@id='soapPassword']";
			
			// Object map declaration for enabling WebserviceConfirmPassword
			 	
			static final String TXT_WebServiceConfirmPassword = "//input[@id='soapPassword_confirm']";
			
			// Object map declaration for adding Access Point
			 
			
			static final String Btn_AddAccessPoint = "//button[@value='dummy']";
			
			// Object map declaration for adding Live Access Point
			 
			
			static final String LNK_Live= "//option[@id='addLIVEAp']";
			
			// Object map declaration for providing 
			 
			
			static final String TXT_APName = "//input[@id='name']";
			
			// Object map declaration for providing 
			
			static final String CHK_Rebroadcast = "//input[@id='streamVOD']";
			
			// Object map declaration for providing 
				
			static final String CHK_Unicast = "//input[@id='unicastEnabled']";
			
			// Object map declaration for providing 
				
			static final String CHK_Multicast = "//input[@id='multicastEnabled']";
			
			// Object map declaration for providing 

			static final String Btn_SaveAP = "//button[@id='_eventId_submit']";
			
			// Object map declaration for providing 
				
			static final String Btn_SaveDeleveryOption = "//button[@id='_eventId_submit']";

			// Object map declaration for providing 
			
			
			static final String SelectType_DO_WMS = "//select[@id='selectselectTypeDialogdoptTypes']";

			// Object map declaration for providing 
			 
			static final String SelectType_AP = "//select[@id='selectselectTypeDialogapTypes']";
			
			 //**********************************Create the RSS4000v5 encoder****************************// 
		    
			//Object map declaration for Resources Menu 
			
			static final String LNK_Resources = "//div[@id='menu_resourcebin_cont']";
			
			// Object map declaration for Storage link under Resources 
			 
			static final String LNK_Storage = "//a[contains(text(),'Storage')]";
			
			// Object map declaration for Encoders link under Resources
			 	
			static final String LNK_Encoders = "//a[contains(text(),'Encoders')]";
			
			//Object map declaration for encoder list
			
		    static final String lst_rss2k = "selectselectTypeDialogencoderTypes";
		    
			//Object map declaration for RSS Encoder option
			
		    static final String lnk_rss2k = "RSSEncType";
		    
			//Object map declaration for name textbox
			
		    static final String txt_rss2kEncName = "name";
		    
			//Object map declaration for Host address textbox
			
		    static final String txt_rss2kHostIP = "hostAddress";
		    
			//Object map declaration for username textbox
			
		    static final String txt_rss2kEncUserName = "user";
		    
			//Object map declaration for RSS version dropdown
			
		    static final String drp_rss2kVerSelect = "version";
		    
			//Object map declaration for button for Encoder profile
			
		    static final String btn_rss2kEncProfile = "//button[@type='button']";
		    
			//Object map declaration for encoder profile name text box
			
		    static final String txt_rss2kProfName = "name";
		    
			//Object map declaration for encoder profile video size dropdown
			
		    static final String drp_rss2kProfVideoSize = "videoSize";
		    
			//Object map declaration for video size dropdown value
			
		    static final String drp_rss2kProfVideoSizeValue = "label=320x240";
		    
			//Object map declaration for bitrate
			
		    static final String txt_rss2kProfBitRate = "bitRate";
		    
			//Object map declaration for H239 checkbox 
			
		    static final String chk_rss2kProfH239 = "DUALVIDEO";
		    
			//Object map declaration for save profile button
			
		    static final String btn_rss2kProfSave = "_eventId_submit";
		    
			//Object map declaration for password text box
			
		    static final String txt_rss2kPassword = "password";
		    
			//Object map declaration for confirm password textbox
			
		    static final String txt_rss2kConfirmPassword = "password_confirm";
		    
			//Object map declaration for save btton
			
		    static final String btn_rss2kSave = "_eventId_submit";
		    
		  //**********************************Add Poll/Survey****************************// 

		    
		  //Object map declaration for Content Item	
			
			static final String LNK_Content = "link=Content";
			
			// Object map declaration for Add Content
			
			static final String Btn_AddItem = "addI";
			
			//Object map declaration for selecting Content Item
			
			static final String Rbtn_Slides = "contentTypeRadio_7";
			
			// Object map declaration for Clicking Next button
				
			
			// Object map declaration for Clicking Next button
			
			static final String TXT_Selected_File = "mpiwidget_form_FileUpload_0";
			
			//static final String TXT_Selected_File = "mpiwidget.form.FileUpload"	;
			
			//Object map declaration for Clicking Next button
			 	
			static final String Btn_Upload_Next = "_eventId_next";
			
			// Object map declaration for providing Content display name
				
			static final String TXT_Display_Name = "displayName";
			
			// Object map declaration for clicking Finish button
				
			static final String BTN_Finish_Content = "_eventId_finish";
			
			// Object map declaration for clicking More button to search
				
			static final String BTN_More_Search = "link=Advanced Search";
			
			// Object map declaration for providing selecting Name field to search
				
			static final String TXT_Search_Name = "_adv_name";

			// Object map declaration for providing selecting Name field to search
			 	
			static final String Btn_Search = "searchSubmit";
			
			// Object map declaration for Selecting Content
			
			static final String LNK_Content_Exist = "link=Slide001";
			// Object map declaration for Poll radio button
			 
		    static final String radio_contentTypePoll = "contentTypeRadio_6";

			// Object map declaration for Poll display name textbox
			 
		     
		    static final String txt_pollDispName = "displayName";

			// Object map declaration for Add question btn
			 
		    static final String btn_addQuestion = "addQuestion";

			// Object map declaration for question display name textbox
			  
		    static final String txt_questionDispName = "displayName";

			// Object map declaration for question explanation textbox
			 
		    static final String txt_questionExplanation = "title";

			// Object map declaration for question type dropdown
			 
		    static final String drp_questionType = "type";

			// Object map declaration for answer value1 textbox
			 
		    static final String txt_questionAnswer1 = "answerValues";

			// Object map declaration for answer value2 textbox
			 
		    static final String txt_questionAnswer2 = "//div[@id='answersDiv']/div[2]/input[1]";

			// Object map declaration for answer value3 textbox 
			 
		    static final String txt_questionAnswer3 = "//div[@id='answersDiv']/div[3]/input[1]";

			// Object map declaration for save question button
			 
		    static final String btn_questionSave = "_eventId_finish";

		  //**********************************Verify Un-approved Program****************************//
		    
		    //Object Map declaration for checkbox to approve program
		    
		    static final String chk_approveProram = "programApprovalRequired";

		    //Object Map declaration for link to edit domain
		    
		    static final String lnk_editDomain = "//a[contains(@href, 'domainEdit.do?domainId=esc_domain:";
		    
		    //Program Name link
		    static final String lnk_programNameCVP = "link=";
		   
		    //Object for Approve Program menu
		    static final String lnk_approveProgram = "link=Approve Programs";
		    
		    //Object for Approve status dropdown
		    static final String drp_approvalStatus = "filterBy";

		    //Label prefix to the dropdown for the approval status on Approve Programs page
		    
		    static final String drp_approvalStatusValue = "label=";   
		    
		  //*********************Live_Program_CVP****************************	
			
			static final String window_pollCVP = "poll";
			
			static final String poll_answerOptionCVP ="//td/input";
			static final String poll_answerSubmitCVP ="polSubmit";
			
			//static final String poll_answerOptionCVP = "//option[2]";
			static final String survey_answerCVP = "//td/input";	
			//static final String poll_answerSubmitCVP = "submit";
			
			static final String tab_qaCVP = "//div[@id='playerTabs']/div[1]/div[3]/div/span[1]";
			
			static final String txt_questionCVP = "qText";
			
			static final String btn_questionSubmitCVP = "qSub";
			
			static final String tab_slideCVP = "//div[@id='playerTabs']/div[1]/div[1]/div/span[1]";
			
			//static final String survey_answerCVP = "//option[2]";
			
			static final String btn_answerSubmitSurvey = "submit";
			
			static final String survey_answerselection = "//select";
			static final String poll_answerselection = "//select";
			
			
			static final String survey_answerselectionlabel = "label=1";
	
			
			
		    
			//*****************Object Map for Programs*************
			
			
			//Object map declaration for opening Programs 
			
			static final String LNK_Programs = "//a[contains(text(),'Programs')]";
			
			//Object map declaration for Click Add button in programs 
			 
			static final String Btn_Add_Program = "//button[2]";
			
			static final String Select_Program_Live = "label=Live Broadcast";
			
			// Object map declaration for selecting Program Panel in programs 
			
			static final String SelectType_Program_Live = "//select[@id='selectselectTypeDialogprogramTypes']";
			
			//Object map declaration for Click Live Broadcast in programs 
			 
			static final String LNK_Live_Broadcast = "//option[@id='esc_program.type.2']";
			
			//Object map declaration for providing Live program name 
			 
			static final String TXT_Program_Name = "//input[@id='name']";
			
			//Object map declaration for selecting Channel 
			 
			static final String Dropdown_channel = "//select[@id='selectedChannel']";
			
			//Object map declaration for selecting Channel 
			 
			static final String Btn_Next_Prog_Info = "//button[@id='_eventId_next']";
			
			// Object map declaration for selecting Start Listing
			 
			static final String Radio_btn_Immediately = "//input[@id='availableDateSetting_2']";
			
			//Object map declaration for Adding Encoder
			 
			static final String Btn_Add_Enc = "//td[@onclick='doItLiveMedia()']";
			
			//Object map declaration for Adding Encoder
			 
			static final String SelectType_Add_Encoder_Panel = "encSel";
			
			//Object map declaration for clicking Encoder 
			
			//static final String LNK_Select_Enc = "//option[@value='enc_encoder:1015']";
			
			static final String LNK_Select_Enc = "//select[@id='encSel']/option";
			
			//option[@value='enc_encoder:302']
			
			//Object map declaration for Adding Encoder profile
			
			static final String SelectType_Add_Encoder_Profile = "profSelPD";
			
			// Object map declaration for Selecting Encoder profile
			 
			//static final String LNK_Select_Profile = "//option[@value='enc_encpfil:1014']";
			static final String LNK_Select_Profile = "//select[@id='profSelPD']/option";
			
			// Object map declaration for clicking Add Encoder Profile
			 
			static final String Btn_Add_Profile = "//button[@type='button' and @onclick=\"doProfAdd(get('profSelPD'))\"]";
			
			//Object map declaration for clicking Next button Program Listing page
			 
			static final String Btn_Next_Prog_Listing = "//button[@id='_eventId_next']";
			
			// Object map declaration for clicking select button for Slides
			
			static final String Btn_Select_Slides = "selectSlideDeck";
			
			
			// Object map declaration for selecting  Search field
			
			//static final String LNK_Search_Field = "dijit_layout__TabButton_5";
			
			static final String LNK_Search_Field = "dijit_layout__TabButton_5";
			
			//Object map declaration for selecting Search Panel
			 
			static final String SelectType_Search_Panel = "//div[@id='dijit_layout_ContentPane_12']/div[1]/input[1]";
			
			// Object map declaration for Clicking Search button
			 
			static final String Btn_Search_Slides = "//div[@id='dijit_layout_ContentPane_12']/div[1]/input[2]";
			
			//Object map declaration for selecting Slides
			
			static final String LNK_Select_Slides = "//div[@id='dijit_layout_ContentPane_13']/div/div/div";
			
			//Object map declaration for clicking Save button for Slides 
			 
			static final String Btn_Save_Slides = "mpiwidget_form_ContentSelection_2_submit";
			
			// Object map declaration for clicking next button  on Program Content Page 
			 
			static final String Btn_Next_Content = "_eventId_next";
			
			//Object map declaration for clicking next button  on Program Delivery Selection Page 
			 
		
			
	
			 
			//static final String Radio_Btn_Select_HTTP = "dgDOWNLOAD___3_opt";
			
			static final String Radio_Btn_Select_HTTP = "dgDOWNLOAD___1_opt";
			//Object map declaration for selecting WMS Delivery Option 
			 
			//static final String Radio_Btn_Select_WMS = "dgLIVE___media_formattype_windows_4_opt";
			static final String Radio_Btn_Select_WMS = "dgLIVE___media_formattype_windows_1_opt";
			
			//Object map declaration for clicking next button  on Content Delivery Option Page 
			 
			
			 
			
			
			// Object map declaration for clicking in Program Search field
			 
			static final String LNK_Search_Program = "query";

			// Object map declaration for selecting Search Panel
			 
			static final String SelectType_Search_Program = "query";
			
			// Object map declaration for selecting Search Panel
			
			static final String Btn_Search_Program = "//button[@type='submit']";
			
			// Object map declaration for Live program Existence
			 
			static final String LNK_Live_Program = "id";	
			
			//Object Map declaration for deleting upcoming occurrence
			
			static final String lnk_deleteUpcomingOccurrence = "dateDelete_occurrences";
			
			 static final String btn_submitSurveyCVP = "submit";
			//ObjectMAp declaration for radio button for On demand Survay Summary report
			    
			 static final String radio_onDemandSurveySummary = "//input[@name='reportName' and @value='OnDemand_Program_Survey_Summary']";
			 
			 
			 //ObjectMAp declaration for Next button on Reports page
			    
			  static final String btn_reportNext = "//button[@type='submit']";
			  static final String drp_selectProgramReport = "input_programId";
			  			  
			  //ObjectMAp declaration for radio button to select Liv eProgram Survey Summary Report
			    
			    static final String radio_LiveProgramSurveySummary = "//input[@name='reportName' and @value='Live_Program_Poll_Summary']";

			    //ObjectMAp declaration for dropdown to select POll or Survey option
			    
			    static final String drp_SelectPollorSurvey= "input_pollOrSurvey";
			  
			    //ObjectMAp declaration for survey text
			    
			    static final String txt_Survey="label=Survey";
			    
			    //Survey window
			    static final String LNK_SurveyWindow= "//div[@id='mpi_vp_Polls_0']/div[1]/span";
			    //select answer on survey pop up window
			    static final String CHK_SurveyWindow= "//div[@id='mpi_vp_Polls_0']/div[2]/div[2]/form/input[1]";
			    
			  // Submit button for submitting the answer on survey
			    static final String btn_SubmitSurveyanswer="Submit";

			    
			    		    
				//Object Map declaration for selected domain Name link
				
				static final String LNK_selecteddomainName="//a[contains(@href, 'domainEdit.do?domainId=esc_domain:";
				
				//Object Map declaration for EGC program Approval checkbox
				static final String CHK_EGCApprovalRequiredchkbox = "egcApprovalRequired";
				
				//Object Map declaration for Enable Employee Generated Content checkbox
				static final String Chk_EnableEmployeeGeneratedContent="enableEGC";
				
				
				//Object map declaration to Save the Domain
				

			    //**********************************Upload EGC program SVP****************************// 
			    
			    
			    static final String lnk_AddProgram_SVP = "//a[@id='ingestLink']/span";
			    
			    static final String lnk_MyVideoSVP = "//a[@id='myProgsLink']/span";
			    
			    static final String txt_egcProgramNameSVP = "title";
			        
			    static final String fileUPl_egcStreamingMediaSVP = "file"; 
			    
			    static final String btn_egcSaveprogramSVP = "save";
			
			    static final String btn_egcSubmitprogramSVP="//input[@value='Submit for Approval']";  
	            static final String drp_egcchannel="channelTemp";
	            
	            static final String lnk_egc_rename="renLink";
	            
	            //************************SVP links under My Video************   
	            static final String LNK_EditVODProgram = "link=Edit";


	    		//*****************Create User********************//
	    		
	    		
	    		//Object map declaration for the User Management menu
	    		
	    	    static final String LNK_userManagement = "menu_security_cont";
	    	    
	    		//Object map declaration for the User page 
	    	    
	    	    static final String LNK_Users = "link=Users";    
	    	    
	    		//Object map declaration for the Add user button
	    	    
	    	    static final String btn_AddUser = "add_button";
	    	    
	    		//Object map declaration for the First name text box
	    	    
	    	    static final String txt_firstName = "firstName";
	    	    
	    		//Object map declaration for the Last name text box 
	    	    
	    	    static final String txt_lastname = "lastName";
	    	    
	    		//Object map declaration for the email text box
	    	    
	    	    static final String txt_Email = "email";
	    	    
	    		//Object map declaration for the password text box
	    	    
	    	    static final String txt_Password = "password";
	    	    
	    		//Object map declaration for the confirm text box 
	    	    
	    	    static final String txt_confirmPassword = "password_confirm";
	    	    
	    		//Object map declaration for the submit button
	    	    
	    	    static final String btn_saveUser = "_eventId_submit";
	    	  //************************************* //Transcoding //****************************************************************************************************************//   
	            
	             static final String lnk_TranscodingNodes = "link=Transcoding Nodes";
	             static final String BT_AddNode = "//button[@type='button']";
	             
	             static final String opt_selectNodeType= "selectselectTypeDialognodeTypes";
	             static final String val_nodevalue= "label=Anystream Agility";
	             static final String btn_transcodenode= "transcode_anynode";
	             static final String txt_transcodenodename= "name";
	             static final String txt_transcodenodehost= "hostName";
	             static final String txt_transcodeinputfolder= "inputFolder";
	             static final String txt_transcodeoutputfolder= "outputFolder";
	             static final String btn_transcodeloadprofilebtn= "node_LoadButton";
	             static final String tbl_transcodeprofiletable= "//table[@id='profileTable']/tbody/tr[3]/td[1]";
	             static final String btn_Submitnodecreation= "_eventId_submit";
	             static final String lst_transcodetextfield= "transSel";
	             static final String lst_transcodeprofilefield= "profSelPD";
	             static final String btn_starttranscoding= "_eventId_save";
	             
	             
	             static final String btn_transcodeEvent="_eventId_transcode";
	             static final String icn_Closewindow="//div[@id='newItemDialog']/div[1]/span[2]";
	             
	             static final String lnk_transcodedfirstfilename="//tr[2]/td[2]/a";
	             static final String icn_transcodedfirstfileingesticon= "//a[3]/img";
	             
	             static final String tbl_transcodedprofilelisttable="//table[@id='profileTable']/tbody/tr[13]/td[2]";
	             static final String lnk_transcodingprofiletext= "//tr[{0}]/td[2]/a";
	             
	             static final String chk_transProfilechkbox ="//tr[{0}]/td[1]/input";
	             static final String lnk_transcodedfilename="//tr[{0}]/td[2]/a";
	             static final String icn_transcodedfileicn="//tr[{0}]/td[6]/a[3]/img";
	             //**********************************Media Editor****************************//
		    	    
		    	    //Button for Select Slide
		    	    static final String btn_AttachSlide = "selectSlideDeck";
		    	    
		    	    //Text box for search slide
		    	    static final String txt_searchSlide = "//div[@id='dijit_layout_ContentPane_1']/div[1]/input[1]";
		    	    
		    	    //button for Find Slide
		    	    static final String btn_findSlide = "//input[@value='Find']";
		    	    
		    	    //Link to select the searched slide
		    	    static final String lnk_selectSlide = "//div[@id='dijit_layout_ContentPane_2']/div/div/div";
		    	    
		    	    //Button to save the selected slide
		    	    static final String btn_saveSelectedSlide = "mpiwidget_form_ContentSelection_0_submit";    
		    	    
		    	    //Button to Launch the media editor
		    	    static final String btn_LaunchMediaEditor = "_eventId_trim";
		    	    
		    	    //Button to add caption
		    	    static final String btn_addCaption = "addCaptionBtn";
		    	    
		    	    //Text box to add the caption time stamp
		    	    static final String txt_captionTimeStamp = "seEdit_timestamp_caption";
		    	    
		    	    //Text box to add the caption text
		    	    static final String txt_addCaption = "seEdit_text_caption";
		    	    
		    	    //Button to save the added caption
		    	    static final String btn_saveCaption = "seEdit_save_caption";
		    	    
		    	    //Button to add a new chapter
		    	    static final String btn_addChapter = "addChapterBtn";
		    	    
		    	    //Text box to add a chapter time stamp
		    	    static final String txt_chapterTimeStamp = "seEdit_timestamp_chapter";
		    	    
		    	    //Text box to add teh chapter title
		    	    static final String txt_chapterName = "seEdit_name_chapter";
		    	    
		    	    //Text box to add the chapter description
		    	    static final String txt_chapterDesc = "seEdit_text_chapter";
		    	    
		    	    //Button to save the added chapter
		    	    static final String btn_saveChapter = "//div[@id='chapterEdit']/table/tbody/tr[2]/td/div/input[2]";
		    	    
		    	    //Button to add slide
		    	    static final String btn_addSlide = "addSlideBtn";
		    	    
		    	    //Text box to add the slide display name
		    	    static final String txt_slideName = "seEdit_name_slideurl";
		    	    
		    	    //Text box to add the Slide time stamp
		    	    static final String txt_slideTimeStamp = "seEdit_timestamp_slideurl";
		    	    
		    	    //Drop down to choose the slide
		    	    static final String drp_slideChoose = "seEdit_text_slideurl";
		    	    
		    	    //Button to save the selected slide
		    	    static final String btn_saveSlide = "//div[@id='slideEdit']/table/tbody/tr[2]/td/div/input[3]";
		    	    
		    	    //Button to save the Media Editor changes
		    	    static final String btn_saveMediaEditor = "_eventId_save";
		    	    static final String btn_saveEditContent = "_eventId_finish";
		    	    //Image for caption
		    	    static final String img_captionMediaEditor = "//img[@alt='caption']";
		    	    
		    	    //Image for chapter
		    	    static final String img_chapterMediaEditor = "//img[@alt='chapter']";
		    	    
		    	    //Image for slide
		    	    static final String img_slideMediaEditor = "//img[@alt='slideurl']";   
		    	    
		    	    
		    	  //*********************RSS Discovery****************************//      
				    
				    
				    //Polycom RSS discovery link
				    static final String Lnk_PolycomRSSDiscovery = "link=Polycom RSS Discovery";
				    //Button to add RSS Discovery
				    static final String btn_configureRSSDEvice = "//button[@type='button']";
				    //link to select the RSS device
				    static final String select_RSSDiscovery = "//select[@id='selectselectTypeDialogrssSourceDevices']/option";
				    //Label to check if the discovered calls is N/A
				    static final String lbl_discoveredCalls = "//td[11]";
				    //Link to the discovered calls
				    static final String lnk_discoveredCalls = "//td[11]/a";
				    //Button to save the RSS Discovery
				    static final String btn_submitDiscovery = "_eventId_submit";
				    //Textbox for program prefix 
				    static final String txt_prograPrefixDiscovery = "programPrefix";
				    //Textbox for  content prefix
				    static final String txt_contentPrefixDiscovery = "contentPrefix"; 
				    //Checkbox for MAke VRR owner the publisher of the program
				    static final String chk_VRRownerPublisher = "assignVrrOwner";
				    //Checkbox for the auto publish non-pin protected call 
				    static final String chk_autoPublishNonPinLive = "listNonPINLiveCalls";
				    //Checkbox for auto publish pin protected call
				    static final String chk_autoPublishPinLive = "listPINLiveCalls";
				    //Create On-demand program for archived non-pin protected call
				    static final String chk_createVODNonPin = "createNonPINRecordedCalls";
				    //AutoPublish On-demand program for archived non-pin protected call
				    static final String chk_autoPublishNonPinVOD = "listNonPINRecordedCalls";
				    //Create On-demand program for archived pin protected call
				    static final String chk_createVODPin = "createPINRecordedCalls";
				    //AutoPublish On-demand program for archived pin protected call
				    static final String chk_autoPublishPinVOD = "listPINRecordedCalls";
				    //Button for Load VRRs 
				    static final String btn_LoadVRR = "rssConfig_LoadButton";
				    //Dropdown to select the template for Live call for a VRR
				    static final String drp_templateLive = "liveTemplateId";
				    //Dropdown to select the template for archived call for a VRR
				    static final String drp_templateArchive = "recordedTemplateId";
				    //Link to the discovered program name on list of ad-hoc discovery page
				    static final String lnk_DiscoveredProgram = "//span/a";
				    static final String lnk_DiscoveredProgramRSS2k = "//tr[{0}]/td[5]/span/a";
				      //Object map declaration for label for Pin protected status of the program on Program summary page
		            static final String Lnk_Discoveries = "discosMenu_text";
				    static final String lbl_pinStatusAutomatedSummaryPage = "//div[11]/div[4]/div[3]/div[2]";
				      static final String lbl_pinStatusVODSummaryPage = "//div[4]/div[3]/div[2]";
				      static final String img_externalskin="//td[3]/a/img";
				      static final String chk_skin ="useSkins";
				      static final String Btn_Add_skin="create_button";
						static final String Btn_skinname="name";
						static final String Btn_skinsave="_eventId_submit";
						static final String Btn_skinexternal="external";
						static final String Btn_skinselect="selectedSkin";
						static final String Btn_skinpage="Add Skin";
						static final String Lnk_programproperties="propertiesMenu_text";
		   
						//**********************************Upload EGC program CVP****************************// 
					    
					    
					    static final String lnk_AddVideo_CVP = "link=Add Video";
					    
					    static final String lnk_MyVideoCVP = "//a[@id='myProgsLink']/span";
					    
					    static final String txt_egcProgramNameCVP = "title";
					        
					    static final String fileUPl_egcStreamingMediaCVP = "id=file"; 
					    
					    static final String btn_egcSaveprogramCVP = "save";
					
					    static final String btn_egcSubmitprogramCVP="//input[@value='Submit for Approval']";  
					  //*****************************Program Template***********************************
		                
		                static final String Btn_AdddPrgTemplate="//button[@type='button']";
		                static final String Drp_PrgTemplatechoose="selectselectTypeDialogprogramTypeNames";
		               		                
		                static final String Txt_PrgTemplate="name";
		                
		                static final String Txt_PrgTemplateStorage="storageOption";
		                
		                static final String Btn_AddDelivery="css=div.actionButtons > button.basicButton.addButton";
		                
		                static final String Drp_AddDeliveryName="deliveryMode";
		                
		                static final String Chk_AddDeliveryOption="includedAccessPointIDs";
		                
		                static final String Btn_AddDeliverySave="_eventId_submit";
		                
		                static final String Drp_MediaFormat="formatName";
		                
		                static final String Btn_SaveProgramTemplate="_eventId_submit";
		                static final String Txt_AddDeliveryOptionAutofile="//div[@id='doptEnclosure']/input[4]";
		                
		                static final String Txt_Templatedelivery="id=doptEnclosure";
		                

		      	   //************************************Automated File Broadcast Program*************************
		      		  
		      		  static final String Btn_selectMedia = "selectMedia";
		      	   
		      		  
		      		  //Add Automated File Broadcast Program
		      		  static final String Select_programType_AutomatedFileBroadcast = "label=Automated File Broadcast";
		      		  

		      		  
		      		  //Add Automated file broadcast Program
		      		  static final String AutomatedFilePrgram = "esc_program.type.3";
		      		  

		      		  
		      		  //Add Program
		      		  static final String Txt_AutomatedFileProgramName = "name";
		      		  
		      				  
		      		  //Add Program
		      		  static final String Radio_listingImmedtiatelyAutomatedFile = "availableDateSetting_3";
		      		  
//		      		Object map declaration for Domains link
						 
						//static final String LNK_Domains = "//a[contains(text(),'Domains')]";
						
						static final String LNK_Domains = "link=Domains";
						
						// Object map declaration for Domain Add button	
						
						static final String BTN_AddDomain = "//form[@id='mainform']/div[1]/div[2]/button[2]";
						
						//Object map declaration for Domain Id
						
						static final String LNK_DomainID= "//input[@id='domainId']";
						
						//Object map declaration for Domain Name
						
						static final String LNK_DomainName= "//input[@id='displayName']";
						
						//Object map declaration for Activate the Domain
						
						static final String LNK_DomainActive= "//input[@id='active']";
						
						//Object map declaration for providing the Site URL for the Domain 
						
						static final String TXT_SiteURL= "//input[@id='domainUrl']";	
						
						//Object map declaration for providing the checkbox to receive the WMP logs 
							
						static final String CHK_WMP_logs= "//input[@id='enableWMSLogging']";		
							
						//Object map declaration for providing the location for receiving the WMP logs 
						
						static final String TXT_WMP_logs_location= "//input[@id='wmsLoggingUrl']";		
						
						//Object map declaration for providing the Storage Quota 
						
						static final String TXT_Storage_Quota= "//input[@id='domainStorageLimit']";		
						
						//Object map declaration for providing the Storage threshold warning
						
						static final String TXT_Storage_Threshold= "//input[@id='storageWarningThreshold']";			
						
						//Object map declaration for configuring the domain with Social Viewer portal
						 
						static final String CHK_Domain_Conf_SVP= "//input[@id='useVP52']";		
						
						//Object map declaration for security realm
						static final String Drp_securityRealm = "realm";
						
						//Object map declaration for enable EGC checkbox
						static final String Chk_enableEGC = "enableEGC";
						
						
						//Object Map declaration for Allow Duplicate passcode checkbox
						static final String chk_allowDuplicatePasscode = "enableDuplicatePasscodes";
			    	  
						//*******************Object Map for Change Domain********************//
						
						//Object map declaration to click the Change Domain link
							
						static final String LNK_Chng_Domain = "domainSelectionComponent_link";
						
						//Object map declaration to choose the required domain
						 
						static final String LNK_Domain_select = "//a[{0}]/div";
						
						// Object map declaration for the Domain existence 
							
						static final String LNK_DoaminExist= "//input[@name='id']";
						
						//Object map declaration for deleting the existed Domain  
							
						static final String LNK_DoaminDelete= "//button[@id='delete']";
						
						//Object map declaration for the Confirm existence 
							
						static final String LNK_DoaminDeleteConfirm= "//div[@id='mpiwidget_layout_ConfirmDialog_0']/div[2]/button[1]";
						
						 //**********************************Add Poll/Survey****************************// 

					   			
							//Object map declaration for selecting Content Item
							
							static final String Radio_Slides = "contentTypeRadio_7";				

							// *************************Storage Page Object Map**********************************	
							
							//Object map declaration for Add button
							
							
							static final String BTN_AddStorage = "//form[@id='mainform']/div[1]/div[2]/button[2]";

							// Object map declaration for Select Type popup window
							 	
							
							static final String SelectType_AddStorage = "//select[@id='selectselectTypeDialogdoptTypes']";
							
							// Object map declaration for select Local Storage on the "Select Type" popup
							 	
							static final String LNK_LocalStorage = "//option[@id='storage.type.local']";
							
							// Object map declaration for Storage Name textbox
							 	
							static final String TXT_StorageName = "//input[@id='name']";
							
							// Object map declaration for Storage Path textbox
							
							static final String TXT_StoragePath = "//input[@id='appath']";
							
							//Object map declaration for Storage Path textbox
							
							
							static final String BTN_AddAPStorage = "//button[@name='apType']";
							
							//Object map declaration for Storage Path textbox
							
							static final String SelectType_AddAPStorage = "//select[@id='selectselectTypeDialogapTypes']";
							
							// Object map declaration for Storage Path textbox
							
							static final String LNK_HTTP_AP_Storage = "//option[@id='storage.accesspt.standard.http']";
							
							//Object map declaration for HTTP Access Point Name
							
							static final String TXT_NameAP_Storage = "//input[@id='name']";
							
							// Object map declaration for Host Name
							
							
							static final String TXT_NameHOST_AP_Storage = "//input[@id='aphostname']";
							
							// Object map declaration for Mount Point Name textbox
							 	
							static final String TXT_NameMountPoint_AP_Storage = "//input[@id='apmount']";	
							
							// Object map declaration for Select All Roles checkbox

							
							static final String CHK_AllRoles_APStorage = "//input[@type='checkbox' and @onclick=\"adminMultiCheckAll('roles',this)\"]";
							
							// Object map declaration for Save button on HTTP Access Point page 
							 	
							static final String BTN_SaveAP_Storage = "//button[@id='_eventId_submit']";
							
							// Object map declaration for Save button on Storage page
							
							static final String BTN_SaveStorage = "//button[@id='_eventId_submit']";
							
							
							//*********************HTTP Delivery Option************************
							
							// Object map declaration adding HTTP Delivery Option
							 
							static final String LNK_selectHTTPdelivery = "//select[@id='selectselectTypeDialogdoptTypes']";
							
							// Object map declaration for providing the HTTP do name. 
								
							static final String TXT_HTTP_Name = "//input[@id='name']";
							
							// Object map declaration for providing the HTTP do Host. 
							
							static final String TXT_HTTP_Host = "//input[@id='host']";
							
							// Object map declaration adding HTTP Delivery Option
							 
							static final String LNK_Click_Add_Download = "//button[@value='dummy']";
							
							// Object map declaration adding Download Delivery Option
							 
							static final String SelectType_DO_Download_Type = "//select[@id='selectselectTypeDialogapTypes']";
							
							// Object map declaration selecting Download Delivery Option
							 
							static final String LNK_selectDownloaddelivery = "//option[@id='addDOWNLOADAp']";
							
							// Object map declaration for adding Access Point 
							
							static final String TXT_AP_HTTP_Name= "//input[@id='name']";
							
							// Object map declaration for adding MountPoint
							
							static final String TXT_MP_HTTP = "mountPoint";
							
							// Object map declaration for selecting Storage drop-down
							
							static final String dropdown_Storage = "storage";
							
							// Object map declaration for Saving Access Point
							
							static final String Btn_Save_AP = "//button[@id='_eventId_submit']";
							
							// Object map declaration for Saving Access Point
							 
							static final String Btn_Save_HTTP = "//button[@id='_eventId_submit']";
							
							//Object map declaration for testing HTTP exist
							
							static final String LNK_HTTP_Exist = "//input[@name='id' and @value='dlvryimpl_http:304']";

							//***********************RSS4000V6************************//
						    
							//Object map declaration for encoder list
							
						    static final String select_EncoderType = "selectselectTypeDialogencoderTypes";
						    
							//Object map declaration for RSS4kV6 encoder
							
						    static final String rss_v6Encoder = "RSS4KEncType" ;
						    
							//Object map declaration for encoder name text box
							
						    static final String txt_nameRSSv6 = "name";
						    
							//Object map declaration for Host address textbox
							
						    static final String txt_hostRSSv6 = "hostAddress";
						    
							//Object map declaration for username text box
							
						    static final String txt_userRSSv6 = "user";    
						    
							//Object map declaration for password textbox
							
						    static final String txt_passwordRSSv6 = "password";
						    
							//Object map declaration for confirm textbox
							
						    static final String txt_confirmPasswordRSSv6 = "password_confirm";
						    
							//Object map declaration for Use HTTPS checkbox
							
						    static final String chk_useSSLv6 = "useHttps";
						    
							//Object map declaration for maximum number of live streams textbox
							
						    static final String txt_maxStreamRSSv6 = "maxNumberOfLiveStreams";
						    
							//Object map declaration for add profile button
							
						    static final String btn_profileRSSv6 = "//button[@type='button']";
						    
							//Object map declaration for profile name textbox
							
						    static final String txt_profileNameRSSv6 = "name";
						    
							//Object map declaration for save profile button
							
						    static final String btn_saveProfileRSSv6 = "_eventId_submit";
						    
							//Object map declaration for save encoder button
							
						    static final String btn_saveRSSv6 = "_eventId_submit";
						    
						  //********Automated File Broadcast Program******************//
						      
						      //Object Map declaration for Automated File Broadcast Program option
						      
						      static final String LNK_fileBroadcast = "esc_program.type.3";
						      
						      //Object Map declaration for radio button for immediate listing
						        
						      static final String radio_listImmadiately = "availableDateSetting_3";
						      
						      //Object Map declaration for deleting upcoming occurrence
						      
						      static final String delete_upcomingOccurrence = "dateDelete_occurrences";
						      
						      //Object Map declaration for textbox to search Media
						      
						      static final String txt_searchMedia = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[1]";
						      
						      //Object Map declaration for button to Find Media
						      
						      static final String btn_findMedia = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[2]";
						      
						      //Object Map declaration for Link to select the searched media
						      
						      static final String lnk_searchedMedia = "//div[@id='dijit_layout_ContentPane_8']/div/div/div";
						      
						      //Object Map declaration for the link button to move the selected media to the selected section 
						      
						      static final String btn_moveToSelected = "//div[@id='dijit_layout_ContentPane_9']/a[2]";
						      
						      //Object Map declaration for the button to save the searched media 
						      
						      static final String btn_saveSearchedMedia = "mpiwidget_form_ContentSelection_1_submit";
						      
						      //Object Map declaration for 
						      
						      static final String btn_Next = "_eventId_next";
						      
						      /***********************************Content Page***********************************/		
						  			
								//External Streaming media
								static final String Radio_extStreamingMedia = "contentTypeRadio_2";
										
								//External URL for external Streaming media
								
								static final String Txt_externalURL = "link";
								
								static final String Drp_externalMediaFormatType = "formatType";
								//****************************Audience***************************
								
								// Object map declaration for Audience menu link
								
							    static final String lnk_Audience = "link=Audiences";
								
								// Object map declaration for Add audience button
								
							    static final String btn_audienceAdd = "//form[@id='mainform']/div[1]/div[2]/button[2]";
								
								// Object map declaration for audience name
								    
							    static final String txt_audienceName = "name";
								
								// Object map declaration for next button 
								
							    static final String btn_audienceNext = "_eventId_next";
								
								// Object map declaration for Add Rule link
								
							    static final String lnk_audienceAddRule = "//span[@onclick='addNewRule(0)']";
								
								// Object map declaration for Add Rule pair link
								
							    static final String lnk_audienceAddRulePair = "//img[@alt='Add Rule Pair here']";
								
								// Object map declaration for
								
							    static final String fld_audienceRule = "for";
								
								// Object map declaration for Save audience rule pair button
								
							    static final String btn_audienceSaveRulePair = "//button[@type='button' and @onclick='storeParen(0);']";
								
								// Object map declaration for save audience rule button
								
							    static final String btn_audienceSaveRule = "//button[@type='button' and @onclick='storeRule(0,undefined);']";
								
								// Object map declaration for Download listbox
								
							    static final String lst_audienceDownload = "availableDoptDOWNLOAD";
								
								// Object map declaration for move to selected (for download) list box
								
							    static final String lnk_audienceDownloadMoveToSelected = "//form[@id='mainform']/div[4]/div[2]/a[2]";
								
								// Object map declaration for On-demand listbox
								
							    static final String lst_audienceVOD = "availableDoptVOD";
								
								// Object map declaration for move to selected (for On-demand) list box
								
							    static final String lnk_audienceVODMoveToSelected = "//form[@id='mainform']/div[7]/div[2]/a[2]";
								
								// Object map declaration for Live listbox
								
							    static final String lst_audienceLive = "availableDoptLIVE";
								
								// Object map declaration for move to selected (for Live) list box
								
							    static final String lnk_audienceLiveMoveToSelected = "//form[@id='mainform']/div[10]/div[2]/a[2]";
								
								// Object map declaration for Submit button
								
							    static final String btn_audienceFinish = "_eventId_finish";

								
							 // Q&A tab link for viewer question
								static final String tab_QA = "link=Q&A";
							    
								//Ask button for submitting the viewer question
							    static final String btn_Ask = "Ask";
							    
							    static final String Lnk_asx ="//div[@id='mpi_util_DebugConsole_0']/div[3]";
                                    static final String LNK_PollWindow ="//div[@id='mpi_vp_Polls_0']/div[1]";
							  	
							  	//Checkbox on Poll WIndow
							  	static final String CHK_PollWindow ="//div[@id='mpi_vp_Polls_0']/div[2]/div[2]/form/input[1]";
							  	
							  	// Submit button on Poll window
							  	static final String BTN_PollWindow ="//input[@name='Submit']";	
							
								//**********************************************
							
							    //***********************************Configured URL delivery option**********************************
					    		
					    		
					    		
					    		//VideoNet Edge delivery option value in teh list box
								static final String Lst_addDeliveryOption_Configured_URL = "label=Configured URL";
								
								//List box to add delivery option
								static final String Select_Configured_URLDOPT="dlvryimpl_url";
								
					

								//Configured URL name
								static final String Txt_ConfiguredURLname = "name";
					    		
								//Access point label fro download
							    static final String Lst_AccespointDownload="label=Download";
							    
							  //Access point label fro VOD
							    static final String Lst_AccespointVOD="label=VOD";


							     //Access point label fro download
						         static final String Select_AccespointDownload="addDOWNLOADAp";
						
						        //Access point label fro VOD
						       static final String Select_AccespointVOD="addVODAp";
				 
					
						   	//Access point name
								static final String Txt_AccessPointname = "name";
								//Access point URL
								static final String Txt_AccessPointURL = "url";
								
								//Access point URL
								static final String Btn_AccessPointsubmit= "_eventId_submit";
								//Access point Media format
								static final String Drp_AccessPointformat= "format";
								
								//Access point Media format
								static final String select_AccessPointformat= "label=Windows Media";
								
								//get file Streaming Media File URL
								static final String select_filename= "filename";
								
								//Click on file details button
								static final String Btn_fileDetails= "itemDeets";
								
								//Click on file details button
								static final String TXT_fileLocation= "storageLocation";
								
								//close file dialog
								static final String Btn_crossdialog= "//div[3]/div/span[2]";
							    static final String Lst_AccespointLive="label=Live";
							    //Access point label fro Live
							      static final String Select_AccespointLive="addLIVEAp";

							  
						
}					


			  

