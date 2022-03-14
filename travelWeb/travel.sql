/*
 Navicat Premium Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 16/04/2021 17:52:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名',
  `admin_password` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登录密码',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'mike', '123456');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `com_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `com_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `user_id` int(0) NOT NULL COMMENT '用户编号',
  `spot_id` int(0) NOT NULL COMMENT '景点编号',
  `com_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论状态',
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '真好看', 1, 1, '0');

-- ----------------------------
-- Table structure for great
-- ----------------------------
DROP TABLE IF EXISTS `great`;
CREATE TABLE `great`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `aid` int(0) NOT NULL,
  `uid` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of great
-- ----------------------------
INSERT INTO `great` VALUES (5, 1, 1);

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `img_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '图片编号',
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径',
  `img_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片来源',
  `spot_id` int(0) NULL DEFAULT NULL COMMENT '景点编号',
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES (1, '/images/spot/1/7.jpeg', '用户', 1);
INSERT INTO `images` VALUES (2, '/images/spot/1/8.jpeg', '网络', 1);
INSERT INTO `images` VALUES (3, '/images/spot/1/9.jpeg', '用户', 1);
INSERT INTO `images` VALUES (4, '/images/spot/1/10.jpeg', '用户', 1);
INSERT INTO `images` VALUES (5, '/images/spot/25/1.jpg', '网络', 25);
INSERT INTO `images` VALUES (6, '/images/spot/25/2.jpg', '网络', 25);
INSERT INTO `images` VALUES (7, '/images/spot/25/3.jpg', '网络', 25);

-- ----------------------------
-- Table structure for spot
-- ----------------------------
DROP TABLE IF EXISTS `spot`;
CREATE TABLE `spot`  (
  `spot_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '景点编号',
  `spot_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点名',
  `spot_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点地址',
  `spot_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点开放时间',
  `spot_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游玩方式',
  `spot_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '景点价格',
  `spot_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点描述',
  `spot_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点图片',
  `spot_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点主题',
  `spot_traffic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交通方式',
  `spot_food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点美食',
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `spot_img_status` int(0) NOT NULL,
  `great_num` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`spot_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spot
-- ----------------------------
INSERT INTO `spot` VALUES (1, '故宫', 'BeiJing', NULL, NULL, 100.00, '故宫是遵循封建等级礼制建造的庞大建筑群，有九千多个房间，总面积达72万平方米，布局严谨，秩序井然。所有宫殿建筑均严格按一条由南向北的中轴线展开，南北取直，左右对称，南部太和殿、中和殿、保和殿，北部乾清宫、交泰宫、坤宁宫、御花园都位于这条中轴线上，两侧有数不清的大小宫殿楼阁，清一色的砖木结构、黄琉璃瓦顶，高低错落，壮观雄伟', '/images/spot/1.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (2, '阿尔卑斯山', 'Other', NULL, NULL, 10000.00, '在阿尔卑斯意大利东北部与威尼斯之间有一片独一无二的山区：巍峨的巨型白云岩山峰直插云霄，绿草葱葱、牛羊成群的牧场连接成片，刀切般山峰下精雕细琢的德系小镇悠然自得，这片区域有个如诗如画的名字——多洛米蒂。\r\n\r\n伯尔尼纳景观列车被誉为冰川快车的精华浓缩版，也是瑞士最受欢迎的全景观列车游览路线之一。穿梭于山林绿野间，捕捉一抹风景，感受阿尔卑斯山的辽阔与壮丽。', '/images/spot/2.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (3, '夏威夷', 'Other', NULL, NULL, 1200.00, '夏威夷的岛屿有132个，全年风和日丽、每个岛屿都有着丰富的旅游资源和独特的个性。适合一年四季前来，冬季前来可以享受到夏天的清爽。很多旅行者会选择夏威夷的三个到游玩：欧胡岛，大岛（夏威夷岛）和茂宜岛。\r\n\r\n欧湖岛是你觉得不要错过的一个极具活力的岛屿，这里有最浪漫的日出，也有丰富多彩的夜生活。太阳出来，我们可以漫步在海滩上面，欣赏着清早在海洋中冲浪和游泳的人们，这些冲浪爱好者给这片海洋增添了更多的生机和活力。欧胡岛是夏威夷的第三大岛屿，这里非常适合潜水，浮潜等水上活动。', '/images/spot/3.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (4, '长城', 'BeiJing', NULL, NULL, 1200.00, 'hdfh', '/images/spot/4.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (5, '长城', 'BeiJing', NULL, NULL, 1200.00, 'bfdhdf', '/images/spot/5.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (6, '长城', 'BeiJing', NULL, NULL, 1200.00, 'ngfhdf', '/images/spot/6.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (7, '故宫', 'BeiJing', NULL, NULL, 2200.00, 'jdtyj', '/images/spot/7.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (8, '故宫', 'BeiJing', NULL, NULL, 2200.00, 'fdsh', '/images/spot/8.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (9, '故宫', 'BeiJing', NULL, NULL, 2200.00, 'gdfhs', '/images/spot/9.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (10, '故宫', 'BeiJing', NULL, NULL, 3300.00, 'fdh', '/images/spot/10.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (11, '故宫', 'BeiJing', NULL, NULL, 4300.00, 'bsrhr', '/images/spot/11.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (12, '故宫', 'BeiJing', NULL, NULL, 1200.00, 'fgsdfg', '/images/spot/12.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (13, '颐和园', 'BeiJing', NULL, NULL, 2000.00, 'srhrthstrhtsrj', '/images/spot/13.jpg', 'History', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (14, '鸟巢', 'BeiJing', NULL, NULL, 2300.00, 'bfdsdgklsdjlgjdsg', '/images/spot/14.jpg', 'Other', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (15, '鸟巢', 'BeiJing', NULL, NULL, 2300.00, 'bfdsdgklsdjlgjdsg', '/images/spot/15.jpg', 'Other', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (16, '鸟巢', 'BeiJing', NULL, NULL, 2300.00, 'bfdsdgklsdjlgjdsg', '/images/spot/16.jpg', 'Other', NULL, NULL, 0, 1, 0);
INSERT INTO `spot` VALUES (17, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/17.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (18, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/18.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (19, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/19.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (20, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/20.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (21, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/21.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (22, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/22.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (23, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/23.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (24, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/24.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (25, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot25.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (26, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/26.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (27, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/27.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (28, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/28.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (29, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/29.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (30, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/30.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (31, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/31.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (32, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/32.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (33, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/33.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (34, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/34.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (35, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/35.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (36, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/36.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (37, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/37.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (38, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/38.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (39, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/39.jpg', 'History', NULL, NULL, 0, 1, NULL);
INSERT INTO `spot` VALUES (40, '鸟巢', 'Shanghai', NULL, NULL, 3000.00, 'fwaeterhytkyu', '/images/spot/40.jpg', 'History', NULL, NULL, 0, 1, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户电话',
  `user_password` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13772737237', '12345678');
INSERT INTO `user` VALUES (2, '16778283823', '12345678');

-- ----------------------------
-- Table structure for userlog
-- ----------------------------
DROP TABLE IF EXISTS `userlog`;
CREATE TABLE `userlog`  (
  `log_id` int(0) NOT NULL COMMENT '心得编号',
  `log_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '心得内容',
  `user_id` int(0) NOT NULL COMMENT '用户编号',
  `log_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '心得状态',
  `log_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '心得图片',
  `log_time` date NULL DEFAULT NULL COMMENT '心得发表时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userlog
-- ----------------------------
INSERT INTO `userlog` VALUES (1, 'lalalla', 1, '0', NULL, '2021-02-10');

SET FOREIGN_KEY_CHECKS = 1;
