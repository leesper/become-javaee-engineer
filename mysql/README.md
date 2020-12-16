# MySQL

## 知识点

* DB和DBMS的概念
* MySQL数据库的安装和连接命令
* 图形化开发工具使用：Navicat、DataGrip
* SQL语句分类：DDL、DCL、DML和DQL
* DB中常用数据类型
* 数据库操作、表操作、增删改
* SQL建表的各种约束（主键、外键、唯一、非空、默认和自增）
* SQL查询（简单、条件、排序、聚合、分组+聚合、条数限制查询实现分页查询及计算公式）
* 表之间的关系（一对一、一对多和多对多），如何建模
* 多表关联查询和子查询，左连接、右连接和内连接查询的区别

## 练习题

1. 谈谈你对数据库的理解和用途

数据库分为两种，关系型数据库和NoSQL数据库，它们的共同点是以某种方式实现了对数据的管理。MySQL属于关系型数据库，是以关系代数为基础实现的，它将数据库组织成表，每张表由多个字段组成并相互关联，以建模现实世界中各业务要素之间的关联关系。

2. MySQL 基本数据类型有哪些，大致可以分为哪几类。

分为3类：数值类型、时间类型和字符串类型。数值类型包括int、double、decimal；时间类型包括date、datetime和timestamp；字符串类型char和varchar，后者为不定长类型。

3. 如何创建数据库，选择数据库，删除数据库

```sql
CREATE DATABASE db;
USE db;
DROP DATABASE db;
```

4. 创建数据表，删除数据表。

```sql
CREATE TABLE stu (
  id INT,
  name VARCHAR(256),
  age INT
);

DROP TABLE stu;
```

5. 按照以下要求创建或修改数据库和表

（1）创建数据库test_kkb

```sql
CREATE DATABASE test_kkb;
```

（2）参考以下表格创建表结构（表名tb_user）

列名 类型 备注

id INT 编号

username VARCHAR(32) 用户名

phone VARCHAR(13) 电话号码

job VARCHAR(20) 职业

password VARCHAR(200) 密码

birthday DATETIME 出生日期

age INT 年龄

register_time TIMESTAMP 注册时间

status INT 状态（1 或者 0）

```sql
CREATE TABLE tb_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32),
    phone VARCHAR(13),
    job VARCHAR(20),
    password VARCHAR(200),
    birthday DATETIME,
    age INT,
    register_time TIMESTAMP,
    status INT
);
```

（3）根据提示修改表结构

提示：

* 在表中新增字段 real_name （真实姓名），类型 VARCHAR ，长度20
* 在表中新增字段 sex （性别），类型 INT ， 性别一般存 1，或者0 即可
* 删除表中的年龄字段（age）

```sql
ALTER TABLE tb_user ADD `real_name` VARCHAR(20);
ALTER TABLE tb_user ADD `sex` INT;
ALTER TABLE tb_user DROP `age`;
```

6. 按照以下要求对数据进行操作

（1）在tb_user 中添加数据：在表中最少添加5条以上的数据（信息可以是明星、 医生和自己的信息）

备注：为了方便练习，可以设置一些null值 ，例如生日，职业，在编写sql语句时可以指定列插入数据

```sql
INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('Leesper', '123456', 'Programmer', '123456', '1987-11-11', 18);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('LiLanJuan', '123456', 'Doctor', '123456', '1978-11-11', 68);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('ZhongNanShan', '123456', 'Doctor', '123456', '1978-11-11', 58);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('ZhangWenHong', '123456', 'Doctor', '123456', '1979-11-11', 48);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('Linux Torvalds', '123456', 'Programmer', '123456', '1987-11-11', 38);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('Luoji', '123456', 'Professor', '123456', '1987-12-11', 32);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('YeWenJie', '123456', 'Scientist', '123456', NULL, 38);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('ZhangBeiHai', '123456', 'Political Commissar', '123456', NULL, 33);

INSERT INTO tb_user(username, phone, job, password, birthday, age)
VALUES ('LiZiQi', '123456', 'Actor', '123456', NULL, 25);
```

（2）修改明星的信息为“李兰娟”的信息

```sql
UPDATE tb_user SET `phone` = '987654321' WHERE `username` = 'LiLanJuan';
```

（3）查询出所有医生

```sql
SELECT * FROM tb_user WHERE job = 'Doctor';
```

（4）查询年龄大于40的用户信息

```sql
SELECT * FROM tb_user WHERE age > 40;
```

（5）查询所有的职业且去重

```sql
SELECT DISTINCT job FROM tb_user;
```

（6）查询出生日期为null的信息

```sql
SELECT * FROM tb_user WHERE birthday IS NULL;
```

（7）删除所有的网红信息

```sql
DELETE FROM tb_user WHERE job = 'Actor';
```

7. 执行以下sql语句完成以下练习

下面为sql语句

