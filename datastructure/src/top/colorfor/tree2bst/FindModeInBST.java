package top.colorfor.tree2bst;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class FindModeInBST {

    List<Integer> resCount;
    int count;  //用来计数
    int maxCount;  //出现的最大次数
    TreeNode pre;  //cur的前一个指针
    public int[] findMode(TreeNode root){
        resCount = new ArrayList<>();

        infix(root);
        int[] res = new int[resCount.size()];
        for (int i = 0; i < resCount.size(); i++) {
            res[i] = resCount.get(i);
        }

        return res;
    }

    //中序遍历
    private void infix(TreeNode cur) {
        if (cur == null) return;

        infix(cur.left);  //左

        if (pre == null){  //第一个节点
            count = 1;
        }else if (pre.val != cur.val){  //与前一个节点数值不同
            count = 1;
        }else{   //与前一个节点数值相同
            count++;
        }

        if (count == maxCount){ //如果和出现最多的频率相同
            resCount.add(cur.val);
        }

        if (count > maxCount){
            resCount.clear();  //将resCount清空
            maxCount = count;  //更新maxCount
            resCount.add(cur.val);  //将节点的值加进去
        }

        pre = cur;  //更新上一个指针

        infix(cur.right);  // 右
    }
}


