/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : whlglease

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 31/10/2017 21:03:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PM_FixType
-- ----------------------------
DROP TABLE IF EXISTS `PM_FixType`;
CREATE TABLE `PM_FixType`  (
  `FixParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修参数编号',
  `FixParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '维修类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型名称',
  `IsDelete` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`FixParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_FixType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_FixType
-- ----------------------------
INSERT INTO `PM_FixType` VALUES (1, '门窗损坏', 20, '维修内容', 0);

-- ----------------------------
-- Table structure for PM_HouseType
-- ----------------------------
DROP TABLE IF EXISTS `PM_HouseType`;
CREATE TABLE `PM_HouseType`  (
  `HouseParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '住房参数编号',
  `HouseParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住房参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数类型名称',
  `HouseParamRel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住房登记关系',
  `IsDelete` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`HouseParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_HouseType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '住房参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_HouseType
-- ----------------------------
INSERT INTO `PM_HouseType` VALUES (1, '全额集资房', 1, '住房类型', '空闲,购买', 0);
INSERT INTO `PM_HouseType` VALUES (2, '成本价房', 1, '住房类型', '购买', 0);
INSERT INTO `PM_HouseType` VALUES (4, '私房', 1, '住房类型', '私有', 0);
INSERT INTO `PM_HouseType` VALUES (5, '公租周转房', 1, '住房类型', '空闲,租赁', 0);
INSERT INTO `PM_HouseType` VALUES (6, '周转房', 1, '住房类型', '空闲,租赁,公房', 0);
INSERT INTO `PM_HouseType` VALUES (7, '房改房', 1, '住房类型', '购买', 0);
INSERT INTO `PM_HouseType` VALUES (8, '修改测试', 2, '户型', NULL, 1);
INSERT INTO `PM_HouseType` VALUES (9, '单间', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (10, '一室一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (11, '两室一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (12, '小三间', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (13, '两室两厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (14, '三室一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (15, '三室两厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (16, '四室一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (17, '四室两厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (18, '套间', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (19, '两室', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (20, '两室半一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (21, '三室半一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (22, '一室半一厅', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (23, '三室', 2, '户型', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (24, '空闲', 3, '使用状态', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (25, '租赁', 3, '使用状态', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (26, '购买', 3, '使用状态', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (27, '私有', 3, '使用状态', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (28, '公房', 3, '使用状态', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (29, '钢混', 4, '住房结构', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (30, '混合', 4, '住房结构', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (31, '砖木', 4, '住房结构', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (32, '砖混', 4, '住房结构', NULL, 0);
INSERT INTO `PM_HouseType` VALUES (33, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (34, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (35, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (36, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (37, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (38, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (39, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (40, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (41, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (42, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (43, '测试房1', 1, '住房类型', NULL, NULL);
INSERT INTO `PM_HouseType` VALUES (44, '测试房1', 1, '住房类型', NULL, NULL);

-- ----------------------------
-- Table structure for PM_ParamClass
-- ----------------------------
DROP TABLE IF EXISTS `PM_ParamClass`;
CREATE TABLE `PM_ParamClass`  (
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型名',
  `ParamTypeIName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数渲染用名',
  `ParamClassId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别编号',
  `ParamClassName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别名',
  PRIMARY KEY (`ParamTypeId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  INDEX `ParamTypeId_2`(`ParamTypeId`) USING BTREE,
  INDEX `ParamTypeId_3`(`ParamTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数类型编号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_ParamClass
-- ----------------------------
INSERT INTO `PM_ParamClass` VALUES (0, '系统设置', 'sysSet', '0', '系统参数');
INSERT INTO `PM_ParamClass` VALUES (1, '住房类型', 'houseType', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (2, '户型', 'houseLayout', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (3, '使用状态', 'houseStatus', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (4, '住房结构', 'houseStruct', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (5, '工作部门', 'staffDept', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (6, '职务', 'staffPost', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (7, '职称', 'staffTitle', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (8, '职工类别', 'staffClass', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (9, '工作状态', 'staffStatus', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (10, '配偶单位性质', 'staffSpouse', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (11, '职务分', 'rentPostVal', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (12, '职称分', 'rentTitleVal', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (13, '职务面积', 'rentPostArea', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (14, '职称面积', 'rentTitleArea', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (15, '是否开启选房', 'rentIsOpenSel', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (16, '选房开始时间', 'rentTimeBegin', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (17, '选房时间', 'rentTimeRanges', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (18, '选房所需积分', 'rentSelValReq', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (19, '选房规则', 'rentSelRules', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (20, '维修内容', 'fixContent', '4', '维修参数');
INSERT INTO `PM_ParamClass` VALUES (21, '新老职工时间分界点', 'rentalStaffTimeDiv', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (22, '老职工优惠比例', 'rentalOldDct', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (23, '新职工优惠年限', 'rentalNewDctYear', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (24, '新职工优惠比例', 'rentalNewDct', '5', '租金参数');

-- ----------------------------
-- Table structure for PM_RentType
-- ----------------------------
DROP TABLE IF EXISTS `PM_RentType`;
CREATE TABLE `PM_RentType`  (
  `RentParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租赁参数编号',
  `RentParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租赁参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租赁类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租赁类型名称',
  `IsDelete` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`RentParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_RentType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租赁参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_RentType
-- ----------------------------
INSERT INTO `PM_RentType` VALUES (1, '是', 15, '是否开启选房', 0);
INSERT INTO `PM_RentType` VALUES (2, '2017-03-02 18:36:00.000', 16, '选房开始时间', 0);
INSERT INTO `PM_RentType` VALUES (3, '20', 17, '选房时间', 0);
INSERT INTO `PM_RentType` VALUES (4, '0', 18, '选房所需积分', 0);
INSERT INTO `PM_RentType` VALUES (5, '选房规则', 19, '选房规则', 0);

-- ----------------------------
-- Table structure for PM_RentalType
-- ----------------------------
DROP TABLE IF EXISTS `PM_RentalType`;
CREATE TABLE `PM_RentalType`  (
  `RentalParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租金参数编号',
  `RentalParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租金参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租金类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租金类型名称',
  `IsDelete` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`RentalParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_RentPayType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租金参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_RentalType
-- ----------------------------
INSERT INTO `PM_RentalType` VALUES (1, '1993-09-01 00:00:00.000', 21, '新老职工时间分界点', 0);
INSERT INTO `PM_RentalType` VALUES (2, '0.2', 22, '老职工优惠比例', 0);
INSERT INTO `PM_RentalType` VALUES (3, '3', 23, '新职工优惠年限', 0);
INSERT INTO `PM_RentalType` VALUES (4, '0.2', 24, '新职工优惠比例', 0);

-- ----------------------------
-- Table structure for PM_StaffType
-- ----------------------------
DROP TABLE IF EXISTS `PM_StaffType`;
CREATE TABLE `PM_StaffType`  (
  `StaffParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工参数编号',
  `StaffParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '员工类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工类型名称',
  `StaffParamVal` int(11) NULL DEFAULT NULL COMMENT '分数',
  `StaffParamSpouseVal` int(11) NULL DEFAULT NULL COMMENT '配偶分数',
  `StaffParamHouseArea` float(11, 0) NULL DEFAULT NULL COMMENT '享受面积',
  `IsDelete` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`StaffParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_StaffType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 186 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_StaffType
-- ----------------------------
INSERT INTO `PM_StaffType` VALUES (47, '硅酸盐中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (48, '绿色建材中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (49, '道桥中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (50, '高教所', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (51, '档案馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (52, '图书馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (60, '后勤集团', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (64, '遗属', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (65, '老干处', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (66, '已故', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (67, '未知', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (69, '马克思主义学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (71, '智能中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (75, '团委', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (84, '厅级', 6, '职务', 65, 5, 130, 0);
INSERT INTO `PM_StaffType` VALUES (88, '一般职工', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (89, '哈哈哈无', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (90, '助教22', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_StaffType` VALUES (92, '高级', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (95, '副研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_StaffType` VALUES (96, '副研究员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_StaffType` VALUES (97, '研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_StaffType` VALUES (98, '实验员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_StaffType` VALUES (99, '助理实验师', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_StaffType` VALUES (100, '实验师', 7, '职称', 75, 5, 190, 1);
INSERT INTO `PM_StaffType` VALUES (101, '高级实验师', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_StaffType` VALUES (102, '管理员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_StaffType` VALUES (103, '助理馆员', 7, '职称', 47, 2, 70, 1);
INSERT INTO `PM_StaffType` VALUES (104, '馆员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_StaffType` VALUES (105, '副研究馆员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_StaffType` VALUES (106, '研究馆员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_StaffType` VALUES (107, '助理编辑', 7, '职称', 47, 2, 70, 1);
INSERT INTO `PM_StaffType` VALUES (108, '编辑', 7, '职称', 0, 0, 0, 1);
INSERT INTO `PM_StaffType` VALUES (109, '副编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (110, '编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (111, '技术设计员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (112, '助理技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (113, '技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (114, '三级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (115, '二级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (116, '一级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (117, '小学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (118, '小学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (119, '小学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (120, '中学三级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (121, '中学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (122, '中学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (123, '中学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (125, '医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (127, '主管护（药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (128, '副主任医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (129, '主任医师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (130, '技术员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (131, '助理工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (132, '工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (133, '高级工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (134, '会计（审计）员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (135, '助理会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (136, '会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (137, '高级会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (138, '普工', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (139, '干部', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (140, '未知', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (141, '其它', 7, '职称', 0, 0, 0, 0);
INSERT INTO `PM_StaffType` VALUES (142, 'DASDA', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (143, '管理人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (144, '专业技术人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (145, '工勤人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (146, '其它', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (147, '单位用房', 8, '职工类别', NULL, NULL, NULL, 1);
INSERT INTO `PM_StaffType` VALUES (149, '离休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (150, '退休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (151, '调离', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (152, '去世', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (153, '出国', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (154, '其它', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (155, '重复', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (156, '其它11', 10, '配偶单位性质', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (157, '校内11', 10, '配偶单位性质', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (162, '党员', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (164, '为嗯嗯', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (166, '洒洒水', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (167, '万事达啊', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (168, '大概', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (169, '111', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (170, 'aSDF', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (171, '萨达撒', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (172, '党员', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (173, '润肤乳', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (174, '男男女女', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (176, '张梦殊最漂亮', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (177, '手术室', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (178, '222', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (179, '试试', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (182, '问问', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_StaffType` VALUES (184, '是', 9, '工作状态', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for PM_SysType
-- ----------------------------
DROP TABLE IF EXISTS `PM_SysType`;
CREATE TABLE `PM_SysType`  (
  `SysParamId` int(11) NOT NULL COMMENT '系统参数编号',
  `SysParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数类型名称',
  PRIMARY KEY (`SysParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_SysType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统参数' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
