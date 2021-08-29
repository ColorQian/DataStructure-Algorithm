package top.colorfor.array;

public class SpiralMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n]; // 定义一个二维数组
        int startx = 0, starty = 0; // 定义每循环一个圈的起始位置
        int loop = n / 2; // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int mid = n / 2; // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int count = 1; // 用来给矩阵中每一个空格赋值
        int offset = 1; // 每一圈循环，需要控制每一条边遍历的长度
        int i,j;
        while ( loop > 0 ) {

            i = startx;
            j = starty;

            // 下面开始的四个for就是模拟转了一圈
            // 模拟填充上行从左到右(左闭右开)
            for (j = starty; j < starty + n - offset; j++) {
                res[i][j] = count++;
            }
            // 模拟填充右列从上到下(左闭右开)
            for (i = startx; i < startx + n - offset; i++) {
                res[i][j] = count++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (; j > starty; j--) {
                res[i][j] = count++;
            }
            // 模拟填充左列从下到上(左闭右开)
            for (; i > startx; i--) {
                res[i][j] = count++;
            }

            loop--;

            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startx++;
            starty++;

            // offset 控制每一圈里每一条边遍历的长度
            offset += 2;
        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }

    //自己写的
    public static int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];

        int startx = 0,starty = 0;  //定义每循环一个圈的起始位置
        int offset = 1;  //遍历每条边时的偏移量
        int loop = n/2;  //需要遍历几次，例如n=3,需要遍历一圈
        int i,j;  //用来表示二维矩阵的 行 和 列
        int count = 1;   //用来填充矩阵的每一个位置1到n^2

        int mid = n/2;

        while(loop > 0){

            i = startx;
            j = starty;
            //下面的四个for循环，分别遍历正方形的每一条边，按照左闭右开的原则

            // 模拟填充上行从左到右(左闭右开)
            for(j = starty;j < starty+n-offset;j++){
                res[i][j] = count++;
            }

            //模拟填充右列从上到下(左闭右开)
            for (i = startx;i<startx+n-offset;i++){
                res[i][j] = count++;
            }

            for(;j > starty;j--){
                res[i][j] = count++;
            }

            for(;i > startx;i--){
                res[i][j] = count++;
            }

            loop--;

            startx++;
            starty++;

            offset += 2;

        }

        if (n%2 == 1){
            res[mid][mid] = count;
        }

       return res;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+"\t");
            }
            System.out.println(" ");
        }

    }
}