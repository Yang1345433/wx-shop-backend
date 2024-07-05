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
    `category_id`   BIGINT                      NOT NULL COMMENT '分类id',
    `category_name` VARCHAR(120)                NOT NULL COMMENT '分类名称',
    `brand_id`      BIGINT COMMENT '品牌id',
    `pic_url`       VARCHAR(255)                NOT NULL COMMENT '图片',
    `name`          VARCHAR(120)                NOT NULL COMMENT '名称',
    `brief`         VARCHAR(255) COMMENT '介绍',
    `retail_price`  DECIMAL(10, 2) DEFAULT 0.00 NOT NULL COMMENT '新价格',
    `counter_price` DECIMAL(10, 2) COMMENT '老价格',
    `detail`        VARCHAR(255) COMMENT '详细',
    `other_info`    TEXT COMMENT '其他信息',
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
    `parent_id`  BIGINT       NOT NULL COMMENT '父分类id',
    `pic_url`    VARCHAR(255) NOT NULL COMMENT '图片',
    `front_name` VARCHAR(255) COMMENT '前端名称',
    `name`       VARCHAR(255) NOT NULL COMMENT '名称',
    `icon_url`   VARCHAR(255) COMMENT '名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '分类表';

CREATE TABLE IF NOT EXISTS `specification`
(
    `id`       BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id` BIGINT       NOT NULL COMMENT '商品id',
    `value`    VARCHAR(255) NOT NULL COMMENT '值',
    `spec`     VARCHAR(255) NOT NULL COMMENT '规格类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '商品规格表';

CREATE TABLE IF NOT EXISTS `product`
(
    `id`             BIGINT                      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id`       BIGINT                      NOT NULL COMMENT '商品id',
    `price`          DECIMAL(10, 2) DEFAULT 0.00 NOT NULL COMMENT '价格',
    `specifications` VARCHAR(255)                NOT NULL COMMENT '规格',
    `number`         BIGINT         DEFAULT 0    NOT NULL COMMENT '数量',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '产品表';

CREATE TABLE IF NOT EXISTS `comment`
(
    `id`       BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id` BIGINT      NOT NULL COMMENT '商品id',
    `user_id`  BIGINT      NOT NULL COMMENT '用户id',
    `add_time` VARCHAR(20) NOT NULL COMMENT '时间',
    `content`  TEXT        NOT NULL COMMENT '内容',
    `pic_list` TEXT        NULL COMMENT '图片',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '评论表';

CREATE TABLE IF NOT EXISTS `brand`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        VARCHAR(255) NOT NULL COMMENT '名称',
    `pic_url`     VARCHAR(255) NOT NULL COMMENT '图片',
    `description` TEXT COMMENT '介绍',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '品牌表';

CREATE TABLE IF NOT EXISTS `region`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `pid`  BIGINT       NOT NULL COMMENT '父id',
    `name` VARCHAR(255) NOT NULL COMMENT '名称',
    `type` VARCHAR(20) COMMENT '类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '区域表';

CREATE TABLE IF NOT EXISTS `address`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     BIGINT       NOT NULL COMMENT '用户id',
    `address`     VARCHAR(255) NOT NULL COMMENT '地址',
    `province_id` BIGINT       NOT NULL COMMENT '省份id',
    `city_id`     BIGINT       NOT NULL COMMENT '城市id',
    `area_id`     BIGINT       NOT NULL COMMENT '区域id',
    `mobile`      VARCHAR(20)  NOT NULL COMMENT '电话',
    `name`        VARCHAR(255) NOT NULL COMMENT '姓名',
    `is_default`  BOOL         NOT NULL DEFAULT FALSE COMMENT '是否为默认地址',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '地址表';

CREATE TABLE IF NOT EXISTS `coupon`
(
    `id`          BIGINT                     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `tag`         VARCHAR(255)               NOT NULL COMMENT 'tag',
    `discount`    DECIMAL(10, 2) DEFAULT 0.0 NOT NULL COMMENT '地址',
    `name`        VARCHAR(255)               NOT NULL COMMENT '名称',
    `description` VARCHAR(255)               NOT NULL COMMENT '介绍',
    `min`         DECIMAL(10, 2) DEFAULT 0.0 NOT NULL COMMENT '最小金额',
    `days`        INT                        NOT NULL COMMENT '天数',
    `start_time`  VARCHAR(20)                NOT NULL COMMENT '开始日期',
    `end_time`    VARCHAR(20)                NOT NULL DEFAULT FALSE COMMENT '结束日期',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '优惠卷';

CREATE TABLE IF NOT EXISTS `user_coupon`
(
    `id`        BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`   BIGINT      NOT NULL COMMENT '用户id',
    `coupon_id` BIGINT      NOT NULL COMMENT '优惠卷id',
    `status`    VARCHAR(20) NOT NULL COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '用户优惠卷';

CREATE TABLE IF NOT EXISTS `cart`
(
    `id`         BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    BIGINT NOT NULL COMMENT '用户id',
    `checked`    BOOL            DEFAULT FALSE NOT NULL COMMENT '是否被选中',
    `product_id` BIGINT NOT NULL COMMENT '产品id',
    `number`     INT    NOT NULL DEFAULT 0 COMMENT '数量',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '购物车';
