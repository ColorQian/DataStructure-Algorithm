package top.colorfo.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for (int num : nums) { // map的key:num , value:是否出现
            map.put(num, 1);
        }

        for (int i = 0; i < len; i++) { //找出没有出现过的元素，加入到list集合中
            if (!map.containsKey(i+1)) list.add(i+1);
        }

        return list;
    }
}
