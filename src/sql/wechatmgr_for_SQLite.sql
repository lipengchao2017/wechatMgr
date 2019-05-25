/*
 Navicat Premium Data Transfer

 Source Server         : wechatMgr
 Source Server Type    : SQLite
 Source Server Version : 3012001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3012001
 File Encoding         : 65001

 Date: 26/05/2019 00:54:35
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for WECHAT_BASE_T_GROUP
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_GROUP";
CREATE TABLE `WECHAT_BASE_T_GROUP` (
  `GROUPID` varchar(255) PRIMARY KEY NOT NULL,
  `GROUPCODE` varchar(255) DEFAULT NULL ,
  `GROUPNAME` varchar(255) DEFAULT NULL ,
  `CREATOR` varchar(100) DEFAULT NULL ,
  `CREATORID` varchar(100) DEFAULT NULL,
  `UPDATOR` varchar(100) DEFAULT NULL ,
  `UPDATORID` varchar(100) DEFAULT NULL ,
  `CREATETIME` datetime DEFAULT NULL ,
  `UPDATETIME` datetime DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_ROLE
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_ROLE";
CREATE TABLE `WECHAT_BASE_T_ROLE` (
  `ID` varchar(255) PRIMARY KEY NOT NULL ,
  `ROLECODE` varchar(100) DEFAULT NULL ,
  `ROLENAME` varchar(100) DEFAULT NULL ,
  `CREATOR` varchar(100) DEFAULT NULL ,
  `CREATORID` varchar(100) DEFAULT NULL ,
  `UPDATOR` varchar(100) DEFAULT NULL ,
  `UPDATORID` varchar(100) DEFAULT NULL ,
  `CREATETIME` datetime DEFAULT NULL ,
  `UPDATETIME` datetime DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USER
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USER";
CREATE TABLE `WECHAT_BASE_T_USER` (
  `USERID` varchar(255) PRIMARY KEY NOT NULL ,
  `USERCODE` varchar(255) DEFAULT NULL ,
  `USERNAME` varchar(255) DEFAULT NULL ,
  `CREATOR` varchar(100) DEFAULT NULL ,
  `CREATORID` varchar(100) DEFAULT NULL ,
  `UPDATOR` varchar(100) DEFAULT NULL ,
  `UPDATORID` varchar(100) DEFAULT NULL ,
  `CREATETIME` datetime DEFAULT NULL ,
  `UPDATETIME` datetime DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERGROUP
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USERGROUP";
CREATE TABLE `WECHAT_BASE_T_USERGROUP` (
  `USERCODE` varchar(255) DEFAULT NULL ,
  `GROUPCODE` varchar(255) DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERLOG
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USERLOG";
CREATE TABLE `WECHAT_BASE_T_USERLOG` (
  `ID` varchar(255) PRIMARY KEY NOT NULL ,
  `IP` varchar(100) DEFAULT NULL ,
  `TIME` datetime DEFAULT NULL ,
  `TYPE` varchar(50) DEFAULT NULL ,
  `LEVEL` int(11) DEFAULT NULL ,
  `USERCODE` varchar(255) DEFAULT NULL ,
  `OPINFO` varchar(4000) DEFAULT NULL ,
  `ISSUCCESS` int(11) DEFAULT NULL ,
  `OPNAME` varchar(255) DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERPRPT
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USERPRPT";
CREATE TABLE `WECHAT_BASE_T_USERPRPT` (
  `ID` varchar(255) PRIMARY KEY NOT NULL,
  `USERCODE` varchar(255) DEFAULT NULL ,
  `PROPERTY` varchar(255) DEFAULT NULL ,
  `CREATOR` varchar(100) DEFAULT NULL ,
  `CREATORID` varchar(100) DEFAULT NULL ,
  `UPDATOR` varchar(100) DEFAULT NULL ,
  `UPDATORID` varchar(100) DEFAULT NULL ,
  `CREATETIME` datetime DEFAULT NULL ,
  `UPDATETIME` datetime DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERPWD
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USERPWD";
CREATE TABLE `WECHAT_BASE_T_USERPWD` (
  `ID` varchar(255) PRIMARY KEY NOT NULL,
  `USERCODE` varchar(255) DEFAULT NULL ,
  `USERPWD` varchar(255) DEFAULT NULL ,
  `ISINITPWD` int(11) DEFAULT NULL ,
  `ISEFFECTIVE` int(11) DEFAULT NULL ,
  `LOCKTYPE` int(11) DEFAULT NULL ,
  `ERRORCOUNT` int(11) DEFAULT NULL ,
  `LOCKTIME` datetime DEFAULT NULL ,
  `CREATOR` varchar(100) DEFAULT NULL ,
  `CREATORID` varchar(100) DEFAULT NULL ,
  `UPDATOR` varchar(100) DEFAULT NULL ,
  `UPDATORID` varchar(100) DEFAULT NULL ,
  `CREATETIME` datetime DEFAULT NULL ,
  `UPDATETIME` datetime DEFAULT NULL 
);

-- ----------------------------
-- Table structure for WECHAT_BASE_T_USERROLE
-- ----------------------------
DROP TABLE IF EXISTS "WECHAT_BASE_T_USERROLE";
CREATE TABLE `WECHAT_BASE_T_USERROLE` (
  `USERCODE` varchar(255) DEFAULT NULL ,
  `ROLECODE` varchar(255) DEFAULT NULL 
);

PRAGMA foreign_keys = true;
