/*
 * This class is used to declares Object properties
 * 
 */

package com.qa.columbia.repository.v5_4;

public interface EnvObjectMap_Rep {
	
	
//***************************Admin Portal*****************************//
	
	//Object Map declaration for User Name link
	 
	static final String LNK_UserName ="//input[@id='loginbox']";
	  
	//Object Map declaration for Password link
	 
	static final String LNK_Password ="//input[@id='passwordbox']";
	
	//Object Map declaration for Login button
	 
	static final String BTN_LOGIN = "//button[@id='loginbutton']";
	
    //Object Map declaration for Logout link
	 
	static final String LNK_LOGOUT = "//a[contains(text(),'Log Out')]";
	
    //Object Map declaration for Logout link
	  
	static final String LNK_LOGIN_BTN = "//button[@id='login_button']";	

	
	// ***********************Object Map declaration for Domain******************************
	 
	static final String dropdown_Domain = "//select[@id='domainselect']";
	

	//Object Map declaration for selected domain Name link
	
	static final String LNK_selecteddomainName="//a[contains(@href, 'domainEdit.do?domainId=esc_domain:";
	
	
	// Object map declaration for System link
	 
	
	static final String LNK_System = "//div[@id='menu_system_cont']";

	//	Object map declaration for Domains link
	 
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
	
	//Object map declaration to Save the Domain
	
	static final String BTN_DomainSave= "//button[@id='_eventId_submit']";
	
	//Object Map declaration for EGC program Approval checkbox
	static final String CHK_EGCApprovalRequiredchkbox = "egcApprovalRequired";
	
	
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
	
	
	//*******************************User Management**********************************//
	
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
    
	
	
	// *******************************Resources Menu Object Map***************************************//	
	
	//Object map declaration for Resources Menu 
		
	static final String LNK_Resources = "//div[@id='menu_resourcebin_cont']";
	
	// Object map declaration for Storage link under Resources 
	 
	static final String LNK_Storage = "//a[contains(text(),'Storage')]";
	
	// Object map declaration for Encoders link under Resources
	 	
	static final String LNK_Encoders = "//a[contains(text(),'Encoders')]";
	
	// Object map declaration for Studios under Resources
		
	static final String LNK_Studios = "//a[contains(text(),'Studios')]";
	
	//Object map declaration for Transcoding Nodes under Resources.
	 
	
	static final String LNK_Transcoding_Nodes = "//a[contains(text(),'Transcoding Nodes')]";
	
	// Object map declaration for Polycom RSS Devices under Resources.
	 
	static final String LNK_Polycom_RSS_Devices = "//a[contains(text(),'Polycom RSS Devices')]";
		
	
	// *******************************Encoder menu Object Map***************************************

	// Object map declaration for clicking menu link
	
	static final String Btn_Add_Encoder = "//button[@type='button']";
	
	// Object map declaration for selecting encoder type panel
	 
	static final String LNK_Select_Encoder_Type = "//select[@id='selectselectTypeDialogencoderTypes']";
	
	// Object map declaration for providing Encoder Name
	 
	static final String TXT_Encoder_Name = "//input[@id='name']";
	
	// Object map declaration for providing encoder host address
	 
	static final String TXT_Encoder_Host = "//input[@id='hostAddress']";
	
	// Object map declaration for providing Encoder User ID
	
	static final String TXT_Encoder_UserID = "//input[@id='user']";
	
	// Object map declaration for providing Encoder User Password
	 
	static final String TXT_Encoder_Password = "//input[@id='password']";
	
	// Object map declaration for providing  Encoder Confirm Password
	
	static final String TXT_Encoder_Confirm_Password = "//input[@id='password_confirm']";
	
	// Object map declaration for providing maximum number of calls
	 
	static final String TXT_Encoder_Max_number_calls = "//input[@id='maxNumberOfLiveStreams']";
	
	// Object map declaration adding Encoder Profile
	 
	static final String BTN_Add_Encoder_Profile = "//button[@type='button']";
	
	// Object map declaration adding Encoder Profile
	 
	static final String TXT_Encoder_Profile_Name = "//input[@id='name']";
	
	// Object map declaration adding Encoder Profile
	
	static final String BTN_Save_Enc_Profile = "//button[@id='_eventId_submit']";
	
	// Object map declaration adding Encoder Profile
	 
	static final String BTN_Save_Encoder = "//button[@id='_eventId_submit']";
	
	//Object map declaration adding Encoder Profile
	 
