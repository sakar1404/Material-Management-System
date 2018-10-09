-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.33-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mm
--

CREATE DATABASE IF NOT EXISTS mm;
USE mm;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`adminid`,`name`,`password`) VALUES 
 (1,'Rohit Sharma','123'),
 (2,'Kunal Kapoor','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryid` int(10) unsigned NOT NULL auto_increment,
  `categoryname` varchar(45) NOT NULL,
  `categoryicon` varchar(45) NOT NULL,
  PRIMARY KEY  (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryid`,`categoryname`,`categoryicon`) VALUES 
 (1,'Tyres','road_less_travelled_by_wilddoug-d4lcp7w.jpg'),
 (2,'Bolt','images (3).jpg'),
 (3,'Nuts','download.jpg'),
 (4,'Wheel','spardha.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `cities`
--

DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `stateid` int(10) unsigned NOT NULL,
  `cityid` int(10) unsigned NOT NULL auto_increment,
  `cityname` varchar(45) NOT NULL,
  PRIMARY KEY  (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cities`
--

/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` (`stateid`,`cityid`,`cityname`) VALUES 
 (100,1,'Gwalior'),
 (100,2,'Indore'),
 (100,3,'Bhopal'),
 (200,4,'Karnal'),
 (200,5,'Guru Gram'),
 (200,6,'Sonipat'),
 (300,7,'Kanpur'),
 (300,8,'Lucknow'),
 (300,9,'Allahabad');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `employeeid` int(10) unsigned NOT NULL auto_increment,
  `employeename` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `permanentaddress` varchar(100) NOT NULL,
  `pstate` varchar(45) NOT NULL,
  `pcity` varchar(45) NOT NULL,
  `currentaddress` varchar(100) NOT NULL,
  `cstate` varchar(45) NOT NULL,
  `ccity` varchar(45) NOT NULL,
  `contactno` varchar(45) NOT NULL,
  `mobileno` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `qualification` varchar(45) NOT NULL,
  `designation` varchar(45) NOT NULL,
  `basicsalary` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `photograph` varchar(45) NOT NULL,
  PRIMARY KEY  (`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`employeeid`,`employeename`,`fname`,`dob`,`gender`,`permanentaddress`,`pstate`,`pcity`,`currentaddress`,`cstate`,`ccity`,`contactno`,`mobileno`,`emailid`,`qualification`,`designation`,`basicsalary`,`password`,`photograph`) VALUES 
 (2,'James Gosling','Xyz','1990-03-03','Male','Govindpuri','100','1','Cannaught Place','300','9','9876543210','9875821364','aa@gmail.com','eee','clerk','12000','123','coffee.png'),
 (3,'Khushi Singh','abc','1998-11-11','Female','City centre','200','5','Govindpuri','100','1','875421','254895','ss@gg.com','ece','aso','12500','123','model.jpg'),
 (4,'Kunal Sharma','Karan Sharma','1995-11-12','Male','Atal Marg','300','8','Palasia Road','100','2','9569881500','9569881578','abc@gmail.com','Graduate','clerk','125000','123','address.png'),
 (5,'Krishna  Sharma','Kishan Raj','1995-07-09','Male','Atal Marg','300','8','Govindpuri','100','1','9875411230','9875591364','abc@gg.com','graduate','clerk','120000','123','download.jpg');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `employeeid` int(10) unsigned NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `subcategoryid` int(10) unsigned NOT NULL,
  `productid` int(10) unsigned NOT NULL,
  `transactionid` int(10) unsigned NOT NULL auto_increment,
  `issuedate` date NOT NULL,
  `issueto` varchar(45) NOT NULL,
  `purpose` varchar(100) NOT NULL,
  `quantity` int(10) unsigned default NULL,
  PRIMARY KEY  (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`employeeid`,`categoryid`,`subcategoryid`,`productid`,`transactionid`,`issuedate`,`issueto`,`purpose`,`quantity`) VALUES 
 (2,1,1,1,2,'2018-06-29','3','xyz',15),
 (1,1,1,1,3,'2018-06-29','2','ABC',30),
 (3,4,6,3,4,'2018-07-03','3','abc',10),
 (4,3,5,4,5,'2018-07-03','4','abc',150),
 (2,4,6,3,6,'2018-07-03','5','abc',123),
 (3,2,4,7,7,'2018-07-04','4','xxx',120),
 (2,2,4,11,8,'2018-07-04','4','ghsadh',32),
 (2,3,2,12,9,'2018-07-04','5','jhfd',106),
 (2,1,7,5,10,'2018-07-05','4','as',156);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;


--
-- Definition of table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `employeeid` int(10) unsigned NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `subcategoryid` int(10) unsigned NOT NULL,
  `productid` int(10) unsigned NOT NULL auto_increment,
  `productname` varchar(45) NOT NULL,
  `modelno` varchar(45) NOT NULL,
  `modelname` varchar(45) NOT NULL,
  `rate` int(10) unsigned NOT NULL,
  `stock` int(10) unsigned default NULL,
  `inventorylevel` int(10) unsigned default NULL,
  `photograph` varchar(45) NOT NULL,
  PRIMARY KEY  (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`employeeid`,`categoryid`,`subcategoryid`,`productid`,`productname`,`modelno`,`modelname`,`rate`,`stock`,`inventorylevel`,`photograph`) VALUES 
 (1,1,1,1,'Aba','msh/2018','msg',1500,392,100,'bulb.jpg'),
 (2,4,3,2,'Xyz','XASA@','ssas',1200,120,100,'images.jpg'),
 (5,4,6,3,'Maruti','abx20','abx/bn',16500,307,10,'fish.png'),
 (4,3,5,4,'Godrej','ab21','ab/cd',100,1850,100,'brick.jpg'),
 (2,1,7,5,'Aba','msh/2018','msg',1500,94,10,'splash.png'),
 (2,2,8,6,'Aba','msh/2018','ssas',1500,220,100,'coffee.png'),
 (3,2,4,7,'Xyz','abx20','ab/cd',858,100,100,'plate.png'),
 (3,1,7,8,'aaa','xxx','xxxx',120,306,50,'website.png'),
 (2,1,7,9,'ss','eerr','erwfrf',2000,500,100,'address.png'),
 (2,2,8,10,'huhh','jkhug','hgyug',789,156,105,'plate.png'),
 (2,2,4,11,'khku','uhgug','jgyh',654,420,123,'featured.png'),
 (2,3,2,12,'kjdd','iuhfrg','buewd',963,1043,156,'coffee.png'),
 (2,4,6,13,'hftyf','kjhu','hjvy',965,156,19,'apple.png');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `employeeid` int(10) unsigned NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `subcategoryid` int(10) unsigned NOT NULL,
  `productid` int(10) unsigned NOT NULL,
  `transactionid` int(10) unsigned NOT NULL auto_increment,
  `invoiceno` varchar(45) NOT NULL,
  `dateofinvoice` date NOT NULL,
  `firmname` varchar(45) NOT NULL,
  `quantity` int(10) unsigned default NULL,
  `batchno` varchar(45) NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `totalamount` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`employeeid`,`categoryid`,`subcategoryid`,`productid`,`transactionid`,`invoiceno`,`dateofinvoice`,`firmname`,`quantity`,`batchno`,`price`,`totalamount`) VALUES 
 (4,3,5,4,7,'ac/20','2018-07-03','GODREJ',1000,'1',1000,1000000),
 (5,4,6,3,8,'AB/12/bb','2018-07-03','MARUTI',150,'1',10000,1500000),
 (2,1,7,5,9,'10258','2018-07-03','GODREJ',150,'7',1500,225000),
 (3,2,8,6,10,'AB/12/GG','2018-07-03','785',120,'11',1590,190800),
 (2,2,4,11,12,'jbdu','2018-07-04','kuhfs',156,'48',1560,243360),
 (2,3,2,12,13,'kjsc','2018-07-04','hbhdcd',186,'46',1560,290160),
 (2,2,4,11,14,'jdcfsjh','2018-07-04','djbd',140,'33',10560,1478400),
 (2,1,7,8,15,'ac/20','2018-07-05','GODREJ',156,'12',156,24336);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `states`
--

DROP TABLE IF EXISTS `states`;
CREATE TABLE `states` (
  `stateid` int(10) unsigned NOT NULL auto_increment,
  `statename` varchar(45) NOT NULL,
  PRIMARY KEY  (`stateid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `states`
--

/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` (`stateid`,`statename`) VALUES 
 (100,'Madhya Pradesh'),
 (200,'Haryana'),
 (300,'Uttar Pradesh');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;


--
-- Definition of table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE `subcategory` (
  `categoryid` int(10) unsigned NOT NULL,
  `subcategoryid` int(10) unsigned NOT NULL auto_increment,
  `subcategoryname` varchar(45) NOT NULL,
  `subcategoryicon` varchar(45) NOT NULL,
  PRIMARY KEY  (`subcategoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcategory`
--

/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` (`categoryid`,`subcategoryid`,`subcategoryname`,`subcategoryicon`) VALUES 
 (3,2,'Iron','underwater.jpg'),
 (2,4,'Iron','images (4).jpg'),
 (3,5,'Cap','clouds_.jpg'),
 (4,6,'European','splash.png'),
 (1,7,'MRF','underwater.jpg'),
 (2,8,'Six threaded','brick.jpg');
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
