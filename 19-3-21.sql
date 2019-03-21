/*
SQLyog Ultimate v8.32 
MySQL - 5.5.54 : Database - pigcar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pigcar` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pigcar`;

/*Table structure for table `cars` */

DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `CARNUMBER` varchar(20) NOT NULL,
  `CARTYPE` varchar(50) NOT NULL,
  `COLOR` varchar(10) NOT NULL,
  `PRICE` decimal(10,2) NOT NULL,
  `RENTPRICE` decimal(10,2) NOT NULL,
  `DEPOSIT` decimal(10,2) NOT NULL,
  `ISRENTING` varchar(20) NOT NULL,
  `CARDESC` varchar(500) DEFAULT NULL,
  `CARIMG` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CARNUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cars` */

insert  into `cars`(`CARNUMBER`,`CARTYPE`,`COLOR`,`PRICE`,`RENTPRICE`,`DEPOSIT`,`ISRENTING`,`CARDESC`,`CARIMG`) values ('00000','玛莎拉蒂','白色','99999.00','32428.00','78798.00','0','时速450km/h','efb06605aa464865a839704c7004a515.png'),('1','奥迪','231','123.00','213.00','123.00','0','经典选力气车','3748f25670b64a95bab430b7e4abaf6e.jpg'),('2','奔驰','白色','1000.00','2313.00','3214.00','0','红色霸气suv','dfa039b4cc1548e39c6ff3ab5711e2c8.jpg'),('6666','兰博基尼','黑色','1000777.00','8888.00','99999.00','0','时速400km/h','e6a96a741dab4c739eec4a0a2248edd3.png'),('7777','保时捷','蓝色','99999.00','88888.00','8888.00','0','时速330km/h','f53e2c5ea359459f9c7ee99b451e77f2.png'),('8888','宾利','灰色','787877.00','88877.00','88888.00','0','时速350km/h','8c78890d45e8412bbf43464667d2e189.png'),('京N121-112','奔驰','褐色','1000000.00','10000.00','10000.00','0','炫丽奔驰','276e2bd04e67499dad9dac6bf1e61136.jpg'),('京N1261','兰博基尼','红色','10000000.00','20000.00','1000000.00','0','价值千万的兰博基尼','3f59bd3756304478bdc568bf625d5a56.jpg'),('京n21311','京n21312','黑色','121212.00','1111.00','11111.00','0','dsfsa fsadfa','3e18a84d7e8b44e3811c456b71ff91e8.png'),('京n21312','京n21312','黑色','121212.00','1111.00','11111.00','0','第三方是的撒','863c61bfece54a7e9030042ab985456b.png'),('京N88963','奥迪A80923','白色','1829343.00','23200.00','100000.00','1','奥迪A8','2864a42bde3942149b56e45f5a5ee5f8.jpg');

/*Table structure for table `checktable` */

DROP TABLE IF EXISTS `checktable`;

CREATE TABLE `checktable` (
  `CHECKID` bigint(50) NOT NULL,
  `CHECKDATE` datetime NOT NULL,
  `FIELD` varchar(100) DEFAULT NULL,
  `PROBLEM` varchar(100) DEFAULT NULL,
  `PAYING` decimal(10,2) DEFAULT NULL,
  `CHECKUSERID` varchar(40) NOT NULL,
  `RENTID` bigint(50) NOT NULL,
  PRIMARY KEY (`CHECKID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `checktable` */

