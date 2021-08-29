package top.colorfor.stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens){

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) { // 遍历tokens数组

            if(tokens[i].equals("+")  || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){//如果是加减乘除字符

                //如果是操作符，直接弹出两个数字，准备进行运算
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (tokens[i].equals("+")){
                    stack.push(num1+num2);
                }else if (tokens[i].equals("-")){
                    stack.push(num2-num1);
                }else if (tokens[i].equals("*")){
                    stack.push(num1*num2);
                }else{
                    stack.push(num2 / num1);
                }

            }else{  //如果是数字的话，直接压入
                stack.push(stoi(tokens[i]));
            }
        }

        return stack.pop();
    }

    private Integer stoi(String token) { // 将String转为Integer

        return Integer.valueOf(token);
    }

    //--------------main-----------
    public static void main(String[] args) {

        EvaluateReversePolishNotation RPN = new EvaluateReversePolishNotation();

        /**
         * 该算式转化为常见的中缀算术表达式为：
         *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
         * = ((10 * (6 / (12 * -11))) + 17) + 5
         * = ((10 * (6 / -132)) + 17) + 5
         * = ((10 * 0) + 17) + 5
         * = (0 + 17) + 5
         * = 17 + 5
         * = 22
         */
        int i = RPN.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(i);

        //转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
        int i1 = RPN.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i1);
    }
}
