package com.javaee;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaDemo {
    interface IntInfo {
        public int add(int x, int y);
    }

    static class Human {
        String name;

        public Human() {}

        public Human(String name) {
            this.name = name;
        }

        public static String getNationality() {
            return "中国";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class User {
        private String name;
        private int age;
        private String sex;

        public User(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }

    public static void basicLambdaDemo() {
        // bind interface with lambda expression
        IntInfo f1 = (int a, int b) -> a + b;
        System.out.println(f1.add(1, 2));

        /* functional programming interfaces
        Supplier<T>: returns a T value without input
        Consumer<T>: accepts a T parameter and returns nothing
        Function<T, R>: accepts a T parameter and returns a R value
        Predicate<T>: accepts a T parameter and returns true/false
        * */
        Supplier<Integer> supplier = () -> 10 * 10;
        System.out.println(supplier.get());

        Supplier<Human> userSupplier = () -> new Human("Linus");
        System.out.println(userSupplier.get().toString());

        Consumer<Integer> cus1 = x -> System.out.println(x * 100);
        cus1.accept(15);
        Consumer<Integer> cus2 = y -> System.out.println(y * y);
        cus1.andThen(cus2).accept(12);

        Function<String, String> fun1 = str -> str + "Hello";
        Function<String, String> fun2 = str -> str + "你好";

        String s1 = fun1.compose(fun2).apply("张飞");
        String s2 = fun1.andThen(fun2).apply("赵云");
        System.out.println(s1);
        System.out.println(s2);

        Predicate<String> pre1 = s -> "hello".equals(s);
        System.out.println(pre1.test("hello"));
        System.out.println(pre1.negate().test("hello"));

        Predicate<String> pre2 = s -> s.length() > 4;
        System.out.println(pre1.or(pre2).test("hello1"));
        System.out.println(pre1.and(pre2).test("hello1"));
    }

    public static void streamDemo() {
        // source --> transforming --> operations
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream()
                .filter(s -> s > 3)
                .forEach(x -> System.out.println(Thread.currentThread().getName() + "\t" + x));

        System.out.println("------------");

        list1.parallelStream()
                .filter(s -> s <= 3)
                .forEach(x -> System.out.println(Thread.currentThread().getName() + "\t" + x));

    }

    public static void methodRefDemo() {
        Human human = new Human("赵云");

        Function<Human, String> func1 = Human::getName;
        System.out.println(func1.apply(human));

        Supplier<Human> supplier1 = Human::new;
        System.out.println(supplier1.get() instanceof Human);

        Supplier<String> supplier2 = Human::getNationality;
        System.out.println(supplier2.get());

        Function<String, Human> func2 = Human::new;
        System.out.println(func2.apply("关羽").getName());

        Function<Integer, Integer[]> func3 = x -> new Integer[]{x};
        System.out.println(func3.apply(4).length);

        Function<Integer, Integer[]> func4 = Integer[]::new;
        System.out.println(func4.apply(4).length);
    }

    public static void advancedLambdaDemo() {
        // using lambda in collectors
        List<User> userList = new ArrayList<>();
        userList.add(new User("赵云", 23, "男"));
        userList.add(new User("张飞", 24, "男"));
        userList.add(new User("吕布", 22, "男"));
        userList.add(new User("貂蝉", 18, "女"));
        userList.add(new User("王昭君", 20, "女"));
        userList.add(new User("西施", 16, "女"));

        Map<String, User> userMap = userList.stream()
                .collect(Collectors.toMap(User::getName, u -> u, (u1, u2) -> u1));
        System.out.println(userMap);

        Map<String, List<User>> groupBy = userList.stream()
                .collect(Collectors.groupingBy(User::getSex));
        System.out.println(groupBy);

        List<User> filterList = userList
                .stream()
                .filter(u -> u.getSex().equals("男"))
                .collect(Collectors.toList());
        System.out.println(filterList);

        int totalAge = userList
                .stream()
                .filter(u -> u.getSex().equals("女"))
                .mapToInt(User::getAge)
                .sum();
        System.out.println(totalAge);

        // using lambda in runnable
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        for (int i = 0; i < 100; i ++) {
            Thread t = new Thread(r);
            t.start();
        }
    }

    public static void main(String[] args) {
        basicLambdaDemo();
        streamDemo();
        methodRefDemo();
        advancedLambdaDemo();
    }
}
