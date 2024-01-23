insert into customers(first_name, last_name, email, date_of_creation, leader_id, practice_website,
                       date_of_granted_access, access_granted_by, access_granted, price)
values
    ('Jan', 'Kowalski', 'jasiek@gmail.com', current_date, 1, 'http://www.xd.pl',
     '2023-11-27', 'Piter Blozinski', true, 300),
    ('Radek', 'Lyda', 'radol3@gmail.com', current_date, 1, 'http://www.xd.pl',
     '2023-11-27', 'Piter Blozinski', true, 300),
    ('Adam', 'Ignacy', 'adamcy2@gmail.com', current_date, 2, 'http://www.xd.pl',
     '2023-11-28', 'Piter Blozinski', true, 300),
    ('Piotr', 'Zyla', 'piotrek991@gmail.com', current_date, 1, 'http://www.xd.pl',
     '2023-11-29', 'Piter Blozinski', true, 300),
    ('Radek', 'Slodkiewicz', 'radzio12@gmail.com', current_date, 3, 'http://www.xd.pl',
     '2023-12-03', 'Piter Blozinski', true, 300),
    ('Lukasz', 'Zieminski', 'luki5@gmail.com', current_date, 4, 'http://www.xd.pl',
     '2023-12-05', 'Piter Blozinski', true, 300),
    ('Rafal', 'Podolewski', 'rafi325@gmail.com', current_date, 4, 'http://www.xd.pl',
    '2023-12-09', 'Piter Blozinski', true, 300);


-- insert into leaders(first_name, last_name, customer_id)
--     values ('Jasiek','Wawrzon', 1);