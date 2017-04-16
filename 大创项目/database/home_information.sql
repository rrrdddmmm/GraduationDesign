/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : simulation_laboratory

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-04-16 16:21:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `home_information`
-- ----------------------------
DROP TABLE IF EXISTS `home_information`;
CREATE TABLE `home_information` (
  `project_no` int(10) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`project_no`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home_information
-- ----------------------------
INSERT INTO `home_information` VALUES ('15', '314187985@qq.com');
