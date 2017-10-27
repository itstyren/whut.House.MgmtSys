/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : whlglease

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 26/10/2017 22:00:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PM_EmployeeType
-- ----------------------------
DROP TABLE IF EXISTS `PM_EmployeeType`;
CREATE TABLE `PM_EmployeeType`  (
  `EmployeeParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工参数编号',
  `EmployeeParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '员工类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工类型名称',
  `EmployeeParamFra` int(11) DEFAULT NULL COMMENT '分数',
  `EmployeeParamSpouseFra` int(11) DEFAULT NULL COMMENT '配偶分数',
  `EmployeeParamHouseArea` float(11, 0) DEFAULT NULL COMMENT '享受面积',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`EmployeeParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_EmployeeType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_EmployeeType
-- ----------------------------
INSERT INTO `PM_EmployeeType` VALUES (1, '党办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (2, '校办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (3, '教务处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (4, '研究生处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (5, '科学技术发展院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (6, '学工部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (7, '组织部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (8, '统战部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (9, '宣传部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (10, '纪委监察处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (11, '机关党委', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (12, '人事处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (13, '保卫处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (14, '审计处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (15, '国资处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (16, '基建处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (17, '后勤保障处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (18, '离退休处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (19, '工会', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (20, '余区管委会', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (21, '材料学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (22, '交通学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (23, '管理学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (24, '机电学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (25, '能动学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (26, '土建学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (27, '汽车学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (28, '资环学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (29, '信息学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (30, '计算机学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (31, '自动化学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (32, '航运学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (33, '文法学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (34, '理学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (35, '经济学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (36, '艺术学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (37, '外语学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (38, '物流学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (39, '政治学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (40, '化生学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (41, '国教学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (42, '网络学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (43, '职业技术学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (44, '体育部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (45, '新材所', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (46, '光纤中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (47, '硅酸盐中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (48, '绿色建材中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (49, '道桥中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (50, '高教所', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (51, '档案馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (52, '图书馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (53, '设计院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (54, '出版社', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (55, '医院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (56, '网络中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (57, '教服中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (58, '工程监理中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (59, '工程训练中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (60, '后勤集团', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (61, '产业集团', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (62, '华夏学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (63, '财务处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (64, '遗属', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (65, '老干处', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (66, '已故', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (67, '未知', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (68, '其它', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (69, '马克思主义学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (70, '物流中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (71, '智能中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (72, '测试中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (73, '发展规划办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (74, '继续教育学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (75, '团委', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (76, '科员', 6, '职务', 50, 3, 80, 0);
INSERT INTO `PM_EmployeeType` VALUES (77, '副主任科员', 6, '职务', 47, 2, 70, 1);
INSERT INTO `PM_EmployeeType` VALUES (78, '主任科员', 6, '职务', 48, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (79, '副科长', 6, '职务', 55, 4, 100, 1);
INSERT INTO `PM_EmployeeType` VALUES (80, '科级', 6, '职务', 53, 4, 100, 0);
INSERT INTO `PM_EmployeeType` VALUES (81, '副处长', 6, '职务', 48, 2, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (82, '处级', 6, '职务', 47, 2, 80, 0);
INSERT INTO `PM_EmployeeType` VALUES (83, '副厅长', 6, '职务', 65, 5, 130, 1);
INSERT INTO `PM_EmployeeType` VALUES (84, '厅级', 6, '职务', 65, 5, 130, 0);
INSERT INTO `PM_EmployeeType` VALUES (85, '未知', 6, '职务', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (86, '干部', 6, '职务', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (87, '其它', 6, '职务', 0, 0, 0, 0);
INSERT INTO `PM_EmployeeType` VALUES (88, '一般职工', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (89, '无', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (90, '助教', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (91, '初级', 7, '职称', 47, 1, 70, 0);
INSERT INTO `PM_EmployeeType` VALUES (92, '高级', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (93, '副高', 7, '职称', 46, 1, 100, 0);
INSERT INTO `PM_EmployeeType` VALUES (94, 'HJH', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (95, '副研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_EmployeeType` VALUES (96, '副研究员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_EmployeeType` VALUES (97, '研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_EmployeeType` VALUES (98, '实验员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (99, '助理实验师', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_EmployeeType` VALUES (100, '实验师', 7, '职称', 75, 5, 190, 1);
INSERT INTO `PM_EmployeeType` VALUES (101, '高级实验师', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (102, '管理员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (103, '助理馆员', 7, '职称', 47, 2, 70, 1);
INSERT INTO `PM_EmployeeType` VALUES (104, '馆员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `PM_EmployeeType` VALUES (105, '副研究馆员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `PM_EmployeeType` VALUES (106, '研究馆员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `PM_EmployeeType` VALUES (107, '助理编辑', 7, '职称', 47, 2, 70, 1);
INSERT INTO `PM_EmployeeType` VALUES (108, '编辑', 7, '职称', 0, 0, 0, 1);
INSERT INTO `PM_EmployeeType` VALUES (109, '副编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (110, '编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (111, '技术设计员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (112, '助理技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (113, '技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (114, '三级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (115, '二级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (116, '一级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (117, '小学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (118, '小学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (119, '小学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (120, '中学三级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (121, '中学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (122, '中学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (123, '中学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (124, '护（药、技）士', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (125, '医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (126, '主治医师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (127, '主管护（药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (128, '副主任医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (129, '主任医师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (130, '技术员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (131, '助理工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (132, '工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (133, '高级工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (134, '会计（审计）员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (135, '助理会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (136, '会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (137, '高级会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (138, '普工', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (139, '干部', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (140, '未知', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (141, '其它', 7, '职称', 0, 0, 0, 0);
INSERT INTO `PM_EmployeeType` VALUES (142, 'DASDA', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (143, '管理人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (144, '专业技术人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (145, '工勤人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (146, '其它', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (147, '单位用房', 8, '职工类别', NULL, NULL, NULL, 1);
INSERT INTO `PM_EmployeeType` VALUES (148, '在职', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (149, '离休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (150, '退休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (151, '调离', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (152, '去世', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (153, '出国', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (154, '其它', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (155, '重复', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (156, '其它', 10, '配偶单位性质', NULL, NULL, NULL, 0);
INSERT INTO `PM_EmployeeType` VALUES (157, '校内', 10, '配偶单位性质', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for PM_FixType
-- ----------------------------
DROP TABLE IF EXISTS `PM_FixType`;
CREATE TABLE `PM_FixType`  (
  `FixParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修参数编号',
  `FixParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '维修类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '维修类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
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
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数类型名称',
  `HouseParamRelation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '住房登记关系',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`HouseParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_HouseType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '住房参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_HouseType
-- ----------------------------
INSERT INTO `PM_HouseType` VALUES (1, '全额集资房', 1, '住房类型', '空闲,购买', 0);
INSERT INTO `PM_HouseType` VALUES (2, '成本价房', 1, '住房类型', '购买', 0);
INSERT INTO `PM_HouseType` VALUES (3, '标准价住房', 1, '住房类型', '购买', 0);
INSERT INTO `PM_HouseType` VALUES (4, '私房', 1, '住房类型', '私有', 0);
INSERT INTO `PM_HouseType` VALUES (5, '公租周转房', 1, '住房类型', '空闲,租赁', 0);
INSERT INTO `PM_HouseType` VALUES (6, '周转房', 1, '住房类型', '空闲,租赁,公房', 0);
INSERT INTO `PM_HouseType` VALUES (7, '房改房', 1, '住房类型', '购买', 0);
INSERT INTO `PM_HouseType` VALUES (8, '未知', 1, '住房类型', NULL, 1);
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

-- ----------------------------
-- Table structure for PM_ParamClass
-- ----------------------------
DROP TABLE IF EXISTS `PM_ParamClass`;
CREATE TABLE `PM_ParamClass`  (
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型名',
  `ParamClassId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别编号',
  `ParamClassName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别名',
  PRIMARY KEY (`ParamTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数类型编号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_ParamClass
-- ----------------------------
INSERT INTO `PM_ParamClass` VALUES (0, '系统设置', '0', '系统参数');
INSERT INTO `PM_ParamClass` VALUES (1, '住房类型', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (2, '户型', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (3, '使用状态', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (4, '住房结构', '1', '住房参数');
INSERT INTO `PM_ParamClass` VALUES (5, '工作部门', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (6, '职务', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (7, '职称', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (8, '职工类别', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (9, '工作状态', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (10, '配偶单位性质', '2', '职工参数');
INSERT INTO `PM_ParamClass` VALUES (11, '职务分', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (12, '职称分', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (13, '职务面积', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (14, '职称面积', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (15, '是否开启选房', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (16, '选房开始时间', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (17, '选房时间', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (18, '选房所需积分', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (19, '选房规则', '3', '租赁参数');
INSERT INTO `PM_ParamClass` VALUES (20, '维修内容', '4', '维修参数');
INSERT INTO `PM_ParamClass` VALUES (21, '新老职工时间分界点', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (22, '老职工优惠比例', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (23, '新职工优惠年限', '5', '租金参数');
INSERT INTO `PM_ParamClass` VALUES (24, '新职工优惠比例', '5', '租金参数');

-- ----------------------------
-- Table structure for PM_RentType
-- ----------------------------
DROP TABLE IF EXISTS `PM_RentType`;
CREATE TABLE `PM_RentType`  (
  `RentParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租赁参数编号',
  `RentParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租赁参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租赁类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租赁类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
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
-- Table structure for PM_RentPayType
-- ----------------------------
DROP TABLE IF EXISTS `PM_RentPayType`;
CREATE TABLE `PM_RentPayType`  (
  `RentPayParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租金参数编号',
  `RentPayParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租金参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租金类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租金类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`RentPayParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_RentPayType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租金参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PM_RentPayType
-- ----------------------------
INSERT INTO `PM_RentPayType` VALUES (1, '1993-09-01 00:00:00.000', 21, '新老职工时间分界点', 0);
INSERT INTO `PM_RentPayType` VALUES (2, '0.2', 22, '老职工优惠比例', 0);
INSERT INTO `PM_RentPayType` VALUES (3, '3', 23, '新职工优惠年限', 0);
INSERT INTO `PM_RentPayType` VALUES (4, '0.2', 24, '新职工优惠比例', 0);

-- ----------------------------
-- Table structure for PM_SysType
-- ----------------------------
DROP TABLE IF EXISTS `PM_SysType`;
CREATE TABLE `PM_SysType`  (
  `SysParamId` int(11) NOT NULL COMMENT '系统参数编号',
  `SysParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数类型名称',
  PRIMARY KEY (`SysParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `PM_SysType_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `PM_ParamClass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统参数' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
