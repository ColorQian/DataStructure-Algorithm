package top.colorfor.stack;

/**
 * 时间复杂度为O(N^2),每个位置向右遍历一下即可
 */
public class DailyTemperature2 {

    public static int[] rightWay(int arr[]){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cur = i+1;
            int rightMoreIndex = 0;
            while (cur < arr.length){
                if (arr[cur] > arr[i]){
                    res[i] = cur - i;
                    break;
                }
                cur++;
            }
        }
        return res;
    }


    //写个main方法测试一下
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};

        int[] res = rightWay(arr);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
