#!/bin/sh

# CUSTOMER_PATH=src/main/java/model/Customer.java
# HELLO_PATH=src/main/java/servlet/Hello.java
# BUILD_PATH=build/classes/main
# SERVER_PATH=src/main/lib/javaee-api-6.0.jar

# mkdir -pv build/classes/main
# mkdir -pv build/lib

# javac -d $BUILD_PATH $CUSTOMER_PATH
# javac -d $BUILD_PATH -classpath $BUILD_PATH:$SERVER_PATH $HELLO_PATH

# cp src/main/webapp/WEB-INF/web.xml build/lib/web.xml

SERVLET_PATH=src/main/java/ServletExample.java
BUILD_PATH=build/classes/main

mkdir -pv build/classes/main

javac -d $BUILD_PATH -classpath /usr/local/Cellar/tomcat/8.0.26/libexec/lib/servlet-api.jar $SERVLET_PATH