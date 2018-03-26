@Title Mobile Banking API automation 4.0 %Date% %Time%
@set path=C:\Program Files (x86)\Java\jdk1.8.0_144\bin
@set projloc=C:\Users\brantansp\Desktop\MobileBankingAPI_4.0
@cd %projloc%
@set classpath=%projloc%\lib\*;%projloc%\target\classes;%projloc%\target\test-classes
@java -Dlog4j.configuration=file:%projloc%\property\log4j.properties org.testng.TestNG testng.xml
@pause