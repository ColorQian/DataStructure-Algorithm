package top.colorfor.queue;

import java.util.*;

public class TopKFrequent {

    public int[] topK(int[] nums,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){  //如果包含num
                map.put(num,map.get(num)+1); //将value的值+1
            }else {
                map.put(num,1);
            }
        }
        //上面循环结束，统计到了每个num出现的次数，key=num,value=frequency

        // 遍历map，用最小堆保存出现频率最大的前k个元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (priorityQueue.size() < k){
                priorityQueue.add(key);
            }else if (map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        int[] res = new int[k];
        int index = res.length-1;
        while (!priorityQueue.isEmpty()){
            res[index--] = priorityQueue.remove();
        }

        return res;
    }

    //-----------main---------
    public static void main(String[] args) {

        TopKFrequent topK = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        int[] res = topK.topK(nums,2);
        System.out.println(Arrays.toString(res));

    }
}
