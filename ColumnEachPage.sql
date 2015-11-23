/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-23 09:52:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ColumnEachPage`
-- ----------------------------
DROP TABLE IF EXISTS `ColumnEachPage`;
CREATE TABLE `ColumnEachPage` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `baseUrl` varchar(100) DEFAULT NULL,
  `indexUrl` varchar(100) DEFAULT NULL,
  `hasNext` tinyint(4) DEFAULT NULL,
  `totalNum` int(11) DEFAULT NULL,
  `currentNum` int(11) DEFAULT NULL,
  `currentPageUrl` varchar(100) DEFAULT NULL,
  `isParseError` tinyint(4) DEFAULT NULL,
  `exception` text,
  `type` tinyint(4) NOT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ColumnEachPage
-- ----------------------------
INSERT INTO `ColumnEachPage` VALUES ('1101', 'http://www.uumnt.com/', 'http://www.uumnt.com/sheji/', '1', null, '0', null, '0', null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1103', 'http://www.uumnt.com/', 'http://www.uumnt.com/siwa/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1104', 'http://www.uumnt.com/', 'http://www.uumnt.com/xinggan/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1105', 'http://www.uumnt.com/', 'http://www.uumnt.com/rihan/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1106', 'http://www.uumnt.com/', 'http://www.uumnt.com/chemo/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1107', 'http://www.uumnt.com/', 'http://www.uumnt.com/qingchun/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1108', 'http://www.uumnt.com/', 'http://www.uumnt.com/zipai/', null, null, null, null, null, null, '0');
INSERT INTO `ColumnEachPage` VALUES ('1109', 'http://www.uumnt.com/', 'http://www.uumnt.com/rhmn/', '1', null, '0', '', '0', '', '0');
INSERT INTO `ColumnEachPage` VALUES ('1110', 'http://www.uumnt.com/', 'http://www.uumnt.com/swmt/', '1', null, '0', '', '0', '', '0');
