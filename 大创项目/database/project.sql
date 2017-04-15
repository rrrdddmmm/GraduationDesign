/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : simulation_laboratory

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-04-16 03:29:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_no` int(11) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `home_no` int(11) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `project_data` varchar(50) DEFAULT NULL,
  `project_language` varchar(50) NOT NULL,
  `develop_platform` varchar(50) NOT NULL,
  `all_number` int(11) NOT NULL,
  `pronser_number` int(11) NOT NULL,
  `crt_time` date NOT NULL,
  `update_time` date DEFAULT NULL,
  `status` int(10) NOT NULL,
  `leader` varchar(10) NOT NULL,
  `approver` varchar(10) NOT NULL,
  `budget` double(10,0) NOT NULL,
  `describe` varchar(50) NOT NULL,
  PRIMARY KEY (`project_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '计算机开发', null, '314187985@qq.com', null, 'java', 'windows', '5', '5', '2017-04-13', '2017-04-03', '0', '任博', '宁少杰', '2017', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `project` VALUES ('2', '会议管理系统', null, '925857350@qq.com', null, 'java', 'windows', '6', '3', '2017-04-16', '2017-04-16', '0', '宁少杰', '任博', '2303', '啊啊啊啊啊啊啊啊啊啊啊');
