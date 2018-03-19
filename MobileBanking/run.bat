@set path=C:\Program Files\Java\jdk1.8.0_60\bin
@set projloc=D:\MobileBankingAPI_4.0
@cd %projloc%
@set classpath=%projloc%\lib\*;%projloc%\target\classes;%projloc%\target\test-classes
@java -Dlog4j.configuration=file:%projloc%\property\log4j.properties org.testng.TestNG testng.xml
@pause