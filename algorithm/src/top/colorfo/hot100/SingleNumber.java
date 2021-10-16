package top.colorfo.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number/submissions/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num, count);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }
}
