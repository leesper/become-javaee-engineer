package com.javaee;

import java.util.ArrayList;
import java.util.Collection;

public class CollScore {
    public static void main(String[] args) {
        Collection<Double> scores = new ArrayList<Double>();
        scores.add(88.5);
        scores.add(39.2);
        scores.add(77.1);
        scores.add(56.8);
        scores.add(89.0);
        scores.add(99.0);
        scores.add(59.5);

        System.out.println("Scores: ");
        for (Double score : scores) {
            System.out.println(score);
        }

        System.out.println("Scores under 60: ");
        int count = 0;
        for (Double score : scores) {
            if (score < 60.0) {
                count++;
                System.out.println(score);
            }
        }

        int total = 0;
        double sum = 0;
        for (double score : scores) {
            total++;
            sum += score;
        }
        System.out.printf("Average: %.1f, Failed: %d\n", sum / total, count);

        double top = Double.MIN_VALUE;
        for (double score : scores) {
            if (top < score) {
                top = score;
            }
        }
        System.out.printf("Top Score: %.1f\n", top);

    }
}
