package cc.codetop;

import java.util.LinkedHashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    int capacity;
    //cache 头部是久为使用的数据，尾部是最近常使用的数据
    // (想想链表这个数据结构是怎么组织的, remove时从前往后找, put时加在最后面)
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        //如果包含key
        int val = cache.get(key);
        makeRecently(key);  //更新为最近常使用
        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {  //如果包含key,更新value
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        cache.put(key, value);  //如果不包含，直接放入，然后判断容量有没有超出

        if (cache.size() > capacity) {  //容量超出范围
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
