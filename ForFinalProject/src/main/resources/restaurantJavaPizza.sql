create database restaurant_javapizza;

create table restaurant_info(
id int not null primary key,
name text not null,
address text not null,
mode text not null,
phone text not null,
e_mail text not null
);

insert into restaurant_info (id, name, address, mode, phone, e_mail) values 
			    (1, 'Java_Pazza', 'Kharkiv, Spring str. 13', 'from 10 a.m. till 10 p.m.', '0671234567', 'java_pizza@gmail.com');

select * from restaurant_info;

create table menu(
id int not null primary key,
name text,
weight int,
price real
);

insert into menu (id, name, weight, price) values (1, 'margharita', 400, 55);
insert into menu (id, name, weight, price) values (2, 'pepperoni', 350, 70);

select * from menu;

create table ingredient(
id int not null primary key,
name text not null
);

insert into ingredient (id, name) values (1, 'dough');
insert into ingredient (id, name) values (2, 'tomato');
insert into ingredient (id, name) values (3, 'beef');
insert into ingredient (id, name) values (4, 'pork');
insert into ingredient (id, name) values (5, 'cheese');
insert into ingredient (id, name) values (6, 'oregano');

select * from ingredient;

create table list_of_ingredients(
menu_pizza_id int references menu(id),
ingredient_id int references ingredient(id)
);

insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (1, 1);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (1, 2);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (1, 5);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (1, 6);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 1);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 2);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 3);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 4);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 5);
insert into list_of_ingredients (menu_pizza_id, ingredient_id) values (2, 6);

select * from list_of_ingredients;

create table post(
id int primary key,
name text not null
);

insert into post values (1, 'administrator');
insert into post values (2, 'cook');
insert into post values (3, 'waiter');

select * from post;

create table employee(
id int primary key,
first_name text not null,
post_id int references post(id)
);

insert into employee (id, first_name, post_id) values (1, 'Kate', 1);
insert into employee (id, first_name, post_id) values (2, 'Rita', 2);
insert into employee (id, first_name, post_id) values (3, 'Stasy', 2);
insert into employee (id, first_name, post_id) values (4, 'Egor', 3);
insert into employee (id, first_name, post_id) values (5, 'Kirill', 3);

select * from employee;

create table order_new(
id int primary key,
employee_id int references employee(id),
menu_id int references menu(id),
table_number int not null,
date date not null
);

insert into order_new (id, employee_id, menu_id, table_number, date) values (1, 4, 1, 5, '2016-11-08');
insert into order_new (id, employee_id, menu_id, table_number, date) values (2, 5, 1, 6, '2016-11-08');
insert into order_new (id, employee_id, menu_id, table_number, date) values (3, 4, 2, 8, '2016-11-08');
insert into order_new (id, employee_id, menu_id, table_number, date) values (4, 1, 1, 3, '2016-11-09');

select * from order_new;

create table stock(
id int not null primary key,
ingredient_id int references ingredient(id),
amount int not null
);

insert into stock (id, ingredient_id, amount) values (1, 1, 5850);
insert into stock (id, ingredient_id, amount) values (2, 2, 2080);
insert into stock (id, ingredient_id, amount) values (3, 3, 1560);
insert into stock (id, ingredient_id, amount) values (4, 4, 990);
insert into stock (id, ingredient_id, amount) values (5, 5, 2845);
insert into stock (id, ingredient_id, amount) values (6, 6, 375);

select * from stock;

commit;