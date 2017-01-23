/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : video

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2016-10-01 19:21:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `v_admin`
-- ----------------------------
DROP TABLE IF EXISTS `v_admin`;
CREATE TABLE `v_admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `login_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_admin
-- ----------------------------
INSERT INTO `v_admin` VALUES ('1', '小胖', 'admin', '123456', null, '2016-05-18 13:57:21');

-- ----------------------------
-- Table structure for `v_direction`
-- ----------------------------
DROP TABLE IF EXISTS `v_direction`;
CREATE TABLE `v_direction` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `direction` varchar(20) DEFAULT NULL,
  `info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_direction
-- ----------------------------
INSERT INTO `v_direction` VALUES ('2', '后端开发', 'java,c++,c');
INSERT INTO `v_direction` VALUES ('3', '数据处理\r\n', 'Mysql，Oraacle');
INSERT INTO `v_direction` VALUES ('4', '移动开发', 'Andriod');
INSERT INTO `v_direction` VALUES ('5', '图像处理', 'imgags');
INSERT INTO `v_direction` VALUES ('6', '算法描述', 'fdfsd');
INSERT INTO `v_direction` VALUES ('7', 'b', 'b');
INSERT INTO `v_direction` VALUES ('8', 'c', 'c');
INSERT INTO `v_direction` VALUES ('9', 'd', 'd');
INSERT INTO `v_direction` VALUES ('10', 'e', 'e');
INSERT INTO `v_direction` VALUES ('11', 'f', 'f');
INSERT INTO `v_direction` VALUES ('12', 'g', 'g');
INSERT INTO `v_direction` VALUES ('13', 'h', 'h');
INSERT INTO `v_direction` VALUES ('14', 'i', 'i');
INSERT INTO `v_direction` VALUES ('15', 'j', 'g');
INSERT INTO `v_direction` VALUES ('16', 'k', 'k');
INSERT INTO `v_direction` VALUES ('17', 'l', 'd');
INSERT INTO `v_direction` VALUES ('18', 'm', 'd');
INSERT INTO `v_direction` VALUES ('19', 'n', 'd');
INSERT INTO `v_direction` VALUES ('20', 'o', 'd');
INSERT INTO `v_direction` VALUES ('21', 'p', 'd');
INSERT INTO `v_direction` VALUES ('22', 'q', 'd');
INSERT INTO `v_direction` VALUES ('23', 'r', 'd');

-- ----------------------------
-- Table structure for `v_kc`
-- ----------------------------
DROP TABLE IF EXISTS `v_kc`;
CREATE TABLE `v_kc` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `v_name` varchar(50) DEFAULT NULL,
  `v_info` varchar(100) DEFAULT NULL,
  `v_head` varchar(100) DEFAULT NULL,
  `t_id` int(4) DEFAULT NULL,
  `dire_id` int(4) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `remove` varchar(4) DEFAULT 'N',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_kc
-- ----------------------------
INSERT INTO `v_kc` VALUES ('6', 'java第一弹', '多线程技术描述', '1462606875280.jpg', '5', '2', '齐林', 'N', '2016-05-07 15:42:31');
INSERT INTO `v_kc` VALUES ('7', 'sdfsd', 'fsdfsdf', '1463206159208.jpg', '4', '5', 'sdfsdfsdf', 'N', '2016-05-14 14:09:20');
INSERT INTO `v_kc` VALUES ('8', 'a1', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:41:56');
INSERT INTO `v_kc` VALUES ('9', 'a2', 'a', '1463211715641.jpg', '4', '6', 'a', 'N', '2016-05-14 15:41:58');
INSERT INTO `v_kc` VALUES ('10', 'a3', 'a', '1463211715641.jpg', '4', '6', 'a', 'N', '2016-05-14 15:41:58');
INSERT INTO `v_kc` VALUES ('11', 'a4', 'a', '1463211715641.jpg', '4', '6', 'a', 'N', '2016-05-14 15:41:58');
INSERT INTO `v_kc` VALUES ('12', 'a5', 'a', '1463211715641.jpg', '4', '6', 'a', 'N', '2016-05-14 15:41:58');
INSERT INTO `v_kc` VALUES ('13', 'a6', 'a', '1463211715641.jpg', '4', '6', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('14', 'a7', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('15', 'a8', 'a', '1463211715641.jpg', '4', '4', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('16', 'a9', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('17', 'a10', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('18', 'a11', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('19', 'a12', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:41:59');
INSERT INTO `v_kc` VALUES ('20', 'a13', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('21', 'a14', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('22', 'a15', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('23', 'a16', 'a', '1463211715641.jpg', '4', '4', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('24', 'a17', 'a', '1463211715641.jpg', '4', '3', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('25', 'a18', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:00');
INSERT INTO `v_kc` VALUES ('26', 'a19', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('27', 'a20', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('28', 'a21', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('29', 'a22', 'a', '1463211715641.jpg', '4', '3', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('30', 'a23', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('31', 'a24', 'a', '1463211715641.jpg', '4', '4', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('32', 'a25', 'a', '1463211715641.jpg', '4', '4', 'a', 'N', '2016-05-14 15:42:01');
INSERT INTO `v_kc` VALUES ('33', 'a26', 'a', '1463211715641.jpg', '4', '3', 'a', 'N', '2016-05-14 15:42:02');
INSERT INTO `v_kc` VALUES ('34', 'a27', 'a', '1463211715641.jpg', '4', '2', 'a', 'N', '2016-05-14 15:42:02');
INSERT INTO `v_kc` VALUES ('35', 'a28', 'a', '1463211715641.jpg', '4', '5', 'a', 'N', '2016-05-14 15:42:02');
INSERT INTO `v_kc` VALUES ('36', 'asfasd', 'fsdfsdf', '1463733896082.jpg', '4', '4', 'sdfsdf', 'N', '2016-05-20 16:44:58');
INSERT INTO `v_kc` VALUES ('37', 'asfasd', 'fsdfsdf', '1463733896082.jpg', '4', '3', 'sdfsdf', 'N', '2016-05-20 16:44:59');
INSERT INTO `v_kc` VALUES ('38', 'asdfasd', 'fasdfasdf', '1463733951804.jpg', '4', '2', 'asdfasdf', 'N', '2016-05-20 16:45:52');

-- ----------------------------
-- Table structure for `v_kc_type`
-- ----------------------------
DROP TABLE IF EXISTS `v_kc_type`;
CREATE TABLE `v_kc_type` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(50) DEFAULT NULL,
  `d_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_kc_type
