package com.jianzhi.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * https://leetcode-cn.com/problems/FortPu/
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 */
public class Question30 {

    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;
    public Question30() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }

        // 插入元素
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }

        // 得到该元素的下标
        int location = numToLocation.get(val);

        // 将数组集合中的最后一个元素插入到该位置
        // 首先处理HashMap
        numToLocation.put(nums.get(nums.size() - 1), location);
        numToLocation.remove(val);
        // 接着处理数组集合
        nums.set(location, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int r = new Random().nextInt(nums.size());
        return nums.get(r);
    }
}
