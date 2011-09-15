/*
*  Classname                                                       QumuService_Startup 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure the Qumu application is deployed on Host<br>
* What the script does:											    >Start up the Qumu service. 
* 																	
* What Verification it performs:									Verify that 'Qumu service is started successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 16/06/2011
* Updated by/on date: 												QASource on 16/06/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import java.io.*;

public class QumuService_Startup_TCID extends TesterAsserter  {
	
	static Date date=Calendar.getInstance().getTime();
	
	public void test_ApacheTomcatService_Startup() throws Exception {
    {

	Process servstate2=null;
	Process serv_state= null; 
	String line2,lineval=null;
    
	try {
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String global_path ="Global_variables.xml";
		
		String Var_QumuServiceName= utilityFunction.GetValue(global_path,"VAR_QumuServiceName");
		String Var_Service_Status="cmd.exe /c sc query " + Var_QumuServiceName;
		String Var_Service_Start= "cmd.exe /c sc start " + Var_QumuServiceName;
		
		//verify the service is already running
		servstate2=Runtime.getRuntime().exec(Var_Service_Status);
		BufferedReader input2 = new BufferedReader(new InputStreamReader(servstate2.getInputStream()));
		while ((line2 = input2.readLine()) != null) {
			   lineval= line2+lineval;  }
		//Start the service if it not already running
		  try{ if(!lineval.contains("RUNNING")){
		     Runtime.getRuntime().exec(Var_Service_Start);
		     System.out.println("Qumu startup Service has been started");
		     utilityFunction.waitForChangesToReflect();			        
		     // verify the status of service after starting
		     serv_state=Runtime.getRuntime().exec(Var_Service_Status);
		     BufferedReader input_verify = new BufferedReader(new InputStreamReader(serv_state.getInputStream()));
		     String checkstate=null;
		       while ((line2 = input_verify.readLine()) != null) {
		           // comment below statement to hide the service state details
		           System.out.println(line2); //<-- Parse data here.
		            checkstate= line2+ checkstate;     }
			       if  (checkstate.contains("RUNNING")){
			    	  	assertTrue("TCXX","Verify that Qumu service is running Successfully", date, checkstate.contains("RUNNING"));
			          }
			       else {
			    	   assertFalse("TCXX","Verify that Qumu service failed to run Successfully", date, checkstate.contains("RUNNING"));
			    	 	serv_state.destroy();
			            serv_state.exitValue();}
               input2.close();
               } else{  
		    	  assertTrue("TCXX","Verify that Qumu service is running Successfully", date, lineval.contains("RUNNING")); 
               }
		   }catch (IOException e) {
			    // throw  the exception in case the service is not started due to any reason
			    System.out.println("There has encountered a problem in starting the service");
			    System.out.println(e.toString());
			  }
	 }catch(Exception err){
		err.printStackTrace(); }
	finally  {
	  servstate2.destroy();
	 // serv_state.destroy();
	 // serv_state.exitValue();
	
		  }		     
    }
  }
}
			       
			
		
	
	
