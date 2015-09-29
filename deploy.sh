# #!/bin/sh

# WEB_PATH=/usr/local/Cellar/tomcat/8.0.26/libexec/webapps/testHello/WEB-INF
# BUILD_PATH=/usr/local/Cellar/tomcat/8.0.26/libexec/webapps/testHello/WEB-INF/lib/build

# cd $WEB_PATH/lib
# jar xvf ServletHelloWorld.jar 

# cp $BUILD_PATH/classes/main/model/Customer.class $WEB_PATH/classes/Customer.class
# cp $BUILD_PATH/classes/main/servlet/Hello.class $WEB_PATH/classes/Hello.class
# cp $BUILD_PATH/lib/web.xml $WEB_PATH

# /usr/local/Cellar/tomcat/8.0.26/libexec/bin/startup.sh

#!/bin/sh

WEB_PATH=/usr/local/Cellar/tomcat/8.0.26/libexec/webapps/hello/WEB-INF
BUILD_PATH=/usr/local/Cellar/tomcat/8.0.26/libexec/webapps/hello/WEB-INF/lib/build

cd $WEB_PATH/lib
jar xvf ServletHelloWorld.jar 

cp $BUILD_PATH/classes/main/ServletExample.class $WEB_PATH/classes/ServletExample.class

/usr/local/Cellar/tomcat/8.0.26/libexec/bin/startup.sh --daemon