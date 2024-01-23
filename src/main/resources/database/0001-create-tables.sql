create TABLE customers
(
    id                     bigint NOT NULL auto_increment,
    first_name             varchar(255) DEFAULT NULL,
    last_name              varchar(255) DEFAULT NULL,
    email                  varchar(255) DEFAULT NULL,
    date_of_creation       date         DEFAULT NULL,
    leader_id              bigint       DEFAULT NULL,
    practice_website          varchar(255) DEFAULT NULL,
    date_of_granted_access date         DEFAULT NULL,
    access_granted_by      varchar(255) DEFAULT NULL,
    access_granted         boolean,
    price                  integer      DEFAULT NULL,
    PRIMARY KEY (id)
);

-- create TABLE leaders
-- (
--     id   bigint NOT NULL auto_increment PRIMARY KEY,
--     first_name varchar(255) DEFAULT NULL,
--     last_name varchar(255) DEFAULT NULL,
--     customer_id bigint DEFAULT NULL,
--     PRIMARY KEY (id),
--     constraint leaders_customers_id_fk
--         foreign key (customer_id) references customers (id)
-- );
--



