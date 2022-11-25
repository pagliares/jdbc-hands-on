# JDBC hands-on

Repository with source code of examples used in the JDBC hands-on course taught by Rodrigo Martins Pagliares at UNIFAL-MG.

## MySQL

Before running the examples in this repository, make sure that:

- You have started MySQL (the examples use the default port, 3306)
- You have created a database called hostelapp_jdbc
- You have created a MySQL user named florentino with password 123456
- You have executed the SQL script SQL_Scripts/Hostel_App_SQL_Script.sql to create and populate the tables used in the hostelapp_jdbc database (necessary in all examples after SQLSelectQueryExample).

If you decide to use other names for the database, user or another password, just remember to adjust the following constants in the examples:

private static final String USERNAME = <strong>"florentino"</strong>;

private static final String PASSWORD = <strong>"123456"</strong>;

private static final String CONNECTION_STRING ="jdbc:mysql://localhost:<strong>3306/hostelapp_jdbc</strong>";


### MySQL database used in this course:
   - hostelapp_jdbc

### MySQL credentials used in this course:
   - user: florentino
   - password: 123456

In this hands-on, the  user florentino is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**. The user florentino is granted all privileges a root user has (also with the aid of **PHP MyAdmin**). 

### The database hostelapp_jdbc used in this course:

In this hands-on, the database hostelapp_jdbc is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**.

An **SQL script** is used to create and populate the tables in the **MySQL database** (See SQL_Scripts folder in this repository).
   - SQL_Scripts/Hostel_App_SQL_Script.sql
   - Use **PHP MyAdmin**, **MySQL monitor** (from terminal/console) or any other **SQL front-end** to import/execute the scripts contents.
   
### MySQL Connector/J

