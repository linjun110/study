#!/bin/bash
keytool -genkey -alias tomcat -keyalg RSA
# .keystore file is store in the dir where the command is executed.

# ref: http://tomcat.apache.org/tomcat-8.0-doc/ssl-howto.html
# beware: the password should be the same during creating keystore

<Connector port="8081" protocol="org.apache.coyote.http11.Http11NioProtocol"
maxThreads="200"
scheme="https" secure="true" SSLEnabled="true"
keystoreFile="${user.home}/.keystore" keystorePass="linjunAmazon"
clientAuth="false" sslProtocol="TLS"
connectionTimeout="20000"
redirectPort="8443" />
