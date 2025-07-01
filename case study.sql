create database financeManagement;
use financeManagement;
create table users(
user_id int primary key,
username varchar(255),
password varchar(255),
email varchar(255)
);
create table expenses(
expense_id int primary key,
user_id int,
foreign key(user_id) references users(user_id) on delete cascade,
amount int,
date date,
description varchar(255)
);
create table expensecategories(
category_id int primary key,
category_name varchar(255)
);
alter table expenses add category_id int;
alter table expenses add constraint ck foreign key(category_id) references expensecategories(category_id) on delete cascade;
insert into users (user_id, username, password, email) VALUES
(1, 'john_doe', 'pass123', 'john@example.com'),
(2, 'jane_smith', 'qwerty456', 'jane@example.com'),
(3, 'mike_ross', 'mikepass', 'mike@example.com'),
(4, 'rachel_green', 'green123', 'rachel@example.com'),
(5, 'harvey_specter', 'suitup', 'harvey@example.com');
select * from users;

insert into expensecategories (category_id, category_name) VALUES
(1, 'Food'),
(2, 'Transport'),
(3, 'Utilities'),
(4, 'Entertainment'),
(5, 'Healthcare');


insert into expenses (expense_id, user_id, amount, date, description, category_id) VALUES
(101, 1, 500, '2025-06-01', 'Grocery shopping', 1),
(102, 2, 200, '2025-06-05', 'Bus ticket', 2),
(103, 3, 1500, '2025-06-10', 'Electricity bill', 3),
(104, 4, 800, '2025-06-15', 'Movie night', 4),
(105, 5, 1200, '2025-06-20', 'Doctor appointment', 5);
update expenses set amount=20000,date='2025-08-29',description='concert',category_id='3'where user_id=2;
select * from expenses;
select * from users;
select * from expensecategories;
select * from expenses where user_id=100 and date between '2020-06-01' and '2025-06-30';
Delete from expenses where expense_id = 101;
Delete from users where user_id = 1;