	static final String LNK_RSS4000 = "//option[@id='RSS4KEncType']";
	
    //**********************************Create the RSS4000v5 encoder****************************// 
    
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
    
    
    //*******************************WME Encoder menu Object Map***************************************
	
	//Object map declaration for the panel for selecting the Windows Media Encoder
		
	static final String SelectType_Enc = "//select[@id='selectselectTypeDialogencoderTypes']";
	
	// Object map declaration for clicking Windows Media Encoder option.
	 
	static final String LNK_WME  = "//option[@id='winEnc1']" ;
	
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
	
    // Object map declaration for clicking menu link
	
    //static final String LNK_ = "//a[contains(text(),'WME001')]";
    
    
	// Object map declaration for verifying WME link
	
    static final String CHK_VerifyWME = "//input[@name='id']";
		
	
	
	
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
	
	
	// *************************Polycom RSS devices Page Object Map**********************************	
	
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
	
	
	
	//************RSS Source Device***********//
	
	// Object map declaration for 
	
	static final String chk_archiveMediaRSSsourceDevice =  "//tr[{0}]/td[1]/input";
	
	// Object map declaration for place a call menu
	
	static final String lnk_endPointPlaceACall = "main_0";
	
	// Object map declaration for encoder IP text box
	
	static final String txt_endPointDialNumber = "dialnumber";
	
	// Object map declaration for dial image link
	
	static final String img_endPointDial = "dialimage";
	
	// Object map declaration for IP address frame (section)
	
	static final String frame_endPointCall = "contentFrame";
	
	// Object map declaration for hang image link
	
	static final String img_endPointHang ="hangupimage";
	
	// Object map declaration for username text box
	
	static final String txt_SourceDeviceUsername = "username";
	
	// Object map declaration for password textbox
	
	static final String txt_SourceDevicePassword = "password";
	
	// Object map declaration for Login button
	
	static final String btn_SourceDeviceLogin = "//form[@id='form_login']/table[4]/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/a/img";
	
	// Object map declaration for Archives menu
	
	static final String menu_SourceDeviceArchives = "//td[@id='id_menu_5']/div";
	
	// Object map declaration for archives submenu
	
	static final String subMenu_SourceDeviceArchives = "link=Archives";
	
	// Object map declaration for Archive frame section
	
	static final String frame_SourceDeviceArchives = "index_right";
	
	// Object map declaration for last page link button
	
	static final String lnk_SourceDeviceLastPageArchives = "//img[@alt='Last Page']";
	
	// Object map declaration for label describing the page count
	
	static final String lbl_SourceDeviceArchivesPageCount = "//form[@id='archive_admin']/table[2]/tbody/tr/td[8]";
	
	// Object map declaration for connected calls section
	
	static final String frame_SourceDeviceConnectedcall = "index_bottom";
	
	// Object map declaration for start recording button
	
	static final String btn_SourceDeviceSartRecording = "//img[@alt='Start Recording']";
	
	// Object map declaration for stop recording button
	
	static final String btn_SourceDeviceStopRecording = "//img[@alt='Stop Recording']";

	
	//*******************************Delivery Page Object Map***************************************//
	
	// Object map declaration for the Delivery menu. 
		
	static final String LNK_Deliverymenu= "//div[@id='menu_config_cont']";
		
	//Object map declaration for the Delivery Options page. 
	 
	static final String LNK_DeliveryOption= "//a[contains(text(),'Delivery Options')]";	

	//Object map declaration for Add Delivery button. 
	 
	static final String Btn_Adddelivery = "//table[@id='bindContainer']/tbody/tr[1]/td[1]/div/button[2]";	
	
	
	//***************Windows Media Server**********************
	
	//Object map declaration for selecting the WMS Delivery Options. 
	
	static final String LNK_selectWMSdelivery = "//option[@id='dlvryimpl_wms']";

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
	
	static final String TXT_MP_HTTP = "//input[@id='mountPoint']";
	
	// Object map declaration for selecting Storage drop-down
	
	static final String dropdown_Storage = "//select[@id='storage']";
	
	// Object map declaration for Saving Access Point
	
	static final String Btn_Save_AP = "//button[@id='_eventId_submit']";
	
	// Object map declaration for Saving Access Point
	 
	static final String Btn_Save_HTTP = "//button[@id='_eventId_submit']";
	
	//Object map declaration for testing HTTP exist
	
