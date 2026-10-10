package com.dev.string;

import java.util.Stack;

//Input: "3[a2[c]]"
//Output: "accaccacc"

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                System.out.println("num : "+num);
            }else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);

                num = 0;
                current = new StringBuilder();
            }else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        //String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
    }
}