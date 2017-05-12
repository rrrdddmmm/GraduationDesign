/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : simulation_laboratory

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-04-16 19:04:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12', '12', '12', '1');
INSERT INTO `user` VALUES ('123', '123', '123', '1');
INSERT INTO `user` VALUES ('12', '2111121', '12', '1');
INSERT INTO `user` VALUES ('123456', '314187985@qq.com', '123123', '1');
INSERT INTO `user` VALUES ('123456', '314187985@qq44.com', '18829348437', '1');
