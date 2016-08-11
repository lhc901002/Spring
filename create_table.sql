SET NAMES utf8;

DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `name` VARCHAR(20) NOT NULL DEFAULT '',
  `balance` INT(10) NOT NULL DEFAULT -1 COMMENT 'account balance',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='account entity';

DROP TABLE IF EXISTS `tb_transaction_log`;
CREATE TABLE `tb_transaction_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `from_account_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'from account id',
  `to_account_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'to account id',
  `amount` INT(10) NOT NULL DEFAULT -1 COMMENT 'transaction amount',
  `type` TINYINT(2) NOT NULL DEFAULT -1 COMMENT '1 ',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`from_account_id`),
  KEY `idx_type` (`type`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaction log entity';
