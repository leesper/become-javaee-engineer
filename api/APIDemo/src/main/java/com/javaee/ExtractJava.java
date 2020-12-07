package com.javaee;

import java.util.Arrays;

public class ExtractJava {
    public static void main(String[] args) {
        String[] strs = {"kkbJava","asdjavaccc","Jaasdhva","siaiq","javacjavaz","iloveJava"};
        String[] deleteArr = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].toLowerCase().contains("java")) {
                deleteArr[i] = strs[i]
                        .toLowerCase()
                        .replace("java", "")
                        .toUpperCase();
            } else {
                deleteArr[i] = strs[i].toUpperCase();
            }
        }

        System.out.println(Arrays.toString(deleteArr));
    }
}