	static final String LNK_HTTP_Exist = "//input[@name='id' and @value='dlvryimpl_http:304']";
	
	
	//***********************MediaNet************************
	
	// Object map declaration for select medianet option from the list box
	
    static final String selectMediaNet = "dlvryimpl_medianet";
	
	// Object map declaration for medianet name textbox
	
    static final String txt_nameMedianet = "name";
	
	// Object map declaration for origin listbox
	
    static final String lst_selectOrigin = "//div[2]/div/div[1]/div/div[{0}]";
	
	// Object map declaration for 
	
    //"//div[@id='mpiwidget_form_SloshBucket_0']/div[1]/div/div[1]";
	
	// Object map declaration for First WMS delivery option in the listbox
	
    static final String lst_FirstWMSdo = "//div[6]/div[1]/div[2]/div/div[1]/div/div[1]";
	
	// Object map declaration for second WMS delivery option in the listbox
	
    static final String lst_SecondWMSdo = "//div[6]/div[1]/div[2]/div/div[1]/div/div[2]";
	
	// Object map declaration for button to move to selected list box
	
    static final String lnk_originMoveToSelected = "//div[@id='mpiwidget_form_SloshBucket_0']/div[2]/a[2]";
	
	// Object map declaration for edge listbox
	
    static final String lst_selectEdge = "//div[8]/div[1]/div[2]/div/div[1]/div/div[{0}]";
	
	// Object map declaration for Add proximity button
	
    static final String btn_addProximity = "editProx_link";
	
	// Object map declaration for adding proximity mapping
	
    static final String btn_addProximity1 = "_eventId_editProximity";
	
	// Object map declaration for move to selected in edge listbox
	
    static final String lnk_edgeMoveToSelected = "//div[@id='mpiwidget_form_SloshBucket_1']/div[2]/a[2]";
    static final String radio_Proximity = "proximityEnabled_2" ;
	
	// Object map declaration for CIDR (for origin) text box
	
    static final String txt_ProximityOriginCIDR1 = "//div[@id='mpiwidget_form_MNProximity_0']/table/tbody/tr/td[1]/input";
	
	// Object map declaration for Metric (for origin) textbox
	
    static final String txt_ProximityOriginMetric1 = "//div[@id='mpiwidget_form_MNProximity_0']/table/tbody/tr/td[2]/input";
	
	// Object map declaration for 2nd CIDR (for origin) textbox 
	
    static final String txt_ProximityOriginCIDR2 = "//div[@id='mpiwidget_form_MNProximity_0']/table/tbody/tr[2]/td[1]/input";
	
	// Object map declaration for 2nd Metric (for origin) textbox
	
    static final String txt_ProximityOriginMetric2 = "//div[@id='mpiwidget_form_MNProximity_0']/table/tbody/tr[2]/td[2]/input";
	
	// Object map declaration for CIDR (for edge) text box
	
    static final String txt_ProximityEdgeCIDR1 = "//div[@id='mpiwidget_form_MNProximity_1']/table/tbody/tr/td[1]/input";
	
	// Object map declaration for Metric (for edge) textbox
	
    static final String txt_ProximityEdgeMetric1 = "//div[@id='mpiwidget_form_MNProximity_1']/table/tbody/tr/td[2]/input";
	
	// Object map declaration for 2nd CIDR (for edge) textbox 
	
    static final String txt_ProximityEdgeCIDR2 = "//div[@id='mpiwidget_form_MNProximity_1']/table/tbody/tr[2]/td[1]/input";
	
	// Object map declaration for 2nd Metric (for edge) textbox
	
    static final String txt_ProximityEdgeMetric2 = "//div[@id='mpiwidget_form_MNProximity_1']/table/tbody/tr[2]/td[2]/input";
	
	// Object map declaration for radio button for selecting edge
	
    static final String radioEdge = "document.forms[0].elements[2]";
	
	// Object map declaration for Add proximity mapping button for origin
	
    static final String  btn_addProximityMapOrigin = "//div[@id='mpiwidget_form_MNProximity_0']/button";
	
	// Object map declaration for Add proximity mapping button for edge
	
    static final String  btn_addProximityMapEdge = "//div[@id='mpiwidget_form_MNProximity_1']/button";
	
	// Object map declaration for save button for proximty mapping page
	
    static final String btn_saveProximity = "_eventId_submit";
	
	// Object map declaration for save medianet button
	
    static final String btn_saveMedianet = "_eventId_submit";        
	
	// Object map declaration for DNS textbox
	
