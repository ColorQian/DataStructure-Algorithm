package top.colorfor.array;

public class RemoveElement {

    /**暴力移除数组的元素
     *
     * @param arr 输入的数组
     * @param val 要移除的元素
     * @return 返回新的数组的长度
     */
    public int removeElement(int[] arr,int val){
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            //如果找到要删除的值,就利用一个for循环,将下标i后面的值统统后移
            if (arr[i] == val){
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                i--;  // 因为此时i后面的值后移了，i位置上是新的值，所以i要减去1
                      //这样下一次循环时(i++)，i上的值相当于原先i位置上的下一个
                size--;
            }
        }
        return size;
    }

    //--------main------------
    public static void main(String[] args) {
        RemoveElement remove = new RemoveElement();
        int[] arr = {1,2,3,4,6,6};
        int length = remove.removeElement(arr, 2);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }

    }
}
