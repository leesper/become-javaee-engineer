# 集合

## 知识点

* Collection集合类、继承体系、接口方法
* 迭代器Iterator和Iterable接口，foreach循环
* 栈、队列、链表等数据结构
* List接口与ArrayList和LinkedList
* 定义泛型类型、接口和方法，泛型通配符
* Set、HashSet和LinkedHashSet的区别
* Map、HashMap和LinkedHashMap的区别
* 可变参数及其应用

## 练习题

1. 选择题

 （1）Collection接口contains方法正确的是？多选（BC）。

 A: 对比集合泛型为String类型的，需要重写String的equals和hashCode方法

 B: 对比集合泛型为String类型的，不需要重写String的equals和hashCode方法

 C: 对比集合泛型为自定义实体类的，需要重写实体类的equals和hashCode方法

 D: 对比集合泛型为自定义实体类的，不需要重写实体类的equals和hashCode方法

 （2）数组和链表说法正确的是？多选（AD）

A: 数组查询快

B: 链表查询快 

C: 数组增删改快 

D: 链表增删改快

2. 编程题

（1）请定义一个Collection类型的集合，存储以下字符串：“JavaEE企业级开发指南”，”Oracle高级编程”，”MySQL从入门到精通”， ”Java架构师之路”，编程实现以下功能：

使用迭代器遍历所有元素，并打印

使用迭代器遍历所有元素，筛选书名小于10个字符的，并打印；

使用迭代器遍历所有元素，筛选书名中包含“Java”的，并打印

如果书名中包含“Oracle”，则删掉此书。删掉后，遍历集合，打印所有书名。

注意：以上功能写在一个main()方法中，但请单独实现

你的答案（请编写代码并附上正确的运行截图）

（2）请定义一个Collection类型的集合，存储以下分数信息：88.5,39.2,77.1,56.8,89,99,59.5。编程实现以下功能：

* 使用增强for遍历所有元素，并打印
* 使用增强for遍历所有元素，打印不及格的分数；
* 使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果。
* 使用增强for遍历所有元素，求出最高分，并打印；

注意：以上所有功能写在一个main()方法中，但请单独实现

你的答案（请编写代码并附上正确的运行截图）

（3）有以下类结构：

   人员类(Person)：

​    |--学生类(Student)

​    	|--Java学生类(JavaStudent)

​    	|--UI学生类(UIStudent)

​    |--教师类(Teacher)

​    	|--Java教师类(JavaTeacher)

​    	|--UI教师类(UITeacher)

要求：

* 请按上述要求定义类，并实现继承关系即可（不需要定义类成员）
* 请按以下格式和要求定义测试类和方法：

```java
 public class Test4_1{
   public static void main(String[] args){
     ArrayList<String> list1 = new ArrayList<>();
     ArrayList<Person> list2 = new ArrayList<>();
     ArrayList<Student> list3 = new ArrayList<>();
     ArrayList<JavaStudent> list4 = new ArrayList<>();
     ArrayList<UIStudent> list5 = new ArrayList<>();
     ArrayList<Teacher> list6 = new ArrayList<>();
     ArrayList<JavaTeacher> list7 = new ArrayList<>();
     ArrayList<UITeacher> list8 = new ArrayList<>();
   }
  //要求：参数可以接收任何泛型的ArrayList参数
	public static void print1(ArrayList<______________> list){}

  //要求：参数可以接收任何Person及其子类泛型的ArrayList参数
  public static void print2(ArrayList<______________> list){}
	
  //要求：参数可以接收任何Student及其子类泛型的ArrayList参数
	public static void print3(ArrayList<______________> list){}

  //要求：参数可以接收任何Java学员，及其父类泛型的ArrayList参数
   public static void print4(ArrayList<______________> list){}
 }
```

* 请问哪些集合可以调用print1()方法

list1-8

* 请问哪些集合可以调用print2()方法

list2-8

* 请问哪些集合可以调用print3()方法

list3-5

* 请问哪些集合可以调用print4()方法

list2-4

3. 下面代码运行结果是？（C）

 ```java
HashSet<String> set = new HashSet<String>();
set.add("cba");
set.add("abc");
set.add("bac"); 
set.add("cba"); 
for (int i = 0; i < set.size(); i++) {
  System.out.println(set.get(i));
}
 ```

A：abc--abc--bac--cba

B：abc--bac--cba

C：编译出错

D：abc

4. Student类中自动生成了hashCode()和equals()方法，输出结果是？（B）

 ```java
//观察下列代码
HashSet<Student> hs = new HashSet<Student>();
Student s1 = new Student("张三", 18);
Student s2 = new Student("李四", 18);
Student s3 = new Student("张三", 20);
Student s4 = new Student("李四", 18);
hs.add(s1);
hs.add(s2);
hs.add(s3);
hs.add(s4);
for (Student s : hs) {
  System.out.println(s.getName() + --- + s.getAge());
}
 ```

A：李四---18，张三---20

B：李四---18，张三---20，张三---18

C：李四---18，张三---18，李四---18，张三---20

D：李四---18，张三---18

5. User类中自动生成了hashCode()和equals()方法，输出结果是？（B）

 ```java
HashSet<User> set = new HashSet<User>();
set.add(new User("杰克", 18));
set.add(new User("肉丝", 17));
set.add(new User("杰克", 19));
set.add(new User("肉丝", 16));
int sum =0;
for (User u : set) {
	sum += u.getAge();
}
System.out.println(sum/set.size());
 ```

A：16 

B：17

C：18 

D：19

6. 请问，输出的结果是? （ B）

 ```java
//观察下列代码
HashMap<String, Integer> map = new HashMap<>();
map.put("张三", 18);
map.put("李四", 20);
map.put("张三", 20);
System.out.println(map.get("张三"));
 ```

A：张三:18

B： 20

C：18

D： 张三:20 李四:20

7. 编程题

（1）请编写main()方法，按以下要求定义一个Set集合，并存储以下数据：刘备，关羽，张飞，刘备，张飞，然后：

* 打印集合大小

* 使用迭代器遍历集合，并打印每个元素

* 使用增强for遍历集合，并打印每个元素

（2）请按以下要求顺序编码：

* 定义学生类Student，属性：姓名、性别、年龄

* 定义测试类，及main()方法

* 定义一个存储Student类型的集合

* 创建以下三个Student对象
  * 张三,男,20
  * 李四,女,21
  * 张三,男,20

* 将上述三个对象存储到集合中, 请实现集合中不能存储姓名年龄相同的元素

* 使用增强for遍历集合，获取每个Student对象，并打印属性值；

（3） 有以下字符串：`String str = “fjekwFDQFjfeAFEajfeo2FAFEjfew”;`，请编程统计每个字符出现的次数,并打印出来

 

 

 

