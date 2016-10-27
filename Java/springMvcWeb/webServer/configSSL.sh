#!/bin/bash
keytool -genkey -alias tomcat -keyalg RSA
# .keystore file is store in the dir where the command is executed.

# ref: http://tomcat.apache.org/tomcat-8.0-doc/ssl-howto.html
# beware: the password should be the same during creating keystore
