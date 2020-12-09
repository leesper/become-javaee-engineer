package com.javaee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Poetry {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("tangshi.txt"));
            Stack<String> stack = new Stack<>();
            for (String line : lines) {
                stack.push(line);
            }
            while (!stack.empty()) {
                System.out.println(new StringBuilder(stack.pop()).reverse().toString());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
