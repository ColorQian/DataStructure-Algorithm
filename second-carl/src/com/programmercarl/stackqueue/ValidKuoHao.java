package com.programmercarl.stackqueue;

import java.util.Stack;

public class ValidKuoHao {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {

            if (c == '(') {   //如果遇到左括号，就把右括号压栈
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.peek() != c) {  //若满足该条件，则说明括号不匹配
                return false;
            } else {       //如果当前的右括号匹配上，则将其弹出栈
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
