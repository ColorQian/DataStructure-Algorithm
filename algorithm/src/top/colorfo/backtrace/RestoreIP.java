package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 示例 5： 输入：s = "101023" 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class RestoreIP {

    List<String> result = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12) return result;
        
        backtracking(s,0,0);
        
        return result;
    }

    private void backtracking(String s, int startIndex, int pointNum) {

        if (pointNum == 3){  // 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            //如果s的[startIndex,i]是合法的整数子串
            if (isValid(s,startIndex,i)){
                s = s.substring(0,i+1) + "." + s.substring(i+1);
                pointNum++;

                backtracking(s,i+2,pointNum);  //递归

                s = s.substring(0,i+1) + s.substring(i+2);
                pointNum--;

            }else {
                break;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) return false;

        //如果以0开头，不合法
        if (s.charAt(start) == '0' && start != end) return false;

        int num = 0;
        for (int i = start;i <= end;i++){
            //判断每一个数字是否合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;

            //如果[start,end]范围内的整数大于255，不合法
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }

        return true;
    }

    //------------------

    public static void main(String[] args) {
        RestoreIP ip = new RestoreIP();
        List<String> strings = ip.restoreIpAddresses("101023");
        for (String s : strings){
            System.out.println(s);
        }
    }
}