-- ----------------------------
INSERT INTO `v_kc_type` VALUES ('4', 'PHP', '2');
INSERT INTO `v_kc_type` VALUES ('5', 'JAVA', '2');
INSERT INTO `v_kc_type` VALUES ('6', 'Linux', '2');
INSERT INTO `v_kc_type` VALUES ('7', 'Python', '2');
INSERT INTO `v_kc_type` VALUES ('8', 'Android', '4');
INSERT INTO `v_kc_type` VALUES ('9', 'iOS', '4');
INSERT INTO `v_kc_type` VALUES ('10', 'Unity 3D', '4');
INSERT INTO `v_kc_type` VALUES ('11', 'aaa', '2');
INSERT INTO `v_kc_type` VALUES ('12', 'bbbc', '2');
INSERT INTO `v_kc_type` VALUES ('13', 'cccc', '2');

-- ----------------------------
-- Table structure for `v_user`
-- ----------------------------
DROP TABLE IF EXISTS `v_user`;
CREATE TABLE `v_user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `xl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_user
-- ----------------------------
INSERT INTO `v_user` VALUES ('1', '小明', '女', '20', '大专');
INSERT INTO `v_user` VALUES ('2', '晓红', '女', '21', '本科');
INSERT INTO `v_user` VALUES ('3', '小黑', '男', '30', '博士');

-- ----------------------------
-- Table structure for `v_video`
-- ----------------------------
DROP TABLE IF EXISTS `v_video`;
CREATE TABLE `v_video` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `v_name` varchar(40) DEFAULT NULL,
  `v_url` varchar(40) DEFAULT NULL,
  `v_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_video
-- ----------------------------
INSERT INTO `v_video` VALUES ('1', 'aaaaaaaaaa', '1459494616652.mp4', '6');
INSERT INTO `v_video` VALUES ('2', 'bbbbbbbbbbb', '1459494616681.mp4', '6');
