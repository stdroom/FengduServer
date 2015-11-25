/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-25 14:26:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Website`
-- ----------------------------
DROP TABLE IF EXISTS `Website`;
CREATE TABLE `Website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web_name` varchar(100) DEFAULT NULL,
  `web_url` varchar(100) DEFAULT NULL,
  `charset` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Website
-- ----------------------------
