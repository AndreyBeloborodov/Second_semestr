package AISD.domachka;

import java.util.Scanner;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/submissions/

public class Queue_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        System.out.println(stack.empty() ? "YES" : "NO");
    }
}
