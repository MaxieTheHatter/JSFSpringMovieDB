# JSF Spring Movie Database

Simple web project that allows the user to create an account and login to the page to view a database of movies.

User can add their own movies and admins can manage and delete users and/or movies.

## Technologies used

JSF (JavaServerFaces 2.2)

Spring 3.2

Spring Security 3.2

Hibernate 4.1

MySQL 5.1.3

Maven 3.0

Java 1.8

Tomcat 8.5

## Getting started

Getting started is simple, all your need is a basic understanding of Java and the Hibernate API.

### Prerequisites
Here's what you neeed to get started.
#### Software/APIs

Maven [Setup Guide for eclipse](http://www.vogella.com/tutorials/EclipseMaven/article.html)

JSF 2.2 - Included with Eclipse Oxygen EE

Eclipse Oxygen EE (or IDE of your choice) [Download Link](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R/eclipse-inst-win64.exe)

Hibernate [Download Link](http://tools.jboss.org/downloads/jbosstools/oxygen/4.5.1.Final.html) - Can be installed through eclipse marketplace using jbosstools

Spring [Online tutorial](https://www.tutorialspoint.com/spring/index.htm)

XAMPP (or similiar server tool) [Download Link](https://www.apachefriends.org/index.html)

Tomcat [Setup Guide](https://www.eclipse.org/webtools/jst/components/ws/M5/tutorials/InstallTomcat.html) - Server used for running the project

#### Setting up SQL server

Create database
```sql
CREATE DATABASE IF NOT EXISTS `jsfmoviedb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jsfmoviedb`;
```

Create tables
```sql
CREATE TABLE `genre` (
  `GENRE_ID` int(255) NOT NULL,
  `GENRE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `movie` (
  `MOVIE_ID` int(255) NOT NULL AUTO_INCREMENT,
  `GENRE_ID` int(11) NOT NULL,
  `TITLE` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `RATING` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `ROLE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(60) NOT NULL,
  `LABEL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `USER_ID` int(255) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(255) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```
Create user roles and insert admin account (I recommend a stronger password)
```sql
INSERT INTO `role` (`ROLE_ID`, `CODE`, `LABEL`) VALUES
(1, 'ROLE_ADMIN', 'ADMIN'),
(2, 'ROLE_USER', 'user');

INSERT INTO `user` (`USER_ID`, `ROLE_ID`, `USERNAME`, `PASSWORD`, `ENABLED`) VALUES
(1, 1, 'ADMIN', 'abc123', 1);
```

Add primary and foreign keys
```sql
ALTER TABLE `genre`
  ADD PRIMARY KEY (`GENRE_ID`);
ALTER TABLE `movie`
  ADD PRIMARY KEY (`MOVIE_ID`),
  ADD KEY `movie_ibfk_3` (`GENRE_ID`);
ALTER TABLE `role`
  ADD PRIMARY KEY (`ROLE_ID`);
ALTER TABLE `user`
  ADD PRIMARY KEY (`USER_ID`),
  ADD KEY `ROLE_ID` (`ROLE_ID`);
```
Add constraints
```sql
ALTER TABLE `movie`
  ADD CONSTRAINT `movie_ibfk_3` FOREIGN KEY (`GENRE_ID`) REFERENCES `genre` (`genre_id`);
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`);
```
Or simply import the included SQL file using phpmyadmin or SQL workbench (found in the documentation folder)

## General info

Please check the javadocs if any of the methods are unclear, if it's still confusing post an issue to this page.
[Link to javadocs](https://maxiethehatter.github.io/DnDCharacterDB/)

## Authors

MaxieTheHatter - yours truly

## Resources Used

[Keylessons](http://keylesson.com/index.php/2015/03/05/jsf-2-spring-hibernate-example-1717/) - Guide that allowed me to get started, if only a little flawed