    static final String txt_DNS = "dns";
	
	// Object map declaration for Submit button
	
    static final String btn_submit = "_eventId_submit";

	  
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

	
	

	// *******************************Programming Page Object Map***************************************

	
	//Object map declaration for Programming link
	 
	static final String LNK_Programming = "//div[@id='menu_programming_cont']";
	
	
	// ************************Content Page Object Map***************************
	
	//Object map declaration for Content Item	
	
	static final String LNK_Content = "link=Content";
	
	// Object map declaration for Add Content
	
	static final String Btn_AddItem = "addI";
	
	//Object map declaration for selecting Content Item
	
	static final String Rbtn_Slides = "contentTypeRadio_7";
	
	// Object map declaration for Clicking Next button
		
	static final String Btn_Next = "_eventId_next";
	
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
		
	static final String BTN_More_Search = "//div[@id='searchResults']/table[1]/tbody/tr/td[2]/button[2]";
	
	// Object map declaration for providing selecting Name field to search
		
	static final String TXT_Search_Name = "_adv_name";

	// Object map declaration for providing selecting Name field to search
	 	
	static final String Btn_Search = "searchSubmit";
	
	// Object map declaration for Selecting Content
	
	static final String LNK_Content_Exist = "link=Slide001";
	
	
	//**********************************Add Poll/Survey****************************// 

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

	
    //**********************************Thumbnail Extraction*********************//
    
    //Button for Pick Thumbnail
    static final String btn_thumbnailExtraction = "_eventId_thumbnail";
    
    //Radio button for selecting the thumbnail (1st)
    static final String radio_selectthumbnail = "thumbnail_0";
    
    //button to Save the selected thumbnail
    static final String btn_saveExtractedThumbnail = "_eventId_save";
    
    //Button for Save on Edit Streaming page
    static final String btn_saveEditContent = "_eventId_finish";
    
    
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
    
    //Image for caption
    static final String img_captionMediaEditor = "//img[@alt='caption']";
    
    //Image for chapter
    static final String img_chapterMediaEditor = "//img[@alt='chapter']";
    
    //Image for slide
    static final String img_slideMediaEditor = "//img[@alt='slideurl']";   
 
    //**********************Image Upload in Content*******************//
    
	// Radio button for Image
    
    static final String btn_Img  = "contentTypeRadio_5"; 
    
    //Drop down for searching the active content
    
    static final String drp_Active = "_advs_status";
    
    static final String drp_Active_val = "label=ACTIVE";
    

//**********************Complex Presentation Upload in Content*******************//
    
	// Radio button for Image
    
    static final String btn_ComplexPresenation  = "contentTypeRadio_8"; 
    
    //Text box for duration
    static final  String txt_Duration = "duration";
    
    //Drop down for VideoSize
    static final  String drp_VideoSize = "predefinedSize";
    
    //Value of the VideoSize
    static final String drp_VideoSize_val = "label=352x288"; 
	
	
	//*****************Object Map for Programs*************
	
	
	//Object map declaration for opening Programs 
	
	static final String LNK_Programs = "//a[contains(text(),'Programs')]";
	
	//Object map declaration for Click Add button in programs 
	 
	static final String Btn_Add_Program = "//button[2]";
	
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
	
	static final String LNK_Select_Enc	 = "//select[@id='encSel']/option";
	
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
	 
	static final String Btn_Next_Delivery_Select = "_eventId_next";
	
	//Object map declaration for selecting HTTP delivery Option 
	 
	//static final String Radio_Btn_Select_HTTP = "dgDOWNLOAD___3_opt";
	
	static final String Radio_Btn_Select_HTTP = "dgDOWNLOAD___1_opt";
	//Object map declaration for selecting WMS Delivery Option 
	 
	//static final String Radio_Btn_Select_WMS = "dgLIVE___media_formattype_windows_4_opt";
	static final String Radio_Btn_Select_WMS = "dgLIVE___media_formattype_windows_1_opt";
	
	//Object map declaration for clicking next button  on Content Delivery Option Page 
	 
	static final String Btn_Next_Delivery = "_eventId_next";
	
	//Object map declaration for clicking Summary button Program Assignment page
	 
	//static final String Btn_Summary = "_eventId_summary";
	
	static final String Btn_Summary = "//button[3]";
	// Object map declaration for clicking Finish Button on Program Summary page
	 
	//static final String Btn_Finish_Program = "_eventId_summary";
	
	static final String Btn_Finish_Program = "//button[3]";
	
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

