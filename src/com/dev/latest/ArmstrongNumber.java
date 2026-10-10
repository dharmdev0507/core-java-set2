package com.dev.latest;

public class ArmstrongNumber {

    public static boolean isArmstrong(int number) {
        int original = number;
        int digits = String.valueOf(number).length();

        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number=number/10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        int num = 153;

        if (isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number");
        } else {
            System.out.println(num + " is not an Armstrong number");
        }
    }
}
