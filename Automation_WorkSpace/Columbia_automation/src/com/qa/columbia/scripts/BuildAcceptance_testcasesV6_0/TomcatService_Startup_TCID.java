/*
*  Classname                                                       TomcatService_Startup 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure the Apache Tomcat is installed.<br>
* What the script does:											    >Start up the apache tomcat service. 
* 																	
* What Verification it performs:									Verify that 'Tomcat service is started successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 15/06/2011
* Updated by/on date: 												QASource on 15/06/2011
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

public class TomcatService_Startup_TCID extends TesterAsserter  {
	
	static Date date=Calendar.getInstance().getTime();
	
	public void test_ApacheTomcatService_Startup() throws Exception {
    {
	Process p2=null;
	Process servstate2=null;
	Process serv_state= null;
	String line2,lineval=null;
    try {
		Utility_Functions utilityFunction = new Utility_Functions(); 
		//verify the service is already running
		servstate2=Runtime.getRuntime().exec("cmd /c sc query Tomcat5");
		BufferedReader input2 = new BufferedReader(new InputStreamReader(servstate2.getInputStream()));
		while ((line2 = input2.readLine()) != null) {
			   lineval= line2+lineval;  }
		//Start the service if it not already running
		  try{ if(!lineval.contains("RUNNING")){
		     p2 = Runtime.getRuntime().exec("cmd /c sc start Tomcat5");
		     System.out.print("Tomcat Service has been started");
		     utilityFunction.waitForChangesToReflect();			        
		     // verify the status of service after starting
		     serv_state=Runtime.getRuntime().exec("cmd /c sc query Tomcat5");
		     BufferedReader input_verify = new BufferedReader(new InputStreamReader(serv_state.getInputStream()));
		     String checkstate=null;
		       while ((line2 = input_verify.readLine()) != null) {
		           // comment below statement to hide the servcie state details
		           //System.out.println(line2); //<-- Parse data here.
		            checkstate= line2+ checkstate;     }
			       if  (checkstate.contains("RUNNING")){
			           System.out.print("Tomcat Service is running successfully");}
			       else {
			    	    System.out.print("Tomcat Service is running successfully");
			            serv_state.destroy();
			            serv_state.exitValue();}
               input2.close();}
		     else{  	          
		         System.out.print("Tomcat Service is already running successfully");}
		   }catch (IOException e) {
			     // throw  the exception in case the service is not started due to any reason
			    System.out.println(" There has encountered a problem in starting the service");
			    System.out.println(e.toString());
			    servstate2.exitValue();
			    servstate2.destroy();}
	 }catch(Exception err){
		err.printStackTrace(); }
	finally  {
	  servstate2.destroy();
	  serv_state.destroy();
	  serv_state.exitValue();
	  p2.destroy();
	  p2.exitValue();
			    	   
		  }
			     
    }
  }
}
			       
			
		
	
	