	// Object map declaration for link to select the searche dsurvey
	
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

	// Object map declaration for radio button to choose audience during program creation
	
    static final String radio_audience = "deliveryType";

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
   

  //**********************VOD Program *******************//
      
  	// On-demand selection from the Program Type listbox 
      
      static final String lst_ondemand = "label=On-Demand";
      
      //Object map declaration for on-demand program option
      
      static final String LNK_OnDemand = "esc_program.type.1";

      //Object map declaration for next button 
      
      static final String btn_Next_programPage = "_eventId_next";

      //Object map declaration for program name textbox
      
      static final String txt_ProgramName ="name";

      //Object map declaration for Immediate listing radio button
      
      static final String radio_Immediately = "availableDateSetting_3";

      //Object map declaration for Select button to choose streaming media
      
      static final String btn_selectMedia = "selectMedia";

      //Object map declaration for Finish button
      
      static final String btn_FinishProgram = "_eventId_finish";

      //Object map declaration for browse label on add streaming media popup window
      
      static final String lbl_browseMedia = "dijit_layout__TabButton_2";

      //Object map declaration for textbox to searching streaming media 
      
      static final String txt_SearchMedia = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[1]";

      //Object map declaration for button to fing streaming media
      
      static final String btn_mediaSearch = "//div[@id='dijit_layout_ContentPane_7']/div[1]/input[2]";

      //Object map declaration for Link to select streaming media
      
      static final String Lnk_selectMedia = "//div[@id='dijit_layout_ContentPane_8']/div/div/div";

      //Object map declaration for link button to move teh media to the selected list box
      
      static final String lnk_moveToSelected = "//div[@id='dijit_layout_ContentPane_9']/a[2]";

      //Object map declaration for 
      
      static final String btn_saveSelectedMedia = "mpiwidget_form_ContentSelection_1_submit";

      //Object map declaration for checkbox to make the program as master program 
      
      static final String chk_masterProgram = "makeMaster";
  	  
	  static final String Lnk_masterprogram="link=";

      //Object map declaration for Edit button for Program Assets (on Program summar page)
      
      static final String btn_editProgramAsset = "document.forms[0].elements[4]";

      //Object map declaration for button to select survey
      
      static final String btn_addSurvey = "selectSurvey";

      //Object map declaration for Summary button
      
      static final String btn_summary = "_eventId_summary"; 

      //Object map declaration for Text box to search button
      
      static final String txt_searchSurvey = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[1]";

      //Object map declaration for button to find the survey
      
      static final String btn_searchSurvey = "//div[@id='dijit_layout_ContentPane_17']/div[1]/input[2]";

      //Object map declaration for Link to select the searched survey
      
      static final String lnk_selectSurvey = "//div[@id='dijit_layout_ContentPane_18']/div/div[1]/div";

      //Object map declaration for button to save selected survey
      
      static final String btn_saveSelectedSurvey = "mpiwidget_form_ContentSelection_3_submit";

      //Object map declaration for label for Pin protected status of the program on Program summary page
            
      static final String lbl_pinStatusVODSummaryPage = "//div[4]/div[3]/div[2]";
      
      
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
      
	// *****************Category Page Object Map*****************************
	
	//Object map declaration for Category link
	
	static final String LNK_Category = "//a[contains(text(),'Categories')]";
	
	//Object map declaration for Add Category 
	 
	static final String BTN_Add_Cat = "//button[@type='button']";
	
	//Object map declaration for Category name
	
	static final String LNK_Cat_Name = "//input[@id='name']";
	
	// Object map declaration for Category description
	 
	static final String LNK_Cat_description = "//textarea[@id='description']";
	
	// Object map declaration for Category Active
	static final String LNK_Cat_Active = "//input[@id='active']";
	
	//Object map declaration for Category Save
	 
	static final String BTN_Cat_Save = "//button[@id='_eventId_submit']";
	
	//Object map declaration for Category Existence
	
	static final String LNK_Cat_Exist = "//a[contains(text(),'Cat001')]";
	
	
	// *******************************Channel Page Object Map***************************************
	
	//Object map declaration for Channel link 
	 
	static final String LNK_Channel = "//a[contains(text(),'Channels')]";
	
	//Object map declaration for Add Channel button
	
	static final String BTN_AddChannel = "//button[@type='button']";
	
	//Object map declaration for Channel name textbox
			
	static final String TXT_ChannelName = "//input[@id='name']";
	
