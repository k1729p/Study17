@echo off
set JAVA_HOME=C:\PROGRA~1\JAVA\JDK-24
set M2_HOME=c:\\tools\\apache-maven-3.9.9
pushd %cd%
cd ..
chcp 65001 > nul 2>&1
call %M2_HOME%\bin\mvn clean install exec:java
pause
popd