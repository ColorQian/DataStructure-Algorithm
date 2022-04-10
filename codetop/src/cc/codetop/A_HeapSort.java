package cc.codetop;


public class A_HeapSort {
    /**
     *
     * @param nums 传入的数组(可以看成完全二叉树)
     * @param n  数组大小，也是二叉树的节点个数
     * @param curIndex  cur 表示当前节点的下标
     */
    public void heapify(int[] nums, int n, int curIndex) {
        if (curIndex >= n) return; // 递归终止条件

        int c1 = 2 * curIndex + 1;  //当前节点的左孩子 的 下标
        int c2 = 2 * curIndex + 2;  //当前节点的右孩子 的 下标

        int max = curIndex;  // max 保存三者中最大值 对应的 下标
        if (c1 < n && nums[c1] > nums[max]) max = c1;
        if (c2 < n && nums[c2] > nums[max]) max = c2;

        // 如果左右孩子 比 当前节点大, 让左右孩子中的较大者充当父节点
        if (curIndex != max) {
            swap(nums, curIndex, max);
            heapify(nums, n, max);  // 因为max保存的是孩子节点的下标, 对父节点heapify之后(交换父子节点的值),
                                    // 孩子节点的堆特性可能会被破坏,所以需要孩子节点进行heapify
        }
    }

    // 将传入的一颗普通的完全二叉树 构造成 一个大顶堆
    public void buildTree(int[] nums, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    // 利用堆结构的完全二叉树, 对数组进行排序
    // 1.先让根节点和最后一个节点做交换
    // 2.然后删除最后一个节点, 接着 heapify 根节点 -> heapify(nums, n - 1, 0)
    public void heapSort(int[] nums, int n) {
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    //======================
    public static void main(String[] args) {
        A_HeapSort sort = new A_HeapSort();
        int[] nums = new int[]{3,2,1,5,6,4};
        sort.buildTree(nums, nums.length);
        sort.heapSort(nums, nums.length);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }
}
