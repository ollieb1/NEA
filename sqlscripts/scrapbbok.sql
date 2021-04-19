use bond_app;

INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

select * from role;
select * from user;
select * from user_role;

update role set name = 'ROLE_USER' where id = 1;

select * from curve_point;

delete from curve where id < 100;

select * from curve inner join curve_point on curve.id = curve_point.curve_id;

select * from bond;

insert into bond values
(1, sysdate(),sysdate(),1,1,0.01,'GBP',0,2,'TEST','2017-06-15','2017-06-15',null,null);

insert into bond values
(1, sysdate(),sysdate(),1,1,0.01,'GBP',0,2,'TEST','2017-06-15','2017-06-15',null,null);


delete from curve_point where curve_point.curve_id < 10;

delete from curve where id = 4;

insert into user_role values (1,2);