CREATE DATABASE Restaurant;

CREATE TABLE POSITION(
  id int primary key,
  name text not null
);

insert into POSITION values (1, 'administrator');
insert into POSITION values (2, 'cook');
insert into POSITION values (3, 'waiter');
insert into POSITION values (4, 'cleaner');

CREATE TABLE EMPLOYEE(
  id int primary key,
  first_name text not null,
  last_name text not null,
  date_of_birth date not null,
  phone_number text,
  salary real,
  position_id int REFERENCES POSITION(id)
);

insert into EMPLOYEE values (1, 'Avramenko', 'Max', '1992-09-24', '0971327892', 5000.0, 3);
insert into EMPLOYEE values (2, 'Romanenko', 'Kate', '1979-02-01', '0667891583', 8200.0, 1);
insert into EMPLOYEE values (3, 'Khutorniy', 'Alex', '1983-08-19', '0668452974', 4800.0, 3);
insert into EMPLOYEE values (4, 'Marchenko', 'Olga', '1993-05-15', '0668452974', 7500.0, 2);
insert into EMPLOYEE values (5, 'Pshenichnaya', 'Nastya', '1992-12-28', '0661876589', 6300.0, 3);
insert into EMPLOYEE values (6, 'Trofimenko', 'Dasha', '1993-02-17', '0638974561', 6900.0, 2);
insert into EMPLOYEE values (7, 'Minattulayev', 'Pasha', '1989-05-20', '0970203125', 7500.0, 2);
insert into EMPLOYEE values (8, 'Marchenko', 'Yana', '1990-11-17', '0631231519', 4900.0, 4);

CREATE TABLE INGREDIENTS(
  id int primary key,
  name text not null
);

insert into INGREDIENTS values (1, 'egg');
insert into INGREDIENTS values (2, 'bread');
insert into INGREDIENTS values (3, 'fish');
insert into INGREDIENTS values (4, 'potato');
insert into INGREDIENTS values (5, 'basil');
insert into INGREDIENTS values (6, 'meat');
insert into INGREDIENTS values (7, 'tomato');
insert into INGREDIENTS values (8, 'cucumber');
insert into INGREDIENTS values (9, 'sausage');

CREATE TABLE LIST_OF_INGREDIENTS(
  id int primary key,
  ingredients_id_1 int,
  ingredients_id_2 int,
  ingredients_id_3 int,
  ingredients_id_4 int,
  ingredients_id_5 int,
  ingredients_id_6 int,
  ingredients_id_7 int,
  ingredients_id_8 int
);

insert into LIST_OF_INGREDIENTS values (1, 1, 6, 8);
insert into LIST_OF_INGREDIENTS values (2, 2, 5, 6);
insert into LIST_OF_INGREDIENTS values (3, 3, 6);
insert into LIST_OF_INGREDIENTS values (4, 4);
insert into LIST_OF_INGREDIENTS values (5, 5, 4);
insert into LIST_OF_INGREDIENTS values (6, 6, 7);

CREATE TABLE DISH(
  id int primary key,
  name text not null,
  list_of_ingredients_id int REFERENCES LIST_OF_INGREDIENTS(id),
  cost real not null,
  weight int
);

insert into DISH values (1, 'omelet', 1, 15, 200);
insert into DISH values (2, 'sandwich', 2, 17, 180);
insert into DISH values (3, 'fish', 3, 32, 250);
insert into DISH values (4, 'puree', 4, 20, 250);
insert into DISH values (5, 'steak', 5, 45, 320);
insert into DISH values (6, 'salad', 6, 18, 250);

CREATE TABLE LIST_OF_DISHES(
  id int primary key,
  dish_id_1 int,
  dish_id_2 int,
  dish_id_3 int,
  dish_id_4 int,
  dish_id_5 int,
  dish_id_6 int
);

insert into LIST_OF_DISHES values (1, 1, 2);
insert into LIST_OF_DISHES values (2, 3, 4, 6);
insert into LIST_OF_DISHES values (3, 3, 4, 5, 6);

CREATE TABLE MENU(
  id int primary key,
  name text not null,
  list_of_dishes_id int REFERENCES LIST_OF_DISHES(id)
);

insert into MENU values (1, 'breackfast', 1);
insert into MENU values (2, 'lunch', 2);
insert into MENU values (3, 'dinner', 3);

CREATE TABLE NEW_ORDER(
  id int primary key,
  employee_id int REFERENCES EMPLOYEE(id),
  list_of_dishes_id int REFERENCES LIST_OF_DISHES(id),
  table_number int not null,
  date date not null
);

insert into NEW_ORDER values (1, 3, 1, 12, '2016-10-20');
insert into NEW_ORDER values (2, 5, 1, 8, '2016-10-20');
insert into NEW_ORDER values (3, 1, 2, 10, '2016-10-20');
insert into NEW_ORDER values (4, 3, 2, 2, '2016-10-20');
insert into NEW_ORDER values (5, 1, 3, 3, '2016-10-20');

CREATE TABLE COOKED_DISHES(
  id int primary key,
  dish_id int REFERENCES DISH(id),
  employee_id int REFERENCES EMPLOYEE(id),
  new_order_id int REFERENCES NEW_ORDER(id),
  date date not null
);

insert into COOKED_DISHES values (1, 1, 4, 1, '2016-10-20');
insert into COOKED_DISHES values (2, 2, 6, 1, '2016-10-20');
insert into COOKED_DISHES values (3, 1, 4, 2, '2016-10-20');
insert into COOKED_DISHES values (4, 2, 6, 2, '2016-10-20');
insert into COOKED_DISHES values (5, 3, 4, 3, '2016-10-20');
insert into COOKED_DISHES values (6, 4, 6, 3, '2016-10-20');
insert into COOKED_DISHES values (7, 6, 6, 3, '2016-10-20');
insert into COOKED_DISHES values (8, 3, 4, 4, '2016-10-20');
insert into COOKED_DISHES values (9, 4, 7, 4, '2016-10-20');
insert into COOKED_DISHES values (10, 6, 6, 4, '2016-10-20');
insert into COOKED_DISHES values (11, 5, 7, 5, '2016-10-20');
insert into COOKED_DISHES values (12, 6, 6, 5, '2016-10-20');

CREATE TABLE STORAGE(
  id int not null primary key,
  ingredient_id int REFERENCES INGREDIENTS(id),
  amount int not null
);

insert into STORAGE values (1, 1, 50);
insert into STORAGE values (2, 2, 20);
insert into STORAGE values (3, 3, 35);
insert into STORAGE values (4, 4, 15);
insert into STORAGE values (5, 5, 80);
insert into STORAGE values (6, 6, 12);
insert into STORAGE values (7, 7, 61);
insert into STORAGE values (8, 8, 13);

commit;
