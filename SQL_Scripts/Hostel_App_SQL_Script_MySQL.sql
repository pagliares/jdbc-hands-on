 


USE `hostelapp_jdbc`;

--
-- Drop tables if they already exist
--

DROP TABLE IF EXISTS `admin`;
DROP TABLE IF EXISTS `guest`; 

-- --------------------------------------------------------

--
-- Table DDL structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `ADMIN` (
  `ADMIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Populate initial data for table `admin`
--

INSERT INTO `ADMIN` (`ADMIN_ID`, `USERNAME`, `PASSWORD`) VALUES
(1, 'atticus', 'finch');

-- --------------------------------------------------------

CREATE TABLE `GUEST`(
  GUEST_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Gatsby', 'Jay', 'jay@gmail.com', 'United States', '1187  Fleming 
Street', 'AL', '+1-205-555-0178');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Caulfield', 'Holden', 'holden@mit.edu', 'United States', '3998  
Davis Lane', 'CO', '+1-303-555-0137');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Humbert', 'Humbert', 'humbert@gmail.com', 'United States', '499  
McKinley Avenue', 'CO', '+1-303-555-0156');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Bloom', 'Leopold', 'bloom@blogs.com', 'United States', '4239  
Marigold Lane', 'FL', '+1-561-555-0145');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Angstrom', 'Rabbit', 'angstrom@hotmail.com', 'United States', 
'4306  Jacobs Street', 'FL', '+1-561-555-0135');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Holmes', 'Sherlock', 'holmes@aol.com', 'United States', '1395  
Dola Mine Road', 'AK', '+1-907-555-0187');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Finch', 'Atticus', 'finch@hotmail.com', 'United States', '3566  
Parkway Drive', 'AZ', '+1-480-555-0198');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Bloom', 'Molly', 'molly@microsoft.com', 'United States', '4206  
Mulberry Avenue', 'AR', '+1-501-555-0120');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Dedalus', 'Stephen', 'dedalus@apple.com', 'United States', '359  
Hide A Way Road', 'CA', '+1-510-555-0183');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Bart', 'Lily', 'bart@gmail.com', 'United States', '639  Airplane 
Avenue', 'CT', '+1-860-555-0154');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Golightly', 'Holly', 'golightly@gmail.com', 'United States', '3786  
Scenic Way', 'IL', '+1-847-555-0127');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Samsa', 'Gregor', 'samsa@yahoo.com', 'United States', '1833  Don 
Jackson Lane', 'HI', '+1-808-555-0162');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Buendia', 'Aureliano', 'buendia@yahoo.com', 'United States', '2195  
Eagle Street', 'IL', '+1-847-555-0151');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Dalloway', 'Clarissa', 'dalloway@gmail.com', 'United States', 
'1632  Pearlman Avenue', 'KS', '+1-785-555-0189');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Reilly', 'Ignatius', 'reilly@gmail.com', 'United States', '1632  
Pearlman Avenue', 'WI', '+1-920-555-0109');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Smiley', 'George', 'smiley@gmail.com', 'United States', '2436  
Williams Lane', 'KS', '+1-785-555-0132');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Pooh', 'Winnie', 'pooh@yahoo.com', 'United States', '3529  
Cheshire Road', 'CT', '+1-860-555-0146');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Thomas', 'Bigger', 'thomas@hotmail.com', 'United States', '3091  
Doctors Drive', 'CA', '+1-510-555-0112');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Adams', 'Nick', 'adams@gmail.com', 'United States', '3199  Ryan 
Road', 'SD', '+1-605-555-0121');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('OHara', 'Scarlett', 'ohara@gmail.com', 'United States', '3502  
Station Street', 'CA', '+1-510-555-0187');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Finch', 'Scout', 'finch@gmail.com', 'United States', '2552  Cedar 
Street', 'AR', '+1-501-555-0132');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('Marlowe', 'Philip', 'marlowe@hotmail.com', 'United States', '2810  
Polk Street', 'AZ', '+1-480-555-0147');

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, 
STATE, PHONE_NUMBER)
VALUES('di Rondo', 'Cosimo', 'dirondo@gmail.com', 'United States', '4772  
Pinewood Drive', 'AK', '+1-907-555-0178');
