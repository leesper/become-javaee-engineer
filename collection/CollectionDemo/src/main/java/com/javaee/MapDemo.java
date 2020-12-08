package com.javaee;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        String str = "fjekwFDQFjfeAFEajfeo2FAFEjfew";

        Map<String, Integer> counter = new HashMap<>();
        for (String c : str.split("")) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        System.out.println(counter);
    }
}