	//Object map declaration for Enable Channel checkbox
		
	static final String CHK_EnableChannel = "//input[@id='active.channel.listing']";
	
	//Object map declaration for selecting the Category from the available list
	 
	static final String Select_Category_Chnl = "//div[@id='mpiwidget_form_SloshBucket_0']/div[1]/div/div[1]";
	
	//Object map declaration for Moving the category to the selected list
	 
	static final String Move_Category_Chnl = "//div[@id='mpiwidget_form_SloshBucket_0']/div[2]/a[2]";
	
	//Object map declaration for Save button for Channel
	
	static final String BTN_SaveChannel = "//button[@id='_eventId_submit']";
	
	//Object map declaration for label(ChannelName)
	 
	static final String CHK_VerifyChannel = "//input[@name='id']";

	//Object map declaration for Delete Button 
	
	static final String BTN_DeleteChannel = "//button[@id='delete']";

	//Object map declaration for Delete Button 
		
	static final String BTN_ConfirmDeleteChannel = "//div[3]/div[2]/button[1]";

		
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
    
    //Object map declaration for delete channel button
    
    static final String btn_deleteChannel = "delete";
    
    //Object map declaration for confirm delete button
    
    static final String btn_confirmDeleteChannel = "//div[@id='mpiwidget_layout_ConfirmDialog_0']/div[2]/button[1]";
    
     
    
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
    
    
    
    //*********************RSS Discovery****************************//      
    
    
    //Polycom RSS discovery link
    static final String lnk_PolycomRSSDiscovery = "link=Polycom RSS Discovery";
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
    static final String lnk_DiscoveredProgram = "//tr[{0}]/td[6]/span/a";
    static final String lnk_DiscoveredProgramRSS2k = "//tr[{0}]/td[5]/span/a";

        
  //**************************Reporting Menu********************************//
    
    //****************On-demand Survey Summary Report**********************
    
    //ObjectMAp declaration for Reporting menu
    
    static final String lnk_reporting = "menu_reports_cont";

    //ObjectMAp declaration for Reports menu link
    
    static final String lnk_reports = "link=Reports";    

    //ObjectMAp declaration for start date
    
    static final String Cal_Startdate = "//td[1]/span";

    //ObjectMAp declaration for end date
    
    static final String Cal_Enddate = "//tr[6]/td[7]/span";

    //ObjectMAp declaration for radio button for Survay Summary report
    
    static final String radio_onDemandSurveySummary = "//input[@name='reportName' and @value='OnDemand_Program_Survey_Summary']";

    //ObjectMAp declaration for Next button on Reports page
    
    static final String btn_reportNext = "//button[@type='submit']";

    //ObjectMAp declaration for checkbox to select Poll answer on classic viewer protal
    
    static final String chk_selectOption1CVP = "qid_pa_question:";

    //ObjectMAp declaration for chackbox to select poll answer on classic viewer portal
    
    static final String chk_selectOptionCVP = "document.forms[0].elements[1]";

    //ObjectMAp declaration for Submit button for survey on classic viewer portal
    
    static final String btn_submitSurveyCVP = "submit";

    //ObjectMAp declaration for dropdown to select Program name 
    
    static final String drp_selectProgramReport = "input_programId";

    //ObjectMAp declaration for button to generate report
    
    static final String btn_runReport = "runReportButton";

    //ObjectMAp declaration for radio button to select Content storage report
    
    static final String radio_ContentStorage = "reportName";

    //ObjectMAp declaration for radio button to select Liv eProgram Survey Summary Report
    
    static final String radio_LiveProgramSurveySummary = "//input[@name='reportName' and @value='Live_Program_Poll_Summary']";

    //ObjectMAp declaration for dropdown to select POll or Survey option
    
    static final String drp_SelectPollorSurvey= "input_pollOrSurvey";

    //ObjectMAp declaration for survey text
    
    static final String txt_Survey="label=Survey";
    
//*****************************************************************************************************************************************************//    

//************************Live Broadcast Control****************************//
	
	// Object map declaration for clicking LBC icon
	 
	static final String LNK_LBC = "//img[@alt='Live Broadcast']";
	
	// Object map declaration for Launching LBC 
	 

	static final String LNK_Launch_Now = "link=Launch Broadcast Now";
	
	// Object map declaration for LBC 
	 
	static final String  Select_LBC = "lbc_false_esc_program";
	
	// Object map declaration for Saving LBC 
	 

