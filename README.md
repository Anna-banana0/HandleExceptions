# HandleExceptions
A config.xml file has been created for some exceptions, i.e take some actions when a particular type of exception is caught.
Use of DOM parser was done to validate and parse the xml file and call the action name from the properties file.
The actions taken here are like sending email to concerned party, logger and Abort.
The Test.java has the main method that calls for a particular exception.
