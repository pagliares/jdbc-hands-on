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
   - This example project builds upon the previous example, encapsulating the JDBC error handling in an utilitary classs.

07 - Java7TryWithResources
   - This example project builds upon the previous example, refactoring it in order to create more readable and succint code by automatically closing JDBC resources with try with resoursces feature of Java SE.

08 - ResultSetNavigation
   - This example project builds upon the previous example, creating a utility class (Guests) with a static method (Guests.displayData(ResultSet)) that prints to the console details of the GUEST table in the database.
   - The example demonstrates the use of the method next (responsible to move forward a ResultSet cursor)
   - The example also demonstrates the methods rs.getInt(String columnName), rs.getString(String columnName) of an object ResultSet  
   - The example also illustrates how to concatenate strings with StringBuffer (to avoid creating a new String objec on each concatenation)
   
09 - ScrollableResultSet
   - This example project demonstrates several ResultSet methods that moves the cursor between elements in the ResultSet
   - Methods discussed: rs.last(), rs.first(), rs.absolute(int row), rs.getRow();
   - The example demonstrates two ways to get an objetc Statement: 			 
   
    1. Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    2. Statement stmt = conn.createStatement();
    
   - The first option creates a scrollable ResultSet. 
   - The second option is RDBMS specific. In case of MySQL it returns a forward only ResultSet.

