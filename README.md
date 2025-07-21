How to create a jar file which doesn't have a main method and use that jar file from another jar file as dependency while running a program?

I am answer that  question and gave the example java program for your understanding.
 in this i create a two projects using maven project.

  1)Create jar file which doesn't have a main method-install .jar
 First project name is  "HelloProject"    -this does n't have any main method.
  i am create the simple maven project and giving the groupid is "com.example"
                                                      artifactid is "HelloProject".
project folder src/main/java -i am create one package name "Hello".inside this package create one class name is "hello". inside this class i am created one method name is "getMessage"  ,this method only return "Hello,How are you?".
in that project folder ->right click ->run as ->maven install . now we see console window project will be build step by step and build is success.     after that in your projet structure in  "Target folder" automatically 
created one jar file,the file name is "HelloProject-0.0.1-SNAPSHOT.jar".

2) use that jar file from another jar file as dependency while running a program?
   Now i am create the another maven project name is "HelloMainProject".
                          in this project groupid is "com.example".
                                          artifactid is "HelloMainProject"        
	 
      in this project folder create a new folder name is "lib".
      in that lib folder inside privious project jar file "HelloProject-0.0.1-SANPSHOT.jar " copy and save this folder.

	 after that pom.xml add privious project jar file dependencies in this project.
                  <dependencies>
                     <groupId>com.example</groupId>
                     <artifactId>HelloProject</artifactId>
                     <version>0.0.1-SNAPSHOT</version>
                     <scope>system</scope>
                     <systemPath>${project.basedir}/lib/HelloProject-0.0.1-SNAPSHOT.jar</systemPath>
										 <dependency>
  	                 <groupId>com.example</groupId>
  	                 <artifactId>HelloProject</artifactId>
                     <version>0.0.1-SNAPSHOT</version>
                     </dependency>
                 </dependencies>

	update the pom.xml and save.

		after that src/main/java create the package name is "HelloMain".
    in this package inside i am create one class name is "hellomain".
      hellomain.class inside i am create one main method  call that get.message method and print message.
   run the java application you see your console "Hello,How are you?".
   how to print this message in your console- in the HelloProject-0.0.1-SNAPSHOT.jar is used for dependencies as a HelloMainProject.Helloproject-0.0.1-SNAPSHOT.jar is install in the local repository so the
   HelloMainProject verify the repository and print the message.

	 after that package the HelloMainProject.for using maven package command.then target folder you see the one jar file "HelloMainProject-0.0.1-SNAPSHOT.jar".


in this project i am convert in docker image run the container the "Hello,How are you?" the result will show the terminal.
how to build the docker image and run the container?
answer for the question is first HelloMainProject folder inside create the dockerfile and docker-compose.yml file.
 dockerfile:
 FROM openjdk:17-jdk-slim
 WORKDIR /app

 docker-compose.yml
  "version: "3.8"

services:
  hellomain:
    build: .   
    container_name: hellomain-container
    working_dir: /app
    volumes:
      - ./target:/app/target
      - ./lib:/app/lib
    command: >
      java -cp target/HelloMainProject-0.0.1-SNAPSHOT.jar:lib/HelloProject-0.0.1-SNAPSHOT.jar HelloMain.hellomain "
save the file in the HelloMainProject folder inside.
open terminal in this folder:
 command    " docker-compose up --build "
 in this command create image,and container  in terminal show the message "Hello,How are you?".

 and i am also add the docker image in github package. you are go that folder pull the image and run the container in your system.


   
																											



