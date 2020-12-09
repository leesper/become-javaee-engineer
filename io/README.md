# IO流

## 知识点

## 练习题

选择题

 （1）观察以下代码,如果创建Person对象,下列哪种处理是正确的：（CD）

 ```java
//观察以下代码
public class WeightOutOfBoundsException extends Exception {
  public WeightOutOfBoundsException(){}
	public WeightOutOfBoundsException(String message){
		super(message);  
  }
}

public class Person{
	private int weight;
	public Person(int weight) throws WeightOutOfBoundsException {
    if(weight < 0 || weight > 300) {
      throw new WeightOutOfBoundsException("体重不符合要求");
    }
    this.weight = weight;
  }
}
 ```

A：直接 Person person = new Person();

B：直接 Person person = new Person(70);

C：只能将 Person person = new Person(70); 只能用 try-catch语句处理一下才可以 

D：可以在创建person对象的方法上,用throws关键字将WeightOutOfBoundsException这个异常声明出来

2. 编程题

（1）有个tangshi.txt文件,该文件中保存了一首古诗词,但是每行的顺序被颠倒的,每行的字符也是被颠倒的,利用IO技术,恢复古诗词的顺序。演示效果如下图：

.乡故思头低

,月明望头举

.霜上地是疑

,光月明前床

（2）拷贝一张图片，从一个目录复制到另外一个目录下

3. 选择题

 （1）能指定字符编码的I/O流是：多选（）

A：Reader

B：InputStreamReader 

C：OutputStreamWriter

D：BufferedReader

（2）下面哪个方法可以刷新 流的缓冲?()

A：void release()

B：void close()

C：void remove()

D：void flush()

4. 看程序写结果

（1）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

```java
class IOTest {
  public static void main (String[] args) throws IOException {
    write();
    read();
  }
  
	public static void write() throws IOException {
    FileWriter fw = new FileWriter(""d:\\fw.txt"");
    fw.write( ""hello"" );
  }
  public static void read() throws IOException {
    FileReader fr = new FileReader(""d:\\fw.txt"");
    int ch = -1;
    while ( (ch = fr.read()) != -1 ) {
      System.out.print( (char)ch );
    }
  }
}
```

（2）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

 ```java
class IOTest {
  public static void main (String[] args) throws IOException {
    write();
		read();
  }
  public static void write() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(""d:\\bw.txt"") );
    bw.write(""hello"");
    bw.newLine();
    bw.flush();
    bw.close();
  }
	public static void read() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(""d:\\bw.txt""));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.print( line );
    }
    br.close();
  }
}
 ```

（3）给出以下代码，请问该程序的运行结果是什么？如有问题，请说明原因。

 ```java
class Test {
  public static void main(String[] args) throws IOException {
    write();
    write();
    read();
  }
  
	public static void write() throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream(""d:\\file.txt"", true));
    pw.println(""你好"");
    pw.close();
  }
  public static void read() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(""d:\\file.txt""));
		String line = null;
		while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
  }
}
 ```