insert  into `checktable`(`CHECKID`,`CHECKDATE`,`FIELD`,`PROBLEM`,`PAYING`,`CHECKUSERID`,`RENTID`) values (128717731360767920,'2018-11-06 00:00:00','1212','1212','12121.00','admin',202608434162256832),(709156172693120256,'2018-11-07 00:00:00','','',NULL,'',5312621529580897);

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `IDENTITY` varchar(20) NOT NULL,
  `CUSTNAME` varchar(40) NOT NULL,
  `SEX` varchar(10) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `CAREER` varchar(20) NOT NULL,
  `CUSTPWD` varchar(20) NOT NULL,
  PRIMARY KEY (`IDENTITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customers` */

insert  into `customers`(`IDENTITY`,`CUSTNAME`,`SEX`,`ADDRESS`,`PHONE`,`CAREER`,`CUSTPWD`) values ('11111','111','111','1111','11','111','111'),('111112132131','王二下','男','北京','23232','1','1Aa12_dss'),('12121212121212','周清来','男','北京市海淀区肖家河新村东区9栋3单元','13359850175','架构师','1'),('123','11212','213412','234123','2141','1234','12341'),('12312131114121','潘森','男','北京朝阳','13333387382','老师','1'),('123456','解决1','男','mmm','123','安德森','333'),('130729199503252113','老李','男','北京','18131371979','学生','点击显示密码'),('456745','於化安','男','额未全额','2313231','243424','4324234'),('4598','於化安','男','32131','3123123123','12312','123456'),('532128199511231123','周清来','男','北京市海淀区肖家河新村东区9栋3单元','13359850175','架构师','1'),('789','111','女','北京ff','5737','解决','222'),('85258','阿门','男','2434','3244','4234','24342432'),('9898','於化於','男','32131321','3123123','12312312','3123123');

/*Table structure for table `funs` */

DROP TABLE IF EXISTS `funs`;

CREATE TABLE `funs` (
  `FUNID` decimal(8,0) NOT NULL,
  `FUNNAME` varchar(40) NOT NULL,
  `FUNURL` varchar(80) NOT NULL,
  `MENUID` decimal(8,0) NOT NULL,
  PRIMARY KEY (`FUNID`),
  KEY `FUNS_FK` (`MENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `funs` */

insert  into `funs`(`FUNID`,`FUNNAME`,`FUNURL`,`MENUID`) values ('1','主页面','index.jsp','1'),('2','头页面','head.jsp','1'),('3','菜单页面','menu.jsp','1'),('4','脚页面','foot.jsp','1'),('5','操作页面','welcome.jsp','1'),('6','权限提示页面','norole.jsp','1'),('8','退出系统动作n','ExitSystemAction.do','1'),('9','菜单导航','modNavTop.jsp','1'),('10','菜单条','splitor.jsp','1'),('11','操作失败提示页面','error.jsp','1'),('12','系统崩溃提示页面','appError.jsp','1'),('13','成功页面','ok.jsp','1'),('15','添加角色功能n','RoleManagerAction.do','20'),('16','角色管理页面','roleManager.jsp','20'),('17','查询角色信息动作','FindRole.do','20'),('18','添加新角色的菜单查询动作','FindMenus.do','20'),('19','预修改角色信息查询动作','PreUpdateRole.do','20'),('20','修改角色信息动作','UpdateRole.do','20'),('21','删除角色动作','DeleteRole.do','20'),('22','添加新角色页面','addRole.jsp','20'),('23','查询日志信息页面','findLog.jsp','21'),('24','查询日志信息动作n','LogOperatorAction.do','21'),('25','显示日志信息页面','viewLog.jsp','21'),('26','删除日志信息动作','DeleteLog.do','21'),('27','查询登陆信息页面','findLoginInfo.jsp','22'),('28','查询登陆信息动作','LoginInfoOperatorAction.do','22'),('29','显示登陆信息页面','showLoginLogInfo.jsp','22'),('30','底页面','foot.jsp','1'),('50','添加用户角色查询动作n','AddUserAction.do','3'),('51','添加用户页面','addUser.jsp','3'),('52','添加用户动作','AddUser.do','3'),('53','查询用户角色查询动作n','FindUserAction.do','4'),('54','查询用户页面','findUser.jsp','4'),('55','显示查询用户结果页面n','viewUser.jsp','4'),('56','查询用户动作','FindUser.do','4'),('57','预更新查询用户动作','PreUpdateUser.do','4'),('58','显示更新用户页面','updateUser.jsp','4'),('59','更新用户动作','UpdateUser.do','4'),('60','删除用户动作','DeleteUser.do','4'),('61','预修改用户密码','PreChangeUserPwd.do','4'),('62','修改用户密码页面','chengeUserPwd.jsp','4'),('63','修改用户密码动作','ChangeUserPwd.do','4'),('100','添加客户页面','addCustomers.jsp','6'),('101','添加客户动作n','AddCustomersAction.do','6'),('102','查询客户页面','findCustomers.jsp','7'),('103','查询客户信息动作n','FindCustomersAction.do','7'),('104','显示查询客户结果页面','viewCustomers.jsp','7'),('105','预更新客户查询动作','PreCustomers.do','7'),('106','显示更新客户页面','updateCustomers.jsp','7'),('107','更新客户动作','UpdateCustomers.do','7'),('108','删除客户动作','DeleteCustomers.do','7'),('109','预修改客户密码','PreChangeCustomerPwd.do','7'),('110','修改客户密码页面','chengeCustomersPwd.jsp','7'),('111','修改用户密码动作','ChangeCustomersPwd.do','7'),('200','添加汽车页面','addCar.jsp','9'),('201','添加汽车动作n','AddCarAction.do','9'),('202','查询汽车页面','findCar.jsp','10'),('203','显示查询汽车结果页面','viewCars.jsp','10'),('204','查询汽车信息动作n','FindCarAction.do','10'),('205','预更新查询汽车动作','PreUpdateCar.do','10'),('206','显示更新汽车结果页面','updateCar.jsp','10'),('207','更新汽车动作','UpdateCar.do','10'),('209','删除汽车动作','DeleteCar.do','10'),('300','租车页面','rentCar.jsp','12'),('301','预生成出租单动作n','RentingCarAction.do','12'),('302','预生成出租单页面','preCreateRenting.jsp','12'),('303','生成出租单动作','CreateRentCarTable.do','12'),('304','汽车出租单查询页面','returnCar.jsp','13'),('305','预还车查询动作','PreReturnCarSearch.do','13'),('306','创建检查单页面','createCheckTable.jsp','13'),('307','创建检查单动作','CreateCheckTable.do','13'),('308','出租单管理页面','rentManager.jsp','14'),('309','出租单管理查询动作','RentManagerSearch.do','14'),('310','显示查询出租单结果页面','viewRenttables.jsp','14'),('311','预更新出租单查询动作','PreUpdateRenttable.do','14'),('312','更新出租单页面','updateRenttable.jsp','14'),('313','更新出租单动作','UpdateRenttable.do','14'),('314','删除出租单动作','DeleteRenttable.do','14'),('315','检查单管理页面','checkManager.jsp','15'),('316','查询检查单动作','FindCheckTable.do','15'),('317','显示查询检查单结果页面','viewCheckTables.jsp','15'),('318','预更新检查单查询动作','PreUdateCheckTable.do','15'),('319','更新检查单页面','updateCheckTable.jsp','15'),('320','更新检查单动作','UpdateCheckTable.do','15'),('321','删除检查单动作','DeleteCheckTables.do','15'),('322','查询当月应还汽车动作n','MonthStatisticsCarAction.do','17'),('400','显示当月应还车结果页面','viewMonthReturnCarResult.jsp','17'),('401','查询当月应归还汽车相信信息','FindMonthReturnCarByInfo.do','17'),('402','显示当月应还汽车详细信息','findMonthReturnCarByInfo.jsp','17');

/*Table structure for table `loginlogs` */

DROP TABLE IF EXISTS `loginlogs`;

CREATE TABLE `loginlogs` (
  `LOGINLOGID` int(20) NOT NULL AUTO_INCREMENT,
  `LOGINNAME` varchar(80) DEFAULT NULL,
  `LOGINIP` varchar(40) DEFAULT NULL,
  `LOGINTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`LOGINLOGID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `loginlogs` */

insert  into `loginlogs`(`LOGINLOGID`,`LOGINNAME`,`LOGINIP`,`LOGINTIME`) values (2,'admin','0:0:0:0:0:0:0:1','2018-10-23 11:14:17'),(3,'admin','0:0:0:0:0:0:0:1','2018-10-23 11:17:02'),(4,'admin','0:0:0:0:0:0:0:1','2018-10-23 12:07:10'),(5,'1','0:0:0:0:0:0:0:1','2018-11-06 02:36:44'),(6,'1','0:0:0:0:0:0:0:1','2018-11-06 02:52:20'),(7,'1','0:0:0:0:0:0:0:1','2018-11-06 02:54:59'),(8,'1','0:0:0:0:0:0:0:1','2018-11-06 03:07:36'),(9,'1','0:0:0:0:0:0:0:1','2018-11-06 03:27:21'),(10,'1','0:0:0:0:0:0:0:1','2018-11-06 09:50:44'),(11,'1','0:0:0:0:0:0:0:1','2018-11-07 00:57:10');

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(40) NOT NULL,
  `ACTION` varchar(40) NOT NULL,
  `ACTIONTIME` datetime NOT NULL,
  `FLAG` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `logs` */

insert  into `logs`(`ID`,`USERNAME`,`ACTION`,`ACTIONTIME`,`FLAG`) values (1,'admin','/car/car/user/addUsers','2018-10-23 12:11:12','1'),(2,'admin','/car/car/user/addUsers','2018-10-23 12:21:03','1'),(3,'admin','/car/car/user/addUsers','2018-10-23 12:21:59','1'),(4,'admin','/car/car/user/addUsers','2018-10-23 12:26:13','1'),(5,'admin','/car/car/user/updatePwd','2018-10-23 12:26:57','3'),(6,'admin','/car/car/user/addUsers','2018-10-23 12:31:27','1'),(7,'admin','/car/car/user/addUsers','2018-10-23 12:31:48','1'),(8,'admin','/car/car/user/addCust','2018-10-23 13:30:58','20'),(9,'admin','/car/car/car/addCar','2018-10-23 13:33:59','10'),(10,'admin','/car/car/car/addCar','2018-10-23 13:36:27','10'),(11,'1','/car/car/user/updateUser','2018-11-06 02:50:52','2'),(12,'1','/car/car/user/updatePwd','2018-11-06 02:53:21','3'),(13,'1','/car/car/user/updateUser','2018-11-06 02:53:47','2'),(14,'1','/car/car/user/addUsers','2018-11-06 02:54:49','1'),(15,'1','/car/car/main/addRentTable','2018-11-06 03:08:29','30'),(16,'1','/car/car/check/updateCheck','2018-11-06 03:10:43','31'),(17,'1','/car/car/check/updateCheck','2018-11-06 03:10:59','31'),(18,'1','/car/car/role/updateRole','2018-11-06 03:42:15','41'),(19,'1','/car/car/main/addRentTable','2018-11-06 03:45:57','30'),(20,'1','/car/car/main/addRentTable','2018-11-06 10:08:10','30'),(21,'1','/car/car/main/addRentTable','2018-11-06 10:09:43','30'),(22,'1','/car/car/main/addRentTable','2018-11-06 10:10:56','30'),(23,'1','/car/car/user/addCust','2018-11-06 16:21:01','20');

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `MENUID` decimal(8,0) NOT NULL,
  `MENUNAME` varchar(40) NOT NULL,
  `CONNURL` varchar(80) DEFAULT NULL,
  `FATHERID` decimal(8,0) NOT NULL,
  PRIMARY KEY (`MENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menus` */

insert  into `menus`(`MENUID`,`MENUNAME`,`CONNURL`,`FATHERID`) values ('1','汽车租赁管理系统','null','-1'),('2','用户管理','null','1'),('3','添加用户','userManager/addUser.html','2'),('4','查询用户','car/user/findAllRoles','2'),('5','客户管理','null','1'),('6','添加客户信息','custManager/addCustomers.jsp','5'),('7','查询客户信息','custManager/findCustomers.jsp','5'),('8','汽车管理','null','1'),('9','添加汽车信息','carManager/addCar.jsp','8'),('10','查询汽车信息','carManager/findCar.jsp','8'),('11','业务管理','null','1'),('12','汽车出租','operatorManager/rentCar.jsp','11'),('13','汽车入库','operatorManager/returnCar.jsp','11'),('14','出租单管理','operatorManager/rentManager.jsp','11'),('15','检查单管理','operatorManager/checkManager.jsp','11'),('16','业务统计','null','1'),('17','当月应还汽车','car/statistics/getAllStati','16'),('18','系统管理','null','1'),('20','角色管理','systemManager/roleManager.jsp','18'),('21','日志管理','systemManager/findLog.jsp','18'),('22','登陆信息管理','systemManager/findLoginInfo.jsp','18'),('23','查询所有用户信息','car/user/findUserByPage','2'),('24','统计每辆汽车的租金情况','car/countRent/countPriceAndNum','16'),('25','统计每月汽车的租赁次数','car/statistics/getMonthAmount','16');

/*Table structure for table `renttable` */

DROP TABLE IF EXISTS `renttable`;

CREATE TABLE `renttable` (
  `TABLEID` bigint(50) NOT NULL,
  `IMPREST` decimal(10,2) NOT NULL,
  `SHOULDPAYPRICE` decimal(10,2) NOT NULL,
  `PRICE` decimal(10,2) NOT NULL,
  `BEGINDATE` datetime NOT NULL,
  `SHOULDRETURNDATE` datetime NOT NULL,
  `RETERNDATE` datetime DEFAULT NULL,
  `RENTFLAG` decimal(8,0) NOT NULL,
  `CUSTID` varchar(20) NOT NULL,
  `CARID` varchar(20) NOT NULL,
  `USERID` varchar(40) NOT NULL,
  PRIMARY KEY (`TABLEID`),
  KEY `RENTTABLE_CUSTIONERS_FK3` (`USERID`),
  KEY `RENTTABLE_CUSTOMERS_FK1` (`CUSTID`),
  KEY `RENTTABLE_CUSTONERS_FK2` (`CARID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `renttable` */

insert  into `renttable`(`TABLEID`,`IMPREST`,`SHOULDPAYPRICE`,`PRICE`,`BEGINDATE`,`SHOULDRETURNDATE`,`RETERNDATE`,`RENTFLAG`,`CUSTID`,`CARID`,`USERID`) values (5312621529580897,'471200.00','371200.00','1111.00','2018-11-06 00:00:00','2018-11-22 00:00:00',NULL,'0','532128199511231123','京N88963','admin'),(93814336988798816,'111226.00','32428.00','121212.00','2018-11-06 00:00:00','2018-11-06 00:00:00',NULL,'1','532128199511231123','00000','lifan'),(171364454550031680,'111226.00','32428.00','121212.00','2018-11-06 00:00:00','2018-11-07 00:00:00',NULL,'0','111112132131','00000','admin'),(202608434162256832,'1614.00','1491.00','1111.00','2018-11-06 00:00:00','2018-11-13 16:00:00',NULL,'0','532128199511231123','1','admin'),(220143659151784256,'123200.00','23200.00','1111.00','2018-11-06 00:00:00','2018-11-07 00:00:00',NULL,'0','12312131114121','京N88963','admin'),(350616471593578880,'29998.00','18887.00','121212.00','2018-11-06 00:00:00','2018-11-23 00:00:00',NULL,'0','12312131114121','京n21312','admin');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `ROLEID` decimal(8,0) NOT NULL,
  `ROLENAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`ROLEID`,`ROLENAME`) values ('1','管理员'),('10','业务员'),('11','维护人员'),('12','用户1'),('13','用户2'),('14','管理员1'),('15','用户3'),('24','业务员2'),('25','业务员3'),('26','角色1'),('27','角色2'),('28','营业员'),('29','1');

/*Table structure for table `roles_menus` */

DROP TABLE IF EXISTS `roles_menus`;

CREATE TABLE `roles_menus` (
  `ROLEID` decimal(8,0) NOT NULL,
  `MENUID` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ROLEID`,`MENUID`),
  KEY `ROLES_MENUS_FK2` (`MENUID`),
  CONSTRAINT `ROLES_MENUS_FK1` FOREIGN KEY (`ROLEID`) REFERENCES `roles` (`ROLEID`),
  CONSTRAINT `ROLES_MENUS_FK2` FOREIGN KEY (`MENUID`) REFERENCES `menus` (`MENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles_menus` */

insert  into `roles_menus`(`ROLEID`,`MENUID`) values ('1','1'),('10','1'),('11','1'),('12','1'),('13','1'),('14','1'),('15','1'),('24','1'),('25','1'),('26','1'),('27','1'),('28','1'),('29','1'),('1','2'),('13','2'),('14','2'),('15','2'),('24','2'),('27','2'),('1','3'),('13','3'),('14','3'),('15','3'),('24','3'),('27','3'),('1','4'),('13','4'),('14','4'),('15','4'),('24','4'),('27','4'),('1','5'),('10','5'),('12','5'),('13','5'),('14','5'),('15','5'),('24','5'),('26','5'),('27','5'),('28','5'),('1','6'),('10','6'),('12','6'),('13','6'),('14','6'),('15','6'),('24','6'),('26','6'),('27','6'),('28','6'),('1','7'),('10','7'),('12','7'),('13','7'),('14','7'),('15','7'),('24','7'),('26','7'),('27','7'),('28','7'),('1','8'),('10','8'),('12','8'),('13','8'),('14','8'),('24','8'),('26','8'),('27','8'),('28','8'),('1','9'),('10','9'),('12','9'),('13','9'),('14','9'),('24','9'),('26','9'),('27','9'),('28','9'),('1','10'),('10','10'),('12','10'),('13','10'),('14','10'),('24','10'),('26','10'),('27','10'),('28','10'),('1','11'),('10','11'),('14','11'),('24','11'),('28','11'),('1','12'),('10','12'),('14','12'),('24','12'),('28','12'),('1','13'),('10','13'),('14','13'),('24','13'),('28','13'),('1','14'),('10','14'),('14','14'),('24','14'),('28','14'),('1','15'),('10','15'),('14','15'),('24','15'),('28','15'),('1','16'),('13','16'),('14','16'),('28','16'),('1','17'),('13','17'),('14','17'),('28','17'),('1','18'),('11','18'),('14','18'),('1','20'),('11','20'),('14','20'),('1','21'),('11','21'),('14','21'),('1','22'),('11','22'),('14','22'),('1','23'),('13','23'),('14','23'),('15','23'),('24','23'),('27','23'),('1','24'),('1','25');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `USERNAME` varchar(40) NOT NULL,
  `IDENTITY` varchar(20) NOT NULL,
  `FULLNAME` varchar(20) NOT NULL,
  `SEX` varchar(10) NOT NULL,
  `ADDRESS` varchar(40) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `POSITION` varchar(20) NOT NULL,
  `USERLEVEL` decimal(8,0) NOT NULL,
  `USERPWD` varchar(40) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  KEY `USERS_UK` (`IDENTITY`),
  KEY `USERS_FK` (`USERLEVEL`),
  CONSTRAINT `USERS_FK` FOREIGN KEY (`USERLEVEL`) REFERENCES `roles` (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`USERNAME`,`IDENTITY`,`FULLNAME`,`SEX`,`ADDRESS`,`PHONE`,`POSITION`,`USERLEVEL`,`USERPWD`) values ('aaaa','121212121212','1','女','北京市海淀区肖家河新村东区9栋3单元','12112112112','1','11','123456'),('admin','121212121212','1','男','北京市海淀区肖家河新村东区9栋3单元','12112112112','1','1','123456'),('aql','121212121212','1','男','北京市海淀区肖家河新村东区9栋3单元','12112112112','1','12','123456'),('asd','123123123','1','男','噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦','1231231231','1','28','123456'),('hqz','749464445255','123456789','男','3212435678','123456789','呵呵','1','123456'),('hzq','74185209637418520','何正清','男','深南中路下水道','111992133112','超一线','1','123456'),('lifan','121212121212','1','男','北京市海淀区肖家河新村东区9栋3单元','12112112112','1','10','123456'),('qwe','213132222222','1','女','啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊','12121112112','1','14','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
