/*
Navicat MySQL Data Transfer

Source Server         : 本机MySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2019-03-07 17:36:25
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordertest
-- ----------------------------
INSERT INTO `ordertest` VALUES ('1', '2019012717243025001', '测试产品1', '测试产品测试数据1');
INSERT INTO `ordertest` VALUES ('2', '2019012717243025002', '测试产品2', '测试产品测试数据2');
INSERT INTO `ordertest` VALUES ('3', '2019012717243025003', '测试产品3', '测试产品测试数据3');
INSERT INTO `ordertest` VALUES ('4', '2019012717243025004', '测试产品4', '测试产品测试数据4');
INSERT INTO `ordertest` VALUES ('5', '2019012717243025005', '测试产品5', '测试产品测试数据5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `age` int(11) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '25', 'Mr.薛');
INSERT INTO `user` VALUES ('2', '26', 'scott');
INSERT INTO `user` VALUES ('4', '25', '祁同伟');
INSERT INTO `user` VALUES ('5', '25', '李达康');
INSERT INTO `user` VALUES ('6', '25', '天地壹号');
INSERT INTO `user` VALUES ('7', '25', '天地壹号');
INSERT INTO `user` VALUES ('8', '23', '天地壹号');
INSERT INTO `user` VALUES ('9', '12', '天地壹号');
INSERT INTO `user` VALUES ('10', '23', '天地壹号');
INSERT INTO `user` VALUES ('11', '23', '天地壹号');
INSERT INTO `user` VALUES ('12', '34', '天地壹号');
INSERT INTO `user` VALUES ('13', '23', '天地壹号');
INSERT INTO `user` VALUES ('14', '32', '天地壹号');
INSERT INTO `user` VALUES ('15', '23', '天地壹号');
INSERT INTO `user` VALUES ('16', '34', '天地壹号');
INSERT INTO `user` VALUES ('17', '12', '天地壹号');
INSERT INTO `user` VALUES ('18', '12', '天地壹号');
INSERT INTO `user` VALUES ('19', '24', '天地壹号');
INSERT INTO `user` VALUES ('20', '24', '天地壹号');
INSERT INTO `user` VALUES ('21', '24', '天地壹号');
INSERT INTO `user` VALUES ('22', '25', '天地壹号');
INSERT INTO `user` VALUES ('23', '26', '天地壹号');
INSERT INTO `user` VALUES ('24', '35', '天地壹号');
INSERT INTO `user` VALUES ('25', '24', '天地壹号');
INSERT INTO `user` VALUES ('26', '34', '天地壹号');
INSERT INTO `user` VALUES ('27', '25', '天地壹号');
INSERT INTO `user` VALUES ('28', '25', '天地壹号');
INSERT INTO `user` VALUES ('29', '26', '天地壹号');
INSERT INTO `user` VALUES ('30', '35', '天地壹号');
INSERT INTO `user` VALUES ('31', '36', '天地壹号');
INSERT INTO `user` VALUES ('32', '35', '天地壹号');
INSERT INTO `user` VALUES ('33', '58', '天地壹号');
