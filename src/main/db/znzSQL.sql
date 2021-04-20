CREATE TABLE `user_info` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
                          `user_name` varchar(32) NOT NULL COMMENT '用户账号',
                          `pass_word` varchar(255) NOT NULL COMMENT '用户密码',
                          `phone` tinyint(11) NOT NULL DEFAULT '0' COMMENT '用户手机号 ',
                          `emal` varchar(20) DEFAULT NULL COMMENT '更新时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `event_info` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
                          `event_id` varchar(32) NOT NULL COMMENT '事件编号',
                          `event_address` varchar(32) NOT NULL COMMENT '事件地址',
                          `event_type` varchar(255) NOT NULL COMMENT '事件类型',
                          `event_time` varchar(32) NOT NULL COMMENT '事件时间',
                          `event_number` int(11) NOT NULL DEFAULT '0' COMMENT '事件人数 ',
                          `event_org` varchar(20) DEFAULT NULL COMMENT '事件场所',
                          `event_person` varchar(20) DEFAULT NULL COMMENT '事件人员',
                          `event_content` varchar(20) DEFAULT NULL COMMENT '事件详情',
                          `event_create_time` varchar(20) DEFAULT NULL COMMENT '事件时间',
                          `event_fact_person` varchar(20) DEFAULT NULL COMMENT '上报人',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;