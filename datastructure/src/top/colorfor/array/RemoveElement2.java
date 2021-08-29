package top.colorfor.array;

public class RemoveElement2 {

    public int removeElement(int[] nums,int val){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        RemoveElement2 remove = new RemoveElement2();
        int[] arr = {0,1,2,3,3,0,4,2};
        int length = remove.removeElement(arr, 2);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }

    }
}
