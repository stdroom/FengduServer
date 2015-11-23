/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-23 10:01:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Catalog`
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `cata_name` varchar(100) DEFAULT NULL,
  `cata_dir` varchar(100) DEFAULT NULL,
  `web_id` int(11) NOT NULL DEFAULT '0',
  `cata_type` tinyint(4) DEFAULT NULL COMMENT '1=>文章，2=>图集',
  `updcata_id` int(11) DEFAULT NULL,
  `is_leaf` tinyint(4) DEFAULT NULL,
  `cata_baseurl` varchar(100) DEFAULT NULL,
  `v1` varchar(255) DEFAULT NULL,
  `v2` varchar(255) DEFAULT NULL,
  `i1` int(11) DEFAULT NULL,
  `i2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Catalog
-- ----------------------------
