# Name-Sorter-Service

The Goal: Name Sorter
Build a name sorter. Given a set of names, order that set first by last name, then by any given names the person may have. A name must have at least 1 given name
and may have up to 3 given names.

Name-Sorter-Service is a springboot project using REST api to read unsorted names from input file then sort them and write he sorted names to outputfile
and return the sorted output to GET rest api as well.

NameResource - is a RestController with a method name sortNameList() with GET rest api to fetch sorted names.
                Lombok is used to autowire NameSorterService with constructor.                
                               
NameSorterService - is a service class which reads unsorted names from input file and then sort them first with lastName and then with FirstName and 
                write sorted names to output file and returns the sorted name list.

AppProperties - read properties from application.properties file.

TESTs  
various test classes are available under tests folder.

Deployment 
Name-Sorter-Service is deployed on local Jenkins running on port 8080.

Installation
* JDK, For installation - https://www.oracle.com/java/technologies/downloads/  
* maven
* SpringBoot 3.1.0
* lombok
* jenkins

