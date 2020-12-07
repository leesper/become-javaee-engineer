package com.javaee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EntryYear {
    public static void main(String[] args) {
        System.out.println("Please input your date of entry: ");
        Scanner sc = new Scanner(System.in);
        String dt = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Date entryDate = sdf.parse(dt);
            Date now = new Date();
            double interval = now.getTime() - entryDate.getTime();
            int year = (int) Math.floor(interval / 1000.0 / 60.0 / 60.0 / 24.0 / 365.0);
            System.out.printf("Year of work: %d\n", year);
        } catch (ParseException e) {
            System.out.println("Invalid date format, bye");
        }
    }
}
