/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-25 14:23:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appcolumn`
-- ----------------------------
DROP TABLE IF EXISTS `appcolumn`;
CREATE TABLE `appcolumn` (
  `appid` int(11) NOT NULL DEFAULT '0',
  `cataid` int(11) DEFAULT NULL,
  `columnid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  `version` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `column_ibfk_2` (`cataid`),
  KEY `column_ibfk_1` (`appid`),
  CONSTRAINT `column_ibfk_1` FOREIGN KEY (`appid`) REFERENCES `app` (`id`),
  CONSTRAINT `column_ibfk_2` FOREIGN KEY (`cataid`) REFERENCES `catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appcolumn
-- ----------------------------
INSERT INTO `appcolumn` VALUES ('102601', '1101', '1', '设计', '1001', null, null);
INSERT INTO `appcolumn` VALUES ('102601', '1103', '1', '设计', '1002', null, null);
