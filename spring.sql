/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50717
Source Host           : 192.168.129.15:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-04 17:56:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'class_a', '1');
INSERT INTO `class` VALUES ('2', 'class_b', '2');

-- ----------------------------
-- Table structure for `learn_resource`
-- ----------------------------
DROP TABLE IF EXISTS `learn_resource`;
CREATE TABLE `learn_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '地址链接',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of learn_resource
-- ----------------------------
INSERT INTO `learn_resource` VALUES ('999', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1000', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1001', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1002', '后端编程嘟', 'Spring Boot视频教程', 'http://tengj.top/');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'student_A', '1');
INSERT INTO `student` VALUES ('2', 'student_B', '1');
INSERT INTO `student` VALUES ('3', 'student_C', '1');
INSERT INTO `student` VALUES ('4', 'student_D', '2');
INSERT INTO `student` VALUES ('5', 'student_E', '2');
INSERT INTO `student` VALUES ('6', 'student_F', '2');

-- ----------------------------
-- Table structure for `sysrole`
-- ----------------------------
DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole` (
  `id` int(128) NOT NULL COMMENT '编号',
  `role` varchar(255) NOT NULL COMMENT '角色标识程序中判断使用,如"admin",这个是唯一的:',
  `description` varchar(512) NOT NULL COMMENT '角色描述,UI界面显示使用',
  `available` char(1) NOT NULL COMMENT '是否可用,如果不可用将不会添加给用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysrole
-- ----------------------------
INSERT INTO `sysrole` VALUES ('1', '权限1', '权限1', '1');
INSERT INTO `sysrole` VALUES ('2', '权限2', '权限2', '1');

-- ----------------------------
-- Table structure for `sysuserrole`
-- ----------------------------
DROP TABLE IF EXISTS `sysuserrole`;
CREATE TABLE `sysuserrole` (
  `uid` int(128) NOT NULL,
  `roleId` int(128) NOT NULL,
  `id` int(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysuserrole
-- ----------------------------
INSERT INTO `sysuserrole` VALUES ('1', '2', '1');
INSERT INTO `sysuserrole` VALUES ('2', '1', '3');
INSERT INTO `sysuserrole` VALUES ('2', '2', '4');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uid` int(128) NOT NULL,
  `username` varchar(128) NOT NULL COMMENT '帐号',
  `name` varchar(128) NOT NULL COMMENT '名称（昵称或者真实姓名，不同系统不同定义）',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `salt` varchar(128) NOT NULL COMMENT '加密密码的盐',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'usernam1', '1', '123456', '1');
INSERT INTO `userinfo` VALUES ('2', 'username2', '2', '123455', '1');
