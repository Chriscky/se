/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : everlasting

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2023-05-04 15:37:54
*/
USE `intelligence`;

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` tinytext default NULL comment '标题',
  `detail_url` varchar(255) NOT NULL comment '详情连接',
  `time` bigint NOT NULL comment '时间',
  `content` MEDIUMTEXT NOT NULL comment '内容',
  `source` varchar(255) DEFAULT NULL comment '来源',
  `type` varchar(32) NOT NULL comment '类别',
  `intro` text DEFAULT NULL comment '简介',
  `enable` tinyint(1) NOT NULL DEFAULT '1' comment '是否启用',
  `created_at` bigint NOT NULL comment '创建时间',
  `updated_at` bigint NOT NULL comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