```sql
/*==============================================================*/
/* DBMS name:   MySQL 5.0                  */
/* Created on:   2020/4/30 10:47:01              */
/*==============================================================*/
drop table if exists tb_course;
drop table if exists tb_score;
drop table if exists tb_student;
drop table if exists tb_teacher;

/*==============================================================*/
/* Table: tb_course                       */
/*==============================================================*/

create table tb_course (
  id          int not null auto_increment,
  name         varchar(20),
  description     varchar(200),
  primary key (id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Table: tb_score                       */
/*==============================================================*/

create table tb_score (
  id          int not null auto_increment,
	stu_id        int,
	course_id      int,
	teacher_id      int,
	score        int,
	primary key (id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Table: tb_student                      */
/*==============================================================*/

create table tb_student (
  id          int not null auto_increment,
  name         varchar(20),
  sex         char(6),
  stu_num       varchar(20),
  age         int,
  primary key (id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Table: tb_teacher                      */
/*==============================================================*/

create table tb_teacher(
  id          int not null auto_increment,
  name         varchar(20),
  sex         varchar(6),
  primary key (id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

alter table tb_score add constraint FK_COURSE_SCORE foreign key (course_id) references tb_course (id) on delete restrict on update restrict;

alter table tb_score add constraint FK_STU_SCORE foreign key (stu_id) references tb_student (id) on delete restrict on update restrict;

alter table tb_score add constraint FK_Teacher_SCORE foreign key (teacher_id) references tb_teacher (id) on delete restrict on update restrict;
```

下面sql语句可以添加数据

```sql
insert into tb_course 
values
(null, "数学","数学"),
(null, "英语","英语"),
(null, "语文","语文"),
(null, "物理","物理"),
(null, "化学","化学"),
(null, "生物","生物");

insert into tb_teacher VALUES
(null, "石老师", "男"),
(null, "田老师", "女"),
(null, "杨老师", "男"),
(null, "张老师", "女"),
(null, "李老师", "男"),
(null, "马老师", "男");

insert into tb_student VALUES
(null, "刘备","男",1, 50),
(null, "关羽","男",2, 48),
(null, "张飞","男",3, 46),
(null, "貂蝉","女",4, 20),
(null, "杨玉环","女",5,24),
(null, "西施","女",6, 22),
(null, "如花","女",7, 18);

insert into tb_score VALUE
(null, 1, 1, 1 ,80),
(null, 1, 2, 3 ,60),
(null, 2, 1, 3 ,40),
(null, 3, 2, 2 ,70),
(null, 4, 5, 4 ,90),
(null, 3, 1, 1 ,100),
(null, 4, 1, 1 ,89),
(null, 1, 3, 3 ,99),
(null, 1, 4, 3 ,47),
(null, 5, 5, 5 ,90),
(null, 5, 2, 2 ,38),
(null, 6, 1, 4 ,100),
(null, 6, 4, 3 ,89),
(null, 6, 2, 3 ,88),
(null, 6, 4, 1 ,77);
```

编写以下sql语句

（1）查询李老师所教的课程

```sql
SELECT c.name, t.name
FROM tb_course c
JOIN tb_score s
ON c.id = s.course_id
JOIN tb_teacher t
ON t.id = s.teacher_id
WHERE t.name = '李老师';
```

（2）查询西施选修的课程

```sql
SELECT d.name, d.stu_num, c.name
FROM tb_student d
JOIN tb_score s
ON d.id = s.stu_id
JOIN tb_course c
ON c.id = s.course_id
WHERE d.name = '西施';
```

（3）查询杨玉环所有选修课程的总分

```sql
SELECT name, SUM(score) AS total FROM
(SELECT d.name, s.score
FROM tb_student d
LEFT JOIN tb_score s
ON d.id = s.stu_id
WHERE d.name = '杨玉环') t
```

（4）查询每个学生选修的课程总分（没有选修课程的学生也要显示）

```sql
SELECT name, SUM(score) AS total FROM
(SELECT d.name, s.score
FROM tb_student d
LEFT JOIN tb_score s
ON d.id = s.stu_id) t
GROUP BY name;
```

（5）查询选修了数学的所有学生信息

```sql
SELECT d.name, d.sex, d.stu_num, d.age
FROM tb_student d
JOIN tb_score s
ON d.id = s.stu_id
JOIN tb_course c
ON s.course_id = c.id
WHERE c.name = '数学';
```

（6）查询平均成绩不及格的学生信息

```sql
SELECT d.id, d.name, d.sex, d.stu_num, d.age, AVG(s.score) AS avg_score
FROM tb_student d
JOIN tb_score s
ON d.id = s.stu_id
GROUP BY d.id HAVING avg_score < 60;
```

（7）查询各科的平均分数

```sql
SELECT c.name, AVG(s.score) AS avg_score
FROM tb_course c
JOIN tb_score s
ON c.id = s.course_id
GROUP BY c.name;
```

（8）查询没有报李老师课的学生姓名

```sql
SELECT d.name
FROM tb_student d
JOIN tb_score s
ON d.id = s.stu_id
JOIN tb_course c
ON s.course_id = c.id
JOIN tb_teacher t
ON s.teacher_id = t.id
WHERE t.name != '李老师';
```

（9）查询每科选修的学生个数（显示科目和学生个数）

```sql
SELECT c.name, COUNT(d.id) AS stu_total
FROM tb_course c
JOIN tb_score s
ON c.id = s.course_id
JOIN tb_student d
ON d.id = s.stu_id
GROUP BY c.name;
```

