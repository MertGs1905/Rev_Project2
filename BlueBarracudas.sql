/*******************************************************************************
   BlueBarracudas Database - Version 1.4
   Script: BlueBarracudas.sql
   Description: Creates and initializes the Blue Barracudas database.
   DB Server: Oracle
   Author: Michael Perkins
   ********************************************************************************/
/*******************************************************************************
   Drop database if it exists
********************************************************************************
DROP USER mgperkins1 CASCADE;
********************************************************************************
   Create database
********************************************************************************/
CREATE USER blueBarracuda
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to blueBarracuda;
GRANT resource to blueBarracuda;
GRANT create session TO blueBarracuda;
GRANT create table TO blueBarracuda;
GRANT create view TO blueBarracuda;

CREATE USER blueBarracuda IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO blueBarracuda;
GRANT DBA TO blueBarracuda WITH ADMIN OPTION;


DROP USER blueBarracuda CASCADE;

