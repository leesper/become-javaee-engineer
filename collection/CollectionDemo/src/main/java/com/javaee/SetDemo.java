package com.javaee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> heroes = new HashSet<>();
        heroes.add("刘备");
        heroes.add("关羽");
        heroes.add("张飞");
        heroes.add("刘备");
        heroes.add("张飞");

        System.out.println("size: " + heroes.size());
        Iterator<String> iter = heroes.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (String hero : heroes) {
            System.out.println(hero);
        }
    }
}
