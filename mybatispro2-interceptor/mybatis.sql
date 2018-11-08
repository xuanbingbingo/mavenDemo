/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2018-04-27 13:34:11
*/
CREATE DATABASE IF NOT EXISTS `mybatis`  DEFAULT CHARACTER SET utf8;
use mybatis;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) DEFAULT NULL,
  `deptNo` varchar(255) DEFAULT NULL,
  `deptName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('2', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('3', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('4', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('5', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('6', 'tom', 'tom@imooc.com', 'F', null);
INSERT INTO `person` VALUES ('7', 'tom', 'tom@imooc.com', 'F', null);



-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('2', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('3', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('4', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('5', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('6', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('7', 'jerry', 'bj');
INSERT INTO `t_user` VALUES ('8', 'jerry', 'bj');
