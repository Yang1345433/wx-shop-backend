CREATE DATABASE IF NOT EXISTS `wx_shop`;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `open_id`    VARCHAR(255) NOT NULL COMMENT '微信id',
    `avatar_url` VARCHAR(255) COMMENT '头像',
    `name`       VARCHAR(60)  NOT NULL COMMENT '姓名',
    `phone`      VARCHAR(20) COMMENT '电话',
    `password`   VARCHAR(225) COMMENT '密码',
    `roles`      VARCHAR(60)  NOT NULL COMMENT '身份',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '用户表';
