/*
SQLyog Ultimate v8.55 
MySQL - 5.1.36-community : Database - smart_book_borrow
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smart_book_borrow` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `smart_book_borrow`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_email` varchar(20) DEFAULT NULL,
  `admin_password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`admin_email`,`admin_password`) values ('admin@gmail.com','admin');

/*Table structure for table `book_details` */

DROP TABLE IF EXISTS `book_details`;

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(200) DEFAULT NULL,
  `book_author` varchar(200) DEFAULT NULL,
  `book_desc` varchar(200) DEFAULT NULL,
  `book_created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `book_image_path` varchar(200) DEFAULT NULL,
  `can_buy` int(11) DEFAULT '1',
  `can_borrow` int(11) DEFAULT '0',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `book_details` */

insert  into `book_details`(`book_id`,`book_name`,`book_author`,`book_desc`,`book_created_date`,`book_image_path`,`can_buy`,`can_borrow`) values (5,'Testing Book ','daasdsadsdasdasdsa','Tested Successfully','2018-02-08 19:37:06','C:/ImageData/g4.jpg',1,0),(9,'Testing Book 2da','Gowda','Tested Successfully24das','2018-02-09 18:43:08','C:/ImageData/1book3-med.jpg',1,1),(10,'Testing Book ','Gowda','Tested Successfully','2018-02-09 19:19:04','C:/ImageData/h.png',0,1);

/*Table structure for table `borrow_book_list` */

DROP TABLE IF EXISTS `borrow_book_list`;

CREATE TABLE `borrow_book_list` (
  `borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_book_id` int(11) DEFAULT NULL,
  `borrow_user_id` int(11) DEFAULT NULL,
  `borrow_status` int(11) DEFAULT '0',
  PRIMARY KEY (`borrow_id`),
  KEY `FK_borrow_book_id` (`borrow_book_id`),
  CONSTRAINT `FK_borrow_book_id` FOREIGN KEY (`borrow_book_id`) REFERENCES `book_details` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `borrow_book_list` */

/*Table structure for table `buying_book_list` */

DROP TABLE IF EXISTS `buying_book_list`;

CREATE TABLE `buying_book_list` (
  `buying_id` int(11) NOT NULL AUTO_INCREMENT,
  `buying_book_id` int(11) DEFAULT NULL,
  `buying_user_id` int(11) DEFAULT NULL,
  `buying_status` int(11) DEFAULT '0',
  PRIMARY KEY (`buying_id`),
  KEY `FK_buying_book_id` (`buying_book_id`),
  CONSTRAINT `FK_buying_book_id` FOREIGN KEY (`buying_book_id`) REFERENCES `book_details` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `buying_book_list` */

/*Table structure for table `reviews` */

DROP TABLE IF EXISTS `reviews`;

CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_rating` double DEFAULT '0',
  PRIMARY KEY (`review_id`),
  KEY `FK_review_user_id` (`user_id`),
  KEY `FK_review_book_id` (`book_id`),
  CONSTRAINT `FK_review_book_id` FOREIGN KEY (`book_id`) REFERENCES `book_details` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_review_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `reviews` */

insert  into `reviews`(`review_id`,`user_id`,`book_id`,`user_rating`) values (1,1,5,4.6),(2,2,5,3.6),(3,3,5,3.9),(4,1,9,4.7),(5,2,9,4.3);

/*Table structure for table `selling_book_list` */

DROP TABLE IF EXISTS `selling_book_list`;

CREATE TABLE `selling_book_list` (
  `selling_id` int(11) NOT NULL AUTO_INCREMENT,
  `selling_book_id` int(11) DEFAULT NULL,
  `selling_user_id` int(11) DEFAULT NULL,
  `selling_status` int(11) DEFAULT '0',
  PRIMARY KEY (`selling_id`),
  KEY `FK_selling_book_` (`selling_book_id`),
  CONSTRAINT `FK_selling_book_` FOREIGN KEY (`selling_book_id`) REFERENCES `book_details` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `selling_book_list` */

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) DEFAULT NULL,
  `user_gender` varchar(200) DEFAULT NULL,
  `user_dob` varbinary(200) DEFAULT NULL,
  `user_address` varchar(200) DEFAULT NULL,
  `user_email` varchar(200) DEFAULT NULL,
  `user_password` varchar(200) DEFAULT NULL,
  `user_mobile_number` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_details` */

insert  into `user_details`(`user_id`,`user_name`,`user_gender`,`user_dob`,`user_address`,`user_email`,`user_password`,`user_mobile_number`) values (1,'a','m','45412','asfsdafasfsaf','a@gmail.com','a123',789796456),(2,'MAG','m','45412','asfsdf','a@gmail.com','mag123',789796456),(3,'MAGsdad','m','45sdas412','asfsasdsaddf','a@gmail.com','magasds123',789796456);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
