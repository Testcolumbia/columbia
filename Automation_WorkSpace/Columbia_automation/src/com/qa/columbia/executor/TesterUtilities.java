package com.qa.columbia.executor;


import java.lang.reflect.*;

/**
 * This class contains utility methods like generating strings and random strings etc
 * 
 */
public class TesterUtilities {


 private Method[] getMethodsOfClass(String testClassName) 
 {
      
	  Class testClass = null;
	  
	  try {
		  testClass= Class.forName(testClassName);
	  } catch (Exception e) {
		  
		  return null;
	  }
	  
	  
	  return testClass.getMethods();
	  
  }
  
  protected Method[] getTestMethodsOfClass(String testClassName) {
	  
	  Method[] theMethods = getMethodsOfClass(testClassName);
	 	  
	  if (theMethods == null) {
		  return null;
	  } 
	  
	  Method[] tempTestMethods = new Method[1];
	 
	 
      for (int i = 0; i < theMethods.length; i++) {
    	  
          String methodString = theMethods[i].getName();
          if (methodString.equals("setUp")) {
        	  
        	        	  
    	  }  else if (methodString.startsWith("test")) {
    		  tempTestMethods[0] = theMethods[i];
          }
          
      }
      System.out.println("Size of the methods:"+tempTestMethods.length);
      return tempTestMethods;
	  
	  
   }

  protected int runTestMethodsOfTestClass(String testClassName) {
	  Method[] theMethods = getTestMethodsOfClass(testClassName);
	  int failedMethods = 0;
	  int ranMethods = 0;
	  long start = System.currentTimeMillis();
	 
	  int numbOfTestMethods = 0;
	  
	  if ((theMethods == null)) {
		  TesterLogger.getLoggerObject().logFail("<font color='#000000' face='Garamond'>There was a problem getting the Class of '" + testClassName + "'.</font><BR>");
		  return 0;
	  } else if ((theMethods.length == 0)) {
		  showMsg("<font color='#000000' face='Garamond'>There is no Test method in Test Class '" + testClassName + "'. </font");
		  return 0;
	  } else {
		  
		  numbOfTestMethods = theMethods.length ; // We don't include Setup method
		  Object testObject = null;
		  
		  showMsg("  ---- Started running " + numbOfTestMethods  + " Test methods of Tester class '" + testClassName + "'");
		  System.out.println("Class name:"+testClassName);
		  int i1=testClassName.lastIndexOf(".");
		  String className=testClassName.substring(i1+1);
		 TesterLogger.getLoggerObject().logSuccess("<table border='0' width='100%' height='47'>");
		 TesterLogger.getLoggerObject().logSuccess("<tr>");
		 TesterLogger.getLoggerObject().logSuccess("<td width='33%'> <font color='#000000' face='Garamond'>"+className+ "</font></td>");
		 TesterLogger.getLoggerObject().logSuccess("</tr>");
		 TesterLogger.getLoggerObject().logSuccess("</table>");
		    
		 try {
			  Class testClass= Class.forName(testClassName);
			  Constructor constructor = testClass.getConstructor(null);
		      testObject = constructor.newInstance(null);
		 } catch (Exception e) {
			  return 0;
		 }
		  
	      for (int i = 0; i < theMethods.length; i++) {
	    	  Method testMethod = theMethods[i];
	    	  if (testMethod != null) {
		    	  try {
		 
		    		  System.out.println("Test object:"+testObject);
		    		  System.out.println("Test Method:"+testMethod.getName());
		    		  testMethod.invoke(testObject, null);
		    		  
					  showMsg(" Finished running method '" + testMethod.getName() + "'");
				  } catch (Exception e) {

					  e.printStackTrace();
					  failedMethods++;
				  } finally {
					  ranMethods++;
				  }
	    	  }
	      }
	  }

	  String failedMsg = "";
	  if (failedMethods > 0) {
		  failedMsg = failedMethods + " Test methods threw exception after invocation.";
	  }
	  showMsg("  ---- Finished running " + numbOfTestMethods  + " Test methods of Class '" + testClassName + "' in " + ((System.currentTimeMillis() - start)/1000) + " seconds. " + failedMsg );
	  TesterLogger.getLoggerObject().logSuccess("=========================================================================================================================" );
	  showMsg("");
	  
	  return 1;  // exclude Setup and Cleanup methods
	  
  }
  
  public String getElapsedTimeString (long millis) {
	  long seconds = millis / 1000;
	  long minutes = seconds / 60;
	  long hours = minutes / 60;
	  
	  return hours + " hour(s), " + (minutes % 60) + " minute(s), " + (seconds % 60) + " second(s)";
	  
  }
	
	static protected void showMsg (String msg) {
		System.out.println(">>>> " + msg);
	}
	
	static protected void showErr (String msg) {
		System.err.println(">>>> " + msg);
	}

	  
	public static void result(Class testClass){
				
		TesterLogger.getLoggerObject().logSuccess("<table border='0' width='100%' height='47'>");
		TesterLogger.getLoggerObject().logSuccess("<tr>");
		TesterLogger.getLoggerObject().logSuccess("</tr>");
		TesterLogger.getLoggerObject().logSuccess("<BR>");
		TesterLogger.getLoggerObject().logSuccess("<tr>");
		TesterLogger.getLoggerObject().logSuccess("<td width='50%' bgcolor='#CCCCFF'><b><font color='#000000' face='Garamond'>Test Case Description</font></b></td>");
		TesterLogger.getLoggerObject().logSuccess("<td width='50%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>Result</font></b></td>");
		TesterLogger.getLoggerObject().logSuccess("</tr>");
		TesterLogger.getLoggerObject().logSuccess("</table>");
		
	
		
	}

}
