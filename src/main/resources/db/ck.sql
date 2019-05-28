/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22 : Database - ck
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ck` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ck`;

/*Table structure for table `ck_t_login_log` */

DROP TABLE IF EXISTS `ck_t_login_log`;

CREATE TABLE `ck_t_login_log` (
  `id` char(36) NOT NULL,
  `user_id` char(36) DEFAULT NULL COMMENT '登录用户ID',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `ip_address` varchar(50) DEFAULT NULL COMMENT '登录IP地址',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志表';

/*Data for the table `ck_t_login_log` */

insert  into `ck_t_login_log`(`id`,`user_id`,`record_status`,`ip_address`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('06eac5c7-8fb2-465e-8231-53c6c85c40b5','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:29:32','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:29:32',0,NULL),('0d111387-db5b-485e-a638-6f02279ea27f','1','0','169.254.21.218','1','2019-05-28 15:54:07','1','2019-05-28 15:54:07',0,NULL),('16fa9241-9c61-4110-9b2a-332835dfc704','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:39:49','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:39:49',0,NULL),('1fce1238-cdb1-4339-aa75-f577fda5c46b','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:05:47','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:05:47',0,NULL),('2340f93b-4d34-4e66-84c3-309f626f0d04','1','0','169.254.21.218','1','2019-05-28 12:14:03','1','2019-05-28 12:14:03',0,NULL),('2d5b554c-44bb-42c8-b2c7-1ea24f9e4181','1','0','169.254.21.218','1','2019-05-28 16:03:29','1','2019-05-28 16:03:29',0,NULL),('2f3b0768-1959-4f91-b514-8cc252aa3924','1','0',NULL,'1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('4edf472d-8d63-41a8-8088-791ac9db3b91','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:06:05','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:06:05',0,NULL),('50e4f397-1565-41ae-b0ac-85a9abb4c7cb','1','0','169.254.21.218','1','2019-05-28 17:07:32','1','2019-05-28 17:07:32',0,NULL),('56062ec8-b137-4f36-9e74-05babb528158','1','0','169.254.21.218','1','2019-05-28 16:54:12','1','2019-05-28 16:54:12',0,NULL),('583277f7-2097-4547-b0f9-93c785c6ba76','1','0','169.254.21.218','1','2019-05-28 13:47:17','1','2019-05-28 13:47:17',0,NULL),('6475f882-abe5-4294-9af9-9c6aa9910e55','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:04:16','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:04:16',0,NULL),('780f5706-5c80-4ad1-a7a8-c77c9b742a02','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:36:24','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:36:24',0,NULL),('7d308290-5b28-4e11-a5c2-ef510fe170ee','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:36:10','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:36:10',0,NULL),('7f8a5e14-a97f-449c-82d4-f5c3179fe863','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:39:08','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:39:08',0,NULL),('91483632-3b10-424d-b75f-6c68a3a94f1f','1','0',NULL,'1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('945d92ea-5159-4fd0-ba2a-7cfe764115c6','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:03:21','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:03:21',0,NULL),('96f574a7-d487-46f5-afc4-6291b824050f','1','0',NULL,'1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('97dc48b8-0e20-40c3-b6e4-636f0bf76138','1','0','169.254.21.218','1','2019-05-28 12:12:06','1','2019-05-28 12:12:06',0,NULL),('a4f5d082-b163-4ac5-97bb-f7e2167c3fe2','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:22:44','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:22:44',0,NULL),('a5328368-9e7a-43f2-b746-bad328defd30','1','0','169.254.21.218','1','2019-05-28 16:04:40','1','2019-05-28 16:04:40',0,NULL),('b414ebca-fcb6-4066-9289-e5c738a6c3f9','1','0',NULL,'1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('c0a16a6a-00dd-4423-a0d7-1fb7bb2ddfeb','1','0',NULL,'1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('d6306f83-9288-40fc-86d6-ee178f6800c2','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:54:26','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 15:54:26',0,NULL),('dff40190-f021-4623-bfb8-9d5530cc8bce','1','0','169.254.21.218','1','2019-05-28 12:01:47','1','2019-05-28 12:01:47',0,NULL),('e53c788f-3d7f-4526-9a68-fbc5d9af28a0','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 13:52:54','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 13:52:54',0,NULL),('ea0ba3c2-77b7-4f46-9453-45a916760a0d','1','0','169.254.21.218','1','2019-05-28 17:03:32','1','2019-05-28 17:03:32',0,NULL),('fe5c2d9f-7b7e-4fcc-879a-5fe6d997340a','65985213-53f2-4ed7-8853-50d35e685927','0','169.254.21.218','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:48:09','65985213-53f2-4ed7-8853-50d35e685927','2019-05-28 16:48:09',0,NULL);

/*Table structure for table `ck_t_menu` */

DROP TABLE IF EXISTS `ck_t_menu`;

CREATE TABLE `ck_t_menu` (
  `id` char(36) NOT NULL,
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  `menu_level` int(4) NOT NULL COMMENT '菜单级别',
  `menu_flag` varchar(50) DEFAULT NULL COMMENT '菜单标识',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `parent_id` varchar(50) NOT NULL COMMENT '父级菜单',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `menu_desc` varchar(500) DEFAULT NULL COMMENT '菜单描述',
  `is_enabled` char(1) DEFAULT NULL COMMENT '是否启用',
  `menu_type` char(2) DEFAULT NULL COMMENT '菜单类型',
  `menu_sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `menu_code` char(5) DEFAULT NULL COMMENT '菜单编码',
  `search_code` varchar(255) DEFAULT NULL COMMENT '查询编码',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

/*Data for the table `ck_t_menu` */

insert  into `ck_t_menu`(`id`,`menu_name`,`menu_level`,`menu_flag`,`menu_url`,`parent_id`,`menu_icon`,`menu_desc`,`is_enabled`,`menu_type`,`menu_sort`,`menu_code`,`search_code`,`record_status`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('02eb9211-fa97-4c02-b557-f9f7c4948520','删除用户',4,'ROLE_USER_DELETE','/user/delete','8b9cbfc4-fdf1-4818-993b-5fcea7257859','','','0','02',3,'00028','|00001|00021|00025|00028','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:07',2,NULL),('1','基础管理',1,'ROLE_SYSTEM','/index','0','icon-cog','','0','01',0,'00001','|00001','0','1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('1d5ca5df-c398-44cc-9a42-19c2f38f9258','菜单详情',3,'ROLE_MENU_DETAIL','/menu/detail','4','','','0','01',1,'00037','|00001|00023|00037','0','1','2019-05-28 00:00:00','1','2019-05-28 12:30:04',2,NULL),('2','用户管理',2,'ROLE_USER_LIST','/user','1','icon-user','','0','01',1,'00021','|00001|00021','0','1','2018-05-27 00:00:00','1','2019-05-28 12:17:18',1,NULL),('23926bfa-7cda-4003-abdf-9190d76a4176','添加用户',4,'ROLE_USER_INSERT','/user/save','8b9cbfc4-fdf1-4818-993b-5fcea7257859','','','0','02',1,'00026','|00001|00021|00025|00026','0','1','2019-05-27 00:00:00','1','2019-05-28 12:28:57',2,NULL),('3','角色管理',2,'ROLE_ROLE_LIST','/role','1','icon-eye-open','','0','01',2,'00022','|00001|00022','0','1','2018-05-27 00:00:00','1','2019-05-28 12:27:42',2,NULL),('36cd8ca0-8a11-49ae-8e59-4b4752002bc5','用户角色分配',4,'ROLE_USER_GRANT_ROLE','/user/grant/role','8b9cbfc4-fdf1-4818-993b-5fcea7257859','','','0','02',4,'00029','|00001|00021|00025|00029','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:12',2,NULL),('39c6bea3-de03-4330-85e4-7d246ad0899d','删除菜单',4,'ROLE_MENU_DELETE','/menu/delete','1d5ca5df-c398-44cc-9a42-19c2f38f9258','','','0','02',3,'00040','|00001|00023|00037|00040','0','1','2019-05-28 00:00:00','1','2019-05-28 12:30:20',1,NULL),('4','菜单管理',2,'ROLE_MENU_LIST','/menu','1','icon-th-list','','0','01',3,'00023','|00001|00023','0','1','2018-05-27 00:00:00','1','2019-05-28 12:27:53',2,NULL),('48fe30df-8434-43de-a93a-7cc8de8aedfc','添加菜单',4,'ROLE_MENU_INSERT','/menu/save','1d5ca5df-c398-44cc-9a42-19c2f38f9258','','','0','02',1,'00038','|00001|00023|00037|00038','0','1','2019-05-28 00:00:00','1','2019-05-28 12:30:10',1,NULL),('7943fcdc-ec7e-4320-91a9-a5d1a41f5c2e','删除角色',4,'ROLE_ROLE_DELETE','/role/delete','c753ca9c-2eec-4063-8c59-f2cd2708684f','','','0','02',3,'00034','|00001|00022|00031|00034','0','1','2019-05-28 00:00:00','1','2019-05-28 12:29:46',1,NULL),('8b9cbfc4-fdf1-4818-993b-5fcea7257859','用户详情',3,'ROLE_USER_DETAIL','/user/detail','2','','','0','01',1,'00025','|00001|00021|00025','0','1','2019-05-27 00:00:00','1','2019-05-28 12:28:46',1,NULL),('97f9e31b-8765-47e7-b8b5-0d2f35d8ca8a','编辑用户',4,'ROLE_USER_UPDATE','/user/save','8b9cbfc4-fdf1-4818-993b-5fcea7257859','','','0','02',2,'00027','|00001|00021|00025|00027','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:02',2,NULL),('b2ba86f1-1bd1-470b-bd2b-4290d4966dd4','编辑菜单',4,'ROLE_MENU_UPDATE','/menu/save','1d5ca5df-c398-44cc-9a42-19c2f38f9258','','','0','02',2,'00039','|00001|00023|00037|00039','0','1','2019-05-28 00:00:00','1','2019-05-28 12:30:15',1,NULL),('bf4c8648-160c-45db-bd8a-6902ba3a92d1','用户查询',3,'ROLE_USER_SEARCH','/user/list','2','','','0','02',2,'00024','|00001|00021|00024','0','1','2019-05-28 00:00:00','1','2019-05-28 12:28:29',1,NULL),('c753ca9c-2eec-4063-8c59-f2cd2708684f','角色详情',3,'ROLE_ROLE_DETAIL','/role/detail','3','','','0','01',1,'00031','|00001|00022|00031','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:24',1,NULL),('e5490268-1755-4e49-9b52-8b2ce5f1b4a1','菜单查询',3,'ROLE_MENU_SEARCH','/menu/list','4','','','0','02',2,'00036','|00001|00023|00036','0','1','2019-05-28 00:00:00','1','2019-05-28 12:30:00',1,NULL),('ec498171-b660-4a7e-ac59-10c830598ca3','编辑角色',4,'ROLE_ROLE_UPDATE','/role/save','c753ca9c-2eec-4063-8c59-f2cd2708684f','','','0','02',2,'00033','|00001|00022|00031|00033','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:37',3,NULL),('ed7cc67f-9380-4131-b1fd-837e017a3147','角色菜单',4,'ROLE_GRANT_MENUS','/role/grant/menus','c753ca9c-2eec-4063-8c59-f2cd2708684f','','','0','02',4,'00035','|00001|00022|00031|00035','0','1','2019-05-28 00:00:00','1','2019-05-28 12:29:50',1,NULL),('fd0d1ec7-7f84-474f-aa78-3c9737387b45','新增角色',4,'ROLE_ROLE_INSERT','/role/save','c753ca9c-2eec-4063-8c59-f2cd2708684f','','','0','02',1,'00032','|00001|00022|00031|00032','0','1','2019-05-27 00:00:00','1','2019-05-28 12:29:33',2,NULL),('fe6efdaf-7e08-4ba1-9915-fc7d2a475d3c','角色查询',3,'ROLE_ROLE_SEARCH','/role/list','3','','','0','02',2,'00030','|00001|00022|00030','0','1','2019-05-28 00:00:00','1','2019-05-28 12:29:19',1,NULL);

/*Table structure for table `ck_t_role` */

DROP TABLE IF EXISTS `ck_t_role`;

CREATE TABLE `ck_t_role` (
  `id` char(36) NOT NULL,
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `role_key` varchar(50) DEFAULT NULL COMMENT '角色标识',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

/*Data for the table `ck_t_role` */

insert  into `ck_t_role`(`id`,`role_name`,`role_desc`,`role_key`,`record_status`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('1','系统管理员','','ROLE_ADMIN','0','1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('dbb0ea0f-6787-4cc8-af6d-8a9882fa3de5','测试','fff','fff','0','1','2019-05-27 00:00:00','1','2019-05-28 10:04:46',1,NULL);

/*Table structure for table `ck_t_role_menu` */

DROP TABLE IF EXISTS `ck_t_role_menu`;

CREATE TABLE `ck_t_role_menu` (
  `id` char(36) NOT NULL,
  `role_id` char(36) NOT NULL COMMENT '角色表主键',
  `menu_id` char(36) NOT NULL COMMENT '菜单表主键',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单关联表';

/*Data for the table `ck_t_role_menu` */

insert  into `ck_t_role_menu`(`id`,`role_id`,`menu_id`,`record_status`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('00619636-be7d-46a1-96dd-e61486054a96','1','36cd8ca0-8a11-49ae-8e59-4b4752002bc5','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('08ae4074-4470-4294-b054-f9dc075bbe0f','1','02eb9211-fa97-4c02-b557-f9f7c4948520','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('138ad6a3-3af1-4635-9788-a5bb91fac1b0','1','ed7cc67f-9380-4131-b1fd-837e017a3147','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('257df59d-7047-4844-8172-828eed659cfb','1','e5490268-1755-4e49-9b52-8b2ce5f1b4a1','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('35be9d85-097f-460b-80a6-701e0a63ff7a','1','c753ca9c-2eec-4063-8c59-f2cd2708684f','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('3b94f594-d119-4af1-a4a5-9d524434a2a4','1','2','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('45e034be-360a-4373-b5e7-c51066ac73ff','1','48fe30df-8434-43de-a93a-7cc8de8aedfc','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('487709c5-d908-4f5f-a1fc-301989cdfb42','1','97f9e31b-8765-47e7-b8b5-0d2f35d8ca8a','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('5ed24373-232e-4109-a97e-01bedf5a906e','1','3','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('61712563-6569-4176-aa90-2ca0691356f1','1','8b9cbfc4-fdf1-4818-993b-5fcea7257859','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('686ba31e-2bb9-4790-93e9-7a415c028c43','1','1d5ca5df-c398-44cc-9a42-19c2f38f9258','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('764103f3-870f-4ca5-b865-d2dd50530201','1','ec498171-b660-4a7e-ac59-10c830598ca3','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('8769cf47-209b-47bc-b956-8b6bf3ae2a41','dbb0ea0f-6787-4cc8-af6d-8a9882fa3de5','2','0','1','2019-05-28 16:04:00','1','2019-05-28 16:04:00',0,NULL),('88e03edd-be0f-406d-89f0-1042634385ce','1','7943fcdc-ec7e-4320-91a9-a5d1a41f5c2e','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('8f5b7ba4-eb4f-4ae1-a90a-d3b8897ad1f7','1','fe6efdaf-7e08-4ba1-9915-fc7d2a475d3c','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('a355ee18-5e7a-48b3-a4a8-853b720df3ef','1','23926bfa-7cda-4003-abdf-9190d76a4176','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('ba46bfc5-9fac-48da-a089-d0e5d8a71e2a','1','bf4c8648-160c-45db-bd8a-6902ba3a92d1','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('cdd4c76d-effd-4b4d-aacc-93bb0b0894a4','dbb0ea0f-6787-4cc8-af6d-8a9882fa3de5','bf4c8648-160c-45db-bd8a-6902ba3a92d1','0','1','2019-05-28 16:04:00','1','2019-05-28 16:04:00',0,NULL),('d03d3a5a-e8bb-4964-b8cc-c07e525f2b9e','1','4','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('d4e3c757-e735-45e4-a04a-5b7cfa7a91d2','dbb0ea0f-6787-4cc8-af6d-8a9882fa3de5','1','0','1','2019-05-28 16:04:00','1','2019-05-28 16:04:00',0,NULL),('d55ff477-06bc-4738-b270-2af8c435a3d2','1','39c6bea3-de03-4330-85e4-7d246ad0899d','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('d8671290-35a1-441b-acda-3682c9abca21','1','fd0d1ec7-7f84-474f-aa78-3c9737387b45','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('e0025650-319b-4b00-b010-aee35cd8258c','1','b2ba86f1-1bd1-470b-bd2b-4290d4966dd4','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL),('e33ce2f5-7d70-42fe-9850-e1f3856109da','1','1','0','1','2019-05-28 00:00:00','1','2019-05-28 00:00:00',0,NULL);

/*Table structure for table `ck_t_user` */

DROP TABLE IF EXISTS `ck_t_user`;

CREATE TABLE `ck_t_user` (
  `id` char(36) NOT NULL,
  `login_name` varchar(255) NOT NULL COMMENT '登录用户名',
  `login_password` varchar(255) NOT NULL COMMENT '登录密码',
  `cust_name` varchar(255) DEFAULT NULL COMMENT '身份证名称',
  `credentials_code` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

/*Data for the table `ck_t_user` */

insert  into `ck_t_user`(`id`,`login_name`,`login_password`,`cust_name`,`credentials_code`,`mobile`,`email`,`record_status`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('1','admin','$2a$10$zPfrORypeqQrQOc8t5vXlud24o23nk8eU/GGcQkUHCvBVcpbwt3SC','管理员','','13800138000','admin@163.com','0','1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('65985213-53f2-4ed7-8853-50d35e685927','wjf2','$2a$10$9/AmJrpdmMkc1MbmJfdklO.KwYlI2NjHV7yUSJffzjKTtXsg0FdTa','望京','320689198502014336','13818872986',NULL,'0','1','2019-05-27 00:00:00','1','2019-05-27 00:00:00',5,NULL);

/*Table structure for table `ck_t_user_role` */

DROP TABLE IF EXISTS `ck_t_user_role`;

CREATE TABLE `ck_t_user_role` (
  `id` char(36) NOT NULL,
  `user_id` char(36) NOT NULL COMMENT '用户表主键',
  `role_id` char(36) NOT NULL COMMENT '角色表主键',
  `record_status` char(1) DEFAULT NULL COMMENT '记录状态',
  `create_user` char(36) DEFAULT NULL COMMENT '创建人员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` char(36) DEFAULT NULL COMMENT '最后更新人员',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户与角色关联表';

/*Data for the table `ck_t_user_role` */

insert  into `ck_t_user_role`(`id`,`user_id`,`role_id`,`record_status`,`create_user`,`create_date`,`last_update_user`,`last_update_date`,`version`,`memo`) values ('1','1','1','有','1','2018-05-27 00:00:00','1','2018-05-27 00:00:00',0,NULL),('d5ad0fef-41ee-402e-9949-fc65cf08f773','65985213-53f2-4ed7-8853-50d35e685927','dbb0ea0f-6787-4cc8-af6d-8a9882fa3de5','0','1','2019-05-28 16:06:03','1','2019-05-28 16:06:03',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
