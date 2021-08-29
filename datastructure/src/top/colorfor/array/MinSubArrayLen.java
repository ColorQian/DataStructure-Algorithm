package top.colorfor.array;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {

    /** 暴力求解，利用两个for循环
     *
     * @param nums 输入的数组
     * @param s 要求子数组的和 >= s
     * @return 返回子数组的长度
     */
    public int minSubArrayLen(int[] nums,int s){
        int result = Integer.MAX_VALUE; // 要返回的子数组的长度
        int subLen = 0; // 子数组的长度，中间变量，用于比较各个子数组
        int sum = 0;   //用于计算子数组的和

        for (int i = 0; i < nums.length; i++) {  //遍历数组
            sum = 0;
            for (int j = i; j < nums.length ; j++) {  //j从i的位置往后累加
                sum += nums[j];
                if(sum >= s){
                    subLen = j-i+1;  //当累加结果sum大于等于s时，保留此时的子数组长度
                    result = subLen < result ? subLen : result;  //更新result的值
                    break;           //跳出循环，进行下一轮
                }
            }

        }

        return result == Integer.MAX_VALUE ? 0 : result; //如果result的值不变，
                                                         // 说明为找到符合条件的子数组，则返回0
    }

    /** 滑动窗口，也可以理解为双指针
     *
     * @param nums 输入的数组
     * @param s 要求子数组的和 >= s
     * @return 返回子数组的长度
     */
    public int minSubArrayLengthWindow(int[] nums,int s){
        int result = Integer.MAX_VALUE; // 要返回的子数组的长度
        int subLen = 0; // 子数组的长度，中间变量，用于比较各个子数组
        int sum = 0;   //用于计算子数组的和
        int i = 0;     //滑动窗口的起始位置
        for (int j = 0; j < nums.length; j++) {  //j表示滑动窗口的终止位置
            sum += nums[j];   //sum滑动窗口内保存的值

            //滑动窗口的精髓
            while(sum >= s){  //当滑动窗口内的值大于等于s时，滑动窗口的起始位置移动
                subLen = j-i+1;
                result = result < subLen ? result : subLen;  //更新result的值

                sum = sum - nums[i++];  //滑动窗口内的值减去nums[i],同时，滑动窗口的起始位置右移

            }

        }

        return result == Integer.MAX_VALUE ? 0 : result; //如果result的值不变，
                                                         // 说明为找到符合条件的子数组，则返回0
    }

    //--------------main---------------

    public static void main(String[] args) {
        MinSubArrayLen subArrayLen = new MinSubArrayLen();
        int[] nums = {2,3,1,2,4,3};
        int len = subArrayLen.minSubArrayLen(nums, 7);
        System.out.println(len);

        //===============

        int lengthWindow = subArrayLen.minSubArrayLengthWindow(nums, 7);
        System.out.println("滑动窗口的结果"+lengthWindow);

    }
}



