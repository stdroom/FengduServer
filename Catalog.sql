/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-25 14:24:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `catalog`
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `cata_dir` varchar(100) DEFAULT NULL,
  `web_id` int(11) NOT NULL DEFAULT '0',
  `cata_type` tinyint(4) DEFAULT NULL COMMENT '1=>文章，2=>图集',
  `updcata_id` int(11) DEFAULT NULL,
  `is_leaf` tinyint(1) DEFAULT NULL,
  `cata_baseurl` varchar(100) DEFAULT NULL,
  `v1` varchar(255) DEFAULT NULL,
  `v2` varchar(255) DEFAULT NULL,
  `i1` int(11) DEFAULT NULL,
  `i2` int(11) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1101', '设计', null, '0', null, null, null, 'http://www.uumnt.com/sheji/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1103', '丝袜', null, '0', null, null, null, 'http://www.uumnt.com/siwa/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1104', '性感', null, '0', null, null, null, 'http://www.uumnt.com/xinggan/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1105', '日韩', null, '0', null, null, null, 'http://www.uumnt.com/rihan/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1106', '车模', null, '0', null, null, null, 'http://www.uumnt.com/chemo/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1107', '清纯', null, '0', null, null, null, 'http://www.uumnt.com/qingchun/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1108', '自拍', null, '0', null, null, null, 'http://www.uumnt.com/zipai/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1109', '日韩美女', null, '0', null, null, null, 'http://www.uumnt.com/rhmn/', null, null, null, null, '1', '0');
INSERT INTO `catalog` VALUES ('1110', '丝袜美腿', null, '0', null, null, null, 'http://www.uumnt.com/swmt/', null, null, null, null, '1', '0');
