 -- Lv_Home

 -- 用户信息表
CREATE TABLE IF NOT EXISTS `usertable` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `useraccount` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  UNIQUE (useraccount),
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `usertable` (`userId`, `useraccount`, `username`, `password`, `sex`, `age`) VALUES
(1, 'zhangsan', 'zhangsan', '123456', '男', 18),
(2, 'lisi', 'lisi', '123456', '男', 19),
(3, 'wangwu', 'wangwu', '123456', '男', 20),
(4, 'zhaoliu', 'zhaoliu', '123456', '男', 20),
(5, 'tianqi', 'tianqi', '123456', '男', 20),
(6, 'huba', 'huba', '123456', '男', 20);

 -- 驴舍信息表
CREATE TABLE IF NOT EXISTS `hometable` (
  `homeId` int(20) NOT NULL AUTO_INCREMENT,
  `userId` int(20) DEFAULT NULL,
  `temperature` float(2) DEFAULT NULL,
  `humidity` float(3) DEFAULT NULL,
  `illumination` float(3) DEFAULT NULL,
  `dest1` varchar(60) DEFAULT NULL,
  `dest2` varchar(60) DEFAULT NULL,
  `PANID` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`homeId`),
  KEY `FK_Relationship_1` (`userId`),
  INDEX (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `hometable` (`homeId`, `userId`, `temperature`, `humidity`, `illumination`, `dest1`, `dest2`, `PANID`) VALUES
(1, 3, 0, 0, 0, NULL, NULL, NULL),
(2, 2, 0, 0, 0, NULL, NULL, NULL),
(3, 1, 0, 0, 0, NULL, NULL, NULL);

 -- 驴的信息表
CREATE TABLE IF NOT EXISTS `donkeytable` (
  `donkeyId` int(20) NOT NULL AUTO_INCREMENT ,
  `RFIDInfo` varchar(50) DEFAULT NULL ,
  `homeId` int(20) DEFAULT NULL ,
  `gender` varchar(50) DEFAULT NULL ,
  `size` int(3) DEFAULT NULL ,
  PRIMARY KEY (`donkeyId`) ,
  UNIQUE (RFIDInfo) ,
  KEY `FK_Relationship_2` (`homeId`) ,
  INDEX (`homeId`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `donkeytable` (`donkeyId`, `RFIDInfo`, `homeId`, `gender`, `size`) VALUES
(1, NULL, 1, '雌', 1),
(2, NULL, 2, '雌', 2),
(3, NULL, 3, '雌', 2),
(4, NULL, 1, '雄', 2),
(5, NULL, 2, '雄', 2),
(6, NULL, 3, '雄', 2);


 -- 历史信息表   -   用来画图  --  留给 SocketServer 来使用


 -- 驴设温度历史信息表
CREATE TABLE IF NOT EXISTS `homeTemperatureHistory` (
  `hometimeId` int(20) NOT NULL AUTO_INCREMENT,
  `homeId` int(20) NOT NULL ,
  `temperature` float(2) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL ,
  PRIMARY KEY (`hometimeId`),
  KEY `FK_Relationship_3` (`homeId`),
  INDEX (`homeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


 -- 驴设湿度历史信息表
CREATE TABLE IF NOT EXISTS `homeHumidityHistory` (
  `hometimeId` int(20) NOT NULL AUTO_INCREMENT,
  `homeId` int(20) NOT NULL ,
  `humidity` float(3) DEFAULT NULL ,
  `time` varchar(30) DEFAULT NULL ,
  PRIMARY KEY (`hometimeId`),
  KEY `FK_Relationship_4` (`homeId`),
  INDEX (`homeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


 -- 驴设光照历史信息表
CREATE TABLE IF NOT EXISTS `homeIlluminationHistory` (
  `hometimeId` int(20) NOT NULL AUTO_INCREMENT,
  `homeId` int(20) NOT NULL ,
  `illumination` float(3) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL ,
  PRIMARY KEY (`hometimeId`),
  KEY `FK_Relationship_5` (`homeId`),
  INDEX (`homeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 -- 驴的历史信息表
CREATE TABLE IF NOT EXISTS `donkeyhistory` (
  `donkeytimeId` int(20) NOT NULL AUTO_INCREMENT ,
  `donkeyId` int(20) NOT NULL ,
  `RFIDInfo` varchar(50) DEFAULT NULL ,
  `size` int(3) DEFAULT NULL ,
  `time` varchar(30) DEFAULT NULL ,
  PRIMARY KEY (`donkeytimeId`) ,
  KEY `FK_Relationship_6` (`donkeyId`) ,
  INDEX (`donkeyId`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



ALTER TABLE `hometable`
  ADD CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`userId`) REFERENCES `usertable` (`userId`) ON DELETE CASCADE;
  
ALTER TABLE `donkeytable`
  ADD CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`homeId`) REFERENCES `hometable` (`homeId`) ON DELETE CASCADE;

 -- 用来记录驴舍数据历史   

ALTER TABLE `homeTemperatureHistory`
  ADD CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`homeId`) REFERENCES `hometable` (`homeId`) ON DELETE CASCADE;
  
ALTER TABLE `homeHumidityHistory`
  ADD CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`homeId`) REFERENCES `hometable` (`homeId`) ON DELETE CASCADE;
  
ALTER TABLE `homeIlluminationHistory`
  ADD CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`homeId`) REFERENCES `hometable` (`homeId`) ON DELETE CASCADE;

 -- 驴历史  
  
ALTER TABLE `donkeyhistory`
  ADD CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`donkeyId`) REFERENCES `donkeytable` (`donkeyId`) ON DELETE CASCADE;
  