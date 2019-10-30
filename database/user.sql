-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL,
  `schoolName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '易哥', 'yeecode@sample.com', '18', '0', 'Sunny School');
INSERT INTO `user` VALUES ('2', '莉莉', 'lili@sample.com', '15', '1', 'Garden School');
INSERT INTO `user` VALUES ('3', '杰克', 'jack@sample.com', '25', '0', 'Sunny School');
INSERT INTO `user` VALUES ('4', '张大壮', 'zdazhaung@sample.com', '16', '0', 'Garden School');
INSERT INTO `user` VALUES ('5', '王小壮', 'wxiaozhuang@sample.com', '27', '0', 'Sunny School');
INSERT INTO `user` VALUES ('6', '露西', 'lucy@sample.com', '14', '1', 'Garden School');
INSERT INTO `user` VALUES ('7', '李二壮', 'lerzhuang@sample.com', '9', '0', 'Sunny School');
