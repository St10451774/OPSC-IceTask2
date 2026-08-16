#!/usr/bin/env sh
# gradlew - Gradle wrapper script (UNIX)
set -e
###############################################################################
# Gradle startup script for UN*X
###############################################################################
# Determine the location of the script
PRG="$0"
while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`"/$link"
  fi
done
PRGDIR=`dirname "$PRG"`
# OS specific support (must be 'true' or 'false')
cygwin=false
darwin=false
case "`uname`" in
  CYGWIN*) cygwin=true ;;
  Darwin*) darwin=true ;;
esac
if $cygwin ; then
  [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
  [ -n "$GRADLE_USER_HOME" ] && GRADLE_USER_HOME=`cygpath --unix "$GRADLE_USER_HOME"`
fi
if [ -n "$JAVA_HOME" ] ; then
  JAVACMD="$JAVA_HOME/bin/java"
else
  JAVACMD=`which java 2>/dev/null || true`
  if [ -z "$JAVACMD" ] ; then
    JAVACMD=java
  fi
fi
# Execute Gradle wrapper
exec "$JAVACMD" -classpath "$PRGDIR/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
