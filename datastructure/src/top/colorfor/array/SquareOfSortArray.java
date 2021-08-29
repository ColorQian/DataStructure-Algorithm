package top.colorfor.array;

public class SquareOfSortArray {

    public int[] sortedSquare(int[] arr){
        int[] res = new int[arr.length];
        int k = arr.length-1;
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            if (arr[right]*arr[right] > arr[left]*arr[left]){
                res[k--] = arr[right]*arr[right];
                right--;
            }else {
                res[k--] = arr[left]*arr[left];
                left++;
            }
        }

        return res;
    }

    //--------main------

    public static void main(String[] args) {
        SquareOfSortArray sortArray = new SquareOfSortArray();
        int[] arr = {-4,-1,2,3,10};
        int[] square = sortArray.sortedSquare(arr);
        for (int i : square) {
            System.out.println(i);
        }
    }
}
