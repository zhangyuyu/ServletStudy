#!/bin/sh

BUILD_PATH=build/classes/main

mkdir -pv build/jar
jar cvf build/jar/ServletHelloWorld.jar $BUILD_PATH