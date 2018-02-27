CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `resource_type` varchar(32) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(32) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) DEFAULT NULL COMMENT '账号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `password` varchar(32) DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `index_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `sys_permission`(name,parent_id,parent_ids,available,permission,resource_type,url)   
VALUES ('用户管理',0,'0/' ,1,'userInfo:view', 'menu', 'userInfo/userList');  
  
INSERT INTO `sys_permission`(name,parent_id,parent_ids,available,permission,resource_type,url)   
VALUES ('用户添加',1,'0/1',1,'userInfo:add', 'button', 'userInfo/userAdd');  
  
INSERT INTO `sys_permission`(name,parent_id,parent_ids,available,permission,resource_type,url)   
VALUES ('用户删除',1,'0/1',1,'userInfo:del', 'button', 'userInfo/userDel');  
  
INSERT INTO `sys_role`(available,description,role) VALUES (1,'管理员','admin');  
INSERT INTO `sys_role`(available,description,role) VALUES (1,'VIP会员','vip');  
  
INSERT INTO `sys_role_permission`(permission_id,role_id) VALUES ('1', '1');  
INSERT INTO `sys_role_permission`(permission_id,role_id) VALUES ('2', '1'); 
INSERT INTO `sys_role_permission`(permission_id,role_id) VALUES ('1', '2');  
  
INSERT INTO `user_info`(name,password,salt,state,username) VALUES ('管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0', 'admin');  
  
INSERT INTO `sys_user_role`(uid,role_id) VALUES (1,1);  
INSERT INTO `sys_user_role`(uid,role_id) VALUES (1,2);  