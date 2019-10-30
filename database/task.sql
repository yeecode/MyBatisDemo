-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `taskName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '1', 'Clean classroom.');
INSERT INTO `task` VALUES ('2', '1', 'Open the door.');
INSERT INTO `task` VALUES ('3', '2', 'Open windows.');
INSERT INTO `task` VALUES ('4', '3', 'Clean the blackboard.');
INSERT INTO `task` VALUES ('5', '2', 'Buy some boos.');
INSERT INTO `task` VALUES ('6', '3', 'Buy some pens.');
INSERT INTO `task` VALUES ('7', '4', 'Buy some flowers.');