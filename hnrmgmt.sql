/*
SQLyog Job Agent Version 10.0 Beta1 Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.7.17-log : Database - hnrmgmt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hnrmgmt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hnrmgmt`;

/*Table structure for table `award` */

DROP TABLE IF EXISTS `award`;

CREATE TABLE `award` (
  `AWD_ID` varchar(255) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `GRADE_NAME` varchar(255) DEFAULT NULL,
  `GRADE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AWD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `award` */

insert  into `award` values ('1','计算机设计大赛','1',NULL),('2','互联网+创新创业大赛','1',NULL),('8a0eb5665f3a6644015f3a666c6c0000','修改后的\"互联网+\"创新创业大赛','2','2'),('8a0eb5665f3a8395015f3a8456ba0000','挑战杯','1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
