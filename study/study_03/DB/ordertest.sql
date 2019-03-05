/*
Navicat MySQL Data Transfer

Source Server         : 本机MySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2019-03-05 16:40:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ordertest
-- ----------------------------
DROP TABLE IF EXISTS `ordertest`;
CREATE TABLE `ordertest` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '序号',
  `orderNo` varchar(50) default NULL COMMENT '订单号',
  `orderName` varchar(50) default NULL COMMENT '商品名称',
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordertest
-- ----------------------------
INSERT INTO `ordertest` VALUES ('1', '2019012717243025001', '测试产品1', '测试产品测试数据1');
INSERT INTO `ordertest` VALUES ('2', '2019012717243025002', '测试产品2', '测试产品测试数据2');
INSERT INTO `ordertest` VALUES ('3', '2019012717243025003', '测试产品3', '测试产品测试数据3');
INSERT INTO `ordertest` VALUES ('4', '2019012717243025004', '测试产品4', '测试产品测试数据4');
INSERT INTO `ordertest` VALUES ('5', '2019012717243025005', '测试产品5', '测试产品测试数据5');
