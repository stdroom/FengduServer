/*
Navicat MySQL Data Transfer

Source Server         : mike
Source Server Version : 50546
Source Host           : 115.28.224.54:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-11-25 14:25:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Article`
-- ----------------------------
DROP TABLE IF EXISTS `Article`;
CREATE TABLE `Article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `contxtPath` varchar(255) DEFAULT NULL,
  `contextHtml` varchar(100) DEFAULT NULL,
  `cata_id` int(11) NOT NULL,
  `fromUrl` text,
  `pageNum` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updateed_at` datetime DEFAULT NULL,
  `imgPath` text,
  `author` text,
  `contextSummary` text,
  `tags` text,
  `t1` text,
  `t2` text,
  `v1` varchar(255) DEFAULT NULL,
  `v2` varchar(255) DEFAULT NULL,
  `i1` int(11) DEFAULT NULL,
  `i2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Article
-- ----------------------------
