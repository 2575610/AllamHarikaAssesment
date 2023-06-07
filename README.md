About the Project: This project contains the  scala code solution for Refinitiv Matching Engine Exercise.New matching engine for FX orders. The engine will take a CSV file of orders for a given currency pair and match orders together
JarName : sbt:org.scala-lang:scala-library:2.13.10:jar
Ide : intelliJ IDEA
To execute the Scala code in IntelliJ IDEA, follow these steps:
1. Open IntelliJ IDEA and create a new Scala project.
2. Create a new Scala file and copy the matching engine code into it.
3. Make sure you have the Scala and Spark dependencies configured in your project. You can add them to your `build.sbt` file.
4. Place the `Book1.csv` file in the project directory or provide the complete path to the file in the "C:\Users\pulic\Downloads\Book1.txt" variable.
5. Run the Scala code by right-clicking on the file.

Make sure you have the necessary Scala and Spark dependencies added to your project. You can add the following dependencies to your `build.sbt` file:
Build Tool: Maven Dependencies Used :

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "FIRSTSCALAPROJECT"
  )
// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.3"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3" % "provided"

After executing the code, the matching engine will read the CSV file, perform order matching, and print the details of the matched orders.
