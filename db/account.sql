/*
Navicat MySQL Data Transfer

Source Server         : mysqllocal
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : account

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2014-04-01 11:48:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `c3p0test`
-- ----------------------------
DROP TABLE IF EXISTS `c3p0test`;
CREATE TABLE `c3p0test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c3p0test
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_t`;
CREATE TABLE `sys_menu_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `p_id` int(11) DEFAULT NULL,
  `lft` int(11) NOT NULL,
  `rgt` int(11) NOT NULL,
  `is_parent` tinyint(4) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `menu_desc` varchar(255) DEFAULT NULL,
  `menu_type` varchar(10) NOT NULL DEFAULT 'menu' COMMENT '菜单的等级类型，按照常规分类可分为，应用，菜单，子功能，按钮等不同等级。不同类型的在不同的区域或者树中展示，可以自由配置。默认为menu，为菜单。',
  `Weight` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_name` (`name`) USING BTREE,
  KEY `menu_p_id` (`p_id`),
  KEY `menu_lft` (`lft`),
  KEY `menu_right` (`rgt`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_t
-- ----------------------------
INSERT INTO `sys_menu_t` VALUES ('1', '首页', '0', '1', '2', '0', '', 'bb', 'menu', '100');
INSERT INTO `sys_menu_t` VALUES ('2', '权限管理', '0', '3', '12', '1', '', 'bbb', 'menu', '100');
INSERT INTO `sys_menu_t` VALUES ('3', '角色管理', '2', '4', '5', '0', null, null, 'menu', '100');
INSERT INTO `sys_menu_t` VALUES ('4', '用户管理', '2', '6', '7', '0', null, null, 'menu', '100');
INSERT INTO `sys_menu_t` VALUES ('5', '菜单管理', '2', '8', '9', '0', null, null, 'menu', '100');

-- ----------------------------
-- Table structure for `sys_menu_url_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_url_t`;
CREATE TABLE `sys_menu_url_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_name` varchar(255) DEFAULT NULL,
  `menu_id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `channel` varchar(10) DEFAULT NULL COMMENT '该请求的传输通道，包含http，https，无，any几种。',
  `match_type` varchar(10) DEFAULT 'ant' COMMENT 'url的匹配式的类型，包含ant，regex，ciRegex几种，默认为ant',
  `auth_type` varchar(10) DEFAULT '' COMMENT '需要通过的认证类型，一般来说有几种，一种是通过了REMEMBERED认证，一种是全权限的认证(有输入用名密码认证),第三种是所有人都能够查看，默认值暂时未知。',
  `func_desc` varchar(255) DEFAULT NULL,
  `is_access` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否是 菜单的对应界面的入口',
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `sys_menu_url_t_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu_t` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_url_t
-- ----------------------------
INSERT INTO `sys_menu_url_t` VALUES ('1', '首页', '1', '/index.jsp', null, 'ant', '', null, '1');

-- ----------------------------
-- Table structure for `sys_role_menu_m`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_m`;
CREATE TABLE `sys_role_menu_m` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `is_all` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否包含menu_id对应的菜单的所有子菜单，默认为false。',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu_m
-- ----------------------------
INSERT INTO `sys_role_menu_m` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_role_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_t`;
CREATE TABLE `sys_role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_t
-- ----------------------------
INSERT INTO `sys_role_t` VALUES ('1', '管理员', null);

-- ----------------------------
-- Table structure for `sys_user_login_error_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login_error_t`;
CREATE TABLE `sys_user_login_error_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `error_msg` varchar(255) NOT NULL,
  `error_time` varchar(255) NOT NULL,
  `error_count` int(11) NOT NULL,
  `error_ip` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sys_user_login_error_t_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user_t` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_login_error_t
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_login_ip_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login_ip_t`;
CREATE TABLE `sys_user_login_ip_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `login_ip` varchar(255) NOT NULL,
  `login_count` int(11) NOT NULL DEFAULT '1',
  `logint_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sys_user_login_ip_t_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user_t` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_login_ip_t
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_role_m`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_m`;
CREATE TABLE `sys_user_role_m` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sys_user_role_m_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user_t` (`id`),
  CONSTRAINT `sys_user_role_m_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role_t` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role_m
-- ----------------------------
INSERT INTO `sys_user_role_m` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `sys_user_t`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_t`;
CREATE TABLE `sys_user_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(255) DEFAULT '' COMMENT '真实姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `status` varchar(255) NOT NULL COMMENT '当前账号状态',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(255) DEFAULT NULL COMMENT '注册ip',
  `register_address` varchar(255) DEFAULT NULL COMMENT '注册地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_t
-- ----------------------------
INSERT INTO `sys_user_t` VALUES ('1', 'zhezhiren', '123456', '折枝人', '郑兴', '451179870@qq.com', 'normal', '2014-03-11 09:19:38', '127.0.0.1', '长沙');

-- ----------------------------
-- Procedure structure for `addMenu`
-- ----------------------------
DROP PROCEDURE IF EXISTS `addMenu`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addMenu`(IN v_menuName VARCHAR(255), IN v_pId INT, IN v_isParent TINYINT(2), IN v_icon VARCHAR(255), IN v_menuDesc VARCHAR(255), IN v_menuType VARCHAR(255) ,OUT result INT)
BEGIN
	IF v_pId = 0 OR v_pId = NULL THEN
		SELECT @myRight := MAX(rgt) FROM sys_menu_t;
		INSERT INTO sys_menu_t (id, name, p_id, lft, rgt, is_parent, icon, menu_desc, menu_type) values (null, v_menuName, v_pId, @myRight + 1, @myRight + 2, v_isParent, v_icon , v_menuDesc, v_menuType); 
		SET result = 1;
	ELSE 
		SELECT @myRight := rgt FROM sys_menu_t WHERE id = v_pId; 
		UPDATE sys_menu_t SET rgt = rgt + 2 WHERE rgt >= @myRight; 
		UPDATE sys_menu_t SET lft = lft + 2 WHERE lft > @myRight; 
		INSERT INTO sys_menu_t (id, name, p_id, lft, rgt, is_parent, icon, menu_desc, menu_type) values (null, v_menuName, v_pId, @myRight, @myRight + 1, v_isParent, v_icon , v_menuDesc, v_menuType); 
		SET result = 1;
	END IF;
	END
;;
DELIMITER ;
