DROP database IF EXISTS `simulation_laboratory`;
CREATE DATABASE simulation_laboratory;  
USE simulation_laboratory;  
-- ----------------------------
-- 用户表Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(50) NOT NULL COMMENT '邮件地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(50) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '密码',
  `role` varchar(5) NOT NULL COMMENT '角色',
  `title` varchar(5) DEFAULT '学生' COMMENT '职称',
  `education` varchar(5) DEFAULT '本科' COMMENT '学历',
  `direction` varchar(5) DEFAULT '大数据' COMMENT '方向',
  `introduce` varchar(500) DEFAULT '该用户没有留下任何痕迹!' COMMENT '简介和补充说明',
  `image` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '头像照片',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5)  DEFAULT '2' COMMENT '账号状态',
  `grade` varchar(5)  DEFAULT '1000' COMMENT '用户等级数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '任勃', '314187985@qq.com', '18829348437', 'e10adc3949ba59abbe56e057f20f883e', '3', '职称', '学历', '方向', '简介和补充说明', '/resource/1/TopImages/20170524144855', '2017-04-13', '2017-05-24', '1', '10');
INSERT INTO `t_user` VALUES ('21', '邝忠震', '123456789@qq.com', '15548752689', 'e10adc3949ba59abbe56e057f20f883e', '1', '学生', '本科', '算法', '本人家住湖南省，在西安科技大学学习四年。', '/resource/21/TopImages/20170524144906', '2017-05-23', '2017-05-23', '1', '1000');
INSERT INTO `t_user` VALUES ('22', '董美丽', '850263341@qq.com', '15548785826', 'e10adc3949ba59abbe56e057f20f883e', '2', '教授', '研究生', '大数据', '本人本科在西安科技大学，研究生在西安交通大学，曾获得国家级奖项多项', '/resource/22/TopImages/20170523193238', '2017-05-23', '2017-05-23', '1', '1000');
INSERT INTO `t_user` VALUES ('23', '姚鹏飞', '456789123@qq.com', '18825478965', 'e10adc3949ba59abbe56e057f20f883e', '1', '学生', '本科', 'web开发', '本人在西安科技大学计算机学院软件工程专业学习四年，在这四年获得国家级软件奖项2项，省级5项，校级多项。', '/resource/23/TopImages/20170524144932', '2017-05-23', '2017-05-23', '1', '1000');
INSERT INTO `t_user` VALUES ('24', '王朝', '789123456@qq.com', '15228086532', 'e10adc3949ba59abbe56e057f20f883e', '1', '学生', '研究生', '大数据', '曾经参加数学建模大赛在其中取得了很大的经验，并具有很强的泡妞能力，擅长数学，计算机软件使用，大数据。', '/resource/24/TopImages/20170524145245', '2017-05-24', '2017-05-24', '1', '1000');


