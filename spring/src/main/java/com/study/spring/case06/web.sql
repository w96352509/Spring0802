--建立web資料庫
create database web character set utf8mb4 collate
 utf8mb4_general_ci
-- 建立 Emp 資料表
create table emp(
	eid int not null auto_increment, -- 主鍵(自行產生序號)
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key(eid)
);
-- 建立 Emp 範例資料
insert into emp(ename ,age) value('john', 40);
insert into emp(ename ,age) value('Mary', 39);
insert into emp(ename ,age) value('bobo', 38);

--查詢emp資料
select eid,ename , age , createtime from emp ;