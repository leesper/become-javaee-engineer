# 异常

## 知识点

* 异常的概念和体系（Throwable、Error和Exception）
* Exception的分类，RuntimeException被Java自动抛出，可以不在定义方法时声明；其他都是“被检查的异常”，在编译期进行检查
* 异常的处理，要么再次抛出（throw），要么try-catch-finally进行处理；throws可以声明方法抛出哪些异常，子类继承时也必须遵守
* 使用Try-With-Resources处理各种混乱情况，比如（在特定时刻）清理资源

