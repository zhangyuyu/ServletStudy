#!/bin/sh

CUSTOMER_PATH=src/main/java/model/Customer.java
HELLO_PATH=src/main/java/servlet/Hello.java
BUILD_PATH=build/classes/main
SERVER_PATH=src/main/lib/javaee-api-6.0.jar

mkdir -pv build/classes/main
javac -d build/classes/main $CUSTOMER_PATH

javac -d $BUILD_PATH -classpath $BUILD_PATH:$SERVER_PATH $HELLO_PATH