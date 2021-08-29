package top.colorfor.stack;

//测试回文
public class TestPalindrome {

    public static void main(String[] args) throws Exception {

        System.out.println(detection("abcdedcba"));

    }

    public static boolean detection(String str) throws Exception {

        int length = str.length();
        
        ArrayForStack stack = new ArrayForStack(length);

        for (int i = 0; i < length; i++) {
            stack.push(str.charAt(i));
        }
        
        String newStr = "";
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty()){
                char s = (char)stack.pop();
                newStr += s;
            }
        }
        if (str.equals(newStr)){
            return true;
        }
        return false;
    }
}
