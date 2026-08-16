@echo off
rem ------------------------------------------------------------------------------
rem Gradle - Copyright 2012-2023 the Gradle authors
rem ------------------------------------------------------------------------------
setlocal
set DIRNAME=%~dp0n
rem Make sure the current dir is the script dir
cd /d "%DIRNAME%"
set "APP_HOME=%DIRNAME%"
set JAVA_EXE=java
if defined JAVA_HOME (
  if exist "%JAVA_HOME%\bin\java.exe" set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
)
"%JAVA_EXE%" -classpath "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
endlocal
