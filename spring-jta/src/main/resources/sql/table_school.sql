SET NAMES utf8;

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `s_name` VARCHAR(20) NOT NULL DEFAULT '',
  `s_age` INT(5) NOT NULL DEFAULT -1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='student entity';

DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `t_name` VARCHAR(20) NOT NULL DEFAULT '',
  `t_department` VARCHAR(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='teacher entity';
