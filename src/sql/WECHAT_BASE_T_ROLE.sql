/*
 Navicat Premium Data Transfer

 Source Server         : wechatMgr_mysql
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : 192.168.1.106:3306
 Source Schema         : wechatmgr

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 24/05/2019 23:51:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_ROLE`;
CREATE TABLE `WECHAT_BASE_T_ROLE` (
  `ID` varchar(255) CHARACTER SET latin1 NOT NULL COMMENT 'uuid主键',
  `ROLEID` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '角色编号',
  `ROLENAME` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '角色名称',
  `CREATOR` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
