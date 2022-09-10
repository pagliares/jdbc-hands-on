 


USE `hostelapp_jdbc`;

--
-- Drop tables if they already exist
--

DROP TABLE IF EXISTS `admin`;
 

-- --------------------------------------------------------

--
-- Table DDL structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Populate initial data for table `admin`
--

INSERT INTO `admin` (`adminId`, `userName`, `password`) VALUES
(1, 'atticus', 'finch');

-- --------------------------------------------------------


