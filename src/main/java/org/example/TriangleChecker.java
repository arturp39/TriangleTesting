package org.example;

import java.util.Scanner;

public class TriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (isTriangle(a, b, c)) {
            String triangleType = getTriangleType(a, b, c);
            System.out.println("The sides form a " + triangleType + " triangle");
        } else {
            System.out.println("The given sides do not form a triangle");
        }
        scanner.close();
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static String getTriangleType(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}