package com.qa.columbia.executor;


import java.util.Calendar;
import java.util.Date;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * This class contains overloaded JUnit methods.
 *  
 */

public class TesterAsserter extends SeleneseTestCase{
	public static Calendar calendar = null;
	public static Date date = null;
	
  public TesterAsserter() {
  }

  private static String getTesterCallerName() {
	  String callerName = null;
	  for (int i=0; i<10; i++) {
		  callerName = getCallerName(i);
		  if (callerName.indexOf("_Tester.test") > -1) {
			  break;
		  }
	  }
	  if (callerName != null) {
		  try {
			  callerName = callerName.substring(TesterConstants.TEST_SUITE_PACKAGE_NAME.length());
		  } catch (Exception e) {
		  }
	  }
	  
	  return callerName;
  }
  
  
  private static String getCallerName(int callerLevel) {
    String caller = "<Unknown Class.Method>";
    try {
      throw new Exception("A trick to find the caller class and method");
    } catch (Exception e) {

      // Get the caller Class and Method
      caller = e.getStackTrace()[callerLevel].getClassName() + "." +
      e.getStackTrace()[callerLevel].getMethodName() +  "()";
    }

    return caller;

  }


  static private void recordSuccess (String Test_id, String msg, Date date) {
	  calendar = Calendar.getInstance();
	 TesterRunner.cntSuccess++;
	 
	//	Log to be displayed in the log file
	TesterLogger.getLoggerObject().logSuccess("<table border='0' width='100%' height='47'>");
	TesterLogger.getLoggerObject().logSuccess("<tr>");
	TesterLogger.getLoggerObject().logSuccess("<td width='25%'> <font color='#000000' face='Garamond'>"+Test_id+" </font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='35%'> <font color='#000000' face='Garamond'> " + msg +"</font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='10%' align='center'><font color='#000000' face='Garamond'> SUCCESSFULL </font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='15%' align='center'><font color='#000000' face='Garamond'> "+date+"</font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='15%' align='center'><font color='#000000' face='Garamond'> "+Calendar.getInstance().getTime()+"</font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("</tr>");
    TesterLogger.getLoggerObject().logSuccess("</table>");
    

  }

  static private void recordFailure (String Test_id,String msg) {
    
	  TesterRunner.cntFail++;
	String caller = getTesterCallerName();
    if (caller != null) {
    	
    }
    
    TesterLogger.getLoggerObject().logSuccess("<table border='0' width='100%' height='47'>");
	TesterLogger.getLoggerObject().logSuccess("<tr>");
	TesterLogger.getLoggerObject().logSuccess("<td width='25%'> <font color='#000000' face='Garamond'>"+Test_id+" </font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='35%'> <font color='#000000' face='Garamond'> " + msg +"</font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='10%' align='center'><font color='#000000' face='Garamond'> FAILURE </font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='15%' align='center'><font color='#000000' face='Garamond'> "+date+"</font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("<td width='15%' align='center'><font color='#000000' face='Garamond'> "+Calendar.getInstance().getTime()+" </font></td>");//"   == SUCCESSFUL == " + msg + " <BR>");
    TesterLogger.getLoggerObject().logSuccess("</tr>");
    TesterLogger.getLoggerObject().logSuccess("</table>");
  }

   /**
   * Reports a success
   */
  static public void success(String message) {
    assertTrue(message, true);
  }

//////////////////////////////////////////////////////
//These are overwritten from JUnit
//////////////////////////////////////////////////////
  
  static public void assertTrue(String Test_id,String message,Date date, boolean condition) {
      if (!condition) {
        fail(message);
      } else {
        recordSuccess(Test_id,message,date);
      }
  }
  
  //customize function for success
  static public void calladdnewcase(String Test_id, String message, String Results) {
      if (Results!="Pass") {
        fail(message);
      } else {
        recordSuccess(Test_id,message,date);
      }
  }
  
  
  
     static public void assertFalse(String Test_id, String message,Date date, boolean condition) {
      if (condition) {
    	  fail(message);
      }else{
    	  recordSuccess(Test_id,message,date);
    	  
      }
    }
  

  static public void fail(String Test_id, String message) {
	  
	  recordFailure(Test_id, message);
	  
  }
  public enum Resource 
  {
	  Cisco("Cisco"),Agility("Anystream Agility"),CSSLayouts("CSS Layouts"),WindowsMediaServer("Windows Media Server"),VideoNetEdge("VideoNet Edge"),   
	 PolycomRSS4000Devices("Polycom RSS4000 Devices"),Encoders("Encoders"),Akamai("Akamai"),Audiences("Audiences"), PolycomRSS2000Devices("Polycom RSS2000 Devices")
	 ,HTTP("HTTP Server"),MediaNet("MediaNet"),Storage("Storage"),Studios("Studios");
  
  private final String displayName;

  Resource(final String display)
  {
      this.displayName = display;
  }

  @Override public String toString()
  {
      return this.displayName;
  }}

}



  

