SET NAMES utf8;

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `s_name` VARCHAR(20) NOT NULL DEFAULT '',
  `s_age` INT(5) NOT NULL DEFAULT -1,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='student entity';

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
  `account_id` BIGINT(20) NOT NULL DEFAULT -1 COMMENT 'account id',
  `amount` INT(10) NOT NULL DEFAULT -1 COMMENT 'transaction amount',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY `fk_account_id` (`account_id`) REFERENCES tb_account(`id`),
  KEY `idx_account_id` (`account_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaction log entity';
