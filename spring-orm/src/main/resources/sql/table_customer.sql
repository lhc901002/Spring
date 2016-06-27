SET NAMES utf8;
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `nick_name` VARCHAR(20) NOT NULL DEFAULT '',
  `sur_name` VARCHAR(50) NOT NULL DEFAULT '',
  `given_name` VARCHAR(20) NOT NULL DEFAULT '',
  `gender` TINYINT(2) NOT NULL DEFAULT 0 COMMENT '1 male 2 female 0 unknown',
  `phone_no` VARCHAR(20) NOT NULL DEFAULT '' COMMENT 'cellphone number of customer',
  `email` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'email of customer',
  `head_image_url` VARCHAR(200) NOT NULL DEFAULT '',
  `star_level` INT(10) NOT NULL DEFAULT -1 COMMENT 'number of stars',
  `score` INT(10) NOT NULL DEFAULT -1,
  `details` BLOB NOT NULL DEFAULT '',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_phone_no` (`phone_no`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='customer entity';


DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `country` VARCHAR(20) NOT NULL DEFAULT '',
  `province` VARCHAR(20) NOT NULL DEFAULT 'province or state',
  `city` VARCHAR(20) NOT NULL DEFAULT '',
  `street` VARCHAR(100) NOT NULL DEFAULT '',
  `zip_code` VARCHAR(20) NOT NULL DEFAULT '',
  `address_type` TINYINT(2) NOT NULL DEFAULT 2 COMMENT '1 permanent address, 2 mailing address',
  `status` BOOL NOT NULL DEFAULT TRUE COMMENT 'TRUE in use, FALSE no longer in use',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='address entity';


DROP TABLE IF EXISTS `tb_customer_address_relation`;
CREATE TABLE `tb_customer_address_relation` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `customer_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_customer.id',
  `address_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_address.id',
  `status` BOOL NOT NULL DEFAULT TRUE COMMENT 'TRUE in use, FALSE no longer in use',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY `fk_customer_id` (`customer_id`) REFERENCES tb_customer(`id`),
  FOREIGN KEY `fk_address_id` (`address_id`) REFERENCES tb_address(`id`),
  KEY `idx_customer_id` (`customer_id`),
  KEY `idx_address_id` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='relation entity between customer and address';