-- ----------------------------
-- 职称常量表：Table structure for `t_title`
-- ----------------------------
DROP TABLE IF EXISTS `t_title`;
CREATE TABLE `t_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '职称名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '职称状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_title
-- ----------------------------
INSERT INTO `t_title` VALUES ('21', '学生', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_title` VALUES ('23', '讲师', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_title` VALUES ('24', '教授', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_title` VALUES ('25', '副教授', '2017-05-23', '2017-05-23', '1');

-- ----------------------------
-- 学历常量表：Table structure for `t_education`
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '学历状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_education
-- ----------------------------
INSERT INTO `t_education` VALUES ('21', '初中', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_education` VALUES ('22', '小学', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_education` VALUES ('23', '本科', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_education` VALUES ('24', '研究生', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_education` VALUES ('25', '博士', '2017-05-23', '2017-05-23', '1');


-- ----------------------------
-- 方向常量表：Table structure for `t_direction`
-- ----------------------------
DROP TABLE IF EXISTS `t_direction`;
CREATE TABLE `t_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '方向名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_direction
-- ----------------------------
INSERT INTO `t_direction` VALUES ('21', '大数据', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('22', '云计算', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('23', 'web开发', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('24', 'android开发', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('25', '人工智能', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('26', '游戏开发', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('27', '算法', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_direction` VALUES ('28', '硬件开发', '2017-05-23', '2017-05-23', '1');


-- ----------------------------
-- 新闻表：Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `newstitle` varchar(200) DEFAULT NULL COMMENT '新闻标题',
  `newsexplain` varchar(500) DEFAULT NULL COMMENT '新闻简介',
  `newslogo` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '新闻logo',
  `newsdetails` varchar(200) DEFAULT '#' COMMENT '详情连接',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '0' COMMENT '新闻状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('21', '平台测试', '本平台开发阶段已将近完成马上进入测试阶段，希望广大内测人员尽力测试出bug，以便后期维护。', '/resource/news/1495537091411', '#', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_news` VALUES ('22', '软件测试全面启动', '到目前为止该平台代码实现已经完成，现已全面进入软件测试阶段。在此阶段过程中遇到的问题希望大家积极配合实现bug的战斗。', '/resource/news/1495537540521', '#', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_news` VALUES ('23', '校园软件开发在线协同平台平台1.0版本发布', '校园软件开发在线协同平台平台1.0版本发布，本平台1.0版本在于大家长期测试使用，再次阶段广大用户可以免费使用，在后期不确定是否会收费。', '/resource/news/1495537812843', '#', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_news` VALUES ('24', '平台启动授权', '西安科技大学对校园软件开发平台项目启动授权，其中包括我校各级领导，以及老师，研发工作这共计100人。', '/resource/news/1495702114725', '#', '2017-05-25', '2017-05-25', '1');
INSERT INTO `t_news` VALUES ('25', '项目2.0发布', '校园软件项目开发平台，在经历一年的测试交付使用后，终于迎来了2.0版本的上线，在这一年中感谢广大学生，老师，领导对校园软件在线开发平台的支持。', '/resource/news/1495702304809', '#', '2017-05-25', '2017-05-25', '1');
INSERT INTO `t_news` VALUES ('26', 'bug发布', '校园软件开发在线协同平台在2.0发布的一年后，出现了第一次网络攻击，在这次攻击的过程中影响了广大用户的操作，小编在此表示抱歉，不过的们的bug已经修复，大家可以正常使用该系统进行软件开发管理啦。', '/resource/news/1495702571308', '#', '2017-05-25', '2017-05-25', '1');

-- ----------------------------
-- 项目表Table structure for `t_project`
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `projid` varchar(100) NOT NULL  COMMENT '主键',
  `projname` varchar(50)  NOT NULL COMMENT '项目名称',
  `projemail` varchar(50)  NOT NULL COMMENT '创建人邮件账号',
  `creatpersionname` varchar(50)  NOT NULL COMMENT '创建人姓名',
  `projphone` varchar(20) NOT NULL COMMENT '手机号',
  `projlanguage` varchar(50)  NOT NULL COMMENT '开发语言',
  `projplatform` varchar(50)  NOT NULL COMMENT '开发平台',
  `projallNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目总人数',
  `projcurrentNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目当前人数',
  `projtutor` varchar(10)  NOT NULL COMMENT '指导老师账号',
  `projtutorname` varchar(10)  NOT NULL COMMENT '指导老师姓名',
  `projbudget` double(10,0) DEFAULT NULL COMMENT '项目预算价格',
  `projbudgetFile` varchar(200)  DEFAULT NULL COMMENT '预算账单地址',
  `projprogectFile` varchar(200)  DEFAULT NULL COMMENT '立项书',
  `projdescribe` varchar(500)  DEFAULT NULL COMMENT '项目描述',
  `projlogo` varchar(200)  DEFAULT NULL COMMENT '项目logo',
  `projcreatTime` date NOT NULL COMMENT '创建时间',
  `projstartupTime` date DEFAULT NULL COMMENT '启动时间',
  `projupdateTime` date DEFAULT NULL COMMENT '更新时间',
  `projendTime` date NOT NULL COMMENT '结束时间',
  `projstartupEvaluation` varchar(500) DEFAULT NULL COMMENT '项目启动审核评价',
  `projstartupEvaluationvalue` int(5) DEFAULT 0 COMMENT '项目启动审核评价等级',
  `projstartupEvaluationstate` int(5) DEFAULT 0 COMMENT '项目启动审核状态',
  
  `projresultEvaluationvalue` varchar(500) DEFAULT NULL COMMENT '项目结题审核评价',
  `projresultEvaluation` int(5) DEFAULT 0 COMMENT '项目结题审核评价等级',
  `projresultEvaluationstate` int(5) DEFAULT 0 COMMENT '项目结题审核状态',
  
  `projgrade` varchar(5) NOT NULL DEFAULT '0' COMMENT '项目最终等级数据',
  `projstatus` int(5) NOT NULL DEFAULT 0 COMMENT '项目最终结果状态',
  PRIMARY KEY (`projid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('20170523193658', '计算机开发', '123456789@qq.com', '邝忠震', '15548752689', 'Python', 'Windows', '12', '12', '22', '董美丽', '1255', 'F:/resource/21/20170523193658/4c978c3c-df44-4c3e-8699-cc0e75e9a57d新版标准日本语初级单词文本(1-48课)电子文档.doc', 'F:/resource/21/20170523193658/c1d4aab9-7330-4b4d-9aeb-74ee37ea47c7日语学习计划.docx', '微型计算机开发西安科技大学。', null, '2017-05-23', '2017-05-23', '2017-05-23', '2017-05-30', '该项目具有创新性', '4', '1', null, null, '0', '初审：优', '1');
INSERT INTO `t_project` VALUES ('20170524182337', '校园软件在线协同平台', '456789123@qq.com', '姚鹏飞', '18825478965', 'Java', 'Windows', '23', '23', '22', '董美丽', '1522', 'F:/resource/23/20170524182337/9f7cbb2f-0355-48dd-9981-94d354bf3d43913.docx', 'F:/resource/23/20170524182337/fa11b9f2-4ec1-456e-a372-9f9b1b68bf77日语学习计划.docx', '本项目主要针对在校学生开发的一款项目在线协同开发平台，学生自行管理整个项目的创建，管理，交付等，老师仅仅项目的验收和评价。', null, '2017-05-24', '2017-05-24', '2017-05-24', '2017-05-31', '本项目具有创新性，搭建了老师和学生的桥梁，以及可以培养学生的能力，值得给予优秀。', '4', '1', null, null, '0', '初审：优', '1');

-- ----------------------------
-- 开发语言常量表：Table structure for `t_language`
-- ----------------------------
DROP TABLE IF EXISTS `t_language`;
CREATE TABLE `t_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '语言名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '语言状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_language
-- ----------------------------
INSERT INTO `t_language` VALUES ('21', 'Java', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_language` VALUES ('22', 'C语言', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_language` VALUES ('23', 'C++语言', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_language` VALUES ('24', 'Python', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_language` VALUES ('25', '汇编语言', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_language` VALUES ('26', 'C#', '2017-05-23', '2017-05-23', '1');

-- ----------------------------
-- 开发平台常量表：Table structure for `t_platform`
-- ----------------------------
DROP TABLE IF EXISTS `t_platform`;
CREATE TABLE `t_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '平台名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_platform
-- ----------------------------
INSERT INTO `t_platform` VALUES ('21', 'Windows', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_platform` VALUES ('22', 'Linux', '2017-05-23', '2017-05-23', '1');
INSERT INTO `t_platform` VALUES ('23', 'Unix', '2017-05-23', '2017-05-23', '1');

-- ----------------------------
-- 用户-项目表（不包括负责人）：Table structure for `home`
-- ----------------------------
DROP TABLE IF EXISTS `t_home`;
CREATE TABLE `t_home` (
  `projectId` varchar(100)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '加入项目状态',
  PRIMARY KEY (`projectId`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_home
-- ----------------------------
INSERT INTO `t_home` VALUES ('20170523193658', '456789123@qq.com', '2017-05-24', '2017-05-24', '0');
INSERT INTO `t_home` VALUES ('20170523193658', '789123456@qq.com', '2017-05-25', '2017-05-25', '0');
INSERT INTO `t_home` VALUES ('20170524182337', '123456789@qq.com', '2017-05-24', '2017-05-24', '0');
INSERT INTO `t_home` VALUES ('20170524182337', '789123456@qq.com', '2017-05-24', '2017-05-24', '0');

-- ----------------------------
-- 任务表：Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `projectId` varchar(100)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `name` varchar(50) NOT NULL COMMENT '用户name',
  `startupTime` date NOT NULL COMMENT '开始时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `endTime` date NOT NULL COMMENT '结束时间',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `taskFile` varchar(200)  DEFAULT NULL COMMENT '详细任务文件地址',
  `resultDescription` varchar(200)  DEFAULT NULL COMMENT '成果描述',
  `resultFile` varchar(200)  DEFAULT NULL COMMENT '成果文件地址',
  `resultEvaluation` varchar(500) DEFAULT NULL COMMENT '成果评价',
  `parentTask` int(11) DEFAULT -1 COMMENT '父任务',
  `status` int(10) DEFAULT 0 COMMENT '任务是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('22', '20170523193658', '123456789@qq.com', '邝忠震', '2017-05-24', '2017-05-25', '2017-05-30', '默认任务：本系统默认任务终期成果视屏上传', 'F:/resource/default.txt', '该视屏展示了本系统的基本功能的演示', '/resource/21/20170523193658/task/6ffc5c15-1138-4978-8ad0-68f522ebe9b6indexdefault.mp4', null, -1, 0);
INSERT INTO `t_task` VALUES ('27', '20170523193658', '123456789@qq.com', '邝忠震', '2017-05-23', '2017-05-25', '2017-05-24', '未启动却无法阿萨德撒大所啊实打实多', 'F:/resource/21/20170523193658/task/5f49322c-3518-4ad1-8c58-e2a989bb2300郝永升毕业论文.docx', '任务已完成，有一些bug有待解决，如果有什么问题可以在以任务的形式反馈给我。', 'F:/resource/21/20170523193658/task/23e3ccae-480b-4049-a7ef-184a2d7bc0d6郝永升毕业论文.docx', null, -1, 0);
INSERT INTO `t_task` VALUES ('28', '20170523193658', '456789123@qq.com', '姚鹏飞', '2017-05-23', '2017-05-25', '2017-05-24', '负责页面的设计，和后台人员交流实现页面的讲解，以及在截止时间上交本项目所有设计页面的初稿。', 'F:/resource/21/20170523193658/task/d276888f-2366-4a94-a00d-004dd3c56339论文章节.docx', null, null, null, 27, 0);
INSERT INTO `t_task` VALUES ('29', '20170524182337', '456789123@qq.com', '姚鹏飞', '2017-05-24', '2017-05-24', '2017-05-31', '默认任务：本系统默认任务终期成果视屏上传', 'F:/resource/default.txt', null, '/resource/default.mp4', null, -1,0);
INSERT INTO `t_task` VALUES ('30', '20170524182337', '456789123@qq.com', '姚鹏飞', '2017-05-24', '2017-05-24', '2017-05-25', '设计阶段，数据字典，页面成果。', 'F:/resource/23/20170524182337/task/b228ce68-2aad-426c-8dda-0929178a7d26913.docx', null, null, null, -1,0);
INSERT INTO `t_task` VALUES ('31', '20170524182337', '123456789@qq.com', '邝忠震', '2017-05-24', '2017-05-25', '2017-05-25', '实现算法的实现，基于高数基础扎实，算法的核心思想以文档的形式上传', 'F:/resource/23/20170524182337/task/52a7c169-fa91-4e4c-8476-805819dc1e76郝永升毕业论文.docx', null, null, null, 30, 0);
INSERT INTO `t_task` VALUES ('32', '20170524182337', '789123456@qq.com', '王朝', '2017-05-24', '2017-05-25', '2017-05-25', '代码的实现实现登陆注册功能，任务文件中已经给予了你所需的所有页面', 'F:/resource/23/20170524182337/task/02640be6-5aa5-44fd-8280-da00be4ec6c3日语学习计划.docx', null, null, null, 30, 0);

-- ----------------------------
-- 数据库备份表：Table structure for `t_dbbackup`
-- ----------------------------
DROP TABLE IF EXISTS `t_dbbackup`;
CREATE TABLE `t_dbbackup` (
  `id` varchar(100) NOT NULL  COMMENT '主键',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `creatTimeStr` varchar(20) DEFAULT NULL COMMENT '建创时间',
  `backuppath` varchar(100) NOT NULL COMMENT '数据库备份地址',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_dbbackup
-- ----------------------------
INSERT INTO `t_dbbackup` VALUES ('20170523191402', '2017-05-23', '2017-05-23 19:14:02', 'F:/resource/db/20170523191402.sql');
INSERT INTO `t_dbbackup` VALUES ('20170523193105', '2017-05-23', '2017-05-23 19:31:05', 'F:/resource/db/20170523193105.sql');
INSERT INTO `t_dbbackup` VALUES ('20170524122651', '2017-05-24', '2017-05-24 12:26:51', 'F:/resource/db/20170524122651.sql');
INSERT INTO `t_dbbackup` VALUES ('20170524184400', '2017-05-24', '2017-05-24 18:44:00', 'F:/resource/db/20170524184400.sql');
INSERT INTO `t_dbbackup` VALUES ('20170525003410', '2017-05-25', '2017-05-25 00:34:10', 'F:/resource/db/20170525003410.sql');
INSERT INTO `t_dbbackup` VALUES ('20170525033428', '2017-05-25', '2017-05-25 03:34:28', 'F:/resource/db/20170525033428.sql');
INSERT INTO `t_dbbackup` VALUES ('20170525161516', '2017-05-25', '2017-05-25 16:15:16', 'F:/resource/db/20170525161516.sql');
INSERT INTO `t_dbbackup` VALUES ('20170525162319', '2017-05-25', '2017-05-25 16:23:19', 'F:/resource/db/20170525162319.sql');
INSERT INTO `t_dbbackup` VALUES ('20170526012923', '2017-05-26', '2017-05-26 01:29:23', 'F:/resource/db/20170526012923.sql');