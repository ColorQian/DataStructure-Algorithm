package top.colorfor.stack;

import java.util.Stack;

/**
 * 用栈实现括号的匹配
 *
 * Input:"()[]{}"
 *
 * Output : true
 */
public class ValidParentheses {

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s){

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                //当满足"左括号"的条件时，压入栈中
                stack.push(c);
            }else{

                //如果此时栈中还为空，则不满足条件
                if (stack.isEmpty()){
                    return false;
                }

                //走到这一步，说明栈中不为空，此时"c"，满足为括号的右半部分
                //此时弹栈拿出括号的坐半部分left
                char left = stack.pop();

                //一下三个条件说明，在弹栈得到的left时,括号右半部分匹配不上，就返回false;
                boolean b1 = left == '(' && c != ')';
                boolean b2 = left == '{' && c != '}';
                boolean b3 = left == '[' && c != ']';
                if (b1 || b2 || b3){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }


    //测试 *******************************
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));  //true
        System.out.println(vp.isValid("()[]{}"));  //true
        System.out.println(vp.isValid("{[]}"));  //true
        System.out.println(vp.isValid("(]"));   //false
        System.out.println(vp.isValid("([)]"));  //false

    }

}