To configure the **JDBC Driver for MySQL (Connector/J)** on **Apache Maven**, include the following lines on the dependencies section of pom.xml (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>

To configure the **JDBC Driver for MySQL (Connector/J)** on **Gradle**, include the following line on the dependencies section of the build.gradle (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

<code>implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'</code>


## Examples discussed in this hands-on

01 - MySQLConnectionTestJDBCDriverWithoutBuildTool 
   - This example project shows how to connect to a MySQL database without using a build tool to include de JDBC Driver for MySQL known as Connector/J 
   - The  JDBC driver is included by placing the Connector/J in the source path of the project (lib folder in the example).

<p align="center">
    <img width="238" height="127" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/01_Class_Diagram.png" alt="UML class diagram">
</p>

02 - MySQLConnectionTestJDBCDriverWithMaven
   - This example project is identical the previous project that shows how to connect to a MySQL database. The only difference is that this version uses a build tool (Maven). The JDBC Driver for MySQL known as Connector/J is included in the project (configuring the dependency on the pom.xml file and not including in on the lib folder of the project).
   
    <dependencies>
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>
    </dependencies>
    
03 - MySQLConnectionTestJDBCDriverWithGradle
   - Same as previous project, but with Gradle build tool instead of Maven.

`dependencies {
    implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'
}`
   
04 - SQLSelectQueryExample
   - This example project builds upon the previous example, adding a simple SELECT query to the database.
   - The simple SELECT query returns the number of rows of the admin table of the hostelapp_jdbc database.

05 - DatabaseConnectionEncapsulation
   - This example project builds upon the previous example, refactoring it in order to encapsulate the data needed to connect to a database.
   - After this refactoring, it will be easier to evolve the code to support additional RDBMs.

<p align="center">
    <img width="710" height="424" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_DatabaseConnectionEncapsulation.png" alt="UML class diagram">
</p>

06 - JDBCExceptionHandling
   - This example project builds upon the previous example, encapsulating the JDBC error handling in an utilitary classs (method processException(SQLException e).

<p align="center">
    <img width="705" height="321" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_DIagram_JDBCExceptionHandling.png" alt="UML class diagram">
</p>


07 - Java7TryWithResources
   - This example project builds upon the previous example, refactoring it in order to create more readable and succint code by automatically closing JDBC resources with try with resources feature of Java SE.

08 - ResultSetNavigation
   - This example project builds upon the previous example, creating a utility class (Guests) with a static method (Guests.displayData(ResultSet)) that prints to the console details of the GUEST table in the database.
   - The example demonstrates the use of the method next (responsible to move forward a ResultSet cursor).
   - The example also demonstrates the methods rs.getInt(String columnName), rs.getString(String columnName) of an object ResultSet.  
   - The example also illustrates how to concatenate strings with StringBuffer (to avoid creating a new String object on each concatenation).

<p align="center">
    <img width="591" height="379" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_ResultSetNavigation.png" alt="UML class diagram">
</p>
   
09 - ScrollableResultSet
   - This example project demonstrates several ResultSet methods that moves the cursor between elements in the ResultSet
   - Methods discussed: rs.last(), rs.first(), rs.absolute(int row), rs.getRow();
   - The example demonstrates two ways to get an object Statement: 			 
   
    1. Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    2. Statement stmt = conn.createStatement();
    
   - The first option creates a scrollable ResultSet. 
   - The second option is RDBMS specific. In case of MySQL it returns a forward only ResultSet.
   
   <strong>Good practice</strong>: explicitly indicate a scrollable ResultSet with the constant ResultSet.TYPE_SCROLL_INSENSITIVE when creating a Statement

10 - LimitedRowsResultSetBadSolution
   - This example project illustrates one way to limit the number or results (rows) in a resultset: method setMaxRows(int rows) of Statement object.
   - The example use a JDBC API approach (not SQL specification) and has some drawbacks (Next example will illustrate a better solution based on SQL only).
   - <strong>Drawback 1</strong>: need to move ResultSet instantiation from try with resources to the try body
   - <strong>Drawback 2</strong>: need to include a finally block to close the ResultSet, without benefits provided by auto closing of the resource introduced in Java 7
   - <strong>Drawback 3</strong>: hhis solution has a poor performance, since the query returns all rows that are then filter it, discading additional rows.

11 - LimitedRowsResultSetBetterSolution
   - This example project illustrates one way to limit the number or results (rows) in a resultset using the LIMIT clause in SQL.  
   
   <p align="center"><code>ResultSet rs = stmt.executeQuery("SELECT * FROM GUEST <strong>LIMIT 5, 3</strong>"); // 3 results, starting at 6 </code></p>
   
   - This solution is better than the one provided in the LimitedRowsResultSetBadSolution, since it has better performance.
   - This solution also does not has problems with try with resources feature of Java SE.

12 - PreparedStatement
   - This example project demonstrates how we can use SQL queries with parameters, filtering the results returned by the database engine.
   
      <p align="center"><code>private static final String SQL = "SELECT * FROM GUEST WHERE <strong>STATE = ?</strong>";</code></p>

   - The example uses the class PreparedStatement presented in JDBC API.
   - It demonstrates, for instance, how to retriveve the guests who lives in the California state - CA.
   - The example also introduces a new class (KeyboardInput) that allows reading the state from the keyboard.
   
   <p align="center">
    <img width="746" height="374" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_PreparedStatement.png" alt="UML class diagram">
</p>
   
13 - ResultSetGetObjectWithGenerics
   - This example project demonstrates an alternative way to retrieve values for a specifified column from a row within a result set by using the method getObject(String column name, <E>). For example, calling rs.getObject("GUEST_ID", Integer.class) instead of rs.getInt("GUEST_ID");
   
   - <strong>Note</strong>: The example shown does not deal yet with decimal numbers (float and double for instance in Java). If you, for instance, try to use:
   
     <p align="center"><code>double price =  rs.getObject("price", Double.class);</code></p>
   
   and are getting the Exception java.math.BigDecimal cannot be cast to java.lang.Double, try changing to BigDecimal:
   
   <p align="center"><code>BigDecimal price = rs.getObject("price", BigDecimal.class);</code></p>
    
   - For RDBMS portability reasons, I suggest using BigDecimal instead of Double or Float as the second parameter of the getObject method.

14 - JavaBeans
   - This example project demonstrates the good practice of creating a JavaBean classes for database tables.
   - In this example, a JavaBean named Admin is created with instance variables reflecting the column names in the ADMIN table.
   - A class named AdminController is used to show the detais of all admins stored in the ADMIN table as well as to allow retrieving only one single Admin by its ADMIN_ID.
   - The example includes some improvements in the KeyboardInput utility class to ease the task of reading integer and float pointing input from the command prompt. 
   
   <p align="center">
    <img width="684" height="379" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_JavaBeans.png" alt="UML class diagram">

15 - JavaBeanCreationSQLInsertPreparedStatement
   - This example project starts with a new method, insert(Admin admin),on the AdminControler class. 
   - The insert method uses Statement.RETURN_GENERATED_KEYS when creating the prepared statement. For some RDBMSs this is automatic. For others, it is not.
   
<p align="center"><code>PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);</code></p>
               
   - The example also demonstrates how to grab the primary key generated just after executing the method stmt.executeUpdate().
   - The example demonstrates how to create an Admin bean and persisting it to the database.
   
<p align="center">
    <img width="684" height="379" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_JavaBeanCreationSQLInsertPreparedStatement.png" alt="UML class diagram">

16 -  JavaBeanUpdateSQLUpdatePreparedStatement
   - This example project demonstrates how to update data of an existing tuple in a table from data of a bean passed as argument to the method update(Admin bean) in the class AdminController.
   - The example uses a PreparedStatement:
   
<p align="center"><code>String sql = "UPDATE ADMIN SET USERNAME = ?, PASSWORD = ? WHERE ADMIN_ID = ?";</code></p>

<p align="center">
    <img width="684" height="379" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_JavaBeanUpdateSQLUpdatePreparedStatement.png" alt="UML class diagram">
    
 17 - JavaBeanDeleteSQLDeletePreparedStatement
   - This example project demonstrates how to delete an existing tuple in a table based on the ADMIN_ID passed as argument to the method delete(int adminId)in the class AdminController
   - The example uses a PreparedStatement:
   

<p align="center"><code>String sql = "DELETE FROM ADMIN WHERE ADMIN_ID = ?";</code></p>
	       
   - The prepared statement is filled with arguments:
   
               stmt.setInt(1, adminId);
               int affected = stmt.executeUpdate();

               if (affected == 1) {
	               return true;
               } else {
	               return false;
               }	       
	       
<p align="center">
    <img width="927" height="404" src="https://github.com/pagliares/jdbc-hands-on/blob/main/UML_Diagrams/Class_Diagram_JavaBeanDeleteSQLDeletePreparedStatement.png" alt="UML class diagram">
	      
 18 - UpdatableResultSet
   - This examples demonstrates an alternative way to update data in a database by the use of UpdatableResultSet.
   - In this example we need to pass the ResultSet.CONCUR_UPDATABLE constant argument when creating a Prepared Statement
   
   			PreparedStatement stmt = conn.prepareStatement(
							sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

   - The snippet of code needed to use an UpdatableResultSet:
   
   			rs = stmt.executeQuery();

			if (rs.next()) {
				rs.updateString("userName", bean.getUserName());
				rs.updateString("password", bean.getPassword());
				rs.updateRow();
				return true;
			} else {
				return false;
			}

19 - PersistentDatabaseConnection
   - This example project explains that the task of opening/closing database connections demands much time, memory and resources.
   - A good practice is to reuse opened connections
   - In Java SE single user enviromente, it is task of the developer to manges the database connections. In Jakarta EE, the app servers manage the connection by the use of Connection Pooling
   - This example project creates a ConnectionManager class as a Singleton design pattern to better manage database connections and refactor previous code to use this new ConnectionManager class.
   
20 - TransactionManagement
   - This example project builds on a previous example to demonstrate how to use transactions with JDBC.
   - A database transaction is one or more actions that make change do data in a RDBMS server or file.
   - Insert, update and delete are examples of transactions.
   - In JDBC transactions are auto-commited. The changes in your queries are committed immediately. 
   - Most RDBMSs give you the ability to explicitly commit and rollback transactions
        - In MySQL this depends on the engine being used.
   - Open PHPMyadmin, and click on a table of the hostelapp_jdbc database and select Operations | Storage Engine |
      - A list of engines is presented, included InnoDB
      - InnoDB support transactions, foreign keys, etc.
      - MyISAM is the default engine, but does not support transactions, for instance.
   - To turn off auto commit of transactions in JDBC:

			Connection connection = ConnectionManager.getInstance().getConnection();
 			connection.setAutoCommit(false);

     - To commit the transaction (in case your have turned off auto-commit features:

			connection.commit();

     - If auto-commit is turned off and you have not explicitly called connection.commit(), you can roll back the transaction:

			connection.rollback();  

21 - TablesListDatabaseMetadata
   - This example project shows how we can obtain metadata about the database
   - In particular, we demonstrate how to get the name of the tables in the database using the following snippet of code:
   
   			DatabaseMetaData metadata = conn.getMetaData();
			String[] tableTypes = {"TABLE"};
			rsTables = metadata.getTables("hostelapp_jdbc", "%", "%", tableTypes);
			while (rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_NAME"));
			}
