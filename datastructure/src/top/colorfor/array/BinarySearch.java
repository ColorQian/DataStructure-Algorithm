package top.colorfor.array;

public class BinarySearch {

    //二分查找
    public int binarySearch(int[] nums,int target){
       //先判断要查找的值是否在数组的范围内
       if(target < nums[0] || target > nums[nums.length-1]){
           return -1;
       }

       int left = 0;
       int right = nums.length-1;

       while (left <= right){
           int middle = (left+right)/2;
           if (nums[middle] == target){
               return middle;
           }else if (target < nums[middle]){ //如果要查找的值在左边
                right = middle - 1;
           }else { //如果要查找的值在右边
               left = middle+1;
           }
       }

        return -1;
    }

    //----------main-------------

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {-1,0,3,5,9,12};
        int target = 4;
        int res = binarySearch.binarySearch(arr,target);
        System.out.println(res);
    }
}
