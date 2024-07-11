/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author lcaohoanq
 */
public class NewClass {

    public static void main(String[] args) {

        System.out.println("Result: " + cal("even", 1, 6));

    }

    public static int cal(String options, int start, int end) {
        start = 1;
        int sum = 0;
        if (options.equals("odd")) {
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    sum += i;
                }
            }
        } else if (options.equals("even")) {
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public static int calV2(String options, int start, int end) {
        int sum = 0;

        // Adjust start value if needed
        if (start % 2 == 0 && options.equals("odd")) {
            start++;
        } else if (start % 2 != 0 && options.equals("even")) {
            start++;
        }

        // Iterate through the numbers from start to end based on options
        for (int i = start; i <= end; i++) {
            if (options.equals("odd") && i % 2 != 0) {
                sum += i;
            } else if (options.equals("even") && i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
