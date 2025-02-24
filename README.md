# Java 9 to 21

Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd.,

Email: banuprakashc@yahoo.co.in; banuprakash.cr@gmail.com; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/Java_21

===================================

Softwares Required:

1) openJDK 21
https://jdk.java.net/java-se-ri/21

Option 1:
install and add path
vi ~/.zshrc
export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21
export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH

Option 2: [better]

USE SDKMAN to manage java

curl -s "https://get.sdkman.io" | bash

sdk install java 21.0.6-tem

sdk default java 21.0.6-tem 

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.


2) IntelliJ Ultimate edition https://www.jetbrains.com/idea/download/?section=mac

========

java 9 - 21 Features:

Java 9(September 2017) : Java Module System, StackWalker, ADS, JShell, FlightRecorder, Stream takeWhile, dropWhile

Java 10(March 2018) : Local Variable Type Inference, List.copyOf for immutable collection

Java 11(September 2018) : Local Variable Type in Lambda Expressions

Java 12(March 2019) : String Indent, Repeat, strip, isBlank and Transform, Teeing Collector [https://boottechnologies-ci.medium.com/java-stream-api-exploring-collectors-teeing-collector-16f260e9c492]

Java 13(September 2019) : TextBlocks

Java 14(March 2020) : arrow and yield in switch, Helpful NullPointerExceptions

Java 15(September 2020) : Garbage Collector Updates

Java 16(March 2021) : Pattern Matching for instanceof

Java 17(September 2021) : Sealed Class

Java 18: jwebserver [simple web server]

Java 21(September 2023) : Virtual Threads, StringTemplate, Record Patterns,  Pattern Matching for Switch

========

JPMS: Java Module System --> Project Jigsaw

com.visa.prj.service package

com.visa.prj.repo package


OSGi --> Open service gateway initaitive

METAINF.MF
EXPORTS: com.visa.prj.service
IMPORTS: com.visa.security

JPMS:
* Better Encapsulation
* More readable
* Smaller footprint

Dockerfile
FROM openjdk:8-jdk-alpine
COPY target/docker-java-jar-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

java --list-modules
java --describe-module java.logging
java --describe-module java.sql 

Types of modules:
* System modules : java --list-modules
* Unnamed modules: modules without module-info.java
* Automatic modules: jars added to module-path and not to class-path. By default "jar" file becomes the module name, until mentioned in META-INF/MANIFEST.MF

Maven Multi-module and JPMS with ServiceLocator

jlink --module-path util.jar:impl.jar:client.jar --add-modules client,util,impl --output myimage --launcher MYAPP=client/pkg.Main
