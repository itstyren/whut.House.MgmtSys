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
-- Table structure for pm_employeeparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_employeeparamtype`;
CREATE TABLE `pm_employeeparamtype`  (
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
  CONSTRAINT `pm_employeeparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_employeeparamtype
-- ----------------------------
INSERT INTO `pm_employeeparamtype` VALUES (1, '党办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (2, '校办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (3, '教务处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (4, '研究生处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (5, '科学技术发展院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (6, '学工部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (7, '组织部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (8, '统战部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (9, '宣传部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (10, '纪委监察处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (11, '机关党委', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (12, '人事处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (13, '保卫处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (14, '审计处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (15, '国资处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (16, '基建处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (17, '后勤保障处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (18, '离退休处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (19, '工会', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (20, '余区管委会', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (21, '材料学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (22, '交通学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (23, '管理学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (24, '机电学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (25, '能动学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (26, '土建学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (27, '汽车学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (28, '资环学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (29, '信息学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (30, '计算机学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (31, '自动化学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (32, '航运学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (33, '文法学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (34, '理学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (35, '经济学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (36, '艺术学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (37, '外语学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (38, '物流学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (39, '政治学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (40, '化生学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (41, '国教学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (42, '网络学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (43, '职业技术学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (44, '体育部', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (45, '新材所', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (46, '光纤中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (47, '硅酸盐中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (48, '绿色建材中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (49, '道桥中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (50, '高教所', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (51, '档案馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (52, '图书馆', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (53, '设计院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (54, '出版社', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (55, '医院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (56, '网络中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (57, '教服中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (58, '工程监理中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (59, '工程训练中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (60, '后勤集团', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (61, '产业集团', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (62, '华夏学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (63, '财务处', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (64, '遗属', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (65, '老干处', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (66, '已故', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (67, '未知', 5, '工作部门', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (68, '其它', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (69, '马克思主义学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (70, '物流中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (71, '智能中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (72, '测试中心', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (73, '发展规划办', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (74, '继续教育学院', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (75, '团委', 5, '工作部门', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (76, '科员', 6, '职务', 50, 3, 80, 0);
INSERT INTO `pm_employeeparamtype` VALUES (77, '副主任科员', 6, '职务', 47, 2, 70, 1);
INSERT INTO `pm_employeeparamtype` VALUES (78, '主任科员', 6, '职务', 48, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (79, '副科长', 6, '职务', 55, 4, 100, 1);
INSERT INTO `pm_employeeparamtype` VALUES (80, '科级', 6, '职务', 53, 4, 100, 0);
INSERT INTO `pm_employeeparamtype` VALUES (81, '副处长', 6, '职务', 48, 2, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (82, '处级', 6, '职务', 47, 2, 80, 0);
INSERT INTO `pm_employeeparamtype` VALUES (83, '副厅长', 6, '职务', 65, 5, 130, 1);
INSERT INTO `pm_employeeparamtype` VALUES (84, '厅级', 6, '职务', 65, 5, 130, 0);
INSERT INTO `pm_employeeparamtype` VALUES (85, '未知', 6, '职务', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (86, '干部', 6, '职务', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (87, '其它', 6, '职务', 0, 0, 0, 0);
INSERT INTO `pm_employeeparamtype` VALUES (88, '一般职工', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (89, '无', 6, '职务', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (90, '助教', 7, '职称', 50, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (91, '初级', 7, '职称', 47, 1, 70, 0);
INSERT INTO `pm_employeeparamtype` VALUES (92, '高级', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (93, '副高', 7, '职称', 46, 1, 100, 0);
INSERT INTO `pm_employeeparamtype` VALUES (94, 'HJH', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (95, '副研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `pm_employeeparamtype` VALUES (96, '副研究员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `pm_employeeparamtype` VALUES (97, '研究员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `pm_employeeparamtype` VALUES (98, '实验员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (99, '助理实验师', 7, '职称', 55, 4, 100, 1);
INSERT INTO `pm_employeeparamtype` VALUES (100, '实验师', 7, '职称', 75, 5, 190, 1);
INSERT INTO `pm_employeeparamtype` VALUES (101, '高级实验师', 7, '职称', 50, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (102, '管理员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (103, '助理馆员', 7, '职称', 47, 2, 70, 1);
INSERT INTO `pm_employeeparamtype` VALUES (104, '馆员', 7, '职称', 50, 3, 80, 1);
INSERT INTO `pm_employeeparamtype` VALUES (105, '副研究馆员', 7, '职称', 55, 4, 100, 1);
INSERT INTO `pm_employeeparamtype` VALUES (106, '研究馆员', 7, '职称', 60, 5, 130, 1);
INSERT INTO `pm_employeeparamtype` VALUES (107, '助理编辑', 7, '职称', 47, 2, 70, 1);
INSERT INTO `pm_employeeparamtype` VALUES (108, '编辑', 7, '职称', 0, 0, 0, 1);
INSERT INTO `pm_employeeparamtype` VALUES (109, '副编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (110, '编审', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (111, '技术设计员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (112, '助理技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (113, '技术编辑', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (114, '三级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (115, '二级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (116, '一级校对', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (117, '小学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (118, '小学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (119, '小学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (120, '中学三级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (121, '中学二级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (122, '中学一级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (123, '中学高级教师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (124, '护（药、技）士', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (125, '医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (126, '主治医师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (127, '主管护（药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (128, '副主任医（护、药、技）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (129, '主任医师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (130, '技术员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (131, '助理工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (132, '工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (133, '高级工程师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (134, '会计（审计）员', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (135, '助理会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (136, '会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (137, '高级会计（审计）师', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (138, '普工', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (139, '干部', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (140, '未知', 7, '职称', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (141, '其它', 7, '职称', 0, 0, 0, 0);
INSERT INTO `pm_employeeparamtype` VALUES (142, 'DASDA', 7, '职称', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (143, '管理人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (144, '专业技术人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (145, '工勤人员', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (146, '其它', 8, '职工类别', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (147, '单位用房', 8, '职工类别', NULL, NULL, NULL, 1);
INSERT INTO `pm_employeeparamtype` VALUES (148, '在职', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (149, '离休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (150, '退休', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (151, '调离', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (152, '去世', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (153, '出国', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (154, '其它', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (155, '重复', 9, '工作状态', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (156, '其它', 10, '配偶单位性质', NULL, NULL, NULL, 0);
INSERT INTO `pm_employeeparamtype` VALUES (157, '校内', 10, '配偶单位性质', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for pm_fixparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_fixparamtype`;
CREATE TABLE `pm_fixparamtype`  (
  `FixParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修参数编号',
  `FixParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '维修类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '维修类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`FixParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `pm_fixparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_fixparamtype
-- ----------------------------
INSERT INTO `pm_fixparamtype` VALUES (1, '门窗损坏', 20, '维修内容', 0);

-- ----------------------------
-- Table structure for pm_houseparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_houseparamtype`;
CREATE TABLE `pm_houseparamtype`  (
  `HouseParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '住房参数编号',
  `HouseParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住房参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数类型名称',
  `HouseParamRelation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '住房登记关系',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`HouseParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `pm_houseparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '住房参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_houseparamtype
-- ----------------------------
INSERT INTO `pm_houseparamtype` VALUES (1, '全额集资房', 1, '住房类型', '空闲,购买', 0);
INSERT INTO `pm_houseparamtype` VALUES (2, '成本价房', 1, '住房类型', '购买', 0);
INSERT INTO `pm_houseparamtype` VALUES (3, '标准价住房', 1, '住房类型', '购买', 0);
INSERT INTO `pm_houseparamtype` VALUES (4, '私房', 1, '住房类型', '私有', 0);
INSERT INTO `pm_houseparamtype` VALUES (5, '公租周转房', 1, '住房类型', '空闲,租赁', 0);
INSERT INTO `pm_houseparamtype` VALUES (6, '周转房', 1, '住房类型', '空闲,租赁,公房', 0);
INSERT INTO `pm_houseparamtype` VALUES (7, '房改房', 1, '住房类型', '购买', 0);
INSERT INTO `pm_houseparamtype` VALUES (8, '未知', 1, '住房类型', NULL, 1);
INSERT INTO `pm_houseparamtype` VALUES (9, '单间', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (10, '一室一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (11, '两室一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (12, '小三间', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (13, '两室两厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (14, '三室一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (15, '三室两厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (16, '四室一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (17, '四室两厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (18, '套间', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (19, '两室', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (20, '两室半一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (21, '三室半一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (22, '一室半一厅', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (23, '三室', 2, '户型', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (24, '空闲', 3, '使用状态', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (25, '租赁', 3, '使用状态', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (26, '购买', 3, '使用状态', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (27, '私有', 3, '使用状态', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (28, '公房', 3, '使用状态', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (29, '钢混', 4, '住房结构', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (30, '混合', 4, '住房结构', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (31, '砖木', 4, '住房结构', NULL, 0);
INSERT INTO `pm_houseparamtype` VALUES (32, '砖混', 4, '住房结构', NULL, 0);

-- ----------------------------
-- Table structure for pm_paramclass
-- ----------------------------
DROP TABLE IF EXISTS `pm_paramclass`;
CREATE TABLE `pm_paramclass`  (
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型名',
  `ParamClassId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别编号',
  `ParamClassName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类别名',
  PRIMARY KEY (`ParamTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数类型编号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_paramclass
-- ----------------------------
INSERT INTO `pm_paramclass` VALUES (0, '系统设置', '0', '系统参数');
INSERT INTO `pm_paramclass` VALUES (1, '住房类型', '1', '住房参数');
INSERT INTO `pm_paramclass` VALUES (2, '户型', '1', '住房参数');
INSERT INTO `pm_paramclass` VALUES (3, '使用状态', '1', '住房参数');
INSERT INTO `pm_paramclass` VALUES (4, '住房结构', '1', '住房参数');
INSERT INTO `pm_paramclass` VALUES (5, '工作部门', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (6, '职务', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (7, '职称', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (8, '职工类别', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (9, '工作状态', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (10, '配偶单位性质', '2', '职工参数');
INSERT INTO `pm_paramclass` VALUES (11, '职务分', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (12, '职称分', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (13, '职务面积', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (14, '职称面积', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (15, '是否开启选房', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (16, '选房开始时间', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (17, '选房时间', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (18, '选房所需积分', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (19, '选房规则', '3', '租赁参数');
INSERT INTO `pm_paramclass` VALUES (20, '维修内容', '4', '维修参数');
INSERT INTO `pm_paramclass` VALUES (21, '新老职工时间分界点', '5', '租金参数');
INSERT INTO `pm_paramclass` VALUES (22, '老职工优惠比例', '5', '租金参数');
INSERT INTO `pm_paramclass` VALUES (23, '新职工优惠年限', '5', '租金参数');
INSERT INTO `pm_paramclass` VALUES (24, '新职工优惠比例', '5', '租金参数');

-- ----------------------------
-- Table structure for pm_rentparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_rentparamtype`;
CREATE TABLE `pm_rentparamtype`  (
  `RentParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租赁参数编号',
  `RentParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租赁参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租赁类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租赁类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`RentParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `pm_rentparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租赁参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_rentparamtype
-- ----------------------------
INSERT INTO `pm_rentparamtype` VALUES (1, '是', 15, '是否开启选房', 0);
INSERT INTO `pm_rentparamtype` VALUES (2, '2017-03-02 18:36:00.000', 16, '选房开始时间', 0);
INSERT INTO `pm_rentparamtype` VALUES (3, '20', 17, '选房时间', 0);
INSERT INTO `pm_rentparamtype` VALUES (4, '0', 18, '选房所需积分', 0);
INSERT INTO `pm_rentparamtype` VALUES (5, '选房规则', 19, '选房规则', 0);

-- ----------------------------
-- Table structure for pm_rentpayparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_rentpayparamtype`;
CREATE TABLE `pm_rentpayparamtype`  (
  `RentPayParamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租金参数编号',
  `RentPayParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租金参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '租金类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租金类型名称',
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`RentPayParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `pm_rentpayparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租金参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_rentpayparamtype
-- ----------------------------
INSERT INTO `pm_rentpayparamtype` VALUES (1, '1993-09-01 00:00:00.000', 21, '新老职工时间分界点', 0);
INSERT INTO `pm_rentpayparamtype` VALUES (2, '0.2', 22, '老职工优惠比例', 0);
INSERT INTO `pm_rentpayparamtype` VALUES (3, '3', 23, '新职工优惠年限', 0);
INSERT INTO `pm_rentpayparamtype` VALUES (4, '0.2', 24, '新职工优惠比例', 0);

-- ----------------------------
-- Table structure for pm_sysparamtype
-- ----------------------------
DROP TABLE IF EXISTS `pm_sysparamtype`;
CREATE TABLE `pm_sysparamtype`  (
  `SysParamId` int(11) NOT NULL COMMENT '系统参数编号',
  `SysParamName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统参数名称',
  `ParamTypeId` int(11) NOT NULL COMMENT '参数类型编号',
  `ParamTypeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数类型名称',
  PRIMARY KEY (`SysParamId`) USING BTREE,
  INDEX `ParamTypeId`(`ParamTypeId`) USING BTREE,
  CONSTRAINT `pm_sysparamtype_ibfk_1` FOREIGN KEY (`ParamTypeId`) REFERENCES `pm_paramclass` (`ParamTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统参数' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
