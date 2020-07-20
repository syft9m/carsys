create table car(
                    id int primary key,
                    brand varchar(255) NOT  NULL,
                    type varchar(255) NOT NULL,
                    price float
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into car (id,brand, type, price) values
                    (1,'奔驰','轿车',1000000),
                    (2,'宝马','轿车',100000),
                    (3,'奥迪','轿车',100000),
                    (4,'大众','轿车',50000),
                    (5,'奥迪Q3','SUV',250000),
                    (6,'本田','轿车',80000),
                    (7,'奔驰','SUV',750000),
                    (8,'宝马','SUV',380000);


create table car_accessories(id int primary key,brand varchar(255),accessories_name varchar(255),availability boolean,price float);

INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (1, '奔驰', '发动机', true, 100000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (2, '奔驰', '轮胎', false, 10000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (3, '宝马', '发动机', true, 10000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (4, '宝马', '轮胎', true, 15000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (5, '奥迪', '发动机', false, 7800);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (6, '奥迪', '轮胎', false, 1800);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (7, '大众', '发动机', true, 900);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (8, '大众', '轮胎', true, 800);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (9, '本田', '发动机', true, 1500);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (10, '本田', '轮胎', true, 9000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (11, '现代', '发动机', true, 1600);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (12, '现代', '轮胎', false, 750);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (13, '吉利', '发动机', true, 1500);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (14, '吉利', '轮胎', false, 500);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (15, '长城', '发动机', true, 1500);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (16, '长城', '轮胎', true, 450);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (17, '东风日产', '发动机', true, 1500);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (18, '东风日产', '轮胎', true, 900);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (19, '特斯拉', '发动机', true, 150000);
INSERT INTO public.car_accessories (id, brand, accessories_name, availability, price) VALUES (20, '特斯拉', '轮胎', true, 100000);

create table car_maintenance(id int primary key,appointmentTime varchar2(30),isVip varchar2(1),name varchar2(255),phone varchar2(25),carNo varchar2(50) );
insert into car_maintenance(id,appointmenttime,isvip,name,phone,carno) values(3,'2020-08-02 12:00:00','N','wangwu','1234569999','111111');