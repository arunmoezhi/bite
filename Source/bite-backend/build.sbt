name := """bite-backend"""

//organization := "com.bite.backend"
description := "Bite backend API Project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

autoScalaLibrary := false

libraryDependencies ++= Seq(
  javaCore,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  javaJdbc,
  cache,
  javaWs,
  filters,
  "org.springframework" % "spring-core" % "4.1.6.RELEASE",
  "org.springframework" % "spring-context" % "4.1.6.RELEASE",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework" % "spring-web" % "4.1.6.RELEASE",
  "javax.servlet" % "servlet-api" % "2.5",
  "javax.servlet.jsp" % "jsp-api" % "2.1" % "provided",
  "org.springframework" % "spring-webmvc" % "4.1.6.RELEASE",
  "org.springframework" % "spring-test" % "4.1.6.RELEASE" % "test",
  "junit" % "junit" % "4.11" % "test",
  "jstl" % "jstl" % "1.2",
  "org.springframework.data" % "spring-data-jpa" % "1.2.0.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.6.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.json" % "json" % "20080701"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
// routesGenerator := InjectedRoutesGenerator
