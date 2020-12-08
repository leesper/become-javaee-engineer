package com.javaee;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollBook {
    public static void main(String[] args) {
        Collection<String> books = new LinkedList<String>();
        books.add("JavaEE企业级开发指南");
        books.add("Oracle高级编程");
        books.add("MySQL从入门到精通");
        books.add("Java架构师之路");

        System.out.println("All books: ");
        Iterator<String> iter = books.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("Books with title < 10: ");
        iter = books.iterator();
        while (iter.hasNext()) {
            String bookName = iter.next();
            if (bookName.length() < 10) {
                System.out.println();
            }
        }

        System.out.println("Books with title Java: ");
        iter = books.iterator();
        while (iter.hasNext()) {
            String bookName = iter.next();
            if (bookName.contains("Java")) {
                System.out.println(bookName);
            }
        }

        System.out.println("Books without Oracle: ");
        iter = books.iterator();
        while (iter.hasNext()) {
            String bookName = iter.next();
            if (!bookName.contains("Oracle")) {
                System.out.println(bookName);
            }
        }
    }
}
