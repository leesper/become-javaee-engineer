# 多线程和网络编程

## 知识点

* 进程和线程的概念
* 线程的两种创建方式及其区别
* 网络编程基础知识
* TCP协议基本概念

## 练习题

1. 简答题

 （1）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

 ```java
class Test implements Runnable {
  public static void main (String[] args) {
    Thread t = new Thread(new Test());
    t.start();
  }
  public void run(int num) {
    for (int i =0; i < num; i++) {
      System.out.println( i );
    }
  }
} 
 ```

该程序有错误，首先它没有覆盖Runnable的run()方法，其次该方法不带参数。

（2）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

 ```java
class Test extends Thread {
  public static void main(String[] args) {
    Test t1 = new Test();
    Test t2 = new Test();
    t1.start();
    t2.start();
  }
  public void run() {
    System.out.println(1);
    yield();
    System.out.println(2);
  }
}
 ```

yield()会让掉当前正在使用的CPU时间片，使线程重新开始竞争，可能是原线程获取到，或者是被其他线程获取到。输出可能是：

* 1212
* 1122

（3）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

 ```java
class Test {
  public static void main (String[] args) {
    Thread t = new MyThread();
    t.displayOutput("t has been created");
    t.start();
  }
}

class MyThread extends Thread {
  public void run() {
    displayOutput("t is running");
  }
  public void displayOutput(String s) {
    System.out.println(s);
  }
}
 ```

输出：

t has been created

t is running

（4）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因

 ```java
class Test {
	public static void main (String[] args) {
    MyThread t1 = new MyThread("t1");
    MyThread t2 = new MyThread("t2");
    t1.start();
    t2.start();
  }
}

class MyThread extends Thread {
  public MyThread (String s) {
    super(s);
  }
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        sleep(1000);
      } catch (Exception e) {}
      System.out.println(getName());
    }
  }
}
 ```

间隔一秒交替打印线程名称。

2. 选择题

 （1）观察下列代码，最终结果是？（B）

 ```java
//客户端代码：
Socket s = new Socket(127.0.0.1, 10000);
OutputStream os = s.getOutputStream();
os.write("hello"，"TCP","我来了".getBytes());
s.close();

//服务端代码：
ServerSocket serverSocket = new ServerSocket(9999);
Socket socket = serverSocket.accept();
InputStream is = socket.getInputStream();
byte[] buf=new byte[1024];
int len=0;
while((len=is.read(buf))!=-1) {
  System.out.println(new String(buf,0,len));
}
 ```

A：hello，TCP，我来了

B：客户端报异常，java.net.ConnectException: Connection refused

C：报连接超时异常

D：没有输出任何内容

（2）下面不属于网络编程三要素的是？（ABC）

A：IP 地址

B：协议

C：端口号

D：项目名称

（3）下面说法正确的是？多选（AC）

A：TCP是面向连接的协议

B：TCP是无连接协议

C：TCP协议传输可靠性强

D：TCP协议传输可靠性弱