# JDBC hands-on

Repository with source code of examples used in the JDBC course taught by Rodrigo Martins Pagliares at UNIFAL-MG.

# MySQL

MySQL database used in this course:
   - hostelapp_jdbc

MySQL credentials used in this course:
   - user: florentino
   - password: 123456

The user florentino was granted all privileges a root user has. 

The database hostelapp_jdbc and user florentino were created with aid of PHP MyAdmin that comes bundled with MAMP.

SQL script used to create and populate the tables in the MySQL database (See SQL_Scripts folder in this repository).
   - SQL_Scripts/Hostel_App_SQL_Script.sql
   - Use PHP MyAdmin, MySQL monitor (from terminal/console) or any other SQL front-end to import/execute the scripts contents.
   
# MySQL Connector/J

To configure the JDBC Driver for MySQL (Connector/J) on Maven, include the following lines on the dependencies section of pom.xml (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>

To configure the JDBC Driver for MySQL (Connector/J) on Gradle, include the following lines on dependencies section of the build.gradle (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'


# Examples

01 - MySQLConnectionTestJDBCDriverWithoutBuildTool 
   - This example project shows how to connect to a MySQL database without using a build tool to include de JDBC Driver for MySQL known as Connector/J 
   - The  JDBC driver is included by placing the Connector/J in the souce path of the project (lib folder in the example).

02 - MySQLConnectionTestJDBCDriverWithMaven
   - This example project, as the previous project, shows how to connect to a MySQL database, but this time using a build tool (Maven) including de JDBC Driver for MySQL known as Connector/J in the project (configuring the dependency on the pom.xml file and not including in on the lib folder of the project.
    
03 - MySQLConnectionTestJDBCDriverWithGradle
   - Same as previous project, but with Gradle build tool instead of Maven.
   
04 - SQLSelectQueryExample
   - This example project builds upon the previous example, adding a simple SELECT query to the database.
   - The simple SELECT query returns the number of rows of the admin table of the hostelapp_jdbc database.

05 - DatabaseConnectionEncapsulation
   - This example project builds upon the previous example, refactoring it in order to encapsulate the data needed to connect to a database.
   - After this refactoring, it will be easier to evolve the code to support additional RDBMs

06 - JDBCExceptionHandling
   - This example project builds upon the previous example, refactoring it in order to create more readable and succint code by automatically closing JDBC resources with try with resoursces feature of Java SE.

07 - Java7TryWithResources
   - This example project builds upon the previous example, refactoring it in order to create more readable and succint code by automatically closing JDBC resources with try with resoursces feature of Java SE.
   
