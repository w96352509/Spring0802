--建立web資料庫
create database web character set utf8mb4 collate utf8mb4_general_ci

-- 建立 Emp 資料表
create table emp(
	eid int not null auto_increment, -- 主鍵
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key(eid)
);
