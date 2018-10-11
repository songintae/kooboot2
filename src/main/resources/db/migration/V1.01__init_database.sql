CREATE TABLE `category` (
  `dtype` varchar(31) NOT NULL,
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `exceed_category` (
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`),
  CONSTRAINT `FK8ftosp8s5pl75l6svhstagdas` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB  ;

CREATE TABLE `init_category` (
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`),
  CONSTRAINT `FKqmtrnx0owhqm2ytcw6yuwyg4` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `search_category` (
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`),
  CONSTRAINT `FKe7wayl2rytx3babwof826amcl` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `translate_category` (
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`),
  CONSTRAINT `FKfnc8a5v59erlb80f8o2ifui0` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `last_request_time` datetime DEFAULT NULL,
  `user_key` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKrfbnkwm509b3phkmoyelw86el` (`category_id`),
  CONSTRAINT `FKrfbnkwm509b3phkmoyelw86el` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB  ;

CREATE TABLE `user_data` (
  `user_data_id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_data_id`),
  CONSTRAINT `FK14odyothq9w4rrw99lepvti95` FOREIGN KEY (`user_data_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB  ;
