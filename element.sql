/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - element
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`element` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `element`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menu_id` bigint(14) NOT NULL AUTO_INCREMENT COMMENT 'menu_id',
  `menu_code` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单编号',
  `menu_name` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `func_url` varchar(120) NOT NULL DEFAULT '' COMMENT 'url',
  `orderno` bigint(14) unsigned NOT NULL DEFAULT '0' COMMENT '时间戳',
  `group_id` bigint(14) unsigned NOT NULL DEFAULT '0' COMMENT '引用于menu_id',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Data for the table `menu` */

insert  into `menu`(`menu_id`,`menu_code`,`menu_name`,`func_url`,`orderno`,`group_id`) values (1000,'basic','组件','basic',0,1),(1001,'form','表单','form',0,2),(1002,'data','数据','data',0,3),(1003,'notice','通知','notice',0,4),(1004,'navigation','导航','navigation',0,5),(1005,'others','其它','others',0,6),(1006,'basic','布局','basic_layout',0,1000),(1007,'basic','布局容器','basic_container',0,1000),(1008,'basic','色彩','basic_color',0,1000),(1009,'basic','字体','basic_typography',0,1000),(1010,'basic','边框','basic_border',0,1000),(1011,'basic','图标','basic_lcon',0,1000),(1012,'basic','按钮','basic_button',0,1000),(1013,'form','单选框','form_radio',0,1000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
