# 常用类库API

请先研究文末的“练习题”，包括它的出题范围和思路，去分析学习时应该怎样回忆知识点、怎样运用知识点并将它们串起来，做到即学即用、即用即学。

## 知识点

* String类，字符串比较用==和equals()的区别，常用字符串处理方法
* Object类，toString()、hashCode()和equals()方法重写
* 处理时间和日期相关类：Date、DateFormat（SimpleDateFormat）、Calendar
* 基本类型包装类、装箱和拆箱
* StringBuilder、System、Arrays和Math类的使用

## 练习题

1. 选择题

（1）`Calendar cal = Calendar.getInstance();`

下面代码中获取月份的代码是（ B）

A： int year = cal.get(Calendar.YEAR);

B： int month = cal.get(Calendar.MONTH) + 1; 

C： int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 

D： System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); 

2. 下列代码用于解析两个字符串形式的时间

```java
String date1 = "2001年1月1日";
String date2 = "2001年1月3日";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
Date parse1 = sdf.parse(date1);
Date parse2 = sdf.parse(date2);
long time = parse1.getTime() - parse2.getTime();
System.out.println(time / 1000 /3600 /24);
```

有关程序的运行结果描述正确的是（B）

A： 输出结果为：3

B： 输出结果为：2

C： 程序报错

D： 输出结果为-2。 

3. 代码如下：

```java
SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日");

String str = _______________________________

System.out.println(str);
```

在横线处填写以下哪个选项能够正确打印当前时间（B） 

 A： sd.format(new Date());  

 B： sd.parse(new Date());  

 C： sd.parse();   

 D： sd.format();  

4. 以下关于Object类说法正确的是（BD）(多选题)

A： Object类中equals()方法比较的是对象的地址值

B： Object类是所有类的父类

C： Object类的toString()方法会显示其子类的属性值 

D： Object类的equals()和toString()可以被自定义类重写。  

5. 以下关于toString()方法、equals()方法说法正确的是？（ D）

 A： 重写Object类的toString()方法是为了方便打印对象的地址值。   

 B： 重写Object类的equals()方法是为了比较对象的地址值。   

 C： 未重写Object类的equals()方法默认是比较对象中的属性值。   

 D： 重写Object类的toString()方法是方便打印对象中的属性值 。 

6. 编程题

 （1）题目一：某公司人事举办了这样一个活动，凡是入职6周年的员工，赠送一个精美小礼品，于是员工纷纷去计算了自己的入职年限，请设计程序，帮同事们计算出入职年限。要求：输入格式为“xxxx年xx月xx日”的日期，获得距离当前时间有多少年。

 训练提示：

* 按照指定的格式将输入的日期转换成Date对象

* 获取Date对象对应的毫秒值

* 获取当前系统毫秒值,然后两个毫秒值相减

参考方案

* 利用SimpleDateFormat中的parse方法将输入的日期转成Date对象

* 调用Date中getTime方法获取对应的毫秒值
* 调用System中的currentTimeMillis()方法获取当前系统毫秒值
* 两个毫秒值相减的出结果,再使用结果/ 1000 / 60 / 60 / 24得出天数,用天数除以365

操作步骤

* 接受键盘录入的入职日期字符串

* 将日期字符串转换为日期对象，方便获取毫秒值

* 获取入职日期的毫秒值

* 获取当前系统的毫秒值

* 计算时间差

* 将单位换算成天

* 将天换算成年，并打印 

你的代码（请编写代码及附上运行截图）

（2）题目二：有字符串数组`String [] strs = {"kkbJava","asdjavaccc","Jaasdhva","siaiq","javacjavaz","iloveJava"}`，需求：

* 如果数组元素的字符串中包含java(不区分大小写)，删除java单词，并把数组中该字符串剩下的字母全部转成大写。

* 控制台输出按要求修改后的数组元素。

操作后的效果如下:

`String [] deleteArr = {"KKB","ASDCCC","JAASDHVA","SIAIQ","CZ","ILOVE"}`

训练提示：

* 字符串判断包含的方法为contains

* 删除可以考虑字符串的replace方法

* 输出数组可以使用Arrays.toString(*)

 你的代码（请编写代码并附上正确的运行截图） 