/*
Navicat MariaDB Data Transfer

Source Server         : 36
Source Server Version : 100322
Source Host           : 192.168.0.36:3308
Source Database       : db_order

Target Server Type    : MariaDB
Target Server Version : 100322
File Encoding         : 65001

Date: 2020-05-14 13:01:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `commodity_code` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT 0,
  `money` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order_tbl
-- ----------------------------
INSERT INTO `order_tbl` VALUES ('9', '1001', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('10', '1001', '2001', '10', '50');
INSERT INTO `order_tbl` VALUES ('13', '1001', '2001', '20', '100');
INSERT INTO `order_tbl` VALUES ('18', '1001', '2001', '30', '150');
INSERT INTO `order_tbl` VALUES ('19', '1001', '2001', '40', '200');
INSERT INTO `order_tbl` VALUES ('21', '1001', '2001', '20', '100');
INSERT INTO `order_tbl` VALUES ('24', '1001', '2001', '20', '100');
INSERT INTO `order_tbl` VALUES ('28', '1001', '2001', '100', '500');
INSERT INTO `order_tbl` VALUES ('29', '1001', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('30', '1001', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('32', '1002', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('34', '1001', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('36', '1001', '2001', '1', '5');
INSERT INTO `order_tbl` VALUES ('38', '1001', '2001', '1', '5');
