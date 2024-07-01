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

CREATE TABLE IF NOT EXISTS `article`
(
    `id`       BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `title`    VARCHAR(255) NOT NULL COMMENT '标题',
    `content`  TEXT COMMENT '正文内容',
    `add_time` VARCHAR(20)  NOT NULL COMMENT '添加时间',
    `type`     INT          NOT NULL COMMENT '类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '公告表';

CREATE TABLE IF NOT EXISTS `goods`
(
    `id`            BIGINT                      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `pic_url`       VARCHAR(255)                NOT NULL COMMENT '图片',
    `name`          VARCHAR(120)                NOT NULL COMMENT '名称',
    `brief`         VARCHAR(255) COMMENT '介绍',
    `counter_price` DECIMAL(10, 2) DEFAULT 0.00 NOT NULL COMMENT '价格',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '商品表';

CREATE TABLE IF NOT EXISTS `groupon`
(
    `id`             BIGINT                      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id`       BIGINT                      NOT NULL COMMENT '商品id',
    `groupon_member` INT COMMENT '团购数',
    `groupon_price`  DECIMAL(10, 2) DEFAULT 0.00 NOT NULL COMMENT '团购价格',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '团购表';

CREATE TABLE IF NOT EXISTS `category`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `parent_id`   BIGINT       NOT NULL COMMENT '父分类id',
    `pic_url`    VARCHAR(255) NOT NULL COMMENT '图片',
    `front_name` VARCHAR(255) COMMENT '前端名称',
    `name`       VARCHAR(255) NOT NULL COMMENT '名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '分类表';
