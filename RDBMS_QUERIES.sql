create database movies;
use movies;
create table employee 
(
id int, name varchar(30), dept varchar(30),salary float(10,4),age int
);

desc employee;
insert into employee values(1,'Nisha','hr',30000,20),
							(2,'Muskan','Manager',4000,18),
                            (3,'Alisha','Admin',90000,30),
                            (4,'Fareen','Technology',100000,45),
                            (5,'raj','tester',66600,80),
                            (6,'Mohan','tester',40002,28)
                            ;
select *from employee;
select id, name ,salary, salary+500 as bonus from employee;
select * from employee where salary >40000 and age<19;

select name from employee where dept = 'tester' ;
select name from employee where dept != 'tester' ;

select * from employee where salary between 40000 and 70000;

select id name,length(name),upper(name) from employee;  
/* scalar function different input for each row column*/  

select sum(salary) from employee;
/* Aggregate function one input for each row*/

update employee set salary = 48000 where id =6;

select dept,sum(salary) from employee group by dept;

select dept,sum(salary),count(id) from employee group by dept having count(id)>2 order by sum(salary);
rename table employee to employees;
alter table employees add column designation1 varchar(30);
alter table employees rename column dept to department;
update employee set designation ='trainer' where id=1;
desc employees;
alter table employees drop designation1;
alter table employees modify department varchar(20);
create table emp2(
id int primary key,
name varchar (30) not null,
age int check(age>20)
);
insert into emp2 values(1,'karan',23);
alter table emp2 add column contact_no varchar(10) unique;
alter table emp2 add column email varchar(10) unique;

create table dept (
id int primary key,
name varchar (30),
manager varchar (10));

insert into dept values(1,'hr','suresh');
create table emp5(
id int primary key,
name varchar(20),
salary int,
deptid int, constraint fk4 foreign key(deptid) references dept(id)
);

insert into emp5 values(1,'sumit',56000,1);
insert into emp5 values(101,'sumita',56000,1);
alter table emp5
add designation varchar(30) default 'branch';
insert into emp5 (id,name,salary,deptid) values (104,'raj',2000,1);
select * from emp5;

/*------Subqueries-----------*/
use movies;
select * from employees;
select salary from employees where name="Fareen";
select * from employees where salary and salary >6000 and salary >(select salary from employees where name="Fareen");
select * from employees where salary> any(select salary from employees where dep1='hr' );
select * from employees where salary> all(select salary from employees where dep1='hr' );
select * from employees where salary> (5000,70000 );

create database company;
use company;
create table bangloreoffice
(
id int, name varchar (30),
dept varchar (30)
);

create table chennaioffice
(
id int, name varchar(30),
dept varchar (30)
);
insert into bangloreoffice values (1,'Arjun','hr');
insert into bangloreoffice values (2,'Rahul','developer');
insert into bangloreoffice values (3,'Mahesh','developer');
insert into bangloreoffice values (4,'Nikita','hr');

insert into chennaioffice values (1,'Mohit','hr');
insert into chennaioffice values (2,'Rahul','developer');
insert into chennaioffice values (3,'Suraj','tester');
insert into chennaioffice values (4,'Nikita','hr');

desc bangloreoffice;

select * from bangloreoffice ;

select * from chennaioffice;
delete from chennaioffice where dept = 'tester';
delete from bangloreoffice where id = 3;


create table dept(
id int primary key,
name varchar(30),
manager varchar(30)
);


create table emp(
id int, name varchar (30),
designation varchar(30), deptid int ,
constraint pk2 primary key(id),
 constraint fk2 foreign key(deptid) references dept(id)
 );
 
 insert into dept values(100,'hr','Anand'),(101,'developer','krishna'),(102,'tester','rohit');
 insert into dept values(103,'technology','Rajan');
  insert into dept values(104,'learning','Rj');
 select * from dept;
 select * from emp;
 insert into emp values (1,'Sumit','trainee',100),(2,'Kiran','trainee',101),(3,'Manoj','trainee',100),(4,'raj','engineer',101),(5,'rashmi','trainee',102),(6,'bob','manager',102);
insert into emp  (id,name,designation) values(7,'harish','intern'),(8,'rajesh ','trainee');

 select * from dept d
 inner join
 emp e on d.id=e.deptid;
 
 select e.id,e.name,e.deptid,d.name,d.manager from emp e inner join dept d on e.deptid=d.id;
 
 select * from emp e inner join dept d on e.deptid = d.id;
 select * from emp e left join dept d on e.deptid = d.id;
 select * from emp e right join dept d on e.deptid = d.id order by d.manager;
 
 select current_date();
 select current_timestamp();
 
 alter table emp add column (doj date, dob datetime);
 update emp set doj = '2021-04-23', dob = '1999-11-30' where id>=3 and id<6;
 
 select id, name,doj,monthname(doj) from emp  where monthname( doj) ='April';
 select id, name ,doj, date_format(doj, '%M %D %Y') as dob from emp;
 