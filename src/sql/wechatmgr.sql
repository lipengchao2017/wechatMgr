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

 Date: 25/05/2019 22:31:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_GROUP
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_GROUP`;
CREATE TABLE `WECHAT_BASE_T_GROUP` (
  `GROUPID` varchar(255) NOT NULL COMMENT '用户组编号',
  `GROUPCODE` varchar(255) DEFAULT NULL COMMENT '用户组标识',
  `GROUPNAME` varchar(255) DEFAULT NULL COMMENT '用户组名称',
  `CREATOR` varchar(100) DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`GROUPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_ROLE`;
CREATE TABLE `WECHAT_BASE_T_ROLE` (
  `ID` varchar(255) CHARACTER SET latin1 NOT NULL COMMENT 'uuid主键',
  `ROLECODE` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '角色编号',
  `ROLENAME` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '角色名称',
  `CREATOR` varchar(100) DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USER
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_USER`;
CREATE TABLE `WECHAT_BASE_T_USER` (
  `USERID` varchar(255) NOT NULL COMMENT '用户编号',
  `USERCODE` varchar(255) DEFAULT NULL COMMENT '用户标识',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `CREATOR` varchar(100) DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`USERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERGROUP
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_USERGROUP`;
CREATE TABLE `WECHAT_BASE_T_USERGROUP` (
  `USERCODE` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `GROUPCODE` varchar(255) DEFAULT NULL COMMENT '用户组编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERPRPT
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_USERPRPT`;
CREATE TABLE `WECHAT_BASE_T_USERPRPT` (
  `ID` varchar(255) NOT NULL,
  `USERCODE` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `PROPERTY` varchar(255) DEFAULT NULL COMMENT '用户属性',
  `CREATOR` varchar(100) DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERPWD
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_USERPWD`;
CREATE TABLE `WECHAT_BASE_T_USERPWD` (
  `ID` varchar(255) NOT NULL,
  `USERCODE` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `USERPWD` varchar(255) DEFAULT NULL COMMENT '用户密码（加密）',
  `ISINITPWD` int(11) DEFAULT NULL COMMENT '是否初始密码',
  `ISEFFECTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
  `LOCKTYPE` int(11) DEFAULT NULL COMMENT '锁定类型',
  `ERRORCOUNT` int(11) DEFAULT NULL COMMENT '错误次数',
  `LOCKTIME` datetime DEFAULT NULL COMMENT '锁定时间',
  `CREATOR` varchar(100) DEFAULT NULL COMMENT '创建者',
  `CREATORID` varchar(100) DEFAULT NULL COMMENT '创建者编号',
  `UPDATOR` varchar(100) DEFAULT NULL COMMENT '修改者',
  `UPDATORID` varchar(100) DEFAULT NULL COMMENT '修改者编号',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERROLE
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_BASE_T_USERROLE`;
CREATE TABLE `WECHAT_BASE_T_USERROLE` (
  `USERCODE` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `ROLECODE` varchar(255) DEFAULT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
