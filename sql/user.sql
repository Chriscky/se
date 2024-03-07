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
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) default NULL,
  `username` varchar(32) default null,
  `password` varchar(64) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `age` tinyint(3) unsigned DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `avatar` VARCHAR(255) DEFAULT NULL COMMENT '头像url',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `created_at` bigint NOT NULL  ,
  `updated_at` bigint NOT NULL  ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

