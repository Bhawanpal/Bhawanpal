drop database if exists employee_db;
create database employee_db;
use  employee_db;


create table employee(
   employee_id int auto_increment,
   employee_email varchar(50),
   employee_name varchar(20),
   employee_dob date,
   constraint ps_employee_id_pk primary key (employee_id)
);


insert into employee (employee_id,employee_email ,employee_name, employee_dob) values (1, 'martin@infy.com', 'Martin', sysdate()- interval 9000 day);
insert into employee (employee_id,employee_email, employee_name, employee_dob) values (2, 'tim@infy.com', 'Tim', sysdate()- interval 5000 day);
insert into employee (employee_id,employee_email, employee_name, employee_dob) values (3, 'jack@infy.com', 'Jack', sysdate()- interval 6000 day);

commit;
select * from employee;