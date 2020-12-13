# MySQL

## 知识点

## 练习题

1. 谈谈你对数据库的理解，他的用途。（用个人话述来说）

2. Mysql 基本数据类型有哪些，大致可以分为哪几类。

3. 如何创建数据库，选择数据库，删除数据库

你的sql语句

4. 创建数据表，删除数据表。

你的sql语句

5. 按照以下要求创建或修改数据库和表

（1）创建数据库 test_xxx (xxx 表示姓名)

你的sql语句

（2）参考以下表格创建表结构（表名tb_user）

列名 类型 备注

id INT 编号

username VARCHAR(32) 用户名

phone VARCHAR(13) 电话号码

word VARCHAR(20) 职业

password VARCHAR(200) 密码

birthday DATETIME 出生日期

age INT 年龄

register_time TIMESTAMP 注册时间

status INT 状态（1 或者 0）

你的sql语句

（3）根据提示修改表结构

提示：

* 在表中新增字段 realName （真实姓名），类型 VARCHAR ，长度20
* 在表中新增字段 sex （性别），类型 INT ， 性别一般存 1，或者0 即可
* 删除表中的年龄字段（age）

你的sql语句

6. 按照以下要求对数据进行操作

（1）在tb_user 中添加数据：在表中最少添加5条以上的数据（信息可以是明星、 医生和自己的信息）

备注：为了方便练习，可以设置一些null值 ，例如生日，职业，在编写sql语句时可以指定列插入数据

（2）修改明星的信息为“李兰娟”的信息

你的代码

（3）查询出所有医生

你的代码

（4）查询年龄大于40的用户信息

你的代码

（5）查询所有的职业且去重

你的代码

（6）查询出生日期为null的信息

你的代码

（7）删除所有的网红信息

你的代码

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
);

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
);

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
);

/*==============================================================*/
/* Table: tb_teacher                      */
/*==============================================================*/

create table tb_teacher(
  id          int not null auto_increment,
  name         varchar(20),
  sex         varchar(6),
  primary key (id)
);

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

（2）查询西施选修的课程

（3）查询杨玉环所有选修课程的总分

（4）查询每个学生选修的课程总分（没有选修课程的学生也要显示）

（5）查询选修了数学的所有学生信息

（6）查询平均成绩不及格的学生信息

（7）查询各科的平均分数

（8）查询没有报李老师课的学生姓名

（9）查询每科选修的学生个数（显示科目和学生个数）