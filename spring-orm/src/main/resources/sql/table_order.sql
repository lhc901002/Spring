SET NAMES utf8;

DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `prod_name` VARCHAR(20) NOT NULL DEFAULT '',
  `model` VARCHAR(50) NOT NULL DEFAULT '',
  `prod_type` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0 no type, or other specific types',
  `prod_image_url` VARCHAR(200) NOT NULL DEFAULT '',
  `price` INT(10) NOT NULL DEFAULT -1 COMMENT 'unit: cent',
  `balance` INT(10) NOT NULL DEFAULT -1 COMMENT 'stock balance',
  `sales_volume` INT(10) NOT NULL DEFAULT 0 COMMENT 'number of copies sold out',
  `comment_count` INT(10) NOT NULL DEFAULT 0 COMMENT 'number of comments',
  `collect_count` INT(10) NOT NULL DEFAULT 0 COMMENT 'number of customers collecting the product',
  `popularity` INT(10) NOT NULL DEFAULT 0 COMMENT 'index of popularity of the product',
  `status` TINYINT(2) NOT NULL DEFAULT -1 COMMENT '1 on sale, 2 no stock, 3 off stock',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_prod_type` (`prod_type`),
  KEY `idx_price` (`price`),
  KEY `idx_sales_volume` (`sales_volume`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product entity';

DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `customer_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_customer.id',
  `address_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_address.id',
  `total_price` INT(10) NOT NULL DEFAULT -1 COMMENT 'unit: cent',
  `prod_count` INT(10) NOT NULL DEFAULT 0 COMMENT 'number of products in the order',
  `status` TINYINT(2) NOT NULL DEFAULT 1 COMMENT '1 not paid, 2 paid, 3 delivered, 4 received, 5 canceled',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY `fk_customer_id` (`customer_id`) REFERENCES tb_customer(`id`),
  FOREIGN KEY `fk_address_id` (`address_id`) REFERENCES tb_address(`id`),
  KEY `idx_customer_id` (`customer_id`),
  KEY `idx_address_id` (`address_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='order entity';

DROP TABLE IF EXISTS `tb_order_product`;
CREATE TABLE `tb_order_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `order_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_order.id',
  `product_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'foreign key reference tb_product.id',
  `prod_count` INT(10) NOT NULL DEFAULT 0 COMMENT 'number of products in the order',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY `fk_order_id` (`order_id`) REFERENCES tb_order(`id`),
  FOREIGN KEY `fk_product_id` (`product_id`) REFERENCES tb_product(`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='relation between order and product';

