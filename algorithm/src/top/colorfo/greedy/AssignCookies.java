package top.colorfo.greedy;

import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {

    /**
     *小饼干先喂饱小胃口
     * @param g 小孩的胃口
     * @param s 饼干的尺寸
     * @return 饼干能满足小孩的个数
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int result = 0;

        for (int i = 0; i < s.length; i++) {

            if (index < g.length && s[i] >= g[index]){ //如果满足了小孩的胃口
                result++;
                index++;  //看下一个小孩的胃口
            }
        }

        return result;
    }
}
