Amazon provides a sample implementation of the kinesis client library for python, node.js and .net but they do not provide one for java. It is very straight-forward but I thought some people could save some time if they had one. 

This implemenation uses Java 1.7 and maven. Build with command:

   mvn assembly:assembly -DdescriptorId=jar-with-dependencies

Run with command:

   java -cp target/amazon-kinesis-client-java-1.0-SNAPSHOT-jar-with-dependencies.jar com.despart.Application
