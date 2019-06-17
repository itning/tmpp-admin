SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_resource
-- ----------------------------
DROP TABLE IF EXISTS `admin_resource`;
CREATE TABLE `admin_resource`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源ID',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'URL',
  `method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_resource
-- ----------------------------
INSERT INTO `admin_resource` VALUES ('2a5dbed01de34d3689917f88167f4f7f', '/discount', 'DELETE', '2019-06-17 09:48:16', '2019-06-17 09:48:16');
INSERT INTO `admin_resource` VALUES ('a', '/discount', 'POST', '2019-06-17 15:16:32', '2019-06-17 09:38:37');
INSERT INTO `admin_resource` VALUES ('e6353bb45e5f4a0aa932ec6a4f159774', '/discounts', 'GET', '2019-06-17 07:31:00', '2019-06-17 09:38:41');

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_type`(`type`) USING BTREE,
  CONSTRAINT `fk_type` FOREIGN KEY (`type`) REFERENCES `admin_user_role` (`type`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('08ce7c6f2c604a7ea5ee43ddd8f2174f', '教师A', '144', '', 'T', '2019-06-17 10:23:33', '2019-06-17 10:23:33');
INSERT INTO `admin_user` VALUES ('90b4f557101e4256a9bd9d6cd8052fe5', '办公室', 'asd', '', 'O', '2019-06-17 10:23:53', '2019-06-17 10:23:53');
INSERT INTO `admin_user` VALUES ('c687bf7728be41eeab36c79dcae67881', '管理员', 'admin', 'admin', 'ADMIN', '2019-06-17 06:43:07', '2019-06-17 06:43:07');
INSERT INTO `admin_user` VALUES ('d980ebbe57e8498d9a050f797a6aa803', '舒露', '14008', '', 'A', '2019-06-17 10:23:19', '2019-06-17 10:23:19');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` int(11) NOT NULL COMMENT '用户类型ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户类型名',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_type`(`type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色表\r\nT 教师  A 教务处  O 办公室主任' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (1, '管理员', '2019-06-17 11:45:03', '2019-06-17 11:45:05', 'ADMIN');
INSERT INTO `admin_user_role` VALUES (2, '教师', '2019-06-17 11:45:54', '2019-06-17 11:45:56', 'T');
INSERT INTO `admin_user_role` VALUES (3, '教务处', '2019-06-17 11:46:09', '2019-06-17 11:46:12', 'A');
INSERT INTO `admin_user_role` VALUES (4, '办公室主任', '2019-06-17 11:46:29', '2019-06-17 11:46:32', 'O');

-- ----------------------------
-- Table structure for admin_user_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role_resource`;
CREATE TABLE `admin_user_role_resource`  (
  `user_role_id` int(11) NOT NULL,
  `resource_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`user_role_id`, `resource_id`) USING BTREE,
  INDEX `fk_resource`(`resource_id`) USING BTREE,
  CONSTRAINT `fk_resource` FOREIGN KEY (`resource_id`) REFERENCES `admin_resource` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_role_id`) REFERENCES `admin_user_role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role_resource
-- ----------------------------
INSERT INTO `admin_user_role_resource` VALUES (3, '2a5dbed01de34d3689917f88167f4f7f', '2019-06-17 09:48:16', '2019-06-17 09:48:16');
INSERT INTO `admin_user_role_resource` VALUES (3, 'e6353bb45e5f4a0aa932ec6a4f159774', '2019-06-17 16:24:10', '2019-06-17 16:24:12');
INSERT INTO `admin_user_role_resource` VALUES (4, 'a', '2019-06-17 09:27:27', '2019-06-17 09:27:27');