	static final String Btn_Save_LBC_Summary = "archSubmit";
	
	// Object map declaration for Starting Sources
	 
	static final String Btn_Start_Source = "startSourcesButton";
		
	// Object map declaration for Provisioning Network
	

	static final String Btn_Prov_Network = "provisionNetworkButton";
	
	//div[4]/button
	
	// Object map declaration for Starting broadcast
	 

	static final String Btn_Start_Bcast = "startBroadcastButton";
	
	//div[7]/button
	
	//Object map declaration for Flipping Slides
	
	static final String Btn_Flip_Slide = "//img[@title='Next Slide']";
	
	// Object map declaration for Archiving(Checkpoint that Broadcast is started)
	
	static final String Btn_Pause_Archive = "pauseArchivingButton";
	
	// Object map declaration for checkbox to enable archiving for the live broadcast
	
    static final String chk_ArchiveLBC = "//td[1]/input";
    
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
    
    static final String img_audienceQuestionLBC = "//div[@id='mpiwidget_lbc_Questions_0']/div[3]/div[1]/div/div[4]/img";

    // Object map declaration for broadcast control tab
    
    static final String tab_broadcastControlLBC = "//div[@id='lbcTabControl']/span";
	
    static final String Txt_pollresultwindow = "pollresult";
    
	   static final String Txt_pollanswer="//table/tbody/tr/td/div/div/span[@value='ejsc-hint']/span[text()='1']/b[text()='Answer:']";
	   
	   
	   static final String Txt_pollresponse="//table/tbody/tr/td/div/div/span[@value='ejsc-hint']/span[text()='1']/b[text()='Responses:']";
	    
	   static final String Txt_pollresultwindowsvp="//div[@id='mpi_vp_Chart_0']/div[@class='titleBar']";
	    
	   
	   static final String Txt_pollresultanswersvp="//body/center/div[@id='mpi_vp_Chart_0']/div[@class='contents']/div/div/span[@class='ejsc-hint']/span[text()='Answer: 1']";
	    
	   static final String Txt_pollresultvotesvp="//body/center/div[@id='mpi_vp_Chart_0']/div[@class='contents']/div/div/span[@class='ejsc-hint']/span[text()='Vote: 1']";
	    
   static final String Btn_crosspollresult="//div[@id='mpi_vp_Chart_0']/div[@class='titleBar']/img[@class='closeButton']";
     
 
//*****************************************************************************************************************************************************//
    
//**********************************Classic Viewer Portal****************************//     
    
    //Home page link
    static final String tab_HomeCVP = "link=Home";
    
    //Search text box
    static final String txt_SearchCVP = "hdrSearchQuery";
    
    //Button for Search
    static final String btn_SearchCVP = "hdrSearchBtn";
    
    //Program Name link
    static final String lnk_ProgramNameCVP = "link=";
    
    //Video Link in the program
    static final String lnk_videoProgramCVP = "link=";
    
    //Select Time Zone drop down
    static final String drp_selectTimeZoneCVP = "tzSelection";
    
    //Select Time Zone drop down value
    static final String drp_selectTimeZone_valueCVP = "label=(GMT-8:00) Pacific Standard Time";
    
    //Select Time zone button
    static final String btn_selectTimeZoneCVP = "tzSelectButton";
    
    static final String title_playerWindow = "Qumu Program Player";
    
    static final String txt_privateCode = "privateCode";
    
    static final String btn_privateCodeSub = "privateCodeSubmit";
    
    //**********************Login/Logout to CVP*********************
    
    static final String lnk_LoginCVP = "loginLink";
    
    static final String txt_userNameCVP = "principalID";
    
    static final String txt_passwordCVP = "password";
    
    static final String btn_loginCVP = "//input[@value='Login']";
    
    static final String lnk_logOutCVP = "logoutLink";
       
    
    //**********************Upload EGC program CVP******************
    
    
    static final String lnk_myProgramCVP = "link=My Programs";
    
    static final String lnk_addEGCprogramCVP = "link=Add";
    
    static final String txt_egcProgramNameCVP = "title";
        
    static final String fileUPl_egcStreamingMediaCVP = "file"; 
    
    static final String btn_egcSaveprogramCVP = "//input[@value='Save']";
    
    static final String btn_egcSubmitprogramCVP="//input[@value='Submit for Approval']";
    
    
	//*********************Live_Program_CVP****************************	
	
	static final String window_pollCVP = "poll";
	
