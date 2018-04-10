/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.39-log : Database - hq_account
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hq_account` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hq_account`;

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` char(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createUser` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表';

/*Data for the table `t_account` */

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` char(32) NOT NULL,
  `perCode` varchar(50) DEFAULT NULL,
  `perPath` varchar(100) DEFAULT NULL,
  `preDesc` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `t_permission` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` char(32) NOT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  `roleCode` varchar(20) DEFAULT NULL,
  `useFlag` int(1) DEFAULT '1',
  `delFlag` int(1) DEFAULT '0',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createUser` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `t_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
