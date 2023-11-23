create TABLE customers (
                            id bigint NOT NULL auto_increment,
                            first_name varchar(255) DEFAULT NULL,
                            last_name varchar(255) DEFAULT NULL,
                            email varchar(255) DEFAULT NULL,
                            PRIMARY KEY (id)
);