	static final String poll_answerOptionCVP = "//tr[4]/td[1]/input";
	
	static final String poll_answerSubmitCVP = "polSubmit";
	
	static final String tab_qaCVP = "//div[@id='playerTabs']/div[1]/div[3]/div/span[1]";
	
	static final String txt_questionCVP = "qText";
	
	static final String btn_questionSubmitCVP = "qSub";
	
	static final String tab_slideCVP = "//div[@id='playerTabs']/div[1]/div[1]/div/span[1]";
	
	static final String survey_answerCVP = "//tr[4]/td/input";
	
	static final String btn_answerSubmitSurvey = "submit";
    
    
    
//*****************************************************************************************************************************************************//
	
//**********************************Social Viewer Portal****************************//    

	//**********Variables for Juke Box********
	//Link for Home on SVP
    static final String LNK_HomeSVP =   "homeLink";
    
    //Search text box for All Videos
    static final String TBX_SearchSVP = "//div[@id='mpi_vp_JukeboxView_filter_2']/form[1]/div/div/input[1]";
    
    //Search box Arrows link
    static final String ICN_SearchBoxArrowlinkSVP = "//div[3]/form[1]/div/div/a[2]";
    //or
    //static final String ICN_SearchBoxArrowlinkSVP ="link=»"
   
    //click the link in search results
  //  static final String LST_Searchresult = "//div[@id='jukebox']/div[6]/div/div/div/a[1]";
    static final String LST_Searchresult = "//div[6]/div/div/div[{0}]/a[2]";
  
    //Link for All Videos
	static final String LNK_AllVideos = "link=All Videos";

   // Link for Poll window on SVP
	static final String LNK_PollWindow ="//div[@id='mpi_vp_Polls_0']/div[1]";
	
	//Checkbox on Poll WIndow
	static final String CHK_PollWindow ="//div[@id='mpi_vp_Polls_0']/div[2]/div[2]/form/input[1]";
	
	// Submit button on Poll window
	static final String BTN_PollWindow ="//input[@name='Submit']";
	
	// Q&A tab link for viewer question
	static final String tab_QA = "link=Q&A";
    
	//Ask button for submitting the viewer question
    static final String btn_Ask = "Ask";
    //Survey window
    static final String LNK_SurveyWindow= "//div[@id='mpi_vp_Polls_0']/div[1]/span";
    //select answer on survey pop up window
    static final String CHK_SurveyWindow= "//div[@id='mpi_vp_Polls_0']/div[2]/div[2]/form/input[1]";
    
  // Submit button for submitting the answer on survey
    static final String btn_SubmitSurveyanswer="Submit";



    //**********************************Login to SVP****************************// 
    
    static final String lnk_LoginSVP = "loginLink";
    
    static final String txt_userNameSVP = "//div[@id='__loginDialog__']/div[2]/input[1]";
    
    static final String txt_passwordSVP = "//input[@type='password']";
    
    static final String btn_loginSVP = "//input[@value='Login']";
    
    static final String lnk_logOutSVP = "logoutLink";
    
    //**********************************Upload EGC program SVP****************************// 
    
    
    static final String lnk_AddProgram_SVP = "//a[@id='ingestLink']/span";
    
    static final String lnk_MyVideoSVP = "//a[@id='myProgsLink']/span";
    
    static final String txt_egcProgramNameSVP = "title";
        
    static final String fileUPl_egcStreamingMediaSVP = "file"; 
    
    static final String btn_egcSaveprogramSVP = "//input[@value='Save']";
    
    static final String btn_egcSubmitprogramSVP="//input[@value='Submit for Approval']";   
       
    //************************SVP links under Home page************ 
    
    static final String LNK_SVP_HOME_LIVENOW="link=Live Now";   
   
    static final String LNK_SVP_ClickLiveProgramInList="//div[16]/div/div[2]/div/div/div[{0}]/div";
    	
    //************************SVP links under My Video************   
    static final String LNK_EditVODProgram = "link=Edit";

	//**************************SVP************************//
	
	// Object map declaration for Flipping Slides
	
	static final String Btn_Select_Timezone = "tzSelectButton";	
	
	   
    
	//*****************************************************************************************************************************************************//   
    
	// Channels
    
    static final String btn_channel_login = "login_button"; 
    
    // It is used to declare login button
     
 	
	//------------- Testing ---------
    
    static final String TB_loginbox = "loginbox";


  //*****************************************************************************************************************************************************//   
    // Transcoding 
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

     
   

      
}	

